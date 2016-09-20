package menuItem;

import java.util.*;

import misc.*;
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
	public void selected()
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
