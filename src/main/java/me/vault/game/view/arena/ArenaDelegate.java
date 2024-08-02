package me.vault.game.view.arena;


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
import me.vault.game.model.Mission;
import me.vault.game.model.Player;
import me.vault.game.model.arena.Arena;
import me.vault.game.model.arena.ArenaResult;
import me.vault.game.model.arena.Timeline;
import me.vault.game.model.gameboard.Figure;
import me.vault.game.model.gameboard.GameBoard;
import me.vault.game.model.gameboard.tile.Tile;
import me.vault.game.model.gameboard.tile.implementation.AccessibleElement;
import me.vault.game.utility.ViewUtil;
import me.vault.game.utility.exception.ElementNotFoundOnGameBoardException;
import me.vault.game.utility.fx.GameBoardButton;
import me.vault.game.utility.fx.TimelineElementHBox;
import me.vault.game.utility.interfaces.Placeable;
import me.vault.game.utility.logging.ILogger;
import me.vault.game.utility.logging.Logger;
import me.vault.game.utility.math.Position;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.List;
import java.util.Objects;
import java.util.PriorityQueue;

import static me.vault.game.utility.interfaces.constant.ArenaConstants.ARENA_FXML;
import static me.vault.game.utility.interfaces.constant.GameBoardConstants.GAME_BOARD_COLUMN_COUNT;
import static me.vault.game.utility.interfaces.constant.GameBoardConstants.GAME_BOARD_ROW_COUNT;
import static me.vault.game.utility.interfaces.constant.LoggingConstants.ArenaDelegate.ARENA_DISPLAY_FAILED;
import static me.vault.game.utility.logging.ILogger.Level.WARNING;


/**
 * The {@link ArenaDelegate} is responsible for the control (Controller) and display (View) for the encounter. It
 * provides methods to change the appearance of the elements of the arena.
 * The arena automatically gets displayed when the player is next to an encounter tile and interacts with it.
 *
 * @author Vincent Wolf, Lasse-Leander Hillen, Timothy Hoegen-Jupp, Alexander Goethel
 * @version 1.0.0
 * @see Arena
 * @since 25.07.2024
 */
public final class ArenaDelegate
{

	/**
	 * The {@link Logger} object for this class used for writing to the console.
	 */
	private static final ILogger LOGGER = new Logger(ArenaDelegate.class.getSimpleName());

	private static final String TO_STRING_FORMAT = "ArenaDelegate'{'fxml={0}'}'";


	/**
	 * {@link GridPane} on which the game board is displayed.
	 */
	@FXML
	private GridPane arenaBoardGridPane;


	/**
	 * {@link Label} that displays the round number.
	 */
	@FXML
	private Label roundNumber;


	/**
	 * {@link VBox} that displays the timeline elements.
	 *
	 * @see TimelineElementHBox
	 */
	@FXML
	private VBox timelineVBox;


	/**
	 * {@link PriorityQueue} that contains the (still) active {@link Figure}s for the current round
	 */
	private PriorityQueue<Figure> currentQueue = null;

	/**
	 * A {@link Timeline} object that contains the timeline of the arena encounter.
	 */
	private Timeline figureTimeline = null;

	/**
	 * {@link Arena} that is passed into the delegate in the show() method
	 */
	private Arena arena = null;

	/**
	 * Integer that keeps track of round number.
	 */
	private int round = 1;


	/**
	 * {@link Mission} object which contains the arena and is passed into the delegate in the show() method.
	 */
	private Mission mission = null;


	/**
	 * Displays the {@link Arena} instance.
	 *
	 * @param mission The {@link Mission} object, which describes the mission the arena originated from.
	 * @param arena   The {@link Arena} object, which describes the arena.
	 *
	 * @precondition The player moved on an encounter tile, and the arena instance for the encounter is supplied.
	 * @postcondition The arena is displayed for the user.
	 */
	public static void show (final @NotNull Mission mission, final @NotNull Arena arena)
	{
		try
		{
			final FXMLLoader fxmlLoader = new FXMLLoader(ArenaDelegate.class.getResource(ARENA_FXML));
			final Parent root = fxmlLoader.load();
			final ArenaDelegate arenaDelegate = fxmlLoader.getController();
			arenaDelegate.setMission(mission);
			arenaDelegate.setArena(arena);
			ViewUtil.show(GameApplication.getStage(), new Scene(root), ArenaDelegate.class);
		}
		catch (final IOException e)
		{
			LOGGER.logf(WARNING, ARENA_DISPLAY_FAILED, arena.toString());
		}
	}


