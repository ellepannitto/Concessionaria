package filters;

import concessionaria.*;

/**
 * Filtra le Auto in base al prezzo.
 * 
 * */ 
public class FilterByPrezzo implements Filterer<Auto>
{
	private float min_p;
	private float max_p;
	
	/**
	 * Inizializza un nuovo Filterer
	 * 
	 * @param min il minimo prezzo
	 * @param max il massimo prezzo
	 * 
	 * */
	public FilterByPrezzo (float min, float max) 
	{
		this.min_p = min;
		this.max_p = max;
		
	}
	
	/**
	 * 
	 * @return true se il prezzo dell'Auto è maggiore o uguali al minimo e minore o uguale al massimo
	 * 
	 * */
	public boolean filter (Auto a)
	{
		boolean ret = true;
				
		float prezzo = a.getPrezzo();
		
		if (this.min_p > 0)
			ret = prezzo >= this.min_p;
			
		if (this.max_p > 0)
			ret = ret && prezzo <= this.max_p;
			
		return ret;
	}
	
}
