package me.vault.vaultgame.model.citybuilding;


import me.vault.vaultgame.model.interfaces.IUpgradable;

import java.util.Map;


/**
 * TODO: Write Javadoc
 * TODO: Fill the enum entries with actual data.
 * TODO: Attributes of enum constants stored in file, then read the data from the file?
 *
 * @author Lasse-Leander Hillen
 * @version 1.0.0
 * @see IUpgradable
 * @since 02.05.2024
 */
public enum CityBuilding implements IUpgradable<CityBuildingLevel, CityBuildingProperties>
{
	/**
	 * Represents the Command Center {@link CityBuilding} in the city.
	 */
	COMMAND_CENTER(
		new ValidatedEntriesHashMap<>()
		{{
			this.put(CityBuildingLevel.OLD, new CityBuildingProperties("Old Command Center", null, null));
			this.put(CityBuildingLevel.NORMAL, new CityBuildingProperties("Command Center", null, null));
			this.put(CityBuildingLevel.SUPER, new CityBuildingProperties("Super Command Center", null, null));
		}}),


	/**
	 * Represents the Docks  in the city.
	 */
	DOCKS(new ValidatedEntriesHashMap<>()
	{{
		this.put(CityBuildingLevel.OLD, new CityBuildingProperties("Old Docks", null, null));
		this.put(CityBuildingLevel.NORMAL, new CityBuildingProperties("Docks", null, null));
		this.put(CityBuildingLevel.SUPER, new CityBuildingProperties("Super Docks", null, null));
	}}),


	/**
	 * Represents the Space Bar  in the city.
	 */
	SPACE_BAR(new ValidatedEntriesHashMap<>()
	{{
		this.put(CityBuildingLevel.OLD, new CityBuildingProperties("Old Space Bar", null, null));
		this.put(CityBuildingLevel.NORMAL, new CityBuildingProperties("Space Bar", null, null));
		this.put(CityBuildingLevel.SUPER, new CityBuildingProperties("Super Space Bar", null, null));
	}}),


	/**
	 * Represents the Training Facility  in the city.
	 */
	TRAINING_FACILITY(new ValidatedEntriesHashMap<>()
	{{
		this.put(CityBuildingLevel.OLD, new CityBuildingProperties("Old Training Facility", null, null));
		this.put(CityBuildingLevel.NORMAL, new CityBuildingProperties("Training Facility", null, null));
		this.put(CityBuildingLevel.SUPER, new CityBuildingProperties("Super Training Facility", null, null));
	}}),


	/**
	 * Represents the Workshop  in the city, which can be used to upgrade and build artifacts.
	 */
	WORKSHOP(new ValidatedEntriesHashMap<>()
	{{
		this.put(CityBuildingLevel.OLD, new CityBuildingProperties("Old Workshop", null, null));
		this.put(CityBuildingLevel.NORMAL, new CityBuildingProperties("Workshop", null, null));
		this.put(CityBuildingLevel.SUPER, new CityBuildingProperties("Super Workshop", null, null));
	}});


	private final ValidatedEntriesHashMap<CityBuildingLevel, CityBuildingProperties> propertyMap;


	private CityBuildingLevel currentLevel;


	CityBuilding (final ValidatedEntriesHashMap<CityBuildingLevel, CityBuildingProperties> propertyMap)
	{
		// TODO: Load Level from Config
		this.currentLevel = CityBuildingLevel.OLD;

		this.propertyMap = propertyMap;
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public Map<CityBuildingLevel, CityBuildingProperties> getAllProperties ()
	{
		return this.propertyMap;
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public CityBuildingProperties getCurrentProperties ()
	{
		return this.propertyMap.get(this.currentLevel);
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public CityBuildingLevel getLevel ()
	{
		return this.currentLevel;
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setLevel (final CityBuildingLevel cityBuildingLevel)
	{
		this.currentLevel = cityBuildingLevel;
	}


	@Override
	public String toString ()
	{
		return "CityBuilding{" +
		       "propertyMap=" + this.propertyMap +
		       ", currentLevel=" + this.currentLevel +
		       '}';
	}
}
