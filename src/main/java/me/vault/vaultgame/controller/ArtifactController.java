package me.vault.vaultgame.controller;


import me.vault.vaultgame.model.artifact.Artifact;
import me.vault.vaultgame.model.artifact.ArtifactLevel;
import me.vault.vaultgame.model.artifact.ArtifactProperties;
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
	public void upgrade (final Artifact upgradable)
	{

	}


	public boolean checkIsUpgradable (final Artifact artifact)
	{
		// Check if enough resources are there.
		return false;
	}


	public static ArtifactController getInstance ()
	{
		return INSTANCE;
	}
}
