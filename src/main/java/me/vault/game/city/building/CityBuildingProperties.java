package me.vault.game.city.building;

import javafx.scene.Scene;
import me.vault.game.currency.CurrencyTransaction;

// TODO: Rename properties to attributes to remove unclear wording due to GUI properties
public class CityBuildingProperties
{
	private final String name;

	private final CurrencyTransaction upgradeCost;


	public CityBuildingProperties (final String name, final CurrencyTransaction upgradeCost)
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
