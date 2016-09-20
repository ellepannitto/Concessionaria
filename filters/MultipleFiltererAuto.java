package filters;

import java.util.*;

import concessionaria.*;

public class MultipleFiltererAuto implements Filterer<Auto>
{
	private List <Filterer<Auto>> lista_filtri;
	
	/**
	 * Inizializza un nuovo Filterer
	 * 
	 * @param lista_condizioni una lista di filtri da rispettare
	 * 
	 * */
	public MultipleFiltererAuto (List<Filterer<Auto>> lista_condizioni)
	{
		this.lista_filtri = lista_condizioni;
	}
	
	
	/**
	 * @return true se l'auto rispetta le condizioni imposte da tutti i filtri
	 * */
	public boolean filter (Auto a)
	{
		boolean ret = true;
		
		for (Filterer<Auto> f : lista_filtri)
		{
			ret = ret && f.filter(a);
		}
		
		return ret;
	}
	
}