	/**
	 * Sets the instance of the {@link Mission} object.
	 *
	 * @param mission The new {@link Mission} object, meant to replace the current attribute in the instance.
	 *
	 * @precondition A {@link NotNull} {@link Mission} object is passed into the method.
	 * @postcondition The mission object in the instance has been set.
	 */
	private void setMission (final Mission mission)
	{
		this.mission = mission;
	}


	/**
	 * Handles the {@code Click}-{@link ActionEvent} of the "Start Game" {@link Button} in the GUI.
	 * Starts the arena by enabling the game board and disabling the start game button.
	 *
	 * @param actionEvent The {@link ActionEvent} which represents the action of the {@link Button} press. Not used in this case.
	 *
	 * @precondition The {@link Button} on the GUI gets clicked and JavaFx generates the {@link ActionEvent}.
	 * @postcondition The arena was started by enabling the game board and disabling the start game button.
	 */
	@FXML
	void onStartGameClick (final ActionEvent actionEvent)
	{
		final Button sender = (Button) actionEvent.getSource();
		sender.setDisable(true);
		this.arenaBoardGridPane.setDisable(false);
		this.executeTurn();
	}


	/**
	 * Handles the {@code Click}-{@link ActionEvent} of the "Dodge Ability" {@link Button} in the GUI.
	 * Disables the sending button and returns true
	 *
	 * @param actionEvent The {@link ActionEvent} which represents the action of the {@link Button} press. Not used in this case.
	 *
	 * @precondition The {@link Button} on the GUI gets clicked and JavaFx generates the {@link ActionEvent}.
	 * @postcondition The button was turned off and returned true.
	 */
	@FXML
	boolean onDodgeAbilityClick (final ActionEvent actionEvent)
	{
		final Button sender = (Button) actionEvent.getSource();
		sender.setDisable(true);
		return true;
	}


	/**
	 * Handles the {@code Click}-{@link ActionEvent} of the "Initiative Ability" {@link Button} in the GUI.
	 * Disables the sending button and returns true
	 *
	 * @param actionEvent The {@link ActionEvent} which represents the action of the {@link Button} press. Not used in this case.
	 *
	 * @precondition The {@link Button} on the GUI gets clicked and JavaFx generates the {@link ActionEvent}.
	 * @postcondition The button was turned off and returned true.
	 */
	@FXML
	boolean onInitiativeAbilityClick (final ActionEvent actionEvent)
	{
		final Button sender = (Button) actionEvent.getSource();
		sender.setDisable(true);
		return true;
	}


	/**
	 * Handles the {@code Click}-{@link ActionEvent} of the "Melee Ability" {@link Button} in the GUI.
	 * Disables the sending button and returns true
	 *
	 * @param actionEvent The {@link ActionEvent} which represents the action of the {@link Button} press. Not used in this case.
	 *
	 * @precondition The {@link Button} on the GUI gets clicked and JavaFx generates the {@link ActionEvent}.
	 * @postcondition The button was turned off and returned true.
	 */
	@FXML
	boolean onMeleeAbilityClick (final ActionEvent actionEvent)
	{
		final Button sender = (Button) actionEvent.getSource();
		sender.setDisable(true);
		return true;
	}


