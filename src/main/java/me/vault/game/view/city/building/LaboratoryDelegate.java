package me.vault.game.view.city.building;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import me.vault.game.GameApplication;
import me.vault.game.control.CityBuildingController;
import me.vault.game.control.EnergyAbilityController;
import me.vault.game.model.artifact.Artifact;
import me.vault.game.model.artifact.implementation.DamageArtifact;
import me.vault.game.model.city.implementation.Laboratory;
import me.vault.game.model.energy.EnergyAbility;
import me.vault.game.model.energy.implementation.DodgeAbility;
import me.vault.game.model.energy.implementation.InitiativeAbility;
import me.vault.game.model.energy.implementation.MeleeAbility;
import me.vault.game.utility.ViewUtil;
import me.vault.game.utility.fx.MultiplierVBox;
import me.vault.game.utility.loading.ResourceLoader;
import me.vault.game.view.UpgradeDialogDelegate;
import me.vault.game.view.city.CityDelegate;
import me.vault.game.view.city.CurrencyDelegate;

import java.net.URL;
import java.text.MessageFormat;
import java.util.ResourceBundle;


/**
 * The {@code LaboratoryDelegate} handles the control and view of the {@link Laboratory} city building.
 * <br>
 * On the one hand, it initializes the view from the fxml-file and binds properties from the model to the view.
 * <br>
 * On the other hand it provides methods to control the model to the {@link Laboratory} city building.
 *
 * @author Lasse-Leander Hillen, Vincent Wolf, Timothy Hoegen-Jupp, Alexander Goethel
 * @version 1.0.0
 * @see CityBuildingController
 * @see Initializable
 * @see Laboratory
 * @since 11.06.2024
 */
public final class LaboratoryDelegate implements Initializable
{

	/**
	 * The path to the respective fxml file of the delegate as a {@link String}.
	 */
	private static final String LABORATORY_VIEW_FXML = "laboratory_view.fxml";

	/**
	 * The pattern used to create the string which describes the class in a human-readable format.
	 */
	private static final String TO_STRING_PATTERN = "LaboratoryDelegate'{'fxml={0}'}'";

	/**
	 * The {@link AnchorPane} at the top-most position in the scene-tree.
	 */
	@FXML
	private AnchorPane mainPane;

	/**
	 * The {@link HBox} that contains the multipliers for the {@link MeleeAbility}
	 */
	@FXML
	private HBox meleeHBox;

	/**
	 * The {@link HBox} that contains the multipliers for the {@link DodgeAbility}
	 */
	@FXML
	private HBox dodgeHBox;

	/**
	 * The {@link HBox} that contains the multipliers for the {@link InitiativeAbility}
	 */
	@FXML
	private HBox initiativeHBox;

	/**
	 * The {@link Label} that contains the name for the {@link DodgeAbility}
	 */
	@FXML
	private Label dodgeLabel;

	/**
	 * The {@link Label} that contains the name for the {@link InitiativeAbility}
	 */
	@FXML
	private Label initiativeLabel;

	/**
	 * The {@link Label} that contains the name for the {@link MeleeAbility}
	 */
	@FXML
	private Label meleeLabel;

	/**
	 * The {@link Button} that allows the upgrade of the {@link DodgeAbility}
	 */
	@FXML
	private Button dodgeUpgradeButton;

	/**
	 * The {@link Button} that allows the upgrade of the {@link DamageArtifact}
	 */
	@FXML
	private Button initiativeUpgradeButton;

	/**
	 * The {@link Button} that allows the upgrade of the {@link MeleeAbility}
	 */
	@FXML
	private Button meleeUpgradeButton;


	/**
	 * Calls a method to display the content stored in {@link LaboratoryDelegate#LABORATORY_VIEW_FXML} and initialized
	 * by {@link LaboratoryDelegate#initialize(URL, ResourceBundle)} on the main stage of this application
	 * ({@link GameApplication#getStage()})
	 *
	 * @precondition The GameApplication has to have a stage.
	 * @postcondition The initialized view is shown on the GameApplication Stage.
	 */
	public static void show ()
	{
		ViewUtil.show(GameApplication.getStage(), ResourceLoader.loadScene(LaboratoryDelegate.class, LABORATORY_VIEW_FXML), LaboratoryDelegate.class);
	}


	/**
	 * Initializes the fxml-view and sets program-specific bindings and properties. Gets called internally by JavaFX.
	 *
	 * @param url            The {@link URL} object, which acts like a pointer to the ressource of the fxml-file.
	 * @param resourceBundle A {@link ResourceBundle} object, which contains locale-specific objects.
	 *
	 * @precondition The passed parameters contain all relevant information needed to initialize the fxml-view.
	 * @postcondition The fxml-view gets initialized and the procedure within the method is run at initialization.
	 */
	@Override
	public void initialize (final URL url, final ResourceBundle resourceBundle)
	{
		this.mainPane.getChildren().add(CurrencyDelegate.getCurrencyBannerScene().getRoot());
		this.bindEnergyTextProperties();
		this.addMultiplierBoxes();
		this.bindUpgradeButtonProperties();
	}


	/**
	 * Binds the {@link Artifact#getIsMaxLevelProperty()} of the abilities to the disableProperty() of the upgrade buttons on the GUI.
	 * This causes that the user isn't able to upgrade the abilities past their maximum level.
	 *
	 * @precondition The view has been initialized and the method got called.
	 * @postcondition The upgrade buttons on the GUI have been turned off if the relative ability is already at maximum level.
	 */
	private void bindUpgradeButtonProperties ()
	{
		this.dodgeUpgradeButton.disableProperty().bind(DodgeAbility.getInstance().getIsMaxLevelProperty());
		this.initiativeUpgradeButton.disableProperty().bind(InitiativeAbility.getInstance().getIsMaxLevelProperty());
		this.meleeUpgradeButton.disableProperty().bind(MeleeAbility.getInstance().getIsMaxLevelProperty());
	}


