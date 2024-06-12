package me.vault.game.exception;


import java.text.MessageFormat;


/**
 * Description
 *
 * @author Vincent Wolf
 * @version 1.0.0
 * @see
 * @since 05.06.2024
 */
public class InvalidAttributeModifierException extends Exception
{

	private static final String EXCEPTION_MESSAGE =
		"The provided attribute modifier is invalid, due to it being less than or equal to 0. (Provided modifier: {0," + " " + "number, long})";


	public InvalidAttributeModifierException (final double modifier)
	{
		super(MessageFormat.format(EXCEPTION_MESSAGE, modifier));
	}

}
