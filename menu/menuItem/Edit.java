package menu.menuItem;

import java.util.*;

import concessionaria.*;
import menu.*;
import exceptions.*;
import editors.*;

/**
 * 
 * Implementazione dell'interfaccia MenuItem che consente di creare una voce del menù per modificare la data di consegna di un'automobile
 * Se la voce è selezionata viene chiesta in input la targa di un'automobile T e una nuova data di consegna, che viene settata per l'automobile con targa T
 * 
 * */
public class Edit implements MenuItem
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
	public void selected()
	{
		
		List<MenuItem> possible_edits = new ArrayList<MenuItem>();
		
		possible_edits.add (new EditDeliveryDate (c));
		possible_edits.add (new EditColore (c));
		possible_edits.add (new EditPrezzo (c));
		
		
		Menu.show_menu (possible_edits, "Selezionare tipo di modifica:");
		
		
		
	}
	
	/**
	 * 
	 * restituisce una descrizione come voce del menù
	 * 
	 * */
	public String getDescrizione ()
	{
		return "Modifica";
	}
}
