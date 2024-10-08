package me.vault.game.utility.interfaces;


import me.vault.game.model.currency.CurrencyTransaction;


/**
 * Any class that's an upgradable object should implement this interface.
 * It provides getters to access the current level of the upgradable object and setters to be able to change it.
 * <br>
 * This getter should only ever be invoked from the corresponding controller class of the specific upgradable object
 * to ensure the program is complying with the model view controller paradigm.
 *
 * @param <T> The leveling enum that the upgradable object corresponds to. For instance, if an implementation of this
 *            interface is an "Artifact", the corresponding leveling enum would be something like "ArtifactLevel".
 *
 * @author Vincent Wolf, Lasse-Leander Hillen, Timothy Hoegen-Jupp, Alexander Goethel
 * @version 1.1.0
 * @since 06.06.2024
 */
public interface Upgradable<T>
{

	/**
	 * Returns the current level of the upgradable object.
	 *
	 * @return The current level.
	 *
	 * @precondition The upgradable object has a valid level attribute of type {@link T}.
	 * @postcondition The current level of the upgradable object.
	 */
	T getLevel ();


	/**
	 * Sets the current level of the upgradable object to a new value.
	 *
	 * @param level The new level of the object.
	 *
	 * @precondition The upgradable object has a valid level attribute of type {@link T} and an object of type {@link T} is passed.
	 * @postcondition The current level of the upgradable object is set to the passed one.
	 */
	void setLevel (final T level);


	/**
	 * Returns an instance of {@link CurrencyTransaction} that consists of the upgrade costs that are required to
	 * upgrade the upgradable object to the next level.
	 *
	 * @return The upgrade costs to upgrade the upgradable object to the next level.
	 *
	 * @precondition The upgradable object has a valid {@link CurrencyTransaction} attribute that resembles the upgrade cost.
	 * @postcondition The {@link CurrencyTransaction} attribute that resembles the upgrade cost has been returned.
	 */
	CurrencyTransaction getUpgradeCosts ();


	/**
	 * Sets the current upgrade costs of the upgradable object to a new value.
	 * <br>
	 * This method should usually be invoked whenever the upgradable object was upgraded, as the upgrade cost to
	 * upgrade to the next level usually changes after the building was upgraded, because the next level is usually
	 * more expensive than the level previously upgraded to.
	 *
	 * @param upgradeCosts The upgrade costs to upgrade the upgradable object to the next level.
	 *
	 * @precondition The upgradable object has a valid {@link CurrencyTransaction} attribute that resembles the
	 * upgrade cost and a {@link CurrencyTransaction} is passed.
	 * @postcondition The {@link CurrencyTransaction} attribute of the upgradable object is set to the passed one.
	 */
	void setUpgradeCosts (final CurrencyTransaction upgradeCosts);


	/**
	 * Returns an instance of {@link CurrencyTransaction} that consists of the upgrade costs that are required to
	 * upgrade the upgradable object to the next level.
	 * <br>
	 * Takes the supplied {@link Level} into account and returns the upgrade costs
	 * {@link CurrencyTransaction} for the next level that comes after the supplied {@link Level}.
	 *
	 * @param level The {@link Level} whose upgrade costs {@link CurrencyTransaction} should be returned.
	 *
	 * @return The upgrade costs to upgrade the upgradable object to the next level.
	 *
	 * @precondition The upgradable object has a valid {@link CurrencyTransaction} attribute that resembles the
	 * upgrade cost and a level of type {@link T} is passed.
	 * @postcondition The {@link CurrencyTransaction} attribute of the upgradable object at the level has been returned.
	 */
	CurrencyTransaction getUpgradeCosts (final T level);

}
