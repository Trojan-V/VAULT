package me.vault.game.utility.exception;


import me.vault.game.model.artifact.AttributeMultiplier;

import java.text.MessageFormat;


/**
 * This exception is thrown whenever an invalid instance of {@link AttributeMultiplier} is attempted to be created.
 * <br>
 * To see the requirements for a valid instance of {@link AttributeMultiplier}, check the validate() method within the
 * {@link AttributeMultiplier} class.
 *
 * @author Vincent Wolf, Lasse-Leander Hillen, Timothy Hoegen-Jupp, Alexander Goethel
 * @version 1.0.0
 * @see AttributeMultiplier
 * @since 05.06.2024
 */
public class InvalidAttributeMultiplierException extends Exception
{

	/**
	 * The message which can be retrieved from the exception instance by invoking
	 * {@link InvalidAttributeMultiplierException#getMessage()}. Usually, this message
	 * should be printed into the console or some other logging destination to inform the user about the exception.
	 */
	private static final String MESSAGE_PATTERN = "The provided attribute modifier is invalid, " +
	                                              "due to it being less than or equal to 0. (Provided modifier: {0, number, long})";


	/**
	 * This constructor takes the invalid modifier value as parameter and prints it into the console.
	 *
	 * @param modifier The modifier value which was invalid.
	 *
	 * @precondition The constructor of the exception gets called.
	 * @postcondition A new instance of the exception is created.
	 */
	public InvalidAttributeMultiplierException (final double modifier)
	{
		super(MessageFormat.format(MESSAGE_PATTERN, modifier));
	}

}
