import java.util.*;

public class AutoUsata extends Auto
{
	protected int anno_di_immatricolazione;
	protected int chilometri_percorsi;
	
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
	
	public int getMatriculationYear()
	{
		return this.anno_di_immatricolazione;
	}
	
	public int getKilometers()
	{
		return this.chilometri_percorsi;
	}
}
