package compare;

import java.util.*;

import misc.*;

/**
 * 
 * Implementa un comparatore fra auto, che le confronta secondo le loro targhe
 * 
 * */
public class CompareByTarga implements Comparator<Auto>
{
	/**
	 * 
	 * confronta due auto secondo la targa
	 * 
	 * @param a un'auto
	 * @param b un'auto
	 * 
	 * @return un valore negativo se la targa di a viene prima lessicograficamente alla targa di b
	 * @return un valore positivo se la targa di a viene dopo lessicograficamente alla targa di b
	 * @return zero se la targa di a è uguale alla targa di b
	 * 
	 * */
	public int compare (Auto a, Auto b)
	{
		return a.getTarga().compareTo(b.getTarga());
	}
}
