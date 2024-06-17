package me.vault.game.view;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import me.vault.game.VaultApplication;
import me.vault.game.control.GameController;
import me.vault.game.model.GameDifficulty;
import me.vault.game.utility.constant.StringConstants;
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
	// Buttons ----------------------------------------------------------------------------------------------------------

	/**
	 * The {@link Logger} object for this class used for writing to the console.
	 */
	private static final ILogger LOGGER = new Logger(DifficultyDelegate.class.getSimpleName());

	/**
	 * This file is located in the directory {@code ./src/main/java/resources/me/vault/vaultgame} and defines the properties (color etc.) of the GUI
	 * elements.
	 */
	private static final String DIFFICULTY_VIEW_FXML = "difficulty.fxml";


	private static final String BUTTON_BACKGROUND_NORMAL = ASSETS_PATH + "button.png";
		//TODO: Consolidate into Interface


	private static final String BUTTON_BACKGROUND_SELECTED = ASSETS_PATH + "button_round.png";
		//TODO: Consolidate into Interface

	private static final Scene DIFFICULTY_MENU_SCENE = ResourceLoader.loadScene(DifficultyDelegate.class, DIFFICULTY_VIEW_FXML);

	@FXML
	private Button easyDifficultyButton;

	@FXML
	private Button normalDifficultyButton;

	@FXML
	private Button hardDifficultyButton;

	@FXML
	private Button backButton;

	@FXML
	private ImageView backgroundImageView;


	public static void show (final Stage stage)
	{
		stage.setScene(DIFFICULTY_MENU_SCENE);
		stage.show();
		LOGGER.log(DEBUG, MessageFormat.format(SHOWING_VIEW_MSG, DifficultyDelegate.class.getSimpleName()));
	}


	@FXML
	void changeButtonBackground (final MouseEvent mouseEvent)
	{
		if (mouseEvent.getSource().equals(this.easyDifficultyButton))
		{
			ViewUtil.setButtonImage(this.easyDifficultyButton, BUTTON_BACKGROUND_SELECTED);
		}
		else if (mouseEvent.getSource().equals(this.normalDifficultyButton))
		{
			ViewUtil.setButtonImage(this.normalDifficultyButton, BUTTON_BACKGROUND_SELECTED);
		}
		else if (mouseEvent.getSource().equals(this.hardDifficultyButton))
		{
			ViewUtil.setButtonImage(this.hardDifficultyButton, BUTTON_BACKGROUND_SELECTED);
		}
		else if (mouseEvent.getSource().equals(this.backButton))
		{
			ViewUtil.setButtonImage(this.backButton, BUTTON_BACKGROUND_SELECTED);
		}
	}


	@FXML
	public void returnButtonBackgroundToNormal (final MouseEvent mouseEvent)
	{
		if (mouseEvent.getSource().equals(this.easyDifficultyButton))
		{
			ViewUtil.setButtonImage(this.easyDifficultyButton, BUTTON_BACKGROUND_NORMAL);
		}
		else if (mouseEvent.getSource().equals(this.normalDifficultyButton))
		{
			ViewUtil.setButtonImage(this.normalDifficultyButton, BUTTON_BACKGROUND_NORMAL);
		}
		else if (mouseEvent.getSource().equals(this.hardDifficultyButton))
		{
			ViewUtil.setButtonImage(this.hardDifficultyButton, BUTTON_BACKGROUND_NORMAL);
		}
		else if (mouseEvent.getSource().equals(this.backButton))
		{
			ViewUtil.setButtonImage(this.backButton, BUTTON_BACKGROUND_NORMAL);
		}
	}


	@FXML
	void changeButtonTextColor (final MouseEvent mouseEvent)
	{
		if (mouseEvent.getSource().equals(this.easyDifficultyButton))
		{
			ViewUtil.setButtonTextColor(this.easyDifficultyButton, StringConstants.colorLightBlue);
		}
		else if (mouseEvent.getSource().equals(this.normalDifficultyButton))
		{
			ViewUtil.setButtonTextColor(this.normalDifficultyButton, StringConstants.colorLightBlue);
		}
		else if (mouseEvent.getSource().equals(this.hardDifficultyButton))
		{
			ViewUtil.setButtonTextColor(this.hardDifficultyButton, StringConstants.colorLightBlue);
		}
		else if (mouseEvent.getSource().equals(this.backButton))
		{
			ViewUtil.setButtonTextColor(this.backButton, StringConstants.colorLightBlue);
		}
	}


	@FXML
	void buttonClick (final MouseEvent mouseEvent)
	{
		if (mouseEvent.getSource().equals(this.easyDifficultyButton))
		{
			ViewUtil.setButtonTextColor(this.easyDifficultyButton, Color.BLACK);
			GameController.getInstance().setDifficultyModifyer(GameDifficulty.EASY_MODE);
			PrologueDelegate.show(VaultApplication.getStage());
		}
		else if (mouseEvent.getSource().equals(this.normalDifficultyButton))
		{
			ViewUtil.setButtonTextColor(this.normalDifficultyButton, Color.BLACK);
			GameController.getInstance().setDifficultyModifyer(GameDifficulty.NORMAL_MODE);
			PrologueDelegate.show(VaultApplication.getStage());
		}
		else if (mouseEvent.getSource().equals(this.hardDifficultyButton))
		{
			ViewUtil.setButtonTextColor(this.hardDifficultyButton, Color.BLACK);
			GameController.getInstance().setDifficultyModifyer(GameDifficulty.HARD_MODE);
			PrologueDelegate.show(VaultApplication.getStage());
		}
		else if (mouseEvent.getSource().equals(this.backButton))
		{
			ViewUtil.setButtonTextColor(this.backButton, Color.BLACK);
			MainMenuDelegate.show();
		}
	}


	@Override
	public void initialize (final URL url, final ResourceBundle resourceBundle)
	{
		this.initializeButtons();
	}


	private void initializeButtons ()
	{
		ViewUtil.setButtonImage(this.backButton, BUTTON_BACKGROUND_NORMAL);
		ViewUtil.setButtonImage(this.easyDifficultyButton, BUTTON_BACKGROUND_NORMAL);
		ViewUtil.setButtonImage(this.normalDifficultyButton, BUTTON_BACKGROUND_NORMAL);
		ViewUtil.setButtonImage(this.hardDifficultyButton, BUTTON_BACKGROUND_NORMAL);
	}

}
