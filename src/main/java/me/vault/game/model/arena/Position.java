package me.vault.game.model.arena;


import java.text.MessageFormat;


/**
 * A record that consists of an X and Y coordinate, which represents a position in the two-dimensional room.
 *
 * @author Vincent Wolf, Lasse-Leander Hillen, Timothy Hoegen-Jupp, Alexander Goethel
 * @version 1.0.0
 * @since 29.07.2024
 */
public final record Position(int x, int y)
{

	/**
	 * The pattern used to create the string which describes the class in a human-readable format.
	 */
	private static final String TO_STRING_PATTERN = "Pos[x:{0},y:{1}]";


	/**
	 * Returns the instance of this class in a human-readable format by creating a string.
	 *
	 * @return The instance in its string representation.
	 *
	 * @precondition The {@link Position#TO_STRING_PATTERN} is {@code != null}.
	 * @postcondition The method returned a {@link String} which represents the object.
	 */
	@Override
	public String toString ()
	{
		return MessageFormat.format(TO_STRING_PATTERN, this.x, this.y);
	}

}
