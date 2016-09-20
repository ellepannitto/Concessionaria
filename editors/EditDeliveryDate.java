package editors;

import java.util.*;

import menu.menuItem.*;
import concessionaria.*;
import menu.*;
import exceptions.*;

public class EditDeliveryDate implements MenuItem
{
	private Concessionaria concessionaria;
	
	public EditDeliveryDate (Concessionaria c)
	{
		this.concessionaria = c;
	}
	
	
	public void selected()
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
