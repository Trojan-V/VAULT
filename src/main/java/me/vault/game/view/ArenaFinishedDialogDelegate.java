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
import me.vault.game.exception.UndefinedArenaResultException;
import me.vault.game.model.arena.Arena;
import me.vault.game.model.arena.ArenaResult;
import me.vault.game.model.mission.Mission;
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

import static me.vault.game.utility.constant.LoggingConstants.DISPLAY_FAILED_PATTERN;
import static me.vault.game.utility.logging.ILogger.Level.ERROR;


/**
 * The {@link MissionSelectionDelegate} is responsible for the control (Controller) and display (View) of the dialog after an arena ends.
 * It provides methods to change the appearance of the {@link DialogPane} and thereby is able to notify the GUI user of the arena-result.
 * The dialog automatically gets displayed when an arena ends.
 *
 * @author Vincent Wolf, Lasse-Leander Hillen, Timothy Hoegen-Jupp, Alexander Goethel
 * @version 1.0.0
 * @see Arena
 * @see Arena
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
	 * The {@link Arena} of the Dialog, which is modified by the {@link MissionDelegate} to display the right result in the {@link ArenaFinishedDialogDelegate#resultLabel}.
	 */
	private Arena arena = null;

	/**
	 * The {@link Mission} of the Dialog, which is needed to return the user into the Mission after the dialog is shown.
	 */
	private Mission mission = null;


	/**
	 * Displays the a {@link DialogPane} based on the {@link Arena} instance on a new {@link Stage}.
	 *
	 * @param mission The {@link Mission} object, which describes the mission the arena originated from.
	 * @param arena   The {@link Arena} object, which describes the arena and its result, that displayed this {@link DialogPane}.
	 *
	 * @precondition A {@link Arena} object is passed into the method.
	 * @postcondition The {@link DialogPane} is displayed on a new {@link Stage}.
	 */
	public static void show (final Mission mission, final Arena arena)
	{
		try
		{
			final FXMLLoader fxmlLoader = new FXMLLoader(UpgradeDialogDelegate.class.getResource(ARENA_FINISHED_DIALOG_FXML));
			final Parent root = fxmlLoader.load();

			final ArenaFinishedDialogDelegate dialogDelegate = fxmlLoader.getController();
			dialogDelegate.setArena(arena);
			dialogDelegate.setMission(mission);
			STAGE.setScene(new Scene(root));
			STAGE.showAndWait();
		}
		catch (final IOException e)
		{
			LOGGER.logf(ERROR, DISPLAY_FAILED_PATTERN, ArenaFinishedDialogDelegate.class.getSimpleName());
		}
	}


	/**
	 * Sets the {@link ArenaFinishedDialogDelegate#mission} attribute in the instance of  to the passed {@link Mission} object.
	 *
	 * @param mission The new {@link Mission} object, meant to replace the current attribute in the instance.
	 *
	 * @precondition A {@link NotNull} {@link Mission} object is passed into the method.
	 * @postcondition The  replaced the old {@link ArenaFinishedDialogDelegate#arena} attribute with the passed one.
	 * The text of the {@link ArenaFinishedDialogDelegate#resultLabel} was replaced with a version of the {@link Mission} object.
	 */
	private void setMission (final Mission mission)
	{
		this.mission = mission;
	}


	/**
	 * Gets the {@link ArenaFinishedDialogDelegate#arena} attribute of the instance of .
	 *
	 * @return The {@link ArenaFinishedDialogDelegate#arena} attribute as a {@link Arena} object.
	 *
	 * @precondition The {@link ArenaFinishedDialogDelegate#arena} attribute has already been set in the .
	 * @postcondition The method returned the {@link Arena} attribute.
	 */
	public Arena getState ()
	{
		return this.arena;
	}


	/**
	 * Sets the {@link ArenaFinishedDialogDelegate#arena} attribute in the instance of  to the passed {@link Arena} object.
	 * Sets the text of the {@link ArenaFinishedDialogDelegate#resultLabel} to a formatted version of the passed {@link Arena} object.
	 *
	 * @param arena The new {@link Arena} object, meant to replace the current attribute in the instance.
	 *
	 * @precondition A {@link NotNull} {@link Arena} object is passed into the method.
	 * @postcondition The  replaced the old {@link ArenaFinishedDialogDelegate#arena} attribute with the passed one.
	 * The text of the {@link ArenaFinishedDialogDelegate#resultLabel} was replaced with a version of the {@link Arena} object.
	 */
	private void setArena (final @NotNull Arena arena)
	{
		this.arena = arena;
		this.resultLabel.setText(MessageFormat.format(RESULT_LABEL_PATTERN, this.arena.toString()));
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
	void onContinue (final ActionEvent ignored) throws UndefinedArenaResultException
	{
		STAGE.close();
		if (this.arena.getResult() == ArenaResult.LOST)
		{
			CityDelegate.show();
		}
		else if (this.arena.getResult() == ArenaResult.WON)
		{
			MissionDelegate.show(this.mission);
		}
		else
		{
			throw new UndefinedArenaResultException();
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
		return MessageFormat.format(TO_STRING_PATTERN, ARENA_FINISHED_DIALOG_FXML, this.arena);
	}

}
