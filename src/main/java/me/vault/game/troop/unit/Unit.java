package me.vault.game.troop.unit;


import me.vault.game.currency.CurrencyTransaction;
import me.vault.game.interfaces.Upgradable;
import me.vault.game.utility.constant.TroopConstants;
import me.vault.game.utility.struct.ValidatedEntriesHashMap;


/**
 * @author Alexander Göthel
 * @version 1.0.0
 * @see Upgradable
 * @since 28.05.2024
 */
public enum Unit implements Upgradable<UnitLevel, UnitAttributes>
{
	// Explorer-Association

	MEDIC(
		new ValidatedEntriesHashMap<>()
		{
			{
				this.put(UnitLevel.SINGLE_COMBATANT, new UnitAttributes(new CurrencyTransaction(
					10, 10, 10, 10, 10),
					TroopConstants.HEALTH_MEDIUM, TroopConstants.ARMOUR_LOW, TroopConstants.ENERGY_NONE,
					TroopConstants.MELEE_DAMAGE_MEDIUM, TroopConstants.GRENADE_DAMAGE_NONE,
					TroopConstants.GRENADE_AMOUNT_NONE,
					TroopConstants.DODGE_HIGH_MINUS, TroopConstants.RESISTANCE_LOW,
					TroopConstants.MOVEMENT_RANGE_HIGH_PLUS, TroopConstants.INITIATIVE_MEDIUM,
					TroopConstants.MELEE_RANGE_MEDIUM, TroopConstants.GRENADE_RANGE_NONE,
					TroopConstants.MEDIC_SINGLE_COMBATANT));

				this.put(UnitLevel.COUPLE, new UnitAttributes(new CurrencyTransaction(
					10, 10, 10, 10, 10),
					TroopConstants.HEALTH_MEDIUM, TroopConstants.ARMOUR_LOW, TroopConstants.ENERGY_NONE,
					TroopConstants.MELEE_DAMAGE_HIGH, TroopConstants.GRENADE_DAMAGE_NONE,
					TroopConstants.GRENADE_AMOUNT_NONE, TroopConstants.DODGE_HIGH_MINUS, TroopConstants.RESISTANCE_LOW,
					TroopConstants.MOVEMENT_RANGE_HIGH_PLUS, TroopConstants.INITIATIVE_MEDIUM,
					TroopConstants.MELEE_RANGE_MEDIUM, TroopConstants.GRENADE_RANGE_NONE,
					TroopConstants.MEDIC_COUPLE));
				// one level higher melee damage

				this.put(UnitLevel.SQUAD, new UnitAttributes(new CurrencyTransaction(
					10, 10, 10, 10, 10),
					TroopConstants.HEALTH_MEDIUM, TroopConstants.ARMOUR_LOW, TroopConstants.ENERGY_NONE,
					TroopConstants.MELEE_DAMAGE_HIGH_PLUS, TroopConstants.GRENADE_DAMAGE_NONE,
					TroopConstants.GRENADE_AMOUNT_NONE, TroopConstants.DODGE_HIGH_MINUS, TroopConstants.RESISTANCE_LOW,
					TroopConstants.MOVEMENT_RANGE_HIGH_PLUS, TroopConstants.INITIATIVE_HIGH,
					TroopConstants.MELEE_RANGE_MEDIUM, TroopConstants.GRENADE_RANGE_NONE, TroopConstants.MEDIC_SQUAD));
				// another level higher melee damage and one level higher initiative
			}
		}
	),

