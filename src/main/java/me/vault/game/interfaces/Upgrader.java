package me.vault.game.interfaces;


/**
 * This interface should be implemented by classes that have some upgrading capability in any form.
 * <br>
 * Usually, these classes are controller classes that provide upgrading capabilities for their corresponding models. These models have to implement
 * the {@link Upgradable} interface.
 *
 * @param <E> The level type.
 * @param <T> The data type of the class that implements the {@link Upgradable} interface.
 *
 * @author Vincent Wolf
 * @version 2.0.0
 * @see Upgrader
 * @see Upgradable
 * @since 08.06.2024
 */
public interface Upgrader<T extends Upgradable<E>, E>
{

	/**
	 * Upgrades the {@link Upgradable} instance to the next level {@link E}.
	 *
	 * @param upgradable The {@link Upgradable} instance that gets upgraded.
	 */
	void upgrade (final T upgradable);


	/**
	 * Checks if the {@link Upgradable} instance can be upgraded to the next level.
	 * <br>
	 * This method checks the constraints that need to be fulfilled to be able to upgrade the {@link Upgradable} to the next level.
	 *
	 * @param upgradable The {@link Upgradable} instance which is checked if it can be upgraded to the next level.
	 *
	 * @return True if the {@link Upgradable} can be upgraded, otherwise false.
	 */
	boolean checkIsUpgradable (final T upgradable);


	void updatePropertyValues (final T upgradable);

}
