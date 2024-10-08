package me.vault.game.model.gameboard;


import me.vault.game.model.Mission;
import me.vault.game.model.arena.Arena;
import me.vault.game.model.artifact.Artifact;
import me.vault.game.model.gameboard.tile.Tile;
import me.vault.game.model.gameboard.tile.implementation.AccessibleElement;
import me.vault.game.utility.exception.ElementNotFoundOnGameBoardException;
import me.vault.game.utility.exception.NotAFigureException;
import me.vault.game.utility.interfaces.Placeable;
import me.vault.game.utility.interfaces.SerializableJSON;
import me.vault.game.utility.math.Position;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * This class is a blueprint for a game board which represents the structure where the {@link Mission}s and {@link Arena} encounters take place.
 * The {@link Figure}s are deployed on the game board and can move on it or attack other {@link Figure}s.
 *
 * @author Vincent Wolf, Lasse-Leander Hillen, Timothy Hoegen-Jupp, Alexander Goethel
 * @version 1.0.0
 * @see Arena
 * @see Mission
 * @since 30.07.2024
 */
public class GameBoard implements SerializableJSON
{

	/**
	 * The default range of a {@link Figure} if no other value is specified.
	 */
	private static final int DEFAULT_FIGURE_RANGE = 1;


	/**
	 * The {@link MessageFormat} pattern, which is used, when the {@link Artifact#toString()} is
	 * called.
	 */
	private static final String TO_STRING_PATTERN = "GameBoard'{'gameBoard={0}'}'";


	/**
	 * The internal data structure of the game board.
	 * <br>
	 * It simply uses a two-dimensional array of {@link Tile}s. The {@link Tile}s in this array represent the game board.
	 */
	private final Tile[][] gameBoard;


	/**
	 * Constructs an instance of this class. The two-dimensional {@link Tile} array has to be supplied to the constructor.
	 *
	 * @param gameBoard The two-dimensional array of {@link Tile}s.
	 *
	 * @precondition The tiles exist.
	 * @postcondition An instance of this class is created from the supplied tiles.
	 */
	public GameBoard (final Tile[][] gameBoard)
	{
		this.gameBoard = gameBoard;
	}


	/**
	 * Searches for the position of the supplied {@link Placeable} element on the game board.
	 * <br>
	 * If the position is found, it'll be returned; otherwise an {@link ElementNotFoundOnGameBoardException} is thrown.
	 *
	 * @param placeable The {@link Placeable} that'll be searched for.
	 *
	 * @return The {@link Position} if the {@link Placeable} was found.
	 *
	 * @exception ElementNotFoundOnGameBoardException If the {@link Placeable} element wasn't found on the game board.
	 * @precondition A {@link Placeable} element was supplied as a parameter.
	 * @postcondition The {@link Position} if the {@link Placeable} was found and is accessible for the program.
	 */
	public Position getPosition (final Placeable placeable) throws ElementNotFoundOnGameBoardException
	{
		for (int i = 0; i < this.gameBoard.length; i++)
		{
			for (int j = 0; j < this.gameBoard[i].length; j++)
			{
				if (this.gameBoard[i][j].getCurrentElement() == placeable)
				{
					return new Position(i, j);
				}
			}
		}
		throw new ElementNotFoundOnGameBoardException();
	}


	/**
	 * Returns the {@link Tile} instance that is located at the supplied {@link Position} on the game board.
	 *
	 * @param position The position of the {@link Tile} that'll be returned.
	 *
	 * @return The {@link Tile} at the supplied {@link Position}.
	 *
	 * @precondition The position of the {@link Tile} that'll be returned exists.
	 * @postcondition The {@link Tile} at the supplied {@link Position} is accessible for the program.
	 */
	public Tile getTile (final Position position)
	{
		return this.gameBoard[position.x()][position.y()];
	}