	SNIPER(
		new ValidatedEntriesHashMap<>()
		{
			{
				this.put(UnitLevel.SINGLE_COMBATANT, new UnitAttributes(new CurrencyTransaction(
					10, 10, 10, 10, 10),
					TroopConstants.HEALTH_LOW_MINUS, TroopConstants.ARMOUR_LOW_MINUS, TroopConstants.ENERGY_NONE,
					TroopConstants.MELEE_DAMAGE_HIGH_PLUS, TroopConstants.GRENADE_DAMAGE_NONE,
					TroopConstants.GRENADE_AMOUNT_NONE, TroopConstants.DODGE_HIGH_MINUS,
					TroopConstants.RESISTANCE_MEDIUM, TroopConstants.MOVEMENT_RANGE_LOW,
					TroopConstants.INITIATIVE_HIGH_PLUS,
					TroopConstants.MELEE_RANGE_HIGH_PLUS, TroopConstants.GRENADE_RANGE_NONE,
					TroopConstants.SNIPER_SINGLE_COMBATANT));

				this.put(UnitLevel.COUPLE, new UnitAttributes(new CurrencyTransaction(
					10, 10, 10, 10, 10),
					TroopConstants.HEALTH_LOW_MINUS, TroopConstants.ARMOUR_LOW_MINUS, TroopConstants.ENERGY_NONE,
					TroopConstants.MELEE_DAMAGE_HIGH_PLUS,
					TroopConstants.GRENADE_DAMAGE_NONE, TroopConstants.GRENADE_AMOUNT_NONE,
					TroopConstants.DODGE_HIGH_MINUS, TroopConstants.RESISTANCE_MEDIUM,
					TroopConstants.MOVEMENT_RANGE_LOW_PLUS, TroopConstants.INITIATIVE_HIGH_PLUS,
					TroopConstants.MELEE_RANGE_HIGH_PLUS, TroopConstants.GRENADE_RANGE_NONE,
					TroopConstants.SNIPER_COUPLE));
				// a higher level of movement range

				this.put(UnitLevel.SQUAD, new UnitAttributes(new CurrencyTransaction(
					10, 10, 10, 10, 10),
					TroopConstants.HEALTH_LOW_MINUS, TroopConstants.ARMOUR_LOW_MINUS, TroopConstants.ENERGY_NONE,
					TroopConstants.MELEE_DAMAGE_HIGH_PLUS,
					TroopConstants.GRENADE_DAMAGE_NONE, TroopConstants.GRENADE_AMOUNT_NONE,
					TroopConstants.DODGE_HIGH_MINUS, TroopConstants.RESISTANCE_MEDIUM,
					TroopConstants.MOVEMENT_RANGE_MEDIUM, TroopConstants.INITIATIVE_HIGH_PLUS,
					TroopConstants.MELEE_RANGE_HIGH_PLUS, TroopConstants.GRENADE_RANGE_NONE,
					TroopConstants.SNIPER_SINGLE_COMBATANT));
				// another higher level of movement range and a higher level
			}
		}
	),

	RANGER(new ValidatedEntriesHashMap<>()
	{
		{
			this.put(UnitLevel.SINGLE_COMBATANT, new UnitAttributes(
				new CurrencyTransaction(10, 10, 10, 10, 10),
				TroopConstants.HEALTH_MEDIUM, TroopConstants.ARMOUR_MEDIUM, TroopConstants.ENERGY_MEDIUM,
				TroopConstants.MELEE_DAMAGE_HIGH, TroopConstants.GRENADE_DAMAGE_MEDIUM,
				TroopConstants.GRENADE_AMOUNT_LOW_MINUS, TroopConstants.DODGE_HIGH, TroopConstants.RESISTANCE_LOW_PLUS,
				TroopConstants.MOVEMENT_RANGE_HIGH_MINUS,
				TroopConstants.INITIATIVE_HIGH, TroopConstants.MELEE_RANGE_HIGH, TroopConstants.GRENADE_RANGE_MEDIUM,
				TroopConstants.RANGER_SINGLE_COMBATANT));

			this.put(UnitLevel.COUPLE, new UnitAttributes(new CurrencyTransaction(
				10, 10, 10, 10, 10),
				TroopConstants.HEALTH_MEDIUM, TroopConstants.ARMOUR_MEDIUM, TroopConstants.ENERGY_MEDIUM,
				TroopConstants.MELEE_DAMAGE_HIGH, TroopConstants.GRENADE_DAMAGE_MEDIUM,
				TroopConstants.GRENADE_AMOUNT_LOW_MINUS, TroopConstants.DODGE_HIGH, TroopConstants.RESISTANCE_LOW_PLUS,
				TroopConstants.MOVEMENT_RANGE_HIGH_PLUS,
				TroopConstants.INITIATIVE_HIGH, TroopConstants.MELEE_RANGE_HIGH, TroopConstants.GRENADE_RANGE_MEDIUM,
				TroopConstants.RANGER_COUPLE));
			// one level higher movement range

			this.put(UnitLevel.SQUAD, new UnitAttributes(new CurrencyTransaction(
				10, 10, 10, 10, 10),
				TroopConstants.HEALTH_HIGH, TroopConstants.ARMOUR_MEDIUM, TroopConstants.ENERGY_MEDIUM,
				TroopConstants.MELEE_DAMAGE_HIGH, TroopConstants.GRENADE_DAMAGE_MEDIUM,
				TroopConstants.GRENADE_AMOUNT_LOW_MINUS, TroopConstants.DODGE_HIGH, TroopConstants.RESISTANCE_LOW_PLUS,
				TroopConstants.MOVEMENT_RANGE_HIGH_MINUS,
				TroopConstants.INITIATIVE_HIGH_PLUS, TroopConstants.MELEE_RANGE_HIGH,
				TroopConstants.GRENADE_RANGE_MEDIUM, TroopConstants.RANGER_SQUAD));
			// one level of initiative and health
		}
	}),

