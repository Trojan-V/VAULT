package me.vault.game.model.building;


import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import me.vault.game.interfaces.Upgradable;
import me.vault.game.model.currency.CurrencyTransaction;
import me.vault.game.utility.loading.ResourceLoader;
import me.vault.game.utility.struct.ValidatedEntriesHashMap;

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
 * @see Upgradable
 * @since 02.05.2024
 */
public enum CityBuilding
{
	/**
	 * Represents the Command Center {@link CityBuilding} in the city.
	 */
	COMMAND_CENTER(new ValidatedEntriesHashMap<>()
	{
		{
			this.put(CityBuildingLevel.OLD, new CityBuildingAttributes("Old Command Center", new CurrencyTransaction(-250, -250, -125, 0, 0)));

			this.put(CityBuildingLevel.NORMAL, new CityBuildingAttributes("Command Center", new CurrencyTransaction(-500, -500, -1000, 0, 0)));

			this.put(CityBuildingLevel.SUPER, new CityBuildingAttributes("Super Command Center", new CurrencyTransaction(-1000, -1000, -2000, 0, 0)));
		}
	}, ResourceLoader.loadImage(ASSETS_PATH + "Item_Pack/command_center_icon.png"), null),


	/**
	 * Represents the Docks {@link CityBuilding} in the city.
	 */
	DOCKS(new ValidatedEntriesHashMap<>()
	{{
		this.put(CityBuildingLevel.OLD, new CityBuildingAttributes("Old Docks", new CurrencyTransaction(-10, -10, -10, -10, -10)));

		this.put(CityBuildingLevel.NORMAL, new CityBuildingAttributes("Docks", new CurrencyTransaction(-10, -10, -10, -10, -10)));

		this.put(CityBuildingLevel.SUPER, new CityBuildingAttributes("Super Docks", new CurrencyTransaction(-10, -10, -10, -10, -10)));

	}}, ResourceLoader.loadImage(ASSETS_PATH + "Item_Pack/docks_icon.png"), ResourceLoader.loadScene(CityBuilding.class, "docks_view" + ".fxml")),


	/**
	 * Represents the Space Bar {@link CityBuilding} in the city.
	 */
	SPACE_BAR(new ValidatedEntriesHashMap<>()
	{
		{
			this.put(CityBuildingLevel.OLD, new CityBuildingAttributes("Old Space Bar", new CurrencyTransaction(-10, -10, -10, -10, -10)));

			this.put(CityBuildingLevel.NORMAL, new CityBuildingAttributes("Space Bar", new CurrencyTransaction(-10, -10, -10, -10, -10)));

			this.put(CityBuildingLevel.SUPER, new CityBuildingAttributes("Super Space Bar", new CurrencyTransaction(-10, -10, -10, -10, -10)));
		}
	}, ResourceLoader.loadImage(ASSETS_PATH + "Item_Pack/space_bar_icon.png"), null),


	/**
	 * Represents the Training Facility {@link CityBuilding} in the city.
	 */
	TRAINING_FACILITY(new ValidatedEntriesHashMap<>()
	{
		{
			this.put(CityBuildingLevel.OLD, new CityBuildingAttributes("Old Training Facility", new CurrencyTransaction(-10, -10, -10, -10, -10)));

			this.put(CityBuildingLevel.NORMAL, new CityBuildingAttributes("Training Facility", new CurrencyTransaction(-10, -10, -10, -10, -10)));

			this.put(CityBuildingLevel.SUPER,
				new CityBuildingAttributes("Super Training Facility", new CurrencyTransaction(-10, -10, -10, -10, -10)));
		}
	}, ResourceLoader.loadImage(ASSETS_PATH + "Item_Pack/training_facility_icon.png"),
		ResourceLoader.loadScene(CityBuilding.class, "training_facility_view.fxml")),


	/**
	 * Represents the Workshop {@link CityBuilding} in the city, which can be used to upgrade and build artifacts.
	 */
	WORKSHOP(new ValidatedEntriesHashMap<>()
	{
		{
			this.put(CityBuildingLevel.OLD, new CityBuildingAttributes("Old Workshop", new CurrencyTransaction(-10, -10, -10, -10, -10)));

			this.put(CityBuildingLevel.NORMAL, new CityBuildingAttributes("Workshop", new CurrencyTransaction(-10, -10, -10, -10, -10)));

			this.put(CityBuildingLevel.SUPER, new CityBuildingAttributes("Super Workshop", new CurrencyTransaction(-10, -10, -10, -10, -10)));
		}
	}, ResourceLoader.loadImage(ASSETS_PATH + "Item_Pack/workshop_icon.png"), ResourceLoader.loadScene(CityBuilding.class, "workshop_view.fxml")),


