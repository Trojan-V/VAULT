package me.vault.game.utility.constant;


import me.vault.game.model.building.CityBuilding;
import me.vault.game.model.currency.CurrencyTransaction;
import me.vault.game.utility.loading.ResourceLoader;
import me.vault.game.utility.struct.MetaDataImage;

import java.util.ArrayList;
import java.util.List;

import static me.vault.game.utility.constant.ConstantInterface.Constant;
import static me.vault.game.utility.constant.GameConstants.ASSETS_PATH;


/**
 * This interface contains constants related to the {@link CityBuilding}.
 *
 * @author Vincent Wolf, Lasse-Leander Hillen, Timothy Hoegen-Jupp, Alexander Goethel
 * @version 1.0.0
 * @see CityBuildingConstants
 * @since 30.07.2024
 */
@ConstantInterface
public interface CityBuildingConstants
{

	/**
	 * The {@link Barracks} subinterface contains all the constants which apply to the {@link Barracks} city building.
	 *
	 * @author Vincent Wolf, Lasse-Leander Hillen, Timothy Hoegen-Jupp, Alexander Goethel
	 * @see Barracks
	 * @see CityBuilding
	 * @since 20.06.2024
	 */
	@ConstantInterface
	interface Barracks
	{

		/**
		 * The display name of the old barracks.
		 */
		@Constant
		String OLD_NAME = "Old Barracks";


		/**
		 * The display name of the normal barracks.
		 */
		@Constant
		String NORMAL_NAME = "Barracks";


		/**
		 * The display name of the super barracks.
		 */
		@Constant
		String SUPER_NAME = "Super Barracks";


		/**
		 * The sprite of the old barracks.
		 */
		@Constant
		MetaDataImage OLD_SPRITE = ResourceLoader.loadImage(ASSETS_PATH + "citybuilding/barracks_icon_old.png");


		/**
		 * The sprite of the normal barracks.
		 */
		@Constant
		MetaDataImage NORMAL_SPRITE = ResourceLoader.loadImage(ASSETS_PATH + "citybuilding/barracks_icon_normal.png");


		/**
		 * The sprite of the super barracks.
		 */
		@Constant
		MetaDataImage SUPER_SPRITE = ResourceLoader.loadImage(ASSETS_PATH + "citybuilding/barracks_icon_super.png");


		/**
		 * The upgrade costs of the old barracks.
		 */
		@Constant
		CurrencyTransaction OLD_UPGRADE_COSTS = new CurrencyTransaction(-1000, -1000, -1000, -500, -200);


		/**
		 * The upgrade costs of the normal barracks.
		 */
		@Constant
		CurrencyTransaction NORMAL_UPGRADE_COSTS = new CurrencyTransaction(-2000, -2000, -5000, -1000, -400);

	}


	/**
	 * The {@link Market} subinterface contains all the constants which apply to the {@link me.vault.game.model.city.Market} city building.
	 *
	 * @author Vincent Wolf, Lasse-Leander Hillen, Timothy Hoegen-Jupp, Alexander Goethel
	 * @see me.vault.game.model.city.Market
	 * @see CityBuilding
	 * @since 20.06.2024
	 */
	@ConstantInterface
	interface Market
	{

		/**
		 * The price for one steel.
		 */
		int STEEL_PRICE = 5;


		/**
		 * The price for one composite.
		 */
		int COMPOSITE_PRICE = 5;


		/**
		 * The price for one science.
		 */
		int SCIENCE_PRICE = 5;


		/**
		 * The price for one food.
		 */
		int FOOD_PRICE = 5;


		/**
		 * The prompt for the text field that displays the steel price.
		 */
		String STEEL_PROMPT = "%d-1 Rate".formatted(STEEL_PRICE);


		/**
		 * The prompt for the text field that displays the composite price.
		 */
		String COMPOSITE_PROMPT = "%d-1 Rate".formatted(COMPOSITE_PRICE);


		/**
		 * The prompt for the text field that displays the science price.
		 */
		String SCIENCE_PROMPT = "%d-1 Rate".formatted(SCIENCE_PRICE);


		/**
		 * The prompt for the text field that displays the food price.
		 */
		String FOOD_PROMPT = "%d-1 Rate".formatted(FOOD_PRICE);


		/**
		 * The display name of the old market.
		 */
		@Constant
		String OLD_NAME = "Old Market";


		/**
		 * The display name of the normal market.
		 */
		@Constant
		String NORMAL_NAME = "Market";


		/**
		 * The display name of the super market.
		 */
		@Constant
		String SUPER_NAME = "Super Market";


