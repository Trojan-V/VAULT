package me.vault.vaultgame.controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import me.vault.vaultgame.model.currency.Currency;
import me.vault.vaultgame.utility.ResourceLoader;

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
	private ImageView compositeImageView;


	@FXML
	private Label compositeLabel;


	@FXML
	private ImageView creditImageView;


	@FXML
	private Label creditLabel;


	@FXML
	private Button docksButton;


	@FXML
	private ImageView foodImageView;


	@FXML
	private Label foodLabel;


	@FXML
	private Button laboratoryButton;


	@FXML
	private Button marketButton;


	@FXML
	private ImageView scienceImageView;


	@FXML
	private Label scienceLabel;


	@FXML
	private Button spaceBarButton;


	@FXML
	private ImageView steelImageView;


	@FXML
	private Label steelLabel;


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
		this.creditLabel.setText("Klappt");
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
	public void initialize (URL url, ResourceBundle resourceBundle)
	{
		this.cityBackgroundImageView.setImage(ResourceLoader.loadImage("src/main/resources/me/vault/vaultgame/view/city_background.png"));
		this.initCurrencies();
	}


	private void initCurrencies ()
	{
		// Initialisation of the STEEL Currency
		this.steelImageView.setImage(Currency.STEEL.getImage());
		this.steelLabel.setText(String.valueOf(Currency.STEEL.getAmount()));

		// Initialisation of the COMPOSITE Currency
		this.compositeImageView.setImage(Currency.COMPOSITE.getImage());
		this.compositeLabel.setText(String.valueOf(Currency.COMPOSITE.getAmount()));

		// Initialisation of the SCIENCE Currency
		this.scienceImageView.setImage(Currency.SCIENCE.getImage());
		this.scienceLabel.setText(String.valueOf(Currency.SCIENCE.getAmount()));

		// Initialisation of the FOOD_RATION Currency
		this.foodImageView.setImage(Currency.FOOD_RATION.getImage());
		this.foodLabel.setText(String.valueOf(Currency.FOOD_RATION.getAmount()));

		// Initialisation of the ENERGY_CREDIT Currency
		this.creditImageView.setImage(Currency.ENERGY_CREDIT.getImage());
		this.creditLabel.setText(String.valueOf(Currency.ENERGY_CREDIT.getAmount()));
	}
}
