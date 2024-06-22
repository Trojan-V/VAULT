package me.vault.game.model.troop;


import javafx.beans.property.SimpleIntegerProperty;


public class DefensiveStatistic
{

	private SimpleIntegerProperty healthPoints;

	private SimpleIntegerProperty armour;

	private SimpleIntegerProperty dodgeRate;

	private SimpleIntegerProperty resistance;


	public DefensiveStatistic (final int healthPoints, final int meleeDamageReduction, final int dodgeRate, final int energyDamageReduction)
	{
		this.healthPoints = new SimpleIntegerProperty(healthPoints);
		this.armour = new SimpleIntegerProperty(meleeDamageReduction);
		this.dodgeRate = new SimpleIntegerProperty(dodgeRate);
		this.resistance = new SimpleIntegerProperty(energyDamageReduction);
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


	public int getArmour ()
	{
		return this.armour.get();
	}


	public SimpleIntegerProperty getMeleeDamageReductionProperty ()
	{
		return this.armour;
	}


	public void setArmour (final int armour)
	{
		this.armour.set(armour);
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


	public int getResistance ()
	{
		return this.resistance.get();
	}


	public SimpleIntegerProperty getEnergyDamageReductionProperty ()
	{
		return this.resistance;
	}


	public void setResistance (final int resistance)
	{
		this.resistance.set(resistance);
	}

}