	//--------------
	// militaristic government

	SPACE_MARINE(new ValidatedEntriesHashMap<>()
	{
		{
			this.put(UnitLevel.SINGLE_COMBATANT, new UnitAttributes(new CurrencyTransaction(
				10, 10, 10, 10, 10),
				TroopConstants.HEALTH_HIGH_PLUS, TroopConstants.ARMOUR_HIGH_PLUS, TroopConstants.ENERGY_NONE,
				TroopConstants.MELEE_DAMAGE_MEDIUM, TroopConstants.GRENADE_DAMAGE_MEDIUM,
				TroopConstants.GRENADE_AMOUNT_LOW, TroopConstants.DODGE_LOW, TroopConstants.RESISTANCE_LOW_PLUS,
				TroopConstants.MOVEMENT_RANGE_LOW_PLUS,
				TroopConstants.INITIATIVE_LOW_MINUS, TroopConstants.MELEE_RANGE_MEDIUM,
				TroopConstants.GRENADE_RANGE_MEDIUM, TroopConstants.SPACE_MARINE_SINGLE_COMBATANT));

			this.put(UnitLevel.COUPLE, new UnitAttributes(new CurrencyTransaction(
				10, 10, 10, 10, 10),
				TroopConstants.HEALTH_HIGH_PLUS, TroopConstants.ARMOUR_HIGH_PLUS, TroopConstants.ENERGY_NONE,
				TroopConstants.MELEE_DAMAGE_MEDIUM, TroopConstants.GRENADE_DAMAGE_MEDIUM,
				TroopConstants.GRENADE_AMOUNT_LOW, TroopConstants.DODGE_LOW, TroopConstants.RESISTANCE_LOW_PLUS,
				TroopConstants.MOVEMENT_RANGE_LOW_PLUS,
				TroopConstants.INITIATIVE_LOW, TroopConstants.MELEE_RANGE_MEDIUM, TroopConstants.GRENADE_RANGE_MEDIUM,
				TroopConstants.SPACE_MARINE_COUPLE));
			// a higher level of initiative

			this.put(UnitLevel.SQUAD, new UnitAttributes(new CurrencyTransaction(
				10, 10, 10, 10, 10),
				TroopConstants.HEALTH_HIGH_PLUS, TroopConstants.ARMOUR_HIGH_PLUS, TroopConstants.ENERGY_NONE,
				TroopConstants.MELEE_DAMAGE_HIGH, TroopConstants.GRENADE_DAMAGE_MEDIUM,
				TroopConstants.GRENADE_AMOUNT_LOW, TroopConstants.DODGE_LOW, TroopConstants.RESISTANCE_LOW_PLUS,
				TroopConstants.MOVEMENT_RANGE_LOW_PLUS,
				TroopConstants.INITIATIVE_LOW_PLUS, TroopConstants.MELEE_RANGE_MEDIUM,
				TroopConstants.GRENADE_RANGE_MEDIUM, TroopConstants.SPACE_MARINE_SQUAD));
			// another higher level of initiative and a higher level of melee damage
		}
	}),

	ENGINEER(new ValidatedEntriesHashMap<>()
	{
		{
			this.put(UnitLevel.SINGLE_COMBATANT, new UnitAttributes(new CurrencyTransaction(
				10, 10, 10, 10, 10),
				TroopConstants.HEALTH_HIGH, TroopConstants.ARMOUR_HIGH_MINUS, TroopConstants.ENERGY_NONE,
				TroopConstants.MELEE_DAMAGE_HIGH, TroopConstants.GRENADE_DAMAGE_HIGH,
				TroopConstants.GRENADE_AMOUNT_MEDIUM, TroopConstants.DODGE_LOW_MINUS, TroopConstants.RESISTANCE_MEDIUM
				, TroopConstants.MOVEMENT_RANGE_LOW_PLUS,
				TroopConstants.INITIATIVE_LOW_MINUS, TroopConstants.MELEE_RANGE_MEDIUM,
				TroopConstants.GRENADE_RANGE_HIGH_MINUS, TroopConstants.ENGINEER_SINGLE_COMBATANT));

			this.put(UnitLevel.COUPLE, new UnitAttributes(new CurrencyTransaction(
				10, 10, 10, 10, 10),
				TroopConstants.HEALTH_HIGH, TroopConstants.ARMOUR_HIGH_MINUS, TroopConstants.ENERGY_NONE,
				TroopConstants.MELEE_DAMAGE_HIGH, TroopConstants.GRENADE_DAMAGE_HIGH,
				TroopConstants.GRENADE_AMOUNT_HIGH_MINUS, TroopConstants.DODGE_LOW_MINUS,
				TroopConstants.RESISTANCE_MEDIUM,
				TroopConstants.MOVEMENT_RANGE_LOW_PLUS,
				TroopConstants.INITIATIVE_LOW_MINUS, TroopConstants.MELEE_RANGE_MEDIUM,
				TroopConstants.GRENADE_RANGE_HIGH_MINUS, TroopConstants.ENGINEER_COUPLE));
			//  a higher level of grenade amount

			this.put(UnitLevel.SQUAD, new UnitAttributes(new CurrencyTransaction(
				10, 10, 10, 10, 10),
				TroopConstants.HEALTH_HIGH, TroopConstants.ARMOUR_HIGH_MINUS, TroopConstants.ENERGY_NONE,
				TroopConstants.MELEE_DAMAGE_HIGH, TroopConstants.GRENADE_DAMAGE_HIGH_PLUS,
				TroopConstants.GRENADE_AMOUNT_HIGH_PLUS, TroopConstants.DODGE_LOW_MINUS,
				TroopConstants.RESISTANCE_MEDIUM,
				TroopConstants.MOVEMENT_RANGE_LOW_PLUS,
				TroopConstants.INITIATIVE_LOW_MINUS, TroopConstants.MELEE_RANGE_MEDIUM,
				TroopConstants.GRENADE_RANGE_HIGH_MINUS, TroopConstants.ENGINEER_SQUAD));
			// another higher level of grenade amount and a higher level of grenade damage
		}
	}),

