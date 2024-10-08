package me.vault.game.view.newgame;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import me.vault.game.GameApplication;
import me.vault.game.control.GameController;
import me.vault.game.model.GameDifficulty;
import me.vault.game.utility.ViewUtil;
import me.vault.game.utility.loading.ResourceLoader;
import me.vault.game.view.menu.MainMenuDelegate;

import java.net.URL;
import java.util.ResourceBundle;


/**
 * This class acts as the controller and view for the difficulty selection.
 * <br>
 * The class provides methods to display the difficulty selection as well as methods for the user to interact with
 * the application.
 *
 * @author Vincent Wolf, Lasse-Leander Hillen, Timothy Hoegen-Jupp, Alexander Goethel
 * @version 1.0.0
 * @since 30.07.2024
 */
public final class DifficultyDelegate implements Initializable
{

	/**
	 * The path to the respective fxml file of the delegate as a {@link String}.
	 */
	private static final String DIFFICULTY_VIEW_FXML = "difficulty.fxml";


	/**
	 * {@link Button} that provides the player with the ability to select the difficulty 'easy'.
	 */
	@FXML
	private Button easyDifficultyButton;

	/**
	 * {@link Button} that provides the player with the ability to select the difficulty 'normal'.
	 */
	@FXML
	private Button normalDifficultyButton;

	/**
	 * {@link Button} that provides the player with the ability to select the difficulty 'hard'.
	 */
	@FXML
	private Button hardDifficultyButton;

	/**
	 * {@link Button} that provides the player with the ability to return to the main menu.
	 */
	@FXML
	private Button backButton;


	/**
	 * Calls a method to display the content stored in {@link DifficultyDelegate#DIFFICULTY_VIEW_FXML} and
	 * initialized by {@link DifficultyDelegate#initialize(URL, ResourceBundle)} on the main stage of this
	 * application ({@link GameApplication#getStage()}).
	 *
	 * @precondition The GameApplication has to have a stage
	 * @postcondition The initialized difficulty scene is shown on the GameApplication Stage
	 * @see ViewUtil#show (Stage, Scene, Class)
	 */
	public static void show ()
	{
		ViewUtil.show(GameApplication.getStage(), ResourceLoader.loadScene(DifficultyDelegate.class, DIFFICULTY_VIEW_FXML), DifficultyDelegate.class);
	}


	/**
	 * Handles the action "click" that is defined in the FXML-File.
	 * <br>
	 * <br>
	 * The method differentiates between different actions that can be triggered by clicking on the different buttons
	 * of the scene.
	 * <br>
	 * <br>
	 * The actions that are triggered by their respective {@link Button} are listed below:
	 * <br>
	 * If "easy" is clicked, the {@link DifficultyDelegate#setGameDifficultyAndContinue(GameDifficulty)}-method is
	 * called with the parameter {@link GameDifficulty#EASY}.
	 * <br>
	 * If "normal" is clicked, the {@link DifficultyDelegate#setGameDifficultyAndContinue(GameDifficulty)}-method is
	 * called with the parameter {@link GameDifficulty#NORMAL}.
	 * <br>
	 * If "hard" is clicked, the {@link DifficultyDelegate#setGameDifficultyAndContinue(GameDifficulty)}-method is
	 * called with the parameter {@link GameDifficulty#HARD}.
	 * <br>
	 * If "back" is clicked, the main menu is displayed.
	 *
	 * @param mouseEvent The MouseEvent that determines the triggered action(s)
	 *
	 * @precondition The Difficulty Scene has to be displayed on the active stage
	 * @postcondition The specified actions as described by this documentation are executed
	 */
	@FXML
	void click (final MouseEvent mouseEvent)
	{
		if (mouseEvent.getSource().equals(this.easyDifficultyButton))
		{
			this.setGameDifficultyAndContinue(GameDifficulty.EASY);
		}
		else if (mouseEvent.getSource().equals(this.normalDifficultyButton))
		{
			this.setGameDifficultyAndContinue(GameDifficulty.NORMAL);
		}
		else if (mouseEvent.getSource().equals(this.hardDifficultyButton))
		{
			this.setGameDifficultyAndContinue(GameDifficulty.HARD);
		}
		else if (mouseEvent.getSource().equals(this.backButton))
		{
			MainMenuDelegate.show();
		}
	}


	/**
	 * Sets the GameDifficulty in the {@link GameController} and displays the prologue scene.
	 *
	 * @param gameDifficulty the difficulty of the game
	 *
	 * @precondition the parameter must be from the {@link GameDifficulty} enumeration
	 * @postcondition the desired {@link GameDifficulty} is set and the prologue scene is shown
	 */
	private void setGameDifficultyAndContinue (final GameDifficulty gameDifficulty)
	{
		GameController.setDifficulty(gameDifficulty);
		PrologueDelegate.show();
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
