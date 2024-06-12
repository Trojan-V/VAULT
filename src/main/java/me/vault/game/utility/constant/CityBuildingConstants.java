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

		MetaDataImage OLD_SPRITE = ResourceLoader.loadImage(ASSETS_PATH + "Item_Pack/barracks_icon.png");

		MetaDataImage NORMAL_SPRITE = ResourceLoader.loadImage(ASSETS_PATH + "Item_Pack/barracks_icon.png");

		MetaDataImage SUPER_SPRITE = ResourceLoader.loadImage(ASSETS_PATH + "Item_Pack/barracks_icon.png");

		CurrencyTransaction OLD_UPGRADE_COSTS = new CurrencyTransaction(-10, -10, -10, -10, -10);

		CurrencyTransaction NORMAL_UPGRADE_COSTS = new CurrencyTransaction(-10, -10, -10, -10, -10);

	}

}
