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
import me.vault.game.utility.constant.GameConstants;
import me.vault.game.utility.constant.StringConstants;
import me.vault.game.utility.loading.ConfigLoader;
import me.vault.game.utility.loading.ResourceLoader;
import me.vault.game.utility.logging.ILogger;
import me.vault.game.utility.logging.Logger;
import me.vault.game.view.city.CityDelegate;
import org.jetbrains.annotations.NotNull;

import java.net.URL;
import java.util.ResourceBundle;


/**
 * This class acts as the controller and view for the main menu.
 *<br>
 * The class provides methods to display the main menu {@link MainMenuDelegate#show()} as well as methods for
 * the user to interact with the application {@link MainMenuDelegate#click(Event)}.
 *
 * @author Timothy Hoegen-Jupp
 * @version 2.0.0
 *
 */
public class MainMenuDelegate implements Initializable
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
	//TODO: Entscheiden, ob die FXML Dateien in den Delegates gespeichert wird
	private static final String MAIN_MENU_VIEW_FXML = "mainMenu.fxml";

	private static final Scene SCENE = ResourceLoader.loadScene(MainMenuDelegate.class, MAIN_MENU_VIEW_FXML);


	/**
	 *  Are used to facilitate the interaction between the user and the application
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
	 * These are used to facilitate the interaction between the user and the application in the menu section of the
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

	//Methods ---------------------------------------------------------------------------------------

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
	 * The method differentiates between the different actions that can be triggered by interacting with eiter the
	 * buttons or the MenuItems in the Scene.
	 * <br>
	 * <br>
	 * Note: As both the MenuItems and the Buttons in the Scene have the same functionality, they are combined in one
	 * method. However, as the buttons use an {@link MouseEvent} and the MenuItems use an {@link ActionEvent}, the
	 * super-Class {@link Event} has been used in order to combine both in a single method.
	 * <br>
	 * <br>
	 * The actions that are triggered by their respective button/menuItem are listed below:
	 * <br>
	 * If "continue" is clicked the Save is loaded by the Config loader and the City-View is shown.
	 * <br>
	 * If "new game" is clicked the Config File is reset and the Difficulty-View is shown.
	 * <br>
	 * If the "load game"-button is pressed the File-Chooser view is shown.
	 * <br>
	 * If the "settings"-button is pressed the settings view is shown.
	 * <br>
	 * If the "exit game"-button is pressed the exit dialog is shown.
	 * <br>
	 * If the "arena"-button is pressed the network connection dialog is shown.
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
			CityDelegate.show(GameApplication.getStage());
		}
		else if (event.getSource().equals(this.newGameButton) || event.getSource().equals(this.newGameMenuItem))
		{
			if (!ConfigLoader.getInstance().isConfigDefault())
			{
				ConfigLoader.getInstance().saveExistingGameToFile();
			}
			ConfigLoader.getInstance().reset();
			DifficultyDelegate.show();
		}
		else if (event.getSource().equals(this.loadGameButton)|| event.getSource().equals(this.loadGameMenuItem))
		{
			//TODO: Update Java Doc
			ConfigLoader.getInstance().load(FileChooserView.show(GameApplication.getStage(),
				GameConstants.GAME_SAVE_FOLDER_FILE_PATH,
				StringConstants.chooseGameFile));
			CityDelegate.show(GameApplication.getStage());
		}
		else if (event.getSource().equals(this.settingsButton) || event.getSource().equals(this.settingsButton))
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

	@Override
	public void initialize (URL url, ResourceBundle resourceBundle)
	{
		this.initializeContinue();
		this.initializeLoadGame();

	}


	/**
	 *
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
	 * <br>
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
		if (ResourceLoader.collectFilesWithSpecifiedEnding(GameConstants.GAME_SAVE_FOLDER_FILE_PATH,
			StringConstants.JSON_FILE_ENDING).isEmpty() || ResourceLoader.collectFilesContaining(GameConstants.GAME_SAVE_FOLDER_FILE_PATH, StringConstants.SAVE_NAME).isEmpty()) //TODO: Update Java DOC
		{
			ViewUtil.setMenuItemInactive(this.loadGameMenuItem);
			ViewUtil.setButtonInactive(this.loadGameButton);
		}
	}
}
