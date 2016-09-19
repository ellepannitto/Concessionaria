package compare;

import java.util.*;

import misc.*;

/**
 * 
 * Implementa un comparatore fra auto, che le confronta secondo il loro prezzo
 * 
 * */
public class CompareByPrezzo implements Comparator<Auto>
{
	/**
	 * 
	 * Confronta due auto secondo il prezzo
	 * 
	 * @param a un'auto
	 * @param b un'auto
	 * 
	 * @return un valore negativo se il prezzo di a è minore del prezzo di b
	 * @return un valore positivo se il prezzo di a è maggiore del prezzo di b
	 * @return zero se il prezzo di a è uguale al prezzo di b
	 * 
	 * 
	 * */
	public int compare (Auto a, Auto b)
	{
		float diff = a.getPrezzo() - b.getPrezzo();
		
		if (diff > 0)
		{
			return 1;
		}
		else if (diff == 0)
		{
			return 0;
		}
		else
		{
			return -1;
		}
	}
}
