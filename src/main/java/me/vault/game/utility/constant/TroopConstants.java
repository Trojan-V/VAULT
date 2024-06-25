package me.vault.game.utility.constant;


import me.vault.game.model.currency.CurrencyTransaction;
import me.vault.game.model.troop.DefensiveStatistic;
import me.vault.game.model.troop.DexterityStatistic;
import me.vault.game.model.troop.OffensiveStatistics;
import me.vault.game.model.troop.TroopStatistics;
import me.vault.game.utility.loading.ResourceLoader;
import me.vault.game.utility.struct.MetaDataImage;

import static me.vault.game.utility.constant.ConstantInterface.Constant;


/**
 * This class provides constants for the unit statistics.
 *
 * @author Alexander Goethel, Lasse-Leander Hillen
 * @version 1.0.0
 * @since 29.05.2024
 */
public interface TroopConstants
{


	/**
	 * The {@link Sniper} subinterface contains all constants, which apply to the Sniper troop class.
	 *
	 * @author Lasse-Leander Hillen
	 * @see me.vault.game.model.troop.impl.Sniper
	 * @see me.vault.game.model.troop.Troop
	 * @since 21.06.2024
	 */
	@ConstantInterface
	interface Sniper
	{

		/**
		 * A constant which represents the base name of the sniper troop.
		 */
		@Constant
		String SINGLE_NAME = "Sniper Single Combatant";

		/**
		 * A constant which represents the name of the improved sniper troop.
		 */
		@Constant
		String COUPLE_NAME = "Sniper Couple";

		/**
		 * A constant which represents the name of the maxed sniper troop.
		 */
		@Constant
		String SQUAD_NAME = "Sniper Squad";

		/**
		 * A constant which represents the base sprite of the sniper troop.
		 */
		@Constant
		MetaDataImage SINGLE_SPRITE = ResourceLoader.loadImage(GameConstants.ASSETS_PATH + "troops/sniper_icon.png");

		/**
		 * A constant which represents the sprite of the improved sniper troop.
		 */
		@Constant
		MetaDataImage COUPLE_SPRITE = ResourceLoader.loadImage(GameConstants.ASSETS_PATH + "troops/sniper_icon.png");

		/**
		 * A constant which represents the sprite of the maxed sniper troop.
		 */
		@Constant
		MetaDataImage SQUAD_SPRITE = ResourceLoader.loadImage(GameConstants.ASSETS_PATH + "troops/sniper_icon.png");

		/**
		 * A constant which represents the base upgrade cost of the sniper troop.
		 */
		@Constant
		CurrencyTransaction SINGLE_UPGRADE_COST = new CurrencyTransaction(-100, -100, -100, -100, -100);

		/**
		 * A constant which represents the upgrade cost of the improved sniper troop.
		 */
		@Constant
		CurrencyTransaction COUPLE_UPGRADE_COST = new CurrencyTransaction(-150, -150, -150, -150, -150);

		/**
		 * A constant which represents the upgrade cost of the maxed sniper troop.
		 */
		@Constant
		CurrencyTransaction SQUAD_UPGRADE_COST = CurrencyTransaction.EMPTY;

		/**
		 * A constant which represents the attributes of the sniper troop.
		 */
		@Constant
		TroopStatistics SNIPER_STATISTICS = new TroopStatistics(
			new DexterityStatistic(1, 2),
			new DefensiveStatistic(25, 5, 15, 20),
			new OffensiveStatistics(0, 24, 0, 0, 0));

	}


	/**
	 * The {@link Ranger} subinterface contains all constants, which apply to the Ranger troop class.
	 *
	 * @author Lasse-Leander Hillen
	 * @see me.vault.game.model.troop.impl.Ranger
	 * @see me.vault.game.model.troop.Troop
	 * @since 21.06.2024
	 */
	@ConstantInterface
	interface Ranger
	{

		/**
		 * A constant which represents the base name of the sniper troop.
		 */
		@Constant
		String SINGLE_NAME = "Ranger Single Combatant";