	/**
	 * Represents the Baracks {@link CityBuilding} in the city, which can be used to recruit troops.
	 */
	BARRACKS(new ValidatedEntriesHashMap<>()
	{
		{
			this.put(CityBuildingLevel.OLD, new CityBuildingAttributes("Old Barracks", new CurrencyTransaction(-10, -10, -10, -10, -10)));

			this.put(CityBuildingLevel.NORMAL, new CityBuildingAttributes("Baracks", new CurrencyTransaction(-10, -10, -10, -10, -10)));

			this.put(CityBuildingLevel.SUPER, new CityBuildingAttributes("Super Baracks", new CurrencyTransaction(-10, -10, -10, -10, -10)));
		}
	}, ResourceLoader.loadImage(ASSETS_PATH + "Item_Pack/barracks_icon.png"), null),


	/**
	 * Represents the Market {@link CityBuilding} in the city, which can be used to buy currencies.
	 */
	MARKET(new ValidatedEntriesHashMap<>()
	{
		{
			this.put(CityBuildingLevel.OLD, new CityBuildingAttributes("Old Market", new CurrencyTransaction(-10, -10, -10, -10, -10)));

			this.put(CityBuildingLevel.NORMAL, new CityBuildingAttributes("Market", new CurrencyTransaction(-10, -10, -10, -10, -10)));

			this.put(CityBuildingLevel.SUPER, new CityBuildingAttributes("Super Market", new CurrencyTransaction(-10, -10, -10, -10, -10)));
		}
	}, ResourceLoader.loadImage(ASSETS_PATH + "Item_Pack/market_icon.png"), null),


	/**
	 * Represents the Laboratory {@link CityBuilding} in the city.
	 */
	LABORATORY(new ValidatedEntriesHashMap<>()
	{
		{
			this.put(CityBuildingLevel.OLD, new CityBuildingAttributes("Old Laboratory", new CurrencyTransaction(-10, -10, -10, -10, -10)));

			this.put(CityBuildingLevel.NORMAL, new CityBuildingAttributes("Laboratory", new CurrencyTransaction(-10, -10, -10, -10, -10)));

			this.put(CityBuildingLevel.SUPER, new CityBuildingAttributes("Super Laboratory", new CurrencyTransaction(-10, -10, -10, -10, -10)));
		}
	}, ResourceLoader.loadImage(ASSETS_PATH + "Item_Pack/laboratory_icon.png"), null);

	//------------------------------------------------------------------------------------------------------------------

	/**
	 * The {@link MessageFormat} pattern, which is used to display the object in the console.
	 */
	private static final String TO_STRING_PATTERN = "{0}[currentLevel={1} | propertyMap={2}}";

	/**
	 * The hashmap, which contains the buildings properties corresponding to each building level.
	 */
	private final ValidatedEntriesHashMap<CityBuildingLevel, CityBuildingAttributes> propertyMap;

	private final SimpleObjectProperty<Image> spriteProperty;

	private final Scene scene;

	private CityBuildingLevel currentLevel;


	CityBuilding (final ValidatedEntriesHashMap<CityBuildingLevel, CityBuildingAttributes> propertyMap, final Image sprite, final Scene scene)
	{
		// TODO: Load Level from Config
		this.currentLevel = CityBuildingLevel.OLD;
		this.propertyMap = propertyMap;
		this.scene = scene;
		this.spriteProperty = new SimpleObjectProperty<>(sprite);
	}


	public Scene getScene ()
	{
		return this.scene;
	}


	/**
	 * {@inheritDoc}
	 */
	public Map<CityBuildingLevel, CityBuildingAttributes> getAllAttributes ()
	{
		return this.propertyMap;
	}


	/**
	 * {@inheritDoc}
	 */
	public CityBuildingAttributes getCurrentAttributes ()
	{
		return this.propertyMap.get(this.currentLevel);
	}


	/**
	 * {@inheritDoc}
	 */
	public CityBuildingLevel getLevel ()
	{
		return this.currentLevel;
	}


	/**
	 * {@inheritDoc}
	 */
	public void setLevel (final CityBuildingLevel cityBuildingLevel)
	{
		this.currentLevel = cityBuildingLevel;
	}


	/**
	 * {@inheritDoc}
	 */
	public SimpleObjectProperty<Image> getSpriteProperty ()
	{
		return this.spriteProperty;
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString ()
	{
		return MessageFormat.format(TO_STRING_PATTERN, this.name(), this.currentLevel, this.propertyMap);
	}


	/**
	 * Returns the sprite property of the displayable object.
	 *
	 * @return The sprite property of the displayable object as an {@link Image}
	 */
	public Image getSprite ()
	{
		return this.spriteProperty.get();
	}


	public void updateProperties ()
	{
		// TODO: Implement
	}
}
