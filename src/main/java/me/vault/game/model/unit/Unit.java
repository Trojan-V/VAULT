package me.vault.game.model.unit;


import me.vault.game.controller.CurrencyController;
import me.vault.game.model.citybuilding.ValidatedEntriesHashMap;
import me.vault.game.model.interfaces.IUpgradable;


/**
 * @author Alexander Göthel
 * @version 1.0.0
 * @see IUpgradable
 * @since 28.05.2024
 */
public enum Unit implements IUpgradable<UnitLevel, UnitProperties>
{
	// Explorer-Association

	MEDIC(new ValidatedEntriesHashMap<>()
	{
		{
			this.put(UnitLevel.SINGEL_COMBATANT, new UnitProperties(CurrencyController.createTransaction(10, 10, 10,
				10, 10), 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, "Medic Single Combatant"));
			this.put(UnitLevel.COUPLE, new UnitProperties(CurrencyController.createTransaction(10, 10, 10, 10, 10), 1,
				1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, "Medic Couple"));
			this.put(UnitLevel.SQUAD, new UnitProperties(CurrencyController.createTransaction(10, 10, 10, 10, 10), 1,
				1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, "Medic Squad"));
		}
	}),

	SNIPER(new ValidatedEntriesHashMap<>()
	{
		{
			this.put(UnitLevel.SINGEL_COMBATANT, new UnitProperties(CurrencyController.createTransaction(10, 10, 10,
				10, 10), 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, "Sniper Single Combatant"));
			this.put(UnitLevel.COUPLE, new UnitProperties(CurrencyController.createTransaction(10, 10, 10, 10, 10), 1,
				1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, "Sniper Couple"));
			this.put(UnitLevel.SQUAD, new UnitProperties(CurrencyController.createTransaction(10, 10, 10, 10, 10), 1,
				1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, "Sniper Squad"));
		}
	}),

	RANGER(new ValidatedEntriesHashMap<>()
	{
		{
			this.put(UnitLevel.SINGEL_COMBATANT, new UnitProperties(CurrencyController.createTransaction(10, 10, 10,
				10, 10), 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, "Ranger Single Combatant"));
			this.put(UnitLevel.COUPLE, new UnitProperties(CurrencyController.createTransaction(10, 10, 10, 10, 10), 1,
				1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, "Ranger Couple"));
			this.put(UnitLevel.SQUAD, new UnitProperties(CurrencyController.createTransaction(10, 10, 10, 10, 10), 1,
				1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, "Ranger Squad"));
		}
	}),

	//--------------
	// militaristic government

	SPACE_MARINE(new ValidatedEntriesHashMap<>()
	{
		{
			this.put(UnitLevel.SINGEL_COMBATANT, new UnitProperties(CurrencyController.createTransaction(10, 10, 10,
				10, 10), 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, "Space-Marine Single Combatant"));
			this.put(UnitLevel.COUPLE, new UnitProperties(CurrencyController.createTransaction(10, 10, 10, 10, 10), 1,
				1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, "Space-Marine Couple"));
			this.put(UnitLevel.SQUAD, new UnitProperties(CurrencyController.createTransaction(10, 10, 10, 10, 10), 1,
				1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, "Space-Marine Squad"));
		}
	}),

	ENGINEER(new ValidatedEntriesHashMap<>()
	{
		{
			this.put(UnitLevel.SINGEL_COMBATANT, new UnitProperties(CurrencyController.createTransaction(10, 10, 10,
				10, 10), 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, "Engineer Single Combatant"));
			this.put(UnitLevel.COUPLE, new UnitProperties(CurrencyController.createTransaction(10, 10, 10, 10, 10), 1,
				1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, "Engineer Couple"));
			this.put(UnitLevel.SQUAD, new UnitProperties(CurrencyController.createTransaction(10, 10, 10, 10, 10), 1,
				1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, "Engineer Squad"));
		}
	}),

	OFFICER(new ValidatedEntriesHashMap<>()
	{
		{
			this.put(UnitLevel.SINGEL_COMBATANT, new UnitProperties(CurrencyController.createTransaction(10, 10, 10,
				10, 10), 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, "Officer Single Combatant"));
			this.put(UnitLevel.COUPLE, new UnitProperties(CurrencyController.createTransaction(10, 10, 10, 10, 10), 1,
				1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, "Officer Couple"));
			this.put(UnitLevel.SQUAD, new UnitProperties(CurrencyController.createTransaction(10, 10, 10, 10, 10), 1,
				1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, "Officer Squad"));
		}
	}),

	//-------------------
	// mega-corporation

