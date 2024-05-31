package me.vault.game.controller;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import me.vault.game.model.citybuilding.CityBuilding;
import me.vault.game.model.citybuilding.CityBuildingLevel;
import me.vault.game.model.citybuilding.CityBuildingProperties;
import me.vault.game.model.currency.Currency;
import me.vault.game.model.interfaces.IUpgrader;

import java.net.URL;
import java.util.ResourceBundle;


/**
 *
 */
public class CityBuildingController
	implements IUpgrader<CityBuilding, CityBuildingLevel, CityBuildingProperties>, Initializable
{
	private static final CityBuildingController INSTANCE = new CityBuildingController();


	@FXML
	private ImageView cityBackgroundImageView;


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


	public static CityBuildingController getInstance ()
	{
		return INSTANCE;
	}


	@Override
	public boolean checkIsUpgradable (final CityBuilding cityBuilding)
	{
		return cityBuilding != null && cityBuilding.getLevel() != CityBuildingLevel.getMaximumArtifactLevel();
	}


	@Override
	public void upgrade (final CityBuilding cityBuilding)
	{
		if (cityBuilding == null || ! getInstance().checkIsUpgradable(cityBuilding))
		{
			return;
		}
		cityBuilding.setLevel(CityBuildingLevel.getNextHigherLevel(cityBuilding.getLevel()));
		CurrencyController.factorCurrencyTransaction(cityBuilding.getCurrentProperties().getUpgradeCost());
	}


	@Override
	public void initialize (final URL url, final ResourceBundle resourceBundle)
	{
		this.initCurrencies();
	}


	private void initCurrencies ()
	{
		this.initCurrency(Currency.STEEL, this.steelAmountLabel, this.steelImageView);

		this.initCurrency(Currency.COMPOSITE, this.compositeAmountLabel, this.compositeImageView);

		this.initCurrency(Currency.SCIENCE, this.scienceAmountLabel, this.scienceImageView);

		this.initCurrency(Currency.FOOD_RATION, this.foodAmountLabel, this.foodImageView);

		this.initCurrency(Currency.ENERGY_CREDIT, this.creditAmountLabel, this.creditImageView);
	}


	private void initCurrency (final Currency currency, final Label label, final ImageView imageView)
	{
		label.textProperty().bind(currency.getAmountProperty().asString());
		imageView.setImage(currency.getSprite());
	}
}
