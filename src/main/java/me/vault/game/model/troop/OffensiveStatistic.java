package me.vault.game.model.troop;


import javafx.beans.property.SimpleIntegerProperty;


public class OffensiveStatistic
{

	private SimpleIntegerProperty energyPoints;

	private SimpleIntegerProperty meleeDamage;

	private SimpleIntegerProperty grenadeDamage;

	private SimpleIntegerProperty grenadeAmount;

	private SimpleIntegerProperty grenadeRange;


	public OffensiveStatistic (final int energyPoints, final int meleeDamage, final int grenadeDamage, final int grenadeAmount, final int grenadeRange)
	{
		this.energyPoints = new SimpleIntegerProperty(energyPoints);
		this.meleeDamage = new SimpleIntegerProperty(meleeDamage);
		this.grenadeDamage = new SimpleIntegerProperty(grenadeDamage);
		this.grenadeAmount = new SimpleIntegerProperty(grenadeAmount);
		this.grenadeRange = new SimpleIntegerProperty(grenadeRange);
	}


	public int getEnergyPoints ()
	{
		return this.energyPoints.get();
	}


	public SimpleIntegerProperty getEnergyPointsProperty ()
	{
		return this.energyPoints;
	}


	public void setEnergyPoints (final int energyPoints)
	{
		this.energyPoints.set(energyPoints);
	}


	public int getMeleeDamage ()
	{
		return this.meleeDamage.get();
	}


	public SimpleIntegerProperty getMeleeDamageProperty ()
	{
		return this.meleeDamage;
	}


	public void setMeleeDamage (final int meleeDamage)
	{
		this.meleeDamage.set(meleeDamage);
	}


	public int getGrenadeDamage ()
	{
		return this.grenadeDamage.get();
	}


	public SimpleIntegerProperty getGrenadeDamageProperty ()
	{
		return this.grenadeDamage;
	}


	public void setGrenadeDamage (final int grenadeDamage)
	{
		this.grenadeDamage.set(grenadeDamage);
	}


	public int getGrenadeAmount ()
	{
		return this.grenadeAmount.get();
	}


	public SimpleIntegerProperty getGrenadeAmountProperty ()
	{
		return this.grenadeAmount;
	}


	public void setGrenadeAmount (final int grenadeAmount)
	{
		this.grenadeAmount.set(grenadeAmount);
	}


	public int getGrenadeRange ()
	{
		return this.grenadeRange.get();
	}


	public SimpleIntegerProperty getGrenadeRangeProperty ()
	{
		return this.grenadeRange;
	}


	public void setGrenadeRange (final int grenadeRange)
	{
		this.grenadeRange.set(grenadeRange);
	}

}