	OFFICER(new ValidatedEntriesHashMap<>()
	{
		{
			this.put(UnitLevel.SINGLE_COMBATANT, new UnitAttributes(new CurrencyTransaction(
				10, 10, 10, 10, 10),
				TroopConstants.HEALTH_MEDIUM, TroopConstants.ARMOUR_MEDIUM, TroopConstants.ENERGY_HIGH_PLUS,
				TroopConstants.MELEE_DAMAGE_LOW, TroopConstants.GRENADE_DAMAGE_NONE,
				TroopConstants.GRENADE_AMOUNT_NONE,
				TroopConstants.DODGE_MEDIUM, TroopConstants.RESISTANCE_MEDIUM,
				TroopConstants.MOVEMENT_RANGE_LOW_PLUS, TroopConstants.INITIATIVE_LOW,
				TroopConstants.MELEE_RANGE_MEDIUM,
				TroopConstants.GRENADE_RANGE_NONE, TroopConstants.OFFICER_SINGLE_COMBATANT));

			this.put(UnitLevel.COUPLE, new UnitAttributes(new CurrencyTransaction(
				10, 10, 10, 10, 10),
				TroopConstants.HEALTH_MEDIUM, TroopConstants.ARMOUR_MEDIUM, TroopConstants.ENERGY_HIGH_PLUS,
				TroopConstants.MELEE_DAMAGE_LOW, TroopConstants.GRENADE_DAMAGE_NONE,
				TroopConstants.GRENADE_AMOUNT_NONE,
				TroopConstants.DODGE_MEDIUM, TroopConstants.RESISTANCE_MEDIUM,
				TroopConstants.MOVEMENT_RANGE_LOW_PLUS, TroopConstants.INITIATIVE_LOW_PLUS,
				TroopConstants.MELEE_RANGE_MEDIUM,
				TroopConstants.GRENADE_RANGE_NONE, TroopConstants.OFFICER_COUPLE));
			// a higher level of initiative

			this.put(UnitLevel.SQUAD, new UnitAttributes(new CurrencyTransaction(
				10, 10, 10, 10, 10),
				TroopConstants.HEALTH_MEDIUM, TroopConstants.ARMOUR_HIGH_MINUS, TroopConstants.ENERGY_HIGH_PLUS,
				TroopConstants.MELEE_DAMAGE_LOW, TroopConstants.GRENADE_DAMAGE_NONE,
				TroopConstants.GRENADE_AMOUNT_NONE,
				TroopConstants.DODGE_MEDIUM, TroopConstants.RESISTANCE_MEDIUM,
				TroopConstants.MOVEMENT_RANGE_LOW_PLUS, TroopConstants.INITIATIVE_MEDIUM,
				TroopConstants.MELEE_RANGE_MEDIUM,
				TroopConstants.GRENADE_RANGE_NONE, TroopConstants.OFFICER_SQUAD));
			// another higher level of initiativ and a higher level of armour
		}
	}),

	//-------------------
	// mega-corporation

