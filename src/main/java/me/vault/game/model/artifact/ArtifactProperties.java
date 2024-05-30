package me.vault.game.model.artifact;


import me.vault.game.model.currency.CurrencyTransaction;

import static me.vault.game.utility.constant.CharacterConstants.PIPE;


// TODO: Kapselung der Attribute in Buff/Debuff Kategorien
public class ArtifactProperties
{
	private final String name;


	private final double healthIncrease;


	private final double regenerationIncrease;


	private final double meleeDamageIncrease;


	private final double energyDamageIncrease;


	private final double dodgeIncrease;


	private final double defenseIncrease;


	private final CurrencyTransaction upgradeCosts;


	public ArtifactProperties (final CurrencyTransaction upgradeCosts, final double healthIncrease,
		final double regenerationIncrease, final double meleeDamageIncrease, final double energyDamageIncrease,
		final double dodgeIncrease, final double defenseIncrease, final String name)
	{
		this.name = name;
		this.upgradeCosts = upgradeCosts;
		this.healthIncrease = healthIncrease;
		this.regenerationIncrease = regenerationIncrease;
		this.meleeDamageIncrease = meleeDamageIncrease;
		this.energyDamageIncrease = energyDamageIncrease;
		this.dodgeIncrease = dodgeIncrease;
		this.defenseIncrease = defenseIncrease;
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


	public double getRegenerationIncrease ()
	{
		return this.regenerationIncrease;
	}


	public double getMeleeDamageIncrease ()
	{
		return this.meleeDamageIncrease;
	}


	public double getEnergyDamageIncrease ()
	{
		return this.energyDamageIncrease;
	}


	public double getDodgeIncrease ()
	{
		return this.dodgeIncrease;
	}


	public double getDefenseIncrease ()
	{
		return this.defenseIncrease;
	}


	public CurrencyTransaction getUpgradeCosts ()
	{
		return this.upgradeCosts;
	}


	@Override
	public String toString ()
	{
		return "ArtifactProperties[" + this.name + PIPE + this.healthIncrease + PIPE + this.regenerationIncrease +
		       PIPE + this.meleeDamageIncrease + PIPE + this.energyDamageIncrease + PIPE + this.dodgeIncrease + PIPE +
		       this.defenseIncrease + PIPE + this.upgradeCosts + ']';
	}

}
