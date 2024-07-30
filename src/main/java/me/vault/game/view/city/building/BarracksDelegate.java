package me.vault.game.view.city.building;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import me.vault.game.GameApplication;
import me.vault.game.control.CityBuildingController;
import me.vault.game.control.CurrencyController;
import me.vault.game.control.PlayerController;
import me.vault.game.model.city.Barracks;
import me.vault.game.model.player.Player;
import me.vault.game.model.troop.Faction;
import me.vault.game.utility.ViewUtil;
import me.vault.game.utility.loading.ResourceLoader;
import me.vault.game.utility.logging.ILogger;
import me.vault.game.utility.logging.Logger;
import me.vault.game.view.city.CityDelegate;

import java.net.URL;
import java.text.MessageFormat;
import java.util.ResourceBundle;

import static me.vault.game.utility.constant.LoggingConstants.CLASS_INITIALIZED;
import static me.vault.game.utility.logging.ILogger.Level.DEBUG;


/**
 * The {@code BarracksDelegate} handles the control and view of the {@link Barracks} city building.
 * <br>
 * On the one hand, it initializes the view from the fxml-file and binds properties from the model to the view.
 * <br>
 * On the other hand, it provides methods to control the model to the {@link Barracks} cty building.
 *
 * @author Lasse-Leander Hillen, Vincent Wolf, Timothy Hoegen-Jupp, Alexander Goethel
 * @see CityBuildingController
 * @see Initializable
 * @see Barracks
 * @since 11.06.2024
 */
public final class BarracksDelegate implements Initializable
{

	/**
	 * The {@link Logger} object for this class used for writing to the console.
	 */
	private static final ILogger LOGGER = new Logger(BarracksDelegate.class.getSimpleName());

	/**
	 * The path to the respective fxml file of the delegate as a {@link String}.
	 */
	private static final String BARRACKS_VIEW_FXML = "barracks_view.fxml";

	/**
	 * The pattern used to create the string which describes the class in a human-readable format.
	 */
	private static final String TO_STRING_PATTERN = "BarracksDelegate'{'barracksAnchorPane={0}, chooseTerraFactionButton={1}'}'";

	/**
	 * The {@link AnchorPane} at the top-most position in the scene-tree.
	 */
	@FXML
	private AnchorPane barracksAnchorPane;


	/**
	 * The {@link Button} which makes it able to choose the New-Terra-Faction as the main faction.
	 */
	@FXML
	private Button chooseTerraFactionButton;


	public static void show ()
	{
		ViewUtil.show(GameApplication.getStage(), ResourceLoader.loadScene(BarracksDelegate.class, BARRACKS_VIEW_FXML), BarracksDelegate.class);
	}


	@FXML
	void onChooseTerraFaction (final ActionEvent ignored)
	{
		PlayerController.changeSelectedFaction(Player.getInstance(), Faction.NEW_TERRA);
	}


	/**
	 * A method that gets called when the user presses the "BACK"-Button, it resets the current view to the city view.
	 *
	 * @param ignored {@link ActionEvent}-parameter, that contains information about the event-caller.
	 */
	@FXML
	void onBackToCityView (final ActionEvent ignored)
	{
		CityDelegate.show();
	}


	/**
	 * Initializes the fxml-view and sets program-specific bindings and properties. Gets called internally by JavaFX.
	 *
	 * @param url            The {@link URL} object, which acts like a pointer to the ressource of the fxml-file.
	 * @param resourceBundle A {@link ResourceBundle} object, which contains locale-specific objects.
	 */
	@Override
	public void initialize (final URL url, final ResourceBundle resourceBundle)
	{
		this.barracksAnchorPane.getChildren().add(CurrencyController.getCurrencyBannerScene().getRoot());
		this.chooseTerraFactionButton.disableProperty().bind(Faction.NEW_TERRA.getIsSelectedProperty());

		// Logging the finalization of the initialization
		LOGGER.logf(DEBUG, CLASS_INITIALIZED, BarracksDelegate.class.getSimpleName());
	}


	@Override
	public String toString ()
	{
		return MessageFormat.format(TO_STRING_PATTERN, this.barracksAnchorPane, this.chooseTerraFactionButton);
	}

}
