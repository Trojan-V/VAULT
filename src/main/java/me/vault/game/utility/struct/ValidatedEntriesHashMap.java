package me.vault.game.utility.struct;


import me.vault.game.exception.InvalidMapEntryException;
import me.vault.game.model.artifact.Artifact;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;


/**
 * This class is simply a more restricted Hash{@link HashMap} that validates that each entry's key and value isn't null.
 *
 * @param <K> The datatype of the key.
 * @param <V> The datatype of the key's value.
 *
 * @author Vincent Wolf
 * @version 1.0.0
 * @see HashMap
 * @since 19.06.2024
 */
public class ValidatedEntriesHashMap<K, V> extends HashMap<K, V>
{

	/**
	 * The pattern used to create the string which describes the class in a human-readable format.
	 */
	private static final String TO_STRING_PATTERN = "[{0}={1}]; ";


	/**
	 * Inserts the supplied entry into this validated HashMap.
	 *
	 * @param entry The entry that's about to be inserted.
	 *
	 * @return The value of the inserted entry.
	 */
	public V put (final Entry<K, V> entry)
	{
		return super.put(entry.getKey(), entry.getValue());
	}


	/**
	 * Returns a string representation of this validated {@link HashMap} including each entry in the map.
	 *
	 * @return A string representation of this validated {@link HashMap}.
	 */
	@Override
	public String toString ()
	{
		final StringBuilder builder = new StringBuilder();
		for (final Map.Entry<K, V> entry : this.entrySet())
		{
			builder.append(MessageFormat.format(TO_STRING_PATTERN, entry.getKey(), entry.getValue()));
		}
		return builder.toString();
	}


	/**
	 * This class is a generic model for an entry in the validated {@link HashMap}.
	 * <br>
	 * Each entry runs the validate() method in its constructor to ensure neither the key nor the value of the key
	 * are equal to null.
	 *
	 * @author Vincent Wolf
	 * @version 1.0.0
	 * @see ValidatedEntriesHashMap
	 * @since 19.06.2024
	 */
	public static class Entry<E, F> implements Map.Entry<E, F>
	{
		/**
		 * The {@link MessageFormat} pattern, which is used, when the {@link Artifact#toString()} is
		 * called.
		 */
		private static final String TO_STRING_PATTERN = "Entry'{'key={0}, value={1}'}'";


		/**
		 * The key of the entry.
		 */
		private final E key;


		/**
		 * The value of the entry.
		 */
		private F value;


		/**
		 * Constructs an instance of the entry, running additional validation logic to ensure neither the key nor the
		 * value of the key are equal to null.
		 *
		 * @param key   The key of the entry.
		 * @param value The value of the entry.
		 *
		 * @exception InvalidMapEntryException When the key or the value of the key is equal to null.
		 */
		public Entry (final E key, final F value) throws InvalidMapEntryException
		{
			this.key = key;
			this.value = value;
			this.validate();
		}


		/**
		 * Validates that neither the key nor the value of the key is equal to null.
		 *
		 * @exception InvalidMapEntryException When the key or the value of the key is equal to null.
		 */
		private void validate () throws InvalidMapEntryException
		{
			if (this.key == null || this.value == null)
			{
				throw new InvalidMapEntryException(this);
			}
		}


		/**
		 * {@inheritDoc}
		 */
		@Override
		public E getKey ()
		{
			return this.key;
		}


		/**
		 * {@inheritDoc}
		 */
		@Override
		public F getValue ()
		{
			return this.value;
		}


		/**
		 * {@inheritDoc}
		 */
		@Override
		public F setValue (final F value)
		{
			this.value = value;
			return this.value;
		}


		/**
		 * Builds a formatted {@link String}, which represents the object, and it's current state using the
		 * {@link Entry#TO_STRING_PATTERN}.
		 *
		 * @return A {@link String} which has been formatted in the {@link Entry#TO_STRING_PATTERN}.
		 * @precondition The {@link Entry#TO_STRING_PATTERN} is {@code != null}.
		 * @postcondition The method returned a {@link String} which represents the object.
		 */
		@Override
		public String toString ()
		{
			return MessageFormat.format(TO_STRING_PATTERN, this.key.toString(), this.value.toString());
		}
	}

}
