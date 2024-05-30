package me.vault.game.controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import me.vault.game.model.citybuilding.CityBuilding;
import me.vault.game.model.currency.Currency;
import me.vault.game.utility.ResourceLoader;

import java.net.URL;
import java.util.ResourceBundle;


/**
 * Description
 *
 * @author Vincent Wolf
 * @version 1.0.0
 * @see
 * @since 15.05.2024
 */
public class CityController implements Initializable
{
	private static final CityController INSTANCE = new CityController();


	@FXML
	private Button barracksButton;


	@FXML
	private ImageView cityBackgroundImageView;


	@FXML
	private Button commandCenterButton;


	@FXML
	private Label compositeAmountLabel;


	@FXML
	private ImageView compositeImageView;


	@FXML
	private Label creditAmountLabel;


	@FXML
	private ImageView creditImageView;


	@FXML
	private Button docksButton;


	@FXML
	private Label foodAmountLabel;


	@FXML
	private ImageView foodImageView;


	@FXML
	private Button laboratoryButton;


	@FXML
	private Button marketButton;


	@FXML
	private Label scienceAmountLabel;


	@FXML
	private ImageView scienceImageView;


	@FXML
	private Button spaceBarButton;


	@FXML
	private Label steelAmountLabel;


	@FXML
	private ImageView steelImageView;


	@FXML
	private Button trainingfacilityButton;


	@FXML
	private Button workshopButton;


	public static CityController getInstance ()
	{
		return INSTANCE;
	}


	@FXML
	void onBarracksButtonClick (final ActionEvent event)
	{

	}


	@FXML
	void onCommandCenterButtonClick (final ActionEvent event)
	{

	}


	@FXML
	void onDocksButtonClick (final ActionEvent event)
	{

	}


	@FXML
	void onLaboratoryButtonClick (final ActionEvent event)
	{

	}


	@FXML
	void onMarketButtonClick (final ActionEvent event)
	{

	}


	@FXML
	void onSpaceBarButtonClick (final ActionEvent event)
	{

	}


	@FXML
	void onTrainingsFacilityButtonClick (final ActionEvent event)
	{

	}


	@FXML
	void onWorkshopButtonClick (final ActionEvent event)
	{

	}


	@Override
	@FXML
	public void initialize (final URL url, final ResourceBundle resourceBundle)
	{
		this.cityBackgroundImageView.setImage(ResourceLoader.loadImage(
			"src/main/resources/me/vault/game/view" + "/city_background.png"));
		this.initCurrencies();
		this.initBuildingButtons();
	}


	private void initBuildingButtons ()
	{
		// Initialization of the BARRACKS Button
		this.barracksButton.setText(CityBuilding.BARACKS.getCurrentProperties().getName());
		this.barracksButton.setGraphic(new ImageView(CityBuilding.BARACKS.getIcon()));

		// Initialization of the WORKSHOP Button
		this.workshopButton.setText(CityBuilding.WORKSHOP.getCurrentProperties().getName());
		this.workshopButton.setGraphic(new ImageView(CityBuilding.WORKSHOP.getIcon()));

		// Initialization of the COMMAND_CENTER Button
		this.commandCenterButton.setText(CityBuilding.COMMAND_CENTER.getCurrentProperties().getName());
		this.commandCenterButton.setGraphic(new ImageView(CityBuilding.COMMAND_CENTER.getIcon()));

		// Initialization of the MARKET Button
		this.marketButton.setText(CityBuilding.MARKET.getCurrentProperties().getName());
		this.marketButton.setGraphic(new ImageView(CityBuilding.MARKET.getIcon()));

		// Initialization of the BARRACKS Button
		this.barracksButton.setText(CityBuilding.BARACKS.getCurrentProperties().getName());
		this.barracksButton.setGraphic(new ImageView(CityBuilding.BARACKS.getIcon()));

		// Initialization of the BARRACKS Button
		this.barracksButton.setText(CityBuilding.BARACKS.getCurrentProperties().getName());
		this.barracksButton.setGraphic(new ImageView(CityBuilding.BARACKS.getIcon()));

		// Initialization of the BARRACKS Button
		this.barracksButton.setText(CityBuilding.BARACKS.getCurrentProperties().getName());
		this.barracksButton.setGraphic(new ImageView(CityBuilding.BARACKS.getIcon()));
	}


	private void initCurrencies ()
	{
		// Initialisation of the STEEL Currency
		this.steelImageView.setImage(Currency.STEEL.getSprite());
		this.steelAmountLabel.setText(String.valueOf(Currency.STEEL.getAmount()));

		// Initialisation of the COMPOSITE Currency
		this.compositeImageView.setImage(Currency.COMPOSITE.getSprite());
		this.compositeAmountLabel.setText(String.valueOf(Currency.COMPOSITE.getAmount()));

		// Initialisation of the SCIENCE Currency
		this.scienceImageView.setImage(Currency.SCIENCE.getSprite());
		this.scienceAmountLabel.setText(String.valueOf(Currency.SCIENCE.getAmount()));

		// Initialisation of the FOOD_RATION Currency
		this.foodImageView.setImage(Currency.FOOD_RATION.getSprite());
		this.foodAmountLabel.setText(String.valueOf(Currency.FOOD_RATION.getAmount()));

		// Initialisation of the ENERGY_CREDIT Currency
		this.creditImageView.setImage(Currency.ENERGY_CREDIT.getSprite());
		this.creditAmountLabel.setText(String.valueOf(Currency.ENERGY_CREDIT.getAmount()));
	}
}
