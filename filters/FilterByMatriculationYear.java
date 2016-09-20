package filters;

import concessionaria.*;

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
			ret = true;
			
			int y = ((AutoUsata)a).getMatriculationYear();
			
			if (this.min_year > 0)
				ret = y >= this.min_year;

			if (this.max_year > 0)
				ret = ret && y <= this.max_year;
			
			
		}
		
		return ret;
		
	}
	
}
