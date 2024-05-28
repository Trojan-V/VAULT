package me.vault.vaultgame.controller;


import me.vault.vaultgame.exception.InvalidMapEntryException;
import me.vault.vaultgame.model.currency.Currency;
import me.vault.vaultgame.model.currency.CurrencyTransaction;

import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

import static me.vault.vaultgame.utility.constant.MiscConstants.ERROR_EXIT_CODE;


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
	 * The Logger which is used to display formatted information in the console.
	 */
	private static final Logger LOGGER = Logger.getLogger(CurrencyController.class.getName());


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


	public static CurrencyTransaction createTransaction (final int steelAmount, final int compositeAmount, final int scienceAmount, final int foodAmount,
		final int energyAmount)
	{
		try
		{
			return new CurrencyTransaction(steelAmount, compositeAmount, scienceAmount, foodAmount, energyAmount);
		}
		catch (final InvalidMapEntryException ex)
		{
			LOGGER.log(new LogRecord(Level.SEVERE, ex.getMessage()));
			System.exit(ERROR_EXIT_CODE);
			return null;
		}
	}
}
