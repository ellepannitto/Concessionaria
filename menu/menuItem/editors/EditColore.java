package menu.menuItem.editors;

import java.util.*;

import menu.menuItem.*;
import concessionaria.*;
import menu.*;
import exceptions.*;

/**
 * 
 * Una voce del menù che consente di modificare il colore di un'automobile
 * 
 * */
public class EditColore implements MenuItem
{
	// la concessionaria della quale modificare l'automobile
	private Concessionaria concessionaria;
	
	/**
	 * 
	 * inizializza un nuovo oggetto, data la concessionaria della quale modificare l'automobile
	 * 
	 * */
	public EditColore (Concessionaria c)
	{
		this.concessionaria = c;
	}
	
	
	/**
	 * 
	 * 
	 * Chiede in input una targa e un colore, poi lo assegna all'auto con quella targa. 
	 * 
	 * @param m un menù per gestire l'input e output
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
		

		String col = m.get_string("Inserisci nuovo colore");

		Auto a = new Auto(t, null, 0, null, 0);

		try
		{
			concessionaria.setNewColor(a, col);
			m.show("Modifica registrata.");
			
		}
		catch (AutoException e)
		{
			m.show_error("Impossibile modificare il colore", e);
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
		return "Modifica il colore";
	}
}
