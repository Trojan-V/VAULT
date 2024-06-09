package me.vault.game.view;


import javafx.scene.Scene;
import javafx.stage.Stage;
import me.vault.game.utility.loading.ResourceLoader;
import me.vault.game.utility.logging.ILogger;
import me.vault.game.utility.logging.Logger;

import java.text.MessageFormat;

import static me.vault.game.utility.constant.LoggingConstants.SHOWING_VIEW_MSG;
import static me.vault.game.utility.logging.ILogger.Level.DEBUG;


public class DifficultyView
{
	/**
	 * The logger object for this class used for writing formatted outputs into the console.
	 *
	 * @see Logger
	 */
	private static final ILogger LOGGER = new Logger(MainMenuView.class.getSimpleName());

	/**
	 * This file is located in the directory {@code ./src/main/java/resources/me/vault/vaultgame} and defines the
	 * properties (color etc.) of the GUI elements.
	 */
	private static final String DIFFICULTY_VIEW_FXML = "difficulty_view.fxml";

	private static final Scene DIFFICULTY_MENU_SCENE = ResourceLoader.loadScene(MainMenuView.class, DIFFICULTY_VIEW_FXML);

	public static void showDifficultyMenu (final Stage stage)
	{
		stage.setScene(DIFFICULTY_MENU_SCENE);
		stage.show();
		LOGGER.log(DEBUG, MessageFormat.format(SHOWING_VIEW_MSG, MainMenuView.class.getSimpleName()));
	}
}
