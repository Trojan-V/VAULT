package me.vault.game.utility.constant;


import me.vault.game.model.currency.CurrencyTransaction;
import me.vault.game.model.troop.DefensiveStatistic;
import me.vault.game.model.troop.DexterityStatistic;
import me.vault.game.model.troop.OffensiveStatistic;
import me.vault.game.model.troop.TroopStatistic;
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

	//-------------------
	// unit health
	double HEALTH_HIGH_PLUS = 67;

	double HEALTH_HIGH = 60;

	double HEALTH_MEDIUM = 46;

	double HEALTH_LOW = 32;

	double HEALTH_LOW_MINUS = 25;

	//--------------------
	// unit armour
	double ARMOUR_HIGH_PLUS = 0.35;

	double ARMOUR_HIGH_MINUS = 0.25;

	double ARMOUR_MEDIUM = 0.2;

	double ARMOUR_LOW_PLUS = 0.15;

	double ARMOUR_LOW = 0.1;

	double ARMOUR_LOW_MINUS = 0.05;

	//--------------------
	// unit energy
	int ENERGY_HIGH_PLUS = 9;

	int ENERGY_MEDIUM = 6;

	int ENERGY_NONE = 0;

	//-----------------
	// unit melee damage
	int MELEE_DAMAGE_HIGH_PLUS = 34;

	int MELEE_DAMAGE_HIGH = 22;

	int MELEE_DAMAGE_MEDIUM = 16;

	int MELEE_DAMAGE_LOW = 10;

	//----------------
	// unit grenade
	int GRENADE_DAMAGE_HIGH_PLUS = 34;

	int GRENADE_DAMAGE_HIGH = 22;

	int GRENADE_DAMAGE_MEDIUM = 16;

	int GRENADE_DAMAGE_LOW = 10;

	int GRENADE_DAMAGE_NONE = 0;

	//----------------------
	// unit grenade amount
	int GRENADE_AMOUNT_HIGH_PLUS = 7;

	int GRENADE_AMOUNT_HIGH_MINUS = 5;

	int GRENADE_AMOUNT_MEDIUM = 4;

	int GRENADE_AMOUNT_LOW_PLUS = 3;

	int GRENADE_AMOUNT_LOW = 2;

	int GRENADE_AMOUNT_LOW_MINUS = 1;

	int GRENADE_AMOUNT_NONE = 0;

	//------------------------
	// unit dodge
	double DODGE_HIGH = 0.25;

	double DODGE_HIGH_MINUS = 0.2;

	double DODGE_MEDIUM = 0.15;

	double DODGE_LOW_PLUS = 0.1;

	double DODGE_LOW = 0.05;

	double DODGE_LOW_MINUS = 0;

	//---------------------
	// unit resistance
	double RESISTANCE_HIGH_PLUS = 0.35;

	double RESISTANCE_HIGH_MINUS = 0.25;

	double RESISTANCE_MEDIUM = 0.2;

	double RESISTANCE_LOW_PLUS = 0.15;

	double RESISTANCE_LOW = 0.1;

	//------------------
	// unit movement range
	int MOVEMENT_RANGE_HIGH_PLUS = 6;

	int MOVEMENT_RANGE_HIGH_MINUS = 4;

	int MOVEMENT_RANGE_MEDIUM = 3;

	int MOVEMENT_RANGE_LOW_PLUS = 2;

	int MOVEMENT_RANGE_LOW = 1;

	//---------------
	// unit initiative
	int INITIATIVE_HIGH_PLUS = 2;

	int INITIATIVE_HIGH = 1;

	int INITIATIVE_MEDIUM = 0;

	int INITIATIVE_LOW_PLUS = -1;

	int INITIATIVE_LOW = -2;

	int INITIATIVE_LOW_MINUS = -3;

	//-------------
	// unit melee range
	int MELEE_RANGE_HIGH_PLUS = 6;

	int MELEE_RANGE_HIGH = 4;

	int MELEE_RANGE_HIGH_MINUS = 3;

	int MELEE_RANGE_MEDIUM = 1;

	//--------------
	// unit grenade range
	int GRENADE_RANGE_HIGH = 3;

	int GRENADE_RANGE_HIGH_MINUS = 2;

	int GRENADE_RANGE_MEDIUM = 1;

	int GRENADE_RANGE_NONE = 0;

	//--------------------
	// unit names
	String MEDIC_SINGLE_COMBATANT = "Medic Single Combatant";

	String MEDIC_COUPLE = "Medic Couple";

	String MEDIC_SQUAD = "Medic Squad";

	String RANGER_SINGLE_COMBATANT = "Ranger Single Combatant";

	String RANGER_COUPLE = "Ranger Couple";

	String RANGER_SQUAD = "Ranger Squad";

	String SPACE_MARINE_SINGLE_COMBATANT = "Space-Marine Single Combatant";

	String SPACE_MARINE_COUPLE = "Space-Marine Couple";

	String SPACE_MARINE_SQUAD = "Space-Marine Squad";

	String ENGINEER_SINGLE_COMBATANT = "Engineer Single Combatant";

	String ENGINEER_COUPLE = "Engineer Couple";

	String ENGINEER_SQUAD = "Engineer Squad";

	String OFFICER_SINGLE_COMBATANT = "Officer Single Combatant";

	String OFFICER_COUPLE = "Officer Couple";

	String OFFICER_SQUAD = "Officer Squad";

	String GUARD_SINGLE_COMBATANT = "Guard Single Combatant";

	String GUARD_COUPLE = "Guard Couple";

	String GUARD_SQUAD = "Guard Squad";

	String GRENADIER_SINGLE_COMBATANT = "Grenadier Single Combatant";

	String GRENADIER_COUPLE = "Grenadier Couple";

	String GRENADIER_SQUAD = "Grenadier Squad";

	String RECRUIT_SINGLE_COMBATANT = "Recruit Single Combatant";

	String RECRUIT_COUPLE = "Recruit Couple";

	String RECRUIT_SQUAD = "Recruit Squad";

	String INFANTRY_SINGLE_COMBATANT = "Infantry Single Combatant";

	String INFANTRY_COUPLE = "Infantry Couple";

	String INFANTRY_SQUAD = "Infantry Squad";

	String LIEUTENANT_SINGLE_COMBATANT = "Lieutenant Single Combatant";

	String LIEUTENANT_COUPLE = "Lieutenant Couple";

	String LIEUTENANT_SQUAD = "Lieutenant Squad";

	String PRECISION_SHOOTER_SINGLE_COMBATANT = "Precision-Shooter Single Combatant";

	String PRECISION_SHOOTER_COUPLE = "Precision-Shooter Couple";

	String PRECISION_SHOOTER_SQUAD = "Precision-Shooter Squad";

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
		CurrencyTransaction COUPLE_UPGRADE_COST = new CurrencyTransaction(-100, -100, -100, -100, -100);

		/**
		 * A constant which represents the upgrade cost of the maxed sniper troop.
		 */
		@Constant
		CurrencyTransaction SQUAD_UPGRADE_COST = CurrencyTransaction.EMPTY;

		/**
		 * A constant which represents the attributes of the sniper troop.
		 */
		@Constant
		TroopStatistic SNIPER_STATISTIC = new TroopStatistic(
			new DexterityStatistic(100, 100),
			new DefensiveStatistic(100, 100, 100, 100),
			new OffensiveStatistic(100, 100, 100, 100, 100));

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
		CurrencyTransaction COUPLE_UPGRADE_COST = new CurrencyTransaction(-100, -100, -100, -100, -100);

		/**
		 * A constant which represents the upgrade cost of the maxed sniper troop.
		 */
		@Constant
		CurrencyTransaction SQUAD_UPGRADE_COST = CurrencyTransaction.EMPTY;

		/**
		 * A constant which represents the attributes of the sniper troop.
		 */

		@Constant
		TroopStatistic RANGER_STATISTIC = new TroopStatistic(
			new DexterityStatistic(1, 1),
			new DefensiveStatistic(1, 1, 1, 1),
			new OffensiveStatistic(1, 1, 1, 1, 1));

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
		CurrencyTransaction COUPLE_UPGRADE_COST = new CurrencyTransaction(-100, -100, -100, -100, -100);

		/**
		 * A constant which represents the upgrade cost of the maxed sniper troop.
		 */
		@Constant
		CurrencyTransaction SQUAD_UPGRADE_COST = CurrencyTransaction.EMPTY;

		/**
		 * A constant which represents the attributes of the sniper troop.
		 */
		@Constant
		TroopStatistic MEDIC_STATISTIC = new TroopStatistic(
			new DexterityStatistic(100, 100),
			new DefensiveStatistic(100, 100, 100, 100),
			new OffensiveStatistic(100, 100, 100, 100, 100));

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
		CurrencyTransaction COUPLE_UPGRADE_COST = new CurrencyTransaction(-100, -100, -100, -100, -100);

		/**
		 * A constant which represents the upgrade cost of the maxed space marine troop.
		 */
		@Constant
		CurrencyTransaction SQUAD_UPGRADE_COST = CurrencyTransaction.EMPTY;

		/**
		 * A constant which represents the attributes of the space marine troop.
		 */
		@Constant
		TroopStatistic SPACE_MARINE_STATISTIC = new TroopStatistic(
			new DexterityStatistic(100, 100),
			new DefensiveStatistic(100, 100, 100, 100),
			new OffensiveStatistic(100, 100, 100, 100, 100));

	}

	/**
	 * The {@link SpaceMarine} subinterface contains all constants, which apply to the Officer troop class.
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
		CurrencyTransaction COUPLE_UPGRADE_COST = new CurrencyTransaction(-100, -100, -100, -100, -100);

		/**
		 * A constant which represents the upgrade cost of the maxed officer troop.
		 */
		@Constant
		CurrencyTransaction SQUAD_UPGRADE_COST = CurrencyTransaction.EMPTY;

		/**
		 * A constant which represents the attributes of the officer troop.
		 */
		@Constant
		TroopStatistic OFFICER_STATISTIC = new TroopStatistic(
			new DexterityStatistic(100, 100),
			new DefensiveStatistic(100, 100, 100, 100),
			new OffensiveStatistic(100, 100, 100, 100, 100));

	}

	/**
	 * The {@link Engineer} subinterface contains all constants, which apply to the Engineer troop class.
	 *
	 * @author Alexander Göthel
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
		CurrencyTransaction COUPLE_UPGRADE_COST = new CurrencyTransaction(-100, -100, -100, -100, -100);

		/**
		 * A constant which represents the upgrade cost of the maxed engineer troop.
		 */
		@Constant
		CurrencyTransaction SQUAD_UPGRADE_COST = CurrencyTransaction.EMPTY;

		/**
		 * A constant which represents the attributes of the engineer troop.
		 */
		@Constant
		TroopStatistic ENGINEER_STATISTIC = new TroopStatistic(
			new DexterityStatistic(100, 100),
			new DefensiveStatistic(100, 100, 100, 100),
			new OffensiveStatistic(100, 100, 100, 100, 100));

	}

	/**
	 * The {@link Guard} subinterface contains all constants, which apply to the Engineer troop class.
	 *
	 * @author Alexander Göthel
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
		CurrencyTransaction COUPLE_UPGRADE_COST = new CurrencyTransaction(-100, -100, -100, -100, -100);

		/**
		 * A constant which represents the upgrade cost of the maxed guard troop.
		 */
		@Constant
		CurrencyTransaction SQUAD_UPGRADE_COST = CurrencyTransaction.EMPTY;

		/**
		 * A constant which represents the attributes of the guard troop.
		 */
		@Constant
		TroopStatistic GUARD_STATISTIC = new TroopStatistic(
			new DexterityStatistic(100, 100),
			new DefensiveStatistic(100, 100, 100, 100),
			new OffensiveStatistic(100, 100, 100, 100, 100));

	}

	/**
	 * The {@link Grenadier} subinterface contains all constants, which apply to the Grenadier troop class.
	 *
	 * @author Alexander Göthel
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
		CurrencyTransaction COUPLE_UPGRADE_COST = new CurrencyTransaction(-100, -100, -100, -100, -100);

		/**
		 * A constant which represents the upgrade cost of the maxed grenadier troop.
		 */
		@Constant
		CurrencyTransaction SQUAD_UPGRADE_COST = CurrencyTransaction.EMPTY;

		/**
		 * A constant which represents the attributes of the grenadier troop.
		 */
		@Constant
		TroopStatistic GRENADIER_STATISTIC = new TroopStatistic(
			new DexterityStatistic(100, 100),
			new DefensiveStatistic(100, 100, 100, 100),
			new OffensiveStatistic(100, 100, 100, 100, 100));

	}

	/**
	 * The {@link Recruit} subinterface contains all constants, which apply to the Recruit troop class.
	 *
	 * @author Alexander Göthel
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
		CurrencyTransaction COUPLE_UPGRADE_COST = new CurrencyTransaction(-100, -100, -100, -100, -100);

		/**
		 * A constant which represents the upgrade cost of the maxed recruit troop.
		 */
		@Constant
		CurrencyTransaction SQUAD_UPGRADE_COST = CurrencyTransaction.EMPTY;

		/**
		 * A constant which represents the attributes of the recruit troop.
		 */
		@Constant
		TroopStatistic RECRUIT_STATISTIC = new TroopStatistic(
			new DexterityStatistic(100, 100),
			new DefensiveStatistic(100, 100, 100, 100),
			new OffensiveStatistic(100, 100, 100, 100, 100));

	}

	/**
	 * The {@link Infantry} subinterface contains all constants, which apply to the Infantry troop class.
	 *
	 * @author Alexander Göthel
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
		TroopStatistic INFANTRY_STATISTIC = new TroopStatistic(
			new DexterityStatistic(100, 100),
			new DefensiveStatistic(100, 100, 100, 100),
			new OffensiveStatistic(100, 100, 100, 100, 100));

	}

	/**
	 * The {@link Lieutenant} subinterface contains all constants, which apply to the Lieutenant troop class.
	 *
	 * @author Alexander Göthel
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
		CurrencyTransaction COUPLE_UPGRADE_COST = new CurrencyTransaction(-100, -100, -100, -100, -100);

		/**
		 * A constant which represents the upgrade cost of the maxed lieutenant troop.
		 */
		@Constant
		CurrencyTransaction SQUAD_UPGRADE_COST = CurrencyTransaction.EMPTY;

		/**
		 * A constant which represents the attributes of the lieutenant troop.
		 */
		@Constant
		TroopStatistic LIEUTENANT_STATISTIC = new TroopStatistic(
			new DexterityStatistic(100, 100),
			new DefensiveStatistic(100, 100, 100, 100),
			new OffensiveStatistic(100, 100, 100, 100, 100));

	}
}
