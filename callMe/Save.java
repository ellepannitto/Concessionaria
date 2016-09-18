package callMe;

import java.util.*;
import java.io.*;

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
		
		
		try
		{
			c.dump(filename);
		}
		catch (IOException e)
		{
			System.err.println("Impossibile salvare l'archivio su file - "+e);
		}
		
	}
	
	public String getDescrizione ()
	{
		return "Salva l'archivio su un file";
	}
	
}
