package me.vault.game.view.city.building;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import me.vault.game.GameApplication;
import me.vault.game.control.ArtifactController;
import me.vault.game.control.CityBuildingController;
import me.vault.game.control.CurrencyController;
import me.vault.game.model.artifact.AttributeMultiplier;
import me.vault.game.model.artifact.impl.DamageArtifact;
import me.vault.game.model.artifact.impl.DefenseArtifact;
import me.vault.game.model.artifact.impl.HealthArtifact;
import me.vault.game.model.city.Workshop;
import me.vault.game.utility.ViewUtil;
import me.vault.game.utility.fx.ModifierVBox;
import me.vault.game.utility.loading.ResourceLoader;
import me.vault.game.utility.logging.ILogger;
import me.vault.game.utility.logging.Logger;
import me.vault.game.view.UpgradeDialogDelegate;
import me.vault.game.view.city.CityDelegate;

import java.net.URL;
import java.text.MessageFormat;
import java.util.ResourceBundle;


/**
 * The {@code DocksDelegate} handles the control and view of the {@link Workshop} city building.
 * <br>
 * On the one hand it initialises the view from the fxml-file and binds properties from the model to the view.
 * <br>
 * On the other hand it provides methods to control the model to the {@link Workshop} city building.
 *
 * @author Lasse-Leander Hillen, Vincent Wolf, Timothy Hoegen-Jupp, Alexander Goethel
 * @see CityBuildingController
 * @see Initializable
 * @see Workshop
 * @since 11.06.2024
 */
public final class WorkshopDelegate implements Initializable
{

	/**
	 * The {@link Logger} object for this class used for writing to the console.
	 */
	private static final ILogger LOGGER = new Logger(WorkshopDelegate.class.getSimpleName());

	private static final String WORKSHOP_VIEW_FXML = "workshop_view.fxml";

	private static final String TO_STRING_PATTERN = "WorkshopDelegate'{'fxml={0}'}'";

	@FXML
	private AnchorPane mainPane;

	@FXML
	private HBox healthHBox;

	@FXML
	private HBox damageHBox;

	@FXML
	private HBox defenseHBox;

	@FXML
	private ImageView damageArtifactImageView;

	@FXML
	private Label damageArtifactLabel;

	@FXML
	private Button damageUpgradeButton;

	@FXML
	private ImageView defenseArtifactImageView;

	@FXML
	private Label defenseArtifactLabel;

	@FXML
	private Button defenseUpgradeButton;

	@FXML
	private ImageView healthArtifactImageView;

	@FXML
	private Label healthArtifactLabel;

	@FXML
	private Button healthUpgradeButton;


	/**
	 * Calls a method to display the content stored in {@link WorkshopDelegate#WORKSHOP_VIEW_FXML} and initialized
	 * by {@link WorkshopDelegate#initialize(URL, ResourceBundle)} on the main stage of this application
	 * ({@link GameApplication#getStage()})
	 *
	 * @precondition The GameApplication has to have a stage.
	 * @postcondition The initialized view is shown on the GameApplication Stage.
	 */
	public static void show ()
	{
		ViewUtil.show(GameApplication.getStage(), ResourceLoader.loadScene(WorkshopDelegate.class, WORKSHOP_VIEW_FXML), WorkshopDelegate.class);
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
		this.mainPane.getChildren().add(CurrencyController.getCurrencyBannerScene().getRoot());
		this.bindArtifactTextProperties();
		this.bindArtifactImageProperties();
		this.bindArtifactMultiplierTextProperties();
		this.bindUpgradeButtonProperties();

	}


	@FXML
	private void onDamageArtifactUpgrade (final ActionEvent ignored)
	{
		UpgradeDialogDelegate.show(DamageArtifact.getInstance(), ArtifactController.getInstance());
	}


	@FXML
	private void onDefenseArtifactUpgrade (final ActionEvent ignored)
	{
		UpgradeDialogDelegate.show(DefenseArtifact.getInstance(), ArtifactController.getInstance());
	}


	@FXML
	private void onHealthArtifactUpgrade (final ActionEvent ignored)
	{
		UpgradeDialogDelegate.show(HealthArtifact.getInstance(), ArtifactController.getInstance());
	}


	private void bindUpgradeButtonProperties ()
	{
		this.healthUpgradeButton.disableProperty().bind(HealthArtifact.getInstance().getIsMaxLevelProperty());
		this.defenseUpgradeButton.disableProperty().bind(DefenseArtifact.getInstance().getIsMaxLevelProperty());
		this.damageUpgradeButton.disableProperty().bind(DamageArtifact.getInstance().getIsMaxLevelProperty());
	}


	private void bindArtifactTextProperties ()
	{
		this.healthArtifactLabel.textProperty().bind(HealthArtifact.getInstance().getNameProperty());
		this.defenseArtifactLabel.textProperty().bind(DefenseArtifact.getInstance().getNameProperty());
		this.damageArtifactLabel.textProperty().bind(DamageArtifact.getInstance().getNameProperty());
	}


	private void bindArtifactImageProperties ()
	{
		this.healthArtifactImageView.imageProperty().bind(HealthArtifact.getInstance().getSpriteProperty());
		this.damageArtifactImageView.imageProperty().bind(DamageArtifact.getInstance().getSpriteProperty());
		this.defenseArtifactImageView.imageProperty().bind(DefenseArtifact.getInstance().getSpriteProperty());
	}


	private void bindArtifactMultiplierTextProperties ()
	{
		this.healthHBox.getChildren().add(new ModifierVBox(HealthArtifact.getInstance().getAttributeMultipliers()));
		this.damageHBox.getChildren().add(new ModifierVBox(DamageArtifact.getInstance().getAttributeMultipliers()));
		this.defenseHBox.getChildren().add(new ModifierVBox(DefenseArtifact.getInstance().getAttributeMultipliers()));
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
	 * Builds a formatted {@link String}, which represents the object, and it's current state using the {@link WorkshopDelegate#TO_STRING_PATTERN}.
	 *
	 * @return A {@link String} which has been formatted in the {@link WorkshopDelegate#TO_STRING_PATTERN}.
	 *
	 * @precondition The {@link WorkshopDelegate#TO_STRING_PATTERN} is {@code != null}.
	 * @postcondition The method returned a {@link String} which represents the object.
	 */
	@Override
	public String toString ()
	{
		return MessageFormat.format(TO_STRING_PATTERN, WORKSHOP_VIEW_FXML);
	}

}
