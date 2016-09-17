package callMe;

import java.util.*;

import misc.*;
import menu.*;
import filters.*;
import filterCreators.*;

public class Save implements CallMe
{
	private Concessionaria c;
	
	public Save (Concessionaria c)
	{
		this.c = c;
	}
	
	public void call()
	{
		String filename = Menu.get_string ("Inserisci nome del file");
		
		c.dump(filename);
	}
	
	public String getDescrizione ()
	{
		return "Salva l'archivio su un file";
	}
	
}
