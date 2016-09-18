package compare;

import java.util.*;

import misc.*;

public class CompareByPrezzo implements Comparator<Auto>
{
	public int compare (Auto a, Auto b)
	{
		float diff = a.getPrezzo() - b.getPrezzo();
		
		if (diff > 0)
		{
			return 1;
		}
		else if (diff == 0)
		{
			return 0;
		}
		else
		{
			return -1;
		}
	}
}
