package me.vault.game;


import javafx.application.Application;
import javafx.stage.Stage;
import me.vault.game.utility.jvm.JvmArgumentParser;
import me.vault.game.utility.logging.ILogger;
import me.vault.game.utility.logging.Logger;
import me.vault.game.view.ExitGameDialogDelegate;
import me.vault.game.view.MainMenuDelegate;

import java.util.Arrays;

import static me.vault.game.utility.constant.GameConstants.WINDOW_TITLE;
import static me.vault.game.utility.constant.LoggingConstants.PROGRAM_START;


/**
 * The entry point of the VAULT game application. This class launches the GUI window the player will interact with to. The class which inherits from
 * {@link Application} is responsible for loading any {@code .fxml} files.
 *
 * @author Vincent Wolf
 * @version 1.0.0
 * @see Application
 * @since 24.04.2024
 */
public class GameApplication extends Application
{

	/**
	 * The {@link Logger} object for this class used for writing to the console.
	 */
	private static final Logger LOGGER = new Logger(GameApplication.class.getSimpleName());


	/**
	 * This file is located in the directory {@code ./src/main/java/resources/me/vault/vaultgame} and defines the properties (color etc.) of the GUI
	 * elements.
	 */
	private static final String FXML_FILENAME = "main.fxml";


	private static Stage mainStage = null;


	/**
	 * Starts the JavaFX framework by invoking the launch method from the {@link Application} class. It isn't required to explicitly declare the main
	 * method, as the runtime environment will automatically invoke it anyway in a JavaFX project. Declaring it explicitly doesn't hurt though.
	 *
	 * @param args Contains the JVM arguments which have been passed into the program at the start.
	 */
	public static void main (final String[] args)
	{
		JvmArgumentParser.apply(args);
		launch();
	}


	public static Stage getStage ()
	{
		return mainStage;
	}


	/**
	 * Loads the {@code .fxml} files which are located in {@code ./src/main/java/resources/me/vault/vaultgame} and starts the GUI powered by JavaFX.
	 *
	 * @param stage The {@link Stage} which will be displayed in the GUI window which pops up.
	 */
	@Override
	public void start (final Stage stage)
	{
		mainStage = stage;
		stage.setResizable(false);
		stage.setTitle(WINDOW_TITLE);
		MainMenuDelegate.show();

		stage.setOnCloseRequest(evt -> {
			evt.consume();
			ExitGameDialogDelegate.show();
		});
	}

}