package me.vault.game.city.building;


import javafx.scene.Scene;
import javafx.scene.image.Image;
import me.vault.game.currency.CurrencyController;
import me.vault.game.interfaces.IDisplayable;
import me.vault.game.interfaces.IUpgradable;
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
 * @see IUpgradable
 * @since 02.05.2024
 */
public enum CityBuilding implements IUpgradable<CityBuildingLevel, CityBuildingProperties>, IDisplayable {
    /**
     * Represents the Command Center {@link CityBuilding} in the city.
     */
    COMMAND_CENTER(new ValidatedEntriesHashMap<>() {
        {
            this.put(CityBuildingLevel.OLD, new CityBuildingProperties("Old Command Center", CurrencyController.createTransaction(-250, -250, -125, 0, 0)));

            this.put(CityBuildingLevel.NORMAL, new CityBuildingProperties("Command Center", CurrencyController.createTransaction(-500, -500, -1000, 0, 0)));

            this.put(CityBuildingLevel.SUPER, new CityBuildingProperties("Super Command Center", CurrencyController.createTransaction(-1000, -1000, -2000, 0, 0)));
        }
    }, ResourceLoader.loadImage(ASSETS_PATH + "Item_Pack/command_center_icon.png"), null),


    /**
     * Represents the Docks {@link CityBuilding} in the city.
     */
    DOCKS(new ValidatedEntriesHashMap<>() {{
        this.put(CityBuildingLevel.OLD, new CityBuildingProperties("Old Docks", CurrencyController.createTransaction(-10, -10, -10, -10, -10)));

        this.put(CityBuildingLevel.NORMAL, new CityBuildingProperties("Docks", CurrencyController.createTransaction(-10, -10, -10, -10, -10)));

        this.put(CityBuildingLevel.SUPER, new CityBuildingProperties("Super Docks", CurrencyController.createTransaction(-10, -10, -10, -10, -10)));

    }}, ResourceLoader.loadImage(ASSETS_PATH + "Item_Pack/docks_icon.png"), ResourceLoader.loadFXMLScene(CityBuilding.class, "docks_view.fxml")),


    /**
     * Represents the Space Bar {@link CityBuilding} in the city.
     */
    SPACE_BAR(new ValidatedEntriesHashMap<>() {
        {
            this.put(CityBuildingLevel.OLD, new CityBuildingProperties("Old Space Bar", CurrencyController.createTransaction(-10, -10, -10, -10, -10)));

            this.put(CityBuildingLevel.NORMAL, new CityBuildingProperties("Space Bar", CurrencyController.createTransaction(-10, -10, -10, -10, -10)));

            this.put(CityBuildingLevel.SUPER, new CityBuildingProperties("Super Space Bar", CurrencyController.createTransaction(-10, -10, -10, -10, -10)));
        }
    }, ResourceLoader.loadImage(ASSETS_PATH + "Item_Pack/space_bar_icon.png"), null),


    /**
     * Represents the Training Facility {@link CityBuilding} in the city.
     */
    TRAINING_FACILITY(new ValidatedEntriesHashMap<>() {
        {
            this.put(CityBuildingLevel.OLD, new CityBuildingProperties("Old Training Facility", CurrencyController.createTransaction(-10, -10, -10, -10, -10)));

            this.put(CityBuildingLevel.NORMAL, new CityBuildingProperties("Training Facility", CurrencyController.createTransaction(-10, -10, -10, -10, -10)));

            this.put(CityBuildingLevel.SUPER, new CityBuildingProperties("Super Training Facility", CurrencyController.createTransaction(-10, -10, -10, -10, -10)));
        }
    }, ResourceLoader.loadImage(ASSETS_PATH + "Item_Pack/training_facility_icon.png"), null),


