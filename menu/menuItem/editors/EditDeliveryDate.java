package menu.menuItem.editors;

import java.util.*;

import menu.menuItem.*;
import concessionaria.*;
import menu.*;
import exceptions.*;


/**
 * 
 * Una voce del menù che consente di modificare la data di consegna di un'automobile
 * 
 * 
 * */
public class EditDeliveryDate implements MenuItem
{
	// la concessionaria della quale modificare l'automobile
	private Concessionaria concessionaria;
	
	/**
	 * 
	 * inizializza un nuovo oggetto, data la concessionaria della quale modificare l'automobile
	 * 
	 * */	
	public EditDeliveryDate (Concessionaria c)
	{
		this.concessionaria = c;
	}
	
	/**
	 * Chiede in input la targa e una nuova data e assegna quella data all'auto con la targa cercata.
	 * 
	 * @param m Menu
	 * 
	 * */
	public void selected(Menu m)
	{
		Auto[] lista = concessionaria.list_autos();
		
		for (Auto a:lista)
		{
			m.show( a.toString() );
		}
		
		String t = m.get_string("Inserisci targa dell'auto da modificare");
		
		
		GregorianCalendar d = m.get_data("Inserisci nuova data di consegna");

		Auto a = new Auto(t, null, 0, null, 0);

		try
		{
			concessionaria.setNewDeliveryDate(a, d);
			m.show("Modifica registrata.\n");
		}
		catch (AutoException | DateException e)
		{
			m.show_error("Impossibile settare nuova data", e);
		}
		
		m.wait_input ();
		
	}
	
	/**
	 * 
	 * Restituisce una descrizione per la voce del menù
	 * 
	 * */
	public String getDescrizione()
	{
		return "Modifica una data di consegna";
	}
}
