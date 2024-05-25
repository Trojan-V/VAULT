package me.vault.vaultgame.model.citybuilding;


import me.vault.vaultgame.exception.InvalidMapEntryException;

import java.util.HashMap;
import java.util.Map;


public class ValidatedEntriesHashMap<E, F> extends HashMap<E, F>
{
	public F put (final Entry<E, F> entry)
	{
		return super.put(entry.getKey(), entry.getValue());
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
