package filters;

import concessionaria.*;

/**
 * Filtra le Auto in base all'anno di immatricolazione.
 * 
 * */ 
public class FilterByMatriculationYear implements Filterer<Auto>
{
	private int min_year;
	private int max_year;
	
	/**
	 * Inizializza un nuovo Filterer
	 * 
	 * @param min il minimo anno accettato
	 * @param max il massimo anno accettato
	 * 
	 * */
	public FilterByMatriculationYear (int min, int max) 
	{	
		this.min_year = min;
		this.max_year = max;
		
	}
	
	/**
	 * 
	 * @return true se l'anno di immatricolazione dell'Auto è maggiore o uguale al minimo e minore o uguale al massimo
	 * 
	 * */
	public boolean filter (Auto a)
	{
		boolean ret = false;
		
		if (a instanceof AutoUsata)
		{
			ret = true;
			
			int y = ((AutoUsata)a).getMatriculationYear();
			
			if (this.min_year > 0)
				ret = y >= this.min_year;

			if (this.max_year > 0)
				ret = ret && y <= this.max_year;
		}
		
		return ret;
		
	}
	
}