		/**
		 * A constant which represents the name of the improved sniper troop.
		 */
		@Constant
		String COUPLE_NAME = "Ranger Couple";

		/**
		 * A constant which represents the name of the maxed sniper troop.
		 */
		@Constant
		String SQUAD_NAME = "Ranger Squad";

		/**
		 * A constant which represents the base sprite of the sniper troop.
		 */
		@Constant
		MetaDataImage SINGLE_SPRITE = ResourceLoader.loadImage(GameConstants.ASSETS_PATH + "troops/ranger_icon.png");

		/**
		 * A constant which represents the sprite of the improved sniper troop.
		 */
		@Constant
		MetaDataImage COUPLE_SPRITE = ResourceLoader.loadImage(GameConstants.ASSETS_PATH + "troops/ranger_icon.png");

		/**
		 * A constant which represents the sprite of the maxed sniper troop.
		 */
		@Constant
		MetaDataImage SQUAD_SPRITE = ResourceLoader.loadImage(GameConstants.ASSETS_PATH + "troops/ranger_icon.png");

		/**
		 * A constant which represents the base upgrade cost of the sniper troop.
		 */
		@Constant
		CurrencyTransaction SINGLE_UPGRADE_COST = new CurrencyTransaction(-100, -100, -100, -100, -100);

		/**
		 * A constant which represents the upgrade cost of the improved sniper troop.
		 */
		@Constant
		CurrencyTransaction COUPLE_UPGRADE_COST = new CurrencyTransaction(-150, -150, -150, -150, -150);

		/**
		 * A constant which represents the upgrade cost of the maxed sniper troop.
		 */
		@Constant
		CurrencyTransaction SQUAD_UPGRADE_COST = CurrencyTransaction.EMPTY;

		/**
		 * A constant which represents the attributes of the sniper troop.
		 */

		@Constant
		TroopStatistics RANGER_STATISTICS = new TroopStatistics(
			new DexterityStatistic(4, 1),
			new DefensiveStatistic(46, 20, 25, 15),
			new OffensiveStatistics(5, 22, 16, 1, 1));

	}


	/**
	 * The {@link Medic} subinterface contains all constants, which apply to the Medic troop class.
	 *
	 * @author Lasse-Leander Hillen
	 * @see me.vault.game.model.troop.impl.Medic
	 * @see me.vault.game.model.troop.Troop
	 * @since 21.06.2024
	 */
	@ConstantInterface
	interface Medic
	{

		/**
		 * A constant which represents the base name of the sniper troop.
		 */
		@Constant
		String SINGLE_NAME = "Medic Single Combatant";

		/**
		 * A constant which represents the name of the improved sniper troop.
		 */
		@Constant
		String COUPLE_NAME = "Medic Couple";

		/**
		 * A constant which represents the name of the maxed sniper troop.
		 */
		@Constant
		String SQUAD_NAME = "Medic Squad";

		/**
		 * A constant which represents the base sprite of the sniper troop.
		 */
		@Constant
		MetaDataImage SINGLE_SPRITE = ResourceLoader.loadImage(GameConstants.ASSETS_PATH + "troops/medic_icon.png");

		/**
		 * A constant which represents the sprite of the improved sniper troop.
		 */
		@Constant
		MetaDataImage COUPLE_SPRITE = ResourceLoader.loadImage(GameConstants.ASSETS_PATH + "troops/medic_icon.png");

		/**
		 * A constant which represents the sprite of the maxed sniper troop.
		 */
		@Constant
		MetaDataImage SQUAD_SPRITE = ResourceLoader.loadImage(GameConstants.ASSETS_PATH + "troops/medic_icon.png");

		/**
		 * A constant which represents the base upgrade cost of the sniper troop.
		 */
		@Constant
		CurrencyTransaction SINGLE_UPGRADE_COST = new CurrencyTransaction(-100, -100, -100, -100, -100);

		/**
		 * A constant which represents the upgrade cost of the improved sniper troop.
		 */
		@Constant
		CurrencyTransaction COUPLE_UPGRADE_COST = new CurrencyTransaction(-150, -150, -150, -150, -150);

