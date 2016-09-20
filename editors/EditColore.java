package editors;

import java.util.*;

import menuItem.*;
import misc.*;
import menu.*;
import exceptions.*;

public class EditColore implements MenuItem
{
	private Concessionaria concessionaria;
	
	public EditColore (Concessionaria c)
	{
		this.concessionaria = c;
	}
	
	
	public void selected()
	{
		String t = Menu.get_string("targa");
		
		String col = Menu.get_string("nuovo colore");

		Auto a = new Auto(t, null, 0, null, 0);

		try
		{
			concessionaria.setNewColor(a, col);
		}
		catch (AutoException e)
		{
			System.err.println ("Impossibile modificare il colore - "+e);
		}
		
	}
	
	public String getDescrizione()
	{
		return "Modifica il colore";
	}
}
