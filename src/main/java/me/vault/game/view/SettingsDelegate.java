package me.vault.game.view;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import me.vault.game.GameApplication;
import me.vault.game.control.GameController;
import me.vault.game.model.GameDifficulty;
import me.vault.game.utility.loading.ResourceLoader;
import me.vault.game.utility.logging.ILogger;
import me.vault.game.utility.logging.Logger;

import java.net.URL;
import java.util.ResourceBundle;


public class SettingsDelegate implements Initializable
{
	/**
	 * The {@link Logger} object for this class used for writing to the console.
	 */
	private static final ILogger LOGGER = new Logger(SettingsDelegate.class.getSimpleName());

	/**
	 * This file is located in the directory {@code ./src/main/java/resources/me/vault/game} and defines the properties (color etc.) of the GUI
	 * elements.
	 */
	private static final String SETTINGS_FXML = "settings.fxml";

	private static final Scene SCENE = ResourceLoader.loadScene(SettingsDelegate.class, SETTINGS_FXML);

	private final int easy = 0;

	private final int normal = 1;

	private final int hard = 2;

	@FXML
	private Button backButton;

	@FXML
	private Slider difficultySlider;


	/**
	 *
	 */
	public static void show ()
	{
		ViewUtil.show(GameApplication.getStage(), SCENE, SettingsDelegate.class);
	}


	@FXML
	void buttonClick (final MouseEvent mouseEvent)
	{
		MainMenuDelegate.show();
	}


	@FXML
	void updateDifficulty (final MouseEvent mouseEvent)
	{
		switch (this.difficultySlider.valueProperty().intValue())
		{
			case easy:
				GameController.getInstance().setDifficulty(GameDifficulty.EASY_MODE);
				break;
			case normal:
				GameController.getInstance().setDifficulty(GameDifficulty.NORMAL_MODE);
				break;
			case hard:
				GameController.getInstance().setDifficulty(GameDifficulty.HARD_MODE);
				break;
		}
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
	public void initialize (URL url, ResourceBundle resourceBundle)
	{
		this.initializeDifficultySlider();
	}


	private void initializeDifficultySlider ()
	{
		switch (GameController.getInstance().getDifficulty())
		{
			case EASY_MODE -> this.difficultySlider.setValue(easy);
			case NORMAL_MODE -> this.difficultySlider.setValue(normal);
			case HARD_MODE -> this.difficultySlider.setValue(hard);
		}
	}
}
