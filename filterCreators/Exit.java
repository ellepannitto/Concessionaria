package filterCreators;

import java.util.*;

import filters.*;
import callMe.*;
import misc.*;
import menu.*;

public class Exit implements CallMe
{
	private List<Filterer<Auto>> l;
	
	private boolean chiamato = false;
	
	public Exit (List<Filterer<Auto>> l)
	{
		this.l = l;
	}
	
	public void call()
	{			
		chiamato = true;
		
	}
	
	public String getDescrizione()
	{
		return "Ok, ho finito le scelte";
	}
	
	
	public boolean got_called ()
	{
		return this.chiamato;
	}
}
