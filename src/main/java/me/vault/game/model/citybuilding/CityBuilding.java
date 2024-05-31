package me.vault.game.model.citybuilding;


import javafx.scene.image.Image;
import me.vault.game.model.interfaces.IUpgradable;
import me.vault.game.utility.ResourceLoader;

import java.text.MessageFormat;
import java.util.Map;

import static me.vault.game.utility.constant.GameConstants.ASSETS_PATH;


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
	COMMAND_CENTER(new ValidatedEntriesHashMap<>()
	{
		{
			this.put(CityBuildingLevel.OLD, new CityBuildingProperties("Old Command Center", null));
			this.put(CityBuildingLevel.NORMAL, new CityBuildingProperties("Command Center", null));
			this.put(CityBuildingLevel.SUPER, new CityBuildingProperties("Super Command Center", null));
		}
	}, ResourceLoader.loadImage(ASSETS_PATH + "Item_Pack/command_center_icon.png")),


	/**
	 * Represents the Docks {@link CityBuilding} in the city.
	 */
	DOCKS(new ValidatedEntriesHashMap<>()
	{
		{
			this.put(CityBuildingLevel.OLD, new CityBuildingProperties("Old Docks", null));
			this.put(CityBuildingLevel.NORMAL, new CityBuildingProperties("Docks", null));
			this.put(CityBuildingLevel.SUPER, new CityBuildingProperties("Super Docks", null));
		}
	}, ResourceLoader.loadImage(ASSETS_PATH + "Item_Pack/docks_icon.png")),


	/**
	 * Represents the Space Bar {@link CityBuilding} in the city.
	 */
	SPACE_BAR(new ValidatedEntriesHashMap<>()
	{
		{
			this.put(CityBuildingLevel.OLD, new CityBuildingProperties("Old Space Bar", null));
			this.put(CityBuildingLevel.NORMAL, new CityBuildingProperties("Space Bar", null));
			this.put(CityBuildingLevel.SUPER, new CityBuildingProperties("Super Space Bar", null));
		}
	}, ResourceLoader.loadImage(ASSETS_PATH + "Item_Pack/space_bar_icon.png")),


	/**
	 * Represents the Training Facility {@link CityBuilding} in the city.
	 */
	TRAINING_FACILITY(new ValidatedEntriesHashMap<>()
	{
		{
			this.put(CityBuildingLevel.OLD, new CityBuildingProperties("Old Training Facility", null));
			this.put(CityBuildingLevel.NORMAL, new CityBuildingProperties("Training Facility", null));
			this.put(CityBuildingLevel.SUPER, new CityBuildingProperties("Super Training Facility", null));
		}
	}, ResourceLoader.loadImage(ASSETS_PATH + "Item_Pack/training_facility_icon.png")),


	/**
	 * Represents the Workshop {@link CityBuilding} in the city, which can be used to upgrade and build artifacts.
	 */
	WORKSHOP(new ValidatedEntriesHashMap<>()
	{
		{
			this.put(CityBuildingLevel.OLD, new CityBuildingProperties("Old Workshop", null));
			this.put(CityBuildingLevel.NORMAL, new CityBuildingProperties("Workshop", null));
			this.put(CityBuildingLevel.SUPER, new CityBuildingProperties("Super Workshop", null));
		}
	}, ResourceLoader.loadImage(ASSETS_PATH + "Item_Pack/workshop_icon.png")),


	/**
	 * Represents the Baracks {@link CityBuilding} in the city, which can be used to recruit troops.
	 */
	BARACKS(new ValidatedEntriesHashMap<>()
	{
		{
			this.put(CityBuildingLevel.OLD, new CityBuildingProperties("Old Barracks", null));
			this.put(CityBuildingLevel.NORMAL, new CityBuildingProperties("Baracks", null));
			this.put(CityBuildingLevel.SUPER, new CityBuildingProperties("Super Baracks", null));
		}
	}, ResourceLoader.loadImage(ASSETS_PATH + "Item_Pack/barracks_icon.png")),


	/**
	 * Represents the Market {@link CityBuilding} in the city, which can be used to buy currencies.
	 */
	MARKET(new ValidatedEntriesHashMap<>()
	{
		{
			this.put(CityBuildingLevel.OLD, new CityBuildingProperties("Old Market", null));
			this.put(CityBuildingLevel.NORMAL, new CityBuildingProperties("Market", null));
			this.put(CityBuildingLevel.SUPER, new CityBuildingProperties("Super Market", null));
		}
	}, ResourceLoader.loadImage(ASSETS_PATH + "Item_Pack/market_icon.png")),


	/**
	 * Represents the Laboratory {@link CityBuilding} in the city.
	 */
	LABORATORY(new ValidatedEntriesHashMap<>()
	{
		{
			this.put(CityBuildingLevel.OLD, new CityBuildingProperties("Old Laboratory", null));
			this.put(CityBuildingLevel.NORMAL, new CityBuildingProperties("Laboratory", null));
			this.put(CityBuildingLevel.SUPER, new CityBuildingProperties("Super Laboratory", null));
		}
	}, ResourceLoader.loadImage(ASSETS_PATH + "Item_Pack/laboratory_icon.png"));


	private static final String TO_STRING_PATTERN = "{0}[currentLevel={1} | propertyMap={2}}";


	private final ValidatedEntriesHashMap<CityBuildingLevel, CityBuildingProperties> propertyMap;


	private final Image icon;


	private CityBuildingLevel currentLevel;


	CityBuilding (final ValidatedEntriesHashMap<CityBuildingLevel, CityBuildingProperties> propertyMap,
		final Image icon)
	{
		// TODO: Load Level from Config
		this.currentLevel = CityBuildingLevel.OLD;
		this.propertyMap = propertyMap;
		this.icon = icon;
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


	public Image getIcon ()
	{
		return this.icon;
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
