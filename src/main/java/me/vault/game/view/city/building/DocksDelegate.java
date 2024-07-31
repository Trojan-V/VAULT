package me.vault.game.view.city.building;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import me.vault.game.GameApplication;
import me.vault.game.control.CityBuildingController;
import me.vault.game.control.PlayerController;
import me.vault.game.model.Player;
import me.vault.game.model.city.impl.Docks;
import me.vault.game.model.troop.Faction;
import me.vault.game.utility.ViewUtil;
import me.vault.game.utility.loading.ResourceLoader;
import me.vault.game.utility.logging.ILogger;
import me.vault.game.utility.logging.Logger;
import me.vault.game.view.city.CityDelegate;
import me.vault.game.view.city.CurrencyDelegate;

import java.net.URL;
import java.text.MessageFormat;
import java.util.ResourceBundle;

import static me.vault.game.utility.interfaces.constant.GameConstants.TAB_PANE_STYLE;


/**
 * The {@code DocksDelegate} handles the control and view of the {@link Docks} city building.
 * <br>
 * On the one hand, it initializes the view from the fxml-file and binds properties from the model to the view.
 * <br>
 * On the other hand, it provides methods to control the model to the {@link Docks} cty building.
 *
 * @author Lasse-Leander Hillen, Vincent Wolf, Timothy Hoegen-Jupp, Alexander Goethel
 * @version 1.0.0
 * @see CityBuildingController
 * @see Initializable
 * @see Docks
 * @since 11.06.2024
 */
public final class DocksDelegate implements Initializable
{

	/**
	 * The {@link Logger} object for this class used for writing to the console.
	 */
	private static final ILogger LOGGER = new Logger(DocksDelegate.class.getSimpleName());

	/**
	 * The path to the respective fxml file of the delegate as a {@link String}.
	 */
	private static final String DOCKS_VIEW_FXML = "docks_view.fxml";

	/**
	 * The pattern used to create the string which describes the class in a human-readable format.
	 */
	private static final String TO_STRING_PATTERN = "DocksDelegate[fxml={0}]";


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

	/**
	 * The {@link Button} which provides the capabilities to select the explorer faction.
	 */
	@FXML
	private Button chooseExplorerFactionButton;

	/**
	 * The {@link Button} which provides the capabilities to select the militaristic faction.
	 */
	@FXML
	private Button chooseMilitaryFactionButton;


	/**
	 * Calls a method to display the content stored in {@link DocksDelegate#DOCKS_VIEW_FXML} and initialized
	 * by {@link DocksDelegate#initialize(URL, ResourceBundle)} on the main stage of this application
	 * ({@link GameApplication#getStage()})
	 *
	 * @precondition The GameApplication has to have a stage.
	 * @postcondition The initialized view is shown on the GameApplication Stage.
	 */
	public static void show ()
	{
		ViewUtil.show(GameApplication.getStage(), ResourceLoader.loadScene(DocksDelegate.class, DOCKS_VIEW_FXML), DocksDelegate.class);
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
		this.docksAnchorPane.getChildren().add(CurrencyDelegate.getCurrencyBannerScene().getRoot());
		this.chooseExplorerFactionButton.disableProperty().bind(Faction.EXPLORER_ASSOCIATION.getIsSelectedProperty());
		this.chooseMilitaryFactionButton.disableProperty().bind(Faction.MILITARISTIC_GOVERNMENT.getIsSelectedProperty());
	}


	/**
	 * Handles the {@code Click}-{@link ActionEvent} of the "Choose Explorer" {@link Button} in the GUI.
	 * Sets the {@link Faction#EXPLORER_ASSOCIATION} faction to the selected faction of the player.
	 *
	 * @param ignored The {@link ActionEvent} which represents the action of the {@link Button} press. Not used in this case.
	 *
	 * @precondition The {@link Button} on the GUI gets clicked and JavaFx generates the {@link ActionEvent}.
	 * @postcondition The selected faction of the player has been set to the {@link Faction#EXPLORER_ASSOCIATION} faction.
	 */
	@FXML
	void onChooseExplorerFaction (final ActionEvent ignored)
	{
		PlayerController.changeSelectedFaction(Player.getInstance(), Faction.EXPLORER_ASSOCIATION);
	}


	/**
	 * Handles the {@code Click}-{@link ActionEvent} of the "Choose Militaristic" {@link Button} in the GUI.
	 * Sets the {@link Faction#MILITARISTIC_GOVERNMENT} faction to the selected faction of the player.
	 *
	 * @param ignored The {@link ActionEvent} which represents the action of the {@link Button} press. Not used in this case.
	 *
	 * @precondition The {@link Button} on the GUI gets clicked and JavaFx generates the {@link ActionEvent}.
	 * @postcondition The selected faction of the player has been set to the {@link Faction#MILITARISTIC_GOVERNMENT} faction.
	 */
	@FXML
	void onChooseMilitaristicFaction (final ActionEvent ignored)
	{
		PlayerController.changeSelectedFaction(Player.getInstance(), Faction.MILITARISTIC_GOVERNMENT);
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
	void onBackToCityView (final ActionEvent ignored)
	{
		CityDelegate.show();
	}


	/**
	 * Builds a formatted {@link String}, which represents the object, and it's current state using the {@link DocksDelegate#TO_STRING_PATTERN}.
	 *
	 * @return A {@link String} which has been formatted in the {@link DocksDelegate#TO_STRING_PATTERN}.
	 *
	 * @precondition The {@link DocksDelegate#TO_STRING_PATTERN} is {@code != null}.
	 * @postcondition The method returned a {@link String} which represents the object.
	 */
	@Override
	public String toString ()
	{
		return MessageFormat.format(TO_STRING_PATTERN, DOCKS_VIEW_FXML);
	}

}