		/**
		 * A constant which represents the upgrade cost of the maxed sniper troop.
		 */
		@Constant
		CurrencyTransaction SQUAD_UPGRADE_COST = CurrencyTransaction.EMPTY;

		/**
		 * A constant which represents the attributes of the sniper troop.
		 */
		@Constant
		TroopStatistics MEDIC_STATISTICS = new TroopStatistics(
			new DexterityStatistic(6, 0),
			new DefensiveStatistic(46, 10, 20, 10),
			new OffensiveStatistics(0, -16, 0, 0, 0));

	}

	/**
	 * The {@link SpaceMarine} subinterface contains all constants, which apply to the Space Marine troop class.
	 *
	 * @author Alexander Göthel
	 * @see me.vault.game.model.troop.impl.SpaceMarine
	 * @see me.vault.game.model.troop.Troop
	 * @since 23.06.2024
	 */
	@ConstantInterface
	interface SpaceMarine
	{

		/**
		 * A constant which represents the base name of the space marine troop.
		 */
		@Constant
		String SINGLE_NAME = "Space Marine Single Combatant";

		/**
		 * A constant which represents the name of the improved space marine troop.
		 */
		@Constant
		String COUPLE_NAME = "Space Marine Couple";

		/**
		 * A constant which represents the name of the maxed space marine troop.
		 */
		@Constant
		String SQUAD_NAME = "Space Marine Squad";

		/**
		 * A constant which represents the base sprite of the space marine troop.
		 */
		@Constant
		MetaDataImage SINGLE_SPRITE = ResourceLoader.loadImage(GameConstants.ASSETS_PATH + "troops/space_marine_icon" +
		                                                       ".png");

		/**
		 * A constant which represents the sprite of the improved space marine troop.
		 */
		@Constant
		MetaDataImage COUPLE_SPRITE = ResourceLoader.loadImage(GameConstants.ASSETS_PATH + "troops/space_marine_icon" +
		                                                       ".png");

		/**
		 * A constant which represents the sprite of the maxed space marine troop.
		 */
		@Constant
		MetaDataImage SQUAD_SPRITE = ResourceLoader.loadImage(GameConstants.ASSETS_PATH + "troops/space_marine_icon" +
		                                                      ".png");

		/**
		 * A constant which represents the base upgrade cost of the space marine troop.
		 */
		@Constant
		CurrencyTransaction SINGLE_UPGRADE_COST = new CurrencyTransaction(-100, -100, -100, -100, -100);

		/**
		 * A constant which represents the upgrade cost of the improved space marine troop.
		 */
		@Constant
		CurrencyTransaction COUPLE_UPGRADE_COST = new CurrencyTransaction(-150, -150, -150, -100, -150);

		/**
		 * A constant which represents the upgrade cost of the maxed space marine troop.
		 */
		@Constant
		CurrencyTransaction SQUAD_UPGRADE_COST = CurrencyTransaction.EMPTY;

		/**
		 * A constant which represents the attributes of the space marine troop.
		 */
		@Constant
		TroopStatistics SPACE_MARINE_STATISTICS = new TroopStatistics(
			new DexterityStatistic(2, -3),
			new DefensiveStatistic(67, 35, 5, 15),
			new OffensiveStatistics(0, 16, 16, 2, 1));

	}

	/**
	 * The {@link Officer} subinterface contains all constants, which apply to the Officer troop class.
	 *
	 * @author Alexander Göthel
	 * @see me.vault.game.model.troop.impl.Officer
	 * @see me.vault.game.model.troop.Troop
	 * @since 23.06.2024
	 */
	@ConstantInterface
	interface Officer
	{

		/**
		 * A constant which represents the base name of the officer troop.
		 */
		@Constant
		String SINGLE_NAME = "Officer Single Combatant";

		/**
		 * A constant which represents the name of the improved officer troop.
		 */
		@Constant
		String COUPLE_NAME = "Officer Couple";

		/**
		 * A constant which represents the name of the maxed officer troop.
		 */
		@Constant
		String SQUAD_NAME = "Officer Squad";

