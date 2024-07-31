package me.vault.game.view.menu;


import com.google.gson.JsonSyntaxException;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import me.vault.game.GameApplication;
import me.vault.game.utility.ViewUtil;
import me.vault.game.utility.interfaces.constant.GameConstants;
import me.vault.game.utility.interfaces.constant.MiscConstants;
import me.vault.game.utility.loading.ConfigLoader;
import me.vault.game.utility.loading.ResourceLoader;
import me.vault.game.utility.logging.ILogger;
import me.vault.game.utility.logging.Logger;
import me.vault.game.view.ExitGameDialogDelegate;
import me.vault.game.view.city.CityDelegate;
import me.vault.game.view.newgame.DifficultyDelegate;

import java.io.File;
import java.net.URL;
import java.text.MessageFormat;
import java.util.ResourceBundle;

import static me.vault.game.utility.interfaces.constant.GameConstants.GAME_SAVE_DIRECTORY_PATH;
import static me.vault.game.utility.interfaces.constant.MiscConstants.SAVE_NAME;


/**
 * This class acts as the controller and view for the main menu.
 * <br>
 * The class provides methods to display the main menu {@link MainMenuDelegate#show()} as well as methods for
 * the player to interact with the application {@link MainMenuDelegate#click(Event)}.
 *
 * @author Vincent Wolf, Lasse-Leander Hillen, Timothy Hoegen-Jupp, Alexander Goethel
 * @version 1.0.0
 * @since 28.04.2024
 */
public final class MainMenuDelegate implements Initializable
{

	/**
	 * The {@link Logger} object for this class used for writing to the console.
	 */
	private static final ILogger LOGGER = new Logger(MainMenuDelegate.class.getSimpleName());

	/**
	 * The path to the respective fxml file of the delegate as a {@link String}.
	 */
	private static final String MAIN_MENU_VIEW_FXML = "main_menu.fxml";

	/**
	 * The {@link MessageFormat} pattern, which is used, when the {@link MainMenuDelegate#toString()} is called.
	 */
	private static final String TO_STRING_PATTERN = "MainMenuDelegate'{'fxml={0}'}'";

	/**
	 * {@link Button} that provides the player with the ability to continue the game.
	 */
	@FXML
	private Button continueButton;


	/**
	 * {@link Button} that provides the player with the ability to play a new game.
	 */
	@FXML
	private Button newGameButton;


	/**
	 * {@link Button} that provides the player with the ability to load a game from a file.
	 */
	@FXML
	private Button loadGameButton;


	/**
	 * {@link Button} that provides the player with the ability to open the settings.
	 */
	@FXML
	private Button settingsButton;


	/**
	 * {@link Button} that provides the player with the ability to exit the game.
	 */
	@FXML
	private Button exitGameButton;


	/**
	 * {@link Button} that provides the player with the ability to enter the arena.
	 */
	@FXML
	private Button arenaButton;


	/**
	 * {@link MenuItem} that provides the player with the ability to continue the game.
	 */
	@FXML
	private MenuItem continueMenuItem;

	/**
	 * {@link MenuItem} that provides the player with the ability to play a new game.
	 */
	@FXML
	private MenuItem newGameMenuItem;

	/**
	 * {@link MenuItem} that provides the player with the ability to load a game from a file.
	 */
	@FXML
	private MenuItem loadGameMenuItem;

	/**
	 * {@link MenuItem} that provides the player with the ability to open the settings.
	 */
	@FXML
	private MenuItem settingsMenuItem;

	/**
	 * {@link MenuItem} that provides the player with the ability to exit the game.
	 */
	@FXML
	private MenuItem exitGameMenuItem;

	/**
	 * {@link MenuItem} that provides the player with the ability to enter the arena.
	 */
	@FXML
	private MenuItem arenaMenuItem;


