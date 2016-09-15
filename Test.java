import java.util.*;

public class Test
{
	
	public static void main (String[] args)
	{
		Concessionaria c = new Concessionaria();
		
		AutoNuova uno = new AutoNuova("BC911LV", "Lancia Y", 1200, "cremisi", 42, new Date(2016, 12, 3), new Cliente("Lucio", "Messina", "LCCMSS"));
		AutoUsata due = new AutoUsata("BD500OG", "Nissan Micra", 1000, "blu", 34, 2005, 300000);
		
		c.add_auto(uno);
		c.add_auto(due);
		
		uno = new AutoNuova("AA502DX", "Lancia Y", 1800, "rossa", 55, new Date(2012, 10, 25), new Cliente("Ludo", "Pannitto", "LPPPNTT"));
		due = new AutoUsata("TE001AA", "Nissan Micra", 700, "blu", 69999, 2009, 350000);
		c.add_auto(uno);
		c.add_auto(due);

		Auto[] prima_lista = c.list_autos( new CompareByTarga() );
		
		for (int i=0; i<prima_lista.length; i++)
		{
			System.out.println(prima_lista[i]);
		}
		
		System.out.println("--- filtrati ----");
	
		List <Filterer<Auto>> filters_list = new LinkedList <Filterer<Auto>> ();
		filters_list.add ( new FilterByMatriculationYear (2000, 2100) );
		filters_list.add ( new FilterByKm (320000,400000) );
		prima_lista = c.filter_autos ( new MultipleFiltererAuto ( filters_list  ));
		
		for (int i=0; i<prima_lista.length; i++)
		{
			System.out.println(prima_lista[i]);
		}

		System.out.println("--- filtrati ----");
	

		prima_lista = c.filter_autos ( new FilterByCustomerSurname ( "mess"  ));
		
		for (int i=0; i<prima_lista.length; i++)
		{
			System.out.println(prima_lista[i]);
		}
		
	}
}