		/**
		 * A constant which represents the base sprite of the officer troop.
		 */
		@Constant
		MetaDataImage SINGLE_SPRITE = ResourceLoader.loadImage(GameConstants.ASSETS_PATH + "troops/officer_icon.png");

		/**
		 * A constant which represents the sprite of the improved officer troop.
		 */
		@Constant
		MetaDataImage COUPLE_SPRITE = ResourceLoader.loadImage(GameConstants.ASSETS_PATH + "troops/officer_icon.png");

		/**
		 * A constant which represents the sprite of the maxed officer troop.
		 */
		@Constant
		MetaDataImage SQUAD_SPRITE = ResourceLoader.loadImage(GameConstants.ASSETS_PATH + "troops/officer_icon.png");

		/**
		 * A constant which represents the base upgrade cost of the officer troop.
		 */
		@Constant
		CurrencyTransaction SINGLE_UPGRADE_COST = new CurrencyTransaction(-100, -100, -100, -100, -100);

		/**
		 * A constant which represents the upgrade cost of the improved officer troop.
		 */
		@Constant
		CurrencyTransaction COUPLE_UPGRADE_COST = new CurrencyTransaction(-150, -150, -150, -150, -150);

		/**
		 * A constant which represents the upgrade cost of the maxed officer troop.
		 */
		@Constant
		CurrencyTransaction SQUAD_UPGRADE_COST = CurrencyTransaction.EMPTY;

		/**
		 * A constant which represents the attributes of the officer troop.
		 */
		@Constant
		TroopStatistics OFFICER_STATISTICS = new TroopStatistics(
			new DexterityStatistic(2, -2),
			new DefensiveStatistic(46, 20, 15, 20),
			new OffensiveStatistics(9, 10, 0, 0, 1));

	}

	/**
	 * The {@link Engineer} subinterface contains all constants, which apply to the Engineer troop class.
	 *
	 * @author Alexander Goethel
	 * @see me.vault.game.model.troop.impl.Engineer
	 * @see me.vault.game.model.troop.Troop
	 * @since 23.06.2024
	 */
	@ConstantInterface
	interface Engineer
	{

		/**
		 * A constant which represents the base name of the engineer troop.
		 */
		@Constant
		String SINGLE_NAME = "Engineer Single Combatant";

		/**
		 * A constant which represents the name of the improved engineer troop.
		 */
		@Constant
		String COUPLE_NAME = "Engineer Couple";

		/**
		 * A constant which represents the name of the maxed engineer troop.
		 */
		@Constant
		String SQUAD_NAME = "Engineer Squad";

		/**
		 * A constant which represents the base sprite of the engineer troop.
		 */
		@Constant
		MetaDataImage SINGLE_SPRITE = ResourceLoader.loadImage(GameConstants.ASSETS_PATH + "troops/engineer_icon.png");

		/**
		 * A constant which represents the sprite of the improved engineer troop.
		 */
		@Constant
		MetaDataImage COUPLE_SPRITE = ResourceLoader.loadImage(GameConstants.ASSETS_PATH + "troops/engineer_icon.png");

		/**
		 * A constant which represents the sprite of the maxed engineer troop.
		 */
		@Constant
		MetaDataImage SQUAD_SPRITE = ResourceLoader.loadImage(GameConstants.ASSETS_PATH + "troops/engineer_icon.png");

		/**
		 * A constant which represents the base upgrade cost of the engineer troop.
		 */
		@Constant
		CurrencyTransaction SINGLE_UPGRADE_COST = new CurrencyTransaction(-100, -100, -100, -100, -100);

		/**
		 * A constant which represents the upgrade cost of the improved engineer troop.
		 */
		@Constant
		CurrencyTransaction COUPLE_UPGRADE_COST = new CurrencyTransaction(-150, -150, -150, -150, -150);

		/**
		 * A constant which represents the upgrade cost of the maxed engineer troop.
		 */
		@Constant
		CurrencyTransaction SQUAD_UPGRADE_COST = CurrencyTransaction.EMPTY;

