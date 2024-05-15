package me.vault.vaultgame;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import me.vault.vaultgame.jvm.JvmArgumentParser;

import java.io.IOException;


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
	 * The window title which will be displayed in the top bar of the game window.
	 */
	private static final String WINDOW_TITLE = "VAULT Game - Ver. 0.1";


	/**
	 * The GUI window will launch in the width specified here.
	 */
	private static final int WINDOW_START_WIDTH = 1080;


	/**
	 * The GUI window will launch in the height specified here.
	 */
	private static final int WINDOW_START_HEIGHT = 720;


	/**
	 * This file is located in the directory {@code ./src/main/java/resources/me/vault/vaultgame} and defines the
	 * properties (color etc.) of the GUI elements.
	 */
	private static final String MAIN_STYLESHEET_FILENAME = "main.fxml";


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


	/**
	 * Loads the {@code .fxml} files which are located in {@code ./src/main/java/resources/me/vault/vaultgame} and
	 * starts the GUI powered by JavaFX.
	 *
	 * @param stage The {@link Stage} which will be displayed in the GUI window which pops up.
	 * @throws IOException If a {@code .fxml} file can't be loaded by the {@link FXMLLoader}.
	 */
	@Override
	public void start (final Stage stage) throws IOException
	{
		final FXMLLoader fxmlLoader = new FXMLLoader(VaultApplication.class.getResource(MAIN_STYLESHEET_FILENAME));
		final Scene scene = new Scene(fxmlLoader.load(), WINDOW_START_WIDTH, WINDOW_START_HEIGHT);
		stage.setTitle(WINDOW_TITLE);
		stage.setScene(scene);
		stage.show();
	}

}