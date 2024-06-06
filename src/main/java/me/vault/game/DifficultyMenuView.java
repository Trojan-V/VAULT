package me.vault.game;


import javafx.scene.Scene;
import javafx.stage.Stage;
import me.vault.game.city.CityView;
import me.vault.game.utility.loading.ResourceLoader;
import me.vault.game.utility.logging.ILogger;
import me.vault.game.utility.logging.Logger;

import java.text.MessageFormat;

import static me.vault.game.utility.constant.LoggingConstants.SHOWING_VIEW_MSG;
import static me.vault.game.utility.logging.ILogger.Level.DEBUG;


public class DifficultyMenuView
{
	private static final ILogger LOGGER = new Logger(CityView.class.getSimpleName());


	/**
	 * This file is located in the directory {@code ./src/main/java/resources/me/vault/vaultgame} and defines the
	 * properties (color etc.) of the GUI elements.
	 */
	private static final String STYLESHEET = "difficulty_view.fxml";


	private static final Scene SCENE = ResourceLoader.loadScene(DifficultyMenuView.class, STYLESHEET);


	public static void show (final Stage stage)
	{
		stage.setScene(SCENE);
		stage.show();
		LOGGER.log(DEBUG, MessageFormat.format(SHOWING_VIEW_MSG, CityView.class.getSimpleName()));
	}
}
