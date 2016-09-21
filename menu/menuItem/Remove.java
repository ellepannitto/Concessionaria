package menu.menuItem;

import concessionaria.*;
import menu.*;
import exceptions.*;

/**
 * 
 * Implementa un'interfaccia MenuItem.
 * Se chiamato carica una rimuove un auto dalla concessionaria.
 * 
 * */
public class Remove implements MenuItem
{
	// la concessionaria su cui operare
	private Concessionaria c;
	
	/**
	 * 
	 * Inizializza un nuovo oggetto, data la concessionaria su cui operare
	 * 
	 * */
	public Remove (Concessionaria c)
	{
		this.c = c;
	}
	
	/**
	 * rimuove un auto dalla concessionaria
	 * */
	public void selected(Menu m)
	{
		String targa = m.get_string ("Inserisci la targa dell'auto da rimuovere");
		Auto a = new Auto ( targa, null, 0, null, 0 );

		try
		{
			c.remove_auto(a);
		}
		catch (AutoException e)
		{
			m.show_error("Impossibile rimuovere auto dall'archivio", e);
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
