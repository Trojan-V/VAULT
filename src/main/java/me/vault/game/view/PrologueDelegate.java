package me.vault.game.view;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import me.vault.game.GameApplication;
import me.vault.game.utility.loading.ResourceLoader;
import me.vault.game.utility.logging.ILogger;
import me.vault.game.utility.logging.Logger;

import java.net.URL;
import java.text.MessageFormat;
import java.util.ResourceBundle;


/**
 * The {@link PrologueDelegate} is responsive for the control (Controller) and display (View) of the prolog scene at the beginning of the game.
 * It provides a GUI and methods to scroll and read through different sections of the game lore.
 *
 * @author Vincent Wolf, Lasse-Leander Hillen, Timothy Hoegen-Jupp, Alexander Goethel
 * @see MainMenuDelegate
 * @since 29.07.2024
 */
public class PrologueDelegate implements Initializable
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
	 * The
	 */
	@FXML
	private Button continueButton;

	@FXML
	private Button backButton;

	@FXML
	private Text storyText; //TODO: put story text in interface (not FXML)


	public static void show ()
	{
		ViewUtil.show(GameApplication.getStage(), ResourceLoader.loadScene(PrologueDelegate.class, PROLOG_VIEW_FXML), PrologueDelegate.class);
	}


	@FXML
	void click (final MouseEvent mouseEvent)
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
