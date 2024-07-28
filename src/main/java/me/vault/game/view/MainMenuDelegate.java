package me.vault.game.view;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import me.vault.game.GameApplication;
import me.vault.game.control.ArtifactController;
import me.vault.game.model.arena.Arena;
import me.vault.game.model.arena.GameBoard;
import me.vault.game.model.artifact.impl.DefenseArtifact;
import me.vault.game.model.troop.impl.Sniper;
import me.vault.game.utility.constant.MissionConstants;
import me.vault.game.utility.constant.StringConstants;
import me.vault.game.utility.loading.ConfigLoader;
import me.vault.game.utility.loading.ResourceLoader;
import me.vault.game.utility.logging.ILogger;
import me.vault.game.utility.logging.Logger;
import me.vault.game.view.city.CityDelegate;
import me.vault.game.view.mission.MissionMapDelegate;

import java.net.URL;
import java.util.ResourceBundle;

import static me.vault.game.utility.constant.EncounterConstants.ALLIES;
import static me.vault.game.utility.constant.EncounterConstants.ENCOUNTER_ONE_ENEMIES;
import static me.vault.game.utility.constant.GameConstants.GAME_SAVE_FOLDER_FILE_PATH;


/**
 * This class acts as the controller and view for the main menu.
 *<br>
 * The class provides methods to display the main menu {@link MainMenuDelegate#show()} as well as methods for
 * the user to interact with the application {@link MainMenuDelegate#buttonClick(MouseEvent)}
 * {@link MainMenuDelegate#buttonClickMenu(ActionEvent)}.
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
	 * These Buttons are used to facilitate the interaction between the user and the application
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
	 * These are used to facilitate the interaction between the user and the application in the menu section of the GUI.
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
	 * Handles the buttonAction "buttonClick" that is defined in the FXML-File.
	 * <br>
	 * The method differentiates between the different buttons and executes the specified methods for the button that
	 * has been pressed.
	 * <br>
	 * If the "continue"-button is pressed the Save is loaded by the Config loader and the City-View is shown.
	 * <br>
	 * If the "new game"-button is pressed the Config File is reset and the Difficulty-View is shown.
	 * <br>
	 * If the "load game"-button is pressed the File-Chooser view is shown.
	 * <br>
	 * If the
	 *
	 * @param mouseEvent the Event on which the method acts.
	 *
	 * @precondition The MainMenu Scene has to be displayed on a stage.
	 * @postcondition The specified actions for each button are executed.
	 */
	@FXML
	private void buttonClick (final MouseEvent mouseEvent)
	{
		if (mouseEvent.getSource().equals(this.continueButton))
		{
			ConfigLoader.getInstance().load();
			CityDelegate.show(GameApplication.getStage());
		}
		else if (mouseEvent.getSource().equals(this.newGameButton))
		{
			ConfigLoader.getInstance().reset();
			DifficultyDelegate.show();
		}
		else if (mouseEvent.getSource().equals(this.loadGameButton))
		{
			//TODO: Config Loader functions
			FileChooserView.show(GameApplication.getStage(), GAME_SAVE_FOLDER_FILE_PATH,
				StringConstants.chooseGameFile);
		}
		else if (mouseEvent.getSource().equals(this.settingsButton))
		{
			SettingsDelegate.show();
		}
		else if (mouseEvent.getSource().equals(this.exitGameButton))
		{
			ExitGameDialogDelegate.show();
		}
		else if (mouseEvent.getSource().equals(this.arenaButton))
		{
			NetworkDelegate.show();
		}
	}


	@FXML
	private void buttonClickMenu (final ActionEvent actionEvent)
	{
		if (actionEvent.getSource().equals(this.continueMenuItem))
		{
			System.out.println(Sniper.getAllyInstance().toString());
		}
		else if (actionEvent.getSource().equals(this.newGameMenuItem))
		{
			DifficultyDelegate.show();
		}
		else if (actionEvent.getSource().equals(this.loadGameMenuItem))
		{
			FileChooserView.show(GameApplication.getStage(), GAME_SAVE_FOLDER_FILE_PATH,
				StringConstants.chooseGameFile);
		}
		else if (actionEvent.getSource().equals(this.settingsMenuItem))
		{
			SettingsDelegate.show();
		}
		else if (actionEvent.getSource().equals(this.exitGameMenuItem))
		{
			// TODO: Replace with actual functionality
			// ExitGameDialogDelegate.show();
			MissionMapDelegate.show(MissionConstants.MissionOne.MISSION_ONE);

		}
		else if (actionEvent.getSource().equals(this.arenaMenuItem))
		{
			ArenaDelegate.show(new Arena(ALLIES, ENCOUNTER_ONE_ENEMIES,
				new GameBoard(ResourceLoader.createGameBoardFromFile(EncounterConstants.ENCOUNTER_TWO_FILEPATH))));
		}
	}


	@Override
	public void initialize (final URL url, final ResourceBundle resourceBundle)
	{
		this.initializeContinue();
		this.initializeLoadGame();

	}


	@FXML
	private void initializeContinue ()
	{
		if (ResourceLoader.collectFiles(GAME_SAVE_FOLDER_FILE_PATH).isEmpty())
		{
			ViewUtil.setMenuItemInactive(this.continueMenuItem);
			ViewUtil.setButtonInactive(this.continueButton);
		}
	}


	@FXML
	private void initializeLoadGame () //TODO: Add checks for loading a save file
	{
		if (ResourceLoader.collectFiles(GAME_SAVE_FOLDER_FILE_PATH).isEmpty())
		{
			ViewUtil.setMenuItemInactive(this.loadGameMenuItem);
			ViewUtil.setButtonInactive(this.loadGameButton);
		}
	}

}
