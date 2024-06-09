package me.vault.game.view;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import javafx.scene.image.ImageView;
import me.vault.game.VaultApplication;
import me.vault.game.city.building.CityBuildingController;
import me.vault.game.currency.Currency;
import me.vault.game.utility.loading.ResourceLoader;

import java.net.URL;
import java.util.ResourceBundle;

import static me.vault.game.utility.constant.GameConstants.*;


public class TrainingFacilityDelegate extends CityBuildingController implements Initializable
{

	@FXML
	private Label compositeAmountLabel;


	@FXML
	private ImageView compositeImageView;


	@FXML
	private Label creditAmountLabel;


	@FXML
	private ImageView creditImageView;


	@FXML
	private ImageView engineerImageView;


	@FXML
	private Button engineerUpgradeButton;


	@FXML
	private Label foodAmountLabel;


	@FXML
	private ImageView foodImageView;


	@FXML
	private ImageView grenadierImageView;


	@FXML
	private Button grenadierUpgradeButton;


	@FXML
	private ImageView guardImageView;


	@FXML
	private Button guardUpgradeButton;


	@FXML
	private ImageView infantryImageView;


	@FXML
	private Button infantryUpgradeButton;


	@FXML
	private ImageView lieutenantImageView;


	@FXML
	private Button lieutenantUpgradeButton;


	@FXML
	private ImageView medicImageView;


	@FXML
	private Button medicUpgradeButton;


	@FXML
	private ImageView officerImageView;


	@FXML
	private Button officerUpgradeButton;


	@FXML
	private ImageView precisionShooterImageView;


	@FXML
	private Button precisionShooterUpgradeButton;


	@FXML
	private ImageView rangerImageView;


	@FXML
	private Button rangerUpgradeButton;


	@FXML
	private ImageView recruitImageView;


	@FXML
	private Button recruitUpgradeButton;


	@FXML
	private Label scienceAmountLabel;


	@FXML
	private ImageView scienceImageView;


	@FXML
	private ImageView sniperImageView;


	@FXML
	private Button sniperUpgradeButton;


	@FXML
	private ImageView spaceMarineImageView;


	@FXML
	private Button spaceMarineUpgradeButton;


	@FXML
	private Label steelAmountLabel;


	@FXML
	private ImageView steelImageView;


	@FXML
	private ImageView trainingFacilityBackgroundImageView;


	@FXML
	private TabPane factionsTabPane;


	@FXML
	void onEngineerUpgrade (final ActionEvent event)
	{

	}


	@FXML
	void onGrenadierUpgrade (final ActionEvent event)
	{

	}


	@FXML
	void onGuardUpgrade (final ActionEvent event)
	{

	}


	@FXML
	void onInfantryUpgrade (final ActionEvent event)
	{

	}


	@FXML
	void onLieutenantUpgrade (final ActionEvent event)
	{

	}


	@FXML
	void onMedicUpgrade (final ActionEvent event)
	{

	}


	@FXML
	void onOfficerUpgrade (final ActionEvent event)
	{

	}


	@FXML
	void onPrecisionShooterUpgrade (final ActionEvent event)
	{

	}


	@FXML
	void onRangerUpgrade (final ActionEvent event)
	{

	}


	@FXML
	void onRecruitUpgrade (final ActionEvent event)
	{

	}


	@FXML
	void onSniperUpgrade (final ActionEvent event)
	{

	}


	@FXML
	void onSpaceMarineUpgrade (final ActionEvent event)
	{

	}


	@FXML
	void onBackToCityView (final ActionEvent ignored)
	{
		CityView.show(VaultApplication.getStage());
	}


	/**
	 * @param url
	 * @param resourceBundle
	 */
	@Override
	public void initialize (final URL url, final ResourceBundle resourceBundle)
	{
		this.trainingFacilityBackgroundImageView.setImage(ResourceLoader.loadImage(ASSETS_PATH + CITY_BACKGROUND_FILENAME));
		this.factionsTabPane.getStyleClass().add(TAB_PANE_STYLE);
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