	GUARD(new ValidatedEntriesHashMap<>()
	{
		{
			this.put(UnitLevel.SINGLE_COMBATANT, new UnitAttributes(new CurrencyTransaction(
				10, 10, 10, 10, 10),
				TroopConstants.HEALTH_LOW, TroopConstants.ARMOUR_MEDIUM, TroopConstants.ENERGY_NONE,
				TroopConstants.MELEE_DAMAGE_MEDIUM,
				TroopConstants.GRENADE_DAMAGE_MEDIUM, TroopConstants.GRENADE_AMOUNT_HIGH_MINUS,
				TroopConstants.DODGE_MEDIUM, TroopConstants.RESISTANCE_HIGH_MINUS,
				TroopConstants.MOVEMENT_RANGE_MEDIUM,
				TroopConstants.INITIATIVE_MEDIUM, TroopConstants.MELEE_RANGE_MEDIUM,
				TroopConstants.GRENADE_RANGE_MEDIUM,
				TroopConstants.OFFICER_SINGLE_COMBATANT));

			this.put(UnitLevel.COUPLE, new UnitAttributes(new CurrencyTransaction(
				10, 10, 10, 10, 10),
				TroopConstants.HEALTH_MEDIUM, TroopConstants.ARMOUR_MEDIUM, TroopConstants.ENERGY_NONE,
				TroopConstants.MELEE_DAMAGE_MEDIUM,
				TroopConstants.GRENADE_DAMAGE_MEDIUM, TroopConstants.GRENADE_AMOUNT_HIGH_MINUS,
				TroopConstants.DODGE_MEDIUM, TroopConstants.RESISTANCE_HIGH_MINUS,
				TroopConstants.MOVEMENT_RANGE_MEDIUM,
				TroopConstants.INITIATIVE_MEDIUM, TroopConstants.MELEE_RANGE_MEDIUM,
				TroopConstants.GRENADE_RANGE_MEDIUM,
				TroopConstants.OFFICER_COUPLE));
			// a higher level of health

			this.put(UnitLevel.SQUAD, new UnitAttributes(new CurrencyTransaction(
				10, 10, 10, 10, 10),
				TroopConstants.HEALTH_HIGH_PLUS, TroopConstants.ARMOUR_MEDIUM, TroopConstants.ENERGY_NONE,
				TroopConstants.MELEE_DAMAGE_MEDIUM,
				TroopConstants.GRENADE_DAMAGE_MEDIUM, TroopConstants.GRENADE_AMOUNT_HIGH_PLUS,
				TroopConstants.DODGE_MEDIUM, TroopConstants.RESISTANCE_HIGH_MINUS,
				TroopConstants.MOVEMENT_RANGE_MEDIUM,
				TroopConstants.INITIATIVE_MEDIUM, TroopConstants.MELEE_RANGE_MEDIUM,
				TroopConstants.GRENADE_RANGE_MEDIUM,
				TroopConstants.OFFICER_SQUAD));
			// another higher level of health and a higher level of grenade amount
		}
	}),

	GRENADIER(new ValidatedEntriesHashMap<>()
	{
		{
			this.put(UnitLevel.SINGLE_COMBATANT, new UnitAttributes(new CurrencyTransaction(
				10, 10, 10, 10, 10),
				TroopConstants.HEALTH_MEDIUM, TroopConstants.ARMOUR_MEDIUM, TroopConstants.ENERGY_MEDIUM,
				TroopConstants.MELEE_DAMAGE_MEDIUM, TroopConstants.GRENADE_DAMAGE_HIGH_PLUS,
				TroopConstants.GRENADE_AMOUNT_HIGH_PLUS, TroopConstants.DODGE_MEDIUM,
				TroopConstants.RESISTANCE_HIGH_PLUS, TroopConstants.MOVEMENT_RANGE_MEDIUM,
				TroopConstants.INITIATIVE_MEDIUM, TroopConstants.MELEE_RANGE_MEDIUM,
				TroopConstants.GRENADE_RANGE_HIGH, TroopConstants.GRENADIER_SINGLE_COMBATANT));

			this.put(UnitLevel.COUPLE, new UnitAttributes(new CurrencyTransaction(
				10, 10, 10, 10, 10),
				TroopConstants.HEALTH_MEDIUM, TroopConstants.ARMOUR_MEDIUM, TroopConstants.ENERGY_MEDIUM,
				TroopConstants.MELEE_DAMAGE_MEDIUM, TroopConstants.GRENADE_DAMAGE_HIGH_PLUS,
				TroopConstants.GRENADE_AMOUNT_HIGH_PLUS, TroopConstants.DODGE_MEDIUM,
				TroopConstants.RESISTANCE_HIGH_PLUS, TroopConstants.MOVEMENT_RANGE_HIGH_MINUS,
				TroopConstants.INITIATIVE_MEDIUM, TroopConstants.MELEE_RANGE_MEDIUM,
				TroopConstants.GRENADE_RANGE_HIGH, TroopConstants.GRENADIER_COUPLE));
			// a higher level of movement range

			this.put(UnitLevel.SQUAD, new UnitAttributes(new CurrencyTransaction(
				10, 10, 10, 10, 10),
				TroopConstants.HEALTH_MEDIUM, TroopConstants.ARMOUR_MEDIUM, TroopConstants.ENERGY_HIGH_PLUS,
				TroopConstants.MELEE_DAMAGE_MEDIUM, TroopConstants.GRENADE_DAMAGE_HIGH_PLUS,
				TroopConstants.GRENADE_AMOUNT_HIGH_PLUS, TroopConstants.DODGE_HIGH_MINUS,
				TroopConstants.RESISTANCE_HIGH_PLUS, TroopConstants.MOVEMENT_RANGE_HIGH_PLUS,
				TroopConstants.INITIATIVE_MEDIUM, TroopConstants.MELEE_RANGE_MEDIUM,
				TroopConstants.GRENADE_RANGE_HIGH, TroopConstants.GRENADIER_SQUAD));
			// another level of movement range and a higher level of dodge
		}
	}),

