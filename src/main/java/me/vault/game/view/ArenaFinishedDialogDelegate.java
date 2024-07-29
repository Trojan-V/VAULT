package me.vault.game.view;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;
import me.vault.game.model.arena.Arena;
import me.vault.game.model.arena.ArenaResult;
import me.vault.game.utility.constant.GameConstants;
import me.vault.game.utility.constant.LoggingConstants;
import me.vault.game.utility.constant.MissionConstants;
import me.vault.game.utility.loading.ResourceLoader;
import me.vault.game.utility.logging.ILogger;
import me.vault.game.utility.logging.Logger;
import me.vault.game.view.city.CityDelegate;
import me.vault.game.view.mission.MissionDelegate;
import me.vault.game.view.mission.MissionSelectionDelegate;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.text.MessageFormat;

import static me.vault.game.utility.constant.LoggingConstants.DISPLAY_FAILED;
import static me.vault.game.utility.logging.ILogger.Level.ERROR;


/**
 * The {@link MissionSelectionDelegate} is responsive for the control (Controller) and display (View) of the dialog after an arena ends.
 * It provides methods to change the appearance of the {@link DialogPane} and thereby is able to notify the GUI user of the arena-result.
 * The dialog automatically gets displayed when an arena ends.
 *
 * @author Vincent Wolf, Lasse-Leander Hillen, Timothy Hoegen-Jupp, Alexander Goethel
 * @see Arena
 * @see ArenaResult
 * @see MissionConstants
 * @see LoggingConstants.MissionDelegate
 * @since 25.07.2024
 */
public final class ArenaFinishedDialogDelegate
{

	/**
	 * The {@link Logger} object for this class used for writing to the console.
	 */
	private static final ILogger LOGGER = new Logger(ArenaFinishedDialogDelegate.class.getSimpleName());

	/**
	 * The path to the respective fxml file of the delegate as a {@link String}.
	 */
	private static final String ARENA_FINISHED_DIALOG_FXML = "arenaFinishedDialog.fxml";

	/**
	 * The {@link MessageFormat} pattern, which is used, when the {@link ArenaFinishedDialogDelegate#toString()} is called.
	 */
	private static final String TO_STRING_PATTERN = "ArenaFinishedDialogDelegate'{'fxml={0}, state={1}'}'";

	/**
	 * The name of the window handle, which is added to the {@link ArenaFinishedDialogDelegate#STAGE} in the static initializer as a {@link String}.
	 */
	private static final String WINDOW_TITLE = "It's finally over...";

	/**
	 * The {@link MessageFormat} pattern of the {@link Label} within the {@link DialogPane} which is used to show the user, if he won or lost the arena.
	 */
	private static final String RESULT_LABEL_PATTERN = "You have {0}.";

	/**
	 * The {@link Stage} of the {@link ArenaFinishedDialogDelegate}, which is needed because the {@link DialogPane} needs to be shown on a new window.
	 */
	private static final Stage STAGE = new Stage();


	static
	{
		STAGE.setTitle(WINDOW_TITLE);
		STAGE.setResizable(false);
		STAGE.initModality(Modality.APPLICATION_MODAL);
		STAGE.getIcons().add(ResourceLoader.loadImage(GameConstants.WINDOW_ICON_PATH));
	}


	/**
	 * The {@link Label} of the {@link DialogPane} which describes the result of the arena.
	 */
	@FXML
	private Label resultLabel;

	/**
	 * The {@link ArenaResult} of the Dialog, which is modified by the {@link MissionDelegate} to display the right result in the {@link ArenaFinishedDialogDelegate#resultLabel}.
	 */
	private ArenaResult arenaResult = ArenaResult.UNDEFINED;


