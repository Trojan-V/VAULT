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

import static me.vault.game.utility.constant.GameConstants.ASSETS_PATH;
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

	//FXML Buttons ---------------------------------------------------------------------------------------
	@FXML
	private Button easyDifficultyButton;

	@FXML
	private Button normalDifficultyButton;

	@FXML
	private Button hardDifficultyButton;

	@FXML
	private Button backButton;

	//Methods ---------------------------------------------------------------------------------------

	public static void show ()
	{
		LOGGER.log(DEBUG, MessageFormat.format(SHOWING_VIEW_MSG, DifficultyDelegate.class.getSimpleName()));
		ViewUtil.show(GameApplication.getStage(), DIFFICULTY_MENU_SCENE, DifficultyDelegate.class);
	}

	@FXML
	void buttonClick (final MouseEvent mouseEvent)
	{
		if (mouseEvent.getSource().equals(this.easyDifficultyButton))
		{
			GameController.getInstance().setDifficulty(GameDifficulty.EASY_MODE);
			PrologueDelegate.show(GameApplication.getStage());
		}
		else if (mouseEvent.getSource().equals(this.normalDifficultyButton))
		{
			GameController.getInstance().setDifficulty(GameDifficulty.NORMAL_MODE);
			PrologueDelegate.show(GameApplication.getStage());
		}
		else if (mouseEvent.getSource().equals(this.hardDifficultyButton))
		{
			GameController.getInstance().setDifficulty(GameDifficulty.HARD_MODE);
			PrologueDelegate.show(GameApplication.getStage());
		}
		else if (mouseEvent.getSource().equals(this.backButton))
		{
			MainMenuDelegate.show();
		}
	}


	@Override
	public void initialize (final URL url, final ResourceBundle resourceBundle)
	{
	}
}
