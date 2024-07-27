package me.vault.game.view;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import me.vault.game.GameApplication;
import me.vault.game.control.EnemyController;
import me.vault.game.control.FigureController;
import me.vault.game.fxcontrols.GameBoardButton;
import me.vault.game.interfaces.Placable;
import me.vault.game.model.arena.*;
import me.vault.game.model.troop.Troop;
import me.vault.game.utility.logging.ILogger;
import me.vault.game.utility.logging.Logger;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.PriorityQueue;

import static me.vault.game.utility.constant.ArenaConstants.*;
import static me.vault.game.utility.constant.LoggingConstants.Arena.ARENA_DISPLAY_FAILED;
import static me.vault.game.utility.logging.ILogger.Level.WARNING;


public class ArenaDelegate
{

	/**
	 * The {@link Logger} object for this class used for writing to the console.
	 */
	private static final ILogger LOGGER = new Logger(ArenaDelegate.class.getSimpleName());

	@FXML
	private GridPane gameBoardGridPane;

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
			arenaDelegate.show(new Scene(root));
		}
		catch (final IOException e)
		{
			LOGGER.logf(WARNING, ARENA_DISPLAY_FAILED, arena.toString());
		}
	}


	private void show (final @NotNull Scene scene)
	{
		ViewUtil.show(GameApplication.getStage(), scene, ArenaDelegate.class);
	}


	@FXML
	void onStartGameClick (final ActionEvent actionEvent)
	{
		final Button sender = (Button) actionEvent.getSource();
		sender.setDisable(true);
		this.gameBoardGridPane.setDisable(false);
		this.executeTurn();
	}


	private void initializeGameBoardGridPane ()
	{
		for (int i = 0; i < ARENA_ROW_COUNT; i++)
		{
			for (int j = 0; j < ARENA_COLUMN_COUNT; j++)
			{
				final Position position = new Position(i, j);
				final GameBoardButton button = new GameBoardButton(this.arena, this.arena.getGameBoard().getTile(position).getCurrentElement());

				button.setOnMouseClicked(_ ->
				{
					this.handleFigureInteraction(position);
				});
				this.gameBoardGridPane.add(button, i, j);
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
			this.timelineVBox.getChildren().add(this.createTimelineElement(Objects.requireNonNull(figurePriorityQueue.poll())));
		}
		this.timelineVBox.setSpacing(TIMELINE_SPACING);
	}


	private void setTroopGlow (final @NotNull Arena arena, final @NotNull ImageView imageView, final @NotNull Figure<? extends Troop> troopFigure)
	{
		if (arena.getPlayerOneTroops().contains(troopFigure))
		{
			final DropShadow playerIdentity = new DropShadow(DROP_SHADOW_RADIUS, Color.BLUE);
			playerIdentity.setSpread(DROP_SHADOW_SPREAD);
			imageView.setEffect(playerIdentity);
		}
		else if (arena.getPlayerTwoTroops().contains(troopFigure))
		{
			final DropShadow playerIdentity = new DropShadow(DROP_SHADOW_RADIUS, Color.RED);
			playerIdentity.setSpread(DROP_SHADOW_SPREAD);
			imageView.setEffect(playerIdentity);
		}
	}


	private void handleFigureInteraction (final @NotNull Position position)
	{
		final Figure<? extends Troop> attacker = this.arena.getSelectedFigure();
		final Placable nextTileElement = this.arena.getGameBoard().getTile(position).getCurrentElement();

		boolean interactionFailed = true;
		if (nextTileElement instanceof Placeholder && FigureController.figureCanMoveToPosition(this.arena, attacker, position))
		{
			FigureController.moveFigure(this.arena, attacker, position);
			interactionFailed = false;
		}
		else if (nextTileElement instanceof final Figure<? extends Troop> defender && FigureController.figureCanAttackFigure(this.arena, attacker, position))
		{
			FigureController.attackFigure(this.arena, attacker, defender);
			interactionFailed = false;
		}
		if (interactionFailed)
		{
			return;
		}
		this.updateTimeline();
		this.gameBoardGridPane.getChildren().clear();
		this.initializeGameBoardGridPane();
		this.executeTurn();
	}


	private void executeTurn ()
	{
		final List<Figure<? extends Troop>> playerTwoTroops = this.arena.getPlayerTwoTroops();

		if (playerTwoTroops.contains(this.arena.getSelectedFigure()))
		{
			this.HandleEnemyTurn();
			this.gameBoardGridPane.getChildren().clear();
			this.initializeGameBoardGridPane();
			this.updateTimeline();
			this.executeTurn();
		}
	}


	private void HandleEnemyTurn ()
	{
		final Position position = this.arena.getGameBoard().getFigurePosition(this.arena.getSelectedFigure());
		final int attackRange = this.arena.getSelectedFigure().getStatistics().getOffensiveStatistic().getGrenadeRange();
		final int movementRange = this.arena.getSelectedFigure().getStatistics().getDexterityStatistic().getMovementTiles();

		final List<Tile> reachableTroopFigureTiles = this.arena.getGameBoard().getReachableTroopFigureTiles(position, attackRange);
		final List<Tile> adjacentAccessibleTiles = this.arena.getGameBoard().getAdjacentAccessibleTiles(position, movementRange);

		boolean hasAttacked = false;
		if (!reachableTroopFigureTiles.isEmpty())
		{
			hasAttacked = EnemyController.attackAdjacentTroop(this.arena, reachableTroopFigureTiles, this.arena.getSelectedFigure());
		}
		if (!adjacentAccessibleTiles.isEmpty() && !hasAttacked)
		{
			FigureController.moveFigure(this.arena, this.arena.getSelectedFigure(), adjacentAccessibleTiles.getFirst());
		}
	}


	private void updateTimeline ()
	{
		this.currentQueue.poll();
		if (this.currentQueue.isEmpty())
		{
			this.currentQueue = new PriorityQueue<>(this.figureTroopTimeline.getPriorityQueue());
			this.incrementRound();
		}

		this.arena.setSelectedFigure(this.currentQueue.peek());
		final PriorityQueue<Figure<? extends Troop>> tempPriorityQueue = new PriorityQueue<>(this.currentQueue);
		this.timelineVBox.getChildren().clear();
		while (!tempPriorityQueue.isEmpty())
		{
			this.timelineVBox.getChildren().add(this.createTimelineElement(Objects.requireNonNull(tempPriorityQueue.poll())));
		}
	}


	private void incrementRound ()
	{
		this.round++;
		this.roundNumber.setText(String.valueOf(this.round));
	}


	private HBox createTimelineElement (final Figure<? extends Troop> troopFigure)
	{
		final HBox container = new HBox();
		final VBox statistics = new VBox();

		statistics.setPrefSize(VBOX_WIDTH, VBOX_HEIGHT);
		final ImageView sprite = new ImageView(troopFigure.getSprite());

		sprite.setFitWidth(SPRITE_WIDTH - IMAGE_OFFSET);
		sprite.setFitHeight(SPRITE_HEIGHT - IMAGE_OFFSET);


		this.setTroopGlow(this.arena, sprite, troopFigure);

		statistics.getChildren().add(new Label(NAME + troopFigure.getName()));
		statistics.getChildren().add(new Label(HEALTH + troopFigure.getStatistics().getDefensiveStatistic().getHealthPoints()));
		statistics.getChildren().add(new Label(ARMOR + troopFigure.getStatistics().getDefensiveStatistic().getArmor()));
		statistics.setSpacing(STATISTICS_SPACING);

		container.getChildren().add(sprite);
		container.getChildren().add(statistics);

		container.setSpacing(H_BOX_OFFSET);

		return container;
	}


	public Arena getArena ()
	{
		return this.arena;
	}


	public void setArena (final @NotNull Arena arena)
	{
		this.arena = arena;
		this.figureTroopTimeline = arena.getTimeline();
		this.currentQueue = arena.getTimeline().getPriorityQueue();
		this.initializeTimelineVbox();
		this.initializeGameBoardGridPane();
		this.gameBoardGridPane.setDisable(true);
	}

}
