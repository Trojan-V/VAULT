package me.vault.game.model.currency;


import me.vault.game.exception.InvalidMapEntryException;
import me.vault.game.interfaces.Upgradable;
import me.vault.game.model.artifact.Artifact;
import me.vault.game.model.building.CityBuilding;
import me.vault.game.utility.logging.ILogger;
import me.vault.game.utility.logging.Logger;
import me.vault.game.utility.struct.ValidatedEntriesHashMap;
import me.vault.game.utility.struct.ValidatedEntriesHashMap.Entry;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import static me.vault.game.utility.constant.CharacterConstants.*;
import static me.vault.game.utility.constant.LoggingConstants.EXECUTION_NOT_POSSIBLE_ANYMORE;
import static me.vault.game.utility.constant.MiscConstants.ERROR_EXIT_CODE;
import static me.vault.game.utility.logging.ILogger.Level.ERROR;


/**
 * This class is used to create the currency transactions that keep the information how many resources of each type
 * are required for certain upgrades of {@link Artifact}s, {@link CityBuilding}s and other
 * {@link Upgradable}s.
 *
 * @author Vincent Wolf, Lasse-Leander Hillen, Timothy Hoegen-Jupp, Alexander Goethel
 * @version 1.0.0
 * @see Currency
 * @see Logger
 * @since 19.06.2024
 */
public class CurrencyTransaction
{

	/**
	 * A constant for an empty currency transaction instance. This constant is solely for convenience to create empty transactions.
	 */
	public static final CurrencyTransaction EMPTY = new CurrencyTransaction(0, 0, 0, 0, 0);


	/**
	 * The {@link Logger} object for this class used for writing to the console.
	 */
	private static final ILogger LOGGER = new Logger(CurrencyTransaction.class.getSimpleName());


	/**
	 * The pattern used to create the string which describes the class in a human-readable format.
	 */
	private static final String TO_STRING_PATTERN = "CurrencyTransaction[{0}]";


	/**
	 * The {@link HashMap} which contains the numbers of currencies that are changed by the transaction. The keys of
	 * the {@code HashMap} represent the {@link Currency} enum values and the values of the {@code HashMap} the corresponding
	 * amounts of each {@code Currency} key.
	 */
	private final ValidatedEntriesHashMap<Currency, Integer> currencyAmountMap = new ValidatedEntriesHashMap<>();


	/**
	 * Constructs an instance of this class.
	 * <br>
	 * This constructor takes an ellipse of {@link ValidatedEntriesHashMap.Entry} as parameter and applies the values
	 * of this ellipse to the internal data structure.
	 * <br>
	 * This method is annotated with the {@link SafeVarargs} annotation, which shows that the operations that are
	 * invoked on the varargs parameter have been reviewed and are safe.
	 *
	 * @param currencyAmountEntries The entries which are used to create the currency transaction.
	 *
	 * @precondition The varargs arguments are of the type Entry<Currency, Integer> and contain only valid Currencies and values.
	 * @postcondition A new instance of CurrencyTransaction has been initialized.
	 */
	@SafeVarargs
	public CurrencyTransaction (final Entry<Currency, Integer>... currencyAmountEntries)
	{
		for (final Entry<Currency, Integer> currencyAmountMapEntry : currencyAmountEntries)
		{
			this.currencyAmountMap.put(currencyAmountMapEntry);
		}
	}


	/**
	 * Constructs an instance of this class.
	 *
	 * @param steelAmount     The amount of steel the transaction consists of.
	 * @param compositeAmount The amount of composite the transaction consists of.
	 * @param scienceAmount   The amount of science the transaction consists of.
	 * @param foodAmount      The amount of food the transaction consists of.
	 * @param energyAmount    The amount of energy the transaction consists of.
	 *
	 * @precondition The passed parameters are only integers and contain the numbers of the currencies in the correct order.
	 * @postcondition A new instance of CurrencyTransaction has been initialized.
	 */
	public CurrencyTransaction (final int steelAmount, final int compositeAmount, final int scienceAmount, final int foodAmount, final int energyAmount)
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
			LOGGER.log(ERROR, EXECUTION_NOT_POSSIBLE_ANYMORE);
			System.exit(ERROR_EXIT_CODE);
		}
	}


	/**
	 * Returns the absolute amount of the currency supplied as parameter, which just means that the positive amount of
	 * the currency is returned.
	 *
	 * @param currency The currency whose absolute amount should be returned.
	 *
	 * @return The absolute amount of the currency.
	 *
	 * @precondition The amount attribute within the instance is set, and a valid Currency is passed into the method.
	 * @postcondition The amountProperty attribute of the Currency instance was returned.
	 */
	public int getAbsoluteAmount (final Currency currency)
	{
		return Math.abs(this.currencyAmountMap.get(currency));
	}


	/**
	 * Returns the amount of the currency supplied as parameter.
	 *
	 * @param currency The currency whose amount should be returned.
	 *
	 * @return The amount of the currency.
	 */
	public int getAmount (final Currency currency)
	{
		return this.currencyAmountMap.get(currency);
	}


	/**
	 * Builds a formatted {@link String}, which represents the object, and it's current state.
	 *
	 * @return A {@link String} which represents the object, and it's current state.
	 *
	 * @precondition The object has been initialized.
	 * @postcondition The method returned a {@link String} which represents the object.
	 */
	@Override
	public String toString ()
	{
		final StringBuilder stringBuilder = new StringBuilder();
		final Iterator<Map.Entry<Currency, Integer>> entryIterator = this.currencyAmountMap.entrySet().iterator();
		while (entryIterator.hasNext())
		{
			final Map.Entry<Currency, Integer> entry = entryIterator.next();
			stringBuilder.append(entry.getKey().name()).append(EQUALS).append(entry.getValue());
			if (entryIterator.hasNext())
			{
				stringBuilder.append(SEMICOLON).append(WHITESPACE);
			}
		}
		return MessageFormat.format(TO_STRING_PATTERN, stringBuilder.toString());
	}

}
