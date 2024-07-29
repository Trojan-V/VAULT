package me.vault.game.control;


import me.vault.game.interfaces.Movable;
import me.vault.game.interfaces.Placeable;
import me.vault.game.model.arena.AccessibleTileAppearance;
import me.vault.game.model.arena.Figure;
import me.vault.game.model.arena.GameBoard;
import me.vault.game.model.arena.Position;
import me.vault.game.model.player.Player;


/**
 * Controller class for any {@link Movable}s.
 * <br>
 * Provides a move() method the Movable's can use to move on the {@link GameBoard}.
 *
 * @author Vincent Wolf
 * @version 1.0.0
 * @see
 * @since 29.07.2024
 */
public final class MovableController
{
	/**
	 * As this class solely contains static methods and therefore is a utility class,
	 * no other class should be able to instantiate it.
	 * <br>
	 * To prohibit the instantiation from anywhere else but within the class, a private constructor is used.
	 */
	private MovableController ()
	{
	}


	/**
	 * Moves the {@link Movable} on the {@link GameBoard} to the supplied {@link Position}.
	 *
	 * @param gameBoard    The {@link GameBoard} where the encounter is happening.
	 * @param movable      Should be either a {@link Figure <? extends Troop>} or a {@link Player}. But generally
	 *                     speaking, this is the {@link Movable} that will be moved on the {@link GameBoard}.
	 * @param nextPosition The position the {@link Placeable} should be moved to.
	 */
	public static void move (final GameBoard gameBoard, final Movable movable, final Position nextPosition)
	{
		final Position previousTroopPosition = gameBoard.getPosition(movable);
		gameBoard.placeIfAccessibleTile(nextPosition, movable);

		// Set the previous position of the troop back to an accessible tile
		// so the troop isn't displayed multiple times.
		gameBoard.place(previousTroopPosition, new AccessibleTileAppearance());
	}
}
