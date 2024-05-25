package me.vault.vaultgame.model;


import me.vault.vaultgame.model.interfaces.IUpgradable;

import java.util.ArrayList;
import java.util.List;


/**
 * Description
 *
 * @author Vincent Wolf
 * @version 1.0.0
 * @see
 * @since 23.05.2024
 */
public class Artifact implements IUpgradable<ArtifactLevel>
{
	private final List<CurrencyTransaction> upgradeCosts = new ArrayList<>();
	private final String name;
	private ArtifactLevel currentLevel;


	@Override
	public ArtifactLevel getLevel ()
	{
		return this.currentLevel;
	}


	@Override
	public void setLevel (final ArtifactLevel level)
	{
		this.currentLevel = level;
	}



}
