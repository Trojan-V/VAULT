package me.vault.game.model.arena;


import me.vault.game.model.gameboard.GameBoard;
import me.vault.game.model.gameboard.tiles.AccessibleTileAppearance;
import me.vault.game.model.player.Player;
import me.vault.game.utility.fx.TimelineElementHBox;
import me.vault.game.view.mission.MissionSelectionDelegate;

import java.text.MessageFormat;
import java.util.*;

import static me.vault.game.utility.constant.ArenaConstants.MULTIPLIER;
import static me.vault.game.utility.constant.ArenaConstants.OFFSET;


/**
 * This class is the model for the arena where the encounters take place.
 *
 * @author Vincent Wolf
 * @version 1.0.0
 * @see GameBoard
 * @see Figure
 * @since 29.07.2024
 */
public class Arena
{

	/**
	 * The {@link MessageFormat} pattern, which is used, when the {@link MissionSelectionDelegate#toString()} is
	 * called.
	 */
	private static final String TO_STRING_PATTERN =
		"Arena'{'gameBoard={0}, playerTwoFigures={1}, eliminatedFigures={2}, arenaResult={3}, troopTimeline={4}, " +
		"playerOneFigures={5}, selectedFigure={6}'}'";


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
	private ArenaResult arenaResult = ArenaResult.UNDEFINED;


	/**
	 * This is the internal data structure that handles the troop timeline.
	 * It doesn't correspond to the GUI element.
	 * <br>
	 * The timeline contains all {@link Figure}s that are currently on the {@link GameBoard} and determines which
	 * {@link Figure} is allowed to make the next move.
	 * <br>
	 * For the GUI element, check {@link TimelineElementHBox}.
	 */
	private FigureTimeline figureTimeline = null;


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
	 */
	public Arena (final List<Figure> playerOneFigures, final List<Figure> playerTwoFigures, final GameBoard gameBoard)
	{
		this.playerOneFigures = playerOneFigures;
		this.playerTwoFigures = playerTwoFigures;
		this.gameBoard = gameBoard;
	}


	/**
	 * Creates the initial timeline by first placing all troops from player one on it and afterward placing all troops
	 * from player two on it.
	 *
	 * @param playerOneFigures The {@link Figure}s that player one uses in the encounter.
	 * @param playerTwoFigures The {@link Figure}s that player two uses in the encounter.
	 * @return An instance of {@link FigureTimeline} which contains the timeline for the encounter.
	 */
	private FigureTimeline createTimeline (final Collection<Figure> playerOneFigures,
		final Collection<Figure> playerTwoFigures)
	{
		final ArrayList<Figure> troops = new ArrayList<>();
		troops.addAll(playerOneFigures);
		troops.addAll(playerTwoFigures);

		return new FigureTimeline(troops);
	}


	/**
	 * Returns the {@link GameBoard} where the {@link Figure}s are deployed and can be moved/attack.
	 *
	 * @return The {@link GameBoard} where the {@link Figure}s are deployed and can be moved/attack.
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
	 */
	public FigureTimeline getTimeline ()
	{
		return this.figureTimeline;
	}


