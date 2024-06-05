package me.vault.game.model.artifact;


import me.vault.game.model.currency.CurrencyTransaction;

import static me.vault.game.utility.constant.CharacterConstants.PIPE;


/**
 * This class provides the attributes for the artefacts of the game.
 *
 * @author Lasse-Leander Hillen , Vincent Wolf, Alexander Göthel
 * @version 1.0.0
 * @since 25.05.2024
 */

// TODO: Kapselung der Attribute in Buff/Debuff Kategorien
public class ArtifactProperties
{
	private final String name;

	private final double healthIncrease;


	private final double armourIncrease;

	private final double meleeDamageIncrease;


	private final double grenadeDamageIncrease;

	private final double energyDamageIncrease;

	private final double dodgeIncrease;


	private final double resistenzIncrease;


	private final int movementRangeIncrease;

	private final CurrencyTransaction upgradeCosts;


	public ArtifactProperties (final CurrencyTransaction upgradeCosts, final double healthIncrease,
		final double armourIncrease, final double meleeDamageIncrease, final double grenadeDamageIncrease,
		final double energyDamageIncrease, final double dodgeIncrease, final double resistenzIncrease,
		final int movementRangeIncrease, final String name)
	{
		this.name = name;
		this.upgradeCosts = upgradeCosts;
		this.healthIncrease = healthIncrease;
		this.armourIncrease = armourIncrease;
		this.meleeDamageIncrease = meleeDamageIncrease;
		this.grenadeDamageIncrease = grenadeDamageIncrease;
		this.energyDamageIncrease = energyDamageIncrease;
		this.dodgeIncrease = dodgeIncrease;
		this.resistenzIncrease = resistenzIncrease;
		this.movementRangeIncrease = movementRangeIncrease;
	}


	// TODO: Interface für diese Methoden?
	public String getName ()
	{
		return this.name;
	}


	public double getHealthIncrease ()
	{
		return this.healthIncrease;
	}


	public double getArmourIncrease ()
	{
		return this.armourIncrease;
	}


	public double getMeleeDamageIncrease ()
	{
		return this.meleeDamageIncrease;
	}


	public double getGrenadeDamageIncrease ()
	{
		return this.grenadeDamageIncrease;
	}

	public double getEnergyDamageIncrease ()
	{
		return this.energyDamageIncrease;
	}


	public double getDodgeIncrease ()
	{
		return this.dodgeIncrease;
	}


	public double getResistenzIncrease ()
	{
		return this.resistenzIncrease;
	}


	public int getMovementRangeIncrease ()
	{
		return this.movementRangeIncrease;
	}

	public CurrencyTransaction getUpgradeCosts ()
	{
		return this.upgradeCosts;
	}


	@Override
	public String toString ()
	{
		return "ArtifactProperties[" + this.name + PIPE + this.healthIncrease + PIPE + this.armourIncrease +
		       PIPE + this.meleeDamageIncrease + PIPE + this.grenadeDamageIncrease + PIPE + this.energyDamageIncrease +
		       PIPE + this.dodgeIncrease + PIPE +
		       this.resistenzIncrease + PIPE + this.movementRangeIncrease + PIPE + this.upgradeCosts + ']';
	}
}
