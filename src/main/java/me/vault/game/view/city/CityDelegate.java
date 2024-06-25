package me.vault.game.view.city;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import me.vault.game.GameApplication;
import me.vault.game.control.CityBuildingController;
import me.vault.game.control.CurrencyController;
import me.vault.game.model.building.CityBuilding;
import me.vault.game.model.city.*;
import me.vault.game.utility.loading.ConfigLoader;
import me.vault.game.utility.loading.ResourceLoader;
import me.vault.game.utility.logging.ILogger;
import me.vault.game.utility.logging.Logger;
import me.vault.game.view.MainMenuDelegate;
import me.vault.game.view.TutorialDelegate;
import me.vault.game.view.UpgradeDialogDelegate;
import me.vault.game.view.city.buildings.*;

import java.net.URL;
import java.text.MessageFormat;
import java.util.ResourceBundle;

import static me.vault.game.utility.constant.LoggingConstants.SHOWING_VIEW_MSG;
import static me.vault.game.utility.logging.ILogger.Level.DEBUG;


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

	/**
	 * The {@link Logger} object for this class used for writing to the console.
	 */
	private static final ILogger LOGGER = new Logger(CityDelegate.class.getSimpleName());

	/**
	 * This file is located in the directory {@code ./src/main/java/resources/me/vault/vaultgame} and defines the properties (color etc.) of the GUI
	 * elements.
	 */
	private static final String STYLESHEET = "city_view.fxml";

	private static final Scene SCENE = ResourceLoader.loadScene(CityDelegate.class, STYLESHEET);

	@FXML
	private Button barracksButton;

	@FXML
	private Button barracksUpgradeButton;

	@FXML
	private AnchorPane cityAnchorPane;

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


	private static void initCityBuildingButton (final Button button, final Button upgradeButton, final CityBuilding cityBuilding)
	{
		// Sprite property gets bound to the button.
		final ImageView imageView = new ImageView();
		imageView.imageProperty().bind(cityBuilding.getSpriteProperty());
		button.setGraphic(imageView);

		// Name property gets bound to the button.
		button.textProperty().bind(cityBuilding.getNameProperty());

		// Boolean property gets bound to the upgrade button
		upgradeButton.disableProperty().bind(cityBuilding.getMaxLevelProperty());

	}


	public static void show (final Stage stage)
	{
		stage.setScene(SCENE);
		stage.show();
		LOGGER.log(DEBUG, MessageFormat.format(SHOWING_VIEW_MSG, CityDelegate.class.getSimpleName()));
	}


	@FXML
	void onBackToMainMenu (final ActionEvent event)
	{
		MainMenuDelegate.show();
	}


	@FXML
	void onOpenHelpMenu (final ActionEvent event)
	{
		TutorialDelegate.show(GameApplication.getStage());
	}


	@FXML
	void onSaveToConfig (final ActionEvent event)
	{
		ConfigLoader.getInstance().save();
		SaveCompleteDelegate.show();
	}


	@FXML
	void onBarracksUpgrade (final ActionEvent ignored)
	{
		UpgradeDialogDelegate.show(Barracks.getInstance(), CityBuildingController.getInstance());
	}


	@FXML
	void onCommandCenterUpgrade (final ActionEvent ignored)
	{
		UpgradeDialogDelegate.show(CommandCenter.getInstance(), CityBuildingController.getInstance());
	}


	@FXML
	void onDocksUpgrade (final ActionEvent ignored)
	{
		UpgradeDialogDelegate.show(Docks.getInstance(), CityBuildingController.getInstance());
	}


	@FXML
	void onLaboratoryUpgrade (final ActionEvent ignored)
	{
		UpgradeDialogDelegate.show(Laboratory.getInstance(), CityBuildingController.getInstance());
	}


	@FXML
	void onMarketUpgrade (final ActionEvent ignored)
	{
		UpgradeDialogDelegate.show(Market.getInstance(), CityBuildingController.getInstance());
	}


	@FXML
	void onSpaceBarUpgrade (final ActionEvent ignored)
	{
		UpgradeDialogDelegate.show(SpaceBar.getInstance(), CityBuildingController.getInstance());
	}


	@FXML
	void onTrainingFacilityUpgrade (final ActionEvent ignored)
	{
		UpgradeDialogDelegate.show(TrainingFacility.getInstance(), CityBuildingController.getInstance());
	}


	@FXML
	void onWorkshopUpgrade (final ActionEvent ignored)
	{
		UpgradeDialogDelegate.show(Workshop.getInstance(), CityBuildingController.getInstance());
	}


	@FXML
	void onBarracksButtonClick (final ActionEvent ignored)
	{
		BarracksDelegate.show();
	}


	@FXML
	void onCommandCenterButtonClick (final ActionEvent ignored)
	{
		CommandCenterDelegate.show();
	}


	@FXML
	void onDocksButtonClick (final ActionEvent ignored)
	{
		DocksDelegate.show();
	}


	@FXML
	void onLaboratoryButtonClick (final ActionEvent ignored)
	{
		LaboratoryDelegate.show();
	}


	@FXML
	void onMarketButtonClick (final ActionEvent ignored)
	{
		MarketDelegate.show();
	}


	@FXML
	void onSpaceBarButtonClick (final ActionEvent ignored)
	{
		SpaceBarDelegate.show();
	}


	@FXML
	void onTrainingFacilityButtonClick (final ActionEvent ignored)
	{
		TrainingFacilityDelegate.show();
	}


	@FXML
	void onWorkshopButtonClick (final ActionEvent ignored)
	{
		WorkshopDelegate.show();
	}


	@FXML
	@Override
	public void initialize (final URL url, final ResourceBundle resourceBundle)
	{
		this.initBuildingButtons();
		this.cityAnchorPane.getChildren().add(CurrencyController.getCurrencyBannerScene().getRoot());
	}


	private void initBuildingButtons ()
	{
		initCityBuildingButton(this.workshopButton, this.workshopUpgradeButton, Workshop.getInstance());
		initCityBuildingButton(this.barracksButton, this.barracksUpgradeButton, Barracks.getInstance());
		initCityBuildingButton(this.laboratoryButton, this.laboratoryUpgradeButton, Laboratory.getInstance());
		initCityBuildingButton(this.spaceBarButton, this.spaceBarUpgradeButton, SpaceBar.getInstance());
		initCityBuildingButton(this.marketButton, this.marketUpgradeButton, Market.getInstance());
		initCityBuildingButton(this.docksButton, this.docksUpgradeButton, Docks.getInstance());
		initCityBuildingButton(this.commandCenterButton, this.commandCenterUpgradeButton, CommandCenter.getInstance());
		initCityBuildingButton(this.trainingfacilityButton, this.trainingfacilityUpgradeButton, TrainingFacility.getInstance());
	}

}
