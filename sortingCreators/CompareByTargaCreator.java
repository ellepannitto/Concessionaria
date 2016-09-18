package sortingCreators;

import java.util.*;

import misc.*;
import compare.*;
import sortingCreators.*;

public class CompareByTargaCreator extends SortingCreator
{
	
	public CompareByTargaCreator (SortingSelector ss)
	{
		super(ss);
	}
	
	public void call()
	{

		this.selettore.set_ordering_function (new CompareByTarga() );
		
	}
	
	public String getDescrizione ()
	{
		return "Ordina per targa";
	}
	
}
