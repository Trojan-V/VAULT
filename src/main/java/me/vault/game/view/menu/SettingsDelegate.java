package me.vault.game.view.menu;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import me.vault.game.GameApplication;
import me.vault.game.control.GameController;
import me.vault.game.model.GameDifficulty;
import me.vault.game.utility.Config;
import me.vault.game.utility.ViewUtil;
import me.vault.game.utility.loading.ResourceLoader;

import java.net.URL;
import java.util.ResourceBundle;


/**
 * This class acts as the controller and view for the settings.
 * <br>
 * The class provides methods to display the settings {@link SettingsDelegate#show()} as well as methods for
 * the player to interact with the application ({@link SettingsDelegate#updateDifficulty(MouseEvent)} and
 * {@link SettingsDelegate#buttonClick(MouseEvent)}).
 *
 * @author Vincent Wolf, Lasse-Leander Hillen, Timothy Hoegen-Jupp, Alexander Goethel
 * @version 1.0.0
 * @since 28.04.2024
 */
public final class SettingsDelegate implements Initializable
{

	/**
	 * This file is located in the directory {@code ./src/main/java/resources/me/vault/game} and defines the properties (color etc.) of the GUI
	 * elements.
	 */
	private static final String SETTINGS_FXML = "settings.fxml";

	/**
	 * The integer that defines the easy difficulty position of the slider.
	 */
	private static final int EASY_SLIDER_INT = 0;


	/**
	 * The integer that defines the normal difficulty position of the slider.
	 */
	private static final int NORMAL_SLIDER_INT = 1;


	/**
	 * The integer that defines the hard difficulty position of the slider.
	 */
	private static final int HARD_SLIDER_INT = 2;


	/**
	 * {@link Button} that provides the player with the ability to return to the main menu.
	 */
	@FXML
	private Button backButton;


	/**
	 * {@link Slider} that provides the player with the ability to change the difficulty.
	 */
	@FXML
	private Slider difficultySlider;


	/**
	 * Calls a method to display the content stored in {@link SettingsDelegate#SETTINGS_FXML} and initialized
	 * by {@link SettingsDelegate#initialize(URL, ResourceBundle)} on the main stage of this application
	 * ({@link GameApplication#getStage()})
	 *
	 * @precondition The GameApplication has to have a stage.
	 * @postcondition The initialized view is shown on the GameApplication Stage.
	 */
	public static void show ()
	{
		ViewUtil.show(GameApplication.getStage(), ResourceLoader.loadScene(SettingsDelegate.class, SETTINGS_FXML), SettingsDelegate.class);
	}


	/**
	 * When the {@link SettingsDelegate#backButton} is pressed, the main menu is shown.
	 *
	 * @param mouseEvent The MouseEvent that triggers the method.
	 *
	 * @precondition The settings (scene) have to be displayed on the active stage.
	 * @postcondition The main menu is shown if the source from the {@link MouseEvent} is the
	 * {@link SettingsDelegate#backButton}.
	 */
	@FXML
	void buttonClick (final MouseEvent mouseEvent)
	{
		if (mouseEvent.getSource().equals(this.backButton))
		{
			MainMenuDelegate.show();
		}

	}


	/**
	 * Checks if the game difficulty is changed when the slider is clicked.
	 *
	 * @param mouseEvent The MouseEvent that triggers the method.
	 *
	 * @precondition The MainMenu Scene has to be displayed on the active stage.
	 * @postcondition The game difficulty is set according to the position of the slider ({@link SettingsDelegate#EASY_SLIDER_INT} =
	 * easy; {@link SettingsDelegate#NORMAL_SLIDER_INT} = normal; {@link SettingsDelegate#HARD_SLIDER_INT} = hard),
	 * if the mouseEven source is the {@link SettingsDelegate#difficultySlider}.
	 */
	@FXML
	void updateDifficulty (final MouseEvent mouseEvent)
	{
		if (mouseEvent.getSource().equals(this.difficultySlider))
		{
			switch (this.difficultySlider.valueProperty().intValue())
			{
				case EASY_SLIDER_INT:
					GameController.setDifficulty(GameDifficulty.EASY);
					break;
				case NORMAL_SLIDER_INT:
					GameController.setDifficulty(GameDifficulty.NORMAL);
					break;
				case HARD_SLIDER_INT:
					GameController.setDifficulty(GameDifficulty.HARD);
					break;
			}

			Config.getInstance().updateConfigFromModels();
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
	public void initialize (final URL url, final ResourceBundle resourceBundle)
	{
		this.initializeDifficultySlider();
	}


	/**
	 * Sets the position of the {@link SettingsDelegate#difficultySlider} according to the game difficulty in the
	 * {@link GameController}.
	 *
	 * @precondition The settings controller has to have been called.
	 * @postcondition The {@link SettingsDelegate#difficultySlider}-position displays the difficult from the
	 * {@link GameController} class ({@link SettingsDelegate#EASY_SLIDER_INT} = easy;
	 * {@link SettingsDelegate#NORMAL_SLIDER_INT} = normal; {@link SettingsDelegate#HARD_SLIDER_INT} = hard).
	 */
	private void initializeDifficultySlider ()
	{
		switch (GameController.getDifficulty())
		{
			case EASY -> this.difficultySlider.setValue(EASY_SLIDER_INT);
			case NORMAL -> this.difficultySlider.setValue(NORMAL_SLIDER_INT);
			case HARD -> this.difficultySlider.setValue(HARD_SLIDER_INT);
		}
	}

}
