package me.vault.game.utility.interfaces;


import me.vault.game.model.artifact.ArtifactLevel;
import me.vault.game.utility.interfaces.constant.MiscConstants;


/**
 * An interface for levels which defines some methods that every level enum/class should provide.
 *
 * @author Vincent Wolf, Lasse-Leander Hillen, Timothy Hoegen-Jupp, Alexander Goethel
 * @version 1.0.0
 * @see ArtifactLevel
 * @since 08.06.2024
 */
public interface Level
{

	/**
	 * Returns the last index for the total length of the enum.
	 * <br>
	 * Basically just subtracts the length by one, as enums are zero-indexed.
	 *
	 * @param length The length of the enum.
	 *
	 * @return The last index of the enum where's still data that can be accessed.
	 *
	 * @precondition The method gets called and the length of the Level has been passed.
	 * @precondition The last index of the Level was returned
	 */
	public static int getLastIndex (final int length)
	{
		return length - MiscConstants.ZERO_INDEXED_LENGTH_CORRECTION_SUBTRACTION_ORDINAL;
	}


	/**
	 * Returns the next lower level for the current level instance.
	 *
	 * @return The next lower level for the current level instance.
	 *
	 * @precondition The method gets called.
	 * @precondition The next lower level of the Level is returned.
	 */
	Level getNextLowerLevel ();


	/**
	 * Returns the next higher level for the current level instance.
	 *
	 * @return The next higher level for the current level instance.
	 *
	 * @precondition The method gets called.
	 * @precondition The next higher level of the Level is returned.
	 */
	Level getNextHigherLevel ();


	/**
	 * Checks if the level of the current level instance is the minimum level.
	 *
	 * @return True if the level of the current level instance is the minimum level, otherwise false.
	 *
	 * @precondition The method gets called.
	 * @precondition If the level is the minimum, then true was returned.
	 */
	boolean isMinimum ();


	/**
	 * Checks if the level of the current level instance is the maximum level.
	 *
	 * @return True if the level of the current level instance is the maximum level, otherwise false.
	 *
	 * @precondition The method gets called.
	 * @precondition If the level is the maximum, then true was returned.
	 */
	boolean isMaximum ();

}
