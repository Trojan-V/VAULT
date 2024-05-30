package me.vault.vaultgame.model.citybuilding;


import me.vault.vaultgame.model.interfaces.IUpgradable;
import me.vault.vaultgame.utility.ResourceLoader;

import java.text.MessageFormat;
import java.util.Map;

import static me.vault.vaultgame.utility.constant.GameConstants.ASSETS_PATH;


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
			this.put(CityBuildingLevel.OLD, new CityBuildingProperties("Old Command Center",
				ResourceLoader.loadImage(ASSETS_PATH + "Forge_Button_32x32.png"), null));

			this.put(CityBuildingLevel.NORMAL, new CityBuildingProperties("Command Center",
				ResourceLoader.loadImage(ASSETS_PATH + "Forge_Button_32x32.png"), null));

			this.put(CityBuildingLevel.SUPER, new CityBuildingProperties("Super Command Center",
				ResourceLoader.loadImage(ASSETS_PATH + "Forge_Button_32x32.png"), null));
		}}),


	/**
	 * Represents the Docks {@link CityBuilding} in the city.
	 */
	DOCKS(new ValidatedEntriesHashMap<>()
	{{
		this.put(CityBuildingLevel.OLD, new CityBuildingProperties("Old Docks",
			ResourceLoader.loadImage(ASSETS_PATH + "Forge_Button_32x32.png"), null));

		this.put(CityBuildingLevel.NORMAL, new CityBuildingProperties("Docks",
			ResourceLoader.loadImage(ASSETS_PATH + "Forge_Button_32x32.png"), null));

		this.put(CityBuildingLevel.SUPER, new CityBuildingProperties("Super Docks",
			ResourceLoader.loadImage(ASSETS_PATH + "Forge_Button_32x32.png"), null));
	}}),


	/**
	 * Represents the Space Bar {@link CityBuilding} in the city.
	 */
	SPACE_BAR(new ValidatedEntriesHashMap<>()
	{{
		this.put(CityBuildingLevel.OLD, new CityBuildingProperties("Old Space Bar",
			ResourceLoader.loadImage(ASSETS_PATH + "Forge_Button_32x32.png"), null));

		this.put(CityBuildingLevel.NORMAL, new CityBuildingProperties("Space Bar",
			ResourceLoader.loadImage(ASSETS_PATH + "Forge_Button_32x32.png"), null));

		this.put(CityBuildingLevel.SUPER, new CityBuildingProperties("Super Space Bar",
			ResourceLoader.loadImage(ASSETS_PATH + "Forge_Button_32x32.png"), null));
	}}),


	/**
	 * Represents the Training Facility {@link CityBuilding} in the city.
	 */
	TRAINING_FACILITY(new ValidatedEntriesHashMap<>()
	{{
		this.put(CityBuildingLevel.OLD, new CityBuildingProperties("Old Training Facility",
			ResourceLoader.loadImage(ASSETS_PATH + "Forge_Button_32x32.png"), null));

		this.put(CityBuildingLevel.NORMAL, new CityBuildingProperties("Training Facility",
			ResourceLoader.loadImage(ASSETS_PATH + "Forge_Button_32x32.png"), null));

		this.put(CityBuildingLevel.SUPER, new CityBuildingProperties("Super Training Facility",
			ResourceLoader.loadImage(ASSETS_PATH + "Forge_Button_32x32.png"), null));
	}}),


	/**
	 * Represents the Workshop {@link CityBuilding} in the city, which can be used to upgrade and build artifacts.
	 */
	WORKSHOP(new ValidatedEntriesHashMap<>()
	{{
		this.put(CityBuildingLevel.OLD, new CityBuildingProperties("Old Workshop",
			ResourceLoader.loadImage(ASSETS_PATH + "Forge_Button_32x32.png"), null));

		this.put(CityBuildingLevel.NORMAL, new CityBuildingProperties("Workshop",
			ResourceLoader.loadImage(ASSETS_PATH + "Forge_Button_32x32.png"), null));

		this.put(CityBuildingLevel.SUPER, new CityBuildingProperties("Super Workshop",
			ResourceLoader.loadImage(ASSETS_PATH + "Forge_Button_32x32.png"), null));
	}}),

	/**
	 * Represents the Baracks {@link CityBuilding} in the city, which can be used to recruit troops.
	 */
	BARACKS(new ValidatedEntriesHashMap<>()
	{{
		this.put(CityBuildingLevel.OLD, new CityBuildingProperties("Old Baracks",
			ResourceLoader.loadImage(ASSETS_PATH + "Forge_Button_32x32.png"), null));

		this.put(CityBuildingLevel.NORMAL, new CityBuildingProperties("Baracks",
			ResourceLoader.loadImage(ASSETS_PATH + "Forge_Button_32x32.png"), null));

		this.put(CityBuildingLevel.SUPER, new CityBuildingProperties("Super Baracks",
			ResourceLoader.loadImage(ASSETS_PATH + "Forge_Button_32x32.png"), null));
	}}),

	/**
	 * Represents the Market {@link CityBuilding} in the city, which can be used to buy currencies.
	 */
	MARKET(new ValidatedEntriesHashMap<>()
	{{
		this.put(CityBuildingLevel.OLD, new CityBuildingProperties("Old Market",
			ResourceLoader.loadImage(ASSETS_PATH + "Forge_Button_32x32.png"), null));

		this.put(CityBuildingLevel.NORMAL, new CityBuildingProperties("Market",
			ResourceLoader.loadImage(ASSETS_PATH + "Forge_Button_32x32.png"), null));

		this.put(CityBuildingLevel.SUPER, new CityBuildingProperties("Super Market",
			ResourceLoader.loadImage(ASSETS_PATH + "Forge_Button_32x32.png"), null));
	}});


	private static final String TO_STRING_PATTERN = "{0}[currentLevel={1} | propertyMap={2}}";


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
		return MessageFormat.format(TO_STRING_PATTERN, this.name(), this.currentLevel, this.propertyMap);
	}
}
