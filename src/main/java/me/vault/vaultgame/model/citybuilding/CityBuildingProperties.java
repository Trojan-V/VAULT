package me.vault.vaultgame.model.citybuilding;


import javafx.scene.Scene;


// TODO: Rename properties to attributes to remove unclear wording due to GUI properties
public class CityBuildingProperties
{
	private final String name;


	private final Scene scene;


	public CityBuildingProperties (final String name, final Scene scene)
	{
		this.name = name;
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
}
