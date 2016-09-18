package callMe;

import misc.*;
import menu.*;
import exceptions.*;

/**
 * 
 * Implementa un'interfaccia CallMe.
 * Se chiamato carica una rimuove un auto dalla concessionaria.
 * 
 * */
public class Remove implements CallMe
{
	private Concessionaria c;
	
	public Remove (Concessionaria c)
	{
		this.c = c;
	}
	
	/**
	 * rimuove un auto dalla concessionaria
	 * */
	public void call()
	{
		String targa = Menu.get_string ("Inserisci la targa dell'auto da rimuovere");
		Auto a = new Auto ( targa, null, 0, null, 0 );

		try
		{
			c.remove_auto(a);
		}
		catch (AutoException e)
		{
			System.err.println ("Impossibile rimuovere auto dall'archivio - "+e);
		}

	}
	
	/**
	 * restituisce una descrizione della funzione chiamata.
	 *  
	 * */
	public String getDescrizione ()
	{
		return "Rimuovi";
	}
}
