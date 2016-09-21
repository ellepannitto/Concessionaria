package menu.menuItem.sortingCreators;

import java.util.*;

import concessionaria.*;
import compare.*;
import menu.menuItem.sortingCreators.*;
import menu.*;

/**
 * 
 * Crea una funzione di ordinamento che ordinerà le auto secondo la cilindrata, e la setta come selezionata in un oggetto di classe SortingSelector 
 * 
 * */
public class CompareByCilindrataCreator extends SortingCreator
{
	
	/**
	 * 
	 * Inizializza un nuovo oggetto, dato il SortingSelector sul quale lavorare
	 * 
	 * */
	public CompareByCilindrataCreator (SortingSelector ss)
	{
		super(ss);
	}
	
	/**
	 * 
     * Crea una funzione di ordinamento che ordinerà le auto secondo la cilindrata, e la setta come selezionata in un oggetto di classe SortingSelector 
	 * 
	 * */
	public void selected(Menu m)
	{

		this.selettore.set_ordering_function (new CompareByCilindrata() );
		
	}
	
	/**
	 *
	 * Restituisce una descrizione della funzione di ordinamento 
	 * 
	 * */
	public String getDescrizione ()
	{
		return "Ordina per cilindrata";
	}
	
}
