package me.vault.game.city.building;


import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import me.vault.game.currency.Currency;
import me.vault.game.currency.CurrencyController;
import me.vault.game.utility.logging.ILogger;
import me.vault.game.utility.logging.Logger;

// TODO: extends für untergeordnete CityBuildingController


/**
 *
 */
public class CityBuildingController
{
	private static final CityBuildingController INSTANCE = new CityBuildingController();


	/**
	 * The logger object for this class used for writing to the console.
	 *
	 * @see Logger
	 */
	private static final ILogger LOGGER = new Logger(CityBuildingController.class.getSimpleName());


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
	public void upgrade (final CityBuilding cityBuilding)
	{
		if (cityBuilding == null || !getInstance().checkIsUpgradable(cityBuilding))
		{
			return;
		}
		cityBuilding.setLevel(CityBuildingLevel.getNextHigherLevel(cityBuilding.getLevel()));
		CurrencyController.factorCurrencyTransaction(cityBuilding.getCurrentAttributes().getUpgradeCost());
	}
}
