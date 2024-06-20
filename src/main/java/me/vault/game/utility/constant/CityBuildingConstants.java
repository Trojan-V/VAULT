package me.vault.game.utility.constant;


import me.vault.game.model.currency.CurrencyTransaction;
import me.vault.game.utility.loading.ResourceLoader;
import me.vault.game.utility.struct.MetaDataImage;

import static me.vault.game.utility.constant.ConstantInterface.Constant;
import static me.vault.game.utility.constant.GameConstants.ASSETS_PATH;


@ConstantInterface
public interface CityBuildingConstants
{

	/**
	 * The {@link Barracks} subinterface contains all the constants which apply to the {@link me.vault.game.model.city.Barracks} city building.
	 *
	 * @author Lasse-Leander Hillen, Vincent Wolf, Timothy Hoegen-Jupp, Alexander Goethel
	 * @see me.vault.game.model.city.Barracks
	 * @see me.vault.game.model.building.CityBuilding
	 * @since 20.06.2024
	 */
	@ConstantInterface
	interface Barracks
	{

		@Constant
		String OLD_NAME = "Old Barracks";

		@Constant
		String NORMAL_NAME = "Barracks";

		@Constant
		String SUPER_NAME = "Super Barracks";

		@Constant
		MetaDataImage OLD_SPRITE = ResourceLoader.loadImage(ASSETS_PATH + "citybuilding/barracks_icon_old.png");

		@Constant
		MetaDataImage NORMAL_SPRITE = ResourceLoader.loadImage(ASSETS_PATH + "citybuilding/barracks_icon_normal.png");

		@Constant
		MetaDataImage SUPER_SPRITE = ResourceLoader.loadImage(ASSETS_PATH + "citybuilding/barracks_icon_super.png");

		@Constant
		CurrencyTransaction OLD_UPGRADE_COSTS = new CurrencyTransaction(-1000, -1000, -1000, -500, -200);

		@Constant
		CurrencyTransaction NORMAL_UPGRADE_COSTS = new CurrencyTransaction(-2000, -2000, -5000, -1000, -400);

	}


	/**
	 * The {@link Market} subinterface contains all the constants which apply to the {@link me.vault.game.model.city.Market} city building.
	 *
	 * @author Lasse-Leander Hillen, Vincent Wolf, Timothy Hoegen-Jupp, Alexander Goethel
	 * @see me.vault.game.model.city.Market
	 * @see me.vault.game.model.building.CityBuilding
	 * @since 20.06.2024
	 */
	@ConstantInterface
	interface Market
	{

		@Constant
		String OLD_NAME = "Old Market";

		@Constant
		String NORMAL_NAME = "Market";

		@Constant
		String SUPER_NAME = "Super Market";

		@Constant
		MetaDataImage OLD_SPRITE = ResourceLoader.loadImage(ASSETS_PATH + "citybuilding/market_icon_old.png");

		@Constant
		MetaDataImage NORMAL_SPRITE = ResourceLoader.loadImage(ASSETS_PATH + "citybuilding/market_icon_normal.png");

		@Constant
		MetaDataImage SUPER_SPRITE = ResourceLoader.loadImage(ASSETS_PATH + "citybuilding/market_icon_super.png");

		@Constant
		CurrencyTransaction OLD_UPGRADE_COSTS = new CurrencyTransaction(-1000, -1000, -1000, -500, -200);

		@Constant
		CurrencyTransaction NORMAL_UPGRADE_COSTS = new CurrencyTransaction(-2000, -2000, -5000, -1000, -400);

	}


	/**
	 * The {@link CommandCenter} subinterface contains all the constants which apply to the {@link me.vault.game.model.city.CommandCenter} city building.
	 *
	 * @author Lasse-Leander Hillen, Vincent Wolf, Timothy Hoegen-Jupp, Alexander Goethel
	 * @see me.vault.game.model.city.CommandCenter
	 * @see me.vault.game.model.building.CityBuilding
	 * @since 20.06.2024
	 */
	@ConstantInterface
	interface CommandCenter
	{

		@Constant
		String OLD_NAME = "Old Command Center";

		@Constant
		String NORMAL_NAME = "Command Center";

		@Constant
		String SUPER_NAME = "Super Command Center";

