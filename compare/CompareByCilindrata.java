package compare;

import java.util.*;

import misc.*;

/**
 * 
 * Implementa un comparatore fra auto, che le confronta secondo la cilindrata
 * 
 * */
public class CompareByCilindrata implements Comparator<Auto>
{
	/**
	 * 
	 * confronta due auto secondo la cilindrata
	 * 
	 * @param a un'auto
	 * @param b un'auto
	 * 
	 * @return un valore negativo se la cilindrata di a è minore della cilindrata di b
	 * @return un valore positivo se la cilindrata di a è maggiore della cilindrata di b
	 * @return zero se la cilindrata di a è uguale alla cilindrata di b
	 * 
	 * */
	public int compare (Auto a, Auto b)
	{
		return a.getCilindrata() - b.getCilindrata();
	}
}