		/**
		 * A constant which represents the attributes of the engineer troop.
		 */
		@Constant
		TroopStatistics ENGINEER_STATISTICS = new TroopStatistics(
			new DexterityStatistic(2, -3),
			new DefensiveStatistic(60, 25, 0, 20),
			new OffensiveStatistics(0, 22, 22, 4, 2));
	}

	/**
	 * The {@link Guard} subinterface contains all constants, which apply to the Engineer troop class.
	 *
	 * @author Alexander Goethel
	 * @see me.vault.game.model.troop.impl.Guard
	 * @see me.vault.game.model.troop.Troop
	 * @since 23.06.2024
	 */
	@ConstantInterface
	interface Guard
	{

		/**
		 * A constant which represents the base name of the guard troop.
		 */
		@Constant
		String SINGLE_NAME = "Guard Single Combatant";

		/**
		 * A constant which represents the name of the improved guard troop.
		 */
		@Constant
		String COUPLE_NAME = "Guard Couple";

		/**
		 * A constant which represents the name of the maxed guard troop.
		 */
		@Constant
		String SQUAD_NAME = "Guard Squad";

		/**
		 * A constant which represents the base sprite of the guard troop.
		 */
		@Constant
		MetaDataImage SINGLE_SPRITE = ResourceLoader.loadImage(GameConstants.ASSETS_PATH + "troops/guard_icon.png");

		/**
		 * A constant which represents the sprite of the improved guard troop.
		 */
		@Constant
		MetaDataImage COUPLE_SPRITE = ResourceLoader.loadImage(GameConstants.ASSETS_PATH + "troops/guard_icon.png");

		/**
		 * A constant which represents the sprite of the maxed guard troop.
		 */
		@Constant
		MetaDataImage SQUAD_SPRITE = ResourceLoader.loadImage(GameConstants.ASSETS_PATH + "troops/guard_icon.png");

		/**
		 * A constant which represents the base upgrade cost of the guard troop.
		 */
		@Constant
		CurrencyTransaction SINGLE_UPGRADE_COST = new CurrencyTransaction(-100, -100, -100, -100, -100);

		/**
		 * A constant which represents the upgrade cost of the improved guard troop.
		 */
		@Constant
		CurrencyTransaction COUPLE_UPGRADE_COST = new CurrencyTransaction(-150, -150, -150, -150, -150);

		/**
		 * A constant which represents the upgrade cost of the maxed guard troop.
		 */
		@Constant
		CurrencyTransaction SQUAD_UPGRADE_COST = CurrencyTransaction.EMPTY;

		/**
		 * A constant which represents the attributes of the guard troop.
		 */
		@Constant
		TroopStatistics GUARD_STATISTIC = new TroopStatistics(
			new DexterityStatistic(3, 0),
			new DefensiveStatistic(32, 20, 15, 20),
			new OffensiveStatistics(0, 16, 16, 5, 1));

	}

	/**
	 * The {@link Grenadier} subinterface contains all constants, which apply to the Grenadier troop class.
	 *
	 * @author Alexander Goethel
	 * @see me.vault.game.model.troop.impl.Grenadier
	 * @see me.vault.game.model.troop.Troop
	 * @since 23.06.2024
	 */
	@ConstantInterface
	interface Grenadier
	{

		/**
		 * A constant which represents the base name of the grenadier troop.
		 */
		@Constant
		String SINGLE_NAME = "Grenadier Single Combatant";

		/**
		 * A constant which represents the name of the improved grenadier troop.
		 */
		@Constant
		String COUPLE_NAME = "Grenadier Couple";

		/**
		 * A constant which represents the name of the maxed grenadier troop.
		 */
		@Constant
		String SQUAD_NAME = "Grenadier Squad";

		/**
		 * A constant which represents the base sprite of the grenadier troop.
		 */
		@Constant
		MetaDataImage SINGLE_SPRITE = ResourceLoader.loadImage(GameConstants.ASSETS_PATH + "troops/grenadier_icon.png");

		/**
		 * A constant which represents the sprite of the improved grenadier troop.
		 */
		@Constant
		MetaDataImage COUPLE_SPRITE = ResourceLoader.loadImage(GameConstants.ASSETS_PATH + "troops/grenadier_icon.png");

