package me.vault.game.view;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import me.vault.game.GameApplication;
import me.vault.game.control.EnemyController;
import me.vault.game.control.FigureController;
import me.vault.game.control.MovableController;
import me.vault.game.interfaces.Placeable;
import me.vault.game.model.arena.*;
import me.vault.game.model.gameboard.GameBoard;
import me.vault.game.model.gameboard.tiles.AccessibleTileAppearance;
import me.vault.game.model.player.Player;
import me.vault.game.model.troop.Troop;
import me.vault.game.utility.fx.GameBoardButton;
import me.vault.game.utility.fx.TimelineElementHBox;
import me.vault.game.utility.logging.ILogger;
import me.vault.game.utility.logging.Logger;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.PriorityQueue;

import static me.vault.game.utility.constant.ArenaConstants.ARENA_FXML;
import static me.vault.game.utility.constant.ArenaConstants.TIMELINE_SPACING;
import static me.vault.game.utility.constant.GameBoardConstants.GAME_BOARD_COLUMN_COUNT;
import static me.vault.game.utility.constant.GameBoardConstants.GAME_BOARD_ROW_COUNT;
import static me.vault.game.utility.constant.LoggingConstants.ArenaDelegate.ARENA_DISPLAY_FAILED;
import static me.vault.game.utility.logging.ILogger.Level.WARNING;


public final class ArenaDelegate
{

	/**
	 * The {@link Logger} object for this class used for writing to the console.
	 */
	private static final ILogger LOGGER = new Logger(ArenaDelegate.class.getSimpleName());

	@FXML
	private GridPane arenaBoardGridPane;

	@FXML
	private Label roundNumber;

	@FXML
	private VBox timelineVBox;

	private PriorityQueue<Figure<? extends Troop>> currentQueue = null;

	private TroopTimeline figureTroopTimeline = null;

	private Arena arena = null;

	private int round = 1;


	public static void show (final @NotNull Arena arena)
	{
		try
		{
			final FXMLLoader fxmlLoader = new FXMLLoader(ArenaDelegate.class.getResource(ARENA_FXML));
			final Parent root = fxmlLoader.load();
			final ArenaDelegate arenaDelegate = fxmlLoader.getController();

			arenaDelegate.setArena(arena);
			ViewUtil.show(GameApplication.getStage(), new Scene(root), ArenaDelegate.class);
		}
		catch (final IOException e)
		{
			LOGGER.logf(WARNING, ARENA_DISPLAY_FAILED, arena.toString());
		}
	}


	@FXML
	void onStartGameClick (final ActionEvent actionEvent)
	{
		final Button sender = (Button) actionEvent.getSource();
		sender.setDisable(true);
		this.arenaBoardGridPane.setDisable(false);
		this.executeTurn();
	}


	private void initializeGameBoardGridPane ()
	{
		for (int i = 0; i < GAME_BOARD_ROW_COUNT; i++)
		{
			for (int j = 0; j < GAME_BOARD_COLUMN_COUNT; j++)
			{
				final Position position = new Position(i, j);
				final GameBoardButton button = new GameBoardButton(this.arena, this.arena.getGameBoard().getTile(position).getCurrentElement());
				button.setOnMouseClicked(_ ->
				{
					this.handleFigureInteraction(position);
				});
				this.arenaBoardGridPane.add(button, i, j);
			}
		}
	}


	private void initializeTimelineVbox ()
	{
		this.timelineVBox.getChildren().clear();
		this.arena.setSelectedFigure(this.currentQueue.peek());
		final PriorityQueue<Figure<? extends Troop>> figurePriorityQueue = this.figureTroopTimeline.getPriorityQueue();
		while (!figurePriorityQueue.isEmpty())
		{
			this.timelineVBox.getChildren().add(new TimelineElementHBox(this.arena, Objects.requireNonNull(figurePriorityQueue.poll())));
		}
		this.timelineVBox.setSpacing(TIMELINE_SPACING);
	}


