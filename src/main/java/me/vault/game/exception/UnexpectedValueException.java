package me.vault.game.exception;


import me.vault.game.utility.loading.Config;

import java.text.MessageFormat;


/**
 * This exception is thrown when an unexpected value was received for some reason.
 * <br>
 * In this project, it's thrown by the {@link Config#updateConfigFromModels()} and {@link Config#updateModelsFromConfig()} method.
 *
 * @author Vincent Wolf
 * @version 1.0.0
 * @see Config#updateModelsFromConfig()
 * @see Config#updateConfigFromModels()
 * @see Exception
 * @since 30.07.2024
 */
public class UnexpectedValueException extends Exception
{
	/**
	 * The message which can be retrieved from the exception instance by invoking {@link UnexpectedValueException#getMessage()}.
	 * Usually, this message should be printed into the console or some other logging destination to inform the user about the exception.
	 */
	private static final String EXCEPTION_MESSAGE_PATTERN = "Unexpected value: {0}";


	/**
	 * Constructs an instance of this exception.
	 * <br>
	 * The 'unexpectedValue' parameter gets appended to the exception message, so it can be printed out.
	 *
	 * @param unexpectedValue The value that was unexpected. Has to be in {@link String} format, so it can be printed out.
	 */
	public UnexpectedValueException (final String unexpectedValue)
	{
		super(MessageFormat.format(EXCEPTION_MESSAGE_PATTERN, unexpectedValue));
	}
}
