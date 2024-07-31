package me.vault.game.view;


import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import me.vault.game.GameApplication;
import me.vault.game.utility.interfaces.constant.GameConstants;
import me.vault.game.utility.loading.ResourceLoader;
import me.vault.game.utility.logging.ILogger;
import me.vault.game.utility.logging.Logger;

import java.net.URL;
import java.text.MessageFormat;
import java.util.ResourceBundle;

import static me.vault.game.utility.interfaces.constant.LoggingConstants.SHOWING_VIEW_PATTERN;
import static me.vault.game.utility.logging.ILogger.Level.DEBUG;


/**
 * The {@link ExitGameDialogDelegate} is responsive for the control (Controller) and display (View) of the dialog that appears when the
 * user tries to close the game.
 * It provides methods to stop the program from exiting if the user is unsure about leaving or to close the program if the user wants to exit.
 *
 * @author Vincent Wolf, Lasse-Leander Hillen, Timothy Hoegen-Jupp, Alexander Goethel
 * @version 1.0.0
 * @see DialogPane
 * @see Stage
 * @since 29.07.2024
 */
public final class ExitGameDialogDelegate implements Initializable
{

	/**
	 * The {@link Logger} object for this class used for writing to the console.
	 */
	private static final ILogger LOGGER = new Logger(ExitGameDialogDelegate.class.getSimpleName());

	/**
	 * The path to the respective fxml file of the delegate as a {@link String}.
	 */
	private static final String EXIT_GAME_DIALOG_VIEW_FXML = "game_exit_dialog.fxml";

	/**
	 * The {@link MessageFormat} pattern, which is used, when the {@link ExitGameDialogDelegate#toString()} is called.
	 */
	private static final String TO_STRING_PATTERN = "ExitGameDialogDelegate'{'fxml={0}'}'";

	/**
	 * The name of the window handle, which is added to the {@link ExitGameDialogDelegate#STAGE} in the static initializer as a {@link String}.
	 */
	private static final String WINDOW_TITLE = "Exit Game?";

	/**
	 * The {@link Stage} of the {@link ExitGameDialogDelegate}, which is necessary because the {@link DialogPane} needs to be shown on a new window.
	 */
	private static final Stage STAGE = new Stage();


	static
	{
		STAGE.setResizable(false);
		STAGE.setTitle(WINDOW_TITLE);
		STAGE.initModality(Modality.APPLICATION_MODAL);
		STAGE.getIcons().add(ResourceLoader.loadImage(GameConstants.WINDOW_ICON_PATH));
	}


	/**
	 * The {@link DialogPane} at the start of the scene tree, every other control builds on it.
	 */
	@FXML
	private DialogPane exitGameDialogPane;


	/**
	 * Displays the {@link ExitGameDialogDelegate#exitGameDialogPane} on a new {@link Stage}.
	 *
	 * @precondition The method gets called and the fxml file points to the correct ressource.
	 * @postcondition The {@link ExitGameDialogDelegate#exitGameDialogPane} is displayed on a new {@link Stage}.
	 * @see Stage#showAndWait()
	 */
	public static void show ()
	{
		STAGE.setScene(ResourceLoader.loadScene(ExitGameDialogDelegate.class, EXIT_GAME_DIALOG_VIEW_FXML));
		LOGGER.logf(DEBUG, SHOWING_VIEW_PATTERN, ExitGameDialogDelegate.class.getSimpleName());
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
		// Closes the different stages of the program if the user presses "YES".
		this.exitGameDialogPane.lookupButton(ButtonType.YES).setOnMouseClicked(_ -> {
			STAGE.close();
			GameApplication.getStage().close();
			Platform.exit();
		});

		// Closes the dialog if the user presses NO
		this.exitGameDialogPane.lookupButton(ButtonType.NO).setOnMouseClicked(_ -> STAGE.close());
	}


	/**
	 * Builds a formatted {@link String}, which represents the object, and it's current state using the {@link ExitGameDialogDelegate#TO_STRING_PATTERN}.
	 *
	 * @return A {@link String} which has been formatted in the {@link ExitGameDialogDelegate#TO_STRING_PATTERN}.
	 *
	 * @precondition The {@link ExitGameDialogDelegate#TO_STRING_PATTERN} is {@code != null}.
	 * @postcondition The method returned a {@link String} which represents the object.
	 */
	@Override
	public String toString ()
	{
		return MessageFormat.format(TO_STRING_PATTERN, EXIT_GAME_DIALOG_VIEW_FXML);
	}

}
