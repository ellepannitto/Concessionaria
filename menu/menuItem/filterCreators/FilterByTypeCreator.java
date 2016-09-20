package menu.menuItem.filterCreators;

import java.util.*;

import filters.*;
import menu.menuItem.*;
import concessionaria.*;
import menu.*;

/**
 * 
 * Implementa l'interfaccia MenuItem per creare una voce del menù che setta un filtro per le auto in base al tipo, e lo aggiunge ad una lista di filtri
 * 
 * */
public class FilterByTypeCreator implements MenuItem
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
	public FilterByTypeCreator (List<Filterer<Auto>> l)
	{
		this.l = l;
	}
	
	/**
	 * 
	 * crea un filtro per le auto in base al tipo, e lo aggiunge ad una lista di filtri
	 * 
	 * */
	public void selected()
	{
		int new_wanted = Menu.get_int("Inserisci 0 per auto usate e 1(o maggiore) per auto nuove");
		
		boolean n = new_wanted==0 ? false : true;
		
		FilterByType f = new FilterByType(n);
		
		l.add(f);
	}
	
	/**
	 * 
	 * restituisce una descrizione per la voce nel menù
	 * 
	 * */
	public String getDescrizione()
	{
		return "Filtra per Tipo";
	}
	
}
