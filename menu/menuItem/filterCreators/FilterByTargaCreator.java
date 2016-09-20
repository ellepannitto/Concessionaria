package menu.menuItem.filterCreators;

import java.util.*;

import filters.*;
import menu.menuItem.*;
import concessionaria.*;
import menu.*;

/**
 * 
 * Implementa l'interfaccia MenuItem per creare una voce del menù che setta un filtro per le auto in base alla targa, e lo aggiunge ad una lista di filtri
 * 
 * */
public class FilterByTargaCreator implements MenuItem
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
	public FilterByTargaCreator (List<Filterer<Auto>> l)
	{
		this.l = l;
	}
	
	/**
	 * 
	 * crea un filtro per le auto in base alla targa, e lo aggiunge ad una lista di filtri
	 * 
	 * */
	public void selected()
	{
		String s = Menu.get_pattern("Inserisci pattern da ricercare");
		
		
		FilterByTarga f = new FilterByTarga(s);
		
		l.add(f);
	}
	
	/**
	 * 
	 * restituisce una descrizione per la voce nel menù
	 * 
	 * */
	public String getDescrizione()
	{
		return "Filtra per Targa (espressione regolare)";
	}
	
}