		/**
		 * A constant which represents the sprite of the maxed grenadier troop.
		 */
		@Constant
		MetaDataImage SQUAD_SPRITE = ResourceLoader.loadImage(GameConstants.ASSETS_PATH + "troops/grenadier_icon.png");

		/**
		 * A constant which represents the base upgrade cost of the grenadier troop.
		 */
		@Constant
		CurrencyTransaction SINGLE_UPGRADE_COST = new CurrencyTransaction(-100, -100, -100, -100, -100);

		/**
		 * A constant which represents the upgrade cost of the improved grenadier troop.
		 */
		@Constant
		CurrencyTransaction COUPLE_UPGRADE_COST = new CurrencyTransaction(-150, -150, -150, -150, -150);

		/**
		 * A constant which represents the upgrade cost of the maxed grenadier troop.
		 */
		@Constant
		CurrencyTransaction SQUAD_UPGRADE_COST = CurrencyTransaction.EMPTY;

		/**
		 * A constant which represents the attributes of the grenadier troop.
		 */
		@Constant
		TroopStatistics GRENADIER_STATISTICS = new TroopStatistics(
			new DexterityStatistic(3, 0),
			new DefensiveStatistic(46, 20, 15, 35),
			new OffensiveStatistics(6, 16, 34, 7, 3));
	}

	/**
	 * The {@link Recruit} subinterface contains all constants, which apply to the Recruit troop class.
	 *
	 * @author Alexander Goethel, Lasse-Leander Hillen
	 * @see me.vault.game.model.troop.impl.Recruit
	 * @see me.vault.game.model.troop.Troop
	 * @since 23.06.2024
	 */
	@ConstantInterface
	interface Recruit
	{

		/**
		 * A constant which represents the base name of the recruit troop.
		 */
		@Constant
		String SINGLE_NAME = "Recruit Single Combatant";

		/**
		 * A constant which represents the name of the improved recruit troop.
		 */
		@Constant
		String COUPLE_NAME = "Recruit Couple";

		/**
		 * A constant which represents the name of the maxed recruit troop.
		 */
		@Constant
		String SQUAD_NAME = "Recruit Squad";

		/**
		 * A constant which represents the base sprite of the recruit troop.
		 */
		@Constant
		MetaDataImage SINGLE_SPRITE = ResourceLoader.loadImage(GameConstants.ASSETS_PATH + "troops/recruit_icon.png");

		/**
		 * A constant which represents the sprite of the improved recruit troop.
		 */
		@Constant
		MetaDataImage COUPLE_SPRITE = ResourceLoader.loadImage(GameConstants.ASSETS_PATH + "troops/recruit_icon.png");

		/**
		 * A constant which represents the sprite of the maxed recruit troop.
		 */
		@Constant
		MetaDataImage SQUAD_SPRITE = ResourceLoader.loadImage(GameConstants.ASSETS_PATH + "troops/recruit_icon.png");

		/**
		 * A constant which represents the base upgrade cost of the recruit troop.
		 */
		@Constant
		CurrencyTransaction SINGLE_UPGRADE_COST = new CurrencyTransaction(-100, -100, -100, -100, -100);

		/**
		 * A constant which represents the upgrade cost of the improved recruit troop.
		 */
		@Constant
		CurrencyTransaction COUPLE_UPGRADE_COST = new CurrencyTransaction(-150, -150, -150, -150, -150);

		/**
		 * A constant which represents the upgrade cost of the maxed recruit troop.
		 */
		@Constant
		CurrencyTransaction SQUAD_UPGRADE_COST = CurrencyTransaction.EMPTY;

		/**
		 * A constant which represents the attributes of the recruit troop.
		 */
		@Constant
		TroopStatistics RECRUIT_STATISTICS = new TroopStatistics(
			new DexterityStatistic(3, 0),
			new DefensiveStatistic(25, 15, 5, 20),
			new OffensiveStatistics(0, 10, 16, 4, 1));

	}

