package menu.menuItem.editors;

import java.util.*;

import menu.menuItem.*;
import concessionaria.*;
import menu.*;
import exceptions.*;


/**
 * Implementa l'interfaccia MenuItem per realizzare una voce del menu che permette di modificare il prezzo di un'auto.
 * */
public class EditPrezzo implements MenuItem
{
	private Concessionaria concessionaria;
	
	/**
	 * Inizializza un nuovo oggetto della classe
	 * */
	public EditPrezzo (Concessionaria c)
	{
		this.concessionaria = c;
	}
	
	/**
	 * Chiede in input la targa e un nuovo prezzo e assegna il nuovo prezzo all'auto con la targa cercata.
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
				
		float prezzo = m.get_float("Inserisci nuovo prezzo");
		
		while (!concessionaria.check_prezzo(prezzo))
		{
			prezzo = m.get_float ("Il prezzo inserito non è valido, inserisci di nuovo");
		}

		Auto a = new Auto(t, null, 0, null, 0);

		try
		{
			concessionaria.setNewPrice(a, prezzo);
			
			m.show("Modifica registrata.");
			
		}
		catch (AutoException e)
		{
			m.show_error ("Impossibile modificare il colore", e);
		}
		
		m.wait_input ();
	}
	
	/**
	 * 
	 * Restituisce una descrizione per la voce del menù
	 * 
	 * */	public String getDescrizione()
	{
		return "Modifica il prezzo";
	}
}
