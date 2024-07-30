package me.vault.game.utility.constant;


import me.vault.game.model.building.CityBuilding;
import me.vault.game.model.currency.CurrencyTransaction;
import me.vault.game.utility.loading.ResourceLoader;
import me.vault.game.utility.struct.MetaDataImage;

import java.util.ArrayList;

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
	 * @see CityBuilding
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
	 * @see CityBuilding
	 * @since 20.06.2024
	 */
	@ConstantInterface
	interface Market
	{

		int STEEL_PRICE = 5;

		int COMPOSITE_PRICE = 5;

		int SCIENCE_PRICE = 5;

		int FOOD_PRICE = 5;

		String STEEL_PROMPT = "%d-1 Rate".formatted(STEEL_PRICE);

		String COMPOSITE_PROMPT = "%d-1 Rate".formatted(COMPOSITE_PRICE);

		String SCIENCE_PROMPT = "%d-1 Rate".formatted(SCIENCE_PRICE);

		String FOOD_PROMPT = "%d-1 Rate".formatted(FOOD_PRICE);

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
	 * @see CityBuilding
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

		String RANDOM_NEWS_ONE = "Breaking: The System is cut off from the rest of the galaxy. Tensions are " + "high with small skirmishes occurring.";

		String RANDOM_NEWS_TWO =
			"Breaking: Despite rising tension in the system, the Explorer-Association announces that " + "ita members find more and more hints that this was a major Hitani system.";

		String RANDOM_NEWS_THREE = "Breaking: The various factions in the system seem to employ the Mega Corporation soldiers more and more.";

		String RANDOM_NEWS_FOUR = "Breaking: The skirmishes escalate, and now it moves to capturing of outposts from each other.";

		ArrayList<String> RANDOM_NEWS_LIST = new ArrayList<>()
		{{
			this.add(RANDOM_NEWS_ONE);
			this.add(RANDOM_NEWS_TWO);
			this.add(RANDOM_NEWS_THREE);
			this.add(RANDOM_NEWS_FOUR);
		}};

	}


	/**
	 * The {@link Docks} subinterface contains all the constants which apply to the {@link me.vault.game.model.city.Docks} city building.
	 *
	 * @author Lasse-Leander Hillen, Vincent Wolf, Timothy Hoegen-Jupp, Alexander Goethel
	 * @see me.vault.game.model.city.Docks
	 * @see CityBuilding
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
	 * @see CityBuilding
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
	 * @see CityBuilding
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
	 * @see CityBuilding
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
	 * @see CityBuilding
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
