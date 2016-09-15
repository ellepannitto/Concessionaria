public class FilterByMatriculationYear implements Filterer<Auto>
{
	private int min_year;
	private int max_year;
	
	public FilterByMatriculationYear (int min, int max) 
	{
		this.min_year = min;
		this.max_year = max;
		
	}
	
	public boolean filter (Auto a)
	{
		boolean ret = false;
		
		if (a instanceof AutoUsata)
		{
			int y = ((AutoUsata)a).getMatriculationYear();
			
			ret = y >= this.min_year && y <= this.max_year;
		}
		
		return ret;
		
	}
	
}
