package me.vault.vaultgame.city.view;

import me.vault.vaultgame.city.model.Building;

public class BuildingView
{
	/**
	 * @param building
	 */
	public void hide (Building building)
	{
		System.out.println("The building" + building.toString() + "was hidden.");
	}


	/**
	 *
	 */
	public void show (Building building)
	{
		System.out.println("The building" + building.toString() + "was shown.");
	}
}
