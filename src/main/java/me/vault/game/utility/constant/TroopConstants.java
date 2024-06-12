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

	String SNIPER_SINGLE_COMBATANT = "Sniper Single Combatant";

	String SNIPER_COUPLE = "Sniper Couple";

	String SNIPER_SQUAD = "Sniper Squad";

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

}
