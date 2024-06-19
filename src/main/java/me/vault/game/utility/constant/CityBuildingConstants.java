package me.vault.game.utility.constant;


import me.vault.game.model.currency.CurrencyTransaction;
import me.vault.game.utility.loading.ResourceLoader;
import me.vault.game.utility.struct.MetaDataImage;

import static me.vault.game.utility.constant.GameConstants.ASSETS_PATH;


public interface CityBuildingConstants
{

	interface Barracks
	{

		String OLD_NAME = "Old Barracks";

		String NORMAL_NAME = "Barracks";

		String SUPER_NAME = "Super Barracks";

		MetaDataImage OLD_SPRITE = ResourceLoader.loadImage(ASSETS_PATH + "citybuilding/barracks_icon_old.png");

		MetaDataImage NORMAL_SPRITE = ResourceLoader.loadImage(ASSETS_PATH + "citybuilding/barracks_icon_normal.png");

		MetaDataImage SUPER_SPRITE = ResourceLoader.loadImage(ASSETS_PATH + "citybuilding/barracks_icon_super.png");

		CurrencyTransaction OLD_UPGRADE_COSTS = new CurrencyTransaction(-10, -10, -10, -10, -10);

		CurrencyTransaction NORMAL_UPGRADE_COSTS = new CurrencyTransaction(-10, -10, -10, -10, -10);

	}


	interface Market
	{

		String OLD_NAME = "Old Market";

		String NORMAL_NAME = "Market";

		String SUPER_NAME = "Super Market";

		MetaDataImage OLD_SPRITE = ResourceLoader.loadImage(ASSETS_PATH + "citybuilding/market_icon_old.png");

		MetaDataImage NORMAL_SPRITE = ResourceLoader.loadImage(ASSETS_PATH + "citybuilding/market_icon_normal.png");

		MetaDataImage SUPER_SPRITE = ResourceLoader.loadImage(ASSETS_PATH + "citybuilding/market_icon_super.png");

		CurrencyTransaction OLD_UPGRADE_COSTS = new CurrencyTransaction(-10, -10, -10, -10, -10);

		CurrencyTransaction NORMAL_UPGRADE_COSTS = new CurrencyTransaction(-10, -10, -10, -10, -10);

	}


	interface CommandCenter
	{

		String OLD_NAME = "Old Command Center";

		String NORMAL_NAME = "Command Center";

		String SUPER_NAME = "Super Command Center";

		MetaDataImage OLD_SPRITE = ResourceLoader.loadImage(ASSETS_PATH + "citybuilding/commandcenter_icon_old.png");

		MetaDataImage NORMAL_SPRITE = ResourceLoader.loadImage(ASSETS_PATH + "citybuilding/commandcenter_icon_normal.png");

		MetaDataImage SUPER_SPRITE = ResourceLoader.loadImage(ASSETS_PATH + "citybuilding/commandcenter_icon_super.png");

		CurrencyTransaction OLD_UPGRADE_COSTS = new CurrencyTransaction(-10, -10, -10, -10, -10);

		CurrencyTransaction NORMAL_UPGRADE_COSTS = new CurrencyTransaction(-10, -10, -10, -10, -10);

	}


	interface Docks
	{

		String OLD_NAME = "Old Docks";

		String NORMAL_NAME = "Docks";

		String SUPER_NAME = "Super Docks";

		MetaDataImage OLD_SPRITE = ResourceLoader.loadImage(ASSETS_PATH + "citybuilding/docks_icon_old.png");

		MetaDataImage NORMAL_SPRITE = ResourceLoader.loadImage(ASSETS_PATH + "citybuilding/docks_icon_normal.png");

		MetaDataImage SUPER_SPRITE = ResourceLoader.loadImage(ASSETS_PATH + "citybuilding/docks_icon_super.png");

		CurrencyTransaction OLD_UPGRADE_COSTS = new CurrencyTransaction(-10, -10, -10, -10, -10);

