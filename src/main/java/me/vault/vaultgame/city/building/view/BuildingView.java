package me.vault.vaultgame.city.building.view;

import me.vault.vaultgame.city.building.model.CityBuilding;

// TODO: Class not finished, just there as barebones.
/**
 *
 */
public final class BuildingView
{

	private BuildingView () {}


	/**
	 * @param cityBuilding
	 */
	public static void hideDialog (CityBuilding cityBuilding)
	{
		System.out.println("The building" + cityBuilding.toString() + "was hidden.");
	}


	/**
	 * @param cityBuilding
	 */
	public static void openDialog (CityBuilding cityBuilding)
	{
		System.out.println("The building" + cityBuilding.toString() + "was shown.");
	}
}
