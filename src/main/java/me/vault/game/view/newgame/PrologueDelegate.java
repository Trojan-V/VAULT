package me.vault.game.view.newgame;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import me.vault.game.GameApplication;
import me.vault.game.utility.ViewUtil;
import me.vault.game.utility.loading.ResourceLoader;
import me.vault.game.utility.logging.ILogger;
import me.vault.game.utility.logging.Logger;
import me.vault.game.view.arena.ArenaFinishedDialogDelegate;

import java.net.URL;
import java.text.MessageFormat;
import java.util.ResourceBundle;


/**
 * The {@code  PrologueDelegate} is responsive for the control (Controller) and display (View) of the prologue scene at
 * the beginning of the game.
 * It provides a GUI and methods to scroll and read through different sections of the game lore.
 *
 * @author Vincent Wolf, Lasse-Leander Hillen, Timothy Hoegen-Jupp, Alexander Goethel
 * @version 1.0.0
 * @since 29.07.2024
 */
public final class PrologueDelegate implements Initializable
{

	/**
	 * The {@link Logger} object for this class used for writing to the console.
	 */
	private static final ILogger LOGGER = new Logger(PrologueDelegate.class.getSimpleName());

	/**
	 * The path to the respective fxml file of the delegate as a {@link String}.
	 */
	private static final String PROLOG_VIEW_FXML = "prologue.fxml";

	/**
	 * The {@link MessageFormat} pattern, which is used, when the {@link ArenaFinishedDialogDelegate#toString()} is called.
	 */
	private static final String TO_STRING_PATTERN = "PrologueDelegate'{'fxml={0}'}'";

	/**
	 * {@link Button} that provides the player with the ability to continue to the tutorial.
	 */
	@FXML
	private Button continueButton;


	/**
	 * {@link Button} that provides the player with the ability to return to difficulty selection.
	 */
	@FXML
	private Button backButton;


	/**
	 * {@link Text} that displays the prolog of the game.
	 */
	@FXML
	private Text storyText;


	/**
	 * Calls a method to display the content stored in {@link PrologueDelegate#PROLOG_VIEW_FXML} and initialized
	 * by {@link PrologueDelegate#initialize(URL, ResourceBundle)} on the main stage of this application
	 * ({@link GameApplication#getStage()})
	 *
	 * @precondition The GameApplication has to have a stage.
	 * @postcondition The initialized prolog is shown on the GameApplication Stage.
	 * @see ViewUtil#show(Stage, Scene, Class)
	 */
	public static void show ()
	{
		ViewUtil.show(GameApplication.getStage(), ResourceLoader.loadScene(PrologueDelegate.class, PROLOG_VIEW_FXML), PrologueDelegate.class);
	}


	/**
	 * Handles the button action "click" that is defined in the FXML-File.
	 * <br>
	 * <br>
	 * The method differentiates between different action that can be triggered by clicking on the different buttons
	 * of the scene.
	 * <br>
	 * <br>
	 * The actions that are triggered by their respective {@link Button} are listed below:
	 * <br>
	 * If the {@link PrologueDelegate#backButton} is clicked, the difficulty selection is shown.
	 * <br>
	 * If the {@link PrologueDelegate#continueButton} is clicked, the tutorial is shown.
	 *
	 * @param mouseEvent The MouseEvent that determines the triggered action(s)
	 *
	 * @precondition The prolog (scene) has to be displayed on the active stage.
	 * @postcondition The specified actions ,as described by this documentation, are executed.
	 */
	@FXML
	void click (final MouseEvent mouseEvent)
	{
		if (mouseEvent.getSource().equals(this.backButton))
		{
			DifficultyDelegate.show();
		}
		else if (mouseEvent.getSource().equals(this.continueButton))
		{
			TutorialDelegate.show();
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
	}


	/**
	 * Builds a formatted {@link String}, which represents the object, and it's current state using the {@link PrologueDelegate#TO_STRING_PATTERN}.
	 *
	 * @return A {@link String} which has been formatted in the {@link PrologueDelegate#TO_STRING_PATTERN}.
	 *
	 * @precondition The {@link PrologueDelegate#TO_STRING_PATTERN} is {@code != null}.
	 * @postcondition The method returned a {@link String} which represents the object.
	 */
	@Override
	public String toString ()
	{
		return MessageFormat.format(TO_STRING_PATTERN, PROLOG_VIEW_FXML);
	}

}
