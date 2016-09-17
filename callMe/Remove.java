package callMe;

import misc.*;
import menu.*;

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

		boolean success = c.remove_auto(a);
		
		if (!success)
			Menu.show_error("Auto non presente");
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
