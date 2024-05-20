package me.vault.vaultgame.city.building.controller;


import me.vault.vaultgame.city.building.model.CityBuilding;


/**
 *
 */
public final class CityBuildingController
{

	/**
	 * Main constructor of the class is private because it's not meant to be initialized.
	 */
	private CityBuildingController ()
	{}


	/**
	 * Elevates the {@link CityBuilding} to the next (higher) level, updates the sprite and unlocks new features based
	 * on the new level.
	 *
	 * @param cityBuilding The building which is meant to be upgraded.
	 * @since 06.05.2024
	 */
	public static void upgrade (final CityBuilding cityBuilding)
	{
		if (! isUpgradable(cityBuilding))
		{
			return;
		}
		cityBuilding.setLevel(cityBuilding.getLevel() + 1);
	}


	private static boolean isUpgradable (CityBuilding cityBuilding)
	{
		if (cityBuilding != null && cityBuilding.getLevel() < cityBuilding.getNames().length)
		{
			return false;
		}
		return false;
	}
}
