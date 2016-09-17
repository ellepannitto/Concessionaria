package callMe;

import java.util.*;

import misc.*;
import menu.*;
import main.*;

public class Exit implements CallMe
{
	
	public void call()
	{
		Main.esci = true;
	}
	
	public String getDescrizione ()
	{
		return "Esci";
	}
}
