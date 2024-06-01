package me.vault.game.artifact;


import javafx.scene.image.Image;
import me.vault.game.currency.CurrencyTransaction;
import me.vault.game.interfaces.IDisplayable;


// TODO: Kapselung der Attribute in Buff/Debuff Kategorien
public class ArtifactProperties implements IDisplayable
{
	private final String name;


	private final Image sprite;


	private final double healthIncrease;


	private final double regenerationIncrease;


	private final double meleeDamageIncrease;


	private final double energyDamageIncrease;


	private final double dodgeIncrease;


	private final double defenseIncrease;


	private final CurrencyTransaction upgradeCosts;


	public ArtifactProperties (final CurrencyTransaction upgradeCosts, final double healthIncrease,
		final double regenerationIncrease, final double meleeDamageIncrease, final double energyDamageIncrease,
		final double dodgeIncrease, final double defenseIncrease, final String name, final Image sprite)
	{
		this.name = name;
		this.upgradeCosts = upgradeCosts;
		this.healthIncrease = healthIncrease;
		this.regenerationIncrease = regenerationIncrease;
		this.meleeDamageIncrease = meleeDamageIncrease;
		this.energyDamageIncrease = energyDamageIncrease;
		this.dodgeIncrease = dodgeIncrease;
		this.defenseIncrease = defenseIncrease;
		this.sprite = sprite;
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


	/**
	 * {@inheritDoc}
	 */
	@Override
	public Image getSprite ()
	{
		return this.sprite;
	}
}
