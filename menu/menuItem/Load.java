package menu.menuItem;

import java.util.*;
import java.io.*;

import concessionaria.*;
import menu.*;
import filters.*;
import menu.menuItem.filterCreators.*;

/**
 * 
 * Implementazione dell'interfaccia MenuItem che consente di creare una voce del menù per caricare una concessionaria da un file
 * 
 * */
public class Load implements MenuItem
{
	//concessionaria su cui operare
	private Concessionaria c;
	
	/**
	 * 
	 * Inizializza un nuovo oggetto, data la concessionaria su cui operare
	 * 
	 * @param c la concessionaria su cui operare
	 * 
	 * */
	public Load (Concessionaria c)
	{
		this.c = c;
	}
	
	/**
	 * 
	 * Se invocata chiede all'utente in input il nome di un file F, poi carica la concessionaria dal file F
	 * 
	 * */
	public void selected(Menu m)
	{
		String filename = m.get_string ("Inserisci nome del file");
		
		try
		{
			c.load(filename);
			m.show ("Archivio caricato correttamente. Ci sono "+c.size()+" auto nell'archivio.");
		}
		catch (IOException e)
		{
			m.show_error("Impossibile caricare la concessionaria", e);
		}
		
		m.wait_input();
		
	}
	
	/**
	 * restituisce una descrizione della funzione chiamata.
	 *  
	 * */
	public String getDescrizione ()
	{
		return "Carica l'archivio da un file";
	}
	
}
