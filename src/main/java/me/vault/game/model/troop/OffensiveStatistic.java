package me.vault.game.model.troop;


public class OffensiveStatistic
{

	private int energyPoints;

	private int meleeDamage;

	private int grenadeDamage;

	private int grenadeAmount;

	private int grenadeRange;


	public OffensiveStatistic (final int energyPoints, final int meleeDamage, final int grenadeDamage, final int grenadeAmount, final int grenadeRange)
	{
		this.energyPoints = energyPoints;
		this.meleeDamage = meleeDamage;
		this.grenadeDamage = grenadeDamage;
		this.grenadeAmount = grenadeAmount;
		this.grenadeRange = grenadeRange;
	}


	public int getEnergyPoints ()
	{
		return this.energyPoints;
	}


	public void setEnergyPoints (final int energyPoints)
	{
		this.energyPoints = energyPoints;
	}


	public int getMeleeDamage ()
	{
		return this.meleeDamage;
	}


	public void setMeleeDamage (final int meleeDamage)
	{
		this.meleeDamage = meleeDamage;
	}


	public int getGrenadeDamage ()
	{
		return this.grenadeDamage;
	}


	public void setGrenadeDamage (final int grenadeDamage)
	{
		this.grenadeDamage = grenadeDamage;
	}


	public int getGrenadeAmount ()
	{
		return this.grenadeAmount;
	}


	public void setGrenadeAmount (final int grenadeAmount)
	{
		this.grenadeAmount = grenadeAmount;
	}


	public int getGrenadeRange ()
	{
		return this.grenadeRange;
	}


	public void setGrenadeRange (final int grenadeRange)
	{
		this.grenadeRange = grenadeRange;
	}

}
