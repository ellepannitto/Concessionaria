package menu.menuItem.filterCreators;

import java.util.*;

import filters.*;
import menu.menuItem.*;
import concessionaria.*;
import menu.*;

/**
 * 
 * Implementa l'interfaccia MenuItem per creare una voce del menù che setta un filtro per le auto in base ai dati del cliente, e lo aggiunge ad una lista di filtri
 * 
 * */
public class FilterByCostumerCreator implements MenuItem
{
	// lista di filtri alla quale aggiungere il filtro creato
	private List<Filterer<Auto>> l;
	
	/**
	 * 
	 * setta la lista di filtri alla quale aggiungere il filtro creato
	 *
	 * @param l lista di filtri alla quale aggiungere il filtro creato
	 * 
	 * */
	public FilterByCostumerCreator (List<Filterer<Auto>> l)
	{
		this.l = l;
	}
	
	/**
	 * 
	 * Crea un filtro per le auto in base ai dati del cliente, e lo aggiunge ad una lista di filtri
	 * 
	 * */
	public void selected(Menu m)
	{
		String s = m.get_pattern("Inserisci pattern da ricercare");
		
		FilterByCustomer f = new FilterByCustomer(s);
		
		l.add(f);
	}
	
	/**
	 * 
	 * restituisce una descrizione per la voce del menù
	 * 
	 * */
	public String getDescrizione()
	{
		return "Filtra per Cliente";
	}
	
}