		@Constant
		MetaDataImage OLD_SPRITE = ResourceLoader.loadImage(ASSETS_PATH + "citybuilding/commandcenter_icon_old.png");

		@Constant
		MetaDataImage NORMAL_SPRITE = ResourceLoader.loadImage(ASSETS_PATH + "citybuilding/commandcenter_icon_normal.png");

		@Constant
		MetaDataImage SUPER_SPRITE = ResourceLoader.loadImage(ASSETS_PATH + "citybuilding/commandcenter_icon_super.png");

		@Constant
		CurrencyTransaction OLD_UPGRADE_COSTS = new CurrencyTransaction(-1000, -1000, -1000, -500, -200);

		@Constant
		CurrencyTransaction NORMAL_UPGRADE_COSTS = new CurrencyTransaction(-2000, -2000, -5000, -1000, -400);

	}


	/**
	 * The {@link Docks} subinterface contains all the constants which apply to the {@link me.vault.game.model.city.Docks} city building.
	 *
	 * @author Lasse-Leander Hillen, Vincent Wolf, Timothy Hoegen-Jupp, Alexander Goethel
	 * @see me.vault.game.model.city.Docks
	 * @see me.vault.game.model.building.CityBuilding
	 * @since 20.06.2024
	 */
	@ConstantInterface
	interface Docks
	{

		@Constant
		String OLD_NAME = "Old Docks";

		@Constant
		String NORMAL_NAME = "Docks";

		@Constant
		String SUPER_NAME = "Super Docks";

		@Constant
		MetaDataImage OLD_SPRITE = ResourceLoader.loadImage(ASSETS_PATH + "citybuilding/docks_icon_old.png");

		@Constant
		MetaDataImage NORMAL_SPRITE = ResourceLoader.loadImage(ASSETS_PATH + "citybuilding/docks_icon_normal.png");

		@Constant
		MetaDataImage SUPER_SPRITE = ResourceLoader.loadImage(ASSETS_PATH + "citybuilding/docks_icon_super.png");

		@Constant
		CurrencyTransaction OLD_UPGRADE_COSTS = new CurrencyTransaction(-1000, -1000, -1000, -500, -200);

		@Constant
		CurrencyTransaction NORMAL_UPGRADE_COSTS = new CurrencyTransaction(-2000, -2000, -5000, -1000, -400);

	}


	/**
	 * The {@link Laboratory} subinterface contains all the constants which apply to the {@link me.vault.game.model.city.Laboratory} city building.
	 *
	 * @author Lasse-Leander Hillen, Vincent Wolf, Timothy Hoegen-Jupp, Alexander Goethel
	 * @see me.vault.game.model.city.Laboratory
	 * @see me.vault.game.model.building.CityBuilding
	 * @since 20.06.2024
	 */
	@ConstantInterface
	interface Laboratory
	{

		@Constant
		String OLD_NAME = "Old Laboratory";

		@Constant
		String NORMAL_NAME = "Laboratory";

		@Constant
		String SUPER_NAME = "Super Laboratory";

		@Constant
		MetaDataImage OLD_SPRITE = ResourceLoader.loadImage(ASSETS_PATH + "citybuilding/laboratory_icon_old.png");

		@Constant
		MetaDataImage NORMAL_SPRITE = ResourceLoader.loadImage(ASSETS_PATH + "citybuilding/laboratory_icon_normal.png");

		@Constant
		MetaDataImage SUPER_SPRITE = ResourceLoader.loadImage(ASSETS_PATH + "citybuilding/laboratory_icon_super.png");

		@Constant
		CurrencyTransaction OLD_UPGRADE_COSTS = new CurrencyTransaction(-1000, -1000, -1000, -500, -200);

		@Constant
		CurrencyTransaction NORMAL_UPGRADE_COSTS = new CurrencyTransaction(-2000, -2000, -5000, -1000, -400);

	}


	/**
	 * The {@link SpaceBar} subinterface contains all the constants which apply to the {@link me.vault.game.model.city.SpaceBar} city building.
	 *
	 * @author Lasse-Leander Hillen, Vincent Wolf, Timothy Hoegen-Jupp, Alexander Goethel
	 * @see me.vault.game.model.city.SpaceBar
	 * @see me.vault.game.model.building.CityBuilding
	 * @since 20.06.2024
	 */
	@ConstantInterface
	interface SpaceBar
	{

