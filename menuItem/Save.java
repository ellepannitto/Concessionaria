package menuItem;

import java.util.*;
import java.io.*;

import misc.*;
import menu.*;
import filters.*;
import filterCreators.*;

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
	public void selected()
	{
		String filename = Menu.get_string ("Inserisci nome del file");
		
		
		try
		{
			c.dump(filename);
		}
		catch (IOException e)
		{
			System.err.println("Impossibile salvare l'archivio su file - "+e);
		}
		
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
