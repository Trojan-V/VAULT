package me.vault.game.model.energy;


import javafx.beans.property.SimpleBooleanProperty;


public enum MultiplicationFactor
{
	TROOPS(1, 1, 1, new SimpleBooleanProperty(false)),

	PLAYER(1.5f, 1.5f, 1.5f, new SimpleBooleanProperty(false));

	private final SimpleBooleanProperty isSelectedProperty;

	private final float offensiveLevelMultiplier;

	private final float defensiveLevelMultiplier;

	private final float dexterityLevelMultiplier;


	MultiplicationFactor (final float offensiveLevelMultiplier, final float defensiveLevelMultiplier,
		final float dexterityLevelMultiplier, final SimpleBooleanProperty isSelectedProperty)
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
