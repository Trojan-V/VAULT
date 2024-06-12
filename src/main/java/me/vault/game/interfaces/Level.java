package me.vault.game.interfaces;


import me.vault.game.model.artifact.ArtifactLevel;


/**
 * An interface for levels which provides some methods that every level enum/class should provide.
 *
 * @author Vincent Wolf
 * @version 1.0.0
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

}
