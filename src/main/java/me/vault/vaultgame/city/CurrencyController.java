package me.vault.vaultgame.city;


/**
 * The {@code CurrencyController} class primarily provides methods and isn't meant to be implemented. It's used to
 * handle the {@link Currency} class.
 *
 * @author Lasse-Leander Hillen
 * @see Currency
 * @since 21.05.2024
 */
public final class CurrencyController
{
	/**
	 * Private constructor since the class isn't supposed to be instantiated.
	 */
	private CurrencyController ()
	{}


	/**
	 * Accepts a {@link CurrencyTransaction} as input and factors in every amount of {@link Currency} which is saved
	 * in the transaction.
	 *
	 * @param transaction The {@code CurrencyTransaction} object which is meant to be factored in.
	 */
	public static void factorCurrencyTransaction (final CurrencyTransaction transaction)
	{
		for (int i = 0; i < Currency.values().length; i++)
		{
			final Currency currency = Currency.values()[i];
			currency.addAmount(transaction.getAmount(currency));
		}
	}
}
