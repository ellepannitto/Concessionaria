package misc;

import java.util.*;

public class AutoNuova extends Auto 
{
	protected Date data_di_consegna;
	protected Cliente cliente;
	
	/**
	 * Inizializza un nuovo oggetto di classe AutoUsata
	 * 
	 * @param targa dell'Auto
	 * @param modello dell'Auto
	 * @param cilindrata dell'Auto
	 * @param colore dell'Auto
	 * @param prezzo dell'Auto
	 * @param data di consegna prevista
	 * @param cliente
	 * */
	public AutoNuova (String targa, String modello, int cilindrata, String colore, float prezzo, Date data, Cliente cliente)
	{
		super (targa, modello, cilindrata, colore, prezzo);
		
		this.data_di_consegna = data;
		this.cliente = cliente;
	}
	
	public String toString ()
	{
		return this.targa + this.modello;
	}
	
	/**
	 * imposta una diversa data di consegna
	 * 
	 * @param nuova data da impostare
	 * */
	public void setNewDate (Date nuova_data)
	{
		this.data_di_consegna = nuova_data;
	}
	
	/**
	 * @return Cliente dell'Auto
	 * */
	public Cliente getCostumer()
	{
		return this.cliente;
	}
	
	/**
	 * @return data di consegna dell'Auto
	 * */
	public Date getDeliveryDate()
	{
		return this.data_di_consegna;
	}
	
}
