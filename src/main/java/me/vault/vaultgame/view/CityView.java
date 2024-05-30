package me.vault.vaultgame.view;


import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import me.vault.vaultgame.utility.Logger;

import java.io.IOException;
import java.util.Objects;

import static me.vault.vaultgame.utility.Logger.Level.DEBUG;


/**
 * Description
 *
 * @author Vincent Wolf
 * @version 1.0.0
 * @see
 * @since 15.05.2024
 */
public final class CityView
{
	private static final Logger LOGGER = new Logger(CityView.class.getSimpleName());


	/**
	 * This file is located in the directory {@code ./src/main/java/resources/me/vault/vaultgame} and defines the
	 * properties (color etc.) of the GUI elements.
	 */
	private static final String STYLESHEET_URL = "cityview.fxml";


	private static final String SHOWING_CITY_VIEW_MSG = "Showing city view";


	private CityView ()
	{}


	public static void showCityView (final Stage stage) throws IOException
	{
		// Loading the FXML-File and creating a scene from the loaded components
		final Parent root = FXMLLoader.load(Objects.requireNonNull(CityView.class.getResource(STYLESHEET_URL)));
		final Scene scene = new Scene(root);

		// New scene is set as main-scene of the passed stage
		stage.setScene(scene);
		stage.show();
		LOGGER.log(DEBUG, SHOWING_CITY_VIEW_MSG);
	}
}
