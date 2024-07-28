package me.vault.game.view.city.buildings;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import me.vault.game.GameApplication;
import me.vault.game.control.CityBuildingController;
import me.vault.game.control.CurrencyController;
import me.vault.game.control.PlayerController;
import me.vault.game.model.city.Barracks;
import me.vault.game.model.city.SpaceBar;
import me.vault.game.model.player.Player;
import me.vault.game.model.troop.Faction;
import me.vault.game.utility.loading.ResourceLoader;
import me.vault.game.utility.logging.Logger;
import me.vault.game.view.city.CityDelegate;

import java.net.URL;
import java.text.MessageFormat;
import java.util.ResourceBundle;

import static me.vault.game.utility.constant.LoggingConstants.CLASS_INITIALIZED;
import static me.vault.game.utility.constant.LoggingConstants.SHOWING_VIEW_MSG;
import static me.vault.game.utility.logging.ILogger.Level.DEBUG;


/**
 * The {@code SpaceBarDelegate} handles the control and view of the {@link SpaceBar} city building. On the one hand, it
 * initializes the view from the fxml-file and binds properties from the model to the view. On the other hand, it provides
 * methods to control the model to the {@link SpaceBar} city building.
 *
 * @author Lasse-Leander Hillen, Vincent Wolf, Timothy Hoegen-Jupp, Alexander Goethel
 * @see CityBuildingController
 * @see Initializable
 * @see SpaceBar
 * @since 11.06.2024
 */
public class SpaceBarDelegate extends CityBuildingController implements Initializable
{

	/**
	 * The {@link Logger} object for this class used for writing to the console.
	 */
	private static final Logger LOGGER = new Logger(SpaceBarDelegate.class.getSimpleName());


	/**
	 * The {@link Scene} of the {@link SpaceBar} city building, which is extracted from the related .fxml-file with
	 * the {@link ResourceLoader} class.
	 */
	private static final Scene SCENE = ResourceLoader.loadScene(SpaceBar.class, "space_bar_view.fxml");

	private static final String TO_STRING_PATTERN = "SpaceBarDelegate'{'spaceBarAnchorPane={0}, chooseMegaCorporationButton={1}'}'";

	/**
	 * The {@link AnchorPane} at the top-most position in the scene-tree.
	 */
	@FXML
	private AnchorPane spaceBarAnchorPane;

	@FXML
	private Button chooseMegaCorporationButton;


	public static void show ()
	{
		// Loading the FXML-File and creating a scene from the loaded components
		GameApplication.getStage().setScene(SCENE);
		GameApplication.getStage().show();

		// Logging the display of the building
		LOGGER.logf(DEBUG, SHOWING_VIEW_MSG, Barracks.getInstance().getName());
	}


	/**
	 * Initializes the fxml-view and sets program-specific bindings and properties.
	 *
	 * @param url            The {@link URL} object, which represents the fxml-file of the view.
	 * @param resourceBundle A {@link ResourceBundle} object, which contains locale-specific objects.
	 */
	@Override
	public void initialize (final URL url, final ResourceBundle resourceBundle)
	{
		this.spaceBarAnchorPane.getChildren().add(CurrencyController.getCurrencyBannerScene().getRoot());
		this.chooseMegaCorporationButton.disableProperty().bind(Faction.MEGA_CORPORATION.getIsSelectedProperty());

		LOGGER.logf(DEBUG, CLASS_INITIALIZED, SpaceBarDelegate.class.getSimpleName());
	}


	@FXML
	void onChooseMegaCorporation (final ActionEvent ignored)
	{
		PlayerController.changeSelectedFaction(Player.getInstance(), Faction.MEGA_CORPORATION);
	}


	/**
	 * Method, that gets called when the user presses the "BACK"-Button. Resets the current view to the city view.
	 *
	 * @param ignored {@link ActionEvent}-parameter, that contains information about the event-caller.
	 */
	@FXML
	void onBackToCityView (final ActionEvent ignored)
	{
		CityDelegate.show(GameApplication.getStage());
	}


	@Override
	public String toString ()
	{
		return MessageFormat.format(TO_STRING_PATTERN, this.spaceBarAnchorPane, this.chooseMegaCorporationButton);
	}

}
