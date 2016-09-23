package menu.menuItem.editors;

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
	
	
	public void selected(Menu m)
	{
		String t = m.get_string("targa");
		
		
		GregorianCalendar d = m.get_data("data");

		Auto a = new Auto(t, null, 0, null, 0);

		try
		{
			concessionaria.setNewDeliveryDate(a, d);
			m.show("Modifica registrata.\n"+a.toString());
		}
		catch (AutoException | DateException e)
		{
			m.show_error("Impossibile settare nuova data", e);
		}
		
		m.wait_input ();
		
	}
	
	public String getDescrizione()
	{
		return "Modifica una data di consegna";
	}
}
