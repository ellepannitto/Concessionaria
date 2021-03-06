package concessionaria;


import java.io.Serializable;

/**
 * Memorizza i dati di un'auto.
 * 
 * */
public class Auto implements Serializable
{
	protected final String targa;
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
		this.targa = targa.toLowerCase();
		this.modello = modello;
		this.cilindrata = cilindrata;
		this.colore = colore;
		this.prezzo_di_vendita = prezzo;
	}
	
	/**
	 * imposta il nuovo colore a un'auto
	 * 
	 * @param c stringa che descrive il colore
	 * */
	public void setColor (String c)
	{
		this.colore = c;
	}

	/**
	 * imposta il nuovo prezzo a un'auto
	 * 
	 * @param p float che rappresenta il prezzo
	 * */
	public void setPrezzo (float p)
	{
		this.prezzo_di_vendita = p;
	}
	
	/**
	 * @return la targa dell'Auto
	 * */
	public String getTarga()
	{
		return this.targa;
	}
	
	/**
	 * @return il prezzo dell'Auto
	 * */
	public float getPrezzo()
	{
		return this.prezzo_di_vendita;
	}
	/**
	 * @return la cilindrata dell'Auto
	 * */
	public int getCilindrata()
	{
		return this.cilindrata;
	}
	/**
	 * @return il modello dell'Auto
	 * */
	public String getModello()
	{
		return this.modello;
	}
	
	/**
	 * @param a oggetto da confrontare
	 * @return true se le targhe del parametro e dell'auto coincidono
	 * */
	public boolean equals (Object a)
	{
		return ((Auto)a).targa.equals(this.targa) ; 
	}
	
	/**
	 * @return hashCode della targa dell'Auto
	 * */
	public int hashCode ()
	{
		return this.targa.hashCode();
	}
	
	/**
	 * @return restituisce una stringa che rappresenta l'oggetto
	 * */
	public String toString()
	{
		String rigauno = String.format("Targa: %s\n", this.targa.toUpperCase());
		String rigadue = String.format("Desc: %s %s, %d cc\n", this.modello, this.colore, this.cilindrata);
		
		return rigauno+rigadue;


	}
	
}
