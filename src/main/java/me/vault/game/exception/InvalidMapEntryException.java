package me.vault.game.exception;


import java.text.MessageFormat;
import java.util.Map.Entry;


/**
 * This exception is thrown when an invalid map entry was entered into the
 * {@link me.vault.game.model.citybuilding.ValidatedEntriesHashMap} data structure.
 * <br>
 * Only entries that contain valid data for both the key and the value can be entered.
 *
 * @author Vincent Wolf
 * @version 1.0.0
 * @see me.vault.game.model.citybuilding.ValidatedEntriesHashMap
 * @since 28.05.2024
 */
public class InvalidMapEntryException extends Exception
{
	/**
	 * The message which can be retrieved from the exception instance by invoking
	 * {@link InvalidMapEntryException#getMessage()}. Usually, this message should be printed into the console or some
	 * other logging destination to inform the user about the exception.
	 */
	private static final String EXCEPTION_MESSAGE = "The map entry is invalid.";


	/**
	 * If the invalid entry was provided within the constructor of this exception {@code throw new
	 * InvalidMapEntryException(Entry<K, V> entry)}, this appendix will be appended as message suffix to the default
	 * {@link InvalidMapEntryException#EXCEPTION_MESSAGE}.
	 * <br>
	 *
	 * @see InvalidMapEntryException#InvalidMapEntryException(Entry)
	 */
	private static final String MESSAGE_APPENDIX = " Key: {0}; Value: {1}";


	/**
	 * The default constructor of the exception.
	 * Constructs a new instance of this exception and provides the default
	 * {@link InvalidMapEntryException#EXCEPTION_MESSAGE}.
	 */
	public InvalidMapEntryException ()
	{
		super(EXCEPTION_MESSAGE);
	}


	/**
	 * This constructor takes the entry which was invalid as parameter and extracts the key and the value from it.
	 * Then, the key and value of this invalid entry is shown to the user in a human-readable format ({@link String}.
	 *
	 * @param entry The entry which was detected as invalid.
	 * @param <K>   The data type of the entry's key.
	 * @param <V>   The data type of the entry's value.
	 */
	public <K, V> InvalidMapEntryException (final Entry<K, V> entry)
	{
		super(EXCEPTION_MESSAGE + MessageFormat.format(MESSAGE_APPENDIX, entry.getKey(), entry.getValue()));
	}
}
