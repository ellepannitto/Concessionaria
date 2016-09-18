package filterCreators;

import java.util.*;

import filters.*;
import callMe.*;
import misc.*;
import menu.*;

public class FilterByTargaCreator implements CallMe
{
	private List<Filterer<Auto>> l;
	
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