	/**
	 * Returns the {@link Figure} that is located at the supplied {@link Position} on the game board.
	 * <br>
	 * If there's no {@link Figure} at the supplied {@link Position} for some reason, a {@link NotAFigureException} will be thrown.
	 *
	 * @param position The {@link Position} whose {@link Figure} is going to be returned.
	 *
	 * @return The {@link Figure} instance which is located at the supplied {@link Position}.
	 *
	 * @exception NotAFigureException If there's no {@link Figure} at the supplied {@link Position} for some reason.
	 * @precondition The {@link Figure} at the {@link Position} exists.
	 * @postcondition The instance of the {@link Figure} which is at the {@link Position} is accessible for the program.
	 */
	public Figure getFigure (final Position position) throws NotAFigureException
	{
		if (!(this.gameBoard[position.x()][position.y()].getCurrentElement() instanceof Figure))
		{
			throw new NotAFigureException(this.gameBoard[position.x()][position.y()].getCurrentElement().getClass().getName());
		}
		return (Figure) this.gameBoard[position.x()][position.y()].getCurrentElement();
	}


	/**
	 * Places the supplied {@link Placeable} on the game board at the supplied {@link Position}.
	 * <br>
	 * Only places the {@link Placeable} if the {@link Tile} at the supplied {@link Position} is an {@link AccessibleElement}.
	 *
	 * @param position  The {@link Position}.
	 * @param placeable The {@link Placeable}.
	 *
	 * @precondition The {@link Tile} is at the {@link Position} and is an {@link AccessibleElement}.
	 * @postcondition The {@link Placeable} is placed on the game board at the {@link Position}.
	 */
	public void placeIfAccessibleTile (final Position position, final Placeable placeable)
	{
		if (this.gameBoard[position.x()][position.y()].getCurrentElement().getClass() == AccessibleElement.class)
		{
			this.place(position, placeable);
		}
	}


	/**
	 * Places the supplied {@link Placeable} on the game board at the supplied {@link Position}.
	 *
	 * @param position  The {@link Position}.
	 * @param placeable The {@link Placeable}.
	 *
	 * @precondition The {@link Placeable} is supplied and {@link Position} exists.
	 * @postcondition The {@link Placeable} is placed on the game board at the {@link Position}
	 */
	public void place (final Position position, final Placeable placeable)
	{
		this.gameBoard[position.x()][position.y()].setCurrentElement(placeable);
	}


	/**
	 * Returns a {@link List} of all {@link Tile}s that can be reached.
	 * <br>
	 * The attackRange of the {@link Figure} is taken into account.
	 *
	 * @param position    The {@link Position} whose reachable {@link Tile}s should be determined.
	 * @param attackRange The attack range of the {@link Figure}.
	 *
	 * @return A {@link List} of all {@link Tile}s that can be reached.
	 *
	 * @precondition The {@link Figure} has to have a supplied attack range and has to have a {@link Position}.
	 * @postcondition The {@link List} of all {@link Tile}s that can be reached is accessible for the program.
	 */
	public List<Tile> getReachableTiles (final Position position, final int attackRange)
	{
		final List<Tile> adjacentTiles = this.getAdjacentTiles(position, attackRange);
		adjacentTiles.removeIf(tile -> !(tile.getCurrentElement() instanceof Figure));
		return adjacentTiles;
	}


	/**
	 * Returns a {@link List} of all tiles that are adjacent to the supplied {@link Position}.
	 * <br>
	 * This method uses the {@link GameBoard#DEFAULT_FIGURE_RANGE} to determine which tiles are adjacent.
	 *
	 * @param position The {@link Position} whose adjacent {@link Tile}s should be determined.
	 *
	 * @return A {@link List} of all tiles that are adjacent to the supplied {@link Position}.
	 *
	 * @precondition The {@link Position} of the {@link Tile}s as well as the range of the {@link Figure} have to be
	 * supplied.
	 * @postcondition The {@link List} of all tiles that are adjacent to the supplied {@link Position} is accessible
	 * for the program.
	 */
	public List<Tile> getAdjacentTiles (final Position position)
	{
		return this.getAdjacentTiles(position, DEFAULT_FIGURE_RANGE);
	}


