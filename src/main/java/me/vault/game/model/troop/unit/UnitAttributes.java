package me.vault.game.model.troop.unit;


import me.vault.game.model.currency.CurrencyTransaction;

import static me.vault.game.utility.constant.CharacterConstants.PIPE;


/**
 * This class provides the attributes for the units of the game.
 *
 * @author Alexander Göthel
 * @version 1.0.0
 * @since 28.05.2024
 */
public class UnitAttributes
{

	private final String name;

	private final double health;

	private final double armour;

	private final int energy;

	private final int meleeDamage;

	private final int grenade;

	private final int grenadeAmount;

	private final double dodge;

	private final double resistance;

	private final int movementRange;

	private final int initiative;

	private final int meleeRange;

	private final int grenadeRange;

	private final CurrencyTransaction upgradeCosts;


	public UnitAttributes (final CurrencyTransaction upgradeCosts, final double health, final double armour, final int energy, final int meleeDamage,
		final int grenade, final int grenadeAmount, final double dodge, final double resistance, final int movementRange, final int initiative,
		final int meleeRange, final int grenadeRange, final String name)
	{
		this.name = name;
		this.upgradeCosts = upgradeCosts;
		this.health = health;
		this.armour = armour;
		this.energy = energy;
		this.meleeDamage = meleeDamage;
		this.grenade = grenade;
		this.grenadeAmount = grenadeAmount;
		this.dodge = dodge;
		this.resistance = resistance;
		this.movementRange = movementRange;
		this.initiative = initiative;
		this.meleeRange = meleeRange;
		this.grenadeRange = grenadeRange;
	}


	public String getName ()
	{
		return this.name;
	}


	public double getHealth ()
	{
		return this.health;
	}


	public double getArmour ()
	{
		return this.armour;
	}


	public int getEnergy ()
	{
		return this.energy;
	}


	public int getMeleeDamage ()
	{
		return this.meleeDamage;
	}


	public int getGrenade ()
	{
		return this.grenade;
	}


	public int getGrenadeAmount ()
	{
		return this.grenadeAmount;
	}


	public double getDodge ()
	{
		return this.dodge;
	}


	public double getResistance ()
	{
		return this.resistance;
	}


	public int getMovementRange ()
	{
		return this.movementRange;
	}


	public int getInitiative ()
	{
		return this.initiative;
	}


	public int getMeleeRange ()
	{
		return this.meleeRange;
	}


	public int getGrenadeRange ()
	{
		return this.grenadeRange;
	}


	public CurrencyTransaction getUpgradeCosts ()
	{
		return this.upgradeCosts;
	}


	@Override
	public String toString ()
	{
		return "ArtifactProperties[" + this.name + PIPE + this.health + PIPE + this.armour + PIPE + this.meleeDamage + PIPE + this.grenade + PIPE +
		       this.grenadeAmount + PIPE + this.dodge + PIPE + this.resistance + PIPE + this.movementRange + PIPE + this.initiative + PIPE +
		       this.meleeRange + PIPE + this.grenadeRange + PIPE + this.upgradeCosts + ']';
	}

}
