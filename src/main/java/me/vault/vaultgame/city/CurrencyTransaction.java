package me.vault.vaultgame.city;


import java.text.MessageFormat;
import java.util.HashMap;


/**
 *
 */
public class CurrencyTransaction
{


	/**
	 * The pattern that is used to have a formatted output in the {@link CurrencyTransaction#toString()} method.
	 */
	private static final String STRING_PATTERN = "CurrencyTransaction [ amountMap = {0} ]";


	/**
	 * The {@link HashMap} which contains the amounts of currencies that are changed by the transaction. The keys of
	 * the {@code HashMap} represent the {@link Currency} enum values and the values of the {@code HashMap} the
	 * corresponding amounts of each {@code Currency} key.
	 */
	private final HashMap<Currency, Integer> amountMap;


	/**
	 * @param amountMap
	 */
	public CurrencyTransaction (final HashMap<Currency, Integer> amountMap)
	{
		this.amountMap = amountMap;
	}


	/**
	 * @return
	 */
	public HashMap<Currency, Integer> getAmountMap ()
	{
		return this.amountMap;
	}


	/**
	 * @param currency
	 *
	 * @return
	 */
	public int getAmount (final Currency currency)
	{
		return this.amountMap.get(currency);
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
		return MessageFormat.format(STRING_PATTERN, this.amountMap.toString());
	}
}
