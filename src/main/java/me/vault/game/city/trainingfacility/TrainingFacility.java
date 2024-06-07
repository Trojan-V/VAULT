package me.vault.game.city.trainingfacility;


import javafx.scene.Scene;
import me.vault.game.city.building.AbsCityBuilding;
import me.vault.game.city.building.CityBuildingLevel;
import me.vault.game.currency.CurrencyTransaction;
import me.vault.game.utility.loading.ResourceLoader;
import me.vault.game.utility.struct.MetaDataImage;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

import static me.vault.game.utility.constant.GameConstants.ASSETS_PATH;


public class TrainingFacility extends AbsCityBuilding
{
	private static final TrainingFacility INSTANCE;


	private static final Scene SCENE = ResourceLoader.loadScene(TrainingFacility.class, "training_facility_view.fxml");


	private static final Map<CityBuildingLevel, String> NAMES = new HashMap<>();


	private static final Map<CityBuildingLevel, MetaDataImage> SPRITES = new HashMap<>();


	private static final Map<CityBuildingLevel, CurrencyTransaction> UPGRADE_COSTS = new HashMap<>();

	static
	{
		NAMES.put(CityBuildingLevel.OLD, "Old Training Facility");
		NAMES.put(CityBuildingLevel.NORMAL, "Training Facility");
		NAMES.put(CityBuildingLevel.SUPER, "Super Training Facility");

		SPRITES.put(CityBuildingLevel.OLD, ResourceLoader.loadImage(ASSETS_PATH + "Item_Pack/training_facility_icon.png"));
		SPRITES.put(CityBuildingLevel.NORMAL, ResourceLoader.loadImage(ASSETS_PATH + "Item_Pack/training_facility_icon.png"));
		SPRITES.put(CityBuildingLevel.SUPER, ResourceLoader.loadImage(ASSETS_PATH + "Item_Pack/training_facility_icon.png"));

		UPGRADE_COSTS.put(CityBuildingLevel.OLD, new CurrencyTransaction(-10, -10, -10, -10, -10));
		UPGRADE_COSTS.put(CityBuildingLevel.NORMAL, new CurrencyTransaction(-10, -10, -10, -10, -10));
		UPGRADE_COSTS.put(CityBuildingLevel.SUPER, CurrencyTransaction.EMPTY);

		INSTANCE = new TrainingFacility();
	}

	public static TrainingFacility getInstance ()
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
	protected @NotNull Map<CityBuildingLevel, MetaDataImage> getSprites ()
	{
		return SPRITES;
	}


	@Override
	protected @NotNull Scene getScene ()
	{
		return SCENE;
	}
}