		/**
		 * The sprite of the old market.
		 */
		@Constant
		MetaDataImage OLD_SPRITE = ResourceLoader.loadImage(ASSETS_PATH + "citybuilding/market_icon_old.png");


		/**
		 * The sprite of the normal market.
		 */
		@Constant
		MetaDataImage NORMAL_SPRITE = ResourceLoader.loadImage(ASSETS_PATH + "citybuilding/market_icon_normal.png");


		/**
		 * The sprite of the super market.
		 */
		@Constant
		MetaDataImage SUPER_SPRITE = ResourceLoader.loadImage(ASSETS_PATH + "citybuilding/market_icon_super.png");


		/**
		 * The upgrade costs of the old market.
		 */
		@Constant
		CurrencyTransaction OLD_UPGRADE_COSTS = new CurrencyTransaction(-1000, -1000, -1000, -500, -200);


		/**
		 * The upgrade costs of the normal market.
		 */
		@Constant
		CurrencyTransaction NORMAL_UPGRADE_COSTS = new CurrencyTransaction(-2000, -2000, -5000, -1000, -400);

	}


	/**
	 * The {@link CommandCenter} subinterface contains all the constants which apply to the {@link me.vault.game.model.city.CommandCenter} city building.
	 *
	 * @author Vincent Wolf, Lasse-Leander Hillen, Timothy Hoegen-Jupp, Alexander Goethel
	 * @see me.vault.game.model.city.CommandCenter
	 * @see CityBuilding
	 * @since 20.06.2024
	 */
	@ConstantInterface
	interface CommandCenter
	{

		/**
		 * The display name of the old command center.
		 */
		@Constant
		String OLD_NAME = "Old Command Center";


		/**
		 * The display name of the normal command center.
		 */
		@Constant
		String NORMAL_NAME = "Command Center";


		/**
		 * The display name of the super command center.
		 */
		@Constant
		String SUPER_NAME = "Super Command Center";


		/**
		 * The sprite of the old command center.
		 */
		@Constant
		MetaDataImage OLD_SPRITE = ResourceLoader.loadImage(ASSETS_PATH + "citybuilding/commandcenter_icon_old.png");


		/**
		 * The sprite of the normal command center.
		 */
		@Constant
		MetaDataImage NORMAL_SPRITE = ResourceLoader.loadImage(ASSETS_PATH + "citybuilding/commandcenter_icon_normal.png");


		/**
		 * The sprite of the super command center.
		 */
		@Constant
		MetaDataImage SUPER_SPRITE = ResourceLoader.loadImage(ASSETS_PATH + "citybuilding/commandcenter_icon_super.png");


		/**
		 * The upgrade costs of the old command center.
		 */
		@Constant
		CurrencyTransaction OLD_UPGRADE_COSTS = new CurrencyTransaction(-1000, -1000, -1000, -500, -200);


		/**
		 * The upgrade costs of the normal command center.
		 */
		@Constant
		CurrencyTransaction NORMAL_UPGRADE_COSTS = new CurrencyTransaction(-2000, -2000, -5000, -1000, -400);


		/**
		 * Some random news that gets displayed in the command center.
		 */
		String RANDOM_NEWS_ONE = "Breaking: The System is cut off from the rest of the galaxy. Tensions are " + "high with small skirmishes occurring.";


		/**
		 * Some random news that gets displayed in the command center.
		 */
		String RANDOM_NEWS_TWO =
			"Breaking: Despite rising tension in the system, the Explorer-Association announces that " +
			"ita members find more and more hints that this was a major Hitani system.";


		/**
		 * Some random news that gets displayed in the command center.
		 */
		String RANDOM_NEWS_THREE = "Breaking: The various factions in the system seem to employ the Mega Corporation soldiers more and more.";


		/**
		 * Some random news that gets displayed in the command center.
		 */
		String RANDOM_NEWS_FOUR = "Breaking: The skirmishes escalate, and now it moves to capturing of outposts from each other.";


		/**
		 * A {@link List} that contains all random news.
		 */
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
	 * @author Vincent Wolf, Lasse-Leander Hillen, Timothy Hoegen-Jupp, Alexander Goethel
	 * @see me.vault.game.model.city.Docks
	 * @see CityBuilding
	 * @since 20.06.2024
	 */
	@ConstantInterface
	interface Docks
	{

		/**
		 * The display name of the old docks.
		 */
		@Constant
		String OLD_NAME = "Old Docks";


		/**
		 * The display name of the normal docks.
		 */
		@Constant
		String NORMAL_NAME = "Docks";


