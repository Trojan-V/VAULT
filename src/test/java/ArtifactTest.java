import me.vault.vaultgame.controller.ArtifactController;
import me.vault.vaultgame.model.artifact.Artifact;
import me.vault.vaultgame.model.artifact.ArtifactLevel;
import me.vault.vaultgame.model.currency.Currency;
import me.vault.vaultgame.utility.Logger;
import me.vault.vaultgame.utility.jvm.JvmArgumentParser;
import org.junit.jupiter.api.Assertions;

import java.text.MessageFormat;

import static me.vault.vaultgame.utility.Logger.Level.DEBUG;
import static me.vault.vaultgame.utility.Logger.Level.NORMAL;
import static me.vault.vaultgame.utility.constant.CharacterConstants.DIVIDER;
import static me.vault.vaultgame.utility.constant.CharacterConstants.WHITESPACE;

// TODO: Logs aus der Testklasse in die richtige ArtifactController Klasse verschieben
/**
 * Current covered tests:
 * <br>
 * - Upgrading of artifacts: {@link ArtifactController#upgrade(Artifact)}
 * <br>
 * - Check if the artifacts are actually upgradable: {@link ArtifactController#checkIsUpgradable(Artifact)}
 *
 * @author Vincent Wolf
 * @version 1.0.0
 * @see ArtifactController
 * @see Artifact
 * @since 15.05.2024
 */
public final class ArtifactTest
{
	private static final int UPGRADE_TEST_AMOUNT = 1000;


	private static final String UPGRADED_MESSAGE = "The artifact {0} was upgraded to the level {1}.";


	private static final String AVAILABLE_CURRENCIES_MESSAGE = "Available currencies: ";


	private static final Logger LOGGER = new Logger(ArtifactTest.class.getSimpleName());


	private static final String CURRENT_ARTIFACT_MESSAGE = "Artifact {0} (Level: {1})";


	private static final String ARTIFACT_CAN_BE_UPGRADED_MESSAGE = "The artifact {0} ({1}) can be upgraded: {2}";


	private static final String ARTIFACTS_NOT_UPGRADABLE_AT_BASE_LEVEL_ERROR_MESSAGE =
		"Not all artifacts were upgradable, even though all artifacts have been set to the level " +
		ArtifactLevel.BASE.name() + " before the test was run.";


	private static final String ARTIFACTS_UPGRADABLE_AT_SUPER_LEVEL_ERROR_MESSAGE =
		"At least one Artifact was upgradable, even though all artifacts have been set to the level " +
		ArtifactLevel.SUPER.name() + " before the test was run.";


	private ArtifactTest () {}


	public static void main (final String[] args)
	{
		JvmArgumentParser.apply(args);
		testCheckIsArtifactUpgradable();
		testUpgradeArtifacts();
	}


	private static void testCheckIsArtifactUpgradable ()
	{
		// Test case for non-maxed artifacts
		setArtifactsToLevel(ArtifactLevel.BASE);
		Assertions.assertTrue(checkIfArtifactsAreUpgradable(), ARTIFACTS_NOT_UPGRADABLE_AT_BASE_LEVEL_ERROR_MESSAGE);

		// Test case for super artifacts
		setArtifactsToLevel(ArtifactLevel.SUPER);
		Assertions.assertFalse(checkIfArtifactsAreUpgradable(), ARTIFACTS_UPGRADABLE_AT_SUPER_LEVEL_ERROR_MESSAGE);
	}


	private static boolean checkIfArtifactsAreUpgradable ()
	{
		boolean areAllArtifactsUpgradable = true;
		for (final Artifact artifact : Artifact.values())
		{
			final boolean isUpgradable = ArtifactController.getInstance().checkIsUpgradable(artifact);
			LOGGER.log(DEBUG, MessageFormat.format(ARTIFACT_CAN_BE_UPGRADED_MESSAGE, artifact.name(),
				artifact.getLevel(), isUpgradable));
			if (!isUpgradable)
			{
				areAllArtifactsUpgradable = false;
			}
		}
		return areAllArtifactsUpgradable;
	}


	private static void setArtifactsToLevel (final ArtifactLevel level)
	{
		for (final Artifact artifact : Artifact.values())
		{
			artifact.setLevel(level);
		}
	}


	private static void testUpgradeArtifacts ()
	{
		// Set the artifact level to the base level before testing, as otherwise testing upgrading wouldn't make sense.
		setArtifactsToLevel(ArtifactLevel.BASE);

		setStartingCurrencyAmounts();
		LOGGER.log(DEBUG, AVAILABLE_CURRENCIES_MESSAGE + getCurrentCurrencyAmounts());
		LOGGER.log(NORMAL, DIVIDER);

		upgradeAllArtifacts();
		upgradeAllArtifacts();
	}


	private static void upgradeAllArtifacts ()
	{
		for (final Artifact artifact : Artifact.values())
		{
			final ArtifactLevel previousActifactLevel = artifact.getLevel();

			LOGGER.log(DEBUG, MessageFormat.format(CURRENT_ARTIFACT_MESSAGE, artifact.name(), artifact.getLevel()));
			ArtifactController.getInstance().upgrade(artifact);

			// Would become more complex logic here if more than two levels would exist.
			Assertions.assertEquals(ArtifactLevel.SUPER, artifact.getLevel(),
				"The artifact level is not equal to " + ArtifactLevel.SUPER + ", although it always should be, " +
				"because either the level was upgraded if the artifact was at the base level before, or it should " +
				"stay at " + ArtifactLevel.SUPER + " because there is no higher level than super at the moment.");

			LOGGER.log(DEBUG, MessageFormat.format(UPGRADED_MESSAGE, artifact.name(), artifact.getLevel()));
			LOGGER.log(DEBUG, AVAILABLE_CURRENCIES_MESSAGE + getCurrentCurrencyAmounts());
			LOGGER.log(NORMAL, DIVIDER);
		}
	}


	private static void setStartingCurrencyAmounts ()
	{
		// Currencies are set to specified value
		for (final Currency currency : Currency.values())
		{
			currency.setAmount(UPGRADE_TEST_AMOUNT);
		}
	}


	private static String getCurrentCurrencyAmounts ()
	{
		final StringBuilder currencyString = new StringBuilder();
		for (final Currency currency : Currency.values())
		{
			currencyString.append(currency.toString()).append(WHITESPACE);
		}
		return currencyString.toString();
	}
}
