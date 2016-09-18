package misc;

import java.util.*;
import java.io.*;

import filters.*;

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
		load(filename);
	}

	public boolean add_auto (Auto auto)
	{
		boolean non_presente = !archivio.contains(auto);
		
		if (non_presente)
			archivio.add(auto);
			
		return non_presente;
	}
	
	public boolean remove_auto (Auto auto)
	{
		boolean presente = archivio.contains(auto);
		
		if (presente)
			archivio.remove (auto);
			
		return presente;
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
	
	public Auto[] filter_and_list_autos (Filterer<Auto> f, Comparator<Auto> c)
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
	
	public boolean setNewDeliveryDate (Auto a, GregorianCalendar data)
	{
		int presente = archivio.indexOf(a);
		
		Auto old = null;
		
		if (presente > -1)
		{
			old = archivio.get(presente);
			
			if (old instanceof AutoNuova)
			{
				((AutoNuova)old).setNewGregorianCalendar(data);
			}
		}
			
		return presente > -1 && old instanceof AutoNuova;
	}
	
	public Auto getNextDelivery()
	{
		GregorianCalendar now = new GregorianCalendar();
		
		long min = -1;
		Auto next = null;
		
		for (Auto a : archivio)
		{
			if (a instanceof AutoNuova )
			{
				GregorianCalendar consegna = ((AutoNuova)a).getDeliveryDate();
				
				long diff = consegna.getTime().getTime() - now.getTime().getTime();
				
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
		
		return next;
	}
	
	public void dump (String filename)
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
			;
		}
	}
	
	public void load (String filename)
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
			System.err.println("Errore durante il caricamento dal file");
			e.printStackTrace();
		}
	}
	
}
