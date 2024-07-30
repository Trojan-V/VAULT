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
 * @author Vincent Wolf, Lasse-Leander Hillen, Timothy Hoegen-Jupp, Alexander Goethel
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
	 *
	 * @precondition The {@link Upgradable} exists and can be upgraded.
	 * @postcondition The instance of the {@link Upgradable} gets upgraded.
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
	 *
	 * @precondition The {@link Upgradable} exists.
	 * @postcondition Gives back if the {@link Upgradable} is upgradable.
	 */
	boolean checkIsUpgradable (final T upgradable);


	/**
	 * Updates the values of the {@link Upgradable}, so it contains the newest set of data.
	 * <br>
	 * This data is usually displayed in the GUI.
	 * Most {@link Upgradable}'s contain JavaFX properties that are bound to the GUI,
	 * so the data of them can be dynamically updated.
	 *
	 * @param upgradable The {@link Upgradable} instance whose values should be updated.
	 *
	 * @precondition The {@link Upgradable} instance exists and can be upgraded.
	 * @postcondition The instance of the {@link Upgradable} gets upgraded.
	 */
	void updateValues (final T upgradable);

}
