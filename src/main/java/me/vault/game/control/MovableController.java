package me.vault.game.control;


import me.vault.game.model.Player;
import me.vault.game.model.gameboard.Figure;
import me.vault.game.model.gameboard.GameBoard;
import me.vault.game.model.gameboard.tile.impl.AccessibleTileAppearance;
import me.vault.game.utility.exception.ElementNotFoundOnGameBoardException;
import me.vault.game.utility.interfaces.Movable;
import me.vault.game.utility.interfaces.Placeable;
import me.vault.game.utility.logging.ILogger;
import me.vault.game.utility.logging.Logger;
import me.vault.game.utility.math.Position;

import static me.vault.game.utility.logging.ILogger.Level.WARNING;


/**
 * Controller class for any {@link Movable}s.
 * <br>
 * Provides a move() method the Movable's can use to move on the {@link GameBoard}.
 *
 * @author Vincent Wolf, Lasse-Leander Hillen, Timothy Hoegen-Jupp, Alexander Goethel
 * @version 1.0.0
 * @see Movable
 * @since 29.07.2024
 */
public final class MovableController
{

	/**
	 * The {@link Logger} object for this class used for writing to the console.
	 */
	private static final ILogger LOGGER = new Logger(MovableController.class.getSimpleName());


	/**
	 * As this class solely contains static methods and therefore is a utility class,
	 * no other class should be able to instantiate it.
	 * <br>
	 * To prohibit the instantiation from anywhere else but within the class, a private constructor is used.
	 *
	 * @precondition Constructor gets called from within the class
	 * @postcondition A new instance of MovableController is created.
	 */
	private MovableController () {}


	/**
	 * Moves the {@link Movable} on the {@link GameBoard} to the supplied {@link Position}.
	 *
	 * @param gameBoard    The {@link GameBoard} where the encounter is happening.
	 * @param movable      Should be either a {@link Figure <? extends Troop>} or a {@link Player}. But generally
	 *                     speaking, this is the {@link Movable} that will be moved on the {@link GameBoard}.
	 * @param nextPosition The position the {@link Placeable} should be moved to.
	 *
	 * @precondition A game board, a movable, and a position on the game board are passed into the method.
	 * @postcondition The movable object was moved to the passed position on the passed game board.
	 */
	public static void move (final GameBoard gameBoard, final Movable movable, final Position nextPosition)
	{
		try
		{
			final Position previousTroopPosition = gameBoard.getPosition(movable);
			gameBoard.placeIfAccessibleTile(nextPosition, movable);

			// Set the previous position of the troop back to an accessible tile
			// so the troop isn't displayed multiple times.
			gameBoard.place(previousTroopPosition, new AccessibleTileAppearance());
		}
		catch (final ElementNotFoundOnGameBoardException e)
		{
			LOGGER.log(WARNING, e.getMessage());
		}

	}

}
