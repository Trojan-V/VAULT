package me.vault.game.view;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import me.vault.game.GameApplication;
import me.vault.game.control.GameController;
import me.vault.game.model.GameDifficulty;
import me.vault.game.utility.loading.ResourceLoader;
import me.vault.game.utility.logging.ILogger;
import me.vault.game.utility.logging.Logger;

import java.net.URL;
import java.text.MessageFormat;
import java.util.ResourceBundle;

import static me.vault.game.utility.constant.LoggingConstants.SHOWING_VIEW_MSG;
import static me.vault.game.utility.logging.ILogger.Level.DEBUG;


public final class DifficultyDelegate implements Initializable
{

	/**
	 * The {@link Logger} object for this class used for writing to the console.
	 */
	private static final ILogger LOGGER = new Logger(DifficultyDelegate.class.getSimpleName());

	/**
	 * This file is located in the directory {@code ./src/main/java/resources/me/vault/vaultgame} and defines the properties (color etc.) of the GUI
	 * elements.
	 */
	private static final String DIFFICULTY_VIEW_FXML = "difficulty.fxml";

	private static final Scene DIFFICULTY_MENU_SCENE = ResourceLoader.loadScene(DifficultyDelegate.class, DIFFICULTY_VIEW_FXML);


	/**
	 *
	 */
	@FXML
	private Button easyDifficultyButton;

	@FXML
	private Button normalDifficultyButton;

	@FXML
	private Button hardDifficultyButton;

	@FXML
	private Button backButton;


	public static void show ()
	{
		LOGGER.log(DEBUG, MessageFormat.format(SHOWING_VIEW_MSG, DifficultyDelegate.class.getSimpleName()));
		ViewUtil.show(GameApplication.getStage(), DIFFICULTY_MENU_SCENE, DifficultyDelegate.class);
	}


	@FXML
	private void click (final MouseEvent mouseEvent)
	{
		if (mouseEvent.getSource().equals(this.easyDifficultyButton))
		{
			setGameDifficultyAndContinue(GameDifficulty.EASY_MODE);
		}
		else if (mouseEvent.getSource().equals(this.normalDifficultyButton))
		{
			setGameDifficultyAndContinue(GameDifficulty.NORMAL_MODE);
		}
		else if (mouseEvent.getSource().equals(this.hardDifficultyButton))
		{
			setGameDifficultyAndContinue(GameDifficulty.HARD_MODE);
		}
		else if (mouseEvent.getSource().equals(this.backButton))
		{
			MainMenuDelegate.show();
		}
	}


	/**
	 *
	 * @param gameDifficulty
	 */
	private void setGameDifficultyAndContinue (GameDifficulty gameDifficulty)
	{
		GameController.getInstance().setDifficulty(gameDifficulty);
		PrologueDelegate.show(GameApplication.getStage());
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
	}

}
