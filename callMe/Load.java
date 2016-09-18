package callMe;

import java.util.*;
import java.io.*;

import misc.*;
import menu.*;
import filters.*;
import filterCreators.*;

/**
 * 
 * Implementa un'interfaccia CallMe.
 * Se chiamato carica una concessionaria da file.
 * 
 * */
public class Load implements CallMe
{
	private Concessionaria c;
	
	public Load (Concessionaria c)
	{
		this.c = c;
	}
	
	/**
	 * Carica una concessionaria da file
	 * */
	public void call()
	{
		String filename = Menu.get_string ("Inserisci nome del file");
		
		try
		{
			c.load(filename);
		}
		catch (IOException e)
		{
			System.err.println ("Impossibile caricare la concessionaria - "+e);
		}
		
		
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
