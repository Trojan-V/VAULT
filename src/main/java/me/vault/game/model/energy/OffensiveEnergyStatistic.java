package me.vault.game.model.energy;


import javafx.beans.property.SimpleIntegerProperty;


public class OffensiveEnergyStatistic
{
	private final SimpleIntegerProperty meleeDamage;

	public OffensiveEnergyStatistic (final int meleeDamage)
	{
		this.meleeDamage = new SimpleIntegerProperty(meleeDamage);
	}

	public int getMeleeDamage ()
	{
		return this.meleeDamage.get();
	}


	public void setMeleeDamage (final int meleeDamage)
	{
		this.meleeDamage.set(meleeDamage);
	}


	public void setMeleeDamage (final float meleeDamage)
	{
		this.meleeDamage.set(Math.round(meleeDamage));
	}


	public SimpleIntegerProperty getMeleeDamageProperty ()
	{
		return this.meleeDamage;
	}

}
