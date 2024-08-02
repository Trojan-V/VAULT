package me.vault.game.model.city.implementation;


import me.vault.game.model.city.CityBuilding;
import me.vault.game.model.city.CityBuildingLevel;
import me.vault.game.model.currency.CurrencyTransaction;
import me.vault.game.utility.datatypes.MetaDataImage;
import me.vault.game.utility.datatypes.ValidatedEntriesHashMap;
import me.vault.game.utility.interfaces.Upgradable;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

import static me.vault.game.utility.interfaces.constant.CityBuildingConstants.Docks.*;


/**
 * This class is an implementation of {@link CityBuilding}.
 * <br>
 * The {@link Docks} city building holds all information about the factions of the game, which can be selected by the player and be used in
 * missions and encounters.
 *
 * @author Vincent Wolf, Lasse-Leander Hillen, Timothy Hoegen-Jupp, Alexander Goethel
 * @version 1.0.0
 * @see CityBuilding
 * @see Upgradable
 * @since 09.06.2024
 */
public final class Docks extends CityBuilding
{

	/**
	 * Singleton instance, as there's never a reason to have more than one {@link Docks} city building.
	 * Instead of using a singleton, the entire class could've been created using solely static methods and fields.
	 */
	private static final Docks INSTANCE;


	/**
	 * All possible names of the {@link Docks} city building are stored in this {@link Map}, with the {@link CityBuildingLevel} as key to denote which
	 * name corresponds to which {@code CityBuildingLevel}.
	 */
	private static final Map<CityBuildingLevel, String> NAMES = new ValidatedEntriesHashMap<>();

	/**
	 * All possible sprites of the {@link Docks} city building are stored in this {@link Map}, with the {@link CityBuildingLevel} as key to denote which
	 * sprite corresponds to which {@code CityBuildingLevel}.
	 */
	private static final Map<CityBuildingLevel, MetaDataImage> SPRITES = new ValidatedEntriesHashMap<>();

	/**
	 * All possible upgrade cost {@link CurrencyTransaction}'s of the {@link Docks} city building are stored in this {@link Map}, with the
	 * {@link CityBuildingLevel} as key to denote which set of upgrade costs corresponds to which {@code CityBuildingLevel}.
	 */
	private static final Map<CityBuildingLevel, CurrencyTransaction> UPGRADE_COSTS = new ValidatedEntriesHashMap<>();


	static
	{
		NAMES.put(CityBuildingLevel.OLD, OLD_NAME);
		NAMES.put(CityBuildingLevel.NORMAL, NORMAL_NAME);
		NAMES.put(CityBuildingLevel.SUPER, SUPER_NAME);

		SPRITES.put(CityBuildingLevel.OLD, OLD_SPRITE);
		SPRITES.put(CityBuildingLevel.NORMAL, NORMAL_SPRITE);
		SPRITES.put(CityBuildingLevel.SUPER, SUPER_SPRITE);

		UPGRADE_COSTS.put(CityBuildingLevel.OLD, OLD_UPGRADE_COSTS);
		UPGRADE_COSTS.put(CityBuildingLevel.NORMAL, NORMAL_UPGRADE_COSTS);
		UPGRADE_COSTS.put(CityBuildingLevel.SUPER, CurrencyTransaction.EMPTY);

		// Create the singleton instance at last, so all maps are filled with values as the data in these maps is required to create an instance of this class.
		INSTANCE = new Docks();
	}


	/**
	 * As this class is a singleton, no other class should be able to instantiate it, hence why a private constructor is used here to prohibit that.
	 *
	 * @precondition Constructor gets called from within the class.
	 * @postcondition A new instance of Docks is created.
	 */
	private Docks () {}


	/**
	 * Returns the singleton instance of this class.
	 *
	 * @return The singleton instance of this class.
	 *
	 * @precondition The singleton Instance exists.
	 * @postcondition The singleton Instance of this class has been returned.
	 */
	public static Docks getInstance ()
	{
		return INSTANCE;
	}


