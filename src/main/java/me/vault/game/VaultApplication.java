package me.vault.game;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import me.vault.game.utility.jvm.JvmArgumentParser;
import me.vault.game.city.CityView;

import java.io.IOException;

import static me.vault.game.utility.constant.GameConstants.WINDOW_TITLE;


/**
 * The entry point of the VAULT game application. This class launches the GUI window the player will interact with to.
 * The class which inherits from {@link Application} is responsible for loading any {@code .fxml} files. The
 * {@code .fxml} file creates the connection between {@link VaultApplication} and {@link VaultController}.
 *
 * @author Vincent Wolf
 * @version 1.0.0
 * @see Application
 * @see VaultController
 * @since 24.04.2024
 */
public class VaultApplication extends Application
{
	/**
	 * This file is located in the directory {@code ./src/main/java/resources/me/vault/vaultgame} and defines the
	 * properties (color etc.) of the GUI elements.
	 */
	private static final String MAIN_STYLESHEET_FILENAME = "main.fxml";


	private static Stage mainStage;


	/**
	 * Starts the JavaFX framework by invoking the launch method from the {@link Application} class. It isn't required
	 * to explicitly declare the main method, as the runtime environment will automatically invoke it anyway in a
	 * JavaFX
	 * project. Declaring it explicitly doesn't hurt though.
	 *
	 * @param args Contains the JVM arguments which have been passed into the program at the start.
	 */
	public static void main (final String[] args)
	{
		JvmArgumentParser.apply(args);

		// TODO: createDefaultConfig();
		launch();
	}


	public static Stage getStage ()
	{
		return mainStage;
	}


	/**
	 * Loads the {@code .fxml} files which are located in {@code ./src/main/java/resources/me/vault/vaultgame} and
	 * starts the GUI powered by JavaFX.
	 *
	 * @param stage The {@link Stage} which will be displayed in the GUI window which pops up.
	 *
	 * @exception IOException If a {@code .fxml} file can't be loaded by the {@link FXMLLoader}.
	 */
	@Override
	public void start (final Stage stage)
	{
		stage.setResizable(false);
		stage.setTitle(WINDOW_TITLE);
		MainMenuView.show(stage);
		mainStage = stage;
	}
}