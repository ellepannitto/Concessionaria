package concessionaria;

import java.util.*;
import java.io.*;
import java.util.regex.*;
import java.lang.*;

import filters.*;
import exceptions.*;
import menu.*;

/**
 * 
 * Mantiene un archivio di Auto. 
 * E' possibile aggiungere un'auto, rimuoverla, modificarne i dati relativi.
 * Inoltre è possibile ottenere una lista delle auto presenti che rispetti determinati criteri specificati da un filtro, e ordinata secondo una funzione di ordinamento specificata.
 * 
 * */
public class Concessionaria 
{
	private Vector<Auto> archivio = new Vector<Auto>();
	private Menu m;
	
	//~ private Vector<Cliente> clienti_registrati;

	/**
	 * Inizializza una concessionaria vuota.
	 * */
	public Concessionaria ()
	{
		;
	}

	public Concessionaria (Menu m)
	{
		this.m = m;
	}

	/**
	 * Inizializza una concessionaria a partire da un file
	 * */
	public Concessionaria (Menu m, String filename)
	{
		this(m);
		
		try
		{
			load(filename);
		}
		catch (IOException e)
		{
			this.m.show_error("Impossibile caricare l'archivio", e);
			this.m.show ("E' stata creata una nuova concessionaria (vuota)");
			this.m.wait_input();
		}
	}


	/**
	 * Aggiunge un'auto all'archivio.
	 * 
	 * @param auto auto da aggiungere
	 * 
	 * @throws AutoException se l'auto è già presente
	 * */
	public void add_auto (Auto auto) throws AutoException
	{
		boolean non_presente = !archivio.contains(auto);
		
		if (non_presente)
			archivio.add(auto);
		else
			throw new AutoException ("Auto già presente nell'archivio");
			
	}
	
	/**
	 * Rimuove un'auto dall'archivio.
	 * 
	 * @param auto auto da rimuovere
	 * 
	 * @throws AutoException se l'auto non è presente
	 * */
	public void remove_auto (Auto auto) throws AutoException
	{
		boolean presente = archivio.contains(auto);
		
		if (presente)
			archivio.remove (auto);
		else
			throw new AutoException ("Auto non presente nell'archivio");
			
	}
	
	/**
	 * 
	 * Fornisce la lista di auto presenti nell'archivio, ordinate secondo una funzione di ordinamento.
	 * 
	 * @param o funzione di ordinamento
	 * 
	 * @return lista di auto ordinate
	 * 
	 * */
	public Auto[] list_autos (Comparator<Auto> o)
	{
		Auto[] sorted_list = archivio.toArray( new Auto[archivio.size()] );
		
		Arrays.sort(sorted_list, o);
		
		return sorted_list;
	}
	
	/**
	 * 
	 * Fornisce la lista di auto presenti nell'archivio.
	 * 
	 * 
	 * @return lista di auto
	 * 
	 * */
	public Auto[] list_autos ()
	{
		Auto[] list = archivio.toArray( new Auto[archivio.size()] );
		
		return list;
	}

	/**
	 * 
	 * Fornisce una lista di auto che rispettano un filtro.
	 * 
	 * @param o funzione di filtro
	 * 
	 * @return lista di auto che rispettano il criterio specificato
	 * 
	 * */	
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
	
	/**
	 * 
	 * Fornisce una lista ordinata di auto che rispettano un filtro.
	 * 
	 * @param f funzione di filtro
	 * @param c funzione di ordinamento
	 * 
	 * @return lista ordinata di auto che rispettano il criterio specificato
	 * 
	 * */
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
	
	
	/**
	 * Controlla che una data sia successiva alla data corrente.
	 * 
	 * @param data data da controllare
	 * 
	 * @return true se la data è successiva alla data corrente, false altrimenti.
	 * */
	public static boolean check_future_date (GregorianCalendar data)
	{
		GregorianCalendar now = new GregorianCalendar();
		
		long diff = data.getTime().getTime() - now.getTime().getTime();

		return diff > 0;	
	}
	
	/**
	 * Controlla che il numero sia valido come anno di immatricolazione.
	 * 
	 * @param anno intero da controllare
	 * 
	 * @return true se l'intero è compreso tra 1900 e l'anno corrente
	 * @return false altrimenti
	 * */
	public static boolean check_anno_immatricolazione (int anno)
	{
		GregorianCalendar now = new GregorianCalendar();
		
		int y = now.get(Calendar.YEAR);
		
		return anno < y+1 && anno > 1900;	
	}
	
