package callMe;

import java.util.*;

import misc.*;
import menu.*;
import main.*;

/**
 * 
 * Implementazione dell'interfaccia CallMe che consente di creare una voce del menù uscire dal programma
 * 
 * */
public class Exit implements CallMe
{
	
	/**
	 * 
	 * se invocata, comunica al programma che deve terminare
	 * 
	 * */
	public void call()
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
