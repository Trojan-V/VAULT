package me.vault.game.utility.struct;


import me.vault.game.exception.InvalidMapEntryException;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;


public class ValidatedEntriesHashMap<E, F> extends HashMap<E, F>
{
	private static final String TO_STRING_PATTERN = "[({0}) key = {1}; value = {2}]; ";


	public F put (final Entry<E, F> entry)
	{
		return super.put(entry.getKey(), entry.getValue());
	}


	@Override
	public String toString ()
	{
		final StringBuilder builder = new StringBuilder();
		int i = 0;
		for (final Map.Entry<E, F> entry : this.entrySet())
		{
			builder.append(MessageFormat.format(TO_STRING_PATTERN, i, entry.getKey(), entry.getValue()));
			i++;
		}
		return builder.toString();
	}


	public static class Entry<E, F> implements Map.Entry<E, F>
	{
		private final E key;


		private F value;


		public Entry (final E key, final F value) throws InvalidMapEntryException
		{
			this.key = key;
			this.value = value;
			this.validate();
		}


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
	}
}
