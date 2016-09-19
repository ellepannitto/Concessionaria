package sortingCreators;

import java.util.*;

import misc.*;
import compare.*;
import sortingCreators.*;

/**
 * 
 * Crea una funzione di ordinamento che ordinerà le auto secondo il prezzo, e la setta come selezionata in un oggetto di classe SortingSelector 
 * 
 * */
public class CompareByPrezzoCreator extends SortingCreator
{
	
	/**
	 * 
	 * Inizializza un nuovo oggetto, dato il SortingSelector sul quale lavorare
	 * 
	 * */
	public CompareByPrezzoCreator (SortingSelector ss)
	{
		super(ss);
	}
	
	/**
	 * 
     * Crea una funzione di ordinamento che ordinerà le auto secondo il prezzo, e la setta come selezionata in un oggetto di classe SortingSelector 
	 * 
	 * */
	public void call()
	{

		this.selettore.set_ordering_function (new CompareByPrezzo() );
		
	}
	
	/**
	 *
	 * Restituisce una descrizione della funzione di ordinamento 
	 * 
	 * */
	public String getDescrizione ()
	{
		return "Ordina per prezzo";
	}
	
}
