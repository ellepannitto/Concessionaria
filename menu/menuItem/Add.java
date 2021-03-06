package menu.menuItem;

import concessionaria.*;
import menu.*;
import exceptions.*;

/**
 * 
 * Implementazione dell'interfaccia MenuItem che consente di creare una voce del menù Aggiungere un auto ad una concessionaria
 * Se la voce è selezionata vengono chiesti all'utente i dati di un'automobile, che viene aggiunta allla concessionaria
 * 
 * */
public class Add implements MenuItem
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
	public void selected(Menu m)
	{
		Auto a = m.get_auto(this.c);

		try
		{
			c.add_auto(a);
			m.show ("Auto aggiunta correttamente");
		}
		catch (AutoException e)
		{
			m.show_error("Impossibile aggiungere auto", e);
		}
		
		m.wait_input();
		
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
