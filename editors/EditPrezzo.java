package editors;

import java.util.*;

import callMe.*;
import misc.*;
import menu.*;
import exceptions.*;

public class EditPrezzo implements CallMe
{
	private Concessionaria concessionaria;
	
	public EditPrezzo (Concessionaria c)
	{
		this.concessionaria = c;
	}
	
	
	public void call()
	{
		String t = Menu.get_string("targa");
		
		float prezzo = Menu.get_float("prezzo");

		Auto a = new Auto(t, null, 0, null, 0);

		try
		{
			concessionaria.setNewPrice(a, prezzo);
		}
		catch (AutoException e)
		{
			System.err.println ("Impossibile modificare il colore - "+e);
		}
		
	}
	
	public String getDescrizione()
	{
		return "Modifica il prezzo";
	}
}
