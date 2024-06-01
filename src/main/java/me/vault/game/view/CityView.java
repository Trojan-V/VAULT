package me.vault.game.view;


import javafx.scene.Scene;
import javafx.stage.Stage;
import me.vault.game.utility.ResourceLoader;
import me.vault.game.utility.logging.ILogger;
import me.vault.game.utility.logging.Logger;

import java.text.MessageFormat;

import static me.vault.game.utility.constant.LoggingConstants.SHOWING_VIEW_MSG;
import static me.vault.game.utility.logging.ILogger.Level.DEBUG;


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
	private static final ILogger LOGGER = new Logger(CityView.class.getSimpleName());


	/**
	 * This file is located in the directory {@code ./src/main/java/resources/me/vault/vaultgame} and defines the
	 * properties (color etc.) of the GUI elements.
	 */
	private static final String STYLESHEET = "city_view.fxml";


	private static final Scene SCENE = ResourceLoader.loadFXMLScene(CityView.class, STYLESHEET);


	private CityView ()
	{}


	public static void show (final Stage stage)
	{
		stage.setScene(SCENE);
		stage.show();
		LOGGER.log(DEBUG, MessageFormat.format(SHOWING_VIEW_MSG, CityView.class.getSimpleName()));
	}
}
