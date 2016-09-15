import java.util.*;
import java.util.regex.*;
import java.lang.*;

public class FilterByCustomerSurname implements Filterer<Auto>
{
	private Pattern p;
	private String s;
	
	
	public FilterByCustomerSurname (String pattern) 
	{
		this.p = Pattern.compile(pattern);
		this.s = pattern;
	}
	
	public boolean filter (Auto a)
	{
		boolean ret = false;
		
		if (a instanceof AutoNuova)
		{
			Cliente c = ((AutoNuova)a).getCostumer();
		
			String cognome = c.getSurname();
		
			Matcher m = p.matcher(cognome);
			boolean ret_regex = m.matches();
		
			boolean ret_substr = cognome.contains(s);
			
			ret = ret_regex || ret_substr;
		}
		
		return ret;
		
	}
	
}
