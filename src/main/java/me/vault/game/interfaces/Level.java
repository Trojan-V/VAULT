package me.vault.game.interfaces;


import me.vault.game.model.artifact.ArtifactLevel;

import static me.vault.game.utility.constant.MiscConstants.ZERO_INDEXED_LENGTH_CORRECTION_SUBTRACTION_ORDINAL;


/**
 * An interface for levels which defines some methods that every level enum/class should provide.
 *
 * @author Vincent Wolf, Lasse-Leander Hillen, Timothy Hoegen-Jupp, Alexander Goethel
 * @version 1.0.1
 * @see ArtifactLevel
 * @since 08.06.2024
 */
public interface Level
{
	/**
	 * Returns the next lower level for the current level instance.
	 *
	 * @return The next lower level for the current level instance.
	 */
	Level getNextLowerLevel ();


	/**
	 * Returns the next higher level for the current level instance.
	 *
	 * @return The next higher level for the current level instance.
	 */
	Level getNextHigherLevel ();


	/**
	 * Checks if the level of the current level instance is the minimum level.
	 *
	 * @return True if the level of the current level instance is the minimum level, otherwise false.
	 */
	boolean isMinimum ();


	/**
	 * Checks if the level of the current level instance is the maximum level.
	 *
	 * @return True if the level of the current level instance is the maximum level, otherwise false.
	 */
	boolean isMaximum ();


	/**
	 * Returns the last index for the total length of the enum.
	 * <br>
	 * Basically just subtracts the length by one, as enums are zero-indexed.
	 *
	 * @param length The length of the enum.
	 * @return The last index of the enum where's still data that can be accessed.
	 */
	public static int getLastIndex (final int length)
	{
		return length - ZERO_INDEXED_LENGTH_CORRECTION_SUBTRACTION_ORDINAL;
	}
}
