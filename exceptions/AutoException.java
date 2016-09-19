package exceptions;


/**
 * Eccezione da lanciare in caso di problemi riguardanti le auto
 * */
public class AutoException extends Exception
{
	
	public AutoException (String message)
	{
		super(message);
	}
	
}
