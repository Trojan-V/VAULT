package me.vault.game.view.city;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import me.vault.game.VaultApplication;
import me.vault.game.control.CurrencyController;
import me.vault.game.model.building.CityBuilding;
import me.vault.game.model.city.*;
import me.vault.game.model.currency.Currency;
import me.vault.game.utility.loading.ResourceLoader;
import me.vault.game.view.UpgradeDialogDelegate;
import me.vault.game.view.ViewUtil;
import me.vault.game.view.city.buildings.CityBuildingView;

import java.net.URL;
import java.util.ResourceBundle;

import static me.vault.game.utility.constant.GameConstants.ASSETS_PATH;
import static me.vault.game.utility.constant.GameConstants.GENERAL_BACKGROUND_FILENAME;


/**
 * Description
 *
 * @author Vincent Wolf
 * @version 1.0.0
 * @see
 * @since 15.05.2024
 */
public class CityDelegate implements Initializable
{

	@FXML
	private Button barracksButton;

	@FXML
	private Button barracksUpgradeButton;

	@FXML
	private AnchorPane cityAnchorPane;

	@FXML
	private ImageView cityBackgroundImageView;

	@FXML
	private Button commandCenterButton;

	@FXML
	private Button commandCenterUpgradeButton;

	@FXML
	private Button docksButton;

	@FXML
	private Button docksUpgradeButton;

	@FXML
	private Button laboratoryButton;

	@FXML
	private Button laboratoryUpgradeButton;

	@FXML
	private Button marketButton;

	@FXML
	private Button marketUpgradeButton;

	@FXML
	private Button spaceBarButton;

	@FXML
	private Button spaceBarUpgradeButton;

	@FXML
	private Button trainingfacilityButton;

	@FXML
	private Button trainingfacilityUpgradeButton;

	@FXML
	private Button workshopButton;

	@FXML
	private Button workshopUpgradeButton;


	private static void initCityBuildingButton (final Button button, final CityBuilding cityBuilding)
	{
		// Sprite property gets bound to the button.
		final ImageView imageView = new ImageView();
		imageView.imageProperty().bind(cityBuilding.getSpriteProperty());
		button.setGraphic(imageView);

		// Name property gets bound to the button.
		button.textProperty().bind(cityBuilding.getNameProperty());
	}


	public static void initCurrency (final Currency steel, final ImageView steelImageView, final Label steelAmountLabel)
	{
		steelImageView.imageProperty().bind(steel.getSpriteProperty());
		steelAmountLabel.textProperty().bind(steel.getAmountProperty().asString());
	}


	@FXML
	void onBarracksUpgrade (final ActionEvent event)
	{

	}


	@FXML
	void onCommandCenterUpgrade (final ActionEvent event)
	{

	}


	@FXML
	void onDocksUpgrade (final ActionEvent event)
	{

	}


	@FXML
	void onLaboratoryUpgrade (final ActionEvent event)
	{

	}


	@FXML
	void onMarketUpgrade (final ActionEvent event)
	{

	}


	@FXML
	void onSpaceBarUpgrade (final ActionEvent event)
	{

	}


	@FXML
	void onTrainingFacilityUpgrade (final ActionEvent event)
	{

	}


	@FXML
	void onWorkshopUpgrade (final ActionEvent event)
	{
		// WorkshopController.getInstance().upgrade();
	}


	@FXML
	void onBarracksButtonClick (final ActionEvent ignored)
	{
		CityBuildingView.showCityBuilding(VaultApplication.getStage(), Barracks.getInstance());
	}


	@FXML
	void onCommandCenterButtonClick (final ActionEvent ignored)
	{
		CityBuildingView.showCityBuilding(VaultApplication.getStage(), CommandCenter.getInstance());
	}


	@FXML
	void onDocksButtonClick (final ActionEvent ignored)
	{
		CityBuildingView.showCityBuilding(VaultApplication.getStage(), Docks.getInstance());
	}


	@FXML
	void onLaboratoryButtonClick (final ActionEvent ignored)
	{
		CityBuildingView.showCityBuilding(VaultApplication.getStage(), Laboratory.getInstance());
	}


	@FXML
	void onMarketButtonClick (final ActionEvent ignored)
	{
		CityBuildingView.showCityBuilding(VaultApplication.getStage(), Market.getInstance());
	}


	@FXML
	void onSpaceBarButtonClick (final ActionEvent ignored)
	{
		CityBuildingView.showCityBuilding(VaultApplication.getStage(), SpaceBar.getInstance());
	}


	@FXML
	void onTrainingFacilityButtonClick (final ActionEvent ignored)
	{
		CityBuildingView.showCityBuilding(VaultApplication.getStage(), TrainingFacility.getInstance());
	}


	@FXML
	void onWorkshopButtonClick (final ActionEvent ignored)
	{
		CityBuildingView.showCityBuilding(VaultApplication.getStage(), Workshop.getInstance());
	}


	@FXML
	@Override
	public void initialize (final URL url, final ResourceBundle resourceBundle)
	{
		this.initBuildingButtons();
		this.cityAnchorPane.getChildren().add(CurrencyController.getCurrencyBannerScene().getRoot());
		this.cityBackgroundImageView.setImage(ResourceLoader.loadImage(ASSETS_PATH + GENERAL_BACKGROUND_FILENAME));
	}


	private void initBuildingButtons ()
	{
		initCityBuildingButton(this.workshopButton, Workshop.getInstance());
		initCityBuildingButton(this.barracksButton, Barracks.getInstance());
		initCityBuildingButton(this.laboratoryButton, Laboratory.getInstance());
		initCityBuildingButton(this.spaceBarButton, SpaceBar.getInstance());
		initCityBuildingButton(this.marketButton, Market.getInstance());
		initCityBuildingButton(this.docksButton, Docks.getInstance());
		initCityBuildingButton(this.commandCenterButton, CommandCenter.getInstance());
		initCityBuildingButton(this.trainingfacilityButton, TrainingFacility.getInstance());
	}

}
