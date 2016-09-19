package exceptions;


/**
 * Eccezione da lanciare in caso di problemi riguardanti le date
 * */
public class DateException extends Exception
{
	
	public DateException (String message)
	{
		super(message);
	}
	
}
