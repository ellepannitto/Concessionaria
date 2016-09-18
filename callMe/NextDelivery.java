package callMe;

import java.util.*;

import misc.*;
import menu.*;

public class NextDelivery implements CallMe
{
	private Concessionaria c;
	
	public NextDelivery (Concessionaria c)
	{
		this.c = c;
	}
	
	public void call()
	{
		Auto a = c.getNextDelivery();

		System.out.println(a);
	}
	
	public String getDescrizione ()
	{
		return "Mostra prossima auto da consegnare";
	}
}