	/**
	 * Controlla che il numero sia valido come prezzo
	 * 
	 * @param p prezzo (float)
	 * 
	 * @return true se p>=0.01
	 * */
	public static boolean check_prezzo (float p)
	{
		return p >= 0.01 ;	
	}
	
	
	/**
	 * Controlla che una targa corrisponda ad un'auto presente nell'archivio.
	 * 
	 * @param s stringa che rappresenta una targa
	 * 
	 * @return true se c'è nell'archivio un'auto con s come targa
	 * @return false altrimenti
	 * */
	public boolean check_in (String s)
	{
		
		Auto a = new Auto(s, null, 0, null, 0);		
		return archivio.contains(a);
		
	}
	
	
	/**
	 * Controlla che una targa sia nel formato corretto (CCdddCC)
	 * 
	 * @param targa targa da controllare
	 * 
	 * @return true se la targa rispetta il formato, false altrimenti
	 * 
	 * */
	public static boolean check_targa (String targa)
	{
		Pattern t = Pattern.compile ("[A-z]{2}[0-9]{3}[A-z]{2}");
		
		Matcher m = t.matcher(targa);
		
		return m.matches();
	}
	
	/**
	 * 
	 * @return il numero di auto presenti nell'archivio
	 * 
	 * 
	 * */
	public int size ()
	{
		return archivio.size ();
	}
	
	/**
	 * Modifica la data di consegna di un'auto nuova.
	 * 
	 * @param a auto da modificare
	 * @param data nuova data
	 * 
	 * @throws AutoException se l'auto non è presente nell'archivio o non è di tipo nuova.
	 * @throws DateException se la data non è successiva alla data corrente
	 * 
	 * */
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
	
	/**
	 * Modifica il colore di un'auto.
	 * 
	 * @param a auto da modificare
	 * @param col nuovo colore
	 * 
	 * @throws AutoException se l'auto non è presente nell'archivio.
	 * 
	 * */
	public void setNewColor (Auto a, String col) throws AutoException
	{
		
		int presente = archivio.indexOf(a);
		
		Auto old = null;
		
		if (presente > -1)
		{
			old = archivio.get(presente);
			
			old.setColor (col);
			
		}
		else
		{
			throw new AutoException ("Auto non presente nell'archivio");
		}
	}
	
	/**
	 * Modifica il colore di un'auto.
	 * 
	 * @param a auto da modificare
	 * @param p nuovo prezzo
	 * 
	 * @throws AutoException se l'auto non è presente nell'archivio.
	 * 
	 * */
	public void setNewPrice (Auto a, float p) throws AutoException
	{
		
		int presente = archivio.indexOf(a);
		
		Auto old = null;
		
		if (presente > -1)
		{
			old = archivio.get(presente);
			
			old.setPrezzo (p);
			
		}
		else
		{
			throw new AutoException ("Auto non presente nell'archivio");
		}
	}
	
	
	/**
	 * Restituisce la prossima auto da consegnare
	 * 
	 * @return prossima auto da consegnare
	 * 
	 * @throws AutoException nel caso in cui non ci siano prossime consegne
	 * 
	 * */
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
	
	/**
	 * Serializza l'archivio su un file
	 * 
	 * @param filename nome del file su cui scrivere
	 * 
	 * @throws IOException nel caso di problemi in fase di scrittura
	 * 
	 * */
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
	
	
	/**
	 * Carica l'archivio da un file
	 * 
	 * @param filename nome del file da cui caricare l'archivio
	 * 
	 * @throws IOException nel caso di problemi in fase di lettura
	 * 
	 * */
	public void load (String filename) throws IOException
	{
		try
		{
			FileInputStream fin = new FileInputStream(filename);
			ObjectInputStream oin = new ObjectInputStream(fin);
			
			Object oread = oin.readObject();
			
			//~ @SuppressWarnings("unchecked")
			//~ @SuppressWarnings
			archivio = (Vector<Auto>)oread;
		}
		catch (Exception e)
		{
			throw new IOException("Errore durante il caricamento dal file "+filename);
		}
	}
	
	
}
