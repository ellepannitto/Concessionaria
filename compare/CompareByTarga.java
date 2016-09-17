package compare;

import java.util.*;

import misc.*;

public class CompareByTarga implements Comparator<Auto>
{
	public int compare (Auto a, Auto b)
	{
		return a.getTarga().compareTo(b.getTarga());
	}
}
