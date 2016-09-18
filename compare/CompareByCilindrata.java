package compare;

import java.util.*;

import misc.*;

public class CompareByCilindrata implements Comparator<Auto>
{
	public int compare (Auto a, Auto b)
	{
		return a.getCilindrata() - b.getCilindrata();
	}
}
