package me.vault.game.view.mission;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import me.vault.game.GameApplication;
import me.vault.game.control.FigureController;
import me.vault.game.fxcontrols.GameBoardButton;
import me.vault.game.interfaces.Placeable;
import me.vault.game.model.arena.ArenaStartTileAppearance;
import me.vault.game.model.arena.GameBoard;
import me.vault.game.model.arena.PlaceholderTileAppearance;
import me.vault.game.model.arena.Position;
import me.vault.game.model.mission.Mission;
import me.vault.game.model.player.Player;
import me.vault.game.utility.logging.ILogger;
import me.vault.game.utility.logging.Logger;
import me.vault.game.view.ArenaDelegate;
import me.vault.game.view.ViewUtil;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.net.URL;
import java.text.MessageFormat;
import java.util.ResourceBundle;

import static me.vault.game.utility.constant.GameBoardConstants.GAME_BOARD_COLUMN_COUNT;
import static me.vault.game.utility.constant.GameBoardConstants.GAME_BOARD_ROW_COUNT;
import static me.vault.game.utility.constant.LoggingConstants.MissionDelegate.MISSION_DISPLAY_FAILED;
import static me.vault.game.utility.logging.ILogger.Level.WARNING;


/**
 * The {@link MissionDelegate} is responsive for the control (Controller) and display (View) of the different {@link Mission} instances. It provides
 * methods to create the mission game board, alter {@code Mission} instances and allows the player to move and progress in the different missions.
 *
 * @author Vincent Wolf, Lasse-Leander Hillen, Timothy Hoegen-Jupp, Alexander Goethel
 * @see Mission
 * @see me.vault.game.utility.constant.MissionConstants
 * @see me.vault.game.utility.constant.LoggingConstants.MissionDelegate
 * @since 25.07.2024
 */
public class MissionDelegate implements Initializable
{
	/**
	 * The {@link GridPane}, which contains the game board of the mission. It contains all the clickable tiles in the map.
	 */
	@FXML
	private GridPane missionBoardGridPane;

	/**
	 * The {@link Logger} object for this class used for writing to the console.
	 */
	private static final ILogger LOGGER = new Logger(MissionDelegate.class.getSimpleName());

	/**
	 * The path to the respective fxml file of the delegate as a {@link String}.
	 */
	private static final String MISSION_MAP_VIEW_FXML = "mission_map_view.fxml";

	/**
	 * The {@link MessageFormat} pattern, which is used, when the {@link MissionDelegate#toString()} is called.
	 */
	private static final String TO_STRING_PATTERN = "MissionMapDelegate'{'missionBoardGridPane={0}, mission={1}'}'";

	/**
	 * The {@link Mission} object, which is handled by the controller. Gets injected into the controller, when the
	 * {@link MissionDelegate#show(Mission)} method gets called.
	 */
	private Mission mission = null;


	/**
	 * Displays the passed {@link Mission} instance on the main {@link Stage} of the application.
	 *
	 * @param mission The {@code Mission} object, which is meant to be displayed on the main {@code Stage}
	 *
	 * @precondition A {@link NotNull} {@code Mission} object is passed into the method.
	 * @postcondition The main {@code Stage} displays the view of the passed method.
	 */
	public static void show (final @NotNull Mission mission)
	{
		try
		{
			final FXMLLoader fxmlLoader = new FXMLLoader(MissionDelegate.class.getResource(MISSION_MAP_VIEW_FXML));
			final Parent root = fxmlLoader.load();
			final MissionDelegate missionDelegate = fxmlLoader.getController();
			missionDelegate.setMission(mission);
			ViewUtil.show(GameApplication.getStage(), new Scene(root), MissionDelegate.class);
		}
		catch (final IOException e)
		{
			LOGGER.logf(WARNING, MISSION_DISPLAY_FAILED, mission.toString());
		}
	}


	/**
	 * Initializes the fxml-view and sets program-specific bindings and properties. Gets called internally by JavaFX.
	 *
	 * @param location  The {@link URL} object, which acts like a pointer to the ressource of the fxml-file.
	 * @param resources A {@link ResourceBundle} object, which contains locale-specific objects.
	 *
	 * @precondition The passed parameters contain all relevant information needed to initialize the fxml-view.
	 * @postcondition The fxml-view gets initialized and the procedure within the method is run at initialization.
	 */
	@Override
	public void initialize (final URL location, final ResourceBundle resources)
	{
		this.missionBoardGridPane.setDisable(true);
	}


	/**
	 * Handles the {@code Click}-{@link ActionEvent} of the "Start Mission" {@link Button} in the GUI. Disables the sending {@code Button} and
	 * enables
	 * the game board {@link GridPane} so that the user can start playing.
	 *
	 * @param event The {@code ActionEvent} which represents the action of the {@code Button} press.
	 *
	 * @precondition The {@code Button} on the GUI gets clicked and JavaFx generates the {@code ActionEvent}.
	 * @postcondition The sending {@code Button} disables and the game board {@code GridPane} enables in the GUI.
	 */
	@FXML
	void onStartGameClick (final ActionEvent event)
	{
		// When the button (sender) gets clicked, he disables and the grid pane enables
		final Button sender = (Button) event.getSource();
		sender.setDisable(true);
		this.missionBoardGridPane.setDisable(false);
	}


	/**
	 * @param mission
	 */
	public void setMission (final @NotNull Mission mission)
	{
		// Sets the mission of the controller class and initializes the grid pane once.
		this.mission = mission;
		this.initializeGameBoardGridPane();
		this.missionBoardGridPane.setDisable(true);
	}


	private void initializeGameBoardGridPane ()
	{
		for (int row = 0; row < GAME_BOARD_ROW_COUNT; row++)
		{
			for (int column = 0; column < GAME_BOARD_COLUMN_COUNT; column++)
			{
				final Position position = new Position(column, row);
				final GameBoardButton button = new GameBoardButton(this.mission.getGameBoard().getTile(position).getCurrentElement());

				button.setOnMouseClicked(_ -> this.handleFigureInteraction(position));
				this.missionBoardGridPane.add(button, column, row);
			}
		}
	}


	private void handleFigureInteraction (final @NotNull Position position)
	{
		final GameBoard missionGameBoard = this.mission.getGameBoard();
		final Player player = Player.getInstance();

		// the clicked element
		final Placeable nextTileElement = missionGameBoard.getTile(position).getCurrentElement();

		final boolean playerCanMove = FigureController.playerCanMoveToPosition(missionGameBoard, player, position);
		final boolean playerCanReach = FigureController.playerCanReachPosition(missionGameBoard, player, position);

		if (nextTileElement instanceof PlaceholderTileAppearance && playerCanMove)
		{
			FigureController.movePlayer(missionGameBoard, player, position);
		}
		else if (nextTileElement instanceof ArenaStartTileAppearance && playerCanReach)
		{
			ArenaDelegate.show(this.mission.getAvailableArenaEncounters().removeFirst());
		}

		this.missionBoardGridPane.getChildren().clear();
		this.initializeGameBoardGridPane();
	}


	@Override
	public String toString ()
	{
		return MessageFormat.format(TO_STRING_PATTERN, this.missionBoardGridPane, this.mission);
	}
}
