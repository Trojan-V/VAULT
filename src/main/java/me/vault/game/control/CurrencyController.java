package me.vault.game.control;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
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
	private static final String FXML_FILENAME = "currency_view.fxml";


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


	// ImageViews -----------------------------------------------------------------------------------------------------------

	@FXML
	private ImageView steelImageView;

	@FXML
	private ImageView compositeImageView;

	@FXML
	private ImageView scienceImageView;

	@FXML
	private ImageView foodImageView;

	@FXML
	private ImageView creditImageView;


	// Methods --------------------------------------------------------------------------------------------------------------


	private static void initCurrency (final Currency currency, final Label label, final ImageView imageView)
	{
		label.textProperty().bind(currency.getAmountProperty().asString());
		imageView.imageProperty().bind(currency.getSpriteProperty());
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
			currency.addAmount(transaction.getAmount(currency));
		}

		// Logging the used amount and the new currency values
		LOGGER.logf(ILogger.Level.DEBUG, FACTORED_TRANSACTION, transaction);
		LOGGER.logf(ILogger.Level.DEBUG, NEW_CURRENCY_VALUES, Arrays.toString(Currency.values()));
	}


	public static Scene getCurrencyBannerScene ()
	{
		return ResourceLoader.loadScene(CurrencyController.class, FXML_FILENAME);
	}


	@Override
	public void initialize (final URL url, final ResourceBundle resourceBundle)
	{
		initCurrency(Currency.STEEL, this.steelAmountLabel, this.steelImageView);
		initCurrency(Currency.COMPOSITE, this.compositeAmountLabel, this.compositeImageView);
		initCurrency(Currency.SCIENCE, this.scienceAmountLabel, this.scienceImageView);
		initCurrency(Currency.FOOD_RATION, this.foodAmountLabel, this.foodImageView);
		initCurrency(Currency.ENERGY_CREDIT, this.creditAmountLabel, this.creditImageView);
	}

}
