package compare;

import java.util.*;

import concessionaria.*;

/**
 * Implementa un comparatore fittizio fra auto, che restituisce l'ordine in cui sono memorizzate nell'archivio.
 * 
 * */
public class NoSorting implements Comparator<Auto>
{
	/**
	 * @param a un'auto
	 * @param b un'auto
	 * 
	 * @return 0 in ogni caso
	 * 
	 * */
	public int compare (Auto a, Auto b)
	{
		return 0;
	}
}
