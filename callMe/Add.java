package callMe;

import misc.*;
import menu.*;
import exceptions.*;

/**
 * 
 * Implementazione dell'interfaccia CallMe che consente di creare una voce del menù Aggiungere un auto ad una concessionaria
 * Se la voce è selezionata vengono chiesti all'utente i dati di un'automobile, che viene aggiunta allla concessionaria
 * 
 * */
public class Add implements CallMe
{
	// concessionaria su cui operare
	private Concessionaria c;
	
	/**
	 * 
	 * Inizializza un nuovo oggetto, data la concessionaria su cui operare
	 * 
	 * @param c la concessionaria su cui operare
	 * 
	 * */
	public Add (Concessionaria c)
	{
		this.c = c;
	}
	
	/**
	 * 
	 * Chiede in input all'utente i dati di un'auto A, poi aggiunge A alla concessionaria
	 * 
	 * */
	public void call()
	{
		Auto a = Menu.get_auto();

		try
		{
			c.add_auto(a);
		}
		catch (AutoException e)
		{
			System.err.println("Impossibile aggiungere auto - "+e);
		}
		
	}
	
	/**
	 * 
	 * restituisce una descrizione per la voce del menù
	 * 
	 * */
	public String getDescrizione ()
	{
		return "Aggiungi";
	}
}
