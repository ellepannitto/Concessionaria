package callMe;

import misc.*;
import menu.*;

public class Remove implements CallMe
{
	private Concessionaria c;
	
	public Remove (Concessionaria c)
	{
		this.c = c;
	}
	
	public void call()
	{
		Auto a = Menu.get_auto();

		boolean success = c.remove_auto(a);
		
		if (!success)
			Menu.show_error("Auto non presente");
	}
	
	public String getDescrizione ()
	{
		return "Rimuovi";
	}
}
