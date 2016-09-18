package menu;

import java.util.*;
import java.text.DecimalFormatSymbols;

import misc.*;
import callMe.*;
import filters.*;

public class Menu
{
	private static Scanner s = new Scanner(System.in);
	
	private static void clear_input_buffer ()
	{
		if ( s.hasNextLine () )
			s.nextLine ();
	}
	
	public static void show_menu(List<CallMe> options, String intestazione)
	{
		System.out.println (intestazione);
		
		for (int i=0; i<options.size(); i++)
		{
			System.out.println ("["+(i+1)+"] "+options.get(i).getDescrizione());
		}
		
		System.out.println ("Inserisci la tua scelta:");
		String scelta = s.nextLine();
		
		try
		{
			int n = Integer.parseInt(scelta);
			
			CallMe selected = options.get(n-1);
			
			selected.call();
				
		}
		catch(Exception e)
		{
			;
		}
		
	}
	
	
	public static Auto get_auto ()
	{
		Auto ret;
		
		int x = get_int("1 per nuova, 0 per usata");
		
		String targa = get_string("inserisci targa");
		String modello = get_string("inserisci modello");
		String colore = get_string("inserisci colore");
		
		int cilindrata = get_int("inserisci cilindrata");
		float prezzo = get_float("inserisci prezzo");
		
		
		
		if (x==0)
		{
			int anno = get_int("inserisci anno di immatricolazione");
			int chilometri = get_int("inserisci chilometri percorsi");
			
			ret = new AutoUsata(targa, modello, cilindrata, colore, prezzo, anno, chilometri);
			
		}
		else
		{
			Cliente c = get_cliente();
			GregorianCalendar data_di_consegna = get_data("Inserisci la data nel formato ggmmaaaa");
			
			ret = new AutoNuova(targa, modello, cilindrata, colore, prezzo, data_di_consegna, c);
		}
		
		return ret;
	}
	
	public static String get_string(String message)
	{
		System.out.println(message);
		
		String ret = s.next();
		clear_input_buffer ();
		
		return ret;
	}
	
	public static GregorianCalendar get_data(String message)
	{
		GregorianCalendar d = new GregorianCalendar();
		
		try
		{
			int giorno = get_int("Inserisci giorno");
			int mese = get_int("Inserisci mese") - 1;
			int anno = get_int("Inserisci anno");
			
			d = new GregorianCalendar(anno, mese, giorno);
			
		}
		catch (Exception e)
		{
			;
		}
		return d;
	}

	public static Cliente get_cliente()
	{
		String nome = get_string("inserisci nome cliente");
		String cognome = get_string("inserisci cognome cliente");
		String cf = get_string("inserisci codice fiscale cliente");

		Cliente c = new Cliente(nome, cognome, cf);

		return c;
	}
	
	public static void show_error (String error)
	{
		System.out.println(error);
	}
	
	public static String get_pattern(String message)
	{
		System.out.println(message);
		
		String ret = s.next();
		clear_input_buffer ();
		
		return ret;
	}

	public static int get_int(String message)
	{
		System.out.println(message);
		
		int x = 0;
		
		try
		{
			x = s.nextInt();
		}
		catch(Exception e)
		{
			;
		}
		
		clear_input_buffer ();
		return x;
	}

	public static float get_float(String message)
	{
		DecimalFormatSymbols dfs = new DecimalFormatSymbols ();
		System.out.println(message);
		
		System.out.println("Separatore dei decimali: "+dfs.getDecimalSeparator());
		float x = 0;
		
		try
		{
			x = s.nextFloat();
		}
		catch(Exception e)
		{
			;
		}
		
		clear_input_buffer ();
		return x;
	}
	

	
}
