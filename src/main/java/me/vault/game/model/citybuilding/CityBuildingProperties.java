package me.vault.game.model.citybuilding;


import javafx.scene.Scene;
import me.vault.game.model.currency.CurrencyTransaction;


// TODO: Rename properties to attributes to remove unclear wording due to GUI properties
public class CityBuildingProperties
{
	private final String name;


	private final Scene scene;


	private final CurrencyTransaction upgradeCost;


	public CityBuildingProperties (final String name, final CurrencyTransaction upgradeCost, final Scene scene)
	{
		this.name = name;
		this.upgradeCost = upgradeCost;
		this.scene = scene;
	}


	public String getName ()
	{
		return this.name;
	}


	public Scene getScene ()
	{
		return this.scene;
	}


	@Override
	public String toString ()
	{
		return "CityBuildingProperties{" + "name='" + this.name + '\'' + ", scene=" + this.scene + '}';
	}


	public CurrencyTransaction getUpgradeCost ()
	{
		return this.upgradeCost;
	}
}