	/**
	 * Binds the {@link EnergyAbility#getNameProperty()} of the abilities to the textProperty() of the ability labels on the GUI.
	 * This causes that the user has feedback on the design of the laboratory when he upgrades an ability to the next level.
	 *
	 * @precondition The view has been initialized and the method got called.
	 * @postcondition The ability labels have the same text values as the name of their relative ability.
	 */
	private void bindEnergyTextProperties ()
	{
		this.dodgeLabel.textProperty().bind(DodgeAbility.getInstance().getNameProperty());
		this.initiativeLabel.textProperty().bind(InitiativeAbility.getInstance().getNameProperty());
		this.meleeLabel.textProperty().bind(MeleeAbility.getInstance().getNameProperty());
	}


	/**
	 * Adds the multiplier of the different abilities to the GUI by adding {@link MultiplierVBox}es to pre-defined fxml {@link HBox} controls.
	 *
	 * @precondition The view has been initialized and the method got called.
	 * @postcondition The {@link MultiplierVBox}es have been added to pre-defined fxml {@link HBox} controls and display the multipliers of their
	 * relative ability.
	 */
	private void addMultiplierBoxes ()
	{
		this.dodgeHBox.getChildren().add(new MultiplierVBox(DodgeAbility.getInstance().getAbilityMultiplier()));
		this.initiativeHBox.getChildren().add(new MultiplierVBox(InitiativeAbility.getInstance().getAbilityMultiplier()));
		this.meleeHBox.getChildren().add(new MultiplierVBox(MeleeAbility.getInstance().getAbilityMultiplier()));
	}


	/**
	 * Handles the {@code Click}-{@link ActionEvent} of the "Upgrade Dodge Ability" {@link Button} in the GUI.
	 * Shows the dialog of the {@link UpgradeDialogDelegate} for the {@link DodgeAbility}.
	 *
	 * @param ignored The {@link ActionEvent} which represents the action of the {@link Button} press. Not used in this case.
	 *
	 * @precondition The {@link Button} on the GUI gets clicked and JavaFx generates the {@link ActionEvent}.
	 * @postcondition The {@link Scene} of the {@link UpgradeDialogDelegate} is displayed on a new {@link Stage}.
	 */
	@FXML
	private void onDodgeAbilityUpgrade (final ActionEvent ignored)
	{
		UpgradeDialogDelegate.show(DodgeAbility.getInstance(), EnergyAbilityController.getInstance());

	}


	/**
	 * Handles the {@code Click}-{@link ActionEvent} of the "Upgrade Initiative Ability" {@link Button} in the GUI.
	 * Shows the dialog of the {@link UpgradeDialogDelegate} for the {@link InitiativeAbility}.
	 *
	 * @param ignored The {@link ActionEvent} which represents the action of the {@link Button} press. Not used in this case.
	 *
	 * @precondition The {@link Button} on the GUI gets clicked and JavaFx generates the {@link ActionEvent}.
	 * @postcondition The {@link Scene} of the {@link UpgradeDialogDelegate} is displayed on a new {@link Stage}.
	 */
	@FXML
	private void onInitiativeAbilityUpgrade (final ActionEvent ignored)
	{
		UpgradeDialogDelegate.show(InitiativeAbility.getInstance(), EnergyAbilityController.getInstance());
	}


	/**
	 * Handles the {@code Click}-{@link ActionEvent} of the "Upgrade Melee Ability" {@link Button} in the GUI.
	 * Shows the dialog of the {@link UpgradeDialogDelegate} for the {@link MeleeAbility}.
	 *
	 * @param ignored The {@link ActionEvent} which represents the action of the {@link Button} press. Not used in this case.
	 *
	 * @precondition The {@link Button} on the GUI gets clicked and JavaFx generates the {@link ActionEvent}.
	 * @postcondition The {@link Scene} of the {@link UpgradeDialogDelegate} is displayed on a new {@link Stage}.
	 */
	@FXML
	private void onMeleeAbilityUpgrade (final ActionEvent ignored)
	{
		UpgradeDialogDelegate.show(MeleeAbility.getInstance(), EnergyAbilityController.getInstance());

	}


	/**
	 * Handles the {@code Click}-{@link ActionEvent} of the "Back" {@link Button} in the GUI.
	 * Shows the scene of the {@link CityDelegate} on the main {@link Stage} of the application.
	 *
	 * @param ignored The {@link ActionEvent} which represents the action of the {@link Button} press. Not used in this case.
	 *
	 * @precondition The {@link Button} on the GUI gets clicked and JavaFx generates the {@link ActionEvent}.
	 * @postcondition The current {@link Scene} in the main {@link Stage} is set to the {@link Scene} of the {@link CityDelegate}.
	 */
	@FXML
	private void onBackToCityView (final ActionEvent ignored)
	{
		CityDelegate.show();
	}


	/**
	 * Builds a formatted {@link String}, which represents the object, and it's current state using the {@link LaboratoryDelegate#TO_STRING_PATTERN}.
	 *
	 * @return A {@link String} which has been formatted in the {@link LaboratoryDelegate#TO_STRING_PATTERN}.
	 *
	 * @precondition The {@link LaboratoryDelegate#TO_STRING_PATTERN} is {@code != null}.
	 * @postcondition The method returned a {@link String} which represents the object.
	 */
	@Override
	public String toString ()
	{
		return MessageFormat.format(TO_STRING_PATTERN, LABORATORY_VIEW_FXML);
	}

}