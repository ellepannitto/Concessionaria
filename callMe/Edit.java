package callMe;

import java.util.*;

import misc.*;
import menu.*;
import exceptions.*;

public class Edit implements CallMe
{
	private Concessionaria c;
	
	public Edit (Concessionaria c)
	{
		this.c = c;
	}
	
	public void call()
	{
		String t = Menu.get_string("targa");
		
		GregorianCalendar d = Menu.get_data("data");

		Auto a = new Auto(t, null, 0, null, 0);

		try
		{
			c.setNewDeliveryDate(a, d);
		}
		catch (AutoException | DateException e)
		{
			System.err.println ("Impossibile settare nuova data - "+e);
		}
	}
	
	public String getDescrizione ()
	{
		return "Modifica data di consegna";
	}
}
