package me.vault.vaultgame.model.currency;

import me.vault.vaultgame.exception.InvalidMapEntryException;
import me.vault.vaultgame.model.citybuilding.ValidatedEntriesHashMap;
import me.vault.vaultgame.model.citybuilding.ValidatedEntriesHashMap.Entry;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.logging.Logger;

public class CurrencyTransaction
{
	/**
	 * The pattern that is used to have a formatted output in the {@link CurrencyTransaction#toString()} method.
	 */
	private static final String STRING_PATTERN = "CurrencyTransaction [ amountMap = {0} ]";

	private static final Logger LOGGER = Logger.getLogger(CurrencyTransaction.class.getName());

	/**
	 * The {@link HashMap} which contains the numbers of currencies that are changed by the transaction. The keys of the {@code HashMap} represent the
	 * {@link Currency} enum values and the values of the {@code HashMap} the corresponding amounts of each {@code Currency} key.
	 */
	private final ValidatedEntriesHashMap<Currency, Integer> currencyAmountMap = new ValidatedEntriesHashMap<>();


	@SafeVarargs
	public CurrencyTransaction (final Entry<Currency, Integer>... currencyAmountEntries)
	{
		for (final Entry<Currency, Integer> currencyAmountMapEntry : currencyAmountEntries)
		{
			this.currencyAmountMap.put(currencyAmountMapEntry);
		}
	}


	public static CurrencyTransaction factory (final int steelAmount, final int compositeAmount, final int scienceAmount, final int foodAmount,
			final int energyAmount) throws InvalidMapEntryException
	{
		return new CurrencyTransaction(new Entry<>(Currency.STEEL, steelAmount), new Entry<>(Currency.COMPOSITE, compositeAmount),
		                               new Entry<>(Currency.SCIENCE, scienceAmount), new Entry<>(Currency.FOOD_RATION, foodAmount),
		                               new Entry<>(Currency.ENERGY_CREDIT, energyAmount));
	}


	public ValidatedEntriesHashMap<Currency, Integer> getCurrencyAmountMap ()
	{
		return this.currencyAmountMap;
	}


	public int getAmount (final Currency currency)
	{
		return this.currencyAmountMap.get(currency);
	}


	/**
	 * Overrides the {@link Object#toString()} method, that returns a {@link String}, which represents the object with its properties.
	 *
	 * @return A {@link String} value, which represents the object with its properties.
	 */
	@Override
	public String toString ()
	{
		return MessageFormat.format(STRING_PATTERN, this.currencyAmountMap.toString());
	}

}
