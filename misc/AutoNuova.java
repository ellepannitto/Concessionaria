package misc;

import java.util.*;
import java.text.SimpleDateFormat;

public class AutoNuova extends Auto 
{
	protected GregorianCalendar data_di_consegna;
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
	public AutoNuova (String targa, String modello, int cilindrata, String colore, float prezzo, GregorianCalendar data, Cliente cliente)
	{
		super (targa, modello, cilindrata, colore, prezzo);
		
		this.data_di_consegna = data;
		this.cliente = cliente;
	}
	
	public String toString ()
	{
		String auto = super.toString();
		
		String date = new SimpleDateFormat("dd/MM/yyyy").format(this.data_di_consegna.getTime());
		String autonuova = String.format("Cliente: %s\tData di consegna: %s\n", this.cliente.toString(), date);
		String p = String.format("Prezzo: %.2f", this.prezzo_di_vendita);
		
		return auto+autonuova+p;
	}
	
	/**
	 * imposta una diversa data di consegna
	 * 
	 * @param nuova data da impostare
	 * */
	public void setNewDate (GregorianCalendar nuova_data)
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
	public GregorianCalendar getDeliveryDate()
	{
		return this.data_di_consegna;
	}
	
}
