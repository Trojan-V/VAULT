package me.vault.game.control;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
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
 * The {@code CurrencyController} class primarily provides methods and isn't meant to be implemented. It's used to handle the {@link Currency} class.
 *
 * @author Lasse-Leander Hillen, Vincent Wolf, Alexander Goethel,
 * @see Currency
 * @since 21.05.2024
 */
public final class CurrencyController implements Initializable
{

	/**
	 * The {@link Logger} object for this class used for writing to the console.
	 */
	private static final ILogger LOGGER = new Logger(CurrencyController.class.getSimpleName());

	/**
	 * This file is located in the directory {@code ./src/main/java/resources/me/vault/vaultgame} and defines the properties (color etc.) of the GUI
	 * elements.
	 */
	private static final String BANNER_FXML_FILENAME = "currency_view.fxml";

	/**
	 * This file is located in the directory {@code ./src/main/java/resources/me/vault/vaultgame} and defines the properties (color etc.) of the GUI
	 * elements.
	 */
	private static final String REWARD_GRID_FXML_FILENAME = "currencyRewardGrid.fxml";


	// Labels ---------------------------------------------------------------------------------------------------------------

	@FXML
	private Label steelAmountLabel;

	@FXML
	private Label compositeAmountLabel;

	@FXML
	private Label scienceAmountLabel;

	@FXML
	private Label foodAmountLabel;

	@FXML
	private Label creditAmountLabel;

	// Methods --------------------------------------------------------------------------------------------------------------


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
	 * Accepts a {@link CurrencyTransaction} as input and factors in every amount of {@link Currency} which is saved in the transaction.
	 *
	 * @param transaction The {@code CurrencyTransaction} object which is meant to be factored in.
	 */
	public static void factorCurrencyTransaction (final CurrencyTransaction transaction)
	{
		for (int i = 0; i < Currency.values().length; i++)
		{
			final Currency currency = Currency.values()[i];
			factorCurrencyTransaction(currency, transaction.getAmount(currency));
		}

		// Logging the used amount and the new currency values
		LOGGER.logf(DEBUG, FACTORED_TRANSACTION, transaction);
		LOGGER.logf(DEBUG, NEW_CURRENCY_VALUES, Arrays.toString(Currency.values()));
	}


	public static void factorCurrencyTransaction (final Currency currency, final int amount)
	{
		currency.addAmount(amount);
	}


	public static Scene getCurrencyBannerScene ()
	{
		return ResourceLoader.loadScene(CurrencyController.class, BANNER_FXML_FILENAME);
	}


	public static GridPane getCurrencyRewardGrid (final CurrencyTransaction currencyTransaction)
	{
		final GridPane gridPane = new GridPane();
		gridPane.setHgap(40);
		gridPane.setVgap(8);
		for (int row = 0; row < Currency.values().length; row++)
		{
			final Currency currency = Currency.values()[row];
			final ImageView currencyImageView = new ImageView(currency.getSprite());
			currencyImageView.fitHeightProperty().set(32);
			currencyImageView.fitWidthProperty().set(32);
			gridPane.add(currencyImageView, 0, row);
			gridPane.add(new Label(currency.toString()), 1, row);
			gridPane.add(new Label(String.valueOf(currencyTransaction.getAmount(currency))), 2, row);
		}
		return gridPane;
	}


	private static void initCurrency (final Currency currency, final Label label)
	{
		label.textProperty().bind(currency.getAmountProperty().asString());
	}

}