    /**
     * Represents the Workshop {@link CityBuilding} in the city, which can be used to upgrade and build artifacts.
     */
    WORKSHOP(new ValidatedEntriesHashMap<>() {
        {
            this.put(CityBuildingLevel.OLD, new CityBuildingProperties("Old Workshop", CurrencyController.createTransaction(-10, -10, -10, -10, -10)));

            this.put(CityBuildingLevel.NORMAL, new CityBuildingProperties("Workshop", CurrencyController.createTransaction(-10, -10, -10, -10, -10)));

            this.put(CityBuildingLevel.SUPER, new CityBuildingProperties("Super Workshop", CurrencyController.createTransaction(-10, -10, -10, -10, -10)));
        }
    }, ResourceLoader.loadImage(ASSETS_PATH + "Item_Pack/workshop_icon.png"), ResourceLoader.loadFXMLScene(CityBuilding.class, "workshop_view.fxml")),


    /**
     * Represents the Baracks {@link CityBuilding} in the city, which can be used to recruit troops.
     */
    BARRACKS(new ValidatedEntriesHashMap<>() {
        {
            this.put(CityBuildingLevel.OLD, new CityBuildingProperties("Old Barracks", CurrencyController.createTransaction(-10, -10, -10, -10, -10)));

            this.put(CityBuildingLevel.NORMAL, new CityBuildingProperties("Baracks", CurrencyController.createTransaction(-10, -10, -10, -10, -10)));

            this.put(CityBuildingLevel.SUPER, new CityBuildingProperties("Super Baracks", CurrencyController.createTransaction(-10, -10, -10, -10, -10)));
        }
    }, ResourceLoader.loadImage(ASSETS_PATH + "Item_Pack/barracks_icon.png"), null),


    /**
     * Represents the Market {@link CityBuilding} in the city, which can be used to buy currencies.
     */
    MARKET(new ValidatedEntriesHashMap<>() {
        {
            this.put(CityBuildingLevel.OLD, new CityBuildingProperties("Old Market", CurrencyController.createTransaction(-10, -10, -10, -10, -10)));

            this.put(CityBuildingLevel.NORMAL, new CityBuildingProperties("Market", CurrencyController.createTransaction(-10, -10, -10, -10, -10)));

            this.put(CityBuildingLevel.SUPER, new CityBuildingProperties("Super Market", CurrencyController.createTransaction(-10, -10, -10, -10, -10)));
        }
    }, ResourceLoader.loadImage(ASSETS_PATH + "Item_Pack/market_icon.png"), null),


    /**
     * Represents the Laboratory {@link CityBuilding} in the city.
     */
    LABORATORY(new ValidatedEntriesHashMap<>() {
        {
            this.put(CityBuildingLevel.OLD, new CityBuildingProperties("Old Laboratory", CurrencyController.createTransaction(-10, -10, -10, -10, -10)));

            this.put(CityBuildingLevel.NORMAL, new CityBuildingProperties("Laboratory", CurrencyController.createTransaction(-10, -10, -10, -10, -10)));

            this.put(CityBuildingLevel.SUPER, new CityBuildingProperties("Super Laboratory", CurrencyController.createTransaction(-10, -10, -10, -10, -10)));
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
    private final ValidatedEntriesHashMap<CityBuildingLevel, CityBuildingProperties> propertyMap;


    private final Image icon;


    private final Scene scene;

    
    private CityBuildingLevel currentLevel;


    CityBuilding(final ValidatedEntriesHashMap<CityBuildingLevel, CityBuildingProperties> propertyMap, final Image icon, Scene scene) {
        // TODO: Load Level from Config
        this.currentLevel = CityBuildingLevel.OLD;
        this.propertyMap = propertyMap;
        this.scene = scene;
        this.icon = icon;
    }


    public Scene getScene() {
        return scene;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public Map<CityBuildingLevel, CityBuildingProperties> getAllProperties() {
        return this.propertyMap;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public CityBuildingProperties getCurrentProperties() {
        return this.propertyMap.get(this.currentLevel);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public CityBuildingLevel getLevel() {
        return this.currentLevel;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public void setLevel(final CityBuildingLevel cityBuildingLevel) {
        this.currentLevel = cityBuildingLevel;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public Image getSprite() {
        return this.icon;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return MessageFormat.format(TO_STRING_PATTERN, this.name(), this.currentLevel, this.propertyMap);
    }
}
