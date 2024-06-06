package me.vault.game.city.market;


import javafx.scene.Scene;
import javafx.scene.image.Image;
import me.vault.game.city.building.AbsCityBuilding;
import me.vault.game.city.building.CityBuildingLevel;
import me.vault.game.currency.CurrencyTransaction;
import me.vault.game.utility.loading.ResourceLoader;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

import static me.vault.game.utility.constant.GameConstants.ASSETS_PATH;


public class Market extends AbsCityBuilding
{
	private static final Market INSTANCE;


	private static final Scene SCENE = ResourceLoader.loadScene(Market.class, "market_view.fxml");


	private static final Map<CityBuildingLevel, String> NAMES = new HashMap<>();


	private static final Map<CityBuildingLevel, Image> SPRITES = new HashMap<>();


	private static final Map<CityBuildingLevel, CurrencyTransaction> UPGRADE_COSTS = new HashMap<>();

	static
	{
		NAMES.put(CityBuildingLevel.OLD, "Old Market");
		NAMES.put(CityBuildingLevel.NORMAL, "Market");
		NAMES.put(CityBuildingLevel.SUPER, "Super Market");

		SPRITES.put(CityBuildingLevel.OLD, ResourceLoader.loadImage(ASSETS_PATH + "Item_Pack/market_icon.png"));
		SPRITES.put(CityBuildingLevel.NORMAL, ResourceLoader.loadImage(ASSETS_PATH + "Item_Pack/market_icon.png"));
		SPRITES.put(CityBuildingLevel.SUPER, ResourceLoader.loadImage(ASSETS_PATH + "Item_Pack/market_icon.png"));

		UPGRADE_COSTS.put(CityBuildingLevel.OLD, new CurrencyTransaction(-10, -10, -10, -10, -10));
		UPGRADE_COSTS.put(CityBuildingLevel.NORMAL, new CurrencyTransaction(-10, -10, -10, -10, -10));
		UPGRADE_COSTS.put(CityBuildingLevel.SUPER, CurrencyTransaction.EMPTY);

		INSTANCE = new Market();
	}

	public static Market getInstance ()
	{
		return INSTANCE;
	}


	@Override
	protected @NotNull Map<CityBuildingLevel, CurrencyTransaction> getUpgradeCosts ()
	{
		return UPGRADE_COSTS;
	}


	@Override
	protected @NotNull Map<CityBuildingLevel, String> getNames ()
	{
		return NAMES;
	}


	@Override
	protected @NotNull Map<CityBuildingLevel, Image> getSprites ()
	{
		return SPRITES;
	}


	@Override
	protected @NotNull Scene getScene ()
	{
		return SCENE;
	}
}
