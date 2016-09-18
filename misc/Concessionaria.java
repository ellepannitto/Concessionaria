package misc;

import java.util.*;
import java.io.*;
import java.util.regex.*;
import java.lang.*;

import filters.*;
import exceptions.*;

/**
 * 
 * 
 * 
 * 
 * 
 * */

public class Concessionaria 
{
	private Vector<Auto> archivio = new Vector<Auto>();
	
	private Vector<Cliente> clienti_registrati;

	public Concessionaria ()
	{
		;
	}

	public Concessionaria (String filename)
	{
		try
		{
			load(filename);
		}
		catch (IOException e)
		{
			System.err.println("Impossibile caricare l'archivio - "+e);
			System.out.println("E' stata creata una nuova concessionaria");
			
		}
		
	}

	public void add_auto (Auto auto) throws AutoException
	{
		boolean non_presente = !archivio.contains(auto);
		
		if (non_presente)
			archivio.add(auto);
		else
			throw new AutoException ("Auto già presente nell'archivio");
			
	}
	
	public void remove_auto (Auto auto) throws AutoException
	{
		boolean presente = archivio.contains(auto);
		
		if (presente)
			archivio.remove (auto);
		else
			throw new AutoException ("Auto non presente nell'archivio");
			
	}
	
	public Auto[] list_autos (Comparator<Auto> o)
	{
		Auto[] sorted_list = archivio.toArray( new Auto[archivio.size()] );
		
		Arrays.sort(sorted_list, o);
		
		return sorted_list;
	}
	
	public Auto[] filter_autos (Filterer<Auto> o)
	{
		Vector<Auto> return_list = new Vector<Auto>();
		
		for (Auto a: archivio)
		{
			if ( o.filter(a) )
				return_list.add( a );
		}
		
		return return_list.toArray( new Auto[return_list.size()] );
	}
	
	public Auto[] filter_autos (Filterer<Auto> f, Comparator<Auto> c)
	{
		Vector<Auto> filtered_list = new Vector<Auto>();
		
		
		for (Auto a: archivio)
		{
			if ( f.filter(a) )
				filtered_list.add( a );
		}
		
		Auto[] sorted_list = filtered_list.toArray( new Auto[filtered_list.size()] );
		
		Arrays.sort(sorted_list, c);
		
		return sorted_list;
		
	}
	
	public static boolean check_future_date (GregorianCalendar data)
	{
		GregorianCalendar now = new GregorianCalendar();
		
		long diff = data.getTime().getTime() - now.getTime().getTime();

		return diff > 0;	
	}
	
	public static boolean check_targa (String targa)
	{
		Pattern t = Pattern.compile ("[A-z]{2}[0-9]{3}[A-z]{2}");
		
		Matcher m = t.matcher(targa);
		
		return m.matches();
		
		
	}
	
	public void setNewDeliveryDate (Auto a, GregorianCalendar data) throws AutoException, DateException
	{
		
		if ( !check_future_date(data) )
			throw new DateException ("La data inserita è antecedente alla data odierna");
		
		int presente = archivio.indexOf(a);
		
		Auto old = null;
		
		if (presente > -1)
		{
			old = archivio.get(presente);
			
			if (old instanceof AutoNuova)
			{
				((AutoNuova)old).setNewDate(data);
			}
			else
			{
				throw new AutoException ("L'Auto è di tipo Usata");
			}
		}
		else
		{
			throw new AutoException ("Auto non presente nell'archivio");
		}
	}
	
	public Auto getNextDelivery() throws AutoException
	{
		if (archivio.size() == 0) 
			throw new AutoException ("Nessuna auto presente nell'archivio");
		
		GregorianCalendar now = new GregorianCalendar();
		
		long min = -1;
		Auto next = null;
		
		for (Auto a : archivio)
		{
			if (a instanceof AutoNuova )
			{
				GregorianCalendar consegna = ((AutoNuova)a).getDeliveryDate();
				
				long diff = consegna.getTime().getTime() - now.getTime().getTime();
				
				if (diff >= 0)
				{
					if (min < 0)
					{
						min = diff;
						next = archivio.get( archivio.indexOf(a) );
					}
					else
					{
						if (diff < min)
						{
							min = diff;
							next = archivio.get( archivio.indexOf(a) );
						}
					}
				}
			}
		}
		
		if (min < 0)
			throw new AutoException ("Non ci sono prossime consegne");
		
		return next;
	}
	
	public void dump (String filename) throws IOException
	{
		try
		{
			FileOutputStream fout = new FileOutputStream(filename);
			ObjectOutputStream oout = new ObjectOutputStream(fout);
			oout.writeObject(archivio);
			oout.close();
		}
		catch (Exception e)
		{
			throw new IOException("Errore durante il salvataggio sul file "+filename);
		}
	}
	
	public void load (String filename) throws IOException
	{
		try
		{
			FileInputStream fin = new FileInputStream(filename);
			ObjectInputStream oin = new ObjectInputStream(fin);
			
			Object oread = oin.readObject();
			archivio = (Vector<Auto>)oread;
		}
		catch (Exception e)
		{
			throw new IOException("Errore durante il caricamento dal file "+filename);
		}
	}
	
}
