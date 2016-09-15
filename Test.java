import java.util.*;

public class Test
{
	
	public static void main (String[] args)
	{
		Concessionaria c = new Concessionaria();
		
		AutoNuova uno = new AutoNuova("BC911LV", "Lancia Y", 1200, "cremisi", 42, new Date(2016, 12, 3), new Cliente("Lucio", "Messina", "LCCMSS"));
		AutoUsata due = new AutoUsata("BD500OG", "Nissan Micra", 1000, "blu", 34, 1999, 300000);
		
		c.add_auto(uno);
		c.add_auto(due);
		
		Auto[] prima_lista = c.list_autos( new CompareByTarga() );
		
		for (int i=0; i<prima_lista.length; i++)
		{
			System.out.println(prima_lista[i]);
		}
		
		
	}
}
