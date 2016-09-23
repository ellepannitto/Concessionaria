package menu;

import java.util.*;
import java.text.DecimalFormatSymbols;

import concessionaria.*;
import menu.menuItem.*;
import filters.*;

public class Menu implements MenuInterface
{
	private static Scanner s = new Scanner(System.in);
	
	private static void clear_input_buffer ()
	{
		if ( s.hasNextLine () )
			s.nextLine ();
	}
	
	private static void flush_console()
	{
		//Per pulire la console su Linux
		System.out.println("\033[H\033[2J");
		System.out.flush();
	}
	
	public void show_menu(List<MenuItem> options, String intestazione)
	{
		boolean corretto = false;
		
		flush_console();
		
		while (!corretto)
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
				
				MenuItem selected = options.get(n-1);
				
				selected.selected(this);
				
				corretto = true;	
			}
			catch(Exception e)
			{
				System.err.println("Scelta non valida");
			}
		}
	}
	
	
	public Auto get_auto (Concessionaria concessionaria)
	{
		Auto ret;
		
		int x = get_int("Digita 1 per inserire un'auto nuova, 0 per una usata");
		
		
		String targa = get_string("Inserisci targa");
		
		
		while (!Concessionaria.check_targa(targa) || concessionaria.check_in(targa))
		{		
			targa = get_string("Formato targa non valido o auto già presente, inserisci di nuovo");
		}			
							
		
		String modello = get_string("inserisci modello");
		String colore = get_string("inserisci colore");
		
		int cilindrata = get_int("inserisci cilindrata");
		
		float prezzo = get_float("inserisci prezzo");
		
		while (!Concessionaria.check_prezzo(prezzo))
		{
			prezzo = get_float ("Il prezzo inserito non è valido, inserisci di nuovo");
		}
		
		
		if (x==0)
		{
			int anno = get_int("inserisci anno di immatricolazione");
			
			while(!Concessionaria.check_anno_immatricolazione(anno))
			{
				anno = get_int ("L'anno inserito non è valido come anno di immatricolazione, inserisci di nuovo");
			}
			
			int chilometri = get_int("inserisci chilometri percorsi");
			
			ret = new AutoUsata(targa, modello, cilindrata, colore, prezzo, anno, chilometri);
			
		}
		else
		{
			Cliente c = get_cliente();
			
			GregorianCalendar data_di_consegna = get_data("Inserisci la data di consegna");
			
			while ( !Concessionaria.check_future_date (data_di_consegna) )
				data_di_consegna = get_data ("Data non valida, inserisci nuova data");
			
			ret = new AutoNuova(targa, modello, cilindrata, colore, prezzo, data_di_consegna, c);
		}
		
		return ret;
	}
	
	public String get_string(String message)
	{
		System.out.println(message);
		
		String ret = s.nextLine();
		//~ clear_input_buffer ();
		
		return ret;
	}
	
	public GregorianCalendar get_data(String message)
	{
		System.out.println(message);
		
		GregorianCalendar d = new GregorianCalendar();
		d.setLenient(false);

		boolean corretto = false;

		while (!corretto)
		{
			try
			{
				int giorno = get_int("Inserisci giorno");
				int mese = get_int("Inserisci mese") - 1;
				int anno = get_int("Inserisci anno");
				
				d.set(anno, mese, giorno, 0, 0, 0);
				d.getTime ();
				corretto = true;
			}
			catch (Exception e)
			{
				System.err.println("Formato data non valido");
			}
		}

		return d;
	}

	public Cliente get_cliente()
	{
		String nome = get_string("inserisci nome cliente");
		String cognome = get_string("inserisci cognome cliente");
		Cliente c = new Cliente(nome, cognome);

		return c;
	}
	
	public void show_error (String error, Exception e)
	{
		System.err.println(error+"-"+e);
	}
	
	public String get_pattern(String message)
	{
		System.out.println(message);
		
		String ret = s.next();
		clear_input_buffer ();
		
		return ret;
	}

	public int get_int(String message)
	{
		boolean corretto = false;
		int x = 0;
		
		System.out.println(message);
		
		while (!corretto)
		{
			try
			{
				x = s.nextInt();
				
				corretto = true;
			}
			catch(Exception e)
			{
				System.out.println ("Il valore inserito non è numerico, inserisci nuovo valore");
			}
			clear_input_buffer ();
		}
		
		return x;
	}

	public float get_float(String message)
	{
		DecimalFormatSymbols dfs = new DecimalFormatSymbols ();
		System.out.println(message + " ( Separatore dei decimali: "+dfs.getDecimalSeparator()+" )");
		
		boolean corretto = false;
		float x = 0;
		
		while (!corretto)
		{
			try
			{
				x = s.nextFloat();
				corretto = true;
			}
			catch(Exception e)
			{
				System.out.println ("Il valore inserito non è corretto, inserisci di nuovo.");
			}
			clear_input_buffer ();
		}
		
		return x;
	}
	
	public void show (String s)
	{
		System.out.println(s);
	}
	
	public void wait_input ()
	{
		System.out.println("\npremi ENTER per continuare");
		try
		{
			System.in.read();
		}catch(Exception e){
			;
		}
	}

	
}
