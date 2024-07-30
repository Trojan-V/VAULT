package me.vault.game.control;


import javafx.application.Platform;
import me.vault.game.interfaces.Upgrader;
import me.vault.game.model.artifact.Artifact;
import me.vault.game.model.artifact.ArtifactLevel;
import me.vault.game.model.artifact.AttributeMultiplier;
import me.vault.game.model.currency.Currency;
import me.vault.game.utility.logging.ILogger;
import me.vault.game.utility.logging.Logger;
import me.vault.game.utility.struct.UpgradeRunnable;

import java.util.Map;

import static me.vault.game.utility.constant.LoggingConstants.CityBuildingController.UPGRADING;


/**
 * This class contains any methods that are responsible for controlling all the logic that's related to artifacts.
 * <br>
 * Currently, it's responsible for upgrading the artifacts to the next level.
 *
 * @author Vincent Wolf, Lasse-Leander Hillen, Timothy Hoegen-Jupp, Alexander Goethel
 * @version 1.0.0
 * @see Upgrader
 * @see Artifact
 * @see ArtifactLevel
 * @since 30.07.2024
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
	 * The {@link Logger} object for this class used for writing to the console.
	 */
	private static final ILogger LOGGER = new Logger(ArtifactController.class.getSimpleName());


	/**
	 * As this class is a singleton, no other class should be able to instantiate it.
	 * <br>
	 * To prohibit the instantiation from anywhere else but within the class, a private constructor is used.
	 *
	 * @precondition Constructor gets called from within the class.
	 * @postcondition A new instance of ArtifactController is created.
	 */
	private ArtifactController ()
	{}


	/**
	 * Checks if the supplied artifact is at the maximum level. If yes, true is returned, otherwise false.
	 *
	 * @param artifact The instance of {@link Artifact} which is checked.
	 *
	 * @return True if the artifact is maxed, otherwise false.
	 *
	 * @precondition An artifact exists.
	 * @postcondition Says if the artifact is at its maximum.
	 */
	private static boolean isArtifactMaxed (final Artifact artifact)
	{
		return artifact.getLevel() == ArtifactLevel.getMaximum();
	}


	/**
	 * Returns the singleton instance of this class.
	 *
	 * @return The singleton instance of this class.
	 *
	 * @precondition The singleton Instance exists.
	 * @postcondition The singleton Instance of this class has been returned.
	 */
	public static ArtifactController getInstance ()
	{
		return INSTANCE;
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updateValues (final Artifact artifact)
	{
		if (isArtifactMaxed(artifact))
		{
			artifact.setIsMaxLevel(true);
		}

		artifact.setName(artifact.getName(artifact.getLevel()));
		artifact.setSprite(artifact.getSprite(artifact.getLevel()));
		artifact.setUpgradeCosts(artifact.getUpgradeCosts(artifact.getLevel()));

		final Map<AttributeMultiplier.Type, Double> attributeMultipliersMap = artifact.getAttributeMultipliers(artifact.getLevel());
		final AttributeMultiplier currentAttributeMultipliers = artifact.getAttributeMultipliers();

		currentAttributeMultipliers.setDamageMultiplier(attributeMultipliersMap.get(AttributeMultiplier.Type.DAMAGE));
		currentAttributeMultipliers.setHealthMultiplier(attributeMultipliersMap.get(AttributeMultiplier.Type.HEALTH));
		currentAttributeMultipliers.setDefenseMultiplier(attributeMultipliersMap.get(AttributeMultiplier.Type.DEFENSE));
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean checkIsUpgradable (final Artifact artifact)
	{
		// Checks if the artifact is already at the maximum level. If yes, it can't be upgraded any further.
		if (artifact.getIsMaxLevelProperty().get())
		{
			return false;
		}

		// Checks if the user has enough of each required currency to purchase the upgrade. If the amount of at least
		// one currency isn't enough, the artifact can't be upgraded.
		for (final Currency currency : Currency.values())
		{
			if (currency.getAmount() < artifact.getUpgradeCosts().getAbsoluteAmount(currency))
			{
				return false;
			}
		}
		return true;
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public void upgrade (final Artifact artifact)
	{
		if (this.checkIsUpgradable(artifact))
		{
			LOGGER.logf(ILogger.Level.NORMAL, UPGRADING, artifact.getName(), artifact.getLevel(), artifact.getLevel().getNextHigherLevel());
			Platform.runLater(new UpgradeRunnable(artifact, getInstance()));
		}

	}

}