	/**
	 * Initializes the GridPane of the arena game board.
	 *
	 * @precondition The method gets called.
	 * @postcondition The GridPane of the arena game board was initialized.
	 */
	private void initializeGameBoardGridPane ()
	{
		for (int i = 0; i < GAME_BOARD_ROW_COUNT; i++)
		{
			for (int j = 0; j < GAME_BOARD_COLUMN_COUNT; j++)
			{
				final Position position = new Position(i, j);
				final GameBoardButton button = new GameBoardButton(this.arena, this.arena.getGameBoard().getTile(position).getCurrentElement());
				button.setOnMouseClicked(_ -> this.handleFigureInteraction(position));
				this.arenaBoardGridPane.add(button, i, j);
			}
		}
	}


	/**
	 * Initializes the VBox of the arena timeline.
	 *
	 * @precondition The method gets called.
	 * @postcondition The VBox of the arena timeline was initialized.
	 */
	private void initializeTimelineVbox ()
	{
		this.timelineVBox.getChildren().clear();
		this.arena.setSelectedFigure(this.currentQueue.peek());
		final PriorityQueue<Figure> figurePriorityQueue = this.figureTimeline.createPriorityQueue();
		while (!figurePriorityQueue.isEmpty())
		{
			this.timelineVBox.getChildren().add(new TimelineElementHBox(this.arena, Objects.requireNonNull(figurePriorityQueue.poll())));
		}
	}