	RECRUIT(new ValidatedEntriesHashMap<>()
	{
		{
			this.put(UnitLevel.SINGLE_COMBATANT, new UnitAttributes(new CurrencyTransaction(
				10, 10, 10, 10, 10),
				TroopConstants.HEALTH_LOW_MINUS, TroopConstants.ARMOUR_LOW_PLUS, TroopConstants.ENERGY_NONE,
				TroopConstants.MELEE_DAMAGE_LOW, TroopConstants.GRENADE_DAMAGE_MEDIUM,
				TroopConstants.GRENADE_AMOUNT_MEDIUM,
				TroopConstants.DODGE_LOW, TroopConstants.RESISTANCE_MEDIUM, TroopConstants.MOVEMENT_RANGE_MEDIUM,
				TroopConstants.INITIATIVE_MEDIUM, TroopConstants.MELEE_RANGE_MEDIUM,
				TroopConstants.GRENADE_RANGE_MEDIUM,
				TroopConstants.RECRUIT_SINGLE_COMBATANT));

			this.put(UnitLevel.COUPLE, new UnitAttributes(new CurrencyTransaction(
				10, 10, 10, 10, 10),
				TroopConstants.HEALTH_LOW_MINUS, TroopConstants.ARMOUR_LOW_PLUS, TroopConstants.ENERGY_NONE,
				TroopConstants.MELEE_DAMAGE_LOW, TroopConstants.GRENADE_DAMAGE_HIGH,
				TroopConstants.GRENADE_AMOUNT_MEDIUM,
				TroopConstants.DODGE_LOW, TroopConstants.RESISTANCE_MEDIUM, TroopConstants.MOVEMENT_RANGE_MEDIUM,
				TroopConstants.INITIATIVE_MEDIUM, TroopConstants.MELEE_RANGE_MEDIUM,
				TroopConstants.GRENADE_RANGE_MEDIUM,
				TroopConstants.RECRUIT_COUPLE));
			// a higher level of grenade damage

			this.put(UnitLevel.SQUAD, new UnitAttributes(new CurrencyTransaction(
				10, 10, 10, 10, 10),
				TroopConstants.HEALTH_LOW_MINUS, TroopConstants.ARMOUR_LOW_PLUS, TroopConstants.ENERGY_NONE,
				TroopConstants.MELEE_DAMAGE_LOW, TroopConstants.GRENADE_DAMAGE_HIGH_PLUS,
				TroopConstants.GRENADE_AMOUNT_HIGH_MINUS,
				TroopConstants.DODGE_LOW, TroopConstants.RESISTANCE_MEDIUM, TroopConstants.MOVEMENT_RANGE_MEDIUM,
				TroopConstants.INITIATIVE_MEDIUM, TroopConstants.MELEE_RANGE_MEDIUM,
				TroopConstants.GRENADE_RANGE_MEDIUM,
				TroopConstants.SNIPER_SQUAD));
			// another higher level of grenade damage and a higher level of grenade amount
		}
	}),

	//-------------------------
	// New-Terra

