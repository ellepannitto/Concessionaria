package filterCreators;

import java.util.*;

import filters.*;
import callMe.*;
import misc.*;
import menu.*;

/**
 * 
 * Implementa l'interfaccia CallMe per creare una voce del menù che permette di interrompere l'inserimento dei filtri
 * 
 * */
public class Exit implements CallMe
{
	// lista di filtri scelti
	private List<Filterer<Auto>> l;
	
	// true se è stato scelto di uscire
	private boolean chiamato = false;
	
	/**
	 * 
	 * Inizializza un nuovo oggetto
	 * 
	 * @param l lista di filtri scelti
	 * 
	 * */
	public Exit (List<Filterer<Auto>> l)
	{
		this.l = l;
	}
	
	/**
	 * 
	 * Infomra l'oggetto che è stato chiamato
	 * 
	 * */
	public void call()
	{			
		chiamato = true;
		
	}
	
	/**
	 * 
	 * restituisce una descrizione per la voce del menù
	 * 
	 * */
	public String getDescrizione()
	{
		return "Ok, ho finito le scelte";
	}
	
	
	/**
	 * 
	 * @return true se è stato scelto di uscire
	 * @return false altrimenti
	 * 
	 * */
	public boolean got_called ()
	{
		return this.chiamato;
	}
}
