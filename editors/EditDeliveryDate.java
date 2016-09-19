package editors;

import java.util.*;

import callMe.*;
import misc.*;
import menu.*;
import exceptions.*;

public class EditDeliveryDate implements CallMe
{
	private Concessionaria concessionaria;
	
	public EditDeliveryDate (Concessionaria c)
	{
		this.concessionaria = c;
	}
	
	
	public void call()
	{
		String t = Menu.get_string("targa");
		
		GregorianCalendar d = Menu.get_data("data");

		Auto a = new Auto(t, null, 0, null, 0);

		try
		{
			concessionaria.setNewDeliveryDate(a, d);
		}
		catch (AutoException | DateException e)
		{
			System.err.println ("Impossibile settare nuova data - "+e);
		}
		
	}
	
	public String getDescrizione()
	{
		return "Modifica una data di consegna";
	}
}
