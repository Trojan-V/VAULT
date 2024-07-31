package me.vault.game.view.mission;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DialogPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import me.vault.game.model.Mission;
import me.vault.game.model.arena.Arena;
import me.vault.game.utility.fx.RewardGridPane;
import me.vault.game.utility.interfaces.constant.GameConstants;
import me.vault.game.utility.interfaces.constant.LoggingConstants;
import me.vault.game.utility.interfaces.constant.MissionConstants;
import me.vault.game.utility.loading.ResourceLoader;
import me.vault.game.utility.logging.ILogger;
import me.vault.game.utility.logging.Logger;
import me.vault.game.view.city.CityDelegate;
import me.vault.game.view.city.CurrencyDelegate;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.text.MessageFormat;

import static me.vault.game.utility.interfaces.constant.LoggingConstants.DISPLAY_FAILED_PATTERN;
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
public final class MissionFinishedDialogDelegate
{

	/**
	 * The {@link Logger} object for this class used for writing to the console.
	 */
	private static final ILogger LOGGER = new Logger(MissionFinishedDialogDelegate.class.getSimpleName());

	/**
	 * The path to the respective fxml file of the delegate as a {@link String}.
	 */
	private static final String ARENA_FINISHED_DIALOG_FXML = "mission_finished_dialog.fxml";

	/**
	 * The {@link MessageFormat} pattern, which is used, when the {@link MissionFinishedDialogDelegate#toString()} is called.
	 */
	private static final String TO_STRING_PATTERN = "MissionFinishedDialogDelegate'{'fxml={0}, mission={1}'}'";

	/**
	 * The name of the window handle, which is added to the {@link MissionFinishedDialogDelegate#STAGE} in the static initializer as a {@link String}.
	 */
	private static final String WINDOW_TITLE = "Mission complete!";

	/**
	 * The {@link Stage} of the {@link MissionFinishedDialogDelegate}, which is necessary because the {@link DialogPane} needs to be shown on a new window.
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
	 * The {@link Mission} of the Dialog, which is necessary to return the user into the Mission after the dialog is shown.
	 */
	private Mission mission = null;

	/**
	 * The {@link AnchorPane} of the {@link DialogPane} which contains the rewards of the mission.
	 */
	@FXML
	private AnchorPane rewardPane;


	/**
	 * Displays the a {@link DialogPane} based on the finished {@link Mission} instance on a new {@link Stage}.
	 *
	 * @param mission The {@link Mission} object, which describes the mission the arena originated from.
	 *
	 * @precondition A {@link Mission} object is passed into the method.
	 * @postcondition The {@link DialogPane} is displayed on a new {@link Stage}.
	 */
	public static void show (final Mission mission)
	{
		try
		{
			final FXMLLoader fxmlLoader = new FXMLLoader(MissionFinishedDialogDelegate.class.getResource(ARENA_FINISHED_DIALOG_FXML));
			final Parent root = fxmlLoader.load();

			final MissionFinishedDialogDelegate dialogDelegate = fxmlLoader.getController();
			dialogDelegate.setMission(mission);
			STAGE.setScene(new Scene(root));
			STAGE.showAndWait();
		}
		catch (final IOException e)
		{
			LOGGER.logf(ERROR, DISPLAY_FAILED_PATTERN, MissionFinishedDialogDelegate.class.getSimpleName());
		}
	}


	/**
	 * Sets the {@link MissionFinishedDialogDelegate#mission} attribute in the instance of to the passed {@link Mission} object.
	 *
	 * @param mission The new {@link Mission} object, meant to replace the current attribute in the instance.
	 *
	 * @precondition A {@link NotNull} {@link Mission} object is passed into the method.
	 * @postcondition The replaced the old {@link MissionFinishedDialogDelegate#mission} attribute with the passed one.
	 */
	private void setMission (final Mission mission)
	{
		this.mission = mission;
		this.rewardPane.getChildren().add(new RewardGridPane(this.mission.getMissionReward()));
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
		STAGE.close();
		CurrencyDelegate.factorCurrency(this.mission.getMissionReward());
	}


	/**
	 * Builds a formatted {@link String}, which represents the object, and it's current state using the {@link MissionFinishedDialogDelegate#TO_STRING_PATTERN}.
	 *
	 * @return A {@link String} which has been formatted in the {@link MissionFinishedDialogDelegate#TO_STRING_PATTERN}.
	 *
	 * @precondition The {@link MissionFinishedDialogDelegate#TO_STRING_PATTERN} is {@code != null}.
	 * @postcondition The method returned a {@link String} which represents the object.
	 */
	@Override
	public String toString ()
	{
		return MessageFormat.format(TO_STRING_PATTERN, ARENA_FINISHED_DIALOG_FXML, this.mission);
	}

}
