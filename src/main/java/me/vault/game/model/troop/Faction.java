package me.vault.game.model.troop;


public enum Faction
{
	EXPLORER_ASSOCIATION(1.5, 1.5, 1.5),

	MILITARISTIC_GOVERNMENT(1.5, 1.5, 1.5),

	MEGA_CORPORATION(1.5, 1.5, 1.5),

	NEW_TERRA(1.5, 1.5, 1.5);


	private final double offensiveLevelMultiplier;

	private final double defensiveLevelMultiplier;

	private final double dexterityLevelMultiplier;

	Faction (final double offensiveLevelMultiplier, final double defensiveLevelMultiplier, final double dexterityLevelMultiplier)
	{
		this.offensiveLevelMultiplier = offensiveLevelMultiplier;
		this.defensiveLevelMultiplier = defensiveLevelMultiplier;
		this.dexterityLevelMultiplier = dexterityLevelMultiplier;
	}


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

