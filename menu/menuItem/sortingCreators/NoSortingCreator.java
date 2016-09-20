package menu.menuItem.sortingCreators;

import java.util.*;

import concessionaria.*;
import compare.*;
import menu.menuItem.sortingCreators.*;

/**
 * 
 * 
 * */
public class NoSortingCreator extends SortingCreator
{
	
	/**
	 * 
	 * 
	 * */
	public NoSortingCreator (SortingSelector ss)
	{
		super(ss);
	}
	
	/**
	 * 
	 * 
	 * */
	public void selected()
	{

		this.selettore.set_ordering_function (new NoSorting() );
		
	}
	
	/**
	 *
	 * 
	 * */
	public String getDescrizione ()
	{
		return "Nessun ordinamento (data di inserimento)";
	}
}
