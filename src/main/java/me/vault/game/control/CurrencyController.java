package me.vault.game.control;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import me.vault.game.model.currency.Currency;
import me.vault.game.model.currency.CurrencyTransaction;
import me.vault.game.utility.loading.ResourceLoader;
import me.vault.game.utility.logging.ILogger;
import me.vault.game.utility.logging.Logger;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

import static me.vault.game.utility.constant.LoggingConstants.Currency.FACTORED_TRANSACTION;
import static me.vault.game.utility.constant.LoggingConstants.Currency.NEW_CURRENCY_VALUES;
import static me.vault.game.utility.logging.ILogger.Level.DEBUG;

/**
 * Controller class for the {@link Currency} enum. Handles a ton of stuff related to factoring currencies or
 * displaying the banner scene that shows all currencies the player owns as the top bar of the GUI.
 *
 * @author Vincent Wolf, Lasse-Leander Hillen, Timothy Hoegen-Jupp, Alexander Goethel
 * @see Currency
 * @since 30.07.2024
 */
public final class CurrencyController implements Initializable
{
	/**
	 * The {@link Logger} object for this class used for writing to the console.
	 */
	private static final ILogger LOGGER = new Logger(CurrencyController.class.getSimpleName());


	/**
	 * The path to the .fxml file which contains all the styling for the currency view at the top of the screen.
	 */
	private static final String BANNER_FXML_FILE_PATH = "currency_view.fxml";


	/**
	 * This label is used within the GUI to display the steel amount in the top row that contains all the currencies.
	 */
	@FXML
	private Label steelAmountLabel;


	/**
	 * This label is used within the GUI to display the composite amount in the top row that contains all the
	 * currencies.
	 */
	@FXML
	private Label compositeAmountLabel;


	/**
	 * This label is used within the GUI to display the science amount in the top row that contains all the currencies.
	 */
	@FXML
	private Label scienceAmountLabel;


	/**
	 * This label is used within the GUI to display the food amount in the top row that contains all the currencies.
	 */
	@FXML
	private Label foodAmountLabel;


	/**
	 * This label is used within the GUI to display the credit amount in the top row that contains all the currencies.
	 */
	@FXML
	private Label creditAmountLabel;


	/**
	 * Accepts a {@link CurrencyTransaction} as input and factors in every amount of {@link Currency} which is saved
	 * in the transaction.
	 *
	 * @param transaction The {@code CurrencyTransaction} object which is meant to be factored in.
	 * @precondition A transaction can happen.
	 * @postcondition The transaction is completed.
	 */
	public static void factorCurrency (final CurrencyTransaction transaction)
	{
		for (int i = 0; i < Currency.values().length; i++)
		{
			final Currency currency = Currency.values()[i];
			factorCurrency(currency, transaction.getAmount(currency));
		}

		// Logging the used amount and the new currency values
		LOGGER.logf(DEBUG, FACTORED_TRANSACTION, transaction);
		LOGGER.logf(DEBUG, NEW_CURRENCY_VALUES, Arrays.toString(Currency.values()));
	}


	/**
	 * Factors a single {@link Currency} and adds the supplied amount to the 'bank account'.
	 * <br>
	 * It's also possible to supply a negative to essentially subtract the supplied amount from the 'bank account'.
	 *
	 * @param currency The {@link Currency} the supplied amount will be added to.
	 * @param amount   The amount that'll be added to the {@link Currency}.
	 * @precondition IThe player is for any reason eligible to get a certain amount of currency added or removed form
	 * its 'bank account'.
	 * @postcondition A certain amount of currency gets added or subtracted to the 'bank account' of the player.
	 */
	public static void factorCurrency (final Currency currency, final int amount)
	{
		currency.addAmount(amount);
	}


	/**
	 * Loads and returns the scene that displays the currency banner as the top row within a lot of GUI's used by the
	 * program.
	 *
	 * @return The scene that displays the currency banner as the top row.
	 * @precondition The banner that displays the currency`s of the player exist.
	 * @postcondition The banner that displays the currency of the player is shown to the player.
	 */
	public static Scene getCurrencyBannerScene ()
	{
		return ResourceLoader.loadScene(CurrencyController.class, BANNER_FXML_FILE_PATH);
	}


	/**
	 * Initializes the supplied currency in the GUI by binding the property to the GUI.
	 *
	 * @param currency The currency that's initialized to the GUI.
	 * @param label    The label where the currency is being displayed in the GUI.
	 * @precondition The banner that displays the currency`s of the player exist.
	 * @postcondition The amount of currency that the player has in its procession is show in the displayed banner.
	 */
	private static void initCurrency (final Currency currency, final Label label)
	{
		label.textProperty().bind(currency.getAmountProperty().asString());
	}


	/**
	 * Initializes all the currencies in the top row of the GUI.
	 * <br>
	 * {@inheritDoc}
	 */
	@Override
	public void initialize (final URL url, final ResourceBundle resourceBundle)
	{
		initCurrency(Currency.STEEL, this.steelAmountLabel);
		initCurrency(Currency.COMPOSITE, this.compositeAmountLabel);
		initCurrency(Currency.SCIENCE, this.scienceAmountLabel);
		initCurrency(Currency.FOOD_RATION, this.foodAmountLabel);
		initCurrency(Currency.ENERGY_CREDIT, this.creditAmountLabel);
	}

}
