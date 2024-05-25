package me.vault.vaultgame.model.interfaces;


import me.vault.vaultgame.model.citybuilding.CityBuilding;

import java.util.Map;


/**
 * Description
 *
 * @author Vincent Wolf
 * @version 1.0.0
 * @see CityBuilding
 * @since 15.05.2024
 */
public interface IUpgradable<E, F>
{
	public abstract Map<E, F> getAllProperties ();


	/**
	 * Returns the current level of the {@code CityBuilding} object.
	 *
	 * @return The current level of the object as an {@link Integer}.
	 */
	public abstract F getCurrentProperties ();


	public abstract E getLevel ();


	/**
	 * Sets the current level of the {@code CityBuilding} object.
	 *
	 * @param level The new level of the object as an {@link Integer}.
	 */
	public abstract void setLevel (E level);

}
