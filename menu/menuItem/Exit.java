package menu.menuItem;

import java.util.*;

import concessionaria.*;
import menu.*;
import main.*;

/**
 * 
 * Implementazione dell'interfaccia MenuItem che consente di creare una voce del menù uscire dal programma
 * 
 * */
public class Exit implements MenuItem
{
	
	/**
	 * 
	 * se invocata, comunica al programma che deve terminare
	 * 
	 * */
	public void selected(Menu m)
	{
		Main.esci = true;
	}
	
	/**
	 * 
	 * restituisce una descrizione per la voce del menù
	 * 
	 * */
	public String getDescrizione ()
	{
		return "Esci";
	}
}
