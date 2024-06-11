package me.vault.game.interfaces;

/**
 * This interface should be implemented by classes that have some upgrading capability in any form.
 * <br>
 * Usually, these classes are controller classes that provide upgrading capabilities for their corresponding models. These models have to implement
 * the {@link UpgradableNew} interface.
 *
 * @param <E> The level type.
 * @param <T> The data type of the class that implements the {@link UpgradableNew} interface.
 *
 * @author Vincent Wolf
 * @version 1.0.0
 * @see IUpgrader
 * @see UpgradableNew
 * @since 08.06.2024
 */
public interface IUpgrader<T extends UpgradableNew<E>, E>
{
	/**
	 * Upgrades the {@link UpgradableNew} instance to the next level {@link E}.
	 *
	 * @param upgradable The {@link UpgradableNew} instance that gets upgraded.
	 */
	void upgrade (T upgradable);

	/**
	 * Checks if the {@link UpgradableNew} instance can be upgraded to the next level.
	 * <br>
	 * This method checks the constraints that need to be fulfilled to be able to upgrade the {@link UpgradableNew} to the next level.
	 *
	 * @param upgradable The {@link UpgradableNew} instance which is checked if it can be upgraded to the next level.
	 *
	 * @return True if the {@link UpgradableNew} can be upgraded, otherwise false.
	 */
	boolean checkIsUpgradable (T upgradable);

}
