public class FilterByKm implements Filterer<Auto>
{
	private int min_km;
	private int max_km;
	
	public FilterByKm (int min, int max) 
	{
		this.min_km = min;
		this.max_km = max;
		
	}
	
	public boolean filter (Auto a)
	{
		boolean ret = false;
		
		if (a instanceof AutoUsata)
		{
			int km = ((AutoUsata)a).getKilometers();
			
			ret = km >= this.min_km && km <= this.max_km;
		}
		
		return ret;
		
	}
	
}
