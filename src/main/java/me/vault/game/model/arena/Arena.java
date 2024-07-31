package me.vault.game.model.arena;


import me.vault.game.model.Player;
import me.vault.game.model.gameboard.Figure;
import me.vault.game.model.gameboard.GameBoard;
import me.vault.game.model.gameboard.tile.implementation.AccessibleElement;
import me.vault.game.utility.exception.ElementNotFoundOnGameBoardException;
import me.vault.game.utility.fx.TimelineElementHBox;
import me.vault.game.utility.interfaces.SerializableJSON;
import me.vault.game.utility.interfaces.constant.ArenaConstants;
import me.vault.game.utility.interfaces.constant.MiscConstants;
import me.vault.game.utility.loading.ResourceLoader;
import me.vault.game.utility.logging.ILogger;
import me.vault.game.utility.logging.Logger;
import me.vault.game.utility.math.Position;

import java.text.MessageFormat;
import java.util.*;
import java.util.random.RandomGenerator;

import static me.vault.game.utility.interfaces.constant.ArenaConstants.ENEMY_UNIT_TILE_OFFSET;
import static me.vault.game.utility.interfaces.constant.GameBoardConstants.GAME_BOARD_MAXIMUM_INDEX;
import static me.vault.game.utility.logging.ILogger.Level.WARNING;


/**
 * This class is the model for the arena where the encounters take place.
 *
 * @author Vincent Wolf, Lasse-Leander Hillen, Timothy Hoegen-Jupp, Alexander Goethel
 * @version 1.0.0
 * @see GameBoard
 * @see Figure
 * @since 30.07.2024
 */
public class Arena implements SerializableJSON
{

	/**
	 * The {@link Logger} object for this class used for writing to the console.
	 */
	private static final ILogger LOGGER = new Logger(Arena.class.getSimpleName());

	/**
	 * The {@link MessageFormat} pattern, which is used, when the {@link Arena#toString()} is
	 * called.
	 */
	private static final String TO_STRING_PATTERN =
		"Arena'{'gameBoard={0}, playerTwoFigures={1}, eliminatedFigures={2}, arenaResult={3}, troopTimeline={4}, " + "playerOneFigures={5}, selectedFigure={6}'}'";


	/**
	 * The {@link GameBoard} is the place where the {@link Figure}s are deployed and can be moved/attack.
	 * <br>
	 * It's the model for the "field".
	 */
	private final GameBoard gameBoard;


	/**
	 * A {@link List} of all figures that belong to player two.
	 * <br>
	 * In Singleplayer, this is the computer player one fights against.
	 */
	private final List<Figure> playerTwoFigures;


	/**
	 * A {@link List} of all figures that have been eliminated.
	 */
	private final List<Figure> eliminatedFigures = new ArrayList<>();


	/**
	 * The result of the encounter.
	 * Determines if the encounter was won or lost.
	 * <br>
	 * As long as the arena fight isn't finished, the {@link ArenaResult} is undefined.
	 */
	private ArenaResult result = ArenaResult.UNDEFINED;


	/**
	 * This is the internal data structure that handles the troop timeline.
	 * It doesn't correspond to the GUI element.
	 * <br>
	 * The timeline contains all {@link Figure}s that are currently on the {@link GameBoard} and determines which
	 * {@link Figure} is allowed to make the next move.
	 * <br>
	 * For the GUI element, check {@link TimelineElementHBox}.
	 */
	private Timeline timeline = null;


	/**
	 * A {@link List} of all figures that belong to player one.
	 * <br>
	 * In Singleplayer, this is the player who plays the game.
	 */
	private List<Figure> playerOneFigures;


	/**
	 * The figure which is currently selected, which corresponds to the top element in the timeline.
	 */
	private Figure selectedFigure = null;


