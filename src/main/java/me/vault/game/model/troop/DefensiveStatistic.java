package me.vault.game.model.troop;


import javafx.beans.property.SimpleIntegerProperty;


public class DefensiveStatistic
{

	private final SimpleIntegerProperty healthPoints;

	private final SimpleIntegerProperty armour;

	private final SimpleIntegerProperty dodgeRate;

	private final SimpleIntegerProperty resistance;


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


	public void setHealthPoints (final int healthPoints)
	{
		this.healthPoints.set(healthPoints);
	}


	public void setHealthPoints (final float healthPoints)
	{
		this.healthPoints.set(Math.round(healthPoints));
	}


	public SimpleIntegerProperty getHealthPointsProperty ()
	{
		return this.healthPoints;
	}


	public int getArmour ()
	{
		return this.armour.get();
	}


	public void setArmour (final int armour)
	{
		this.armour.set(armour);
	}


	public void setArmour (final float armour)
	{
		this.armour.set(Math.round(armour));
	}


	public SimpleIntegerProperty getMeleeDamageReductionProperty ()
	{
		return this.armour;
	}


	public int getDodgeRate ()
	{
		return this.dodgeRate.get();
	}


	public void setDodgeRate (final int dodgeRate)
	{
		this.dodgeRate.set(dodgeRate);
	}


	public void setDodgeRate (final float dodgeRate)
	{
		this.dodgeRate.set(Math.round(dodgeRate));
	}


	public SimpleIntegerProperty getDodgeRateProperty ()
	{
		return this.dodgeRate;
	}


	public int getResistance ()
	{
		return this.resistance.get();
	}


	public void setResistance (final int resistance)
	{
		this.resistance.set(resistance);
	}


	public void setResistance (final float resistance)
	{
		this.resistance.set(Math.round(resistance));
	}


	public SimpleIntegerProperty getEnergyDamageReductionProperty ()
	{
		return this.resistance;
	}

}