package me.vault.game.currency;


import me.vault.game.exception.InvalidMapEntryException;
import me.vault.game.utility.logging.Logger;
import me.vault.game.utility.struct.ValidatedEntriesHashMap;
import me.vault.game.utility.struct.ValidatedEntriesHashMap.Entry;

import java.text.MessageFormat;
import java.util.HashMap;

import static me.vault.game.utility.constant.LoggingConstants.Currency.EXECUTION_NOT_POSSIBLE_ANYMORE_MSG;
import static me.vault.game.utility.constant.MiscConstants.ERROR_EXIT_CODE;
import static me.vault.game.utility.logging.ILogger.Level.ERROR;


public class CurrencyTransaction
{
	public static final CurrencyTransaction EMPTY = new CurrencyTransaction(0, 0, 0, 0, 0);


	/**
	 * The pattern that is used to have a formatted output in the {@link CurrencyTransaction#toString()} method.
	 */
	private static final String STRING_PATTERN = "CurrencyTransaction[amountMap = {0}]";


	/**
	 * The {@link HashMap} which contains the numbers of currencies that are changed by the transaction. The keys of
	 * the
	 * {@code HashMap} represent the {@link Currency} enum values and the values of the {@code HashMap} the
	 * corresponding amounts of each {@code Currency} key.
	 */
	private final ValidatedEntriesHashMap<Currency, Integer> currencyAmountMap = new ValidatedEntriesHashMap<>();


	private static final Logger LOGGER = new Logger(CurrencyTransaction.class.getSimpleName());


	@SafeVarargs
	public CurrencyTransaction (final Entry<Currency, Integer>... currencyAmountEntries)
	{
		for (final Entry<Currency, Integer> currencyAmountMapEntry : currencyAmountEntries)
		{
			this.currencyAmountMap.put(currencyAmountMapEntry);
		}
	}


	public CurrencyTransaction (final int steelAmount, final int compositeAmount, final int scienceAmount,
		final int foodAmount, final int energyAmount)
	{
		try
		{
			this.currencyAmountMap.put(new Entry<>(Currency.STEEL, steelAmount));
			this.currencyAmountMap.put(new Entry<>(Currency.COMPOSITE, compositeAmount));
			this.currencyAmountMap.put(new Entry<>(Currency.SCIENCE, scienceAmount));
			this.currencyAmountMap.put(new Entry<>(Currency.FOOD_RATION, foodAmount));
			this.currencyAmountMap.put(new Entry<>(Currency.ENERGY_CREDIT, energyAmount));
		}
		catch (final InvalidMapEntryException e)
		{
			LOGGER.log(ERROR, e.getMessage());
			LOGGER.log(ERROR, EXECUTION_NOT_POSSIBLE_ANYMORE_MSG);
			System.exit(ERROR_EXIT_CODE);
		}
	}


	public ValidatedEntriesHashMap<Currency, Integer> getCurrencyAmountMap ()
	{
		return this.currencyAmountMap;
	}


	public int getAbsoluteAmount (final Currency currency)
	{
		return Math.abs(this.currencyAmountMap.get(currency));
	}


	public int getAmount (final Currency currency)
	{
		return this.currencyAmountMap.get(currency);
	}


	/**
	 * Overrides the {@link Object#toString()} method, that returns a {@link String}, which represents the object with
	 * its properties.
	 *
	 * @return A {@link String} value, which represents the object with its properties.
	 */
	@Override
	public String toString ()
	{
		return MessageFormat.format(STRING_PATTERN, this.currencyAmountMap.toString());
	}

}