	/**
	 * Constructs an instance of this class.
	 *
	 * @param playerOneFigures The {@link Figure}s that player one uses in the encounter.
	 * @param playerTwoFigures The {@link Figure}s that player two uses in the encounter.
	 * @param gameBoard        The {@link GameBoard} where the figures are standing on and where they can move and
	 *                         attack.
	 *                         The {@link GameBoard} essentially is the interface for the player, so he can interact
	 *                         with
	 *                         the game.
	 *
	 * @precondition The attributes for the arena exist.
	 * @postcondition The Arena-instances were its attributes assigned.
	 */
	public Arena (final List<Figure> playerOneFigures, final List<Figure> playerTwoFigures, final GameBoard gameBoard)
	{
		this.playerOneFigures = playerOneFigures;
		this.playerTwoFigures = playerTwoFigures;
		this.gameBoard = gameBoard;
	}

	//TODO:
	public Arena()
	{
		this.playerOneFigures = new ArrayList<>();
		this.playerTwoFigures = new ArrayList<>();
		this.gameBoard = new GameBoard(ResourceLoader.createTileArrayFromFile(ArenaConstants.ArenaOne.ARENA_ONE_FILEPATH));
	}


	/**
	 * Creates the initial timeline by first placing all troops from player one on it and afterward placing all troops
	 * from player two on it.
	 *
	 * @param playerOneFigures The {@link Figure}s that player one uses in the encounter.
	 * @param playerTwoFigures The {@link Figure}s that player two uses in the encounter.
	 *
	 * @return An instance of {@link Timeline} which contains the timeline for the encounter.
	 *
	 * @precondition The Figures of player one and player one and two exist in the space of the encounter.
	 * @postcondition An instance of {@link Timeline} which contains the timeline for the encounter was created.
	 */
	private Timeline createTimeline (final Collection<Figure> playerOneFigures, final Collection<Figure> playerTwoFigures)
	{
		final ArrayList<Figure> troops = new ArrayList<>();
		troops.addAll(playerOneFigures);
		troops.addAll(playerTwoFigures);

		return new Timeline(troops);
	}


	/**
	 * Returns the {@link GameBoard} where the {@link Figure}s are deployed and can be moved/attack.
	 *
	 * @return The {@link GameBoard} where the {@link Figure}s are deployed and can be moved/attack.
	 *
	 * @precondition The {@link GameBoard} exist.
	 * @postcondition The game board is accessible is the program.
	 */
	public GameBoard getGameBoard ()
	{
		return this.gameBoard;
	}


	/**
	 * Returns the timeline that contains all {@link Figure}s that are currently on the {@link GameBoard}.
	 * <br>
	 * The timeline determines which {@link Figure} is allowed to make the next move.
	 *
	 * @return The timeline that contains all {@link Figure}s that are currently on the {@link GameBoard}.
	 *
	 * @precondition The FigureTimeline exists.
	 * @postcondition The timeline is accessible in the program.
	 */
	public Timeline getTimeline ()
	{
		return this.timeline;
	}


	/**
	 * Places the supplied {@link Figure} of the first player at a randomized position.
	 *
	 * @precondition The Figures of player one exist.
	 * @postcondition The Figures of player one are placed randomly on the game board.
	 */
	public void placePlayerOneFiguresRandomly ()
	{
		for (final Figure troop : this.playerOneFigures)
		{
			this.placeFigureRandomly(troop, 0);
		}
	}


	/**
	 * Places the supplied {@link Figure} of the second player at a randomized position.
	 *
	 * @precondition The Figures of player two exist.
	 * @postcondition The Figures of player two are placed randomly on the game board.
	 */
	public void placePlayerTwoFiguresRandomly ()
	{
		for (final Figure troop : this.playerTwoFigures)
		{
			this.placeFigureRandomly(troop, ENEMY_UNIT_TILE_OFFSET);
		}
	}


