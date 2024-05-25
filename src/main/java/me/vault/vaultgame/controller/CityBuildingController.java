package me.vault.vaultgame.controller;


import me.vault.vaultgame.model.citybuilding.CityBuilding;
import me.vault.vaultgame.model.citybuilding.CityBuildingLevel;
import me.vault.vaultgame.model.citybuilding.CityBuildingProperties;
import me.vault.vaultgame.model.interfaces.IUpgrader;


/**
 *
 */
public final class CityBuildingController implements IUpgrader<CityBuilding, CityBuildingLevel, CityBuildingProperties>
{
	/**
	 * The constructor of the class is private because it's not meant to be initialized.
	 */
	private CityBuildingController ()
	{}


	private static boolean isUpgradable (final CityBuilding cityBuilding)
	{
		return false;
	}


	@Override
	public void upgrade (final CityBuilding cityBuilding)
	{

	}
}
