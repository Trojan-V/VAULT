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
import me.vault.game.GameApplication;
import me.vault.game.utility.constant.StringConstants;
import me.vault.game.utility.loading.ResourceLoader;
import me.vault.game.utility.logging.ILogger;
import me.vault.game.utility.logging.Logger;

import java.net.URL;
import java.util.ResourceBundle;

import static me.vault.game.utility.constant.GameConstants.ASSETS_PATH;


public class PrologueDelegate implements Initializable
{

	/**
	 * The {@link Logger} object for this class used for writing to the console.
	 */
	private static final ILogger LOGGER = new Logger(PrologueDelegate.class.getSimpleName());

	/**
	 * This file is located in the directory {@code ./src/main/java/resources/me/vault/vaultgame} and defines the properties (color etc.) of the GUI
	 * elements.
	 */
	private static final String FXML_FILENAME = "prologue.fxml";

	private static final Scene SCENE = ResourceLoader.loadScene(PrologueDelegate.class, FXML_FILENAME);

	// Buttons -----------------------------------------------------------------------------------------------------------

	@FXML
	private Button continueButton;

	@FXML
	private Button backButton;

	// ImageViews -----------------------------------------------------------------------------------------------------------

	@FXML
	private ImageView continueButtonBackground;

	@FXML
	private ImageView backButtonBackground;

	// Texts ----------------------------------------------------------------------------------------------------------

	@FXML
	private Text storyText;

	@FXML
	private Text backButtonText;

	@FXML
	private Text continueButtonText;


	public static void show (final Stage stage)
	{
		ViewUtil.show(GameApplication.getStage(), SCENE, PrologueDelegate.class);
	}


	@FXML
	void changeButtonBackground (final MouseEvent mouseEvent)
	{
		if (mouseEvent.getSource().equals(this.backButton))
		{
			ViewUtil.setImage(this.backButtonBackground, ResourceLoader.loadImage(ASSETS_PATH + StringConstants.buttonRoundImageName));
		}
		else if (mouseEvent.getSource().equals(this.continueButton))
		{
			ViewUtil.setImage(this.continueButtonBackground, ResourceLoader.loadImage(ASSETS_PATH + StringConstants.buttonRoundImageName));
		}

	}


	@FXML
	public void returnButtonBackgroundToNormal (final MouseEvent mouseEvent)
	{
		if (mouseEvent.getSource().equals(this.continueButton))
		{
			ViewUtil.setImage(this.continueButtonBackground, ResourceLoader.loadImage(ASSETS_PATH + StringConstants.buttonImageName));
		}
		else if (mouseEvent.getSource().equals(this.backButton))
		{
			ViewUtil.setImage(this.backButtonBackground, ResourceLoader.loadImage(ASSETS_PATH + StringConstants.buttonImageName));
		}
	}


	@FXML
	void changeButtonTextColor (final MouseEvent mouseEvent)
	{
		if (mouseEvent.getSource().equals(this.backButton))
		{
			ViewUtil.setButtonColor(this.backButtonText, Color.valueOf(StringConstants.colorLightBlue));
		}
		else if (mouseEvent.getSource().equals(this.continueButton))
		{
			ViewUtil.setButtonColor(this.continueButtonText, Color.valueOf(StringConstants.colorLightBlue));
		}
	}


	@FXML
	void buttonClick (final MouseEvent mouseEvent)
	{
		if (mouseEvent.getSource().equals(this.backButton))
		{
			ViewUtil.setButtonColor(this.backButtonText, Color.BLACK);
			DifficultyDelegate.show(GameApplication.getStage());
		}
		else if (mouseEvent.getSource().equals(this.continueButton))
		{
			ViewUtil.setButtonColor(this.continueButtonText, Color.BLACK);
			TutorialDelegate.show(GameApplication.getStage());
		}
	}


	@Override
	public void initialize (final URL url, final ResourceBundle resourceBundle)
	{
	}

}
