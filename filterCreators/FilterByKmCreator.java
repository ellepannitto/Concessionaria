package filterCreators;

import java.util.*;

import filters.*;
import callMe.*;
import misc.*;
import menu.*;

public class FilterByKmCreator implements CallMe
{
	private List<Filterer<Auto>> l;
	
	public FilterByKmCreator (List<Filterer<Auto>> l)
	{
		this.l = l;
	}
	
	public void call()
	{
		int min = Menu.get_int("Inserisci minimo");
		int max = Menu.get_int("inserisci massimo");
		
		//~ check_string(s);
		
		FilterByKm f = new FilterByKm(min, max);
		
		l.add(f);
	}
	
	public String getDescrizione()
	{
		return "Filtra per Chilometri Percorsi";
	}
	
}
