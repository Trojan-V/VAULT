package me.vault.game.artifact;

import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.image.Image;
import me.vault.game.currency.CurrencyTransaction;

// TODO: Kapselung der Attribute in Buff/Debuff Kategorien
public class ArtifactProperties
{
	private final String name;

	private final SimpleObjectProperty<Image> imageProperty;


	private final double healthIncrease;


	private final double armourIncrease;


	private final double meleeDamageIncrease;


	private final double grenadeDamageIncrease;


	private final double energyDamageIncrease;


	private final double resistenzIncrease;


	private final CurrencyTransaction upgradeCosts;


	public ArtifactProperties (final String name, final SimpleObjectProperty<Image> imageProperty,
		final double healthIncrease,
		final double armourIncrease, final double meleeDamageIncrease, final double grenadeDamageIncrease,
		final double energyDamageIncrease,
		final double resistenzIncrease, final CurrencyTransaction upgradeCosts)
	{
		this.name = name;
		this.imageProperty = imageProperty;
		this.healthIncrease = healthIncrease;
		this.armourIncrease = armourIncrease;
		this.meleeDamageIncrease = meleeDamageIncrease;
		this.grenadeDamageIncrease = grenadeDamageIncrease;
		this.energyDamageIncrease = energyDamageIncrease;
		this.resistenzIncrease = resistenzIncrease;
		this.upgradeCosts = upgradeCosts;
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


	public double getResistenzIncrease ()
	{
		return this.resistenzIncrease;
	}


	public CurrencyTransaction getUpgradeCosts ()
	{
		return this.upgradeCosts;
	}


	/**
	 * {@inheritDoc}
	 */
	public SimpleObjectProperty<Image> getSprite ()
	{
		return this.imageProperty;
	}

}