		@Constant
		String OLD_NAME = "Old Space-Bar";

		@Constant
		String NORMAL_NAME = " Space-Bar";

		@Constant
		String SUPER_NAME = "Super Space-Bar";

		@Constant
		MetaDataImage OLD_SPRITE = ResourceLoader.loadImage(ASSETS_PATH + "citybuilding/space_bar_icon_old.png");

		@Constant
		MetaDataImage NORMAL_SPRITE = ResourceLoader.loadImage(ASSETS_PATH + "citybuilding/space_bar_icon_normal.png");

		@Constant
		MetaDataImage SUPER_SPRITE = ResourceLoader.loadImage(ASSETS_PATH + "citybuilding/space_bar_icon_super.png");

		@Constant
		CurrencyTransaction OLD_UPGRADE_COSTS = new CurrencyTransaction(-1000, -1000, -1000, -500, -200);

		@Constant
		CurrencyTransaction NORMAL_UPGRADE_COSTS = new CurrencyTransaction(-2000, -2000, -5000, -1000, -400);

	}


	/**
	 * The {@link TrainingFacility} subinterface contains all the constants which apply to the {@link me.vault.game.model.city.TrainingFacility} city building.
	 *
	 * @author Lasse-Leander Hillen, Vincent Wolf, Timothy Hoegen-Jupp, Alexander Goethel
	 * @see me.vault.game.model.city.TrainingFacility
	 * @see me.vault.game.model.building.CityBuilding
	 * @since 20.06.2024
	 */
	@ConstantInterface
	interface TrainingFacility
	{

		@Constant
		String OLD_NAME = "Old Training Facility";

		@Constant
		String NORMAL_NAME = "Training Facility";

		@Constant
		String SUPER_NAME = "Super Training Facility";

		@Constant
		MetaDataImage OLD_SPRITE = ResourceLoader.loadImage(ASSETS_PATH + "citybuilding/training_facility_icon_old.png");

		@Constant
		MetaDataImage NORMAL_SPRITE = ResourceLoader.loadImage(ASSETS_PATH + "citybuilding/training_facility_icon_normal.png");

		@Constant
		MetaDataImage SUPER_SPRITE = ResourceLoader.loadImage(ASSETS_PATH + "citybuilding/training_facility_icon_super.png");

		@Constant
		CurrencyTransaction OLD_UPGRADE_COSTS = new CurrencyTransaction(-1000, -1000, -1000, -500, -200);

		@Constant
		CurrencyTransaction NORMAL_UPGRADE_COSTS = new CurrencyTransaction(-2000, -2000, -5000, -1000, -400);

	}


	/**
	 * The {@link Workshop} subinterface contains all the constants which apply to the {@link me.vault.game.model.city.Workshop} city building.
	 *
	 * @author Lasse-Leander Hillen, Vincent Wolf, Timothy Hoegen-Jupp, Alexander Goethel
	 * @see me.vault.game.model.city.Workshop
	 * @see me.vault.game.model.building.CityBuilding
	 * @since 20.06.2024
	 */
	@ConstantInterface
	interface Workshop
	{

		@Constant
		String OLD_NAME = "Old Workshop";

		@Constant
		String NORMAL_NAME = "Workshop";

		@Constant
		String SUPER_NAME = "Super Workshop";

		@Constant
		MetaDataImage OLD_SPRITE = ResourceLoader.loadImage(ASSETS_PATH + "citybuilding/workshop_icon_old.png");

		@Constant
		MetaDataImage NORMAL_SPRITE = ResourceLoader.loadImage(ASSETS_PATH + "citybuilding/workshop_icon_normal.png");

		@Constant
		MetaDataImage SUPER_SPRITE = ResourceLoader.loadImage(ASSETS_PATH + "citybuilding/workshop_icon_super.png");

		@Constant
		CurrencyTransaction OLD_UPGRADE_COSTS = new CurrencyTransaction(-1000, -1000, -1000, -500, -200);

		@Constant
		CurrencyTransaction NORMAL_UPGRADE_COSTS = new CurrencyTransaction(-2000, -2000, -5000, -1000, -400);

	}

}
