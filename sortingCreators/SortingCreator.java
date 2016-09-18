package sortingCreators;

import java.util.*;

import callMe.*;
import compare.*;
import misc.*;

/**
 *
 * 
 * 
 * */
public abstract class SortingCreator implements CallMe
{
	protected SortingSelector selettore;
	
	public SortingCreator (SortingSelector ss)
	{
		this.selettore = ss;
	}
}
