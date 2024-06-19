package me.vault.game.control;


import javafx.application.Platform;
import me.vault.game.interfaces.Upgrader;
import me.vault.game.model.building.CityBuilding;
import me.vault.game.model.building.CityBuildingLevel;
import me.vault.game.utility.logging.ILogger;
import me.vault.game.utility.logging.Logger;
import me.vault.game.utility.struct.UpgradeRunnable;

import static me.vault.game.utility.constant.LoggingConstants.CityBuildingController.UPGRADING_BUILDING;

// TODO: extends für untergeordnete CityBuildingController


public class CityBuildingController implements Upgrader<CityBuilding, CityBuildingLevel>
{

	private static final CityBuildingController INSTANCE = new CityBuildingController();

	/**
	 * The {@link Logger} object for this class used for writing to the console.
	 */
	private static final ILogger LOGGER = new Logger(CityBuildingController.class.getSimpleName());


	/**
	 * Returns the singleton instance of this class.
	 *
	 * @return The singleton instance of this class.
	 */
	public static CityBuildingController getInstance ()
	{
		return INSTANCE;
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public void upgrade (final CityBuilding upgradable)
	{
		LOGGER.logf(ILogger.Level.NORMAL, UPGRADING_BUILDING, upgradable.getName(), upgradable.getLevel(), upgradable.getLevel().getNextHigherLevel());
		Platform.runLater(new UpgradeRunnable(upgradable, getInstance()));
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean checkIsUpgradable (final CityBuilding cityBuilding)
	{
		// TODO: Currency Check fehlt noch, ob genug vorhanden ist.
		return cityBuilding != null && cityBuilding.getLevel() != CityBuildingLevel.getMaximumCityBuildingLevel();
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updateValues (final CityBuilding cityBuilding)
	{
		// TODO: add to IUpgrader?!
		cityBuilding.setName(cityBuilding.getName(cityBuilding.getLevel()));
		cityBuilding.setSprite(cityBuilding.getSprite(cityBuilding.getLevel()));
		cityBuilding.setUpgradeCosts(cityBuilding.getUpgradeCosts(cityBuilding.getLevel()));
	}

}
