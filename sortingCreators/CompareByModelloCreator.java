package sortingCreators;

import java.util.*;

import misc.*;
import compare.*;
import sortingCreators.*;

/**
 * 
 * Crea una funzione di ordinamento che ordinerà le auto secondo il modello, e la setta come selezionata in un oggetto di classe SortingSelector 
 * 
 * */
public class CompareByModelloCreator extends SortingCreator
{
	
	/**
	 * 
	 * Inizializza un nuovo oggetto, dato il SortingSelector sul quale lavorare
	 * 
	 * */
	public CompareByModelloCreator (SortingSelector ss)
	{
		super(ss);
	}
	
	/**
	 * 
     * Crea una funzione di ordinamento che ordinerà le auto secondo il modello, e la setta come selezionata in un oggetto di classe SortingSelector 
	 * 
	 * */
	public void selected()
	{

		this.selettore.set_ordering_function (new CompareByModello() );
		
	}
	
	/**
	 *
	 * Restituisce una descrizione della funzione di ordinamento 
	 * 
	 * */
	public String getDescrizione ()
	{
		return "Ordina per modello";
	}
	
}
