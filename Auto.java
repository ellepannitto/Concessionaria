import java.util.*;

public class Auto 
{
	protected String targa;
	protected String modello;
	protected int cilindrata;
	protected String colore;
	protected float prezzo_di_vendita;
	
	public Auto (String targa, String modello, int cilindrata, String colore, float prezzo)
	{
		this.targa = targa;
		this.modello = modello;
		this.cilindrata = cilindrata;
		this.colore = colore;
		this.prezzo_di_vendita = prezzo;
	}
	
	
	public String getTarga()
	{
		return this.targa;
	}
	
	public boolean equals (Object a)
	{
		return ((Auto)a).targa == this.targa ; 
	}
	
	public int hashCode ()
	{
		return this.targa.hashCode();
	}
	
}
