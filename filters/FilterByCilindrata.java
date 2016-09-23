package filters;

import concessionaria.*;

/**
 * Filtra le Auto in base alla cilindrata.
 * 
 * */ 
public class FilterByCilindrata implements Filterer<Auto>
{
	private int min_c;
	private int max_c;
	
	/**
	 * Inizializza un nuovo Filterer
	 * 
	 * @param min la minima cilindrata
	 * @param max la massina cilindrata
	 * 
	 * */
	public FilterByCilindrata (int min, int max) 
	{
		this.min_c = min;
		this.max_c = max;
		
	}
	
	/**
	 * 
	 * @return true se la cilindrata dell'Auto è maggiore o uguale al minimo e minore o uguale al massimo
	 * 
	 * */
	public boolean filter (Auto a)
	{
		boolean ret = true;
				
		int cilindrata = a.getCilindrata();
		
		if (this.min_c > 0)
			ret = cilindrata >= this.min_c;
			
		if (this.max_c > 0)
			ret = ret && cilindrata <= this.max_c;
			
		return ret;
	}
	
}
