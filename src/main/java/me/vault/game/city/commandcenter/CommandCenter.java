package me.vault.game.city.commandcenter;


import javafx.scene.Scene;
import javafx.scene.image.Image;
import me.vault.game.city.building.AbsCityBuilding;
import me.vault.game.city.building.CityBuildingLevel;
import me.vault.game.city.docks.Docks;
import me.vault.game.currency.CurrencyTransaction;
import me.vault.game.utility.loading.ResourceLoader;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

import static me.vault.game.utility.constant.GameConstants.ASSETS_PATH;


public class CommandCenter extends AbsCityBuilding
{
	private static final CommandCenter INSTANCE;


	private static final Scene SCENE = ResourceLoader.loadScene(CommandCenter.class, "command_center_view.fxml");


	private static final Map<CityBuildingLevel, String> NAMES = new HashMap<>();


	private static final Map<CityBuildingLevel, Image> SPRITES = new HashMap<>();


	private static final Map<CityBuildingLevel, CurrencyTransaction> UPGRADE_COSTS = new HashMap<>();

	static
	{
		NAMES.put(CityBuildingLevel.OLD, "Old Command Center");
		NAMES.put(CityBuildingLevel.NORMAL, "Command Center");
		NAMES.put(CityBuildingLevel.SUPER, "Super Command Center");

		SPRITES.put(CityBuildingLevel.OLD, ResourceLoader.loadImage(ASSETS_PATH + "Item_Pack/command_center_icon.png"));
		SPRITES.put(CityBuildingLevel.NORMAL, ResourceLoader.loadImage(ASSETS_PATH + "Item_Pack/command_center_icon.png"));
		SPRITES.put(CityBuildingLevel.SUPER, ResourceLoader.loadImage(ASSETS_PATH + "Item_Pack/command_center_icon.png"));

		UPGRADE_COSTS.put(CityBuildingLevel.OLD, new CurrencyTransaction(-10, -10, -10, -10, -10));
		UPGRADE_COSTS.put(CityBuildingLevel.NORMAL, new CurrencyTransaction(-10, -10, -10, -10, -10));
		UPGRADE_COSTS.put(CityBuildingLevel.SUPER, CurrencyTransaction.EMPTY);

		INSTANCE = new CommandCenter();
	}

	public static CommandCenter getInstance ()
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
