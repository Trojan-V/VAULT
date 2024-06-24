package me.vault.game.model.troop;


import javafx.beans.property.SimpleBooleanProperty;


public enum Faction
{
	EXPLORER_ASSOCIATION(1.2f, 1.0f, 1.5f, new SimpleBooleanProperty(false)),

	MILITARISTIC_GOVERNMENT(1.25f, 1.5f, 1.0f, new SimpleBooleanProperty(false)),

	MEGA_CORPORATION(1.5f, 1.25f, 1.25f, new SimpleBooleanProperty(false)),

	NEW_TERRA(1.25f, 1.25f, 1.25f, new SimpleBooleanProperty(false));


	private final SimpleBooleanProperty isSelectedProperty;

	private final float offensiveLevelMultiplier;

	private final float defensiveLevelMultiplier;

	private final float dexterityLevelMultiplier;


	Faction (final float offensiveLevelMultiplier, final float defensiveLevelMultiplier, final float dexterityLevelMultiplier, final SimpleBooleanProperty isSelectedProperty)
	{
		this.offensiveLevelMultiplier = offensiveLevelMultiplier;
		this.defensiveLevelMultiplier = defensiveLevelMultiplier;
		this.dexterityLevelMultiplier = dexterityLevelMultiplier;
		this.isSelectedProperty = isSelectedProperty;
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


	public SimpleBooleanProperty getIsSelectedProperty ()
	{
		return this.isSelectedProperty;
	}
}