	/**
	 * This method provides a {@link Map} of all {@link CurrencyTransaction}s which are mapped to the {@link CityBuildingLevel} they belong to.
	 * These {@link CurrencyTransaction}s represent the upgrade costs to upgrade the city building to the next level.
	 * <br>
	 * It is important that the {@link Map} of {@link CurrencyTransaction}s that is returned by this method is ready before this method gets invoked.
	 * <br>
	 * As this method is invoked within the constructor of this class to extract the data from it, the map can't be created during the instantiation of the
	 * subclass, as the constructor of this class will always be invoked first (because the first call in the constructor of a subclass is always a call to
	 * the constructor of the superclass).
	 * <br>
	 * Therefore, this {@link Map} has to be created during class initialization instead of instance initialization.
	 * <br>
	 * Due to that,every subclass of this class declares a static block where the order of operations during the class initialization is written.
	 * Note that the singleton instance of the subclass is getting created last, so it's ensured that this {@link Map} is filled with data.
	 *
	 * @return A {@link Map} of all {@link CurrencyTransaction}s which are mapped to the {@link CityBuildingLevel} they belong to.
	 * These key-value combinations represent the upgrade costs to upgrade the city building to the next level.
	 *
	 * @precondition The method has been implemented by a subclass and is called from there.
	 * @postcondition A Map with the CityBuildingLevels as keys and the CurrencyTransactions as values of all the different upgrade costs is returned.
	 */
	@Override
	@NotNull
	public Map<CityBuildingLevel, CurrencyTransaction> getAllUpgradeCosts ()
	{
		return UPGRADE_COSTS;
	}


	/**
	 * This method provides a {@link Map} of all {@link String}s that are mapped to the {@link CityBuildingLevel} they belong to.
	 * These {@link String}s represent the name of the city building at the selected level.
	 * <br>
	 * It is important that the {@link Map} of {@link String}s that is returned by this method is ready before this method gets invoked.
	 * <br>
	 * As this method is invoked within the constructor of this class to extract the data from it, the map can't be created during the instantiation of the
	 * subclass, as the constructor of this class will always be invoked first (because the first call in the constructor of a subclass is always a call to
	 * the constructor of the superclass).
	 * <br>
	 * Therefore, this {@link Map} has to be created during class initialization instead of instance initialization.
	 * <br>
	 * Due to that,every subclass of this class declares a static block where the order of operations during the class initialization is written.
	 * Note that the singleton instance of the subclass is getting created last, so it's ensured that this {@link Map} is filled with data.
	 *
	 * @return A {@link Map} of all {@link String}s which are mapped to the {@link CityBuildingLevel} they belong to.
	 * These key-value combinations represent the name of the city building at the selected level.
	 *
	 * @precondition The method has been implemented by a subclass and is called from there.
	 * @postcondition A Map with the CityBuildingLevels as keys and the Name-String as values of all the different upgrade costs is returned.
	 */
	@Override
	@NotNull
	public Map<CityBuildingLevel, String> getAllNames ()
	{
		return NAMES;
	}


	/**
	 * This method provides a {@link Map} of all {@link MetaDataImage}s that are mapped to the {@link CityBuildingLevel} they belong to.
	 * These {@link MetaDataImage}s represent the sprite of the city building at the selected level.
	 * <br>
	 * It is important that the {@link Map} of {@link MetaDataImage}s that is returned by this method is ready before this method gets invoked.
	 * <br>
	 * As this method is invoked within the constructor of this class to extract the data from it, the map can't be created during the instantiation of the
	 * subclass, as the constructor of this class will always be invoked first (because the first call in the constructor of a subclass is always a call to
	 * the constructor of the superclass).
	 * <br>
	 * Therefore, this {@link Map} has to be created during class initialization instead of instance initialization.
	 * <br>
	 * Due to that,every subclass of this class declares a static block where the order of operations during the class initialization is written.
	 * Note that the singleton instance of the subclass is getting created last, so it's ensured that this {@link Map} is filled with data.
	 *
	 * @return A {@link Map} of all {@link MetaDataImage}s which are mapped to the {@link CityBuildingLevel} they belong to.
	 * These key-value combinations represent the sprite of the city building at the selected level.
	 *
	 * @precondition The method has been implemented by a subclass and is called from there.
	 * @postcondition A Map with the CityBuildingLevels as keys and the MetaDataImages as values of all the different upgrade costs is returned.
	 */
	@Override
	@NotNull
	public Map<CityBuildingLevel, MetaDataImage> getAllSprites ()
	{
		return SPRITES;
	}

}