	/**
	 * Returns a {@link List} of all tiles that are adjacent to the supplied {@link Position}.
	 * <br>
	 * This method takes the supplied range into account and increases the depth of the adjacent tile search accordingly.
	 *
	 * @param position The {@link Position} whose adjacent {@link Tile}s should be determined.
	 * @param range    The range of the {@link Figure} at the supplied {@link Position}.
	 *
	 * @return A {@link List} of all tiles that are adjacent to the supplied {@link Position}, while taking care of the supplied range parameter.
	 *
	 * @precondition The {@link Position} of the {@link Tile}s as well as the range of the {@link Figure} have to be
	 * supplied.
	 * @postcondition The {@link List} of all {@link Tile}s that are adjacent to the supplied {@link Position} is accessible
	 * for the program.
	 */
	public List<Tile> getAdjacentTiles (final Position position, final int range)
	{
		final List<Tile> adjacentTiles = new ArrayList<>();
		for (int i = (position.x() - range); i <= position.x() + range; i++)
		{
			for (int j = position.y() - range; j <= position.y() + range; j++)
			{
				try
				{
					adjacentTiles.add(this.gameBoard[i][j]);
				}
				catch (final IndexOutOfBoundsException _)
				{
				}
			}
		}
		adjacentTiles.remove(this.gameBoard[position.x()][position.y()]);
		return adjacentTiles;
	}


	/**
	 * Returns a {@link List} of the tiles that are adjacent and accessible to the supplied {@link Position}.
	 *
	 * @param position The {@link Position} whose adjacent accessible {@link Tile}s should be determined.
	 *
	 * @return A {@link List} of the tiles that are adjacent and accessible to the supplied {@link Position}.
	 *
	 * @precondition The {@link Position} of the {@link Tile}s are supplied, and it has to be determined if the adjacent
	 * {@link Tile} is accessible.
	 * @postcondition The {@link List} of the {@link Tile}s that are adjacent and accessible to the supplied
	 * {@link Position} are accessible to the program.
	 */
	public List<Tile> getAdjacentAccessibleTiles (final Position position)
	{
		final List<Tile> adjacentTiles = this.getAdjacentTiles(position);
		adjacentTiles.removeIf(tile -> !(tile.getCurrentElement() instanceof AccessibleElement));
		return adjacentTiles;
	}


	/**
	 * Returns a {@link List} of the tiles that are adjacent and accessible to the supplied {@link Position}.
	 *
	 * @param position The {@link Position} whose adjacent accessible {@link Tile}s should be determined.
	 * @param range    The range of the {@link Figure} at the supplied {@link Position}.
	 *
	 * @return A {@link List} of the tiles that are adjacent and accessible to the supplied {@link Position}.
	 *
	 * @precondition The {@link Position} of the {@link Tile}s as well as the range of the {@link Figure} are supplied, and it has to be determined
	 * if the adjacent {@link Tile} is accessible.
	 * @postcondition The {@link List} of the {@link Tile}s that are adjacent and accessible to the supplied
	 * {@link Position} while factoring in the range of the {@link Figure} are accessible to the program.
	 */
	public List<Tile> getAdjacentAccessibleTiles (final Position position, final int range)
	{
		final List<Tile> adjacentTiles = this.getAdjacentTiles(position, range);
		adjacentTiles.removeIf(tile -> !(tile.getCurrentElement() instanceof AccessibleElement));
		return adjacentTiles;
	}


	/**
	 * Removes the supplied {@link Placeable} from the game board and replaces it with an {@link AccessibleElement}, which basically "clears" that tile.
	 *
	 * @param placeable The {@link Placeable} that is going to get removed from the game board.
	 *
	 * @exception ElementNotFoundOnGameBoardException If the supplied {@link Placeable} wasn't found on the game board.
	 * @precondition The {@link Tile} on the game board has to have a {@link Placeable}
	 * @postcondition The {@link Placeable} is removed from the game board and the {@link Tile} where the
	 * {@link Placeable} were removed is now an {@link AccessibleElement}.
	 */
	public void remove (final Placeable placeable) throws ElementNotFoundOnGameBoardException
	{
		this.place(this.getPosition(placeable), new AccessibleElement());
	}


	/**
	 * Builds a formatted {@link String}, which represents the object, and it's current state using the
	 * {@link GameBoard#TO_STRING_PATTERN}.
	 *
	 * @return A {@link String} which has been formatted in the {@link GameBoard#TO_STRING_PATTERN}.
	 *
	 * @precondition The {@link GameBoard#TO_STRING_PATTERN} is {@code != null}.
	 * @postcondition The method returned a {@link String} which represents the object.
	 */
	@Override
	public String toString ()
	{
		return MessageFormat.format(TO_STRING_PATTERN, Arrays.toString(this.gameBoard));
	}

}
