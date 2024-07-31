package me.vault.game.view.city;


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
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.ResourceBundle;

import static me.vault.game.utility.interfaces.constant.LoggingConstants.Currency.FACTORED_TRANSACTION;
import static me.vault.game.utility.interfaces.constant.LoggingConstants.Currency.NEW_CURRENCY_VALUES;
import static me.vault.game.utility.logging.ILogger.Level.DEBUG;


/**
 * Controller class for the {@link Currency} enum. Handles a ton of stuff related to factoring currencies or
 * displaying the banner scene that shows all currencies the player owns as the top bar of the GUI.
 *
 * @author Vincent Wolf, Lasse-Leander Hillen, Timothy Hoegen-Jupp, Alexander Goethel
 * @see Currency
 * @since 30.07.2024
 */
public final class CurrencyDelegate implements Initializable
{

	/**
	 * The {@link Logger} object for this class used for writing to the console.
	 */
	private static final ILogger LOGGER = new Logger(CurrencyDelegate.class.getSimpleName());


	/**
	 * The path to the .fxml file which contains all the styling for the currency view at the top of the screen.
	 */
	private static final String BANNER_FXML_FILE_PATH = "currency_view.fxml";

	/**
	 * The pattern used to create the string which describes the class in a human-readable format.
	 */
	private static final String TO_STRING_PATTERN = "CurrencyController'{'fxml={0}'}'";


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
	 *
	 * @precondition A {@link CurrencyTransaction} object != null is passed into the method.
	 * @postcondition The currency amounts within the transaction have been factored into the global currencies.
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
	 *
	 * @precondition A {@link CurrencyTransaction} object != null and an integer amount is passed into the method.
	 * @postcondition The amount of the currency has been factored into the global currencies.
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
	 *
	 * @precondition The fxml file contains all relevant controls to build the CurrencyBannerScene.
	 * @postcondition The CurrencyBannerScene was initialized and returned.
	 */
	public static Scene getCurrencyBannerScene ()
	{
		return ResourceLoader.loadScene(CurrencyDelegate.class, BANNER_FXML_FILE_PATH);
	}


	/**
	 * Initializes the supplied currency in the GUI by binding the property to the GUI.
	 *
	 * @param currency The currency that's initialized to the GUI.
	 * @param label    The label where the currency is being displayed in the GUI.
	 *
	 * @precondition The passed label must be part of the fxml document, and the currency must have an amount property.
	 * @postcondition The text property of the label was bound to the amount of the passed currency.
	 */
	private static void initCurrency (final Currency currency, final Label label)
	{
		label.textProperty().bind(currency.getAmountProperty().asString());
	}


	/**
	 * Initializes the fxml-view and sets program-specific bindings and properties. Gets called internally by JavaFX.
	 *
	 * @param url            The {@link URL} object, which acts like a pointer to the ressource of the fxml-file.
	 * @param resourceBundle A {@link ResourceBundle} object, which contains locale-specific objects.
	 *
	 * @precondition The passed parameters contain all relevant information needed to initialize the fxml-view.
	 * @postcondition The fxml-view gets initialized and the procedure within the method is run at initialization.
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


	/**
	 * Builds a formatted {@link String}, which represents the object, and it's current state using the {@link CurrencyDelegate#TO_STRING_PATTERN}.
	 *
	 * @return A {@link String} which has been formatted in the {@link CurrencyDelegate#TO_STRING_PATTERN}.
	 *
	 * @precondition The {@link CurrencyDelegate#TO_STRING_PATTERN} is {@code != null}.
	 * @postcondition The method returned a {@link String} which represents the object.
	 */
	@Override
	public String toString ()
	{
		return MessageFormat.format(TO_STRING_PATTERN, BANNER_FXML_FILE_PATH);
	}

}
