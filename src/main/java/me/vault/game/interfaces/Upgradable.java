package me.vault.game.interfaces;

import me.vault.game.model.building.CityBuilding;

import java.util.Map;

/**
 * Description
 *
 * @author Vincent Wolf
 * @version 1.0.0
 * @see CityBuilding
 * @since 15.05.2024
 */
public interface Upgradable<K, V>
{
	Map<K, V> getAllAttributes ();

	/**
	 * Returns the current level of the {@code CityBuilding} object.
	 *
	 * @return The current level of the object as an {@link Integer}.
	 */
	V getCurrentAttributes ();

	K getLevel ();

	/**
	 * Sets the current level of the {@code CityBuilding} object.
	 *
	 * @param level The new level of the object as an {@link Integer}.
	 */
	void setLevel (K level);

}
