package menu.menuItem.editors;

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
		Auto[] lista = concessionaria.list_autos();
		
		for (Auto a:lista)
		{
			m.show( a.toString() );
		}
		
		String t = m.get_string("Inserisci targa dell'auto da modificare");
		

		String col = m.get_string("Inserisci nuovo colore");

		Auto a = new Auto(t, null, 0, null, 0);

		try
		{
			concessionaria.setNewColor(a, col);
			m.show("Modifica registrata.\n");
			
		}
		catch (AutoException e)
		{
			m.show_error("Impossibile modificare il colore", e);
		}
		
		m.wait_input ();
		
	}
	
	public String getDescrizione()
	{
		return "Modifica il colore";
	}
}
