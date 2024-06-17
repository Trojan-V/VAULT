package me.vault.game.model.city;


import javafx.scene.Scene;
import me.vault.game.model.building.CityBuilding;
import me.vault.game.model.building.CityBuildingLevel;
import me.vault.game.model.currency.CurrencyTransaction;
import me.vault.game.utility.loading.ResourceLoader;
import me.vault.game.utility.struct.MetaDataImage;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

import static me.vault.game.utility.constant.GameConstants.ASSETS_PATH;


public class SpaceBar extends CityBuilding
{

	private static final SpaceBar INSTANCE;

	private static final Scene SCENE = ResourceLoader.loadScene(SpaceBar.class, "space_bar_view.fxml");

	private static final Map<CityBuildingLevel, String> NAMES = new HashMap<>();

	private static final Map<CityBuildingLevel, MetaDataImage> SPRITES = new HashMap<>();

	private static final Map<CityBuildingLevel, CurrencyTransaction> UPGRADE_COSTS = new HashMap<>();


	static
	{
		NAMES.put(CityBuildingLevel.OLD, "Old Space-Bar");
		NAMES.put(CityBuildingLevel.NORMAL, "Space-Bar");
		NAMES.put(CityBuildingLevel.SUPER, "Super Space-Bar");

		SPRITES.put(CityBuildingLevel.OLD, ResourceLoader.loadImage(ASSETS_PATH + "Item_Pack/space_bar_icon.png"));
		SPRITES.put(CityBuildingLevel.NORMAL, ResourceLoader.loadImage(ASSETS_PATH + "Item_Pack/space_bar_icon.png"));
		SPRITES.put(CityBuildingLevel.SUPER, ResourceLoader.loadImage(ASSETS_PATH + "Item_Pack/space_bar_icon.png"));

		UPGRADE_COSTS.put(CityBuildingLevel.OLD, new CurrencyTransaction(-10, -10, -10, -10, -10));
		UPGRADE_COSTS.put(CityBuildingLevel.NORMAL, new CurrencyTransaction(-10, -10, -10, -10, -10));
		UPGRADE_COSTS.put(CityBuildingLevel.SUPER, CurrencyTransaction.EMPTY);

		INSTANCE = new SpaceBar();
	}


	public static SpaceBar getInstance ()
	{
		return INSTANCE;
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	@NotNull
	public Map<CityBuildingLevel, CurrencyTransaction> getAllUpgradeCosts ()
	{
		return UPGRADE_COSTS;
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	@NotNull
	public Map<CityBuildingLevel, String> getAllNames ()
	{
		return NAMES;
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	@NotNull
	public Map<CityBuildingLevel, MetaDataImage> getAllSprites ()
	{
		return SPRITES;
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	@NotNull
	public Scene getScene ()
	{
		return SCENE;
	}

}
