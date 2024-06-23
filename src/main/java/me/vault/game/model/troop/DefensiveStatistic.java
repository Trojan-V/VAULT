package me.vault.game.model.troop;


import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;


public class DefensiveStatistic
{

	private final SimpleIntegerProperty healthPoints;

	private final SimpleDoubleProperty armour;

	private final SimpleDoubleProperty dodgeRate;

	private final SimpleDoubleProperty resistance;


	public DefensiveStatistic (final int healthPoints, final double armour, final double dodgeRate,
		final double resistance)
	{
		this.healthPoints = new SimpleIntegerProperty(healthPoints);
		this.armour = new SimpleDoubleProperty(armour);
		this.dodgeRate = new SimpleDoubleProperty(dodgeRate);
		this.resistance = new SimpleDoubleProperty(resistance);
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


	public double getArmour ()
	{
		return this.armour.get();
	}


	public void setArmour (final double armour)
	{
		this.armour.set(armour);
	}


	public void setArmour (final float armour)
	{
		this.armour.set(Math.round(armour));
	}


	public SimpleDoubleProperty getMeleeDamageReductionProperty ()
	{
		return this.armour;
	}


	public double getDodgeRate ()
	{
		return this.dodgeRate.get();
	}


	public void setDodgeRate (final double dodgeRate)
	{
		this.dodgeRate.set(dodgeRate);
	}


	public void setDodgeRate (final float dodgeRate)
	{
		this.dodgeRate.set(Math.round(dodgeRate));
	}


	public SimpleDoubleProperty getDodgeRateProperty ()
	{
		return this.dodgeRate;
	}


	public double getResistance ()
	{
		return this.resistance.get();
	}


	public void setResistance (final double resistance)
	{
		this.resistance.set(resistance);
	}


	public void setResistance (final float resistance)
	{
		this.resistance.set(Math.round(resistance));
	}


	public SimpleDoubleProperty getResistanceProperty ()
	{
		return this.resistance;
	}

}
