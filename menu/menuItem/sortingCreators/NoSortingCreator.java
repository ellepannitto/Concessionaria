package menu.menuItem.sortingCreators;

import java.util.*;

import concessionaria.*;
import compare.*;
import menu.menuItem.sortingCreators.*;
import menu.*;

/**
 * Crea una funzione di ordinamento fittizia che lascia inalterato l'ordine delle auto, e la setta come selezionata in un oggetto di classe SortingSelector 
 * 
 * */
public class NoSortingCreator extends SortingCreator
{
	
	/**
	 * 
	 * Inizializza un nuovo oggetto, dato il SortingSelector
	 * */
	public NoSortingCreator (SortingSelector ss)
	{
		super(ss);
	}
	
	/**
	 * Crea un ordinatore di tipo NoSorting che lascia inalterato l'ordine della lista di auto
	 * */
	public void selected(Menu m)
	{

		this.selettore.set_ordering_function (new NoSorting() );
		
	}
	
	public String getDescrizione ()
	{
		return "Nessun ordinamento (data di inserimento)";
	}
}