	/**
	 * Places the supplied {@link Figure} at a randomized position.
	 * <br>
	 * The offset can be used to adjust the placement on the {@link GameBoard}, for instance to create some space
	 * between the {@link Figure}s from the first player and the second player.
	 *
	 * @param figure The {@link Figure}s that'll be placed.
	 * @param offset The offset that'll create some spacing between {@link Figure}s.
	 *
	 * @precondition The Figures of the players exist.
	 * @postcondition The Figures of players are placed randomly on the game board, each in a specified part of the
	 * game board.
	 */
	private void placeFigureRandomly (final Figure figure, final int offset)
	{
		final RandomGenerator random = new Random();
		final int xPosition = random.nextInt(offset, offset + 1);
		final int yPosition = random.nextInt(GAME_BOARD_MAXIMUM_INDEX);
		final Position randomPosition = new Position(xPosition, yPosition);
		if (this.isAccessibleTile(randomPosition))
		{
			this.getGameBoard().place(randomPosition, figure);
			return;
		}

		this.placeFigureRandomly(figure, offset);
	}


	/**
	 * Checks if the tile of the supplied position is an {@link AccessibleElement}.
	 *
	 * @param position The position which will be checked.
	 *
	 * @return True if the tile is an {@link AccessibleElement}, otherwise false.
	 *
	 * @precondition The tile that'll be checked for accessible content.
	 * @postcondition Says if the desirable tile is accessible.
	 */
	private boolean isAccessibleTile (final Position position)
	{
		return this.gameBoard.getTile(position).getCurrentElement() instanceof AccessibleElement;
	}


	/**
	 * Returns the {@link Figure} that is currently selected.
	 *
	 * @return The {@link Figure} that is currently selected.
	 *
	 * @precondition The selected figure exists.
	 * @postcondition The selected figure is accessible for the program.
	 */
	public Figure getSelectedFigure ()
	{
		return this.selectedFigure;
	}


	/**
	 * Sets the {@link Figure} that is currently selected.
	 *
	 * @param selectedFigure The {@link Figure} that'll be set as selected.
	 *
	 * @precondition The selected figure exists.
	 * @postcondition The selected figure was set to a new state.
	 */
	public void setSelectedFigure (final Figure selectedFigure)
	{
		this.selectedFigure = selectedFigure;
	}


	/**
	 * Returns a boolean that says if an ability was used.
	 *
	 * @return The used ability gives a boolean that says if the ability was used.
	 *
	 * @precondition The used ability exists.
	 * @postcondition The boolean that says if the ability was used is accessible for the program.
	 */
	public boolean isAbilityUsed ()
	{
		return false;
	}


	/**
	 * Returns a {@link List} of all {@link Figure}s that belong to {@link Player} one.
	 * <br>
	 * In Singleplayer, this is the {@link Player} who plays the game.
	 *
	 * @return A {@link List} of all {@link Figure}s that belong to {@link Player} one.
	 *
	 * @precondition The figure of player one exists.
	 * @postcondition The Figure of player one is accessible ifor the program.
	 */
	public List<Figure> getPlayerOneFigures ()
	{
		return this.playerOneFigures;
	}


	/**
	 * Sets the {@link List} of all {@link Figure}s
	 * that belong to {@link Player} one to the supplied {@link List} of {@link Figure}s.
	 *
	 * @param playerOneFigures A {@link List} of {@link Figure}s which will be set as the {@link Figure}s that belong
	 *                         to the first player.
	 *
	 * @precondition The selected figure of player one exist.
	 * @postcondition The selected figure of player one was set to a new state.
	 */
	public void setPlayerOneFigures (final List<Figure> playerOneFigures)
	{
		this.playerOneFigures = playerOneFigures;
		this.timeline = this.createTimeline(playerOneFigures, this.playerTwoFigures);
	}


	/**
	 * Returns a {@link List} of all {@link Figure}s that belong to {@link Player} two.
	 * <br>
	 * In Singleplayer, this is the {@link Player} who plays the game.
	 *
	 * @return A {@link List} of all {@link Figure}s that belong to {@link Player} two.
	 *
	 * @precondition The figure of player one exists.
	 * @postcondition The Figure of player one is accessible for the program.
	 */
	public List<Figure> getPlayerTwoFigures ()
	{
		return this.playerTwoFigures;
	}


