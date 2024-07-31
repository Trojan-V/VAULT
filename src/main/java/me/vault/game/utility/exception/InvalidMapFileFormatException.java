package me.vault.game.utility.exception;


/**
 * This exception is thrown when the map file format is invalid.
 *
 * @author Vincent Wolf
 * @version 1.0.0
 * @see me.vault.game.utility.loading.ResourceLoader
 * @since 31.07.2024
 */
public class InvalidMapFileFormatException extends Exception
{
	/**
	 * The message which can be retrieved from the exception instance by invoking {@link NotAFigureException#getMessage()}.
	 * Usually, this message should be printed into the console or some other logging destination to inform the user about the exception.
	 */
	private static final String MESSAGE = "The map file format is invalid.";


	/**
	 * The default constructor of the exception. Constructs a new instance of this exception and provides the default
	 * {@link InvalidMapFileFormatException#MESSAGE}.
	 *
	 * @precondition The constructor of the exception gets called.
	 * @postcondition A new instance of the exception is created.
	 */
	public InvalidMapFileFormatException ()
	{
		super(MESSAGE);
	}
}
