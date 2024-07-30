package me.vault.game.control;


import javafx.application.Platform;
import me.vault.game.interfaces.Upgrader;
import me.vault.game.model.building.CityBuilding;
import me.vault.game.model.building.CityBuildingLevel;
import me.vault.game.model.currency.Currency;
import me.vault.game.utility.logging.ILogger;
import me.vault.game.utility.logging.Logger;
import me.vault.game.utility.struct.UpgradeRunnable;
import me.vault.game.view.city.building.*;
import org.jetbrains.annotations.NotNull;

import static me.vault.game.utility.constant.LoggingConstants.UPGRADING;


/**
 * This class serves as a general controller for all different city buildings, as all city buildings that require a
 * controller share some behavior that applies to them all, which is the upgrading of them in this case.
 * <br>
 * There are several 'Delegates' that extend from this controller as these delegates are all responsible for their
 * own CityBuilding.
 *
 * @author Vincent Wolf, Lasse-Leander Hillen, Timothy Hoegen-Jupp, Alexander Goethel
 * @version 1.0.0
 * @see DocksDelegate
 * @see LaboratoryDelegate
 * @see MarketDelegate
 * @see SpaceBarDelegate
 * @see TrainingFacilityDelegate
 * @see WorkshopDelegate
 * @see Upgrader
 * @see CityBuilding
 * @see CityBuildingLevel
 * @since 28.07.2024
 */
public final class CityBuildingController implements Upgrader<CityBuilding, CityBuildingLevel>
{

	/**
	 * Singleton instance, as there's no reason to have more than one {@link CityBuildingController}.
	 * <br>
	 * Instead of using a singleton, the entire class could've been created using solely static methods and fields.
	 */
	private static final CityBuildingController INSTANCE = new CityBuildingController();


	/**
	 * The {@link Logger} object for this class used for writing to the console.
	 */
	private static final ILogger LOGGER = new Logger(CityBuildingController.class.getSimpleName());


	/**
	 * As this class is a singleton, no other class should be able to instantiate it.
	 * <br>
	 * To prohibit the instantiation from anywhere else but within the class, a private constructor is used.
	 *
	 * @precondition Constructor gets called from within the class
	 * @postcondition A new instance of CityBuildingController is created.
	 */
	private CityBuildingController () {}


	/**
	 * Returns the singleton instance of this class.
	 *
	 * @return The singleton instance of this class.
	 *
	 * @precondition The singleton Instance exists.
	 * @postcondition The singleton Instance of this class has been returned.
	 */
	public static CityBuildingController getInstance ()
	{
		return INSTANCE;
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public void upgrade (final CityBuilding cityBuilding)
	{
		LOGGER.logf(ILogger.Level.NORMAL, UPGRADING, cityBuilding.getName(), cityBuilding.getLevel(), cityBuilding.getLevel().getNextHigherLevel());
		Platform.runLater(new UpgradeRunnable(cityBuilding, getInstance()));
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean checkIsUpgradable (final @NotNull CityBuilding cityBuilding)
	{
		if (cityBuilding.isMaxLevel())
		{
			return false;
		}
		for (final Currency currency : Currency.values())
		{
			if (currency.getAmount() < cityBuilding.getUpgradeCosts().getAbsoluteAmount(currency))
			{
				return false;
			}
		}
		return cityBuilding.getLevel().ordinal() < CityBuildingLevel.getMaximum().ordinal();
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updateValues (final CityBuilding cityBuilding)
	{
		cityBuilding.setIsMaxLevel(cityBuilding.getLevel() == CityBuildingLevel.getMaximum());

		cityBuilding.setName(cityBuilding.getName(cityBuilding.getLevel()));
		cityBuilding.setSprite(cityBuilding.getSprite(cityBuilding.getLevel()));
		cityBuilding.setUpgradeCosts(cityBuilding.getUpgradeCosts(cityBuilding.getLevel()));
	}

}
