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
import me.vault.game.fxcontrols.GameBoardButton;
import me.vault.game.model.arena.Position;
import me.vault.game.model.mission.Mission;
import me.vault.game.utility.loading.ResourceLoader;
import me.vault.game.view.ViewUtil;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static me.vault.game.utility.constant.ArenaConstants.GAME_BOARD_COLUMN_COUNT;
import static me.vault.game.utility.constant.ArenaConstants.GAME_BOARD_ROW_COUNT;


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
	private GridPane gameBoardGridPane;


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
		this.gameBoardGridPane.setDisable(true);
	}


	@FXML
	void onStartGameClick (final ActionEvent event)
	{
		final Button sender = (Button) event.getSource();
		sender.setDisable(true);
		this.gameBoardGridPane.setDisable(false);
	}


	public void setMission (final @NotNull Mission mission)
	{
		this.mission = mission;
		this.initializeGameBoardGridPane();
		this.gameBoardGridPane.setDisable(true);
	}


	private void initializeGameBoardGridPane ()
	{
		for (int i = 0; i < GAME_BOARD_ROW_COUNT; i++)
		{
			for (int j = 0; j < GAME_BOARD_COLUMN_COUNT; j++)
			{
				final Position position = new Position(i, j);
				final GameBoardButton
					button = new GameBoardButton(this.mission.getGameBoard().getTile(position).getCurrentElement());

				button.setOnMouseClicked(_ -> this.handleFigureInteraction(position));
				this.gameBoardGridPane.add(button, i, j);
			}
		}
	}


	private void handleFigureInteraction (final @NotNull Position position)
	{
		//		final Placeable nextTileElement = this.mission.getGameBoard().getTile(position).getCurrentElement();
		//
		//		boolean interactionFailed = true;
		//		if (nextTileElement instanceof Placeholder && FigureController.figureCanMoveToPosition(this.mission,
		//		attacker,
		//			position))
		//		{
		//			FigureController.moveFigure(this.arena, attacker, position);
		//			interactionFailed = false;
		//		}
		//
		//
		//
		//		if (interactionFailed)
		//		{
		//			return;
		//		}
		//		this.gameBoardGridPane.getChildren().clear();
		//		this.initializeGameBoardGridPane();
	}
}
