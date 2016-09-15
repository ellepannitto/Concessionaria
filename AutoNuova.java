import java.util.*;

public class AutoNuova extends Auto 
{
	protected Date data_di_consegna;
	protected Cliente cliente;
	
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
	
	public void setNewDate (Date nuova_data)
	{
		this.data_di_consegna = nuova_data;
	}
	
	public Cliente getCostumer()
	{
		return this.cliente;
	}
	
	public Date getDeliveryDate()
	{
		return this.data_di_consegna;
	}
	
}
