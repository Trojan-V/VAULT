package me.vault.game.controller;


import me.vault.game.model.citybuilding.CityBuilding;
import me.vault.game.model.citybuilding.CityBuildingLevel;
import me.vault.game.model.citybuilding.CityBuildingProperties;
import me.vault.game.model.interfaces.IUpgrader;


/**
 *
 */
public final class CityBuildingController implements IUpgrader<CityBuilding, CityBuildingLevel, CityBuildingProperties>
{
	private static final CityBuildingController INSTANCE = new CityBuildingController();


	/**
	 * The constructor of the class is private because it's not meant to be initialized.
	 */
	private CityBuildingController ()
	{}


	public static CityBuildingController getInstance ()
	{
		return INSTANCE;
	}


	@Override
	public boolean checkIsUpgradable (final CityBuilding cityBuilding)
	{
		// TODO: Implement
		return false;
	}


	@Override
	public void upgrade (final CityBuilding cityBuilding)
	{
		// TODO: Implement
	}
}
