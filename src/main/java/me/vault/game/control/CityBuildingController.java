package me.vault.game.control;


import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import me.vault.game.interfaces.Upgradable;
import me.vault.game.interfaces.Upgrader;
import me.vault.game.model.building.CityBuilding;
import me.vault.game.model.building.CityBuildingLevel;
import me.vault.game.model.currency.Currency;
import me.vault.game.utility.logging.ILogger;
import me.vault.game.utility.logging.Logger;

// TODO: extends für untergeordnete CityBuildingController


/**
 *
 */
public class CityBuildingController implements Upgrader<CityBuilding, CityBuildingLevel>
{

	private static final CityBuildingController INSTANCE = new CityBuildingController();

	/**
	 * The logger object for this class used for writing to the console.
	 *
	 * @see Logger
	 */
	private static final ILogger LOGGER = new Logger(CityBuildingController.class.getSimpleName());


	// TODO: Auslagern in Currency-Controller
	public static void initCurrency (final Currency currency, final Label label, final ImageView imageView)
	{
		label.textProperty().bind(currency.getAmountProperty().asString());
		imageView.imageProperty().bind(currency.getSpriteProperty());
	}


	public static CityBuildingController getInstance ()
	{
		return INSTANCE;
	}


	/**
	 * Upgrades the {@link Upgradable} instance to the next level {@link E}.
	 *
	 * @param upgradable The {@link Upgradable} instance that gets upgraded.
	 */
	@Override
	public void upgrade (final CityBuilding upgradable)
	{
		System.out.println("Building :" + upgradable.toString() + "upgraded!");
	}


	/**
	 * {@inheritDoc}
	 */
	public boolean checkIsUpgradable (final CityBuilding cityBuilding)
	{
		// TODO: Currency Check fehlt noch, ob genug vorhanden ist.
		return cityBuilding != null && cityBuilding.getLevel() != CityBuildingLevel.getMaximumCityBuildingLevel();
	}


	/**
	 * {@inheritDoc}
	 */
	public void upgradeBuilding (final CityBuilding cityBuilding)
	{
		if (cityBuilding == null || !getInstance().checkIsUpgradable(cityBuilding))
		{
			return;
		}
		cityBuilding.setLevel(cityBuilding.getLevel().getNextHigherLevel());
		CurrencyController.factorCurrencyTransaction(cityBuilding.getCurrentUpgradeCosts());
	}

	public void updatePropertyValues (final CityBuilding cityBuilding)
	{
		// TODO: add to IUpgrader?!
		cityBuilding.getNameProperty().set(cityBuilding.getAllNames().get(cityBuilding.getLevel()));
		cityBuilding.getSpriteProperty().set(cityBuilding.getAllSprites().get(cityBuilding.getLevel()));
		cityBuilding.setCurrentUpgradeCosts(cityBuilding.getAllUpgradeCosts().get(cityBuilding.getLevel()));
	}
}
