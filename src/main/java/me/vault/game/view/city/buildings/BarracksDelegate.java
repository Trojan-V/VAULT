package me.vault.game.view.city.buildings;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import me.vault.game.VaultApplication;
import me.vault.game.control.CityBuildingController;
import me.vault.game.control.CurrencyController;
import me.vault.game.utility.constant.GameConstants;
import me.vault.game.utility.loading.ResourceLoader;
import me.vault.game.utility.logging.ILogger;
import me.vault.game.utility.logging.Logger;
import me.vault.game.view.city.CityView;

import java.net.URL;
import java.util.ResourceBundle;

import static me.vault.game.utility.constant.GameConstants.ASSETS_PATH;
import static me.vault.game.utility.constant.NewLoggingConstants.CLASS_INITIALISED;


/**
 * The {@code BarracksDelegate} handles the control and view of the {@link me.vault.game.model.city.Barracks} city building. On the one hand it
 * initialises the view from the fxml-file and binds properties from the model to the view. On the other hand it provides methods to control the model
 * to the {@link me.vault.game.model.city.Barracks} cty building.
 *
 * @author Lasse-Leander Hillen, Vincent Wolf, Timothy Hoegen-Jupp, Alexander Goethel
 * @see CityBuildingController
 * @see Initializable
 * @see me.vault.game.model.city.Barracks
 * @since 11.06.2024
 */
public class BarracksDelegate implements Initializable
{

	/**
	 * The {@link Logger} object for this class used for writing to the console.
	 */
	private static final ILogger LOGGER = new Logger(BarracksDelegate.class.getSimpleName());

	/**
	 * The {@link ImageView} of the scene, which works as the views background.
	 */
	@FXML
	private ImageView backgroundImageView;

	/**
	 * The {@link AnchorPane} at the top-most position in the scene-tree.
	 */
	@FXML
	private AnchorPane barracksAnchorPane;


	/**
	 * Method, that gets called, when th user presses the "BACK"-Button. Resets the current view to the city view.
	 *
	 * @param ignored {@link ActionEvent}-parameter, that contains information about the event-caller.
	 */
	@FXML
	void onBackToCityView (final ActionEvent ignored)
	{
		CityView.show(VaultApplication.getStage());
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
		this.backgroundImageView.setImage(ResourceLoader.loadImage(ASSETS_PATH + GameConstants.GENERAL_BACKGROUND_FILENAME));
		this.barracksAnchorPane.getChildren().add(CurrencyController.getCurrencyBannerScene().getRoot());

		// Logging the finalisation of the initialisation
		LOGGER.logf(ILogger.Level.DEBUG, CLASS_INITIALISED, BarracksDelegate.class.getSimpleName());

	}

}
