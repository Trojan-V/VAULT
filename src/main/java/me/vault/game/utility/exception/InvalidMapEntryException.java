package me.vault.game.utility.exception;


import me.vault.game.utility.datatypes.ValidatedEntriesHashMap;

import java.text.MessageFormat;
import java.util.Map.Entry;


/**
 * This exception is thrown when an invalid map entry was entered into the {@link ValidatedEntriesHashMap} data structure.
 * <br>
 * Only entries that contain valid data for both the key and the value can be entered.
 *
 * @author Vincent Wolf, Lasse-Leander Hillen, Timothy Hoegen-Jupp, Alexander Goethel
 * @version 1.0.0
 * @see ValidatedEntriesHashMap
 * @since 28.05.2024
 */
public class InvalidMapEntryException extends Exception
{

	/**
	 * The message which can be retrieved from the exception instance by invoking {@link InvalidMapEntryException#getMessage()}. Usually, this message
	 * should be printed into the console or some other logging destination to inform the user about the exception.
	 */
	private static final String MESSAGE = "The map entry is invalid.";

	/**
	 * If the invalid entry was provided within the constructor of this exception {@code throw new InvalidMapEntryException(Entry<K, V> entry)}, this
	 * appendix is appended as message suffix to the default {@link InvalidMapEntryException#MESSAGE}.
	 * <br>
	 *
	 * @see InvalidMapEntryException#InvalidMapEntryException(Entry)
	 */
	private static final String MESSAGE_APPENDIX_PATTERN = " Key: {0}; Value: {1}";


	/**
	 * The default constructor of the exception. Constructs a new instance of this exception and provides the default
	 * {@link InvalidMapEntryException#MESSAGE}.
	 *
	 * @precondition The constructor of the exception gets called.
	 * @postcondition A new instance of the exception is created.
	 */
	public InvalidMapEntryException ()
	{
		super(MESSAGE);
	}


	/**
	 * This constructor takes the entry which was invalid as parameter and extracts the key and the value from it. Then, the key and value of this
	 * invalid entry is shown to the user in a human-readable format ({@link String}.
	 *
	 * @param entry The entry which was detected as invalid.
	 * @param <K>   The data type of the entry's key.
	 * @param <V>   The data type of the entry's value.
	 *
	 * @precondition The constructor of the exception gets called and a valid {@link ValidatedEntriesHashMap.Entry} is passed.
	 * @postcondition A new instance of the exception is created.
	 */
	public <K, V> InvalidMapEntryException (final Entry<K, V> entry)
	{
		super(MESSAGE + MessageFormat.format(MESSAGE_APPENDIX_PATTERN, entry.getKey(), entry.getValue()));
	}

}
