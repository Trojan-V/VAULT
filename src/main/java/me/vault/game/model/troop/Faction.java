package me.vault.game.model.troop;


public enum Faction
{
	EXPLORER_ASSOCIATION(1.2, 1, 1),

	MILITARISTIC_GOVERNMENT(1, 1, 1),

	MEGA_CORPORATION(1, 1, 1),

	NEW_TERRA(1, 1, 1);


	Faction (final double offensiveLevelMultiplier, final double defensiveLevelMultiplier, final double dexterityLevelMultiplier)
	{
		this.offensiveLevelMultiplier = offensiveLevelMultiplier;
		this.defensiveLevelMultiplier = defensiveLevelMultiplier;
		this.dexterityLevelMultiplier = dexterityLevelMultiplier;
	}


	private final double offensiveLevelMultiplier;

	private final double defensiveLevelMultiplier;

	private final double dexterityLevelMultiplier;


	public double getOffensiveLevelMultiplier ()
	{
		return this.offensiveLevelMultiplier;
	}


	public double getDefensiveLevelMultiplier ()
	{
		return this.defensiveLevelMultiplier;
	}


	public double getDexterityLevelMultiplier ()
	{
		return this.dexterityLevelMultiplier;
	}
}

