package misc;

import java.util.*;
import java.io.*;

/**
 * 
 * 
 * 
 * 
 * */
public class Auto implements Serializable
{
	protected String targa;
	protected String modello;
	protected int cilindrata;
	protected String colore;
	protected float prezzo_di_vendita;
	
	/**
	 * Inizializza un nuovo oggetto di classe AutoUsata
	 * 
	 * @param targa dell'Auto
	 * @param modello dell'Auto
	 * @param cilindrata dell'Auto
	 * @param colore dell'Auto
	 * @param prezzo dell'Auto
	 * */
	public Auto (String targa, String modello, int cilindrata, String colore, float prezzo)
	{
		this.targa = targa;
		this.modello = modello;
		this.cilindrata = cilindrata;
		this.colore = colore;
		this.prezzo_di_vendita = prezzo;
	}
	
	/**
	 * @return la targa dell'Auto
	 * */
	public String getTarga()
	{
		return this.targa;
	}
	
	/**
	 * @param oggetto da confrontare
	 * @return true se le targhe del parametro e dell'auto coincidono
	 * */
	public boolean equals (Object a)
	{
		return ((Auto)a).targa == this.targa ; 
	}
	
	/**
	 * @return hashCode della targa dell'Auto
	 * */
	public int hashCode ()
	{
		return this.targa.hashCode();
	}
	
	public String toString()
	{
		String rigauno = String.format("Cat: Nuova\tTarga: %s\n", this.targa);
		String rigadue = String.format("Desc: %s %s, %d cc\n", this.modello, this.colore, this.cilindrata);
		
		return rigauno+rigadue;
	}
	
}
