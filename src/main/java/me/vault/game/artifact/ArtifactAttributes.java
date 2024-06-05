package me.vault.game.artifact;


import me.vault.game.currency.CurrencyTransaction;


public class ArtifactAttributes
{
	private final String name;


	private final CurrencyTransaction upgradeCosts;


	private final AttributeModifiers attributeModifiers;


	public ArtifactAttributes (final String name, final CurrencyTransaction upgradeCosts,
		final AttributeModifiers attributeModifiers)
	{
		this.name = name;
		this.attributeModifiers = attributeModifiers;
		this.upgradeCosts = upgradeCosts;
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


	public AttributeModifiers getAttributeModifiers ()
	{
		return this.attributeModifiers;
	}


	public void updateProperties ()
	{

	}
}