	/**
	 * The {@link Infantry} subinterface contains all constants, which apply to the Infantry troop class.
	 *
	 * @author Alexander Goethel
	 * @see me.vault.game.model.troop.impl.Infantry
	 * @see me.vault.game.model.troop.Troop
	 * @since 23.06.2024
	 */
	@ConstantInterface
	interface Infantry
	{

		/**
		 * A constant which represents the base name of the infantry troop.
		 */
		@Constant
		String SINGLE_NAME = "Infantry Single Combatant";

		/**
		 * A constant which represents the name of the improved infantry troop.
		 */
		@Constant
		String COUPLE_NAME = "Infantry Couple";

		/**
		 * A constant which represents the name of the maxed infantry troop.
		 */
		@Constant
		String SQUAD_NAME = "Infantry Squad";

		/**
		 * A constant which represents the base sprite of the infantry troop.
		 */
		@Constant
		MetaDataImage SINGLE_SPRITE = ResourceLoader.loadImage(GameConstants.ASSETS_PATH + "troops/infantry_icon.png");

		/**
		 * A constant which represents the sprite of the improved infantry troop.
		 */
		@Constant
		MetaDataImage COUPLE_SPRITE = ResourceLoader.loadImage(GameConstants.ASSETS_PATH + "troops/infantry_icon.png");

		/**
		 * A constant which represents the sprite of the maxed infantry troop.
		 */
		@Constant
		MetaDataImage SQUAD_SPRITE = ResourceLoader.loadImage(GameConstants.ASSETS_PATH + "troops/infantry_icon.png");

		/**
		 * A constant which represents the base upgrade cost of the infantry troop.
		 */
		@Constant
		CurrencyTransaction SINGLE_UPGRADE_COST = new CurrencyTransaction(-100, -100, -100, -100, -100);

		/**
		 * A constant which represents the upgrade cost of the improved infantry troop.
		 */
		@Constant
		CurrencyTransaction COUPLE_UPGRADE_COST = new CurrencyTransaction(-100, -100, -100, -100, -100);

		/**
		 * A constant which represents the upgrade cost of the maxed infantry troop.
		 */
		@Constant
		CurrencyTransaction SQUAD_UPGRADE_COST = CurrencyTransaction.EMPTY;

		/**
		 * A constant which represents the attributes of the infantry troop.
		 */
		@Constant
		TroopStatistics INFANTRY_STATISTICS = new TroopStatistics(
			new DexterityStatistic(3, 0),
			new DefensiveStatistic(46, 10, 15, 20),
			new OffensiveStatistics(0, 16, 16, 3, 1));

	}

	/**
	 * The {@link Lieutenant} subinterface contains all constants, which apply to the Lieutenant troop class.
	 *
	 * @author Alexander Goethel
	 * @see me.vault.game.model.troop.impl.Lieutenant
	 * @see me.vault.game.model.troop.Troop
	 * @since 23.06.2024
	 */
	@ConstantInterface
	interface Lieutenant
	{

		/**
		 * A constant which represents the base name of the lieutenant troop.
		 */
		@Constant
		String SINGLE_NAME = "Lieutenant Single Combatant";

		/**
		 * A constant which represents the name of the improved lieutenant troop.
		 */
		@Constant
		String COUPLE_NAME = "Lieutenant Couple";

		/**
		 * A constant which represents the name of the maxed lieutenant troop.
		 */
		@Constant
		String SQUAD_NAME = "Lieutenant Squad";

		/**
		 * A constant which represents the base sprite of the lieutenant troop.
		 */
		@Constant
		MetaDataImage SINGLE_SPRITE = ResourceLoader.loadImage(GameConstants.ASSETS_PATH + "troops/lieutenant_icon.png");

		/**
		 * A constant which represents the sprite of the improved lieutenant troop.
		 */
		@Constant
		MetaDataImage COUPLE_SPRITE = ResourceLoader.loadImage(GameConstants.ASSETS_PATH + "troops/lieutenant_icon.png");

