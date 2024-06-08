package me.vault.game.interfaces;


/**
 * An interface for levels which provides some methods that every level enum/class should provide.
 * <br>
 *
 * @author Vincent Wolf
 * @version 1.0.0
 * @see me.vault.game.artifact.ArtifactLevel
 * @since 08.06.2024
 */
public interface ILevel
{
	/**
	 * Returns the next lower level for the current level instance.
	 *
	 * @return The next lower level for the current level instance.
	 */
	public ILevel getNextLowerLevel ();


	/**
	 * Returns the next higher level for the current level instance.
	 *
	 * @return The next higher level for the current level instance.
	 */
	public ILevel getNextHigherLevel ();
}