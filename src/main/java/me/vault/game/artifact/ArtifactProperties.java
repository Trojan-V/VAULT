package me.vault.game.artifact;

import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.image.Image;
import me.vault.game.currency.CurrencyTransaction;

// TODO: Kapselung der Attribute in Buff/Debuff Kategorien
public class ArtifactProperties
{
	private final String name;

	private final SimpleObjectProperty<Image> imageProperty;

	private double healthIncrease;

	private double regenerationIncrease;

	private double meleeDamageIncrease;

	private double energyDamageIncrease;

	private double dodgeIncrease;

	private double defenseIncrease;

	private final CurrencyTransaction upgradeCosts;


	public ArtifactProperties (final String name, final SimpleObjectProperty<Image> imageProperty, final CurrencyTransaction upgradeCosts)
	{
		this.name = name;
		this.upgradeCosts = upgradeCosts;
		this.imageProperty = imageProperty;
	}


	// TODO: Interface für diese Methoden?
	public String getName ()
	{
		return this.name;
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
