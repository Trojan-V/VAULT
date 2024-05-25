package me.vault.vaultgame.exception;


import java.text.MessageFormat;
import java.util.Map.Entry;


public class InvalidMapEntryException extends Exception
{
	private static final String EXCEPTION_MESSAGE = "The map entry is invalid.";


	private static final String MESSAGE_APPENDIX = " Key: {0}; Value: {1}";


	public InvalidMapEntryException ()
	{
		super(EXCEPTION_MESSAGE);
	}


	public <K, V> InvalidMapEntryException (final Entry<K, V> entry)
	{
		super(EXCEPTION_MESSAGE + MessageFormat.format(MESSAGE_APPENDIX, entry.getKey(), entry.getValue()));
	}
}
