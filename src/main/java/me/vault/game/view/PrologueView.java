package me.vault.game.view;


import javafx.scene.Scene;
import javafx.stage.Stage;
import me.vault.game.utility.loading.ResourceLoader;
import me.vault.game.utility.logging.Logger;

import java.text.MessageFormat;

import static me.vault.game.utility.constant.LoggingConstants.SHOWING_VIEW_MSG;
import static me.vault.game.utility.logging.ILogger.Level.DEBUG;


public class PrologueView
{
	/**
	 * The logger object for this class used for writing formatted outputs into the console.
	 *
	 * @see Logger
	 */
	private static final Logger LOGGER = new Logger(PrologueView.class.getSimpleName());


	/**
	 * This file is located in the directory {@code ./src/main/java/resources/me/vault/vaultgame} and defines the
	 * properties (color etc.) of the GUI elements.
	 */
	private static final String PROLOGUE_VIEW_FXML = "prologue.fxml";


	private static final Scene PROLOGUE_SCENE = ResourceLoader.loadScene(PrologueView.class, PROLOGUE_VIEW_FXML);


	public static void show (final Stage stage)
	{
		// Changes the scene of the stage to the prologue scene
		stage.setScene(PROLOGUE_SCENE);
		stage.show();
		LOGGER.log(DEBUG, MessageFormat.format(SHOWING_VIEW_MSG, PrologueView.class.getSimpleName()));
	}
}
