package me.vault.game.view;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import me.vault.game.GameApplication;
import me.vault.game.utility.loading.ResourceLoader;
import me.vault.game.utility.logging.ILogger;
import me.vault.game.utility.logging.Logger;

import java.net.URL;
import java.util.ResourceBundle;


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

	// Texts ----------------------------------------------------------------------------------------------------------

	@FXML
	private Text storyText; //TODO: put story text in interface (not FXML)

	// Methods --------------------------------------------------------------------------------------------------------


	public static void show (final Stage stage)
	{
		ViewUtil.show(GameApplication.getStage(), SCENE, PrologueDelegate.class);
	}


	@FXML
	void buttonClick (final MouseEvent mouseEvent)
	{
		if (mouseEvent.getSource().equals(this.backButton))
		{
			DifficultyDelegate.show();
		}
		else if (mouseEvent.getSource().equals(this.continueButton))
		{
			TutorialDelegate.show(GameApplication.getStage());
		}
	}


	@Override
	public void initialize (final URL url, final ResourceBundle resourceBundle)
	{
	}

}
