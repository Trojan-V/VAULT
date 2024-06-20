package me.vault.game.model.building;


import me.vault.game.model.currency.CurrencyTransaction;


public class CityBuildingAttributes
{

	private final String name;

	private final CurrencyTransaction upgradeCost;


	public CityBuildingAttributes (final String name, final CurrencyTransaction upgradeCost)
	{
		this.name = name;
		this.upgradeCost = upgradeCost;
	}


	public String getName ()
	{
		return this.name;
	}


	@Override
	public String toString ()
	{
		return "CityBuildingProperties{" + "name='" + this.name + '\'' + ", scene=" + '}';
	}


	public CurrencyTransaction getUpgradeCost ()
	{
		return this.upgradeCost;
	}

}
