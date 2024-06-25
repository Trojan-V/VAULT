package me.vault.game.view.city.buildings;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import me.vault.game.GameApplication;
import me.vault.game.control.CityBuildingController;
import me.vault.game.control.CurrencyController;
import me.vault.game.control.TroopController;
import me.vault.game.model.city.Barracks;
import me.vault.game.model.city.TrainingFacility;
import me.vault.game.model.troop.Troop;
import me.vault.game.model.troop.impl.*;
import me.vault.game.utility.loading.ResourceLoader;
import me.vault.game.utility.logging.Logger;
import me.vault.game.view.UpgradeDialogDelegate;
import me.vault.game.view.city.CityDelegate;

import java.net.URL;
import java.text.MessageFormat;
import java.util.ResourceBundle;

import static me.vault.game.utility.constant.GameConstants.TAB_PANE_STYLE;
import static me.vault.game.utility.constant.LoggingConstants.SHOWING_VIEW_MSG;
import static me.vault.game.utility.logging.ILogger.Level.DEBUG;


public class TrainingFacilityDelegate extends CityBuildingController implements Initializable
{

	/**
	 * The {@link Scene} of the {@link TrainingFacility} city building, which is extracted from the related .fxml-file
	 * with the {@link ResourceLoader} class.
	 */
	private static final Scene SCENE = ResourceLoader.loadScene(TrainingFacility.class, "training_facility_view.fxml");


	private static final Logger LOGGER = new Logger(TrainingFacility.class.getSimpleName());

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
	private AnchorPane precShooterAttributePane;

	@FXML
	private ImageView precShooterImageView;

	@FXML
	private Button precShooterUpgradeButton;

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
	private Label spaceMarineLabel;

	@FXML
	private Label officerLabel;

	@FXML
	private Label engineerLabel;

	@FXML
	private Label medicLabel;

	@FXML
	private Label sniperLabel;

	@FXML
	private Label rangerLabel;

	@FXML
	private Label lieutenantLabel;

	@FXML
	private Label precShooterLabel;

	@FXML
	private Label infantryLabel;

	@FXML
	private Label guardLabel;

	@FXML
	private Label grenadierLabel;

	@FXML
	private Label recruitLabel;


	@FXML
	void onEngineerUpgrade (final ActionEvent ignored)
	{
		UpgradeDialogDelegate.show(Engineer.getInstance(), TroopController.getInstance());
	}


	@FXML
	void onGrenadierUpgrade (final ActionEvent ignored)
	{
		UpgradeDialogDelegate.show(Grenadier.getInstance(), TroopController.getInstance());
	}


	@FXML
	void onGuardUpgrade (final ActionEvent ignored)
	{
		UpgradeDialogDelegate.show(Guard.getInstance(), TroopController.getInstance());
	}


	@FXML
	void onInfantryUpgrade (final ActionEvent ignored)
	{
		UpgradeDialogDelegate.show(Infantry.getInstance(), TroopController.getInstance());
	}


	@FXML
	void onLieutenantUpgrade (final ActionEvent ignored)
	{
		UpgradeDialogDelegate.show(Lieutenant.getInstance(), TroopController.getInstance());
	}


	@FXML
	void onMedicUpgrade (final ActionEvent ignored)
	{
		UpgradeDialogDelegate.show(Medic.getInstance(), TroopController.getInstance());
	}


	@FXML
	void onOfficerUpgrade (final ActionEvent ignored)
	{
		UpgradeDialogDelegate.show(Officer.getInstance(), TroopController.getInstance());
	}


	@FXML
	void onPrecisionShooterUpgrade (final ActionEvent ignored)
	{
		UpgradeDialogDelegate.show(PrecisionShooter.getInstance(), TroopController.getInstance());
	}


	@FXML
	void onRangerUpgrade (final ActionEvent ignored)
	{
		UpgradeDialogDelegate.show(Ranger.getInstance(), TroopController.getInstance());
	}


	@FXML
	void onRecruitUpgrade (final ActionEvent ignored)
	{
		UpgradeDialogDelegate.show(Recruit.getInstance(), TroopController.getInstance());
	}


