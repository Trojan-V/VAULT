package me.vault.vaultgame.controller;


import me.vault.vaultgame.model.CityBuilding;


/**
 *
 */
public final class CityBuildingController
{
	/**
	 * The constructor of the class is private because it's not meant to be initialized.
	 */
	private CityBuildingController ()
	{}


	/**
	 * Elevates the {@link CityBuilding} to the next (higher) level, updates the sprite and unlocks new features based
	 * on the new level.
	 *
	 * @param cityBuilding The building which is meant to be upgraded.
	 *
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


	private static boolean isUpgradable (final CityBuilding cityBuilding)
	{
		if (cityBuilding != null && cityBuilding.getLevel() < cityBuilding.getNames().length)
		{
			return false;
		}
		return false;
	}
}