	GUARD(new ValidatedEntriesHashMap<>()
	{
		{
			this.put(UnitLevel.SINGEL_COMBATANT, new UnitProperties(CurrencyController.createTransaction(10, 10, 10,
				10, 10), 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, "Guard Single Combatant"));
			this.put(UnitLevel.COUPLE, new UnitProperties(CurrencyController.createTransaction(10, 10, 10, 10, 10), 1,
				1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, "Guard Couple"));
			this.put(UnitLevel.SQUAD, new UnitProperties(CurrencyController.createTransaction(10, 10, 10, 10, 10), 1,
				1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, "Guard Squad"));
		}
	}),

	GRENADIER(new ValidatedEntriesHashMap<>()
	{
		{
			this.put(UnitLevel.SINGEL_COMBATANT, new UnitProperties(CurrencyController.createTransaction(10, 10, 10,
				10, 10), 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, "Grenadier Single Combatant"));
			this.put(UnitLevel.COUPLE, new UnitProperties(CurrencyController.createTransaction(10, 10, 10, 10, 10), 1,
				1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, "Grenadier Couple"));
			this.put(UnitLevel.SQUAD, new UnitProperties(CurrencyController.createTransaction(10, 10, 10, 10, 10), 1,
				1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, "Grenadier Squad"));
		}
	}),

	RECRUIT(new ValidatedEntriesHashMap<>()
	{
		{
			this.put(UnitLevel.SINGEL_COMBATANT, new UnitProperties(CurrencyController.createTransaction(10, 10, 10,
				10, 10), 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, "Recruit Single Combatant"));
			this.put(UnitLevel.COUPLE, new UnitProperties(CurrencyController.createTransaction(10, 10, 10, 10, 10), 1,
				1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, "Recruit Couple"));
			this.put(UnitLevel.SQUAD, new UnitProperties(CurrencyController.createTransaction(10, 10, 10, 10, 10), 1,
				1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, "Recruit Squad"));
		}
	}),

	//-------------------------
	// New-Terra

	INFANTRY(new ValidatedEntriesHashMap<>()
	{
		{
			this.put(UnitLevel.SINGEL_COMBATANT, new UnitProperties(CurrencyController.createTransaction(10, 10, 10,
				10, 10), 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, "Infantry Single Combatant"));
			this.put(UnitLevel.COUPLE, new UnitProperties(CurrencyController.createTransaction(10, 10, 10, 10, 10), 1,
				1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, "Infantry Couple"));
			this.put(UnitLevel.SQUAD, new UnitProperties(CurrencyController.createTransaction(10, 10, 10, 10, 10), 1,
				1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, "Infantry Squad"));
		}
	}),

	LIEUTENANT(new ValidatedEntriesHashMap<>()
	{
		{
			this.put(UnitLevel.SINGEL_COMBATANT, new UnitProperties(CurrencyController.createTransaction(10, 10, 10,
				10, 10), 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, "Lieutenant Single Combatant"));
			this.put(UnitLevel.COUPLE, new UnitProperties(CurrencyController.createTransaction(10, 10, 10, 10, 10), 1,
				1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, "Lieutenant Couple"));
			this.put(UnitLevel.SQUAD, new UnitProperties(CurrencyController.createTransaction(10, 10, 10, 10, 10), 1,
				1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, "Lieutenant Squad"));
		}
	}),

	PRECISION_SHOOTER(new ValidatedEntriesHashMap<>()
	{
		{
			this.put(UnitLevel.SINGEL_COMBATANT, new UnitProperties(CurrencyController.createTransaction(10, 10, 10,
				10, 10), 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, "Precision Shooter Single Combatant"));
			this.put(UnitLevel.COUPLE, new UnitProperties(CurrencyController.createTransaction(10, 10, 10, 10, 10), 1,
				1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, "Precision Shooter Couple"));
			this.put(UnitLevel.SQUAD, new UnitProperties(CurrencyController.createTransaction(10, 10, 10, 10, 10), 1,
				1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, "Precision Shooter Squad"));
		}
	});


	private final ValidatedEntriesHashMap<UnitLevel, UnitProperties> propertyMap;


	private UnitLevel currentLevel;


	Unit (final ValidatedEntriesHashMap<UnitLevel, UnitProperties> propertyMap)
	{
		// TODO: Load Index from Config
		this.currentLevel = UnitLevel.SINGEL_COMBATANT;

		this.propertyMap = propertyMap;
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public ValidatedEntriesHashMap<UnitLevel, UnitProperties> getAllProperties ()
	{
		return this.propertyMap;
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public UnitProperties getCurrentProperties ()
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
