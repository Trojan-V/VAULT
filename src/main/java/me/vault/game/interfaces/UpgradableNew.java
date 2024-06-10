package me.vault.game.interfaces;


import me.vault.game.model.currency.CurrencyTransaction;


/**
 * Description
 *
 * @author Vincent Wolf
 * @version 1.0.0
 * @see
 * @since 06.06.2024
 */
public interface UpgradableNew<E>
{
	public abstract E getLevel ();


	/**
	 * Sets the current level of the {@code CityBuilding} object.
	 *
	 * @param currentLevel The new level of the object as an {@link Integer}.
	 */
	public abstract void setLevel (E currentLevel);


	public abstract CurrencyTransaction getCurrentUpgradeCosts ();
}
