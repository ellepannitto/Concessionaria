package compare;

import java.util.*;

import misc.*;

/**
 * 
 * Implementa un comparatore fra auto, che le confronta secondo il loro modello
 * 
 * */
public class CompareByModello implements Comparator<Auto>
{
	/**
	 * 
	 * confronta due auto secondo il modello
	 * 
	 * @param a un'auto
	 * @param b un'auto
	 * 
	 * @return un valore negativo se il modello di a è viene prima lessicograficamente al modello di b
	 * @return un valore positivo se il modello di a è viene dopo lessicograficamente al modello di b
	 * @return zero se il modello di a è uguale al modello di b
	 * 
	 * */
	public int compare (Auto a, Auto b)
	{
		return a.getModello().compareTo(b.getModello());
	}
}