		/**
		 * A constant which represents the sprite of the maxed lieutenant troop.
		 */
		@Constant
		MetaDataImage SQUAD_SPRITE = ResourceLoader.loadImage(GameConstants.ASSETS_PATH + "troops/lieutenant_icon.png");

		/**
		 * A constant which represents the base upgrade cost of the lieutenant troop.
		 */
		@Constant
		CurrencyTransaction SINGLE_UPGRADE_COST = new CurrencyTransaction(-100, -100, -100, -100, -100);

		/**
		 * A constant which represents the upgrade cost of the improved lieutenant troop.
		 */
		@Constant
		CurrencyTransaction COUPLE_UPGRADE_COST = new CurrencyTransaction(-150, -150, -150, -150, -150);

		/**
		 * A constant which represents the upgrade cost of the maxed lieutenant troop.
		 */
		@Constant
		CurrencyTransaction SQUAD_UPGRADE_COST = CurrencyTransaction.EMPTY;

		/**
		 * A constant which represents the attributes of the lieutenant troop.
		 */
		@Constant
		TroopStatistics LIEUTENANT_STATISTICS = new TroopStatistics(
			new DexterityStatistic(2, -1),
			new DefensiveStatistic(46, 20, 15, 20),
			new OffensiveStatistics(5, 10, 10, 2, 1));

	}

	/**
	 * The {@link PrecisionShooter} subinterface contains all constants, which apply to the Precision shooter troop
	 * class.
	 *
	 * @author Alexander Goethel
	 * @see me.vault.game.model.troop.impl.PrecisionShooter
	 * @see me.vault.game.model.troop.Troop
	 * @since 23.06.2024
	 */
	@ConstantInterface
	interface PrecisionShooter
	{

		/**
		 * A constant which represents the base name of the precision shooter troop.
		 */
		@Constant
		String SINGLE_NAME = "Precision shooter Single Combatant";

		/**
		 * A constant which represents the name of the improved precision shooter troop.
		 */
		@Constant
		String COUPLE_NAME = "Precision shooter Couple";

		/**
		 * A constant which represents the name of the maxed precision shooter troop.
		 */
		@Constant
		String SQUAD_NAME = "Precision shooter Squad";

		/**
		 * A constant which represents the base sprite of the precision shooter troop.
		 */
		@Constant
		MetaDataImage SINGLE_SPRITE = ResourceLoader.loadImage(GameConstants.ASSETS_PATH + "troops" +
		                                                       "/precision_shooter_icon.png");

		/**
		 * A constant which represents the sprite of the improved precision shooter troop.
		 */
		@Constant
		MetaDataImage COUPLE_SPRITE = ResourceLoader.loadImage(GameConstants.ASSETS_PATH + "troops" +
		                                                       "/precision_shooter_icon.png");

		/**
		 * A constant which represents the sprite of the maxed lieutenant troop.
		 */
		@Constant
		MetaDataImage SQUAD_SPRITE = ResourceLoader.loadImage(GameConstants.ASSETS_PATH + "troops" +
		                                                      "/precision_shooter_icon.png");

		/**
		 * A constant which represents the base upgrade cost of the precision shooter troop.
		 */
		@Constant
		CurrencyTransaction SINGLE_UPGRADE_COST = new CurrencyTransaction(-100, -100, -100, -100, -100);

		/**
		 * A constant which represents the upgrade cost of the improved precision shooter troop.
		 */
		@Constant
		CurrencyTransaction COUPLE_UPGRADE_COST = new CurrencyTransaction(-150, -150, -150, -150, -150);

		/**
		 * A constant which represents the upgrade cost of the maxed precision shooter troop.
		 */
		@Constant
		CurrencyTransaction SQUAD_UPGRADE_COST = CurrencyTransaction.EMPTY;

		/**
		 * A constant which represents the attributes of the precision shooter troop.
		 */
		@Constant
		TroopStatistics PRECISION_SHOOTER_STATISTICS = new TroopStatistics(
			new DexterityStatistic(3, 0),
			new DefensiveStatistic(32, 20, 20, 15),
			new OffensiveStatistics(0, 22, 16, 1, 1));

	}
}