	/**
	 * Removes a {@link Figure} from the {@link GameBoard} and from the {@link Timeline}.
	 * <br>
	 * Additionally, the {@link Figure} is added to the {@link List} of eliminated {@link Figure}s, so to
	 * {@link Arena#eliminatedFigures}.
	 *
	 * @param figure The {@link Figure} that'll be removed.
	 *
	 * @precondition The {@link Figure} exists in the scoop of the encounter.
	 * @postcondition The eliminated {@link Figure} is removed from the timeline and game board and added to a {@link List} of
	 * eliminated {@link Figure}s.
	 */
	public void eliminateFigure (final Figure figure)
	{
		try
		{
			this.gameBoard.remove(figure);
			this.timeline.removeFigure(figure);
			this.eliminatedFigures.add(figure);
			this.adjustArenaResultIfNeeded();
		}
		catch (final ElementNotFoundOnGameBoardException e)
		{
			LOGGER.log(WARNING, e.getMessage());
		}
	}


	/**
	 * Adjusts the {@link Arena#result} if either the first or the second player is eliminated.
	 *
	 * @precondition An encounter is active.
	 * @postcondition Shows the result of the encounter to the player in the form of a displayed banner.
	 */
	private void adjustArenaResultIfNeeded ()
	{
		if (this.isPlayerEliminated(this.playerOneFigures))
		{
			this.result = ArenaResult.LOST;
		}
		else if (this.isPlayerEliminated(this.playerTwoFigures))
		{
			this.result = ArenaResult.WON;
		}
	}


	/**
	 * Checks if the player is eliminated, which is the case if all of his {@link Figure}s are contained in the
	 * {@link Arena#eliminatedFigures} {@link List}.
	 *
	 * @param playerFigures The {@link Figure}s of the {@link Player}.
	 *
	 * @return True if the player is eliminated, otherwise false.
	 *
	 * @precondition Figures exist.
	 * @postcondition Gives a boolean that says if a player lost all of its troops.
	 */
	private boolean isPlayerEliminated (final Collection<Figure> playerFigures)
	{
		return new HashSet<>(this.eliminatedFigures).containsAll(playerFigures);
	}


	/**
	 * Returns a {@link List} of all {@link Figure}s that have been eliminated.
	 *
	 * @return A {@link List} of all {@link Figure}s that have been eliminated.
	 *
	 * @precondition A {@link List} for the eliminated {@link Figure}s exist.
	 * @postcondition The {@link List} of the eliminated {@link Figure}s is accessible for the program.
	 */
	public List<Figure> getEliminatedFigures ()
	{
		return this.eliminatedFigures;
	}


	/**
	 * Builds a formatted {@link String}, which represents the object, and it's current state using the
	 * {@link Arena#TO_STRING_PATTERN}.
	 *
	 * @return A {@link String} which has been formatted in the {@link Arena#TO_STRING_PATTERN}.
	 *
	 * @precondition The {@link Arena#TO_STRING_PATTERN} is {@code != null}.
	 * @postcondition The method returned a {@link String} which represents the object.
	 */
	@Override
	public String toString ()
	{
		return MessageFormat.format(TO_STRING_PATTERN, this.gameBoard.toString(), Arrays.deepToString(this.playerTwoFigures.toArray()), Arrays.deepToString(this.eliminatedFigures.toArray()),
			this.result.toString(), this.timeline.toString(), Arrays.deepToString(this.playerOneFigures.toArray()), this.selectedFigure.toString());
	}


	/**
	 * Returns the current value of the {@link Arena#result}.
	 *
	 * @return The current value of the {@link Arena#result}.
	 *
	 * @precondition An encounter is active.
	 * @postcondition The {@link ArenaResult} is accessible for the program.
	 */
	public ArenaResult getResult ()
	{
		return this.result;
	}

}
