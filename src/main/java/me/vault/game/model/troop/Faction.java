package me.vault.game.model.troop;


public enum Faction
{
	EXPLORER_ASSOCIATION(1.5f, 1.5f, 1.5f),

	MILITARISTIC_GOVERNMENT(1.5f, 1.5f, 1.5f),

	MEGA_CORPORATION(1.5f, 1.5f, 1.5f),

	NEW_TERRA(1.5f, 1.5f, 1.5f);


	private final float offensiveLevelMultiplier;

	private final float defensiveLevelMultiplier;

	private final float dexterityLevelMultiplier;


	Faction (final float offensiveLevelMultiplier, final float defensiveLevelMultiplier, final float dexterityLevelMultiplier)
	{
		this.offensiveLevelMultiplier = offensiveLevelMultiplier;
		this.defensiveLevelMultiplier = defensiveLevelMultiplier;
		this.dexterityLevelMultiplier = dexterityLevelMultiplier;
	}


	public float getOffensiveLevelMultiplier ()
	{
		return this.offensiveLevelMultiplier;
	}


	public float getDefensiveLevelMultiplier ()
	{
		return this.defensiveLevelMultiplier;
	}


	public float getDexterityLevelMultiplier ()
	{
		return this.dexterityLevelMultiplier;
	}
}

