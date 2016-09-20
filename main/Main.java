package main;

import java.util.*;

import menu.*;
import misc.*;
import filters.*;
import filterCreators.*;
import menuItem.*;
import compare.*;

public class Main
{
	public static boolean esci = false;
	
	public static void main (String[] args)
	{
		Concessionaria c = new Concessionaria();
		
		if (args.length > 0)
		{
			c = new Concessionaria(args[0]);
		}
		
		Menu menu = new Menu();
		
		
		List<MenuItem> menu_principale = new ArrayList<MenuItem>();
		
		menu_principale.add(new Add(c));
		menu_principale.add(new Remove(c));
		menu_principale.add(new Edit(c));
		menu_principale.add(new Show(c));
		menu_principale.add(new NextDelivery(c));
		menu_principale.add(new Save(c));
		menu_principale.add(new Load(c));
		menu_principale.add(new menuItem.Exit());
		
		while (!esci)
			Menu.show_menu(menu_principale, "Azioni possibili");
	}
	
	
}
