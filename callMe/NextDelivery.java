package callMe;

import java.util.*;

import misc.*;
import menu.*;
import exceptions.*;

/**
 * 
 * Implementazione dell'interfaccia CallMe che consente di creare una voce del menù per visualizzare la prossima auto da consegnare di una concessionaria
 * Se la voce è selezionata, mostra la prossima auto da consegnare, o un errore nel caso non ci siano 
 * 
 * */
public class NextDelivery implements CallMe
{
	// la concessionaria sulla quale operare
	private Concessionaria c;
	
	/**
	 * 
	 * inizializza un nuovo oggetto, data la concessionaria su cui operare 
	 * 
	 * @param c la concessionaria su cui operare
	 * 
	 * */
	public NextDelivery (Concessionaria c)
	{
		this.c = c;
	}
	
	/**
	 * 
	 * mostra la prossima auto nuova da consegnare
	 * 
	 * 
	 * */
	public void call()
	{
		
		try
		{
			Auto a = c.getNextDelivery();
			System.out.println(a);
		}
		catch (AutoException e)
		{
			System.err.println("Impossibile mostrare la prossima consegna - "+e);
		}
			
	}
	
	public String getDescrizione ()
	{
		return "Mostra prossima auto da consegnare";
	}
}
