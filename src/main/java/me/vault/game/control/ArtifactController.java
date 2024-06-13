package me.vault.game.control;


import me.vault.game.interfaces.Upgrader;
import me.vault.game.model.artifact.Artifact;
import me.vault.game.model.artifact.ArtifactLevel;
import me.vault.game.model.artifact.AttributeMultiplier;
import me.vault.game.model.currency.Currency;
import me.vault.game.model.currency.CurrencyTransaction;
import me.vault.game.utility.logging.ILogger;
import me.vault.game.utility.logging.Logger;

import static me.vault.game.utility.constant.NewLoggingConstants.Artifact.*;
import static me.vault.game.utility.constant.NewLoggingConstants.*;
import static me.vault.game.utility.logging.ILogger.Level.DEBUG;


/**
 * @author Vincent Wolf, Lasse-Leander Hillen
 * @version 1.0.0
 * @see Upgrader
 * @see Artifact
 * @see ArtifactLevel
 * @since 23.05.2024
 */
public final class ArtifactController implements Upgrader<Artifact, ArtifactLevel>
{

	/**
	 * Singleton instance, as there's no reason to have more than one {@link ArtifactController}.
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
	{
	}


	/**
	 * Checks if the supplied artifact is at the maximum level. If yes, true is returned, otherwise false.
	 *
	 * @param artifact The instance of {@link Artifact} which is checked.
	 *
	 * @return True if the artifact is maxed, otherwise false.
	 */
	private static boolean checkIsArtifactMaxed (final Artifact artifact)
	{
		return artifact.getLevel() == ArtifactLevel.getMaximum();
	}


	/**
	 * Returns the singleton instance of this class.
	 *
	 * @return The singleton instance of this class.
	 */
	public static ArtifactController getInstance ()
	{
		return INSTANCE;
	}


	@Override
	public void updatePropertyValues (final Artifact artifact)
	{
		artifact.getNameProperty().set(artifact.getAllNames().get(artifact.getLevel()));
		artifact.getSpriteProperty().set(artifact.getAllSprites().get(artifact.getLevel()));
		artifact.setCurrentUpgradeCosts(artifact.getAllUpgradeCosts().get(artifact.getLevel()));
		artifact.getAttributeModifiers().getDamageMultiplierProperty()
				.set(artifact.getAllModifiers().get(artifact.getLevel()).get(AttributeMultiplier.Type.DAMAGE));
		artifact.getAttributeModifiers().getHealthMultiplierProperty()
				.set(artifact.getAllModifiers().get(artifact.getLevel()).get(AttributeMultiplier.Type.HEALTH));
		artifact.getAttributeModifiers().getDefenseMultiplierProperty()
				.set(artifact.getAllModifiers().get(artifact.getLevel()).get(AttributeMultiplier.Type.DEFENSE));

		// Logging output
		LOGGER.logf(DEBUG, NAME_PROPERTY_SET, artifact.getNameProperty().get());
		LOGGER.logf(DEBUG, SPRITE_PROPERTY_SET, artifact.getSpriteProperty().get().toString());
		LOGGER.logf(DEBUG, UPGRADE_COST_SET, artifact.getCurrentUpgradeCosts().toString());
	}


	/**
	 * {@inheritDoc}
	 *
	 * @param artifact The {@link Artifact} instance which is checked if it can be upgraded to the next level.
	 *
	 * @return True if the {@link Artifact} can be upgraded, otherwise false.
	 */
	@Override
	public boolean checkIsUpgradable (final Artifact artifact)
	{
		// Checks if the artifact is already at the maximum level. If yes, it can't be upgraded any further.
		if (checkIsArtifactMaxed(artifact))
		{
			LOGGER.logf(DEBUG, ARTIFACT_MAXED, artifact.getName());
			LOGGER.log(DEBUG, RETURNING_FALSE);
			return false;
		}

		final CurrencyTransaction upgradeCosts = artifact.getCurrentUpgradeCosts();
		LOGGER.logf(DEBUG, UPGRADE_COST, upgradeCosts.toString());


		// Checks if the user has enough of each required currency to purchase the upgrade. If the amount of at least
		// one currency isn't enough, the artifact can't be upgraded.
		for (final Currency currency : Currency.values())
		{
			if (currency.getAmount() < upgradeCosts.getAbsoluteAmount(currency))
			{
				LOGGER.logf(DEBUG, INSUFFICIENT_CURRENCY_AMOUNT, currency.name(), upgradeCosts.getAmount(currency));
				LOGGER.log(DEBUG, RETURNING_FALSE);
				return false;
			}
		}
		// If all checks are passed, the method returns true.
		LOGGER.log(DEBUG, RETURNING_TRUE);
		return true;
	}


	/**
	 * {@inheritDoc}
	 *
	 * @param artifact The {@link Artifact} instance that gets upgraded.
	 */
	@Override
	public void upgrade (final Artifact artifact)
	{
		// Validate that the artifact can actually be upgraded.
		if (! this.checkIsUpgradable(artifact))
		{
			return;
		}

		// Now it's known that the artifact can be upgraded, so the upgrade costs are factored into the account.
		CurrencyController.factorCurrencyTransaction(artifact.getCurrentUpgradeCosts());

		// The level of the artifact is changed to the next level, so it's getting upgraded now.
		LOGGER.logf(DEBUG, CURRENT_ARTIFACT_LEVEL, artifact.getLevel().toString());

		artifact.setLevel(artifact.getLevel().getNextHigherLevel());
		this.updatePropertyValues(artifact);

		LOGGER.logf(DEBUG, UPGRADED_ARTIFACT_LEVEL, artifact.getLevel().toString());
	}

}