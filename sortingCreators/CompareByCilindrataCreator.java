package sortingCreators;

import java.util.*;

import misc.*;
import compare.*;
import sortingCreators.*;

public class CompareByCilindrataCreator extends SortingCreator
{
	
	public CompareByCilindrataCreator (SortingSelector ss)
	{
		super(ss);
	}
	
	public void call()
	{

		this.selettore.set_ordering_function (new CompareByCilindrata() );
		
	}
	
	public String getDescrizione ()
	{
		return "Ordina per cilindrata";
	}
	
}
