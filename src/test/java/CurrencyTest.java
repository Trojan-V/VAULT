import me.vault.game.currency.CurrencyController;
import me.vault.game.currency.Currency;
import me.vault.game.currency.CurrencyTransaction;
import org.junit.jupiter.api.Assertions;

import java.text.MessageFormat;

import static me.vault.game.currency.Currency.*;
import static util.TestUtil.TEST_CURRENCY_STARTING_AMOUNT;
import static util.TestUtil.setStartingCurrencyAmounts;


/**
 * <u>Tests covered by this class</u> <br>
 * -
 *
 * @author Vincent Wolf
 * @version 1.0.0
 * @see Currency
 * @see CurrencyController
 * @see CurrencyTransaction
 * @since 29.05.2024
 */
public final class CurrencyTest
{
	private static final int TEST_STEEL_AMOUNT = 30;


	private static final int TEST_COMPOSITE_AMOUNT = 24;


	private static final int TEST_SCIENCE_AMOUNT = 17;


	private static final int TEST_FOOD_RATION_AMOUNT = 78;


	private static final int TEST_ENERGY_CREDIT_AMOUNT = 13;


	private static final String CURRENCY_TRANSACTION_CONSTRUCTION_ERROR_MESSAGE =
		"There appears to be an issue during construction of a CurrencyTransaction, as the expected amount of {0}" +
		" = {1}" + " does not match the actual amount of {0} = {2}";


	private static final String INCORRECT_CURRENCY_AMOUNT_AFTER_TRANSACTION_FACTORING_MESSAGE =
		"The amount of {0} after the CurrencyTransaction has been factored was incorrect. [expected = {1}; " +
		"actual = {2}]";


	private CurrencyTest () {}


	public static void main (final String[] args)
	{
		testCreateCurrencyTransaction();
	}


	private static void testCreateCurrencyTransaction ()
	{
		final CurrencyTransaction transaction =
			CurrencyController.createTransaction(TEST_STEEL_AMOUNT, TEST_COMPOSITE_AMOUNT, TEST_SCIENCE_AMOUNT,
				TEST_FOOD_RATION_AMOUNT, TEST_ENERGY_CREDIT_AMOUNT);

		Assertions.assertEquals(TEST_STEEL_AMOUNT, transaction.getAmount(STEEL),
			MessageFormat.format(CURRENCY_TRANSACTION_CONSTRUCTION_ERROR_MESSAGE, STEEL, TEST_STEEL_AMOUNT,
				transaction.getAmount(STEEL)));

		Assertions.assertEquals(TEST_COMPOSITE_AMOUNT, transaction.getAmount(COMPOSITE),
			MessageFormat.format(CURRENCY_TRANSACTION_CONSTRUCTION_ERROR_MESSAGE, COMPOSITE, TEST_COMPOSITE_AMOUNT,
				transaction.getAmount(COMPOSITE)));

		Assertions.assertEquals(TEST_ENERGY_CREDIT_AMOUNT, transaction.getAmount(ENERGY_CREDIT),
			MessageFormat.format(CURRENCY_TRANSACTION_CONSTRUCTION_ERROR_MESSAGE, ENERGY_CREDIT,
				TEST_ENERGY_CREDIT_AMOUNT, transaction.getAmount(ENERGY_CREDIT)));

		Assertions.assertEquals(TEST_FOOD_RATION_AMOUNT, transaction.getAmount(FOOD_RATION),
			MessageFormat.format(CURRENCY_TRANSACTION_CONSTRUCTION_ERROR_MESSAGE, FOOD_RATION, TEST_FOOD_RATION_AMOUNT
				, transaction.getAmount(FOOD_RATION)));

		Assertions.assertEquals(TEST_SCIENCE_AMOUNT, transaction.getAmount(SCIENCE),
			MessageFormat.format(CURRENCY_TRANSACTION_CONSTRUCTION_ERROR_MESSAGE, SCIENCE, TEST_SCIENCE_AMOUNT,
				transaction.getAmount(SCIENCE)));
	}


	private static void testFactorCurrencyTransaction ()
	{
		setStartingCurrencyAmounts();
		final CurrencyTransaction transaction =
			CurrencyController.createTransaction(TEST_STEEL_AMOUNT, TEST_COMPOSITE_AMOUNT, TEST_SCIENCE_AMOUNT,
				TEST_FOOD_RATION_AMOUNT, TEST_ENERGY_CREDIT_AMOUNT);

		CurrencyController.factorCurrencyTransaction(transaction);

		Assertions.assertEquals(TEST_CURRENCY_STARTING_AMOUNT +
		                        transaction.getAmount(STEEL), STEEL.getAmount(),
			MessageFormat.format(INCORRECT_CURRENCY_AMOUNT_AFTER_TRANSACTION_FACTORING_MESSAGE, STEEL,
			TEST_CURRENCY_STARTING_AMOUNT + transaction.getAmount(STEEL), STEEL.getAmount()));

		Assertions.assertEquals(TEST_CURRENCY_STARTING_AMOUNT +
		                        transaction.getAmount(COMPOSITE), COMPOSITE.getAmount(),
			MessageFormat.format(INCORRECT_CURRENCY_AMOUNT_AFTER_TRANSACTION_FACTORING_MESSAGE, COMPOSITE,
			TEST_CURRENCY_STARTING_AMOUNT + transaction.getAmount(COMPOSITE), COMPOSITE.getAmount()));


		Assertions.assertEquals(TEST_CURRENCY_STARTING_AMOUNT +
		                        transaction.getAmount(ENERGY_CREDIT), ENERGY_CREDIT.getAmount(),
			MessageFormat.format(INCORRECT_CURRENCY_AMOUNT_AFTER_TRANSACTION_FACTORING_MESSAGE, ENERGY_CREDIT,
			TEST_CURRENCY_STARTING_AMOUNT + transaction.getAmount(ENERGY_CREDIT), ENERGY_CREDIT.getAmount()));

		Assertions.assertEquals(TEST_CURRENCY_STARTING_AMOUNT +
		                        transaction.getAmount(FOOD_RATION), FOOD_RATION.getAmount(),
			MessageFormat.format(INCORRECT_CURRENCY_AMOUNT_AFTER_TRANSACTION_FACTORING_MESSAGE, FOOD_RATION,
			TEST_CURRENCY_STARTING_AMOUNT + transaction.getAmount(FOOD_RATION), FOOD_RATION.getAmount()));

		Assertions.assertEquals(TEST_CURRENCY_STARTING_AMOUNT +
		                        transaction.getAmount(SCIENCE), SCIENCE.getAmount(),
			MessageFormat.format(INCORRECT_CURRENCY_AMOUNT_AFTER_TRANSACTION_FACTORING_MESSAGE, SCIENCE,
			TEST_CURRENCY_STARTING_AMOUNT + transaction.getAmount(SCIENCE), SCIENCE.getAmount()));

	}
}
