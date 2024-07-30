package me.vault.game.view;


import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import me.vault.game.GameApplication;
import me.vault.game.utility.ViewUtil;
import me.vault.game.utility.constant.GameConstants;
import me.vault.game.utility.constant.StringConstants;
import me.vault.game.utility.loading.ConfigLoader;
import me.vault.game.utility.loading.ResourceLoader;
import me.vault.game.utility.logging.ILogger;
import me.vault.game.utility.logging.Logger;
import me.vault.game.view.city.CityDelegate;

import java.net.URL;
import java.util.ResourceBundle;

import static me.vault.game.utility.constant.GameConstants.GAME_SAVE_FOLDER_FILE_PATH;


/**
 * This class acts as the controller and view for the main menu.
 * <br>
 * The class provides methods to display the main menu {@link MainMenuDelegate#show()} as well as methods for
 * the user to interact with the application {@link MainMenuDelegate#click(Event)}.
 *
 * @author Timothy Hoegen-Jupp
 * @version 2.0.0
 */
public final class MainMenuDelegate implements Initializable
{

	/**
	 * The {@link Logger} object for this class used for writing to the console.
	 */
	private static final ILogger LOGGER = new Logger(MainMenuDelegate.class.getSimpleName());

	/**
	 * This file is located in the directory {@code ./src/main/java/resources/me/vault/game} and defines the properties (color etc.) of the GUI
	 * elements.
	 * <br>
	 * As only this class needs access to this file, it is defined here, instead of in an interface
	 */
	private static final String MAIN_MENU_VIEW_FXML = "mainMenu.fxml";

	private static final Scene SCENE = ResourceLoader.loadScene(MainMenuDelegate.class, MAIN_MENU_VIEW_FXML);


	/**
	 * Are used to facilitate the interaction between the user and the application
	 *
	 * @see Button
	 */
	@FXML
	private Button continueButton;

	@FXML
	private Button newGameButton;

	@FXML
	private Button loadGameButton;

	@FXML
	private Button settingsButton;

	@FXML
	private Button exitGameButton;

	@FXML
	private Button arenaButton;


	/**
	 * Are used to facilitate the interaction between the user and the application in the menu section of the
	 * mainMenu-scene.
	 *
	 * @see MenuItem
	 */
	@FXML
	private MenuItem continueMenuItem;

	@FXML
	private MenuItem newGameMenuItem;

	@FXML
	private MenuItem loadGameMenuItem;

	@FXML
	private MenuItem settingsMenuItem;

	@FXML
	private MenuItem exitGameMenuItem;

	@FXML
	private MenuItem arenaMenuItem;


	/**
	 * Calls a method to display the content stored in {@link MainMenuDelegate#MAIN_MENU_VIEW_FXML} and initialized
	 * by {@link MainMenuDelegate#initialize(URL, ResourceBundle)} on the main stage
	 * of this application ({@link GameApplication#getStage()})
	 *
	 * @precondition The GameApplication has to have a stage.
	 * @postcondition The initialized main menu is shown on the GameApplication Stage.
	 */
	public static void show ()
	{
		ViewUtil.show(GameApplication.getStage(), SCENE, MainMenuDelegate.class);
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
	 * If "new game" is clicked, the Config File is reset and the Difficulty-View is shown.
	 * <br>
	 * If "load game" is clicked, the File-Chooser view is shown.
	 * <br>
	 * If "settings" is clicked, the settings view is shown.
	 * <br>
	 * If "exit game" is clicked, the exit dialog is shown.
	 * <br>
	 * If "arena" is clicked, the network connection dialog is shown.
	 *
	 * @param event the Event on which the method acts.
	 *
	 * @precondition The MainMenu Scene has to be displayed on a stage.
	 * @postcondition The specified actions for each button are executed.
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
			//TODO: update java Doc
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
			//TODO: finish Arena
			//TODO: update java Doc
			NetworkDelegate.show();
		}
	}


	/**
	 * Handles the creation of a new game. The method checks, if the current configuration is equivalent to the
	 * default configuration. If this is not the case, the current configuration is saved and the configuartion is
	 * resetted, before {@link DifficultyDelegate#show()} is called to start a new game.
	 *
	 * @precondition
	 * @postcondition
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
	 *
	 */
	private void loadGameFromFile ()
	{
		if (!ConfigLoader.getInstance().isConfigDefault())
		{
			ConfigLoader.getInstance().saveExistingGameToFile();
		}
		ConfigLoader.getInstance().load(new FileChooserDelegate(GAME_SAVE_FOLDER_FILE_PATH).show());
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
			ViewUtil.setMenuItemInactive(this.continueMenuItem);
			ViewUtil.setButtonInactive(this.continueButton);
		}
	}


	/**
	 * Checks, if there is at least one file with a ".json" ending in the specified folder.
	 * If there is no file with a .json ending, the "load game"-button and menuItem is set to Inactive
	 *
	 * @precondition The main menu controller has to have been called.
	 * @postcondition The {@link MainMenuDelegate#loadGameButton} and {@link MainMenuDelegate#loadGameMenuItem} are
	 * set to inactive if there is no File with the {@link StringConstants#JSON_FILE_ENDING} ending in
	 * {@link GameConstants#GAME_SAVE_FOLDER_FILE_PATH}.
	 */
	@FXML
	private void initializeLoadGame ()
	{
		if (ResourceLoader.collectFilesContaining(GAME_SAVE_FOLDER_FILE_PATH, StringConstants.SAVE_NAME).isEmpty())
		{
			ViewUtil.setMenuItemInactive(this.loadGameMenuItem);
			ViewUtil.setButtonInactive(this.loadGameButton);
		}
	}
}
