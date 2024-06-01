package me.vault.game.controller;


import me.vault.game.model.artifact.Artifact;
import me.vault.game.model.artifact.ArtifactLevel;
import me.vault.game.model.artifact.ArtifactProperties;
import me.vault.game.model.currency.Currency;
import me.vault.game.model.currency.CurrencyTransaction;
import me.vault.game.model.interfaces.IUpgrader;
import me.vault.game.utility.logging.ILogger;
import me.vault.game.utility.logging.Logger;

import java.text.MessageFormat;

import static me.vault.game.utility.constant.LoggingConstants.Artifact.*;
import static me.vault.game.utility.logging.ILogger.Level.DEBUG;


/**
 * This class is the controller class for {@link Artifact}'s. It's responsible for any (complex) logic regarding the
 * management of {@link Artifact}'s.
 * <br>
 * It currently provides a method to upgrade artifacts to the next level.
 * <br>
 * The {@link ArtifactController#upgrade(Artifact)} method is exposed by the {@link IUpgrader} interface.
 *
 * @author Vincent Wolf
 * @version 1.0.0
 * @see Artifact
 * @see ArtifactLevel
 * @see ArtifactProperties
 * @since 23.05.2024
 */
public final class ArtifactController implements IUpgrader<Artifact, ArtifactLevel, ArtifactProperties>
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


	private static boolean checkIsArtifactMaxed (final Artifact artifact)
	{
		return artifact.getLevel().ordinal() == ArtifactLevel.values().length - 1;
	}


	public static ArtifactController getInstance ()
	{
		return INSTANCE;
	}


	/**
	 * Attempts to upgrade an artifact to the next {@link ArtifactLevel}.
	 * <br>
	 * Before upgrading, it checks if the artifact can actually be upgraded. For that, the
	 * {@link ArtifactController#checkIsUpgradable(Artifact)} method is invoked.
	 * <br>
	 * If the artifact can be upgraded, the upgrade costs will be factored in (which means that the amount of currency
	 * the player owns will be deducted by this amount for each currency).
	 *
	 * @param artifact The {@link Artifact} which should be upgraded.
	 */
	@Override
	public void upgrade (final Artifact artifact)
	{
		LOGGER.log(DEBUG, MessageFormat.format(UPGRADE_METHOD_ENTERED_MSG, artifact.name()));


		// Validate that the artifact can actually be upgraded.
		if (! this.checkIsUpgradable(artifact))
		{
			return;
		}

		// Now it's known that the artifact can be upgraded.
		// The upgrade costs are factored in now (see Javadoc of this method for more information).
		CurrencyController.factorCurrencyTransaction(artifact.getCurrentProperties().getUpgradeCosts());


		// The level of the artifact is changed to the next level, so it's getting upgraded now.
		LOGGER.log(DEBUG, MessageFormat.format(CURRENT_ARTIFACT_LEVEL_MSG, artifact.getLevel().toString()));
		artifact.setLevel(ArtifactLevel.getNextHigherLevel(artifact.getLevel()));
		LOGGER.log(DEBUG, MessageFormat.format(UPGRADED_ARTIFACT_LEVEL_MSG, artifact.getLevel().toString()));
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean checkIsUpgradable (final Artifact artifact)
	{
		LOGGER.log(DEBUG, MessageFormat.format(CHECK_IS_UPGRADABLE_METHOD_ENTERED_MSG, artifact.name()));


		// Checks if the artifact is already at the maximum level. If yes, it can't be upgraded any further.
		if (artifact.getLevel() == ArtifactLevel.getMaximumArtifactLevel())
		{
			LOGGER.log(DEBUG, "The artifact is already at the maximum level and can't be upgraded any further.");
			return false;
		}

		// Checks if the user has enough of each required currency to purchase the upgrade. If the amount of at least
		// one currency isn't enough, the artifact can't be upgraded.
		final CurrencyTransaction upgradeCosts = artifact.getCurrentProperties().getUpgradeCosts();
		LOGGER.log(DEBUG, MessageFormat.format(UPGRADE_COSTS_MSG, upgradeCosts.toString()));
		for (final Currency currency : Currency.values())
		{
			if (currency.getAmount() < upgradeCosts.getAmount(currency))
			{
				LOGGER.log(DEBUG, "The available amount of " + currency.name() + " is not sufficient " + "to" +
				                  " perform the requested upgrade. The cost for the upgrade is at " +
				                  upgradeCosts.getAmount(currency) + " " + currency.name());
				return false;
			}
		}

		// If all checks are passed, the method returns true.
		LOGGER.log(DEBUG,
			"The artifact can be upgraded to the next level, leaving the checkIsUpgradable() " + "method.");
		return true;
	}
}
