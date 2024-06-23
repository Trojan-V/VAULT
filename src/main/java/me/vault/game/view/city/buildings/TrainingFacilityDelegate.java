package me.vault.game.view.city.buildings;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TabPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import me.vault.game.VaultApplication;
import me.vault.game.control.CityBuildingController;
import me.vault.game.control.CurrencyController;
import me.vault.game.control.TroopController;
import me.vault.game.model.troop.impl.*;
import me.vault.game.view.city.CityView;

import java.net.URL;
import java.util.ResourceBundle;

import static me.vault.game.utility.constant.GameConstants.TAB_PANE_STYLE;


public class TrainingFacilityDelegate extends CityBuildingController implements Initializable
{

	@FXML
	private AnchorPane engineerAttributePane;

	@FXML
	private ImageView engineerImageView;

	@FXML
	private Button engineerUpgradeButton;

	@FXML
	private TabPane factionsTabPane;

	@FXML
	private AnchorPane grenadierAttributePane;

	@FXML
	private ImageView grenadierImageView;

	@FXML
	private Button grenadierUpgradeButton;

	@FXML
	private AnchorPane guardAttributePane;

	@FXML
	private ImageView guardImageView;

	@FXML
	private Button guardUpgradeButton;

	@FXML
	private AnchorPane infantryAttributePane;

	@FXML
	private ImageView infantryImageView;

	@FXML
	private Button infantryUpgradeButton;

	@FXML
	private AnchorPane lieutenantAttributePane;

	@FXML
	private ImageView lieutenantImageView;

	@FXML
	private Button lieutenantUpgradeButton;

	@FXML
	private AnchorPane mainAnchorPane;

	@FXML
	private AnchorPane medicAttributePane;

	@FXML
	private ImageView medicImageView;

	@FXML
	private Button medicUpgradeButton;

	@FXML
	private AnchorPane officerAttributePane;

	@FXML
	private ImageView officerImageView;

	@FXML
	private Button officerUpgradeButton;

	@FXML
	private AnchorPane precisionShooterAttributePane;

	@FXML
	private ImageView precisionShooterImageView;

	@FXML
	private Button precisionShooterUpgradeButton;

	@FXML
	private AnchorPane rangerAttributePane;

	@FXML
	private ImageView rangerImageView;

	@FXML
	private Button rangerUpgradeButton;

	@FXML
	private AnchorPane recruitAttributePane;

	@FXML
	private ImageView recruitImageView;

	@FXML
	private Button recruitUpgradeButton;

	@FXML
	private AnchorPane sniperAttributePane;

	@FXML
	private ImageView sniperImageView;

	@FXML
	private Button sniperUpgradeButton;

	@FXML
	private AnchorPane spaceMarineAttributePane;

	@FXML
	private ImageView spaceMarineImageView;

	@FXML
	private Button spaceMarineUpgradeButton;


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
		this.factionsTabPane.getStyleClass().add(TAB_PANE_STYLE);
		this.mainAnchorPane.getChildren().add(CurrencyController.getCurrencyBannerScene().getRoot());

		this.spaceMarineAttributePane.getChildren().add(TroopController.getAttributeGridPane(SpaceMarine.getInstance()));
		this.officerAttributePane.getChildren().add(TroopController.getAttributeGridPane(Officer.getInstance()));
		this.engineerAttributePane.getChildren().add(TroopController.getAttributeGridPane(Engineer.getInstance()));

		this.medicAttributePane.getChildren().add(TroopController.getAttributeGridPane(Medic.getInstance()));
		this.sniperAttributePane.getChildren().add(TroopController.getAttributeGridPane(Sniper.getInstance()));
		this.rangerAttributePane.getChildren().add(TroopController.getAttributeGridPane(Ranger.getInstance()));

		this.guardAttributePane.getChildren().add(TroopController.getAttributeGridPane(Guard.getInstance()));
		this.grenadierAttributePane.getChildren().add(TroopController.getAttributeGridPane(Grenadier.getInstance()));
		this.recruitAttributePane.getChildren().add(TroopController.getAttributeGridPane(Recruit.getInstance()));

		this.infantryAttributePane.getChildren().add(TroopController.getAttributeGridPane(Infantry.getInstance()));
		this.lieutenantAttributePane.getChildren().add(TroopController.getAttributeGridPane(Sniper.getInstance()));
		this.precisionShooterAttributePane.getChildren().add(TroopController.getAttributeGridPane(Sniper.getInstance()));
	}

}
