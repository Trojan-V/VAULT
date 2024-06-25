package me.vault.game.model.energy;


import javafx.beans.property.SimpleIntegerProperty;


public class DefensivStatistic
{

	private final SimpleIntegerProperty armour;

	private final SimpleIntegerProperty dodgeRate;

	private final SimpleIntegerProperty resistance;


	public DefensivStatistic (final int armour, final int dodgeRate,
		final int resistance)
	{
		this.armour = new SimpleIntegerProperty(armour);
		this.dodgeRate = new SimpleIntegerProperty(dodgeRate);
		this.resistance = new SimpleIntegerProperty(resistance);
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


	public SimpleIntegerProperty getResistanceProperty ()
	{
		return this.resistance;
	}

}

