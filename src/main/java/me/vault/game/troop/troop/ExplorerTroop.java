package me.vault.game.troop.troop;


import me.vault.game.utility.struct.ValidatedEntriesHashMap;
import me.vault.game.interfaces.IUpgradable;


public enum ExplorerTroop implements IUpgradable<ExplorerTroopLevel, ExplorerTroopProperties>
{
	MEDIC(new ValidatedEntriesHashMap<>()
	{{
		this.put(ExplorerTroopLevel.ONE, new ExplorerTroopProperties());
		this.put(ExplorerTroopLevel.TWO, new ExplorerTroopProperties());
		this.put(ExplorerTroopLevel.THREE, new ExplorerTroopProperties());
	}}),


	SHARPSHOOTER(new ValidatedEntriesHashMap<>()
	{{
		this.put(ExplorerTroopLevel.ONE, new ExplorerTroopProperties());
		this.put(ExplorerTroopLevel.TWO, new ExplorerTroopProperties());
		this.put(ExplorerTroopLevel.THREE, new ExplorerTroopProperties());
	}}),


	RANGER(new ValidatedEntriesHashMap<>()
	{{
		this.put(ExplorerTroopLevel.ONE, new ExplorerTroopProperties());
		this.put(ExplorerTroopLevel.TWO, new ExplorerTroopProperties());
		this.put(ExplorerTroopLevel.THREE, new ExplorerTroopProperties());
	}});


	private final ValidatedEntriesHashMap<ExplorerTroopLevel, ExplorerTroopProperties> propertyMap;


	private ExplorerTroopLevel currentLevel;


	ExplorerTroop (final ValidatedEntriesHashMap<ExplorerTroopLevel, ExplorerTroopProperties> propertyMap)
	{
		// TODO: Load Level from Config
		this.currentLevel = ExplorerTroopLevel.ONE;

		this.propertyMap = propertyMap;
	}


	@Override
	public ValidatedEntriesHashMap<ExplorerTroopLevel, ExplorerTroopProperties> getAllProperties ()
	{
		return this.propertyMap;
	}


	@Override
	public ExplorerTroopProperties getCurrentProperties ()
	{
		return this.propertyMap.get(this.currentLevel);
	}


	@Override
	public ExplorerTroopLevel getLevel ()
	{
		return this.currentLevel;
	}


	@Override
	public void setLevel (final ExplorerTroopLevel level)
	{
		this.currentLevel = level;
	}
}
