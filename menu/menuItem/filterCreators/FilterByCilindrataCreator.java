package menu.menuItem.filterCreators;

import java.util.*;

import filters.*;
import menu.menuItem.*;
import concessionaria.*;
import menu.*;

/**
 * 
 * Implementa l'interfaccia MenuItem per creare una voce del menù che setta un filtro per le auto in base alla cilindrata, e lo aggiunge ad una lista di filtri
 * 
 * */
public class FilterByCilindrataCreator implements MenuItem
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
	public FilterByCilindrataCreator (List<Filterer<Auto>> l)
	{
		this.l = l;
	}
	
	/**
	 * 
	 * crea un filtro per le auto in base alla cilindrata, e lo aggiunge alla lista di filtri
	 * 
	 * */
	public void selected(Menu m)
	{
		int min = m.get_int("Inserisci minimo (-1 se non richiesto)");
		int max = m.get_int("inserisci massimo (-1 se non richiesto)");
			
		FilterByCilindrata f = new FilterByCilindrata(min, max);
		
		l.add(f);
	}
	
	/**
	 * 
	 * restituisce una descrizione per la voce del menù
	 * 
	 * */	public String getDescrizione()
	{
		return "Filtra per Cilindrata";
	}
	
}
