package filterCreators;

import java.util.*;

import filters.*;
import callMe.*;
import misc.*;
import menu.*;

public class FilterByCostumerCreator implements CallMe
{
	private List<Filterer<Auto>> l;
	
	public FilterByCostumerCreator (List<Filterer<Auto>> l)
	{
		this.l = l;
	}
	
	public void call()
	{
		String s = Menu.get_pattern();
		
		//~ check_string(s);
		
		FilterByCustomer f = new FilterByCustomer(s);
		
		l.add(f);
	}
	
	public String getDescrizione()
	{
		return "blabla";
	}
	
}
