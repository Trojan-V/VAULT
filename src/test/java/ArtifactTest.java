import me.vault.game.artifact.ArtifactController;
import me.vault.game.artifact.Artifact;
import me.vault.game.artifact.ArtifactLevel;
import me.vault.game.currency.Currency;
import me.vault.game.currency.CurrencyTransaction;
import me.vault.game.utility.jvm.JvmArgumentParser;
import org.junit.jupiter.api.Assertions;
import util.TestUtil;

import java.text.MessageFormat;

import static me.vault.game.utility.constant.CharacterConstants.WHITESPACE;
import static me.vault.game.utility.constant.LoggingConstants.Artifact.*;

// TODO: Logs aus der Testklasse in die richtige ArtifactController Klasse verschieben


/**
 * <u>Tests covered by this class</u> <br>
 * - Upgrading of artifacts: {@link ArtifactController#upgrade(Artifact)} (Also checks if the currencies are deducted
 * correctly after an upgrade has been made) <br> - Check if the artifacts are actually upgradable:
 * {@link ArtifactController#checkIsUpgradable(Artifact)}
 *
 * @author Vincent Wolf
 * @version 1.0.0
 * @see ArtifactController
 * @see Artifact
 * @since 15.05.2024
 */
public final class ArtifactTest
{
	private static final String ARTIFACTS_NOT_UPGRADABLE_AT_BASE_LEVEL_ERROR_MESSAGE =
		"Not all artifacts were upgradable, even though all artifacts have been set to the level " +
		ArtifactLevel.BASE.name() + " before the test was run.";


	private static final String ARTIFACTS_UPGRADABLE_AT_SUPER_LEVEL_ERROR_MESSAGE =
		"At least one Artifact was upgradable, even though all artifacts have been set to the level " +
		ArtifactLevel.SUPER.name() + " before the test was run.";


	public static final String INVALID_CURRENCY_AMOUNT_AFTER_UPGRADE_MESSAGE =
		"The amount of {0} after the upgrade was performed was not deducted by the correct amount (Correct " +
		" deduction amount: {1, number, integer} - Upgrade cost of the artifact). " + "\nAmount of {0} before " +
		"the upgrade was performed = {2}; Amount of {0} after the upgrade was performed " +
		"= {3}; Current artifact level = {4}";


	private static final String ARTIFACT_LEVEL_IS_NOT_SUPER_AFTER_UPGRADE_MESSAGE =
		"The artifact level is not equal to " + ArtifactLevel.SUPER + ", although it always should be, " +
		"because either the level was upgraded if the artifact was at the base level before, or it should " +
		"stay at " + ArtifactLevel.SUPER + " because there is no higher level than super at the moment.";


	private ArtifactTest () {}


	public static void main (final String[] args)
	{
		JvmArgumentParser.apply(args);
		testCheckIsArtifactUpgradable();
		testUpgradeArtifacts();
		testArtifactLevelGetters();
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
			if (!ArtifactController.getInstance().checkIsUpgradable(artifact))
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
		TestUtil.setStartingCurrencyAmounts();
		upgradeAllArtifacts();
		upgradeAllArtifacts();
	}


