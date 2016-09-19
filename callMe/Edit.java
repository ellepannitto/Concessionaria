package callMe;

import java.util.*;

import misc.*;
import menu.*;
import exceptions.*;

/**
 * 
 * Implementazione dell'interfaccia CallMe che consente di creare una voce del menù per modificare la data di consegna di un'automobile
 * Se la voce è selezionata viene chiesta in input la targa di un'automobile T e una nuova data di consegna, che viene settata per l'automobile con targa T
 * 
 * */
public class Edit implements CallMe
{
	//concessionaria sulla quale operare
	private Concessionaria c;
	
	/**
	 * 
	 * Inizializza un nuovo oggetto, data la concessionaria sulla quale operare
	 * 
	 * @param c la concessionaria sulla quale operare
	 * 
	 * */
	public Edit (Concessionaria c)
	{
		this.c = c;
	}
	
	/**
	 * 
	 * Chiede in input all'utente una targa T e una nuova data di consegna D. Poi setta D come nuova data di consegna all'automobile con targa T
	 * 
	 * 
	 * */
	public void call()
	{
		String t = Menu.get_string("targa");
		
		GregorianCalendar d = Menu.get_data("data");

		Auto a = new Auto(t, null, 0, null, 0);

		try
		{
			c.setNewDeliveryDate(a, d);
		}
		catch (AutoException | DateException e)
		{
			System.err.println ("Impossibile settare nuova data - "+e);
		}
	}
	
	/**
	 * 
	 * restituisce una descrizione come voce del menù
	 * 
	 * */
	public String getDescrizione ()
	{
		return "Modifica data di consegna";
	}
}
