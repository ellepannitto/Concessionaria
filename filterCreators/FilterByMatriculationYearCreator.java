package filterCreators;

import java.util.*;

import filters.*;
import callMe.*;
import misc.*;
import menu.*;

/**
 * 
 * Implementa l'interfaccia CallMe per creare una voce del menù che setta un filtro per le auto in base all'anno di immatricolazione, e lo aggiunge ad una lista di filtri
 * 
 * */
public class FilterByMatriculationYearCreator implements CallMe
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
	public FilterByMatriculationYearCreator (List<Filterer<Auto>> l)
	{
		this.l = l;
	}
	
	public void call()
	{
		int min = Menu.get_int("Inserisci minimo (-1 se non richiesto) ");
		int max = Menu.get_int("Inserisci massimo (-1 se non richiesto) ");
		
		FilterByMatriculationYear f = new FilterByMatriculationYear(min, max);
		
		l.add(f);
	}
	
	public String getDescrizione()
	{
		return "Filtra per anno di immatricolazione";
	}
	
}
