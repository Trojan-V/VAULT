package me.vault.game.city;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import me.vault.game.VaultApplication;
import me.vault.game.city.building.CityBuilding;
import me.vault.game.city.building.CityBuildingView;
import me.vault.game.currency.Currency;
import me.vault.game.utility.loading.ResourceLoader;

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
	void onDocksButtonClick (final ActionEvent ignored)
	{
		CityBuildingView.showCityBuilding(VaultApplication.getStage(), CityBuilding.DOCKS);
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


	// TODO: parameter event zu ignored
	@FXML
	void onTrainingFacilityButtonClick (final ActionEvent ignored)
	{
		CityBuildingView.showCityBuilding(VaultApplication.getStage(), CityBuilding.TRAINING_FACILITY);
	}


	@FXML
	void onWorkshopButtonClick (final ActionEvent event) throws IOException
	{
		CityBuildingView.showCityBuilding(VaultApplication.getStage(), CityBuilding.WORKSHOP);
	}


	@Override
	@FXML
	public void initialize (final URL url, final ResourceBundle resourceBundle)
	{
		this.cityBackgroundImageView.setImage(ResourceLoader.loadImage(ASSETS_PATH + BACKGROUND_FILENAME));
		this.initCurrencies();
		this.initBuildingButtons();
	}


	private static void initCityBuildingButton (final Button button, final CityBuilding cityBuilding)
	{
		// TODO: Bindings
		button.setText(cityBuilding.getCurrentProperties().getName());
		button.setGraphic(new ImageView(cityBuilding.getSprite()));
	}


	private void initBuildingButtons ()
	{
		initCityBuildingButton(this.barracksButton, CityBuilding.BARRACKS);
		initCityBuildingButton(this.commandCenterButton, CityBuilding.COMMAND_CENTER);
		initCityBuildingButton(this.marketButton, CityBuilding.MARKET);
		initCityBuildingButton(this.docksButton, CityBuilding.DOCKS);
		initCityBuildingButton(this.laboratoryButton, CityBuilding.LABORATORY);
		initCityBuildingButton(this.spaceBarButton, CityBuilding.SPACE_BAR);
		initCityBuildingButton(this.trainingfacilityButton, CityBuilding.TRAINING_FACILITY);
		initCityBuildingButton(this.workshopButton, CityBuilding.WORKSHOP);
	}


	// TODO: Selbe Methodik wie bei initCityBuildingButton() anwenden für die Kapselung.
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