	INFANTRY(new ValidatedEntriesHashMap<>()
	{
		{
			this.put(UnitLevel.SINGLE_COMBATANT, new UnitAttributes(new CurrencyTransaction(
				10, 10, 10, 10, 10),
				TroopConstants.HEALTH_MEDIUM, TroopConstants.ARMOUR_LOW, TroopConstants.ENERGY_NONE,
				TroopConstants.MELEE_DAMAGE_MEDIUM,
				TroopConstants.GRENADE_DAMAGE_MEDIUM, TroopConstants.GRENADE_AMOUNT_LOW_PLUS,
				TroopConstants.DODGE_MEDIUM, TroopConstants.RESISTANCE_MEDIUM, TroopConstants.MOVEMENT_RANGE_MEDIUM,
				TroopConstants.INITIATIVE_MEDIUM, TroopConstants.MELEE_RANGE_MEDIUM,
				TroopConstants.GRENADE_RANGE_MEDIUM,
				TroopConstants.INFANTRY_SINGLE_COMBATANT));

			this.put(UnitLevel.COUPLE, new UnitAttributes(new CurrencyTransaction(
				10, 10, 10, 10, 10),
				TroopConstants.HEALTH_MEDIUM, TroopConstants.ARMOUR_LOW, TroopConstants.ENERGY_NONE,
				TroopConstants.MELEE_DAMAGE_MEDIUM,
				TroopConstants.GRENADE_DAMAGE_MEDIUM, TroopConstants.GRENADE_AMOUNT_LOW_PLUS,
				TroopConstants.DODGE_HIGH_MINUS, TroopConstants.RESISTANCE_MEDIUM,
				TroopConstants.MOVEMENT_RANGE_MEDIUM,
				TroopConstants.INITIATIVE_MEDIUM, TroopConstants.MELEE_RANGE_MEDIUM,
				TroopConstants.GRENADE_RANGE_MEDIUM,
				TroopConstants.INFANTRY_SINGLE_COMBATANT));
			// a higher level of dodge

			this.put(UnitLevel.SQUAD, new UnitAttributes(new CurrencyTransaction(
				10, 10, 10, 10, 10),
				TroopConstants.HEALTH_MEDIUM, TroopConstants.ARMOUR_LOW, TroopConstants.ENERGY_NONE,
				TroopConstants.MELEE_DAMAGE_MEDIUM,
				TroopConstants.GRENADE_DAMAGE_MEDIUM, TroopConstants.GRENADE_AMOUNT_LOW_PLUS,
				TroopConstants.DODGE_HIGH, TroopConstants.RESISTANCE_MEDIUM, TroopConstants.MOVEMENT_RANGE_MEDIUM,
				TroopConstants.INITIATIVE_MEDIUM, TroopConstants.MELEE_RANGE_HIGH_MINUS,
				TroopConstants.GRENADE_RANGE_MEDIUM,
				TroopConstants.INFANTRY_SINGLE_COMBATANT));
			// another higher level of dodge and a higher level of melee range
		}
	}),

	LIEUTENANT(new ValidatedEntriesHashMap<>()
	{
		{
			this.put(UnitLevel.SINGLE_COMBATANT, new UnitAttributes(new CurrencyTransaction(
				10, 10, 10, 10, 10),
				TroopConstants.HEALTH_MEDIUM, TroopConstants.ARMOUR_MEDIUM, TroopConstants.ENERGY_MEDIUM,
				TroopConstants.MELEE_DAMAGE_LOW, TroopConstants.GRENADE_DAMAGE_LOW, TroopConstants.GRENADE_AMOUNT_LOW,
				TroopConstants.DODGE_MEDIUM,
				TroopConstants.RESISTANCE_MEDIUM, TroopConstants.MOVEMENT_RANGE_LOW_PLUS,
				TroopConstants.INITIATIVE_LOW_PLUS, TroopConstants.MELEE_RANGE_MEDIUM,
				TroopConstants.GRENADE_RANGE_MEDIUM, TroopConstants.LIEUTENANT_SINGLE_COMBATANT));

			this.put(UnitLevel.COUPLE, new UnitAttributes(new CurrencyTransaction(
				10, 10, 10, 10, 10),
				TroopConstants.HEALTH_MEDIUM, TroopConstants.ARMOUR_HIGH_MINUS, TroopConstants.ENERGY_MEDIUM,
				TroopConstants.MELEE_DAMAGE_LOW, TroopConstants.GRENADE_DAMAGE_LOW, TroopConstants.GRENADE_AMOUNT_LOW,
				TroopConstants.DODGE_MEDIUM,
				TroopConstants.RESISTANCE_MEDIUM, TroopConstants.MOVEMENT_RANGE_LOW_PLUS,
				TroopConstants.INITIATIVE_LOW_PLUS, TroopConstants.MELEE_RANGE_MEDIUM,
				TroopConstants.GRENADE_RANGE_MEDIUM, TroopConstants.LIEUTENANT_COUPLE));
			// a higher level of armour

			this.put(UnitLevel.SQUAD, new UnitAttributes(new CurrencyTransaction(
				10, 10, 10, 10, 10),
				TroopConstants.HEALTH_HIGH, TroopConstants.ARMOUR_HIGH_PLUS, TroopConstants.ENERGY_MEDIUM,
				TroopConstants.MELEE_DAMAGE_LOW, TroopConstants.GRENADE_DAMAGE_LOW, TroopConstants.GRENADE_AMOUNT_LOW,
				TroopConstants.DODGE_MEDIUM,
				TroopConstants.RESISTANCE_MEDIUM, TroopConstants.MOVEMENT_RANGE_LOW_PLUS,
				TroopConstants.INITIATIVE_LOW_PLUS, TroopConstants.MELEE_RANGE_MEDIUM,
				TroopConstants.GRENADE_RANGE_MEDIUM, TroopConstants.LIEUTENANT_SQUAD));
			// another higher level of armour and a higher level of health
		}
	}),

