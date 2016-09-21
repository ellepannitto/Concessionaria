package menu.menuItems.editors;

import java.util.*;

import menu.menuItem.*;
import concessionaria.*;
import menu.*;
import exceptions.*;

public class EditPrezzo implements MenuItem
{
	private Concessionaria concessionaria;
	
	public EditPrezzo (Concessionaria c)
	{
		this.concessionaria = c;
	}
	
	
	public void selected(Menu m)
	{
		String t = m.get_string("targa");
		
		float prezzo = m.get_float("prezzo");

		Auto a = new Auto(t, null, 0, null, 0);

		try
		{
			concessionaria.setNewPrice(a, prezzo);
		}
		catch (AutoException e)
		{
			m.show_error ("Impossibile modificare il colore", e);
		}
		
	}
	
	public String getDescrizione()
	{
		return "Modifica il prezzo";
	}
}
