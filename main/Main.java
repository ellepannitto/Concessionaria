package main;

import java.util.*;

import menu.*;
import misc.*;
import filters.*;
import filterCreators.*;
import callMe.*;
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
		
		
		List<CallMe> menu_principale = new ArrayList<CallMe>();
		
		menu_principale.add(new Add(c));
		menu_principale.add(new Remove(c));
		menu_principale.add(new Edit(c));
		menu_principale.add(new Show(c));
		menu_principale.add(new Save(c));
		menu_principale.add(new Load(c));
		menu_principale.add(new callMe.Exit());
		
		while (!esci)
			Menu.show_menu(menu_principale);
	}
	
	
}
