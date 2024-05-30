package me.vault.game.controller;


import me.vault.game.exception.InvalidMapEntryException;
import me.vault.game.model.currency.Currency;
import me.vault.game.model.currency.CurrencyTransaction;
import me.vault.game.utility.logging.Logger;

import static me.vault.game.utility.constant.LoggingConstants.Currency.EXECUTION_NOT_POSSIBLE_ANYMORE_MSG;
import static me.vault.game.utility.constant.MiscConstants.ERROR_EXIT_CODE;
import static me.vault.game.utility.logging.ILogger.Level.ERROR;


/**
 * The {@code CurrencyController} class primarily provides methods and isn't meant to be implemented. It's used to
 * handle the {@link Currency} class.
 *
 * @author Lasse-Leander Hillen
 * @see Currency
 * @since 21.05.2024
 */
// TODO: Logging einbauen
public final class CurrencyController
{
	private static final Logger LOGGER = new Logger(CurrencyController.class.getSimpleName());


	/**
	 * Private constructor since the class isn't supposed to be instantiated.
	 */
	private CurrencyController ()
	{}


	/**
	 * Accepts a {@link CurrencyTransaction} as input and factors in every amount of {@link Currency} which is saved in
	 * the transaction.
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


	public static CurrencyTransaction createTransaction (final int steelAmount, final int compositeAmount,
		final int scienceAmount, final int foodAmount, final int energyAmount)
	{
		try
		{
			return new CurrencyTransaction(steelAmount, compositeAmount, scienceAmount, foodAmount, energyAmount);
		}
		catch (final InvalidMapEntryException e)
		{
			LOGGER.log(ERROR, e.getMessage());
			LOGGER.log(ERROR, EXECUTION_NOT_POSSIBLE_ANYMORE_MSG);
			System.exit(ERROR_EXIT_CODE);
			return null;
		}
	}
}
