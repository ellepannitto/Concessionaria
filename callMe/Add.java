package callMe;

import misc.*;
import menu.*;

public class Add implements CallMe
{
	private Concessionaria c;
	
	public Add (Concessionaria c)
	{
		this.c = c;
	}
	
	public void call()
	{
		Auto a = Menu.get_auto();

		boolean success = c.add_auto(a);
		
		if (!success)
			Menu.show_error("Auto già presente");
	}
	
	public String getDescrizione ()
	{
		return "Aggiungi";
	}
}
