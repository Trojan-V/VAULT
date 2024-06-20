package me.vault.game.view.city.buildings;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import me.vault.game.VaultApplication;
import me.vault.game.control.CityBuildingController;
import me.vault.game.control.CurrencyController;
import me.vault.game.utility.logging.ILogger;
import me.vault.game.utility.logging.Logger;
import me.vault.game.view.city.CityView;

import java.net.URL;
import java.util.ResourceBundle;

import static me.vault.game.utility.constant.LoggingConstants.CLASS_INITIALISED;
import static me.vault.game.utility.logging.ILogger.Level.DEBUG;


/**
 * The {@code MarketDelegate} handles the control and view of the {@link me.vault.game.model.city.Market} city building.
 * On the one hand, it initializes the view from the fxml-file and binds properties from the model to the view.
 * On the other hand, it provides methods to control the model to the {@link me.vault.game.model.city.Market} city building.
 *
 * @author Lasse-Leander Hillen, Vincent Wolf, Timothy Hoegen-Jupp, Alexander Goethel
 * @see CityBuildingController
 * @see Initializable
 * @see me.vault.game.model.city.Market
 * @since 11.06.2024
 */
public class MarketDelegate extends CityBuildingController implements Initializable
{

	// CONSTANTS -------------------------------------------------------------------------------------------------------

	/**
	 * The {@link Logger} object for this class used for writing to the console.
	 */
	private static final ILogger LOGGER = new Logger(MarketDelegate.class.getSimpleName());


	// FXML ------------------------------------------------------------------------------------------------------------

	/**
	 * The {@link AnchorPane} at the top-most position in the scene-tree.
	 */
	@FXML
	private AnchorPane mainPane;


	/**
	 * Method, that gets called when the user presses the "BACK"-Button. Resets the current view to the city view.
	 *
	 * @param ignored {@link ActionEvent}-parameter, that contains information about the event-caller.
	 */
	@FXML
	void onBackToCityView (final ActionEvent ignored)
	{
		CityView.show(VaultApplication.getStage());
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
		this.mainPane.getChildren().add(CurrencyController.getCurrencyBannerScene().getRoot());

		// Logging the finalization of the initialization
		LOGGER.logf(DEBUG, CLASS_INITIALISED, MarketDelegate.class.getSimpleName());
	}

}
