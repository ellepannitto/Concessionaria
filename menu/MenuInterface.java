package menu;

import java.util.*;
import java.text.DecimalFormatSymbols;

import concessionaria.*;
import menu.menuItem.*;
import filters.*;

public interface MenuInterface
{
	
	public void show_menu(List<MenuItem> options, String intestazione) ;
	
	
	public Auto get_auto (Concessionaria concessionaria);
	
	public String get_string(String message);
	
	public GregorianCalendar get_data(String message);

	public Cliente get_cliente();
	
	public void show_error (String error, Exception e);
	
	public String get_pattern(String message);
	
	public int get_int(String message);

	public float get_float(String message);
	
	public void show (String s);
		
	public void wait_input ();
	
}
