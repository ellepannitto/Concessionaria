package callMe;

import java.util.*;

import misc.*;
import menu.*;

public class Edit implements CallMe
{
	private Concessionaria c;
	
	public Edit (Concessionaria c)
	{
		this.c = c;
	}
	
	public void call()
	{
		String t = Menu.get_string("targa");
		
		GregorianCalendar d = Menu.get_data("data");

		Auto a = new Auto(t, null, 0, null, 0);

		boolean success = c.setNewDeliveryDate(a, d);
		
		if (!success)
			Menu.show_error("Impossibile settare nuova data");
	}
	
	public String getDescrizione ()
	{
		return "Modifica data di consegna";
	}
}