	private static void upgradeAllArtifacts ()
	{
		for (final Artifact artifact : Artifact.values())
		{
			final int steelAmountBeforeUpgrade = Currency.STEEL.getAmount();
			final int compositeAmountBeforeUpgrade = Currency.COMPOSITE.getAmount();
			final int energyCreditAmountBeforeUpgrade = Currency.ENERGY_CREDIT.getAmount();
			final int foodRationAmountBeforeUpgrade = Currency.FOOD_RATION.getAmount();
			final int scienceAmountBeforeUpgrade = Currency.SCIENCE.getAmount();

			final ArtifactLevel artifactLevelBeforeUpgrade = artifact.getLevel();

			final CurrencyTransaction upgradeCosts = artifact.getCurrentProperties().getUpgradeCosts();
			final int steelUpgradeCost = upgradeCosts.getAmount(Currency.STEEL);
			final int compositeUpgradeCost = upgradeCosts.getAmount(Currency.COMPOSITE);
			final int energyCreditUpgradeCost = upgradeCosts.getAmount(Currency.ENERGY_CREDIT);
			final int foodRationUpgradeCost = upgradeCosts.getAmount(Currency.FOOD_RATION);
			final int scienceUpgradeCost = upgradeCosts.getAmount(Currency.SCIENCE);

			ArtifactController.getInstance().upgrade(artifact);


			// Would become more complex logic here if more than two levels would exist.
			Assertions.assertEquals(ArtifactLevel.SUPER, artifact.getLevel(), ARTIFACT_LEVEL_IS_NOT_SUPER_AFTER_UPGRADE_MESSAGE);

			// If the artifact level is already maxed, there is no point in continuing with the currency deduction
			// assertions, as there is no further upgrade to make and therefore no currencies will be deducted in
			// this case.
			if (artifactLevelBeforeUpgrade == ArtifactLevel.getMaximumArtifactLevel())
			{
				return;
			}

			// Validate that the currency amounts have been deducted by the upgrade costs of the artifact.
			Assertions.assertEquals(Currency.STEEL.getAmount(), steelAmountBeforeUpgrade +
			                                                    steelUpgradeCost,
				MessageFormat.format(INVALID_CURRENCY_AMOUNT_AFTER_UPGRADE_MESSAGE, Currency.STEEL.name(),
					steelUpgradeCost, steelAmountBeforeUpgrade, Currency.STEEL.getAmount(), artifact.getLevel()
				.name()));

			Assertions.assertEquals(Currency.COMPOSITE.getAmount(), compositeAmountBeforeUpgrade +
			                                                        compositeUpgradeCost,
				MessageFormat.format(INVALID_CURRENCY_AMOUNT_AFTER_UPGRADE_MESSAGE, Currency.COMPOSITE.name(),
					compositeUpgradeCost, compositeAmountBeforeUpgrade, Currency.COMPOSITE.getAmount(),
					artifact.getLevel()
				.name()));

			Assertions.assertEquals(Currency.ENERGY_CREDIT.getAmount(), energyCreditAmountBeforeUpgrade +
			                                                            energyCreditUpgradeCost,
				MessageFormat.format(INVALID_CURRENCY_AMOUNT_AFTER_UPGRADE_MESSAGE, Currency.ENERGY_CREDIT.name(),
					energyCreditUpgradeCost, energyCreditAmountBeforeUpgrade, Currency.ENERGY_CREDIT.getAmount(),
					artifact.getLevel()
				.name()));

			Assertions.assertEquals(Currency.FOOD_RATION.getAmount(), foodRationAmountBeforeUpgrade +
			                                                          foodRationUpgradeCost,
				MessageFormat.format(INVALID_CURRENCY_AMOUNT_AFTER_UPGRADE_MESSAGE, Currency.FOOD_RATION.name(),
					foodRationUpgradeCost, foodRationAmountBeforeUpgrade, Currency.FOOD_RATION.getAmount(),
					artifact.getLevel()
				.name()));

			Assertions.assertEquals(Currency.SCIENCE.getAmount(), scienceAmountBeforeUpgrade +
			                                                      scienceUpgradeCost,
				MessageFormat.format(INVALID_CURRENCY_AMOUNT_AFTER_UPGRADE_MESSAGE, Currency.SCIENCE.name(),
					scienceUpgradeCost, scienceAmountBeforeUpgrade, Currency.SCIENCE.getAmount(), artifact.getLevel()
				.name()));
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


	private static void testArtifactLevelGetters ()
	{
		Assertions.assertEquals(ArtifactLevel.SUPER, ArtifactLevel.getMaximumArtifactLevel(),
			MessageFormat.format(MAX_ARTIFACT_LEVEL_NOT_SUPER_MSG, ArtifactLevel.SUPER.name(),
				ArtifactLevel.getMaximumArtifactLevel()
			.name()));

		Assertions.assertEquals(ArtifactLevel.SUPER, ArtifactLevel.getNextHigherLevel(ArtifactLevel.BASE),
			MessageFormat.format(NEXT_ARTIFACT_LEVEL_INCORRECT_MSG, ArtifactLevel.BASE.name(),
				ArtifactLevel.SUPER.name(), ArtifactLevel.getNextHigherLevel(ArtifactLevel.BASE)
			.name()));

		Assertions.assertEquals(ArtifactLevel.SUPER, ArtifactLevel.getNextHigherLevel(ArtifactLevel.SUPER),
			MessageFormat.format(NEXT_ARTIFACT_LEVEL_INCORRECT_MSG, ArtifactLevel.SUPER.name(),
				ArtifactLevel.SUPER.name(), ArtifactLevel.getNextHigherLevel(ArtifactLevel.SUPER)
			.name()));

		Assertions.assertEquals(ArtifactLevel.BASE, ArtifactLevel.getNextLowerLevel(ArtifactLevel.BASE),
			MessageFormat.format(PREVIOUS_ARTIFACT_LEVEL_INCORRECT_MSG, ArtifactLevel.BASE, ArtifactLevel.BASE,
				ArtifactLevel.getNextLowerLevel(ArtifactLevel.BASE)));

		Assertions.assertEquals(ArtifactLevel.BASE, ArtifactLevel.getNextLowerLevel(ArtifactLevel.SUPER),
			MessageFormat.format(PREVIOUS_ARTIFACT_LEVEL_INCORRECT_MSG, ArtifactLevel.SUPER, ArtifactLevel.BASE,
				ArtifactLevel.getNextLowerLevel(ArtifactLevel.SUPER)));
	}
}
