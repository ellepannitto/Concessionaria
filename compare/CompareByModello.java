package compare;

import java.util.*;

import misc.*;

public class CompareByModello implements Comparator<Auto>
{
	public int compare (Auto a, Auto b)
	{
		return a.getModello().compareTo(b.getModello());
	}
}
