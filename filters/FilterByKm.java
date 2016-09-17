package filters;

import misc.*;

/**
 * Filtra le Auto in base ai chilometri percorsi dall'Auto.
 * 
 * */ 
public class FilterByKm implements Filterer<Auto>
{
	private int min_km;
	private int max_km;
	
	/**
	 * Inizializza un nuovo Filterer
	 * 
	 * @param il minimo numero di chilometri accettati
	 * @param il massimo numero di chilometri accettati
	 * 
	 * */
	public FilterByKm (int min, int max) 
	{
		this.min_km = min;
		this.max_km = max;
		
	}
	
	/**
	 * 
	 * @return true se i chilometri dell'Auto sono maggiori o uguali al minimo e minori o uguali al massimo
	 * 
	 * */
	public boolean filter (Auto a)
	{
		boolean ret = false;
		
		if (a instanceof AutoUsata)
		{
			int km = ((AutoUsata)a).getKilometers();
			
			ret = km >= this.min_km && km <= this.max_km;
		}
		return ret;
	}
	
}
