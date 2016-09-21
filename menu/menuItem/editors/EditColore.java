package menu.menuItems.editors;

import java.util.*;

import menu.menuItem.*;
import concessionaria.*;
import menu.*;
import exceptions.*;

public class EditColore implements MenuItem
{
	private Concessionaria concessionaria;
	
	public EditColore (Concessionaria c)
	{
		this.concessionaria = c;
	}
	
	
	public void selected(Menu m)
	{
		String t = m.get_string("targa");
		
		String col = m.get_string("nuovo colore");

		Auto a = new Auto(t, null, 0, null, 0);

		try
		{
			concessionaria.setNewColor(a, col);
		}
		catch (AutoException e)
		{
			m.show_error("Impossibile modificare il colore", e);
		}
		
	}
	
	public String getDescrizione()
	{
		return "Modifica il colore";
	}
}
