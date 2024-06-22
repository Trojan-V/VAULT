package me.vault.game.model.troop;


public class DefensiveStatistic
{

	private int healthPoints;

	private int meleeDamageReduction;

	private int dodgeRate;

	private int energyDamageReduction;


	public DefensiveStatistic (final int healthPoints, final int meleeDamageReduction, final int dodgeRate, final int energyDamageReduction)
	{
		this.healthPoints = healthPoints;
		this.meleeDamageReduction = meleeDamageReduction;
		this.dodgeRate = dodgeRate;
		this.energyDamageReduction = energyDamageReduction;
	}


	public int getHealthPoints ()
	{
		return this.healthPoints;
	}


	public void setHealthPoints (final int healthPoints)
	{
		this.healthPoints = healthPoints;
	}


	public int getMeleeDamageReduction ()
	{
		return this.meleeDamageReduction;
	}


	public void setMeleeDamageReduction (final int meleeDamageReduction)
	{
		this.meleeDamageReduction = meleeDamageReduction;
	}


	public int getDodgeRate ()
	{
		return this.dodgeRate;
	}


	public void setDodgeRate (final int dodgeRate)
	{
		this.dodgeRate = dodgeRate;
	}


	public int getEnergyDamageReduction ()
	{
		return this.energyDamageReduction;
	}


	public void setEnergyDamageReduction (final int energyDamageReduction)
	{
		this.energyDamageReduction = energyDamageReduction;
	}

}
