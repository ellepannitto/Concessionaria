package menu.menuItem;

import java.util.*;

import concessionaria.*;
import menu.*;
import exceptions.*;

/**
 * 
 * Implementazione dell'interfaccia MenuItem che consente di creare una voce del menù per visualizzare la prossima auto da consegnare di una concessionaria
 * Se la voce è selezionata, mostra la prossima auto da consegnare, o un errore nel caso non ci siano 
 * 
 * */
public class NextDelivery implements MenuItem
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
	public void selected(Menu m)
	{
		
		try
		{
			Auto a = c.getNextDelivery();
			m.show(a.toString());
		}
		catch (AutoException e)
		{
			m.show_error("Impossibile mostrare la prossima consegna", e);
		}
		
		m.wait_input();
			
	}
	
	public String getDescrizione ()
	{
		return "Mostra prossima auto da consegnare";
	}
}
