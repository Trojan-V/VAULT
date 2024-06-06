package me.vault.game.artifact;


import me.vault.game.currency.Currency;
import me.vault.game.currency.CurrencyController;
import me.vault.game.currency.CurrencyTransaction;
import me.vault.game.interfaces.IUpgrader;
import me.vault.game.utility.logging.ILogger;
import me.vault.game.utility.logging.Logger;

import java.text.MessageFormat;

import static me.vault.game.utility.constant.LoggingConstants.Artifact.*;
import static me.vault.game.utility.logging.ILogger.Level.DEBUG;


/**
 * @since 23.05.2024
 */
public final class ArtifactController implements IUpgrader<AbsArtifact, ArtifactLevel>
{
	/**
	 * Singleton instance, as there will never be a reason to have more than one {@link ArtifactController}.
	 * <br>
	 * Instead of using a singleton, the entire class could've been created using solely static methods and fields.
	 */
	private static final ArtifactController INSTANCE = new ArtifactController();


	/**
	 * The logger object for this class used for writing to the console.
	 *
	 * @see Logger
	 */
	private static final ILogger LOGGER = new Logger(ArtifactController.class.getSimpleName());


	/**
	 * As this class is a singleton, no other class should be able to instantiate it.
	 * <br>
	 * To prohibit the instantiation from anywhere else but within the class, a private constructor is used.
	 */
	private ArtifactController ()
	{}


	private static boolean checkIsArtifactMaxed (final AbsArtifact artifact)
	{
		return artifact.getLevel() == ArtifactLevel.getMaximumArtifactLevel();
	}


	public static ArtifactController getInstance ()
	{
		return INSTANCE;
	}


	@Override
	public void upgrade (final AbsArtifact artifact)
	{
		LOGGER.log(DEBUG, MessageFormat.format(UPGRADE_METHOD_ENTERED_MSG, artifact.getName()));


		// Validate that the artifact can actually be upgraded.
		if (! this.checkIsUpgradable(artifact))
		{
			return;
		}

		// Now it's known that the artifact can be upgraded.
		// The upgrade costs are factored in now (see Javadoc of this method for more information).
		CurrencyController.factorCurrencyTransaction(artifact.getCurrentUpgradeCost());


		// The level of the artifact is changed to the next level, so it's getting upgraded now.
		LOGGER.log(DEBUG, MessageFormat.format(CURRENT_ARTIFACT_LEVEL_MSG, artifact.getLevel().toString()));


		artifact.setLevel(ArtifactLevel.getNextHigherLevel(artifact.getLevel()));
		artifact.updateProperties();

		LOGGER.log(DEBUG, MessageFormat.format(UPGRADED_ARTIFACT_LEVEL_MSG, artifact.getLevel().toString()));
	}


	@Override
	public boolean checkIsUpgradable (final AbsArtifact artifact)
	{
		LOGGER.log(DEBUG, MessageFormat.format(CHECK_IS_UPGRADABLE_METHOD_ENTERED_MSG, artifact.getName()));


		// Checks if the artifact is already at the maximum level. If yes, it can't be upgraded any further.
		if (artifact.getLevel() == ArtifactLevel.getMaximumArtifactLevel())
		{
			LOGGER.log(DEBUG, "The artifact is already at the maximum level and can't be upgraded any further.");
			return false;
		}

		// Checks if the user has enough of each required currency to purchase the upgrade. If the amount of at least
		// one currency isn't enough, the artifact can't be upgraded.
		final CurrencyTransaction upgradeCosts = artifact.getCurrentUpgradeCost();
		LOGGER.log(DEBUG, MessageFormat.format(UPGRADE_COSTS_MSG, upgradeCosts.toString()));
		for (final Currency currency : Currency.values())
		{
			if (currency.getAmount() < upgradeCosts.getAbsoluteAmount(currency))
			{
				LOGGER.log(DEBUG, "The available amount of " + currency.name() + " isn't enough to" +
				                  " perform the requested upgrade. The cost for the upgrade is at " +
				                  upgradeCosts.getAmount(currency) + " " + currency.name());
				return false;
			}
		}

		// If all checks are passed, the method returns true.
		LOGGER.log(DEBUG,
			"The artifact can be upgraded to the next level, leaving the checkIsUpgradable() method.");
		return true;
	}
}