		CurrencyTransaction NORMAL_UPGRADE_COSTS = new CurrencyTransaction(-10, -10, -10, -10, -10);

	}


	interface Laboratory
	{

		String OLD_NAME = "Old Laboratory";

		String NORMAL_NAME = "Laboratory";

		String SUPER_NAME = "Super Laboratory";

		MetaDataImage OLD_SPRITE = ResourceLoader.loadImage(ASSETS_PATH + "citybuilding/laboratory_icon_old.png");

		MetaDataImage NORMAL_SPRITE = ResourceLoader.loadImage(ASSETS_PATH + "citybuilding/laboratory_icon_normal.png");

		MetaDataImage SUPER_SPRITE = ResourceLoader.loadImage(ASSETS_PATH + "citybuilding/laboratory_icon_super.png");

		CurrencyTransaction OLD_UPGRADE_COSTS = new CurrencyTransaction(-10, -10, -10, -10, -10);

		CurrencyTransaction NORMAL_UPGRADE_COSTS = new CurrencyTransaction(-10, -10, -10, -10, -10);

	}


	interface SpaceBar
	{

		String OLD_NAME = "Old Space-Bar";

		String NORMAL_NAME = " Space-Bar";

		String SUPER_NAME = "Super Space-Bar";

		MetaDataImage OLD_SPRITE = ResourceLoader.loadImage(ASSETS_PATH + "citybuilding/space_bar_icon_old.png");

		MetaDataImage NORMAL_SPRITE = ResourceLoader.loadImage(ASSETS_PATH + "citybuilding/space_bar_icon_normal.png");

		MetaDataImage SUPER_SPRITE = ResourceLoader.loadImage(ASSETS_PATH + "citybuilding/space_bar_icon_super.png");

		CurrencyTransaction OLD_UPGRADE_COSTS = new CurrencyTransaction(-10, -10, -10, -10, -10);

		CurrencyTransaction NORMAL_UPGRADE_COSTS = new CurrencyTransaction(-10, -10, -10, -10, -10);

	}


	interface TrainingFacility
	{

		String OLD_NAME = "Old Training Facility";

		String NORMAL_NAME = "Training Facility";

		String SUPER_NAME = "Super Training Facility";

		MetaDataImage OLD_SPRITE = ResourceLoader.loadImage(ASSETS_PATH + "citybuilding/training_facility_icon_old.png");

		MetaDataImage NORMAL_SPRITE = ResourceLoader.loadImage(ASSETS_PATH + "citybuilding/training_facility_icon_normal.png");

		MetaDataImage SUPER_SPRITE = ResourceLoader.loadImage(ASSETS_PATH + "citybuilding/training_facility_icon_super.png");

		CurrencyTransaction OLD_UPGRADE_COSTS = new CurrencyTransaction(-10, -10, -10, -10, -10);

		CurrencyTransaction NORMAL_UPGRADE_COSTS = new CurrencyTransaction(-10, -10, -10, -10, -10);

	}

	interface Workshop
	{

		String OLD_NAME = "Old Workshop";

		String NORMAL_NAME = "Workshop";

		String SUPER_NAME = "Super Workshop";

		MetaDataImage OLD_SPRITE = ResourceLoader.loadImage(ASSETS_PATH + "citybuilding/workshop_icon_old.png");

		MetaDataImage NORMAL_SPRITE = ResourceLoader.loadImage(ASSETS_PATH + "citybuilding/workshop_icon_normal.png");

		MetaDataImage SUPER_SPRITE = ResourceLoader.loadImage(ASSETS_PATH + "citybuilding/workshop_icon_super.png");

		CurrencyTransaction OLD_UPGRADE_COSTS = new CurrencyTransaction(-10, -10, -10, -10, -10);

		CurrencyTransaction NORMAL_UPGRADE_COSTS = new CurrencyTransaction(-10, -10, -10, -10, -10);

	}

}