	/**
	 * Places the supplied {@link Figure} of the first player at a randomized position.
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
	 */
	public void placePlayerTwoFiguresRandomly ()
	{
		for (final Figure troop : this.playerTwoFigures)
		{
			this.placeFigureRandomly(troop, OFFSET);
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
	 */
	private void placeFigureRandomly (final Figure figure, final int offset)
	{
		final Position randomPosition = new Position((int) Math.round(Math.random() + offset), (int) Math.round(Math.random() * MULTIPLIER));
		if (this.isAccessibleTile(randomPosition))
		{
			this.getGameBoard().place(randomPosition, figure);
			return;
		}

		this.placeFigureRandomly(figure, offset);
	}


	/**
	 * Checks if the tile of the supplied position is an {@link AccessibleTileAppearance}.
	 *
	 * @param position The position which will be checked.
	 * @return True if the tile is an {@link AccessibleTileAppearance}, otherwise false.
	 */
	private boolean isAccessibleTile (final Position position)
	{
		return this.gameBoard.getTile(position).getCurrentElement() instanceof AccessibleTileAppearance;
	}


	/**
	 * Returns the {@link Figure} that is currently selected.
	 *
	 * @return The {@link Figure} that is currently selected.
	 */
	public Figure getSelectedFigure ()
	{
		return this.selectedFigure;
	}


	/**
	 * Sets the {@link Figure} that is currently selected.
	 *
	 * @param selectedFigure The {@link Figure} that'll be set as selected.
	 */
	public void setSelectedFigure (final Figure selectedFigure)
	{
		this.selectedFigure = selectedFigure;
	}


	/**
	 * Returns a {@link List} of all {@link Figure}s that belong to {@link Player} one.
	 * <br>
	 * In Singleplayer, this is the {@link Player} who plays the game.
	 *
	 * @return A {@link List} of all {@link Figure}s that belong to {@link Player} one.
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
	 */
	public void setPlayerOneFigures (final List<Figure> playerOneFigures)
	{
		this.playerOneFigures = playerOneFigures;
		this.figureTimeline = this.createTimeline(playerOneFigures, this.playerTwoFigures);
	}


	/**
	 * Returns a {@link List} of all {@link Figure}s that belong to {@link Player} two.
	 * <br>
	 * In Singleplayer, this is the {@link Player} who plays the game.
	 *
	 * @return A {@link List} of all {@link Figure}s that belong to {@link Player} two.
	 */
	public List<Figure> getPlayerTwoFigures ()
	{
		return this.playerTwoFigures;
	}


	/**
	 * Removes a {@link Figure} from the {@link GameBoard} and from the {@link FigureTimeline}.
	 * <br>
	 * Additionally, the {@link Figure} is added to the {@link List} of eliminated {@link Figure}s, so to
	 * {@link Arena#eliminatedFigures}.
	 *
	 * @param figure The {@link Figure} that'll be removed.
	 */
	public void eliminateFigure (final Figure figure)
	{
		this.gameBoard.remove(figure);
		this.figureTimeline.removeFigure(figure);
		this.eliminatedFigures.add(figure);
		this.adjustArenaResultIfNeeded();
	}


	/**
	 * Adjusts the {@link Arena#arenaResult} if either the first or the second player is eliminated.
	 */
	private void adjustArenaResultIfNeeded ()
	{
		if (this.isPlayerEliminated(this.playerOneFigures))
		{
			this.arenaResult = ArenaResult.LOST;
		}
		else if (this.isPlayerEliminated(this.playerTwoFigures))
		{
			this.arenaResult = ArenaResult.WON;
		}
	}


	/**
	 * Checks if the player is eliminated, which is the case if all of his {@link Figure}s are contained in the
	 * {@link Arena#eliminatedFigures} {@link List}.
	 *
	 * @param playerFigures The {@link Figure}s of the {@link Player}.
	 * @return True if the player is eliminated, otherwise false.
	 */
	private boolean isPlayerEliminated (final Collection<Figure> playerFigures)
	{
		return new HashSet<>(this.eliminatedFigures).containsAll(playerFigures);
	}


	/**
	 * Returns a {@link List} of all {@link Figure}s that have been eliminated.
	 *
	 * @return A {@link List} of all {@link Figure}s that have been eliminated.
	 */
	public List<Figure> getEliminatedFigures ()
	{
		return this.eliminatedFigures;
	}


	/**
	 * Returns the {@link ArenaResult}, which represents the current state of the encounter in the arena.
	 *
	 * @return The {@link ArenaResult}, which represents the current state of the encounter in the arena.
	 */
	public ArenaResult getState ()
	{
		return this.arenaResult;
	}


	/**
	 * Builds a formatted {@link String}, which represents the object, and it's current state using the
	 * {@link Arena#TO_STRING_PATTERN}.
	 *
	 * @return A {@link String} which has been formatted in the {@link Arena#TO_STRING_PATTERN}.
	 * @precondition The {@link Arena#TO_STRING_PATTERN} is {@code != null}.
	 * @postcondition The method returned a {@link String} which represents the object.
	 */
	@Override
	public String toString ()
	{
		return MessageFormat.format(TO_STRING_PATTERN, this.gameBoard.toString(),
			Arrays.deepToString(this.playerTwoFigures.toArray()),
			Arrays.deepToString(this.eliminatedFigures.toArray()), this.arenaResult.toString(),
			this.figureTimeline.toString(),
			Arrays.deepToString(this.playerOneFigures.toArray()), this.selectedFigure.toString());
	}
}
