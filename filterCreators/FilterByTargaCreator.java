package filterCreators;

import java.util.*;

import filters.*;
import callMe.*;
import misc.*;
import menu.*;

/**
 * 
 * Implementa l'interfaccia CallMe per creare una voce del menù che setta un filtro per le auto in base alla targa, e lo aggiunge ad una lista di filtri
 * 
 * */
public class FilterByTargaCreator implements CallMe
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
	
	public void call()
	{
		String s = Menu.get_pattern("Inserisci pattern da ricercare");
		
		
		FilterByTarga f = new FilterByTarga(s);
		
		l.add(f);
	}
	
	public String getDescrizione()
	{
		return "Filtra per Cliente";
	}
	
}
