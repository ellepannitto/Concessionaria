package misc;

import java.util.*;

public class AutoUsata extends Auto
{
	protected int anno_di_immatricolazione;
	protected int chilometri_percorsi;
	
	/**
	 * Inizializza un nuovo oggetto di classe AutoUsata
	 * 
	 * @param targa dell'Auto
	 * @param modello dell'Auto
	 * @param cilindrata dell'Auto
	 * @param colore dell'Auto
	 * @param prezzo dell'Auto
	 * @param anno di immatricolazione dell'Auto
	 * @param chilometri percorsi dall'Auto
	 * */
	public AutoUsata (String targa, String modello, int cilindrata, String colore, float prezzo, int anno_di_immatricolazione, int km)
	{
		super (targa, modello, cilindrata, colore, prezzo);
		
		this.anno_di_immatricolazione = anno_di_immatricolazione;
		this.chilometri_percorsi = km;
	}
	
	public String toString ()
	{
		return this.targa + this.modello;
	}
	
	/**
	 * @return anno di immatricolazione dell'Auto
	 * */
	public int getMatriculationYear()
	{
		return this.anno_di_immatricolazione;
	}
	
	/**
	 * @return chilometri percorsi dall'Auto
	 * */
	public int getKilometers()
	{
		return this.chilometri_percorsi;
	}
}