		/**
		 * The display name of the super docks.
		 */
		@Constant
		String SUPER_NAME = "Super Docks";


		/**
		 * The sprite of the old docks.
		 */
		@Constant
		MetaDataImage OLD_SPRITE = ResourceLoader.loadImage(ASSETS_PATH + "citybuilding/docks_icon_old.png");


		/**
		 * The sprite of the normal docks.
		 */
		@Constant
		MetaDataImage NORMAL_SPRITE = ResourceLoader.loadImage(ASSETS_PATH + "citybuilding/docks_icon_normal.png");


		/**
		 * The sprite of the super docks.
		 */
		@Constant
		MetaDataImage SUPER_SPRITE = ResourceLoader.loadImage(ASSETS_PATH + "citybuilding/docks_icon_super.png");


		/**
		 * The upgrade costs of the old docks.
		 */
		@Constant
		CurrencyTransaction OLD_UPGRADE_COSTS = new CurrencyTransaction(-1000, -1000, -1000, -500, -200);


		/**
		 * The upgrade costs of the normal docks.
		 */
		@Constant
		CurrencyTransaction NORMAL_UPGRADE_COSTS = new CurrencyTransaction(-2000, -2000, -5000, -1000, -400);

	}


	/**
	 * The {@link Laboratory} subinterface contains all the constants which apply to the {@link me.vault.game.model.city.Laboratory} city building.
	 *
	 * @author Vincent Wolf, Lasse-Leander Hillen, Timothy Hoegen-Jupp, Alexander Goethel
	 * @see me.vault.game.model.city.Laboratory
	 * @see CityBuilding
	 * @since 20.06.2024
	 */
	@ConstantInterface
	interface Laboratory
	{

		/**
		 * The display name of the old laboratory.
		 */
		@Constant
		String OLD_NAME = "Old Laboratory";


		/**
		 * The display name of the normal laboratory.
		 */
		@Constant
		String NORMAL_NAME = "Laboratory";


		/**
		 * The display name of the super laboratory.
		 */
		@Constant
		String SUPER_NAME = "Super Laboratory";


		/**
		 * The sprite of the old laboratory.
		 */
		@Constant
		MetaDataImage OLD_SPRITE = ResourceLoader.loadImage(ASSETS_PATH + "citybuilding/laboratory_icon_old.png");


		/**
		 * The sprite of the normal laboratory.
		 */
		@Constant
		MetaDataImage NORMAL_SPRITE = ResourceLoader.loadImage(ASSETS_PATH + "citybuilding/laboratory_icon_normal.png");


		/**
		 * The sprite of the super laboratory.
		 */
		@Constant
		MetaDataImage SUPER_SPRITE = ResourceLoader.loadImage(ASSETS_PATH + "citybuilding/laboratory_icon_super.png");


		/**
		 * The upgrade costs of the old laboratory.
		 */
		@Constant
		CurrencyTransaction OLD_UPGRADE_COSTS = new CurrencyTransaction(-1000, -1000, -1000, -500, -200);


		/**
		 * The upgrade costs of the normal laboratory.
		 */
		@Constant
		CurrencyTransaction NORMAL_UPGRADE_COSTS = new CurrencyTransaction(-2000, -2000, -5000, -1000, -400);

	}


	/**
	 * The {@link SpaceBar} subinterface contains all the constants which apply to the {@link me.vault.game.model.city.SpaceBar} city building.
	 *
	 * @author Vincent Wolf, Lasse-Leander Hillen, Timothy Hoegen-Jupp, Alexander Goethel
	 * @see me.vault.game.model.city.SpaceBar
	 * @see CityBuilding
	 * @since 20.06.2024
	 */
	@ConstantInterface
	interface SpaceBar
	{

		/**
		 * The display name of the old space bar.
		 */
		@Constant
		String OLD_NAME = "Old Space Bar";


		/**
		 * The display name of the normal space bar.
		 */
		@Constant
		String NORMAL_NAME = " Space Bar";


		/**
		 * The display name of the super space bar.
		 */
		@Constant
		String SUPER_NAME = "Super Space Bar";


		/**
		 * The sprite of the old space bar.
		 */
		@Constant
		MetaDataImage OLD_SPRITE = ResourceLoader.loadImage(ASSETS_PATH + "citybuilding/space_bar_icon_old.png");


		/**
		 * The sprite of the normal space bar.
		 */
		@Constant
		MetaDataImage NORMAL_SPRITE = ResourceLoader.loadImage(ASSETS_PATH + "citybuilding/space_bar_icon_normal.png");


