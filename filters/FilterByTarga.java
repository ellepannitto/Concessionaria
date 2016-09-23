package filters;

import java.util.*;
import java.util.regex.*;
import java.lang.*;

import concessionaria.*;

/**
 * Filtra le Auto in base alla targa dell'auto.
 * 
 * */ 
public class FilterByTarga implements Filterer<Auto>
{
	private Pattern p;
	
	/**
	 * Inizializza un nuovo Filterer
	 * 
	 * @param pattern da cercare (cognome)
	 * */
	public FilterByTarga (String pattern) 
	{
		this.p = Pattern.compile(pattern);
	}
	
	/**
	 * @return true se l'Auto rispetta le condizioni del filtro, ovvero se la targa matcha il pattern settata dal costruttore.
	 * */
	public boolean filter (Auto a)
	{
					
		String targa = a.getTarga();
	
		Matcher m = p.matcher(targa);
		
		boolean ret = m.find();
		

		return ret;
	}
	
}
