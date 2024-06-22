package me.vault.game.model.troop;


import javafx.beans.property.SimpleIntegerProperty;


public class DefensiveStatistic
{

	private SimpleIntegerProperty healthPoints;

	private SimpleIntegerProperty meleeDamageReduction;

	private SimpleIntegerProperty dodgeRate;

	private SimpleIntegerProperty energyDamageReduction;


	public DefensiveStatistic (final int healthPoints, final int meleeDamageReduction, final int dodgeRate, final int energyDamageReduction)
	{
		this.healthPoints = new SimpleIntegerProperty(healthPoints);
		this.meleeDamageReduction = new SimpleIntegerProperty(meleeDamageReduction);
		this.dodgeRate = new SimpleIntegerProperty(dodgeRate);
		this.energyDamageReduction = new SimpleIntegerProperty(energyDamageReduction);
	}


	public int getHealthPoints ()
	{
		return this.healthPoints.get();
	}


	public SimpleIntegerProperty getHealthPointsProperty ()
	{
		return this.healthPoints;
	}


	public void setHealthPoints (final int healthPoints)
	{
		this.healthPoints.set(healthPoints);
	}


	public int getMeleeDamageReduction ()
	{
		return this.meleeDamageReduction.get();
	}


	public SimpleIntegerProperty getMeleeDamageReductionProperty ()
	{
		return this.meleeDamageReduction;
	}


	public void setMeleeDamageReduction (final int meleeDamageReduction)
	{
		this.meleeDamageReduction.set(meleeDamageReduction);
	}


	public int getDodgeRate ()
	{
		return this.dodgeRate.get();
	}


	public SimpleIntegerProperty getDodgeRateProperty ()
	{
		return this.dodgeRate;
	}


	public void setDodgeRate (final int dodgeRate)
	{
		this.dodgeRate.set(dodgeRate);
	}


	public int getEnergyDamageReduction ()
	{
		return this.energyDamageReduction.get();
	}


	public SimpleIntegerProperty getEnergyDamageReductionProperty ()
	{
		return this.energyDamageReduction;
	}


	public void setEnergyDamageReduction (final int energyDamageReduction)
	{
		this.energyDamageReduction.set(energyDamageReduction);
	}

}
