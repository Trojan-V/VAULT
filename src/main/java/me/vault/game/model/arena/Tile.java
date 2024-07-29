package me.vault.game.model.arena;


import me.vault.game.interfaces.Placeable;
import me.vault.game.model.gameboard.GameBoard;

import java.text.MessageFormat;


/**
 * This class is a blueprint for a tile.
 * The {@link GameBoard} consists of many tiles.
 * <br>
 * Each tile consists of a {@link Position} and a {@link Placeable} that describes the element that's located on the tile.
 * <br>
 * These elements range from accessible tiles where everyone can walk, arena tiles where an encounter will begin to collectible tiles and blocked tiles which
 * represent an obstacle where no-one can walk.
 *
 * @author Vincent Wolf
 * @version 1.0.0
 * @see Position
 * @see Placeable
 * @since 29.07.2024
 */
public class Tile
{
	/**
	 * The {@link MessageFormat} pattern, which is used, when the {@link Tile#toString()} is
	 * called.
	 */
	private static final String TO_STRING_PATTERN = "Tile'{'position={0}, currentElement={1}'}'";


	/**
	 * The {@link Position} of the tile.
	 */
	private final Position position;


	/**
	 * The {@link Placeable} element that's located on the tile.
	 */
	private Placeable currentElement;


	/**
	 * Constructs an instance of this class.
	 *
	 * @param position The position of the tile.
	 * @param currentElement The {@link Placeable} element that's located on the tile.
	 */
	public Tile (final Position position, final Placeable currentElement)
	{
		this.position = position;
		this.currentElement = currentElement;
	}


	/**
	 * Returns the {@link Placeable} element that's located on the tile.
	 *
	 * @return The {@link Placeable} element that's located on the tile.
	 */
	public Placeable getCurrentElement ()
	{
		return this.currentElement;
	}


	/**
	 * Sets the {@link Placeable} element that's located on the tile.
	 *
	 * @param placeable The {@link Placeable} element that'll be set to the tile.
	 */
	public void setCurrentElement (final Placeable placeable)
	{
		this.currentElement = placeable;
	}


	/**
	 * Builds a formatted {@link String}, which represents the object, and it's current state using the
	 * {@link Tile#TO_STRING_PATTERN}.
	 *
	 * @return A {@link String} which has been formatted in the {@link Tile#TO_STRING_PATTERN}.
	 * @precondition The {@link Tile#TO_STRING_PATTERN} is {@code != null}.
	 * @postcondition The method returned a {@link String} which represents the object.
	 */
	@Override
	public String toString ()
	{
		return MessageFormat.format(TO_STRING_PATTERN, this.position, this.currentElement);
	}


	/**
	 * Returns the {@link Position} of the tile.
	 *
	 * @return the {@link Position} of the tile.
	 */
	public Position getPosition ()
	{
		return this.position;
	}
}
