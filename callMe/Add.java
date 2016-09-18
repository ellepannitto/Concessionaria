package callMe;

import misc.*;
import menu.*;
import exceptions.*;

public class Add implements CallMe
{
	private Concessionaria c;
	
	public Add (Concessionaria c)
	{
		this.c = c;
	}
	
	public void call()
	{
		Auto a = Menu.get_auto();

		try
		{
			c.add_auto(a);
		}
		catch (AutoException e)
		{
			System.err.println("Impossibile aggiungere auto - "+e);
		}
		
	}
	
	public String getDescrizione ()
	{
		return "Aggiungi";
	}
}
