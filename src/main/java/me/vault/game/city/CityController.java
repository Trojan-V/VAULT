package me.vault.game.city;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import me.vault.game.VaultApplication;
import me.vault.game.city.building.CityBuildingController;
import me.vault.game.city.building.CityBuilding;
import me.vault.game.currency.Currency;
import me.vault.game.utility.loading.ResourceLoader;
import me.vault.game.city.building.CityBuildingView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static me.vault.game.utility.constant.GameConstants.ASSETS_PATH;


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


	private static final String BACKGROUND_FILENAME = "city_background.png";


	@FXML
	private Button barracksButton;


	@FXML
	private Button barracksUpgradeButton;


	@FXML
	private ImageView cityBackgroundImageView;


	@FXML
	private Button commandCenterButton;


	@FXML
	private Button commandCenterUpgradeButton;


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
	private Button docksUpgradeButton;


	@FXML
	private Label foodAmountLabel;


	@FXML
	private ImageView foodImageView;


	@FXML
	private Button laboratoryButton;


	@FXML
	private Button laboratoryUpgradeButton;


	@FXML
	private Button marketButton;


	@FXML
	private Button marketUpgradeButton;


	@FXML
	private Label scienceAmountLabel;


	@FXML
	private ImageView scienceImageView;


	@FXML
	private Button spaceBarButton;


	@FXML
	private Button spaceBarUpgradeButton;


	@FXML
	private Label steelAmountLabel;


	@FXML
	private ImageView steelImageView;


	@FXML
	private Button trainingfacilityButton;


	@FXML
	private Button trainingfacilityUpgradeButton;


	@FXML
	private Button workshopButton;


	@FXML
	private Button workshopUpgradeButton;


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
		CityBuildingController.getInstance().upgrade(CityBuilding.DOCKS);
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
	void onTrainingFacilityButtonClick (final ActionEvent event)
	{
		Currency.STEEL.addAmount(100000);
	}


	@FXML
	void onWorkshopButtonClick (final ActionEvent event) throws IOException
	{
		CityBuildingView.showWorkshop(VaultApplication.getStage());
	}


	@Override
	@FXML
	public void initialize (final URL url, final ResourceBundle resourceBundle)
	{
		this.cityBackgroundImageView.setImage(ResourceLoader.loadImage(ASSETS_PATH + BACKGROUND_FILENAME));
		this.initCurrencies();
		this.initBuildingButtons();
	}


	private void initBuildingButtons ()
	{
		this.initBarracksButton();
		this.initWorkshopButton();
		this.initCommandCenterButton();
		this.initMarketButton();
		this.initDocksButton();
		this.initLaboratoryButton();
		this.initSpaceBarButton();
		this.initTrainingFacilityButton();
	}


	private void initBarracksButton ()
	{
		this.barracksButton.setText(CityBuilding.BARACKS.getCurrentProperties().getName());
		this.barracksButton.setGraphic(new ImageView(CityBuilding.BARACKS.getIcon()));
	}


	private void initWorkshopButton ()
	{
		this.workshopButton.setText(CityBuilding.WORKSHOP.getCurrentProperties().getName());
		this.workshopButton.setGraphic(new ImageView(CityBuilding.WORKSHOP.getIcon()));
	}


	private void initCommandCenterButton ()
	{
		this.commandCenterButton.setText(CityBuilding.COMMAND_CENTER.getCurrentProperties().getName());
		this.commandCenterButton.setGraphic(new ImageView(CityBuilding.COMMAND_CENTER.getIcon()));
	}


	private void initMarketButton ()
	{
		this.marketButton.setText(CityBuilding.MARKET.getCurrentProperties().getName());
		this.marketButton.setGraphic(new ImageView(CityBuilding.MARKET.getIcon()));
	}


	private void initDocksButton ()
	{
		this.docksButton.setText(CityBuilding.DOCKS.getCurrentProperties().getName());
		this.docksButton.setGraphic(new ImageView(CityBuilding.DOCKS.getIcon()));
	}


	private void initLaboratoryButton ()
	{
		this.laboratoryButton.setText(CityBuilding.LABORATORY.getCurrentProperties().getName());
		this.laboratoryButton.setGraphic(new ImageView(CityBuilding.LABORATORY.getIcon()));
	}


	private void initSpaceBarButton ()
	{
		this.spaceBarButton.setText(CityBuilding.SPACE_BAR.getCurrentProperties().getName());
		this.spaceBarButton.setGraphic(new ImageView(CityBuilding.SPACE_BAR.getIcon()));
	}


	private void initTrainingFacilityButton ()
	{
		this.trainingfacilityButton.setText(CityBuilding.TRAINING_FACILITY.getCurrentProperties().getName());
		this.trainingfacilityButton.setGraphic(new ImageView(CityBuilding.TRAINING_FACILITY.getIcon()));
	}


	private void initCurrencies ()
	{
		// Initialisation of the steel Currency
		this.steelImageView.setImage(Currency.STEEL.getSprite());
		this.steelAmountLabel.textProperty().bind(Currency.STEEL.getAmountProperty().asString());

		// Initialisation of the composite Currency
		this.compositeImageView.setImage(Currency.COMPOSITE.getSprite());
		this.compositeAmountLabel.textProperty().bind(Currency.COMPOSITE.getAmountProperty().asString());

		// Initialisation of the science Currency
		this.scienceImageView.setImage(Currency.SCIENCE.getSprite());
		this.scienceAmountLabel.textProperty().bind(Currency.SCIENCE.getAmountProperty().asString());

		// Initialisation of the food ration Currency
		this.foodImageView.setImage(Currency.FOOD_RATION.getSprite());
		this.foodAmountLabel.textProperty().bind(Currency.FOOD_RATION.getAmountProperty().asString());

		// Initialisation of the energy credit Currency
		this.creditImageView.setImage(Currency.ENERGY_CREDIT.getSprite());
		this.creditAmountLabel.textProperty().bind(Currency.ENERGY_CREDIT.getAmountProperty().asString());

	}
}
