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
import me.vault.game.model.city.Laboratory;
import me.vault.game.utility.loading.ResourceLoader;
import me.vault.game.utility.logging.ILogger;
import me.vault.game.utility.logging.Logger;
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
	private ImageView ability1ImageView;

	@FXML
	private Label ability1Label;

	@FXML
	private Button ability1UpgradeButton;

	@FXML
	private ImageView ability2ImageView;

	@FXML
	private Label ability2Label;

	@FXML
	private Button ability2UpgradeButton;

	@FXML
	private ImageView ability3ImageView;

	@FXML
	private Label ability3Label;

	@FXML
	private Button ability3UpgradeButton;

	@FXML
	private Label damageArtifactDamageModifierLabel;

	@FXML
	private Label damageArtifactDefenseModifierLabel;

	@FXML
	private Label damageArtifactHealthModifierLabel;

	@FXML
	private Label defenseArtifactDamageModifierLabel;

	@FXML
	private Label defenseArtifactDefenseModifierLabel;

	@FXML
	private Label defenseArtifactHealthModifierLabel;

	@FXML
	private Label healthArtifactDamageModifierLabel;

	@FXML
	private Label healthArtifactDefenseModifierLabel;

	@FXML
	private Label healthArtifactHealthModifierLabel;


	@FXML
	void onAbilityOneUpgrade (final ActionEvent event)
	{

	}


	@FXML
	void onAbilityThreeUpgrade (final ActionEvent event)
	{

	}


	@FXML
	void onAbilityTwoUpgrade (final ActionEvent event)
	{

	}


	public static void show ()
	{
		// Loading the FXML-File and creating a scene from the loaded components
		GameApplication.getStage().setScene(SCENE);
		GameApplication.getStage().show();

		// Logging the display of the building
		LOGGER.log(DEBUG, MessageFormat.format(SHOWING_VIEW_MSG, Laboratory.getInstance().getName()));
	}


	@FXML
	void onDamageArtifactUpgrade (final ActionEvent event)
	{

	}


	@FXML
	void onDefenseArtifactUpgrade (final ActionEvent event)
	{

	}


	@FXML
	void onHealthArtifactUpgrade (final ActionEvent event)
	{

	}


	@FXML
	void onBackToCityView (final ActionEvent ignored)
	{
		CityDelegate.show(GameApplication.getStage());
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

	}

}
