package sortingCreators;

import java.util.*;

import callMe.*;
import compare.*;
import misc.*;

/**
 *
 * Permette di aggiungere un numero indefinito di funzioni di ordinamento, di sceglierne uno e di restituire l'ordinamento scelto
 *  
 * */
public class SortingSelector
{
	// funzione di ordinamento scelta
	private Comparator<Auto> funzione_di_ordinamento;
	// lista di possibili funzioni di ordinamento
	private List<CallMe> lista = new ArrayList<CallMe> (); 
	
	/**
	 * restituisce la funzione di ordinamento scelta
	 * 
	 * @return la funzione di ordinamento scelta
	 * */
	public Comparator<Auto> get_ordering ()
	{
		return this.funzione_di_ordinamento;
	}
	
	/**
	 * 
	 * Aggiunge un funzione di ordinamento a quelle già presenti
	 * 
	 * @param sc un creatore per la funzione di ordinamento da aggiungere
	 * 
	 * */
	public void add (SortingCreator sc)
	{
		lista.add (sc);
	}
	
	/**
	 * 
	 * restituisce la lista di tutte le funzioni di ordinamento memorizzate
	 * 
	 * @return una lista di creatori di funzioni di ordinamento, corrispondenti alle funzioni di ordinamento presenti
	 * 
	 * */
	public List<CallMe> get_list ()
	{
		return lista;
	}
	
	/**
	 * 
	 * Permettere di scegliere una fra le funzioni di ordinamento presenti
	 * 
	 * @param c funzione di ordinamento scelta
	 * 
	 * */
	public void set_ordering_function (Comparator<Auto> c)
	{
		this.funzione_di_ordinamento = c;
	}
	
}
