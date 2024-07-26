package me.vault.game.view.city.buildings;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import me.vault.game.GameApplication;
import me.vault.game.control.CityBuildingController;
import me.vault.game.control.CurrencyController;
import me.vault.game.control.EnergyAbilityConroller;
import me.vault.game.model.city.Laboratory;
import me.vault.game.model.energy.AbilityMultiplier;
import me.vault.game.model.energy.impl.DodgeAbility;
import me.vault.game.model.energy.impl.InitiativeAbility;
import me.vault.game.model.energy.impl.MeleeAbility;
import me.vault.game.utility.loading.ResourceLoader;
import me.vault.game.utility.logging.ILogger;
import me.vault.game.utility.logging.Logger;
import me.vault.game.view.UpgradeDialogDelegate;
import me.vault.game.view.city.CityDelegate;

import java.net.URL;
import java.text.MessageFormat;
import java.util.ResourceBundle;

import static me.vault.game.utility.constant.LoggingConstants.SHOWING_VIEW_MSG;
import static me.vault.game.utility.logging.ILogger.Level.DEBUG;


public class LaboratoryDelegate extends CityBuildingController implements Initializable
{

	/**
	 * The {@link Scene} of the {@link Laboratory} city building, which is extracted from the related .fxml-file with
	 * the {@link ResourceLoader} class.
	 */
	private static final Scene SCENE = ResourceLoader.loadScene(Laboratory.class, "laboratory_view.fxml");

	// CONSTANTS -------------------------------------------------------------------------------------------------------

	/**
	 * The {@link Logger} object for this class used for writing to the console.
	 */
	private static final ILogger LOGGER = new Logger(LaboratoryDelegate.class.getSimpleName());


	// FXML ------------------------------------------------------------------------------------------------------------

	@FXML
	private AnchorPane mainPane;

	@FXML
	private ImageView dodgeImageView;

	@FXML
	private Label dodgeLabel;

	@FXML
	private Button dodgeUpgradeButton;

	@FXML
	private ImageView initiativeImageView;

	@FXML
	private Label initiativeLabel;

	@FXML
	private Button initiativeUpgradeButton;

	@FXML
	private ImageView meleeImageView;

	@FXML
	private Label meleeLabel;

	@FXML
	private Button meleeUpgradeButton;

	@FXML
	private Label dodgeEnergyAbilityDodgeModifierLabel;

	@FXML
	private Label dodgeEnergyAbilityInitiativeModifierLabel;

	@FXML
	private Label dodgeEnergyAbilityMeleeModifierLabel;

	@FXML
	private Label initiativeEnergyAbilityDodgeModifierLabel;

	@FXML
	private Label initiativeEnergyAbilityInitiativeModifierLabel;

	@FXML
	private Label initiativeEnergyAbilityMeleeModifierLabel;

	@FXML
	private Label meleeEnergyAbilityDodgeModifierLabel;

	@FXML
	private Label meleeEnergyAbilityInitiativeModifierLabel;

	@FXML
	private Label meleeEnergyAbilityMeleeModifierLabel;


	public static void show ()
	{
		// Loading the FXML-File and creating a scene from the loaded components
		GameApplication.getStage().setScene(SCENE);
		GameApplication.getStage().show();

		// Logging the display of the building
		LOGGER.log(DEBUG, MessageFormat.format(SHOWING_VIEW_MSG, Laboratory.getInstance().getName()));
	}


	@FXML
	private void onDodgeAbilityUpgrade (final ActionEvent ignored)
	{
		UpgradeDialogDelegate.show(DodgeAbility.getInstance(), EnergyAbilityConroller.getInstance());
	}


	@FXML
	private void onInitiativeAbilityUpgrade (final ActionEvent ignored)
	{
		UpgradeDialogDelegate.show(InitiativeAbility.getInstance(), EnergyAbilityConroller.getInstance());
	}


	@FXML
	private void onMeleeAbilityUpgrade (final ActionEvent ignored)
	{
		UpgradeDialogDelegate.show(MeleeAbility.getInstance(), EnergyAbilityConroller.getInstance());
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
		this.mainPane.getChildren().add(CurrencyController.getCurrencyBannerScene().getRoot());
		this.bindEnergyTextProperties();
		this.bindEnergyImageProperties();
		this.bindEnergyMultiplierTextProperties();
		this.bindUpgradeButtonProperties();

	}


	private void bindUpgradeButtonProperties ()
	{
		this.dodgeUpgradeButton.disableProperty().bind(DodgeAbility.getInstance().getIsMaxLevelProperty());
		this.initiativeUpgradeButton.disableProperty().bind(InitiativeAbility.getInstance().getIsMaxLevelProperty());
		this.meleeUpgradeButton.disableProperty().bind(MeleeAbility.getInstance().getIsMaxLevelProperty());
	}


	private void bindEnergyTextProperties ()
	{
		this.dodgeUpgradeButton.textProperty().bind(DodgeAbility.getInstance().getNameProperty());
		this.initiativeUpgradeButton.textProperty().bind(InitiativeAbility.getInstance().getNameProperty());
		this.meleeUpgradeButton.textProperty().bind(MeleeAbility.getInstance().getNameProperty());
	}


	private void bindEnergyImageProperties ()
	{
		this.dodgeImageView.imageProperty().bind(DodgeAbility.getInstance().getSpriteProperty());
		this.initiativeImageView.imageProperty().bind(InitiativeAbility.getInstance().getSpriteProperty());
		this.meleeImageView.imageProperty().bind(MeleeAbility.getInstance().getSpriteProperty());
	}


	private void bindEnergyMultiplierTextProperties ()
	{
		final AbilityMultiplier dodgeAbilityModifiers = DodgeAbility.getInstance().getAbilityMultiplier();
		this.dodgeEnergyAbilityDodgeModifierLabel.textProperty().bind(dodgeAbilityModifiers.getDodgeMultiplierProperty().asString());
		this.dodgeEnergyAbilityInitiativeModifierLabel.textProperty().bind(dodgeAbilityModifiers.getInitiativeMultiplierProperty().asString());
		this.dodgeEnergyAbilityMeleeModifierLabel.textProperty().bind(dodgeAbilityModifiers.getMeleeMultiplierProperty().asString());

		final AbilityMultiplier initiativeAbilityModifiers = InitiativeAbility.getInstance().getAbilityMultiplier();
		this.initiativeEnergyAbilityDodgeModifierLabel.textProperty().bind(initiativeAbilityModifiers.getDodgeMultiplierProperty().asString());
		this.initiativeEnergyAbilityInitiativeModifierLabel.textProperty().bind(initiativeAbilityModifiers.getInitiativeMultiplierProperty().asString());
		this.initiativeEnergyAbilityMeleeModifierLabel.textProperty().bind(initiativeAbilityModifiers.getMeleeMultiplierProperty().asString());

		final AbilityMultiplier meleeAbilityModifiers = MeleeAbility.getInstance().getAbilityMultiplier();
		this.meleeEnergyAbilityDodgeModifierLabel.textProperty().bind(meleeAbilityModifiers.getDodgeMultiplierProperty().asString());
		this.meleeEnergyAbilityInitiativeModifierLabel.textProperty().bind(meleeAbilityModifiers.getInitiativeMultiplierProperty().asString());
		this.meleeEnergyAbilityMeleeModifierLabel.textProperty().bind(meleeAbilityModifiers.getMeleeMultiplierProperty().asString());
	}


	@FXML
	private void onBackToCityView (final ActionEvent ignored)
	{
		CityDelegate.show(GameApplication.getStage());
	}

}