	/**
	 * Is set to each button of the game board grid and is used to determine the user interaction with the position of the button.
	 *
	 * @param position The position of the button in the game board of the arena.
	 *
	 * @precondition The method is called and a valid position of the game board between 0,0 and 11,11 is passed.
	 * @precondition The respective action for the position and the state of the game board was chosen.
	 */
	private void handleFigureInteraction (final @NotNull Position position)
	{
		final GameBoard arenaGameBoard = this.arena.getGameBoard();
		final Figure attacker = this.arena.getSelectedFigure();
		final Placeable nextTileElement = arenaGameBoard.getTile(position).getCurrentElement();

		boolean interactionFailed = true;
		if (nextTileElement instanceof AccessibleElement && FigureController.canMoveToPosition(this.arena, attacker, position))
		{
			MovableController.move(arenaGameBoard, attacker, position);
			interactionFailed = false;
		}
		else if (nextTileElement instanceof final Figure defender && FigureController.canAttackAtPosition(this.arena, attacker, position))
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


	/**
	 * Executes one turn of the game and starts enemy actions.
	 *
	 * @precondition The method gets called.
	 * @postcondition One turn of the game was executed.
	 */
	private void executeTurn ()
	{
		final List<Figure> playerOneTroops = this.arena.getPlayerOneFigures();
		final List<Figure> playerTwoTroops = this.arena.getPlayerTwoFigures();

		final boolean finished = this.checkForFinish();
		if (playerOneTroops.contains(this.arena.getSelectedFigure()) && !finished)
		{
			// irrelevant just for reference
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


	/**
	 * Checks if the arena has finished and what result was returned.
	 *
	 * @return The result of the arena as a {@link ArenaResult}.
	 *
	 * @precondition The method gets called.
	 * @postcondition The result of the arena was returned as a {@link ArenaResult}.
	 */
	private boolean checkForFinish ()
	{
		final ArenaResult arenaResult = this.arena.getResult();
		if (arenaResult == ArenaResult.LOST || arenaResult == ArenaResult.WON)
		{
			ArenaFinishedDialogDelegate.show(this.mission, this.arena);
			return true;
		}
		return false;
	}


	/**
	 * Handles the turn for an enemy troop figure on the arena.
	 *
	 * @precondition The method gets called.
	 * @postcondition The turn of the selected enemy troop was handled.
	 */
	private void handleEnemyTurn ()
	{
		final GameBoard arenaGameBoard = this.arena.getGameBoard();

		try
		{
			final Position position = arenaGameBoard.getPosition(this.arena.getSelectedFigure());
			final int attackRange = this.arena.getSelectedFigure().getStatistics().getOffensive().getGrenadeRange();
			final int movementRange = this.arena.getSelectedFigure().getStatistics().getDexterity().getMovementTiles();

			final List<Tile> reachableTroopFigureTiles = arenaGameBoard.getReachableTiles(position, attackRange);
			final List<Tile> adjacentAccessibleTiles = arenaGameBoard.getAdjacentAccessibleTiles(position, movementRange);

			boolean hasAttacked = false;
			if (!reachableTroopFigureTiles.isEmpty())
			{
				hasAttacked = EnemyController.tryAttackAdjacentTroop(this.arena, reachableTroopFigureTiles, this.arena.getSelectedFigure());
			}
			if (!adjacentAccessibleTiles.isEmpty() && !hasAttacked)
			{
				MovableController.move(arenaGameBoard, this.arena.getSelectedFigure(), adjacentAccessibleTiles.getFirst().getPosition());
			}
		}
		catch (final ElementNotFoundOnGameBoardException e)
		{
			LOGGER.log(WARNING, e.getMessage());
		}
	}


	/**
	 * Updates the timeline of the running arena.
	 *
	 * @precondition The method gets called.
	 * @postcondition The timeline of the arena was updated.
	 */
	private void updateTimeline ()
	{
		// Entfernt die oberste Truppe aus der Queue und f&uuml;llt die Queue ggf. wieder auf
		this.currentQueue.poll();
		if (this.currentQueue.isEmpty())
		{
			this.currentQueue = new PriorityQueue<>(this.figureTimeline.createPriorityQueue());
			this.incrementRound();
		}
		this.currentQueue.removeAll(this.arena.getEliminatedFigures());
		this.arena.setSelectedFigure(this.currentQueue.peek());


		// Aktualisiert die Timeline am rechten Rand des Bildschirms
		final PriorityQueue<Figure> tempPriorityQueue = new PriorityQueue<>(this.currentQueue);
		this.timelineVBox.getChildren().clear();
		while (!tempPriorityQueue.isEmpty())
		{
			this.timelineVBox.getChildren().add(new TimelineElementHBox(this.arena, Objects.requireNonNull(tempPriorityQueue.poll())));
		}
	}


	/**
	 * Increments the round of the arena by increasing the internal counter and the gui.
	 *
	 * @precondition The method gets called.
	 * @postcondition The counter was increasing and the GUI was respectfully upgraded.
	 */
	private void incrementRound ()
	{
		this.round++;
		this.roundNumber.setText(String.valueOf(this.round));
	}


	/**
	 * Gets the {@link Arena} attribute of the instance of this class.
	 *
	 * @return The {@link Arena} attribute as a {@link Arena} object.
	 *
	 * @precondition The {@link Arena} attribute has already been set in the instance of this class.
	 * @postcondition The method returned the {@link Arena} attribute.
	 */
	public Arena getArena ()
	{
		return this.arena;
	}


	/**
	 * Sets the {@link Arena} object in an instance of this class to the passed {@link Arena} object.
	 *
	 * @param arena The new {@link Arena} object, meant to replace the current one in the instance.
	 *
	 * @precondition A {@link NotNull} {@link Arena} object is passed into the method.
	 * @postcondition The old {@link Arena} instance was replaced with the supplied one.
	 */
	public void setArena (final @NotNull Arena arena)
	{
		arena.setPlayerOneFigures(Player.getInstance().getSelectedFigures());
		arena.placePlayerOneFiguresRandomly();
		arena.placePlayerTwoFiguresRandomly();

		this.arena = arena;
		this.figureTimeline = arena.getTimeline();
		this.currentQueue = arena.getTimeline().createPriorityQueue();
		this.initializeTimelineVbox();
		this.initializeGameBoardGridPane();
		this.arenaBoardGridPane.setDisable(true);
	}


	/**
	 * Builds a formatted {@link String}, which represents the object, and it's current state using the {@link ArenaDelegate#TO_STRING_FORMAT}.
	 *
	 * @return A {@link String} which has been formatted in the {@link ArenaDelegate#TO_STRING_FORMAT}.
	 *
	 * @precondition The {@link ArenaDelegate#TO_STRING_FORMAT} is {@code != null}.
	 * @postcondition The method returned a {@link String} which represents the object.
	 */
	@Override
	public String toString ()
	{
		return MessageFormat.format(TO_STRING_FORMAT, ARENA_FXML);
	}

}
