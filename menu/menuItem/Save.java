package menu.menuItem;

import java.util.*;
import java.io.*;

import concessionaria.*;
import menu.*;
import filters.*;
import menu.menuItem.filterCreators.*;

/**
 * 
 * Implementazione dell'interfaccia MenuItem che consente di salvare il contenuto di una concessionaria su un file.
 * 
 * */
public class Save implements MenuItem
{
	// la concessionaria su cui lavorare
	private Concessionaria c;
	
	/**
	 * 
	 * Inizializza un nuovo oggetto, data la concessionaria su cui lavorare
	 * 
	 * @param c la concessionaria su cui lavorare
	 * 
	 * */
	public Save (Concessionaria c)
	{
		this.c = c;
	}
	
	/**
	 * 
	 * Chiede all'utente in input il nome di un file F, poi salva l'archivio dellla concessionaria sul file F.
	 * 
	 * */
	public void selected(Menu m)
	{
		String filename = m.get_string ("Inserisci nome del file");
		
		
		try
		{
			c.dump(filename);
			m.show("Archivio salvato su file: "+filename);
		}
		catch (IOException e)
		{
			m.show_error("Impossibile salvare l'archivio su file", e);
		}
		
		m.wait_input();
		
	}
	
	/**
	 * 
	 * restituisce la descrizione per questa voce del menù
	 * 
	 * */
	public String getDescrizione ()
	{
		return "Salva l'archivio su un file";
	}
	
}
