package me.vault.vaultgame.controller;

import me.vault.vaultgame.model.artifact.Artifact;
import me.vault.vaultgame.model.artifact.ArtifactLevel;
import me.vault.vaultgame.model.artifact.ArtifactProperties;
import me.vault.vaultgame.model.currency.Currency;
import me.vault.vaultgame.model.currency.CurrencyTransaction;
import me.vault.vaultgame.model.interfaces.IUpgrader;

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


	private ArtifactController ()
	{}


	@Override
	public void upgrade (final Artifact artifact)
	{
		if (!checkIsUpgradable(artifact))
		{
			return;
		}
		// The costs of the upgrade are factored in
		CurrencyController.factorCurrencyTransaction(artifact.getCurrentProperties().getUpgradeCosts());

		// The level of the artifact is changed
		artifact.setLevel(ArtifactLevel.SUPER);
	}


	public boolean checkIsUpgradable (final Artifact artifact)
	{
		// Checks if the artifact is already at the maximum level
		if (artifact.getLevel() == ArtifactLevel.SUPER)
		{
			return false;
		}

		// Checks if the user has enough currency to purchase the upgrade
		CurrencyTransaction upgradeCosts = artifact.getCurrentProperties().getUpgradeCosts();
		for (Currency providedCurrency : Currency.values())
		{
			if (providedCurrency.getAmount() < upgradeCosts.getAmount(providedCurrency))
			{
				return false;
			}
		}

		// If all checks are passed, the method returns true
		return true;
	}


	public static ArtifactController getInstance ()
	{
		return INSTANCE;
	}

}
