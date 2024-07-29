package me.vault.game.view.mission;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import me.vault.game.GameApplication;
import me.vault.game.control.FigureController;
import me.vault.game.fxcontrols.GameBoardButton;
import me.vault.game.interfaces.Placeable;
import me.vault.game.model.arena.AccessibleTileAppearance;
import me.vault.game.model.arena.ArenaStartTileAppearance;
import me.vault.game.model.arena.GameBoard;
import me.vault.game.model.arena.Position;
import me.vault.game.model.mission.Mission;
import me.vault.game.model.player.Player;
import me.vault.game.utility.loading.ResourceLoader;
import me.vault.game.view.ArenaDelegate;
import me.vault.game.view.ViewUtil;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static me.vault.game.utility.constant.GameBoardConstants.GAME_BOARD_COLUMN_COUNT;
import static me.vault.game.utility.constant.GameBoardConstants.GAME_BOARD_ROW_COUNT;


/**
 * Description
 *
 * @author Vincent Wolf
 * @version 1.0.0
 * @see
 * @since 25.07.2024
 */
public class MissionMapDelegate implements Initializable
{
	private static final String MISSION_MAP_VIEW_FXML = "mission_map_view.fxml";


	private static final Scene MISSION_MAP_SCENE =
		ResourceLoader.loadScene(MissionMapDelegate.class, MISSION_MAP_VIEW_FXML);


	@FXML
	private GridPane missionBoardGridPane;


	private Mission mission;


	public static void show (final @NotNull Mission mission)
	{
		try
		{
			final FXMLLoader fxmlLoader = new FXMLLoader(MissionMapDelegate.class.getResource(MISSION_MAP_VIEW_FXML));
			final Parent root = fxmlLoader.load();
			final MissionMapDelegate missionMapDelegate = fxmlLoader.getController();

			missionMapDelegate.setMission(mission);
			missionMapDelegate.show(new Scene(root));
		}
		catch (final IOException e)
		{
			// TODO: add logger
			//			LOGGER.logf(WARNING, ARENA_DISPLAY_FAILED, arena.toString());
		}
	}


	private void show (final @NotNull Scene scene)
	{
		ViewUtil.show(GameApplication.getStage(), scene, MissionMapDelegate.class);
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public void initialize (final URL location, final ResourceBundle resources)
	{
		this.missionBoardGridPane.setDisable(true);
	}


	@FXML
	void onStartGameClick (final ActionEvent event)
	{
		final Button sender = (Button) event.getSource();
		sender.setDisable(true);
		this.missionBoardGridPane.setDisable(false);
	}


	public void setMission (final @NotNull Mission mission)
	{
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
				final GameBoardButton
					button = new GameBoardButton(this.mission.getGameBoard().getTile(position).getCurrentElement());

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

		if (nextTileElement instanceof AccessibleTileAppearance && playerCanMove)
		{
			FigureController.move(missionGameBoard, player, position);
		}
		else if (nextTileElement instanceof ArenaStartTileAppearance && playerCanReach)
		{
			ArenaDelegate.show(this.mission.getAvailableArenaEncounters().removeFirst());
		}


		this.missionBoardGridPane.getChildren().clear();
		this.initializeGameBoardGridPane();
	}
}
