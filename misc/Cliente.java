package misc;

import java.io.*;


/**
 * Memorizza i dati di un cliente.
 * 
 * */
public class Cliente implements Serializable
{
	private String nome;
	private String cognome;
	private String cf;
	
	/**
	 * Inizializza un cliente a partire dai dati anagrafici.
	 * 
	 * @param nome del cliente
	 * @param cognome del cliente
	 * @param codice fiscale del cliente
	 * 
	 * */
	public Cliente (String n, String c, String cf)
	{
		this.nome = n;
		this.cognome = c;
		this.cf = cf;
	}
	
	/**
	 * @return cognome del cliente
	 * */
	public String getSurname ()
	{
		return cognome;
	}

	/**
	 * @return nome del cliente
	 * */
	public String getName ()
	{
		return nome;
	}
	
	
	/**
	 * @return restituisce una stringa che rappresenta l'oggetto
	 * */
	public String toString()
	{
		return this.nome + " " + this.cognome;
	}
}
