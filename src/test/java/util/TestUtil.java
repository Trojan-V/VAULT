package util;


import me.vault.game.currency.Currency;


/**
 * Description
 *
 * @author Vincent Wolf
 * @version 1.0.0
 * @see
 * @since 29.05.2024
 */
public class TestUtil
{
	public static final int TEST_CURRENCY_STARTING_AMOUNT = 1000;


	public static void setStartingCurrencyAmounts ()
	{
		// Currencies are set to specified value
		for (final Currency currency : Currency.values())
		{
			currency.setAmount(TEST_CURRENCY_STARTING_AMOUNT);
		}
	}
}
