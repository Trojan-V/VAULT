package me.vault.game.controller;


import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import me.vault.game.model.citybuilding.CityBuilding;
import me.vault.game.model.citybuilding.CityBuildingLevel;
import me.vault.game.model.citybuilding.CityBuildingProperties;
import me.vault.game.model.currency.Currency;
import me.vault.game.model.interfaces.IUpgrader;
import me.vault.game.utility.logging.ILogger;
import me.vault.game.utility.logging.Logger;


/**
 *
 */
public class CityBuildingController implements IUpgrader<CityBuilding, CityBuildingLevel, CityBuildingProperties>
{
	private static final CityBuildingController INSTANCE = new CityBuildingController();

	/**
	 * The logger object for this class used for writing to the console.
	 *
	 * @see Logger
	 */
	private static final ILogger LOGGER = new Logger(CityBuildingController.class.getSimpleName());


	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean checkIsUpgradable (final CityBuilding cityBuilding)
	{
		return cityBuilding != null && cityBuilding.getLevel() != CityBuildingLevel.getMaximumArtifactLevel();
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public void upgrade (final CityBuilding cityBuilding)
	{
		if (cityBuilding == null || ! getInstance().checkIsUpgradable(cityBuilding))
		{
			return;
		}
		cityBuilding.setLevel(CityBuildingLevel.getNextHigherLevel(cityBuilding.getLevel()));
		CurrencyController.factorCurrencyTransaction(cityBuilding.getCurrentProperties().getUpgradeCost());
	}


	public static void initCurrency (final Currency currency, final Label label, final ImageView imageView)
	{
		label.textProperty().bind(currency.getAmountProperty().asString());
		imageView.setImage(currency.getSprite());
	}


	public static CityBuildingController getInstance ()
	{
		return INSTANCE;
	}
}
