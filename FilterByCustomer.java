import java.util.*;
import java.util.regex.*;
import java.lang.*;

public class FilterByCustomer implements Filterer<Auto>
{
	private Pattern p_surname;
	private String s_surname;

	private Pattern p_name;
	private String s_name;
	
	
	public FilterByCustomer (String pattern) 
	{
		this.p_surname = Pattern.compile(pattern);
		this.s_surname = pattern;
	}

	public FilterByCustomer (String surname, String name) 
	{
		this.p_surname = Pattern.compile(surname);
		this.s_surname = surname;
		
		this.p_name = Pattern.compile(name);
		this.s_name = name;
	}
	
	public boolean filter (Auto a)
	{
		boolean ret = false;
		
		if (a instanceof AutoNuova)
		{
			Cliente c = ((AutoNuova)a).getCostumer();
		
			String cognome = c.getSurname();
		
			Matcher m = p_surname.matcher(cognome);
			boolean ret_regex = m.find();
		
			boolean ret_substr = cognome.toLowerCase().contains(s_surname.toLowerCase());
			
			ret = ret_regex || ret_substr;
			
			if (s_name != null)
			{
				String nome = c.getName();
				
				m = p_name.matcher(nome);
				ret_regex = m.find();
		
				ret_substr = nome.toLowerCase().contains(s_name.toLowerCase());
			
				ret = ret && (ret_regex || ret_substr);
			}
		}
		
		return ret;
		
	}
	
}