	/**
	 * Displays the a {@link DialogPane} based on the {@link ArenaResult} instance on a new {@link Stage}.
	 *
	 * @param arenaResult The {@link ArenaResult} object, which describes the result of the arena, that displayed this {@link DialogPane}.
	 *
	 * @precondition A {@link ArenaResult} object is passed into the method.
	 * @postcondition The {@link DialogPane} is displayed on a new {@link Stage}.
	 */
	public static void show (final ArenaResult arenaResult)
	{
		try
		{
			final FXMLLoader fxmlLoader = new FXMLLoader(UpgradeDialogDelegate.class.getResource(ARENA_FINISHED_DIALOG_FXML));
			final Parent root = fxmlLoader.load();

			final ArenaFinishedDialogDelegate dialogDelegate = fxmlLoader.getController();
			dialogDelegate.setState(arenaResult);
			STAGE.setScene(new Scene(root));
			STAGE.showAndWait();
		}
		catch (final IOException e)
		{
			LOGGER.logf(ERROR, DISPLAY_FAILED, ArenaFinishedDialogDelegate.class.getSimpleName());
		}
	}


	/**
	 * Gets the {@link ArenaFinishedDialogDelegate#arenaResult} attribute of the instance of {@link ArenaFinishedDialogDelegate}.
	 *
	 * @return The {@link ArenaFinishedDialogDelegate#arenaResult} attribute as a {@link ArenaResult} object.
	 *
	 * @precondition The {@link ArenaFinishedDialogDelegate#arenaResult} attribute has already been set in the {@link ArenaFinishedDialogDelegate}.
	 * @postcondition The method returned the {@link ArenaResult} attribute.
	 */
	public ArenaResult getState ()
	{
		return this.arenaResult;
	}


	/**
	 * Sets the {@link ArenaFinishedDialogDelegate#arenaResult} attribute in the instance of {@link ArenaFinishedDialogDelegate} to the passed {@link ArenaResult} object.
	 * Sets the text of the {@link ArenaFinishedDialogDelegate#resultLabel} to a formatted version of the passed {@link ArenaResult} object.
	 *
	 * @param arenaResult The new {@link ArenaResult} object, meant to replace the current attribute in the instance.
	 *
	 * @precondition A {@link NotNull} {@link ArenaResult} object is passed into the method.
	 * @postcondition The {@link ArenaFinishedDialogDelegate} replaced the old {@link ArenaFinishedDialogDelegate#arenaResult} attribute with the passed one.
	 * The text of the {@link ArenaFinishedDialogDelegate#resultLabel} was replaced with a version of the {@link ArenaResult} object.
	 */
	private void setState (final @NotNull ArenaResult arenaResult)
	{
		this.arenaResult = arenaResult;
		this.resultLabel.setText(MessageFormat.format(RESULT_LABEL_PATTERN, arenaResult.toString()));
	}


	/**
	 * Handles the {@code Click}-{@link ActionEvent} of the "Continue" {@link Button} in the GUI.
	 * If the user has lost the arena, the user is returned to the city-view, if he has won, then he is returned to the current mission.
	 *
	 * @param ignored The {@link ActionEvent} which represents the action of the {@link Button} press. Not used in this case.
	 *
	 * @precondition The {@link Button} on the GUI gets clicked and JavaFx generates the {@link ActionEvent}.
	 * @postcondition The current {@link Scene} in the main {@link Stage} is set to the {@link Scene} of the {@link CityDelegate} if the user has lost the arena
	 * or set to the {@link Scene} of the {@link MissionDelegate} if the user has won.
	 */
	@FXML
	void onContinue (final ActionEvent ignored)
	{
		// TODO: Behaviour einfügen, siehe JavaDoc
		STAGE.close();
		if (this.arenaResult == ArenaResult.LOST)
		{
			CityDelegate.show();
		}

	}


	/**
	 * Builds a formatted {@link String}, which represents the object, and it's current state using the {@link ArenaFinishedDialogDelegate#TO_STRING_PATTERN}.
	 *
	 * @return A {@link String} which has been formatted in the {@link ArenaFinishedDialogDelegate#TO_STRING_PATTERN}.
	 *
	 * @precondition The {@link ArenaFinishedDialogDelegate#TO_STRING_PATTERN} is {@code != null}.
	 * @postcondition The method returned a {@link String} which represents the object.
	 */
	@Override
	public String toString ()
	{
		return MessageFormat.format(TO_STRING_PATTERN, ARENA_FINISHED_DIALOG_FXML, this.arenaResult);
	}

}
