package me.vault.game.utility.constant;


/**
 * This class provides constants for the unit stistics.
 *
 * @author Alexander Göthel
 * @version 1.0.0
 * @since 29.05.2024
 */
public interface TroopConstants
{
	//-------------------
	// unit health
	public static final double HEALTH_HIGH_PLUS = 67;


	public static final double HEALTH_HIGH = 60;


	public static final double HEALTH_MEDIUM = 46;


	public static final double HEALTH_LOW = 32;


	public static final double HEALTH_LOW_MINUS = 25;


	//--------------------
	// unit armour
	public static final double ARMOUR_HIGH_PLUS = 0.35;


	public static final double ARMOUR_HIGH_MINUS = 0.25;


	public static final double ARMOUR_MEDIUM = 0.2;


	public static final double ARMOUR_LOW_PLUS = 0.15;


	public static final double ARMOUR_LOW = 0.1;


	public static final double ARMOUR_LOW_MINUS = 0.05;


	//--------------------
	// unit energy
	public static final int ENERGY_HIGH_PLUS = 9;


	public static final int ENERGY_MEDIUM = 6;


	public static final int ENERGY_NONE = 0;


	//-----------------
	// unit melee damage
	public static final int MELEE_DAMAGE_HIGH_PLUS = 34;


	public static final int MELEE_DAMAGE_HIGH = 22;


	public static final int MELEE_DAMAGE_MEDIUM = 16;


	public static final int MELEE_DAMAGE_LOW = 10;


	//----------------
	// unit grenade
	public static final int GRENADE_DAMAGE_HIGH_PLUS = 34;


	public static final int GRENADE_DAMAGE_HIGH = 22;


	public static final int GRENADE_DAMAGE_MEDIUM = 16;


	public static final int GRENADE_DAMAGE_LOW = 10;


	public static final int GRENADE_DAMAGE_NONE = 0;


	//----------------------
	// unit grenade amount
	public static final int GRENADE_AMOUNT_HIGH_PLUS = 7;


	public static final int GRENADE_AMOUNT_HIGH_MINUS = 5;


	public static final int GRENADE_AMOUNT_MEDIUM = 4;


	public static final int GRENADE_AMOUNT_LOW_PLUS = 3;


	public static final int GRENADE_AMOUNT_LOW = 2;


	public static final int GRENADE_AMOUNT_LOW_MINUS = 1;


	public static final int GRENADE_AMOUNT_NONE = 0;


	//------------------------
	// unit dodge
	public static final double DODGE_HIGH = 0.25;


	public static final double DODGE_HIGH_MINUS = 0.2;


	public static final double DODGE_MEDIUM = 0.15;


	public static final double DODGE_LOW_PLUS = 0.1;


	public static final double DODGE_LOW = 0.05;


	public static final double DODGE_LOW_MINUS = 0;


	//---------------------
	// unit resistance
	public static final double RESISTANCE_HIGH_PLUS = 0.35;


	public static final double RESISTANCE_HIGH_MINUS = 0.25;


	public static final double RESISTANCE_MEDIUM = 0.2;


	public static final double RESISTANCE_LOW_PLUS = 0.15;


	public static final double RESISTANCE_LOW = 0.1;


	//------------------
	// unit movement range
	public static final int MOVEMENT_RANGE_HIGH_PLUS = 6;


	public static final int MOVEMENT_RANGE_HIGH_MINUS = 4;


	public static final int MOVEMENT_RANGE_MEDIUM = 3;


	public static final int MOVEMENT_RANGE_LOW_PLUS = 2;


	public static final int MOVEMENT_RANGE_LOW = 1;


	//---------------
	// unit initiative
	public static final int INITIATIVE_HIGH_PLUS = 2;


	public static final int INITIATIVE_HIGH = 1;


	public static final int INITIATIVE_MEDIUM = 0;


	public static final int INITIATIVE_LOW_PLUS = -1;


	public static final int INITIATIVE_LOW = -2;


	public static final int INITIATIVE_LOW_MINUS = -3;


	//-------------
	// unit melee range
	public static final int MELEE_RANGE_HIGH_PLUS = 6;


	public static final int MELEE_RANGE_HIGH = 4;


	public static final int MELEE_RANGE_HIGH_MINUS = 3;


	public static final int MELEE_RANGE_MEDIUM = 1;


	//--------------
	// unit grenade range
	public static final int GRENADE_RANGE_HIGH = 3;


	public static final int GRENADE_RANGE_HIGH_MINUS = 2;


	public static final int GRENADE_RANGE_MEDIUM = 1;


	public static final int GRENADE_RANGE_NONE = 0;


	//--------------------
	// unit names
	public static final String MEDIC_SINGLE_COMBATANT = "Medic Single Combatant";


	public static final String MEDIC_COUPLE = "Medic Couple";


	public static final String MEDIC_SQUAD = "Medic Squad";


	public static final String SNIPER_SINGLE_COMBATANT = "Sniper Single Combatant";


	public static final String SNIPER_COUPLE = "Sniper Couple";


	public static final String SNIPER_SQUAD = "Sniper Squad";


	public static final String RANGER_SINGLE_COMBATANT = "Ranger Single Combatant";


	public static final String RANGER_COUPLE = "Ranger Couple";


	public static final String RANGER_SQUAD = "Ranger Squad";


	public static final String SPACE_MARINE_SINGLE_COMBATANT = "Space-Marine Single Combatant";


	public static final String SPACE_MARINE_COUPLE = "Space-Marine Couple";


	public static final String SPACE_MARINE_SQUAD = "Space-Marine Squad";


	public static final String ENGINEER_SINGLE_COMBATANT = "Engineer Single Combatant";


	public static final String ENGINEER_COUPLE = "Engineer Couple";


	public static final String ENGINEER_SQUAD = "Engineer Squad";


	public static final String OFFICER_SINGLE_COMBATANT = "Officer Single Combatant";


	public static final String OFFICER_COUPLE = "Officer Couple";


	public static final String OFFICER_SQUAD = "Officer Squad";


	public static final String GUARD_SINGLE_COMBATANT = "Guard Single Combatant";


	public static final String GUARD_COUPLE = "Guard Couple";


	public static final String GUARD_SQUAD = "Guard Squad";


	public static final String GRENADIER_SINGLE_COMBATANT = "Grenadier Single Combatant";


	public static final String GRENADIER_COUPLE = "Grenadier Couple";


	public static final String GRENADIER_SQUAD = "Grenadier Squad";


	public static final String RECRUIT_SINGLE_COMBATANT = "Recruit Single Combatant";


	public static final String RECRUIT_COUPLE = "Recruit Couple";


	public static final String RECRUIT_SQUAD = "Recruit Squad";


	public static final String INFANTRY_SINGLE_COMBATANT = "Infantry Single Combatant";


	public static final String INFANTRY_COUPLE = "Infantry Couple";


	public static final String INFANTRY_SQUAD = "Infantry Squad";


	public static final String LIEUTENANT_SINGLE_COMBATANT = "Lieutenant Single Combatant";


	public static final String LIEUTENANT_COUPLE = "Lieutenant Couple";


	public static final String LIEUTENANT_SQUAD = "Lieutenant Squad";


	public static final String PRECISION_SHOOTER_SINGLE_COMBATANT = "Precision-Shooter Single Combatant";


	public static final String PRECISION_SHOOTER_COUPLE = "Precision-Shooter Couple";


	public static final String PRECISION_SHOOTER_SQUAD = "Precision-Shooter Squad";
}
