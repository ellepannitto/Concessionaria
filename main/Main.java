package main;

import java.util.*;

import menu.*;
import concessionaria.*;
import filters.*;
import menu.menuItem.filterCreators.*;
import menu.menuItem.*;
import compare.*;

/**
 * Classe principale che avvia il programma
 * */
public class Main
{
	public static boolean esci = false;
	
	public static void main (String[] args)
	{		
		Menu menu = new Menu();
		
		Concessionaria c = new Concessionaria(menu);
		
		if (args.length > 0)
		{
			c = new Concessionaria(menu, args[0]);
		}
		
		List<MenuItem> menu_principale = new ArrayList<MenuItem>();
		
		menu_principale.add(new Add(c));
		menu_principale.add(new Remove(c));
		menu_principale.add(new Edit(c));
		menu_principale.add(new Show(c));
		menu_principale.add(new NextDelivery(c));
		menu_principale.add(new Save(c));
		menu_principale.add(new Load(c));
		menu_principale.add(new menu.menuItem.Exit());
		
		while (!esci)
			menu.show_menu(menu_principale, "**CONCESSIONARIA**\nAzioni possibili");
	}
}
