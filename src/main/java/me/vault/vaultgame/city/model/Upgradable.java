package me.vault.vaultgame.city.model;

/**
 * The interface {@link Upgradable} provides method bodies for subtypes of the {@link Building} class. The implemented methods should contain the
 * upgrade behaviour of the respective building.
 *
 * @author Lasse-Leander Hillen
 * @version 1.0.0
 * @see Spacestation
 * @see Building
 * @since 30.04.2024
 */
public interface Upgradable
{
	/**
	 * Elevates the {@link Building} to the next (higher) level, updates the sprite and unlocks new features based on the new level.
	 *
	 * @since 30.04.2024
	 */
	void upgrade ();

}
