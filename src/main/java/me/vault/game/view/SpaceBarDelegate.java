package me.vault.game.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import me.vault.game.VaultApplication;
import me.vault.game.city.building.CityBuildingController;
import me.vault.game.currency.Currency;
import me.vault.game.utility.loading.ResourceLoader;

import java.net.URL;
import java.util.ResourceBundle;

import static me.vault.game.utility.constant.GameConstants.ASSETS_PATH;
import static me.vault.game.utility.constant.GameConstants.CITY_BACKGROUND_FILENAME;

public class SpaceBarDelegate extends CityBuildingController implements Initializable
{

	@FXML
	private ImageView backgroundImageView;

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


	@FXML
	void onBackToCityView (ActionEvent ignored)
	{
		CityView.show(VaultApplication.getStage());
	}


	@Override
	public void initialize (URL url, ResourceBundle resourceBundle)
	{
		this.backgroundImageView.setImage(ResourceLoader.loadImage(ASSETS_PATH + CITY_BACKGROUND_FILENAME));
		this.initCurrencies();
	}


	private void initCurrencies ()
	{
		CityDelegate.initCurrency(Currency.STEEL, this.steelImageView, steelAmountLabel);
		CityDelegate.initCurrency(Currency.COMPOSITE, this.compositeImageView, compositeAmountLabel);
		CityDelegate.initCurrency(Currency.SCIENCE, this.scienceImageView, scienceAmountLabel);
		CityDelegate.initCurrency(Currency.FOOD_RATION, this.foodImageView, foodAmountLabel);
		CityDelegate.initCurrency(Currency.ENERGY_CREDIT, this.creditImageView, creditAmountLabel);

	}

}
