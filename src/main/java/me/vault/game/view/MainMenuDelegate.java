package me.vault.game.view;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import me.vault.game.GameApplication;
import me.vault.game.control.ArtifactController;
import me.vault.game.model.arena.Arena;
import me.vault.game.model.arena.GameBoard;
import me.vault.game.model.artifact.impl.DefenseArtifact;
import me.vault.game.model.troop.impl.Sniper;
import me.vault.game.utility.constant.StringConstants;
import me.vault.game.utility.loading.ConfigLoader;
import me.vault.game.utility.loading.ResourceLoader;
import me.vault.game.utility.logging.ILogger;
import me.vault.game.utility.logging.Logger;
import me.vault.game.view.city.CityDelegate;

import java.net.URL;
import java.util.ResourceBundle;

import static me.vault.game.utility.constant.EncounterConstants.ALLIES;
import static me.vault.game.utility.constant.EncounterConstants.ENCOUNTER_ONE_ENEMIES;
import static me.vault.game.utility.constant.GameConstants.ASSETS_PATH;
import static me.vault.game.utility.constant.GameConstants.GAME_SAVE_FOLDER_FILE_PATH;


/**
 *
 */
public class MainMenuDelegate implements Initializable
{
	// Buttons ------------------------------------------------------------------------------------------------------------------

	/**
	 * The {@link Logger} object for this class used for writing to the console.
	 */
	private static final ILogger LOGGER = new Logger(MainMenuDelegate.class.getSimpleName());

	/**
	 * This file is located in the directory {@code ./src/main/java/resources/me/vault/game} and defines the properties (color etc.) of the GUI
	 * elements.
	 */
	private static final String MAIN_MENU_VIEW_FXML = "mainMenu.fxml";


	private static final String BUTTON_BACKGROUND_NORMAL = ASSETS_PATH + "button.png";


	private static final String BUTTON_BACKGROUND_SELECTED = ASSETS_PATH + "button_round.png";

	private static final Scene SCENE = ResourceLoader.loadScene(MainMenuDelegate.class, MAIN_MENU_VIEW_FXML);


	//FXML Buttons ---------------------------------------------------------------------------------------

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


	//FXML MenuItems ---------------------------------------------------------------------------------------
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
	 *
	 */
	public static void show ()
	{
		ViewUtil.show(GameApplication.getStage(), SCENE, MainMenuDelegate.class);
	}


	@FXML
	void changeButtonBackground (final MouseEvent mouseEvent)
	{
		if (mouseEvent.getSource().equals(this.continueButton))
		{
			ViewUtil.setButtonImage(this.continueButton, BUTTON_BACKGROUND_SELECTED);
		}
		else if (mouseEvent.getSource().equals(this.newGameButton))
		{
			ViewUtil.setButtonImage(this.newGameButton, BUTTON_BACKGROUND_SELECTED);
		}
		else if (mouseEvent.getSource().equals(this.loadGameButton))
		{
			ViewUtil.setButtonImage(this.loadGameButton, BUTTON_BACKGROUND_SELECTED);
		}
		else if (mouseEvent.getSource().equals(this.settingsButton))
		{
			ViewUtil.setButtonImage(this.settingsButton, BUTTON_BACKGROUND_SELECTED);
		}
		else if (mouseEvent.getSource().equals(this.exitGameButton))
		{
			ViewUtil.setButtonImage(this.exitGameButton, BUTTON_BACKGROUND_SELECTED);
		}
		else if (mouseEvent.getSource().equals(this.arenaButton))
		{
			ViewUtil.setButtonImage(this.arenaButton, BUTTON_BACKGROUND_SELECTED);
		}
	}


	/**
	 * @param mouseEvent
	 */
	@FXML
	public void returnButtonBackgroundToNormal (final MouseEvent mouseEvent)
	{
		if (mouseEvent.getSource().equals(this.continueButton))
		{
			ViewUtil.setButtonImage(this.continueButton, BUTTON_BACKGROUND_NORMAL);
		}
		else if (mouseEvent.getSource().equals(this.newGameButton))
		{
			ViewUtil.setButtonImage(this.newGameButton, BUTTON_BACKGROUND_NORMAL);
		}
		else if (mouseEvent.getSource().equals(this.loadGameButton))
		{
			ViewUtil.setButtonImage(this.loadGameButton, BUTTON_BACKGROUND_NORMAL);
		}
		else if (mouseEvent.getSource().equals(this.settingsButton))
		{
			ViewUtil.setButtonImage(this.settingsButton, BUTTON_BACKGROUND_NORMAL);
		}
		else if (mouseEvent.getSource().equals(this.exitGameButton))
		{
			ViewUtil.setButtonImage(this.exitGameButton, BUTTON_BACKGROUND_NORMAL);
		}
		else if (mouseEvent.getSource().equals(this.arenaButton))
		{
			ViewUtil.setButtonImage(this.arenaButton, BUTTON_BACKGROUND_NORMAL);
		}
	}


