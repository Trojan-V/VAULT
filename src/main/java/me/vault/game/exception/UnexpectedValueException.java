package me.vault.game.exception;


import java.text.MessageFormat;


public class UnexpectedValueException extends Exception
{

	private static final String EXCEPTION_MESSAGE = "Unexpected value: {0}";


	public UnexpectedValueException (final String unexpectedValue)
	{
		super(MessageFormat.format(EXCEPTION_MESSAGE, unexpectedValue));
	}

}
