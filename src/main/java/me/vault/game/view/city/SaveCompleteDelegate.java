package me.vault.game.view.city;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import me.vault.game.utility.loading.ConfigLoader;
import me.vault.game.utility.loading.ResourceLoader;
import me.vault.game.utility.logging.ILogger;
import me.vault.game.utility.logging.Logger;

import java.net.URL;
import java.text.MessageFormat;
import java.util.ResourceBundle;

import static me.vault.game.utility.interfaces.constant.GameConstants.WINDOW_ICON_PATH;
import static me.vault.game.utility.interfaces.constant.LoggingConstants.SHOWING_VIEW_PATTERN;
import static me.vault.game.utility.logging.ILogger.Level.DEBUG;


/**
 * The {@link SaveCompleteDelegate} is responsible for the control (Controller) and display (View) of the dialog that appears when the user saves the game to config.
 * It doesn't provide the actual methods to save the game to config but more so acts like a notification popup, that the user's input has been registered.
 *
 * @author Vincent Wolf, Lasse-Leander Hillen, Timothy Hoegen-Jupp, Alexander Goethel
 * @see DialogPane
 * @see Stage
 * @see ConfigLoader
 * @since 29.07.2024
 */
public final class SaveCompleteDelegate implements Initializable
{

	/**
	 * The {@link Logger} object for this class used for writing to the console.
	 */
	private static final ILogger LOGGER = new Logger(SaveCompleteDelegate.class.getSimpleName());

	/**
	 * The path to the respective fxml file of the delegate as a {@link String}.
	 */
	private static final String SAVE_GAME_DIALOG_VIEW_FXML = "save_complete_dialog.fxml";

	/**
	 * The {@link MessageFormat} pattern, which is used, when the {@link SaveCompleteDelegate#toString()} is called.
	 */
	private static final String TO_STRING_PATTERN = "SaveCompleteDelegate'{'fxml={0}'}'";

	/**
	 * The name of the window handle, which is added to the {@link SaveCompleteDelegate#STAGE} in the static initializer as a {@link String}.
	 */
	private static final String WINDOW_TITLE = "Save game complete.";

	/**
	 * The {@link Stage} of the {@link SaveCompleteDelegate}, which is needed because the {@link DialogPane} needs to be shown on a new window.
	 */
	private static final Stage STAGE = new Stage();


	static
	{
		STAGE.setResizable(false);
		STAGE.setTitle(WINDOW_TITLE);
		STAGE.initModality(Modality.APPLICATION_MODAL);
		STAGE.getIcons().add(ResourceLoader.loadImage(WINDOW_ICON_PATH));
	}


	/**
	 * The {@link DialogPane} at the start of the scene tree, every other control builds on it.
	 */
	@FXML
	private DialogPane saveGameDialogPane;


	/**
	 * Displays the {@link SaveCompleteDelegate#saveGameDialogPane} on a new {@link Stage}.
	 *
	 * @precondition The method gets called and the fxml file points to the correct ressource.
	 * @postcondition The {@link SaveCompleteDelegate#saveGameDialogPane} is displayed on a new {@link Stage}.
	 */
	public static void show ()
	{
		STAGE.setScene(ResourceLoader.loadScene(SaveCompleteDelegate.class, SAVE_GAME_DIALOG_VIEW_FXML));
		LOGGER.logf(DEBUG, SHOWING_VIEW_PATTERN, SaveCompleteDelegate.class.getSimpleName());
		STAGE.showAndWait();
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
		// Closes the different stages of the program if the user presses OK
		this.saveGameDialogPane.lookupButton(ButtonType.OK).setOnMouseClicked(_ -> STAGE.close());
	}


	/**
	 * Builds a formatted {@link String}, which represents the object, and it's current state using the {@link SaveCompleteDelegate#TO_STRING_PATTERN}.
	 *
	 * @return A {@link String} which has been formatted in the {@link SaveCompleteDelegate#TO_STRING_PATTERN}.
	 *
	 * @precondition The {@link SaveCompleteDelegate#TO_STRING_PATTERN} is {@code != null}.
	 * @postcondition The method returned a {@link String} which represents the object.
	 */
	@Override
	public String toString ()
	{
		return MessageFormat.format(TO_STRING_PATTERN, SAVE_GAME_DIALOG_VIEW_FXML);
	}

}

