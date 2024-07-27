package me.vault.game.model.troop;


import javafx.beans.property.SimpleIntegerProperty;


public class OffensiveStatistics
{

	private final SimpleIntegerProperty energyPoints;

	private final SimpleIntegerProperty meleeDamage;

	private final SimpleIntegerProperty grenadeDamage;

	private final SimpleIntegerProperty grenadeAmount;

	private final SimpleIntegerProperty grenadeRange;


	public OffensiveStatistics (final int energyPoints, final int meleeDamage, final int grenadeDamage, final int grenadeAmount, final int grenadeRange)
	{
		this.energyPoints = new SimpleIntegerProperty(energyPoints);
		this.meleeDamage = new SimpleIntegerProperty(meleeDamage);
		this.grenadeDamage = new SimpleIntegerProperty(grenadeDamage);
		this.grenadeAmount = new SimpleIntegerProperty(grenadeAmount);
		this.grenadeRange = new SimpleIntegerProperty(grenadeRange);
	}


	public OffensiveStatistics (final OffensiveStatistics offensiveStatistics)
	{
		this.energyPoints = new SimpleIntegerProperty(offensiveStatistics.getEnergyPoints());
		this.meleeDamage = new SimpleIntegerProperty(offensiveStatistics.getMeleeDamage());
		this.grenadeDamage = new SimpleIntegerProperty(offensiveStatistics.getGrenadeDamage());
		this.grenadeAmount = new SimpleIntegerProperty(offensiveStatistics.getGrenadeAmount());
		this.grenadeRange = new SimpleIntegerProperty(offensiveStatistics.getGrenadeRange());
	}


	public int getEnergyPoints ()
	{
		return this.energyPoints.get();
	}


	public void setEnergyPoints (final int energyPoints)
	{
		this.energyPoints.set(energyPoints);
	}


	public void setEnergyPoints (final float energyPoints)
	{
		this.energyPoints.set(Math.round(energyPoints));
	}


	public SimpleIntegerProperty getEnergyPointsProperty ()
	{
		return this.energyPoints;
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


	public int getGrenadeDamage ()
	{
		return this.grenadeDamage.get();
	}


	public void setGrenadeDamage (final int grenadeDamage)
	{
		this.grenadeDamage.set(grenadeDamage);
	}


	public void setGrenadeDamage (final float grenadeDamage)
	{
		this.grenadeDamage.set(Math.round(grenadeDamage));
	}


	public SimpleIntegerProperty getGrenadeDamageProperty ()
	{
		return this.grenadeDamage;
	}


	public int getGrenadeAmount ()
	{
		return this.grenadeAmount.get();
	}


	public void setGrenadeAmount (final int grenadeAmount)
	{
		this.grenadeAmount.set(grenadeAmount);
	}


	public void setGrenadeAmount (final float grenadeAmount)
	{
		this.grenadeAmount.set(Math.round(grenadeAmount));
	}


	public SimpleIntegerProperty getGrenadeAmountProperty ()
	{
		return this.grenadeAmount;
	}


	public int getGrenadeRange ()
	{
		return this.grenadeRange.get();
	}


	public void setGrenadeRange (final int grenadeRange)
	{
		this.grenadeRange.set(grenadeRange);
	}


	public void setGrenadeRange (final float grenadeRange)
	{
		this.grenadeRange.set(Math.round(grenadeRange));
	}


	public SimpleIntegerProperty getGrenadeRangeProperty ()
	{
		return this.grenadeRange;
	}

}
