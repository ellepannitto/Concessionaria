package filterCreators;

import java.util.*;

import filters.*;
import callMe.*;
import misc.*;
import menu.*;

public class FilterByTypeCreator implements CallMe
{
	private List<Filterer<Auto>> l;
	
	public FilterByTypeCreator (List<Filterer<Auto>> l)
	{
		this.l = l;
	}
	
	public void call()
	{
		int new_wanted = Menu.get_int("Inserisci 0 per auto usate e 1(o maggiore) per auto nuove");
		
		boolean n = new_wanted==0 ? false : true;
		
		FilterByType f = new FilterByType(n);
		
		l.add(f);
	}
	
	public String getDescrizione()
	{
		return "Filtra per Tipo";
	}
	
}
