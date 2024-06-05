package me.vault.game.model.Energy;


import static me.vault.game.utility.constant.CharacterConstants.PIPE;


public class EnergyProperties
{
	private final String name;


	private final double armour;


	private final double meleeDamage;


	private final double energyDamage;


	private final double dodge;


	private final double resistenz;


	private final int movementRange;


	private final double initiative;


	private final int meleeDamageRange;

	// TODO: How to realise a extra turn in a round?


	public EnergyProperties (final String name, final double armour, final double meleeDamage,
		final double energyDamage, final double dodge,
		final double resistenz, final int movementRange, final double initiative, final int meleeDamageRange)
	{
		this.name = name;
		this.armour = armour;
		this.meleeDamage = meleeDamage;
		this.energyDamage = energyDamage;
		this.dodge = dodge;
		this.resistenz = resistenz;
		this.movementRange = movementRange;
		this.initiative = initiative;
		this.meleeDamageRange = meleeDamageRange;
	}


	public String getName ()
	{
		return this.name;
	}


	public double getArmour ()
	{
		return this.armour;
	}


	public double getMeleeDamage ()
	{
		return this.meleeDamage;
	}


	public double getEnergyDamage ()
	{
		return this.energyDamage;
	}


	public double getDodge ()
	{
		return this.dodge;
	}


	public double getResistenz ()
	{
		return this.resistenz;
	}


	public int getMovementRange ()
	{
		return this.movementRange;
	}


	public double getInitiative ()
	{
		return this.initiative;
	}


	public int getMeleeDamageRange ()
	{
		return this.meleeDamageRange;
	}


	@Override
	public String toString ()
	{
		return "EnergyProperties[" + this.name + PIPE + this.armour + PIPE + this.meleeDamage +
		       PIPE + this.energyDamage + PIPE + this.dodge + PIPE + this.resistenz + PIPE + this.movementRange + PIPE +
		       this.initiative + PIPE + this.meleeDamageRange + ']';
	}
}