	@FXML
	void changeButtonTextColor (final MouseEvent mouseEvent)
	{
		if (mouseEvent.getSource().equals(this.continueButton))
		{
			ViewUtil.setButtonTextColor(this.continueButton, StringConstants.colorLightBlue);
		}
		else if (mouseEvent.getSource().equals(this.newGameButton))
		{
			ViewUtil.setButtonTextColor(this.newGameButton, StringConstants.colorLightBlue);
		}
		else if (mouseEvent.getSource().equals(this.loadGameButton))
		{
			ViewUtil.setButtonTextColor(this.loadGameButton, StringConstants.colorLightBlue);
		}
		else if (mouseEvent.getSource().equals(this.settingsButton))
		{
			ViewUtil.setButtonTextColor(this.settingsButton, StringConstants.colorLightBlue);
		}
		else if (mouseEvent.getSource().equals(this.exitGameButton))
		{
			ViewUtil.setButtonTextColor(this.exitGameButton, StringConstants.colorLightBlue);
		}
		else if (mouseEvent.getSource().equals(this.arenaButton))
		{
			ViewUtil.setButtonTextColor(this.arenaButton, StringConstants.colorLightBlue);
		}
	}


	@FXML
	void buttonClick (final MouseEvent mouseEvent)
	{
		if (mouseEvent.getSource().equals(this.continueButton))
		{
			ViewUtil.setButtonTextColor(this.continueButton, Color.BLACK);
			ConfigLoader.getInstance().load();
			CityDelegate.show(GameApplication.getStage());
		}
		else if (mouseEvent.getSource().equals(this.newGameButton))
		{
			ViewUtil.setButtonTextColor(this.newGameButton, Color.BLACK);
			ConfigLoader.getInstance().reset();
			DifficultyDelegate.show(GameApplication.getStage());
		}
		else if (mouseEvent.getSource().equals(this.loadGameButton))
		{
			ViewUtil.setButtonTextColor(this.loadGameButton, Color.BLACK);
			FileChooserView.show(GameApplication.getStage(), GAME_SAVE_FOLDER_FILE_PATH,
				StringConstants.chooseGameFile);
		}
		else if (mouseEvent.getSource().equals(this.settingsButton))
		{
			ViewUtil.setButtonTextColor(this.settingsButton, Color.BLACK);
		}
		else if (mouseEvent.getSource().equals(this.exitGameButton))
		{
			ViewUtil.setButtonTextColor(this.exitGameButton, Color.BLACK);
			ExitGameDialogDelegate.show();
		}
		else if (mouseEvent.getSource().equals(this.arenaButton))
		{
			ViewUtil.setButtonTextColor(this.arenaButton, Color.BLACK);

			NetworkDelegate.show();
//			ArenaDelegate.show(new Arena(ALLIES, EnemyController.adjustEnemiesByDifficulty(ENCOUNTER_ENEMIES),
//				new GameBoard(ResourceLoader.createGameBoardFromFile(ENCOUNTER_TWO_FILEPATH))));
		}
	}


	@FXML
	void buttonClickMenu (final ActionEvent actionEvent)
	{
		if (actionEvent.getSource().equals(this.continueMenuItem))
		{
			System.out.println(Sniper.getAllyInstance().toString());
		}
		else if (actionEvent.getSource().equals(this.newGameMenuItem))
		{
			DifficultyDelegate.show(GameApplication.getStage());
		}
		else if (actionEvent.getSource().equals(this.loadGameMenuItem))
		{
			FileChooserView.show(GameApplication.getStage(), GAME_SAVE_FOLDER_FILE_PATH,
				StringConstants.chooseGameFile);
		}
		else if (actionEvent.getSource().equals(this.settingsMenuItem))
		{
			UpgradeDialogDelegate.show(DefenseArtifact.getInstance(), ArtifactController.getInstance());
		}
		else if (actionEvent.getSource().equals(this.exitGameMenuItem))
		{
			ExitGameDialogDelegate.show();
		}
		else if (actionEvent.getSource().equals(this.arenaMenuItem))
		{
			ArenaDelegate.show(new Arena(ALLIES, ENCOUNTER_ONE_ENEMIES,
				new GameBoard(ResourceLoader.createGameBoardFromFile("src/main/resources/me/vault/game/map" +
				                                                     "/Encounter_2.txt"))));
		}
	}


	@Override
	public void initialize (final URL url, final ResourceBundle resourceBundle)
	{
		this.initializeContinue();
		this.initializeLoadGame();
		this.initializeButtonBackgrounds();

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
	private void initializeLoadGame ()
	{
		if (ResourceLoader.collectFiles(GAME_SAVE_FOLDER_FILE_PATH).isEmpty())
		{
			ViewUtil.setMenuItemInactive(this.loadGameMenuItem);
			ViewUtil.setButtonInactive(this.loadGameButton);
		}
	}


	@FXML
	private void initializeButtonBackgrounds ()
	{
		ViewUtil.setButtonImage(this.continueButton, BUTTON_BACKGROUND_NORMAL);
		ViewUtil.setButtonImage(this.newGameButton, BUTTON_BACKGROUND_NORMAL);
		ViewUtil.setButtonImage(this.loadGameButton, BUTTON_BACKGROUND_NORMAL);
		ViewUtil.setButtonImage(this.settingsButton, BUTTON_BACKGROUND_NORMAL);
		ViewUtil.setButtonImage(this.exitGameButton, BUTTON_BACKGROUND_NORMAL);
		ViewUtil.setButtonImage(this.arenaButton, BUTTON_BACKGROUND_NORMAL);
	}

}