	PRECISION_SHOOTER(new ValidatedEntriesHashMap<>()
	{
		{
			this.put(UnitLevel.SINGLE_COMBATANT, new UnitAttributes(new CurrencyTransaction(
				10, 10, 10, 10, 10),
				TroopConstants.HEALTH_LOW, TroopConstants.ARMOUR_MEDIUM, TroopConstants.ENERGY_NONE,
				TroopConstants.MELEE_DAMAGE_HIGH,
				TroopConstants.GRENADE_DAMAGE_MEDIUM, TroopConstants.GRENADE_AMOUNT_LOW_MINUS,
				TroopConstants.DODGE_HIGH_MINUS, TroopConstants.RESISTANCE_LOW_PLUS,
				TroopConstants.MOVEMENT_RANGE_MEDIUM,
				TroopConstants.INITIATIVE_MEDIUM, TroopConstants.MELEE_RANGE_HIGH_MINUS,
				TroopConstants.GRENADE_RANGE_MEDIUM,
				TroopConstants.PRECISION_SHOOTER_SINGLE_COMBATANT));

			this.put(UnitLevel.COUPLE, new UnitAttributes(new CurrencyTransaction(
				10, 10, 10, 10, 10),
				TroopConstants.HEALTH_LOW, TroopConstants.ARMOUR_MEDIUM, TroopConstants.ENERGY_NONE,
				TroopConstants.MELEE_DAMAGE_HIGH,
				TroopConstants.GRENADE_DAMAGE_MEDIUM, TroopConstants.GRENADE_AMOUNT_LOW_MINUS,
				TroopConstants.DODGE_HIGH_MINUS, TroopConstants.RESISTANCE_LOW_PLUS,
				TroopConstants.MOVEMENT_RANGE_MEDIUM,
				TroopConstants.INITIATIVE_HIGH, TroopConstants.MELEE_RANGE_HIGH_MINUS,
				TroopConstants.GRENADE_RANGE_MEDIUM,
				TroopConstants.PRECISION_SHOOTER_COUPLE));
			// a higher level of initiative

			this.put(UnitLevel.SQUAD, new UnitAttributes(new CurrencyTransaction(
				10, 10, 10, 10, 10),
				TroopConstants.HEALTH_LOW, TroopConstants.ARMOUR_MEDIUM, TroopConstants.ENERGY_NONE,
				TroopConstants.MELEE_DAMAGE_HIGH,
				TroopConstants.GRENADE_DAMAGE_MEDIUM, TroopConstants.GRENADE_AMOUNT_LOW_MINUS,
				TroopConstants.DODGE_HIGH_MINUS, TroopConstants.RESISTANCE_LOW_PLUS,
				TroopConstants.MOVEMENT_RANGE_MEDIUM,
				TroopConstants.INITIATIVE_HIGH_PLUS, TroopConstants.MELEE_RANGE_HIGH_PLUS,
				TroopConstants.GRENADE_RANGE_MEDIUM,
				TroopConstants.PRECISION_SHOOTER_SQUAD));
			// another higher level of initiative and a higher level of melee range
		}
	});


	private final ValidatedEntriesHashMap<UnitLevel, UnitAttributes> propertyMap;


	private UnitLevel currentLevel;


	Unit (final ValidatedEntriesHashMap<UnitLevel, UnitAttributes> propertyMap)
	{
		// TODO: Load Index from Config
		this.currentLevel = UnitLevel.SINGLE_COMBATANT;

		this.propertyMap = propertyMap;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ValidatedEntriesHashMap<UnitLevel, UnitAttributes> getAllAttributes ()
	{
		return this.propertyMap;
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public UnitAttributes getCurrentAttributes ()
	{
		return this.propertyMap.get(this.currentLevel);
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public UnitLevel getLevel ()
	{
		return this.currentLevel;
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setLevel (final UnitLevel unitLevel)
	{
		this.currentLevel = unitLevel;
	}


	@Override
	public String toString ()
	{
		return "Unit{" + "propertyMap=" + this.propertyMap + ", currentLevel=" + this.currentLevel + '}';
	}
}
