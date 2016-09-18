package filterCreators;

import java.util.*;

import filters.*;
import callMe.*;
import misc.*;
import menu.*;

public class FilterByMatriculationYearCreator implements CallMe
{
	private List<Filterer<Auto>> l;
	
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
