package me.vault.game.controller;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import me.vault.game.model.currency.Currency;
import me.vault.game.utility.ResourceLoader;
import me.vault.game.utility.logging.ILogger;
import me.vault.game.utility.logging.Logger;

import java.net.URL;
import java.util.ResourceBundle;

import static me.vault.game.utility.constant.GameConstants.ASSETS_PATH;


public class WorkshopController implements Initializable
{
	/**
	 * The logger object for this class used for writing to the console.
	 *
	 * @see Logger
	 */
	private static final ILogger LOGGER = new Logger(WorkshopController.class.getSimpleName());


	private static final String BACKGROUND_FILENAME = "city_background.png";


	@FXML
	private ImageView workshopBackgroundImageView;


	@FXML
	private Label compositeAmountLabel;


	@FXML
	private ImageView compositeImageView;


	@FXML
	private Label creditAmountLabel;


	@FXML
	private ImageView creditImageView;


	@FXML
	private Label foodAmountLabel;


	@FXML
	private ImageView foodImageView;


	@FXML
	private Label scienceAmountLabel;


	@FXML
	private ImageView scienceImageView;


	@FXML
	private Label steelAmountLabel;


	@FXML
	private ImageView steelImageView;


	@Override
	public void initialize (final URL url, final ResourceBundle resourceBundle)
	{
		this.workshopBackgroundImageView.setImage(ResourceLoader.loadImage(ASSETS_PATH + BACKGROUND_FILENAME));
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
