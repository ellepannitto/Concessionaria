package filterCreators;

import java.util.*;

import filters.*;
import callMe.*;
import misc.*;
import menu.*;

/**
 * 
 * Implementa l'interfaccia CallMe per creare una voce del menù che setta un filtro per le auto in base ai km percorsi, e lo aggiunge ad una lista di filtri
 * 
 * */
public class FilterByKmCreator implements CallMe
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
	public FilterByKmCreator (List<Filterer<Auto>> l)
	{
		this.l = l;
	}
	
	/**
	 * 
	 * crea un filtro per le auto in base ai km percorsi, e lo aggiunge alla lista di filtri
	 * 
	 * */
	public void call()
	{
		int min = Menu.get_int("Inserisci minimo (-1 se non richiesto)");
		int max = Menu.get_int("inserisci massimo (-1 se non richiesto)");
		
		//~ check_string(s);
		
		FilterByKm f = new FilterByKm(min, max);
		
		l.add(f);
	}
	
	/**
	 * 
	 * restituisce una descrizione per la voce del menù
	 * 
	 * */	public String getDescrizione()
	{
		return "Filtra per Chilometri Percorsi";
	}
	
}
