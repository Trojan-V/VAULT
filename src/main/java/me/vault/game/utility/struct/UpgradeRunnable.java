package me.vault.game.utility.struct;


import me.vault.game.control.CurrencyController;
import me.vault.game.interfaces.Level;
import me.vault.game.interfaces.Upgradable;
import me.vault.game.interfaces.Upgrader;
import me.vault.game.model.currency.CurrencyTransaction;
import me.vault.game.utility.logging.ILogger;
import me.vault.game.utility.logging.Logger;

import java.text.MessageFormat;


/**
 *
 */
public class UpgradeRunnable implements Runnable
{

	private static final ILogger LOGGER = new Logger(UpgradeRunnable.class.getSimpleName());

	private static final String TO_STRING_PATTERN = "UpgradeRunnable[upgradable={0}, upgrader={1}]";

	private final Upgrader<Upgradable<Level>, Level> upgrader;

	private final Upgradable<Level> upgradable;


	public UpgradeRunnable (final Upgradable upgradable, final Upgrader upgrader)
	{
		this.upgradable = upgradable;
		this.upgrader = upgrader;
	}


	/**
	 * Runs this operation.
	 */
	@Override
	public void run ()
	{
		final CurrencyTransaction upgradeCost = this.upgradable.getUpgradeCosts();
		final Level beforeUpgradeLevel = this.upgradable.getLevel();
		final Level afterUpgradeLevel = beforeUpgradeLevel.getNextHigherLevel();

		CurrencyController.factorCurrency(upgradeCost);
		this.upgradable.setLevel(afterUpgradeLevel);
		this.upgrader.updateValues(this.upgradable);
	}


	@Override
	public String toString ()
	{
		return MessageFormat.format(TO_STRING_PATTERN, this.upgradable, this.upgrader);
	}

}