	@FXML
	void onSniperUpgrade (final ActionEvent ignored)
	{
		UpgradeDialogDelegate.show(Sniper.getInstance(), TroopController.getInstance());
	}


	@FXML
	void onSpaceMarineUpgrade (final ActionEvent ignored)
	{
		UpgradeDialogDelegate.show(SpaceMarine.getInstance(), TroopController.getInstance());
	}


	public static void show ()
	{
		// Loading the FXML-File and creating a scene from the loaded components
		GameApplication.getStage().setScene(SCENE);
		GameApplication.getStage().show();

		// Logging the display of the building
		LOGGER.log(DEBUG, MessageFormat.format(SHOWING_VIEW_MSG, Barracks.getInstance().getName()));
	}


	/**
	 * Initialises the fxml-view and sets program-specific bindings and properties.
	 *
	 * @param url            The {@link URL} object, which represents the fxml-file of the view.
	 * @param resourceBundle A {@link ResourceBundle} object, which contains locale-specific objects.
	 */
	@Override
	public void initialize (final URL url, final ResourceBundle resourceBundle)
	{
		this.factionsTabPane.getStyleClass().add(TAB_PANE_STYLE);
		this.mainAnchorPane.getChildren().add(CurrencyController.getCurrencyBannerScene().getRoot());

		this.initTroopSpecificControls(SpaceMarine.getInstance(), this.spaceMarineLabel, this.spaceMarineImageView, this.spaceMarineUpgradeButton, this.spaceMarineAttributePane);
		this.initTroopSpecificControls(Officer.getInstance(), this.officerLabel, this.officerImageView, this.officerUpgradeButton, this.officerAttributePane);
		this.initTroopSpecificControls(Engineer.getInstance(), this.engineerLabel, this.engineerImageView, this.engineerUpgradeButton, this.engineerAttributePane);

		this.initTroopSpecificControls(Medic.getInstance(), this.medicLabel, this.medicImageView, this.medicUpgradeButton, this.medicAttributePane);
		this.initTroopSpecificControls(Sniper.getInstance(), this.sniperLabel, this.sniperImageView, this.sniperUpgradeButton, this.sniperAttributePane);
		this.initTroopSpecificControls(Ranger.getInstance(), this.rangerLabel, this.rangerImageView, this.rangerUpgradeButton, this.rangerAttributePane);

		this.initTroopSpecificControls(Lieutenant.getInstance(), this.lieutenantLabel, this.lieutenantImageView, this.lieutenantUpgradeButton, this.lieutenantAttributePane);
		this.initTroopSpecificControls(PrecisionShooter.getInstance(), this.precShooterLabel, this.precShooterImageView, this.precShooterUpgradeButton, this.precShooterAttributePane);
		this.initTroopSpecificControls(Infantry.getInstance(), this.infantryLabel, this.infantryImageView, this.infantryUpgradeButton, this.infantryAttributePane);

		this.initTroopSpecificControls(Guard.getInstance(), this.guardLabel, this.guardImageView, this.guardUpgradeButton, this.guardAttributePane);
		this.initTroopSpecificControls(Grenadier.getInstance(), this.grenadierLabel, this.grenadierImageView, this.grenadierUpgradeButton, this.grenadierAttributePane);
		this.initTroopSpecificControls(Recruit.getInstance(), this.recruitLabel, this.recruitImageView, this.recruitUpgradeButton, this.recruitAttributePane);
	}


	private void initTroopSpecificControls (final Troop troop, final Label nameLabel, final ImageView spriteView, final Button upgradeButton, final AnchorPane attributePane)
	{
		nameLabel.textProperty().bind(troop.getNameProperty());
		spriteView.imageProperty().bind(troop.getSpriteProperty());
		upgradeButton.disableProperty().bind(troop.getIsMaxLevelProperty());
		attributePane.getChildren().add(TroopController.getAttributeGridPane(troop));
	}


	@FXML
	void onBackToCityView (final ActionEvent ignored)
	{
		CityDelegate.show(GameApplication.getStage());
	}

}
