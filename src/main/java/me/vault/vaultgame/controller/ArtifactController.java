package me.vault.vaultgame.controller;


import me.vault.vaultgame.model.artifact.Artifact;
import me.vault.vaultgame.model.artifact.ArtifactLevel;
import me.vault.vaultgame.model.artifact.ArtifactProperties;
import me.vault.vaultgame.model.currency.Currency;
import me.vault.vaultgame.model.currency.CurrencyTransaction;
import me.vault.vaultgame.model.interfaces.IUpgrader;
import me.vault.vaultgame.utility.Logger;
import me.vault.vaultgame.utility.Logger.Level;


/**
 * Description
 *
 * @author Vincent Wolf
 * @version 1.0.0
 * @see
 * @since 23.05.2024
 */
public final class ArtifactController implements IUpgrader<Artifact, ArtifactLevel, ArtifactProperties>
{

	private static final ArtifactController INSTANCE = new ArtifactController();


	private static final Logger LOGGER = new Logger(ArtifactController.class.getName());


	private ArtifactController ()
	{}


	private static boolean checkIsArtifactMaxed (final Artifact artifact)
	{
		return artifact.getLevel().ordinal() == ArtifactLevel.values().length - 1;
	}


	public static ArtifactController getInstance ()
	{
		return INSTANCE;
	}


	@Override
	public void upgrade (final Artifact artifact)
	{
		LOGGER.log(Level.DEBUG, "Invoked the upgrade() method for the artifact " + artifact.name());
		if (! this.checkIsUpgradable(artifact))
		{
			return;
		}
		// The costs of the upgrade are factored in
		CurrencyController.factorCurrencyTransaction(artifact.getCurrentProperties().getUpgradeCosts());

		// The level of the artifact is changed to the next level.
		LOGGER.log(Level.DEBUG, "Current artifact level: " + artifact.getLevel().toString());
		artifact.setLevel(ArtifactLevel.values()[artifact.getLevel().ordinal() + 1]);
		LOGGER.log(Level.DEBUG, "Upgraded the artifact to the level: " + artifact.getLevel().toString());
	}


	@Override
	public boolean checkIsUpgradable (final Artifact artifact)
	{
		LOGGER.log(Level.DEBUG, "Invoked the checkIsUpgradable() method for the artifact " + artifact.name());
		// Checks if the artifact is already at the maximum level
		if (checkIsArtifactMaxed(artifact))
		{
			LOGGER.log(Level.DEBUG,
				"The artifact is already at the maximum level and cannot be upgraded any further" + ".");
			return false;
		}

		// Checks if the user has enough currency to purchase the upgrade
		final CurrencyTransaction upgradeCosts = artifact.getCurrentProperties().getUpgradeCosts();
		LOGGER.log(Level.DEBUG, "Upgrade costs: " + upgradeCosts.toString());
		for (final Currency providedCurrency : Currency.values())
		{
			// TODO: Rename providedCurrency to something more intuitive
			if (providedCurrency.getAmount() < upgradeCosts.getAmount(providedCurrency))
			{
				LOGGER.log(Level.DEBUG,
					"The available amount of " + providedCurrency.name() + " is not sufficient " + "to" +
					" perform the requested upgrade. The cost for the upgrade is at " +
					upgradeCosts.getAmount(providedCurrency) + " " + providedCurrency.name());
				return false;
			}
		}

		// If all checks are passed, the method returns true.
		LOGGER.log(Level.DEBUG,
			"The artifact can be upgraded to the next level, leaving the checkIsUpgradable() " + "method.");
		return true;
	}

}
