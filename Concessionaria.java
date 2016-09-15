import java.util.*;

/**
 * 
 * 
 * 
 * 
 * 
 * */

public class Concessionaria
{
	private Vector<Auto> archivio = new Vector<Auto>();
	
	private Vector<Cliente> clienti_registrati;

	public boolean add_auto (Auto auto)
	{
		boolean non_presente = !archivio.contains(auto);
		
		if (non_presente)
			archivio.add(auto);
			
		return non_presente;
	}
	
	public boolean remove_auto (Auto auto)
	{
		boolean presente = archivio.contains(auto);
		
		if (presente)
			archivio.remove (auto);
			
		return presente;
	}
	
	public Auto[] list_autos (Comparator<Auto> o)
	{
		Auto[] sorted_list = archivio.toArray( new Auto[archivio.size()] );
		
		Arrays.sort(sorted_list, o);
		
		return sorted_list;
	}
	
	public Auto[] filter_autos (Filterer<Auto> o)
	{
		Vector<Auto> return_list = new Vector<Auto>();
		
		
		for (Auto a: archivio)
		{
			if ( o.filter(a) )
				return_list.add( a );
		}
		
		return return_list.toArray( new Auto[return_list.size()] );
		
		
	}
	
	public boolean setNewDeliveryDate (Auto a, Data data)
	{
		int presente = archivio.indexOf(a);
		
		if (presente > -1)
		{
			Auto old = archivio.get(presente);
			old.setNewDate(data);
		}
			
		return presente > -1;
	}
	
}
