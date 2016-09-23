package concessionaria;


import java.io.Serializable;

/**
 * Memorizza i dati di un cliente.
 * 
 * */
public class Cliente implements Serializable
{
	private String nome;
	private String cognome;
	private final String cf;
	
	/**
	 * Inizializza un cliente a partire dai dati anagrafici.
	 * 
	 * @param n nome del cliente
	 * @param c cognome del cliente
	 * 
	 * */
	public Cliente (String n, String c)
	{
		this.nome = n;
		this.cognome = c;
		this.cf = calcola_codice(cognome, nome);
	}
	
	/**
	 * Da implementare: calcolo del codice fiscale.
	 * Al momento restituisce cognome e nome concatenati
	 * */
	private String calcola_codice (String c, String n)
	{
		return c+n;
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
