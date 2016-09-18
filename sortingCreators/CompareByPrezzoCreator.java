package sortingCreators;

import java.util.*;

import misc.*;
import compare.*;
import sortingCreators.*;

public class CompareByPrezzoCreator extends SortingCreator
{
	
	public CompareByPrezzoCreator (SortingSelector ss)
	{
		super(ss);
	}
	
	public void call()
	{

		this.selettore.set_ordering_function (new CompareByModello() );
		
	}
	
	public String getDescrizione ()
	{
		return "Ordina per prezzo";
	}
	
}
