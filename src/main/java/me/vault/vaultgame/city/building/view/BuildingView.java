package me.vault.vaultgame.city.building.view;

import me.vault.vaultgame.city.building.model.CityBuilding;

// TODO: Class not finished, just there as barebones.
public class BuildingView
{
	/**
	 * @param cityBuilding
	 */
	public static void hideDialog (CityBuilding cityBuilding)
	{
		System.out.println("The building" + cityBuilding.toString() + "was hidden.");
	}



	public static void openDialog (CityBuilding cityBuilding)
	{
		System.out.println("The building" + cityBuilding.toString() + "was shown.");
	}
}