		/**
		 * The sprite of the super space bar.
		 */
		@Constant
		MetaDataImage SUPER_SPRITE = ResourceLoader.loadImage(ASSETS_PATH + "citybuilding/space_bar_icon_super.png");


		/**
		 * The upgrade costs of the old space bar.
		 */
		@Constant
		CurrencyTransaction OLD_UPGRADE_COSTS = new CurrencyTransaction(-1000, -1000, -1000, -500, -200);


		/**
		 * The upgrade costs of the normal space bar.
		 */
		@Constant
		CurrencyTransaction NORMAL_UPGRADE_COSTS = new CurrencyTransaction(-2000, -2000, -5000, -1000, -400);

	}


	/**
	 * The {@link TrainingFacility} subinterface contains all the constants which apply to the {@link me.vault.game.model.city.TrainingFacility} city building.
	 *
	 * @author Vincent Wolf, Lasse-Leander Hillen, Timothy Hoegen-Jupp, Alexander Goethel
	 * @see me.vault.game.model.city.TrainingFacility
	 * @see CityBuilding
	 * @since 20.06.2024
	 */
	@ConstantInterface
	interface TrainingFacility
	{

		/**
		 * The display name of the old training facility.
		 */
		@Constant
		String OLD_NAME = "Old Training Facility";


		/**
		 * The display name of the normal training facility.
		 */
		@Constant
		String NORMAL_NAME = "Training Facility";


		/**
		 * The display name of the super training facility.
		 */
		@Constant
		String SUPER_NAME = "Super Training Facility";


		/**
		 * The sprite of the old training facility.
		 */
		@Constant
		MetaDataImage OLD_SPRITE = ResourceLoader.loadImage(ASSETS_PATH + "citybuilding/training_facility_icon_old.png");


		/**
		 * The sprite of the normal training facility.
		 */
		@Constant
		MetaDataImage NORMAL_SPRITE = ResourceLoader.loadImage(ASSETS_PATH + "citybuilding/training_facility_icon_normal.png");


		/**
		 * The sprite of the super training facility.
		 */
		@Constant
		MetaDataImage SUPER_SPRITE = ResourceLoader.loadImage(ASSETS_PATH + "citybuilding/training_facility_icon_super.png");


		/**
		 * The upgrade costs of the old training facility.
		 */
		@Constant
		CurrencyTransaction OLD_UPGRADE_COSTS = new CurrencyTransaction(-1000, -1000, -1000, -500, -200);


		/**
		 * The upgrade costs of the normal training facility.
		 */
		@Constant
		CurrencyTransaction NORMAL_UPGRADE_COSTS = new CurrencyTransaction(-2000, -2000, -5000, -1000, -400);

	}


	/**
	 * The {@link Workshop} subinterface contains all the constants which apply to the {@link me.vault.game.model.city.Workshop} city building.
	 *
	 * @author Vincent Wolf, Lasse-Leander Hillen, Timothy Hoegen-Jupp, Alexander Goethel
	 * @see me.vault.game.model.city.Workshop
	 * @see CityBuilding
	 * @since 20.06.2024
	 */
	@ConstantInterface
	interface Workshop
	{

		/**
		 * The display name of the old workshop.
		 */
		@Constant
		String OLD_NAME = "Old Workshop";


		/**
		 * The display name of the normal workshop.
		 */
		@Constant
		String NORMAL_NAME = "Workshop";


		/**
		 * The display name of the super workshop.
		 */
		@Constant
		String SUPER_NAME = "Super Workshop";


		/**
		 * The sprite of the old workshop.
		 */
		@Constant
		MetaDataImage OLD_SPRITE = ResourceLoader.loadImage(ASSETS_PATH + "citybuilding/workshop_icon_old.png");


		/**
		 * The sprite of the normal workshop.
		 */
		@Constant
		MetaDataImage NORMAL_SPRITE = ResourceLoader.loadImage(ASSETS_PATH + "citybuilding/workshop_icon_normal.png");


		/**
		 * The sprite of the super workshop.
		 */
		@Constant
		MetaDataImage SUPER_SPRITE = ResourceLoader.loadImage(ASSETS_PATH + "citybuilding/workshop_icon_super.png");


		/**
		 * The upgrade costs of the old workshop.
		 */
		@Constant
		CurrencyTransaction OLD_UPGRADE_COSTS = new CurrencyTransaction(-1000, -1000, -1000, -500, -200);


		/**
		 * The upgrade costs of the normal workshop.
		 */
		@Constant
		CurrencyTransaction NORMAL_UPGRADE_COSTS = new CurrencyTransaction(-2000, -2000, -5000, -1000, -400);

	}

}
