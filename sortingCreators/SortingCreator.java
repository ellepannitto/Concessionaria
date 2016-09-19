package sortingCreators;

import java.util.*;

import callMe.*;
import compare.*;
import misc.*;

/**
 *
 * Implementa l'interfaccia CallMe per creare una voce del menù che permette di creare una funzione di prdinamento per le auto.
 * Tale funzione di ordinamento verrà creata e poi settata come "selezionata" in un oggetto di classe SortingSelector 
 * 
 * */
public abstract class SortingCreator implements CallMe
{
	// selettore sul quale lavorare
	protected SortingSelector selettore;
	
	/**
	 * 
	 * Inizializza un oggetto che crea una funzione di ordinamento, dato il selettore sul quale lavorare
	 * 
	 * @param ss il selettore sul quale lavorare
	 * 
	 * */
	public SortingCreator (SortingSelector ss)
	{
		this.selettore = ss;
	}
}
