package me.vault.game.model.arena;


/**
 * This enumeration contains all possible results of an arena encounter.
 *
 * @author Vincent Wolf
 * @version 1.0.0
 * @see Arena
 * @since 29.07.2024
 */
public enum ArenaResult
{
	/**
	 * If the result of the arena encounter isn't decided yet, this is the result.
	 */
	UNDEFINED,


	/**
	 * If the player lost the arena encounter, this is the result.
	 */
	LOST,


	/**
	 * If the player won the arena encounter, this is the result.
	 */
	WON
}