	/**
	 * Calls a method to display the content stored in {@link MainMenuDelegate#MAIN_MENU_VIEW_FXML} and initialized
	 * by {@link MainMenuDelegate#initialize(URL, ResourceBundle)} on the main stage
	 * of this application ({@link GameApplication#getStage()}).
	 *
	 * @precondition The GameApplication has to have a stage
	 * @postcondition The initialized main menu is shown on the GameApplication Stage
	 */
	public static void show ()
	{
		ViewUtil.show(GameApplication.getStage(), ResourceLoader.loadScene(MainMenuDelegate.class, MAIN_MENU_VIEW_FXML), MainMenuDelegate.class);
	}


	/**
	 * Handles the action "click" that is defined in the FXML-File.
	 * <br>
	 * <br>
	 * The method differentiates between the different actions that can be triggered by interacting with either the
	 * buttons or the MenuItems in the Scene.
	 * <br>
	 * <br>
	 * Note: As both the MenuItems and the Buttons in the Scene have the same capabilities, they're combined in one
	 * method. However, as the buttons use an {@link MouseEvent} and the MenuItems use an {@link ActionEvent}, the
	 * super-Class {@link Event} has been used to combine both in a single method.
	 * <br>
	 * <br>
	 * The actions that are triggered by their respective button/menuItem are listed below:
	 * <br>
	 * If "continue" is clicked, the Save is loaded by the Config loader and the City-View is shown.
	 * <br>
	 * If "new game" is clicked, the {@link MainMenuDelegate#createNewGame()} method is called.
	 * <br>
	 * If "load game" is clicked, the {@link MainMenuDelegate#loadGameFromFile()} method is called.
	 * <br>
	 * If "settings" is clicked, the settings view is shown.
	 * <br>
	 * If "exit game" is clicked, the exit dialog is shown.
	 * <br>
	 * If "arena" is clicked, the network connection dialog is shown.
	 *
	 * @param event the Event that determines the triggered actions
	 *
	 * @precondition The MainMenu Scene has to be displayed on the active stage.
	 * @postcondition The specified actions as described by this documentation are executed.
	 */
	@FXML
	private void click (final Event event)
	{
		if (event.getSource().equals(this.continueButton) || event.getSource().equals(this.continueMenuItem))
		{
			ConfigLoader.getInstance().load();
			CityDelegate.show();
		}
		else if (event.getSource().equals(this.newGameButton) || event.getSource().equals(this.newGameMenuItem))
		{
			this.createNewGame();
		}
		else if (event.getSource().equals(this.loadGameButton) || event.getSource().equals(this.loadGameMenuItem))
		{
			this.loadGameFromFile();
		}
		else if (event.getSource().equals(this.settingsButton) || event.getSource().equals(this.settingsMenuItem))
		{
			SettingsDelegate.show();
		}
		else if (event.getSource().equals(this.exitGameButton) || event.getSource().equals(this.exitGameMenuItem))
		{
			ExitGameDialogDelegate.show();
		}
		else if (event.getSource().equals(this.arenaButton) || event.getSource().equals(this.arenaMenuItem))
		{
			NetworkDelegate.show();
		}
	}


	/**
	 * Handles the creation of a new game.
	 * <br>
	 * The method checks if the current configuration is equivalent to the default configuration.
	 * If this isn't the case, the current configuration is saved, and the configuration is reset,
	 * before {@link DifficultyDelegate#show()} is called to start a new game.
	 *
	 * @precondition The method gets called
	 * @postcondition If the config file isn't identical to the default config file the information from the config
	 * file is saved in a new file; the config file is set to the default values, and the difficulty (scene) is shown
	 */
	private void createNewGame ()
	{
		if (!ConfigLoader.getInstance().isConfigDefault())
		{
			ConfigLoader.getInstance().saveExistingGameToFile();
		}
		ConfigLoader.getInstance().reset();
		DifficultyDelegate.show();
	}