	private void handleFigureInteraction (final @NotNull Position position)
	{
		final GameBoard arenaGameBoard = this.arena.getGameBoard();
		final Figure<? extends Troop> attacker = this.arena.getSelectedFigure();
		final Placeable nextTileElement = arenaGameBoard.getTile(position).getCurrentElement();

		boolean interactionFailed = true;
		if (nextTileElement instanceof AccessibleTileAppearance &&
		    FigureController.canMoveToPosition(this.arena, attacker, position))
		{
			MovableController.move(arenaGameBoard, attacker, position);
			interactionFailed = false;
		}
		else if (nextTileElement instanceof final Figure<? extends Troop> defender &&
		         FigureController.canAttackAtPosition(this.arena, attacker, position))
		{
			FigureController.attack(this.arena, attacker, defender);
			interactionFailed = false;
		}
		if (interactionFailed)
		{
			return;
		}

		this.updateTimeline();
		this.arenaBoardGridPane.getChildren().clear();
		this.initializeGameBoardGridPane();
		this.executeTurn();
	}


	private void executeTurn ()
	{
		final List<Figure<? extends Troop>> playerOneTroops = this.arena.getPlayerOneTroops();
		final List<Figure<? extends Troop>> playerTwoTroops = this.arena.getPlayerTwoTroops();

		final boolean finished = this.checkForFinish();
		if (playerOneTroops.contains(this.arena.getSelectedFigure()) && !finished)
		{
			return;
		}
		else if (playerTwoTroops.contains(this.arena.getSelectedFigure()) && !finished)
		{
			this.handleEnemyTurn();
			this.arenaBoardGridPane.getChildren().clear();
			this.initializeGameBoardGridPane();
			this.updateTimeline();

			this.executeTurn();
		}
	}


	private boolean checkForFinish ()
	{
		final ArenaResult arenaResult = this.arena.getState();
		if (arenaResult == ArenaResult.LOST || arenaResult == ArenaResult.WON)
		{
			ArenaFinishedDialogDelegate.show(this.arena.getState());
			return true;
		}
		return false;
	}


	private void handleEnemyTurn ()
	{
		final GameBoard arenaGameBoard = this.arena.getGameBoard();

		final Position position = arenaGameBoard.getPosition(this.arena.getSelectedFigure());
		final int attackRange = this.arena.getSelectedFigure().getStatistics().getOffensive().getGrenadeRange();
		final int movementRange = this.arena.getSelectedFigure().getStatistics().getDexterity().getMovementTiles();

		final List<Tile> reachableTroopFigureTiles = arenaGameBoard.getReachableTroopFigureTiles(position, attackRange);
		final List<Tile> adjacentAccessibleTiles = arenaGameBoard.getAdjacentAccessibleTiles(position, movementRange);

		boolean hasAttacked = false;
		if (!reachableTroopFigureTiles.isEmpty())
		{
			hasAttacked = EnemyController.attackAdjacentTroop(this.arena, reachableTroopFigureTiles, this.arena.getSelectedFigure());
		}
		if (!adjacentAccessibleTiles.isEmpty() && !hasAttacked)
		{
			MovableController.move(arenaGameBoard, this.arena.getSelectedFigure(), adjacentAccessibleTiles.getFirst()
				.getPosition());
		}
	}


	private void updateTimeline ()
	{
		// Entfernt die oberste Truppe aus der Queue und f&uuml;llt die Queue ggf. wieder auf
		this.currentQueue.poll();
		if (this.currentQueue.isEmpty())
		{
			this.currentQueue = new PriorityQueue<>(this.figureTroopTimeline.getPriorityQueue());
			this.incrementRound();
		}
		this.currentQueue.removeAll(this.arena.getEliminatedFigures());
		this.arena.setSelectedFigure(this.currentQueue.peek());


		// Aktualisiert die TimeLine am rechten Rand des Bildschirms
		final PriorityQueue<Figure<? extends Troop>> tempPriorityQueue = new PriorityQueue<>(this.currentQueue);
		this.timelineVBox.getChildren().clear();
		while (!tempPriorityQueue.isEmpty())
		{
			this.timelineVBox.getChildren().add(new TimelineElementHBox(this.arena, Objects.requireNonNull(tempPriorityQueue.poll())));
		}
	}


	private void incrementRound ()
	{
		this.round++;
		this.roundNumber.setText(String.valueOf(this.round));
	}


	public Arena getArena ()
	{
		return this.arena;
	}


	public void setArena (final @NotNull Arena arena)
	{
		arena.setPlayerOneTroops(Player.getInstance().getSelectedTroops());

		this.arena = arena;
		this.figureTroopTimeline = arena.getTimeline();
		this.currentQueue = arena.getTimeline().getPriorityQueue();
		this.initializeTimelineVbox();
		this.initializeGameBoardGridPane();
		this.arenaBoardGridPane.setDisable(true);
	}

}
