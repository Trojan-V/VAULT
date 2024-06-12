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
import java.util.ResourceBundle;


/**
 * The {@code CurrencyController} class primarily provides methods and isn't meant to be implemented. It's used to handle the {@link Currency} class.
 *
 * @author Lasse-Leander Hillen
 * @see Currency
 * @since 21.05.2024
 */
public final class CurrencyController implements Initializable
{

	/**
	 * The logger object for this class used for writing to the console.
	 *
	 * @see Logger
	 */
	private static final ILogger LOGGER = new Logger(CurrencyController.class.getSimpleName());

	private static final Scene SCENE = ResourceLoader.loadScene(CurrencyController.class, "currency_view.fxml");

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
	}


	public static Scene getCurrencyBannerScene ()
	{
		return ResourceLoader.loadScene(CurrencyController.class, "currency_view.fxml");
	}


	@Override
	public void initialize (final URL url, final ResourceBundle resourceBundle)
	{
		this.initCurrencies();
	}


	private void initCurrencies ()
	{
		CityBuildingController.initCurrency(Currency.STEEL, this.steelAmountLabel, this.steelImageView);
		CityBuildingController.initCurrency(Currency.COMPOSITE, this.compositeAmountLabel, this.compositeImageView);
		CityBuildingController.initCurrency(Currency.SCIENCE, this.scienceAmountLabel, this.scienceImageView);
		CityBuildingController.initCurrency(Currency.FOOD_RATION, this.foodAmountLabel, this.foodImageView);
		CityBuildingController.initCurrency(Currency.ENERGY_CREDIT, this.creditAmountLabel, this.creditImageView);
	}

}
