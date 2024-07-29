package me.vault.game.view.city.buildings;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import me.vault.game.GameApplication;
import me.vault.game.control.CityBuildingController;
import me.vault.game.control.CurrencyController;
import me.vault.game.control.PlayerController;
import me.vault.game.model.city.Barracks;
import me.vault.game.model.city.Docks;
import me.vault.game.model.player.Player;
import me.vault.game.model.troop.Faction;
import me.vault.game.utility.loading.ResourceLoader;
import me.vault.game.utility.logging.ILogger;
import me.vault.game.utility.logging.Logger;
import me.vault.game.view.city.CityDelegate;

import java.net.URL;
import java.text.MessageFormat;
import java.util.ResourceBundle;

import static me.vault.game.utility.constant.GameConstants.TAB_PANE_STYLE;
import static me.vault.game.utility.constant.LoggingConstants.SHOWING_VIEW_MSG;
import static me.vault.game.utility.logging.ILogger.Level.DEBUG;


/**
 * The {@code DocksDelegate} handles the control and view of the {@link Docks} city building. On the one hand it initialises
 * the view from the fxml-file and binds properties from the model to the view. On the other hand it provides methods to control the model to the
 * {@link Docks} cty building.
 *
 * @author Lasse-Leander Hillen, Vincent Wolf, Timothy Hoegen-Jupp, Alexander Goethel
 * @see CityBuildingController
 * @see Initializable
 * @see Docks
 * @since 11.06.2024
 */
public class DocksDelegate extends CityBuildingController implements Initializable
{

	/**
	 * The {@link Scene} of the {@link Docks} city building, which is extracted from the related .fxml-file with the
	 * {@link ResourceLoader} class.
	 */
	private static final Scene SCENE = ResourceLoader.loadScene(Docks.class, "docks_view.fxml");

	// CONSTANTS -------------------------------------------------------------------------------------------------------

	/**
	 * The {@link Logger} object for this class used for writing to the console.
	 */
	private static final ILogger LOGGER = new Logger(DocksDelegate.class.getSimpleName());

	/**
	 * The pattern used to create the string which describes the class in a human-readable format.
	 */
	private static final String TO_STRING_PATTERN = "DocksDelegate[fxml={0}]";

	/**
	 * This file is located in the directory {@code ./src/main/java/resources/me/vault/game} and defines the properties (color etc.) of the GUI
	 * elements.
	 */
	private static final Scene FXML_FILENAME = ResourceLoader.loadScene(Docks.class, "docks_view.fxml");


	// FXML ------------------------------------------------------------------------------------------------------------

	/**
	 * The {@link AnchorPane} at the top-most position in the scene-tree.
	 */
	@FXML
	private AnchorPane docksAnchorPane;

	/**
	 * The {@link TabPane}, which contains the different factions of the view.
	 */
	@FXML
	private TabPane factionsTabPane;

	@FXML
	private Button chooseExplorerFactionButton;

	@FXML
	private Button chooseMilitaryFactionButton;


	public static void show ()
	{
		// Loading the FXML-File and creating a scene from the loaded components
		GameApplication.getStage().setScene(SCENE);
		GameApplication.getStage().show();

		// Logging the display of the building
		LOGGER.log(DEBUG, MessageFormat.format(SHOWING_VIEW_MSG, Barracks.getInstance().getName()));
	}


	@FXML
	void onChooseExplorerFaction (final ActionEvent ignored)
	{
		PlayerController.changeSelectedFaction(Player.getInstance(), Faction.EXPLORER_ASSOCIATION);
	}


	@FXML
	void onChooseMilitaristicFaction (final ActionEvent ignored)
	{
		PlayerController.changeSelectedFaction(Player.getInstance(), Faction.MILITARISTIC_GOVERNMENT);
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
		this.factionsTabPane.getStyleClass().add(TAB_PANE_STYLE);
		this.docksAnchorPane.getChildren().add(CurrencyController.getCurrencyBannerScene().getRoot());
		this.chooseExplorerFactionButton.disableProperty().bind(Faction.EXPLORER_ASSOCIATION.getIsSelectedProperty());
		this.chooseMilitaryFactionButton.disableProperty().bind(Faction.MILITARISTIC_GOVERNMENT.getIsSelectedProperty());
	}


	/**
	 * Method, that gets called when the user presses the "BACK"-Button. Resets the current view to the city view.
	 *
	 * @param ignored {@link ActionEvent}-parameter, that contains information about the event-caller.
	 */
	@FXML
	void onBackToCityView (final ActionEvent ignored)
	{
		CityDelegate.show();
	}


	/**
	 * Returns the instance of this class in a human-readable format by creating a string.
	 *
	 * @return The message in its string representation.
	 */
	@Override
	public String toString ()
	{
		return MessageFormat.format(TO_STRING_PATTERN, FXML_FILENAME);
	}

}
