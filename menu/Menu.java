package menu;

import java.util.*;

import misc.*;
import callMe.*;
import filters.*;

public class Menu
{
	private static Scanner s = new Scanner(System.in);
	
	public Menu()
	{
		Concessionaria c = new Concessionaria();
		
		List<CallMe> menu_principale = new ArrayList<CallMe>();
		
		menu_principale.add(new Add(c));
		menu_principale.add(new Remove(c));
		menu_principale.add(new Edit(c));
		//~ menu_principale.add("Visualizza");
		//~ menu_principale.add("Modifica");
		//~ menu_principale.add("Carica");
		//~ menu_principale.add("Salva");
		
		while (true)
		
			show_menu(menu_principale);
		
		
	}
	
	public static void show_menu(List<CallMe> options)
	{
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
	
	public static void main (String[] args)
	{
		Menu m = new Menu();
	}
	
	public static Auto get_auto ()
	{
		Auto a = new Auto("","",0,"",0);
		return a;
	}
	
	public static String get_targa()
	{
		return "AA000AA";
	}
	
	public static Date get_data()
	{
		Date d = new Date();
		return d;
	}
	
	public static void show_error (String error)
	{
		System.out.println(error);
	}
	
	public static String get_pattern()
	{
		return "bbb";
	}
	
}
