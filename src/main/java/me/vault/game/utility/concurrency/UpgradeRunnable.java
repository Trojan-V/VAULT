package me.vault.game.utility.concurrency;


import me.vault.game.model.artifact.Artifact;
import me.vault.game.model.currency.CurrencyTransaction;
import me.vault.game.utility.interfaces.Level;
import me.vault.game.utility.interfaces.Upgradable;
import me.vault.game.utility.interfaces.Upgrader;
import me.vault.game.view.city.CurrencyDelegate;

import java.text.MessageFormat;


/**
 * This class is used to create concurrent behavior for the upgrading process.
 * <br>
 * To achieve that behavior, this class implements the {@link Runnable} interface.
 *
 * @author Vincent Wolf
 * @version 1.0.0
 * @see Runnable
 * @since 30.07.2024
 */
public class UpgradeRunnable implements Runnable
{

	/**
	 * The {@link MessageFormat} pattern, which is used, when the {@link Artifact#toString()} is
	 * called.
	 */
	private static final String TO_STRING_PATTERN = "UpgradeRunnable[upgradable={0}, upgrader={1}]";


	/**
	 * The {@link Upgrader} instance that provides an {@link Upgrader#upgrade(Upgradable)} method so the {@link UpgradeRunnable#upgradable} can be upgraded.
	 */
	private final Upgrader<Upgradable<Level>, Level> upgrader;


	/**
	 * The {@link Upgradable} that'll be upgraded.
	 */
	private final Upgradable<Level> upgradable;


	/**
	 * Constructs an instance of this class.
	 *
	 * @param upgradable The {@link Upgradable} instance that'll be upgraded by the {@link Upgrader}.
	 * @param upgrader   The {@link Upgrader} that provides the upgrade() method to upgrade the {@link Upgradable}.
	 *
	 * @precondition The constructor is invoked and an {@link Upgradable} and {@link Upgrader} are supplied as parameter.
	 * @postcondition An instance of this class was constructed.
	 */
	public UpgradeRunnable (final Upgradable upgradable, final Upgrader upgrader)
	{
		this.upgradable = upgradable;
		this.upgrader = upgrader;
	}


	/**
	 * Runs the concurrent upgrading process.
	 *
	 * @precondition {@link UpgradeRunnable#upgradable} and {@link UpgradeRunnable#upgrader} aren't equal to null.
	 * @postcondition The concurrent upgrading process was run.
	 */
	@Override
	public void run ()
	{
		final CurrencyTransaction upgradeCost = this.upgradable.getUpgradeCosts();
		final Level beforeUpgradeLevel = this.upgradable.getLevel();
		final Level afterUpgradeLevel = beforeUpgradeLevel.getNextHigherLevel();
		CurrencyDelegate.factorCurrency(upgradeCost);
		this.upgradable.setLevel(afterUpgradeLevel);
		this.upgrader.updateValues(this.upgradable);
	}


	/**
	 * Builds a formatted {@link String}, which represents the object, and it's current state using the
	 * {@link UpgradeRunnable#TO_STRING_PATTERN}.
	 *
	 * @return A {@link String} which has been formatted in the {@link UpgradeRunnable#TO_STRING_PATTERN}.
	 *
	 * @precondition The {@link UpgradeRunnable#TO_STRING_PATTERN} is {@code != null}.
	 * @postcondition The method returned a {@link String} which represents the object.
	 */
	@Override
	public String toString ()
	{
		return MessageFormat.format(TO_STRING_PATTERN, this.upgradable, this.upgrader);
	}

}