	/**
	 * Handles the loading of a game file. The method checks, if the current configuration is equivalent to the
	 * default configuration. If this is not the case, the current configuration is saved and the configuration is
	 * reset, before {@link CityDelegate#show()} is called to continue with the game.
	 *
	 * @precondition The method is called.
	 * @postcondition If the config file is not identical to the default config file the information from the config
	 * file is saved in a new file; the config file is updated with the information from the loaded file and the city
	 * (scene) is shown
	 */
	private void loadGameFromFile ()
	{
		final File file;
		try
		{
			//The chosen file has to be a valid .json file
			file = new FileChooserDelegate(GAME_SAVE_DIRECTORY_PATH).show();
			if (file == null)
			{
				return;
			}

			if (!ConfigLoader.getInstance().isConfigDefault())
			{
				ConfigLoader.getInstance().saveExistingGameToFile();
			}

			ConfigLoader.getInstance().load(file);
		}
		catch (final JsonSyntaxException e)
		{
			this.loadGameFromFile();
		}

		CityDelegate.show();
	}


	/**
	 * Initializes the fxml-view and sets program-specific bindings and properties. Gets called internally by JavaFX.
	 *
	 * @param url            The {@link URL} object, which acts like a pointer to the ressource of the fxml-file.
	 * @param resourceBundle A {@link ResourceBundle} object, which contains locale-specific objects.
	 *
	 * @precondition The passed parameters contain all relevant information needed to initialize the fxml-view.
	 * @postcondition The fxml-view gets initialized and the procedure within the method is run at initialization.
	 */
	@Override
	public void initialize (final URL url, final ResourceBundle resourceBundle)
	{
		this.initializeContinue();
		this.initializeLoadGame();

	}


	/**
	 * Checks, if the Config file is identical to the default (config) file. If the files are identical,
	 * {@link MainMenuDelegate#continueButton} and {@link MainMenuDelegate#continueMenuItem} is set to inactive
	 *
	 * @precondition The main menu controller has to have been called.
	 * @postcondition The {@link MainMenuDelegate#continueButton} and {@link MainMenuDelegate#continueMenuItem} are
	 * set to inactive if the Config file is identical to the default (config) file
	 */
	@FXML
	private void initializeContinue ()
	{
		if (ConfigLoader.getInstance().isConfigDefault())
		{
			ViewUtil.disableMenuItem(this.continueMenuItem);
			ViewUtil.disableButton(this.continueButton);
		}
	}


	/**
	 * Checks, if there's at least one file with a ".json" ending in the specified folder.
	 * If there's no file with a .json ending, the "load game"-button and menuItem is set to Inactive
	 *
	 * @precondition The main menu controller has to have been called.
	 * @postcondition The {@link MainMenuDelegate#loadGameButton} and {@link MainMenuDelegate#loadGameMenuItem} are
	 * set to inactive if there's no File with the {@link MiscConstants#JSON_FILE_ENDING} ending in
	 * {@link GameConstants#GAME_SAVE_DIRECTORY_PATH}.
	 */
	@FXML
	private void initializeLoadGame ()
	{
		if (ResourceLoader.collectFilesContaining(GAME_SAVE_DIRECTORY_PATH, SAVE_NAME).isEmpty())
		{
			ViewUtil.disableMenuItem(this.loadGameMenuItem);
			ViewUtil.disableButton(this.loadGameButton);
		}
	}


	/**
	 * Builds a formatted {@link String}, which represents the object, and it's current state using the {@link MainMenuDelegate#TO_STRING_PATTERN}.
	 *
	 * @return A {@link String} which has been formatted in the {@link MainMenuDelegate#TO_STRING_PATTERN}.
	 *
	 * @precondition The {@link MainMenuDelegate#TO_STRING_PATTERN} is {@code != null}.
	 * @postcondition The method returned a {@link String} which represents the object.
	 */
	@Override
	public String toString ()
	{
		return MessageFormat.format(TO_STRING_PATTERN, MAIN_MENU_VIEW_FXML);
	}

}
