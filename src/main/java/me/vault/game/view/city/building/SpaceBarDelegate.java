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
import me.vault.game.model.city.SpaceBar;
import me.vault.game.model.player.Player;
import me.vault.game.model.troop.Faction;
import me.vault.game.utility.ViewUtil;
import me.vault.game.utility.loading.ResourceLoader;
import me.vault.game.utility.logging.Logger;
import me.vault.game.view.city.CityDelegate;

import java.net.URL;
import java.util.ResourceBundle;

import static me.vault.game.utility.constant.LoggingConstants.CLASS_INITIALIZED;
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
public final class SpaceBarDelegate implements Initializable
{

	/**
	 * The {@link Logger} object for this class used for writing to the console.
	 */
	private static final Logger LOGGER = new Logger(SpaceBarDelegate.class.getSimpleName());

	private static final String SPACE_BAR_VIEW_FXML = "space_bar_view.fxml";

	/**
	 * The {@link AnchorPane} at the top-most position in the scene-tree.
	 */
	@FXML
	private AnchorPane spaceBarAnchorPane;

	@FXML
	private Button chooseMegaCorporationButton;


	public static void show ()
	{
		ViewUtil.show(GameApplication.getStage(), ResourceLoader.loadScene(SpaceBarDelegate.class, SPACE_BAR_VIEW_FXML), SpaceBarDelegate.class);
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
		CityDelegate.show();
	}
}