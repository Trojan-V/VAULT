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
	void onLaboratoryButtonClick (final ActionEvent ignored)
	{
		CityBuildingView.showCityBuilding(VaultApplication.getStage(), CityBuilding.LABORATORY);
	}


	@FXML
	void onMarketButtonClick (final ActionEvent ignored)
	{
		CityBuildingView.showCityBuilding(VaultApplication.getStage(), CityBuilding.MARKET);
	}


	@FXML
	void onSpaceBarButtonClick (final ActionEvent ignored)
	{
		CityBuildingView.showCityBuilding(VaultApplication.getStage(), CityBuilding.WORKSHOP);
	}


	// TODO: parameter event zu ignored
	@FXML
	void onTrainingFacilityButtonClick (final ActionEvent ignored)
	{
		CityBuildingView.showCityBuilding(VaultApplication.getStage(), CityBuilding.TRAINING_FACILITY);
	}


	@FXML
	void onWorkshopButtonClick (final ActionEvent ignored)
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
		button.setText(cityBuilding.getCurrentAttributes().getName());
		final ImageView imageView = new ImageView();
		imageView.imageProperty().bind(cityBuilding.getSpriteProperty());
		button.setGraphic(imageView);
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
		initCurrencyView(Currency.STEEL, this.steelImageView, this.steelAmountLabel);

		initCurrencyView(Currency.COMPOSITE, this.compositeImageView, this.compositeAmountLabel);

		initCurrencyView(Currency.SCIENCE, this.scienceImageView, this.scienceAmountLabel);

		initCurrencyView(Currency.FOOD_RATION, this.foodImageView, this.foodAmountLabel);

		initCurrencyView(Currency.ENERGY_CREDIT, this.creditImageView, this.creditAmountLabel);
	}


	public static void initCurrencyView ( Currency steel, ImageView steelImageView, Label steelAmountLabel)
	{
		steelImageView.imageProperty().bind(steel.getSpriteProperty());
		steelAmountLabel.textProperty().bind(steel.getAmountProperty().asString());
	}

}
