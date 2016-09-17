package callMe;

import java.util.*;

import misc.*;
import menu.*;
import filters.*;
import filterCreators.*;

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
		List<CallMe> orderings_to_show = new ArrayList<CallMe>();
		
		List<Filterer<Auto>> filters = new ArrayList<Filterer<Auto>>();
		
		filters_to_show.add(new FilterByCostumerCreator(filters));
		
		Menu.show_menu(filters_to_show);
		Menu.show_menu(orderings_to_show);
	}
	
	public String getDescrizione ()
	{
		return "Mostra Auto";
	}
}
