package menu.menuItem.sortingCreators;

import java.util.*;

import concessionaria.*;
import compare.*;
import menu.menuItem.sortingCreators.*;

/**
 * 
 * Crea una funzione di ordinamento che ordinerà le auto secondo la targa, e la setta come selezionata in un oggetto di classe SortingSelector 
 * 
 * */
public class CompareByTargaCreator extends SortingCreator
{
	
	/**
	 * 
	 * Inizializza un nuovo oggetto, dato il SortingSelector sul quale lavorare
	 * 
	 * */
	public CompareByTargaCreator (SortingSelector ss)
	{
		super(ss);
	}
	
	/**
	 * 
     * Crea una funzione di ordinamento che ordinerà le auto secondo la targa, e la setta come selezionata in un oggetto di classe SortingSelector 
	 * 
	 * */
	public void selected()
	{

		this.selettore.set_ordering_function (new CompareByTarga() );
		
	}
	
	/**
	 *
	 * Restituisce una descrizione della funzione di ordinamento 
	 * 
	 * */
	public String getDescrizione ()
	{
		return "Ordina per targa";
	}
	
}
