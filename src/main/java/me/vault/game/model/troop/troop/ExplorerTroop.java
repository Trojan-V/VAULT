package me.vault.game.model.troop.troop;


import me.vault.game.utility.struct.ValidatedEntriesHashMap;


public enum ExplorerTroop
{
	MEDIC(new ValidatedEntriesHashMap<>()
	{{
		this.put(ExplorerTroopLevel.ONE, new ExplorerTroopAttributes());
		this.put(ExplorerTroopLevel.TWO, new ExplorerTroopAttributes());
		this.put(ExplorerTroopLevel.THREE, new ExplorerTroopAttributes());
	}}),

	SHARPSHOOTER(new ValidatedEntriesHashMap<>()
	{{
		this.put(ExplorerTroopLevel.ONE, new ExplorerTroopAttributes());
		this.put(ExplorerTroopLevel.TWO, new ExplorerTroopAttributes());
		this.put(ExplorerTroopLevel.THREE, new ExplorerTroopAttributes());
	}}),

	RANGER(new ValidatedEntriesHashMap<>()
	{{
		this.put(ExplorerTroopLevel.ONE, new ExplorerTroopAttributes());
		this.put(ExplorerTroopLevel.TWO, new ExplorerTroopAttributes());
		this.put(ExplorerTroopLevel.THREE, new ExplorerTroopAttributes());
	}});

	private final ValidatedEntriesHashMap<ExplorerTroopLevel, ExplorerTroopAttributes> propertyMap;

	private ExplorerTroopLevel currentLevel;


	ExplorerTroop (final ValidatedEntriesHashMap<ExplorerTroopLevel, ExplorerTroopAttributes> propertyMap)
	{
		// TODO: Load Level from Config
		this.currentLevel = ExplorerTroopLevel.ONE;

		this.propertyMap = propertyMap;
	}


	public ValidatedEntriesHashMap<ExplorerTroopLevel, ExplorerTroopAttributes> getAllAttributes ()
	{
		return this.propertyMap;
	}


	public ExplorerTroopAttributes getCurrentAttributes ()
	{
		return this.propertyMap.get(this.currentLevel);
	}


	public ExplorerTroopLevel getLevel ()
	{
		return this.currentLevel;
	}


	public void setLevel (final ExplorerTroopLevel level)
	{
		this.currentLevel = level;
	}
}
