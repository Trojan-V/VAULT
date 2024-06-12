package me.vault.game.model.city;


import javafx.scene.Scene;
import me.vault.game.model.building.AbsCityBuilding;
import me.vault.game.model.building.CityBuildingLevel;
import me.vault.game.model.currency.CurrencyTransaction;
import me.vault.game.utility.loading.ResourceLoader;
import me.vault.game.utility.logging.ILogger;
import me.vault.game.utility.logging.Logger;
import me.vault.game.utility.struct.MetaDataImage;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

import static me.vault.game.utility.constant.CityBuildingConstants.Barracks.*;
import static me.vault.game.utility.constant.NewLoggingConstants.Artifact.*;
import static me.vault.game.utility.logging.ILogger.Level.DEBUG;


/**
 * This class is an implementation of {@link AbsCityBuilding}.
 * <br>
 * The {@link Barracks} city building holds all information about the starting faction of the game, which can be selected by the player and be used in
 * missions and encounters.
 *
 * @author Vincent Wolf, Lasse-Leander Hillen
 * @version 2.0.0
 * @see me.vault.game.city.building.CityBuilding
 * @since 09.06.2024
 */
public final class Barracks extends AbsCityBuilding
{

	/**
	 * The logger object for this class used for writing to the console.
	 *
	 * @see Logger
	 */
	public static final ILogger LOGGER = new Logger(Barracks.class.getSimpleName());

	/**
	 * Singleton instance, as there's never a reason to have more than one {@link Barracks} city building. Instead of using a singleton, the entire
	 * class could've been created using solely static methods and fields.
	 */
	private static final Barracks INSTANCE;

	/**
	 * The {@link Scene} of the {@link Barracks} city building, which is extracted from the related .fxml-file with the {@link ResourceLoader} class.
	 */
	private static final Scene FXML_SCENE = ResourceLoader.loadScene(Barracks.class, "barracks_view.fxml");

	/**
	 * All possible names of the {@link Barracks} city building are stored in this map, with the {@link CityBuildingLevel} as key to denote which name
	 * corresponds to which {@link CityBuildingLevel}.
	 *
	 * @see Map
	 * @see CityBuildingLevel
	 */
	private static final Map<CityBuildingLevel, String> NAMES;

	/**
	 * All possible sprites of the {@link Barracks} city building are stored in this map, with the {@link CityBuildingLevel} as key to denote which
	 * sprite corresponds to which {@link CityBuildingLevel}.
	 *
	 * @see Map
	 * @see CityBuildingLevel
	 * @see Image
	 */
	private static final Map<CityBuildingLevel, MetaDataImage> SPRITES;

	/**
	 * All possible upgrade cost {@link CurrencyTransaction}'s of the {@link Barracks} city building are stored in this map, with the
	 * {@link CityBuildingLevel} as key to denote which set of upgrade costs corresponds to which {@link CityBuildingLevel}.
	 *
	 * @see Map
	 * @see CityBuildingLevel
	 * @see CurrencyTransaction
	 */
	private static final Map<CityBuildingLevel, CurrencyTransaction> UPGRADE_COSTS;


	static
	{
		/*
		 * To ensure that the static fields are initialized in the correct order, a static initializer is used
		 * instead of a direct initialization behind the declaration.
		 */

		// Fill the maps with the corresponding data.
		NAMES = initNamesMap();
		SPRITES = initSpritesMap();
		UPGRADE_COSTS = initUpgradeCostsMap();

		// Ensure the instance is created after all the other static fields are initialized.
		INSTANCE = new Barracks();
	}


	/**
	 * As this class is a singleton, no other class should be able to instantiate it, hence why a private constructor is used here to prohibit that.
	 */
	private Barracks () {}


	/**
	 * Initializes and returns the map of names, which contains all different names for the {@code Barracks} city building.
	 * <br>
	 * This map is created once and then stored in the {@link Barracks#NAMES} field to be able to re-use it when needed.
	 * <br>
	 * This method is invoked in the static initializer of this class.
	 *
	 * @return The map of names for the {@code Barracks} city building.
	 * @see Map
	 * @see CityBuildingLevel
	 */
	private static Map<CityBuildingLevel, String> initNamesMap ()
	{
		final Map<CityBuildingLevel, String> namesMap = new HashMap<>();
		namesMap.put(CityBuildingLevel.OLD, OLD_NAME);
		namesMap.put(CityBuildingLevel.NORMAL, NORMAL_NAME);
		namesMap.put(CityBuildingLevel.SUPER, SUPER_NAME);

		// Logging output
		LOGGER.logf(DEBUG, NAME_MAP_SET, namesMap.toString());
		return namesMap;
	}


	/**
	 * Initializes and returns the map of sprites, which contains all different names for the {@code Barracks} city building.
	 * <br>
	 * This map is created once and then stored in the {@link Barracks#SPRITES} field to be able to re-use it when needed.
	 * <br>
	 * This method is invoked in the static initializer of this class.
	 *
	 * @return The map of sprites for the {@code Barracks} city building.
	 * @see Map
	 * @see CityBuildingLevel
	 */
	private static Map<CityBuildingLevel, MetaDataImage> initSpritesMap ()
	{
		final Map<CityBuildingLevel, MetaDataImage> spritesMap = new HashMap<>();
		spritesMap.put(CityBuildingLevel.OLD, OLD_SPRITE);
		spritesMap.put(CityBuildingLevel.NORMAL, NORMAL_SPRITE);
		spritesMap.put(CityBuildingLevel.SUPER, SUPER_SPRITE);

		// Logging output
		LOGGER.logf(DEBUG, SPRITE_MAP_SET, spritesMap.toString());

		return spritesMap;
	}


	/**
	 * Initializes and returns the map of upgrade costs, which contains all different upgrade costs for the {@code Barracks} city building.
	 * <br>
	 * This map is created once and then stored in the {@link Barracks#UPGRADE_COSTS} field to be able to re-use it when needed.
	 * <br>
	 * This method is invoked in the static initializer of this class.
	 *
	 * @return The map of upgrade costs for the {@code Barracks} city building.
	 * @see Map
	 * @see CityBuildingLevel
	 * @see CurrencyTransaction
	 */
	private static Map<CityBuildingLevel, CurrencyTransaction> initUpgradeCostsMap ()
	{
		final Map<CityBuildingLevel, CurrencyTransaction> upgradeCostsMap = new HashMap<>();
		upgradeCostsMap.put(CityBuildingLevel.OLD, OLD_UPGRADE_COSTS);
		upgradeCostsMap.put(CityBuildingLevel.NORMAL, NORMAL_UPGRADE_COSTS);
		upgradeCostsMap.put(CityBuildingLevel.SUPER, CurrencyTransaction.EMPTY);

		// Logging output
		LOGGER.logf(DEBUG, UPGRADE_COST_MAP_SET, upgradeCostsMap.toString());

		return upgradeCostsMap;
	}


	/**
	 * Returns the singleton instance of this class.
	 *
	 * @return The singleton instance of this class.
	 */
	public static Barracks getInstance ()
	{
		return INSTANCE;
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	protected @NotNull Map<CityBuildingLevel, CurrencyTransaction> getUpgradeCosts ()
	{
		return UPGRADE_COSTS;
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	protected @NotNull Map<CityBuildingLevel, String> getNames ()
	{
		return NAMES;
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	protected @NotNull Map<CityBuildingLevel, MetaDataImage> getSprites ()
	{
		return SPRITES;
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	@NotNull
	public Scene getScene ()
	{
		return FXML_SCENE;
	}

}
