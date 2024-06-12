package me.vault.game.view;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
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
	 * The logger object for this class used for writing formatted outputs into the console.
	 *
	 * @see Logger
	 */
	private static final ILogger LOGGER = new Logger(DifficultyDelegate.class.getSimpleName());

	/**
	 * This file is located in the directory {@code ./src/main/java/resources/me/vault/vaultgame} and defines the properties (color etc.) of the GUI
	 * elements.
	 */
	private static final String DIFFICULTY_VIEW_FXML = "difficulty.fxml";

	private static final Scene DIFFICULTY_MENU_SCENE = ResourceLoader.loadScene(DifficultyDelegate.class, DIFFICULTY_VIEW_FXML);

	@FXML
	private Button easyDifficultyButton;

	// ImageViews ------------------------------------------------------------------------------------------------------------
	@FXML
	private Button normalDifficultyButton;

	@FXML
	private Button hardDifficultyButton;

	@FXML
	private Button backButton;

	@FXML
	private ImageView backgroundImageView;

	@FXML
	private ImageView easyDifficultyButtonImageView;

	// Texts ------------------------------------------------------------------------------------------------------------
	@FXML
	private ImageView normalDifficultyButtonImageView;

	@FXML
	private ImageView hardDifficultyButtonImageView;

	@FXML
	private ImageView backButtonImageView;

	@FXML
	private Text easyDifficultyButtonText;

	// Actions----------------------------------------------------------------------------------------------------------
	@FXML
	private Text normalDifficultyButtonText;

	@FXML
	private Text hardDifficultyButtonText;

	@FXML
	private Text backButtonText;


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
			ViewUtil.setImage(this.easyDifficultyButtonImageView, ResourceLoader.loadImage(ASSETS_PATH + StringConstants.buttonRoundImageName));
		}
		else if (mouseEvent.getSource().equals(this.normalDifficultyButton))
		{
			ViewUtil.setImage(this.normalDifficultyButtonImageView, ResourceLoader.loadImage(ASSETS_PATH + StringConstants.buttonRoundImageName));
		}
		else if (mouseEvent.getSource().equals(this.hardDifficultyButton))
		{
			ViewUtil.setImage(this.hardDifficultyButtonImageView, ResourceLoader.loadImage(ASSETS_PATH + StringConstants.buttonRoundImageName));
		}
		else if (mouseEvent.getSource().equals(this.backButton))
		{
			ViewUtil.setImage(this.backButtonImageView, ResourceLoader.loadImage(ASSETS_PATH + StringConstants.buttonRoundImageName));
		}
	}


	@FXML
	public void returnButtonBackgroundToNormal (final MouseEvent mouseEvent)
	{
		if (mouseEvent.getSource().equals(this.easyDifficultyButton))
		{
			ViewUtil.setImage(this.easyDifficultyButtonImageView, ResourceLoader.loadImage(ASSETS_PATH + StringConstants.buttonImageName));
		}
		else if (mouseEvent.getSource().equals(this.normalDifficultyButton))
		{
			ViewUtil.setImage(this.normalDifficultyButtonImageView, ResourceLoader.loadImage(ASSETS_PATH + StringConstants.buttonImageName));
		}
		else if (mouseEvent.getSource().equals(this.hardDifficultyButton))
		{
			ViewUtil.setImage(this.hardDifficultyButtonImageView, ResourceLoader.loadImage(ASSETS_PATH + StringConstants.buttonImageName));
		}
		else if (mouseEvent.getSource().equals(this.backButton))
		{
			ViewUtil.setImage(this.backButtonImageView, ResourceLoader.loadImage(ASSETS_PATH + StringConstants.buttonImageName));
		}
	}


	@FXML
	void changeButtonTextColor (final MouseEvent mouseEvent)
	{
		if (mouseEvent.getSource().equals(this.easyDifficultyButton))
		{
			ViewUtil.setButtonColor(this.easyDifficultyButtonText, Color.valueOf(StringConstants.colorLightBlue));
		}
		else if (mouseEvent.getSource().equals(this.normalDifficultyButton))
		{
			ViewUtil.setButtonColor(this.normalDifficultyButtonText, Color.valueOf(StringConstants.colorLightBlue));
		}
		else if (mouseEvent.getSource().equals(this.hardDifficultyButton))
		{
			ViewUtil.setButtonColor(this.hardDifficultyButtonText, Color.valueOf(StringConstants.colorLightBlue));
		}
		else if (mouseEvent.getSource().equals(this.backButton))
		{
			ViewUtil.setButtonColor(this.backButtonText, Color.valueOf(StringConstants.colorLightBlue));
		}
	}


	@FXML
	void buttonClick (final MouseEvent mouseEvent)
	{
		if (mouseEvent.getSource().equals(this.easyDifficultyButton))
		{
			ViewUtil.setButtonColor(this.easyDifficultyButtonText, Color.BLACK);
			GameController.getInstance().setDifficultyModifyer(GameDifficulty.EASY_MODE);
			PrologueDelegate.show(VaultApplication.getStage());
		}
		else if (mouseEvent.getSource().equals(this.normalDifficultyButton))
		{
			ViewUtil.setButtonColor(this.normalDifficultyButtonText, Color.BLACK);
			DifficultyDelegate.show(VaultApplication.getStage());
			GameController.getInstance().setDifficultyModifyer(GameDifficulty.NORMAL_MODE);
			PrologueDelegate.show(VaultApplication.getStage());
		}
		else if (mouseEvent.getSource().equals(this.hardDifficultyButton))
		{
			ViewUtil.setButtonColor(this.hardDifficultyButtonText, Color.BLACK);
			GameController.getInstance().setDifficultyModifyer(GameDifficulty.HARD_MODE);
			PrologueDelegate.show(VaultApplication.getStage());
		}
		else if (mouseEvent.getSource().equals(this.backButton))
		{
			ViewUtil.setButtonColor(this.backButtonText, Color.BLACK);
			MainMenuDelegate.show();
		}
	}


	@Override
	public void initialize (final URL url, final ResourceBundle resourceBundle)
	{

	}

}
