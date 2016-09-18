package sortingCreators;

import java.util.*;

import callMe.*;
import compare.*;
import misc.*;

/**
 *
 * 
 * 
 * */
public class SortingSelector
{
	private Comparator<Auto> funzione_di_ordinamento;
	private List<CallMe> lista = new ArrayList<CallMe> (); 
	
	/**
	 * restituisce la funzione di ordinamento scelta
	 * */
	public Comparator<Auto> get_ordering ()
	{
		return this.funzione_di_ordinamento;
	}
	
	public void add (SortingCreator sc)
	{
		lista.add (sc);
	}
	
	public List<CallMe> get_list ()
	{
		return lista;
	}
	
	public void set_ordering_function (Comparator<Auto> c)
	{
		this.funzione_di_ordinamento = c;
	}
	
}
