package callMe;

import java.util.*;

import misc.*;
import menu.*;
import filters.*;
import filterCreators.*;
import sortingCreators.*;

/**
 * 
 * Implementazione dell'interfaccia CallMe che consente di creare una voce del menù per visualizzare le automobili di una concessionaria
 * è possibile applicare dei filtri per ridurre il numero di automobili mostrate, nonché scegliere con quale ordinamento mostrarle 
 * 
 * */
public class Show implements CallMe
{
	// la concessionaria sulla quale operare
	private Concessionaria c;
	
	/**
	 * 
	 * Inizializza un nuovo oggetto, data la concessionaria sulla quale operare
	 * 
	 * @param c la concessionaria sulla quale operare
	 * 
	 * */
	public Show (Concessionaria c)
	{
		this.c = c;
	}
	
	/**
	 * 
	 * Chiede all'utente una lista di filtri da applicare, poi una funzione di ordinamento.
	 * Verranno poi mostrate solo le auto che rispettano i filtri scelti, ordinate con la funzione di ordinamento scelta.
	 * 
	 * */
	public void call()
	{
		List<CallMe> filters_to_show = new ArrayList<CallMe>();
		
		List<Filterer<Auto>> filters = new ArrayList<Filterer<Auto>>();
		
		filters_to_show.add(new FilterByCostumerCreator(filters));
		filters_to_show.add(new FilterByKmCreator(filters));
		filters_to_show.add(new FilterByMatriculationYearCreator(filters));
		filters_to_show.add(new FilterByTypeCreator(filters));
		filters_to_show.add(new FilterByTargaCreator(filters));
		filterCreators.Exit e = new filterCreators.Exit(filters);
		filters_to_show.add(e);
		
		while (!e.got_called())
			Menu.show_menu(filters_to_show, "Imposta i filtri di ricerca");
		
		MultipleFiltererAuto filtro = new MultipleFiltererAuto(filters);
		
		
		SortingSelector ss = new SortingSelector ();
		ss.add ( new CompareByTargaCreator (ss) );
		ss.add ( new CompareByCilindrataCreator (ss) );
		ss.add ( new CompareByModelloCreator (ss) );
		ss.add ( new CompareByPrezzoCreator (ss) );
		
		
		List<CallMe> orderings_to_show = ss.get_list();
		Menu.show_menu ( orderings_to_show , "Scegli il tipo di ordinamento" );
		
		Comparator<Auto> funzione_ordinamento_scelta = ss.get_ordering();
		
		Auto[] lista = c.filter_autos(filtro, funzione_ordinamento_scelta);
		
		for (Auto a: lista)
		{
			System.out.println(a);
		}
		
		
		
	}
	
	/**
	 * 
	 * Restituisce una descrizione per questa voce del menù
	 * 
	 * */
	public String getDescrizione ()
	{
		return "Mostra Auto";
	}
}
