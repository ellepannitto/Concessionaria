package filters;

import concessionaria.*;

/**
 * Filtra le Auto in base al tipo.
 * 
 * */ 
public class FilterByType implements Filterer<Auto>
{
	private boolean new_wanted;
	
	
	/**
	 * Inizializza un nuovo Filterer
	 * 
	 * @param new_wanted boolean
	 * 
	 * */
	public FilterByType (boolean new_wanted)
	{
		this.new_wanted = new_wanted;
	}
	
	
	/**
	 * @return true se l'auto è del tipo richiesto
	 * @return false altrimenti
	 * 
	 * */
	public boolean filter (Auto a)
	{
		return ( new_wanted && (a instanceof AutoNuova) ) || ( !new_wanted && (a instanceof AutoUsata) );
		
	}
}
