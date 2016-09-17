package misc;

import java.util.*;

import filters.*;

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
	
	public boolean setNewDeliveryDate (Auto a, Date data)
	{
		int presente = archivio.indexOf(a);
		
		Auto old = null;
		
		if (presente > -1)
		{
			old = archivio.get(presente);
			
			if (old instanceof AutoNuova)
			{
				((AutoNuova)old).setNewDate(data);
			}
		}
			
		return presente > -1 && old instanceof AutoNuova;
	}
	
	public Auto getNextDelivery()
	{
		Date now = new Date();
		
		long min = -1;
		Auto next = null;
		
		for (Auto a : archivio)
		{
			if (a instanceof AutoNuova )
			{
				Date consegna = ((AutoNuova)a).getDeliveryDate();
				
				long diff = consegna.getTime() - now.getTime();
				
				if (min < 0)
				{
					min = diff;
					next = archivio.get( archivio.indexOf(a) );
				}
				else
				{
					if (diff < min)
					{
						min = diff;
						next = archivio.get( archivio.indexOf(a) );
					}
				}
				
			}
		}
		
		return next;
	}
	
}
