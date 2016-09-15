/**
 * 
 * 
 * 
 *
 * 
 * */

public class FilterByType implements Filterer<Auto>
{
	private boolean new_wanted;
	
	public FilterByType (boolean new_wanted)
	{
		this.new_wanted = new_wanted;
	}
	
	public boolean filter (Auto a)
	{
		return ( new_wanted && (a instanceof AutoNuova) ) || ( !new_wanted && (a instanceof AutoUsata) );
		
	}
	
}
