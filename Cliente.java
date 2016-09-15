public class Cliente
{
	private String nome;
	private String cognome;
	private String cf;
	
	public Cliente (String n, String c, String cf)
	{
		this.nome = n;
		this.cognome = c;
		this.cf = cf;
	}
	
	public String getSurname ()
	{
		return cognome;
	}
}
