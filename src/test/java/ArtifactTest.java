import me.vault.vaultgame.controller.ArtifactController;
import me.vault.vaultgame.model.artifact.Artifact;
import me.vault.vaultgame.model.currency.Currency;
import me.vault.vaultgame.utility.Logger;

import static me.vault.vaultgame.utility.constant.CharacterConstants.WHITESPACE;

/**
 * Description
 *
 * @author Vincent Wolf
 * @version 1.0.0
 * @see
 * @since 15.05.2024
 */
public final class ArtifactTest
{
	private static final Logger LOGGER = new Logger(ArtifactTest.class.getName());
	public static final String UPGRADED_MESSAGE = "The artifact was upgraded.";
	public static final int UPGRADE_TEST_AMOUNT = 1000;
	public static final String AMOUNTS_STARTING = "Currency-Amounts starting:";


	private ArtifactTest () {}


	public static void main (final String[] args)
	{
		testArtifactUpgrade();
	}


	private static void testArtifactUpgrade ()
	{
		// Currencies are set to specified value
		for (final Currency currency : Currency.values())
		{
			currency.setAmount(UPGRADE_TEST_AMOUNT);
		}

		// Currency-amounts are logged
		LOGGER.logNormal(AMOUNTS_STARTING);
		logCurrencyAmounts();

		for (final Artifact artifact : Artifact.values())
		{
			LOGGER.logDebug(artifact.name() + WHITESPACE + artifact.getLevel());

			ArtifactController.getInstance().upgrade(artifact);
			LOGGER.logDebug(UPGRADED_MESSAGE);
			LOGGER.logDebug(artifact.name() + WHITESPACE + artifact.getLevel());

			// Currency-amounts are logged
			logCurrencyAmounts();
		}
	}


	private static void logCurrencyAmounts ()
	{
		final StringBuilder currencyString = new StringBuilder();
		for (final Currency currency : Currency.values())
		{
			currencyString.append(currency.toString()).append(WHITESPACE);
		}
		LOGGER.logNormal(currencyString.toString());
	}

}
