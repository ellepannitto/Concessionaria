package callMe;

import java.util.*;

import misc.*;
import menu.*;
import filters.*;
import filterCreators.*;
import sortingCreators.*;

public class Show implements CallMe
{
	private Concessionaria c;
	
	public Show (Concessionaria c)
	{
		this.c = c;
	}
	
	public void call()
	{
		List<CallMe> filters_to_show = new ArrayList<CallMe>();
		
		List<Filterer<Auto>> filters = new ArrayList<Filterer<Auto>>();
		
		filters_to_show.add(new FilterByCostumerCreator(filters));
		filters_to_show.add(new FilterByKmCreator(filters));
		filters_to_show.add(new FilterByMatriculationYearCreator(filters));
		filters_to_show.add(new FilterByTypeCreator(filters));
		filterCreators.Exit e = new filterCreators.Exit(filters);
		filters_to_show.add(e);
		
		while (!e.got_called())
			Menu.show_menu(filters_to_show, "Imposta i filtri di ricerca");
		
		MultipleFiltererAuto filtro = new MultipleFiltererAuto(filters);
		
		
		SortingSelector ss = new SortingSelector ();
		ss.add ( new CompareByTargaCreator (ss) );
		ss.add ( new CompareByTargaCreator (ss) );
		ss.add ( new CompareByTargaCreator (ss) );
		
		
		List<CallMe> orderings_to_show = ss.get_list();
		Menu.show_menu ( orderings_to_show , "Scegli il tipo di ordinamento" );
		
		Comparator<Auto> funzione_scelta = ss.get_ordering();
		
		Auto[] lista = c.filter_and_list_autos(filtro, funzione_scelta);
		
		for (Auto a: lista)
		{
			System.out.println(a);
		}
		
		
		
	}
	
	public String getDescrizione ()
	{
		return "Mostra Auto";
	}
}
