package callMe;

import java.util.*;

import misc.*;
import menu.*;
import exceptions.*;

public class NextDelivery implements CallMe
{
	private Concessionaria c;
	
	public NextDelivery (Concessionaria c)
	{
		this.c = c;
	}
	
	public void call()
	{
		
		try
		{
			Auto a = c.getNextDelivery();
			System.out.println(a);
		}
		catch (AutoException e)
		{
			System.err.println("Impossibile mostrare la prossima consegna - "+e);
		}
			
	}
	
	public String getDescrizione ()
	{
		return "Mostra prossima auto da consegnare";
	}
}
