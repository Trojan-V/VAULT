package me.vault.game.model.energy.implementation;


import javafx.scene.image.Image;
import me.vault.game.model.currency.CurrencyTransaction;
import me.vault.game.model.energy.AbilityMultiplier;
import me.vault.game.model.energy.EnergyAbility;
import me.vault.game.model.energy.EnergyLevel;
import me.vault.game.utility.datatypes.MetaDataImage;
import me.vault.game.utility.loading.ResourceLoader;
import me.vault.game.utility.logging.ILogger;
import me.vault.game.utility.logging.Logger;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

import static me.vault.game.utility.interfaces.constant.EnergyConstants.*;
import static me.vault.game.utility.interfaces.constant.EnergyConstants.Initiative.BASE_TO_IMPROVED_UPGRADE_COSTS;
import static me.vault.game.utility.interfaces.constant.EnergyConstants.Initiative.IMPROVED_TO_NONE_UPGRADE_COSTS;
import static me.vault.game.utility.interfaces.constant.LoggingConstants.Artifact.*;
import static me.vault.game.utility.logging.ILogger.Level.DEBUG;


/**
 * This class is an implementation of {@link EnergyAbility}.
 * <br>
 * As this specification is an initiative energy ability, it provides positive ability modifiers towards the
 * initiative
 * ability.
 *
 * @author Vincent Wolf, Lasse-Leander Hillen, Timothy Hoegen-Jupp, Alexander Goethel
 * @version 1.0.0
 * @see EnergyAbility
 * @since 25.07.2024
 */
public final class InitiativeAbility extends EnergyAbility
{

	/**
	 * The {@link Logger} object for this class used for writing to the console.
	 */
	private static final ILogger LOGGER = new Logger(InitiativeAbility.class.getSimpleName());

	/**
	 * Singleton instance, as there's never a reason to have more than one {@link InitiativeAbility}. Instead of using a singleton,
	 * the entire class could've been created using solely static methods and fields.
	 */
	private static final InitiativeAbility INSTANCE;

	/**
	 * All possible names of the initiative energy ability are stored in this {@link Map}, with the
	 * {@link EnergyLevel} as key to denote which name corresponds to which {@link EnergyLevel}.
	 */
	private static final Map<EnergyLevel, String> NAMES;

	/**
	 * All possible sprites ({@link Image}) of the initiative energy ability are stored in this {@link Map}, with the
	 * {@link EnergyLevel} as key to denote which sprite corresponds to which {@link EnergyLevel}.
	 */
	private static final Map<EnergyLevel, MetaDataImage> SPRITES;

	/**
	 * All possible modifier sets of the initiative energy ability are stored in this {@link Map}, with the {@link EnergyLevel} as
	 * key to denote which set of modifiers corresponds to which {@link EnergyLevel}.
	 */
	private static final Map<EnergyLevel, Map<AbilityMultiplier.Type, Double>> MODIFIERS;

	/**
	 * All possible upgrade cost {@link CurrencyTransaction}'s of the initiative energy ability are stored in this
	 * {@link Map}, with the {@link EnergyLevel} as key to denote which set of upgrade costs corresponds to which {@link EnergyLevel}.
	 */
	private static final Map<EnergyLevel, CurrencyTransaction> UPGRADE_COSTS;


	static
	{
		/*
		 * To ensure that the static fields are initialized in the correct order, a static initializer is used
		 * instead of a direct initialization behind the declaration.
		 */

		// Fill the maps with the corresponding data.
		NAMES = initNamesMap();
		SPRITES = initSpritesMap();
		MODIFIERS = initModifiersMap();
		UPGRADE_COSTS = initUpgradeCostsMap();

		// Ensure the instance is created after all the other static fields are initialized.
		INSTANCE = new InitiativeAbility();
	}


	/**
	 * As this class is a singleton, no other class should be able to instantiate it, hence why a private constructor is used here to prohibit that.
	 * @precondition Constructor gets called from within the class.
	 * @postcondition A new instance of InitiativeAbility is created.
	 */
	private InitiativeAbility () {}


	/**
	 * Initializes and returns the map of upgrade costs, which contains all different upgrade costs for the initiative energy ability.
	 * <br>
	 * This map is created once and then stored in the {@link InitiativeAbility#UPGRADE_COSTS} field to be able to re-use it when needed.
	 * <br>
	 * This method is invoked in the static initializer of this class.
	 *
	 * @return The map of upgrade costs for the initiative energy ability.
	 *
	 * @precondition The upgrade costs for different {@link EnergyLevel} exists.
	 * @postcondition A map of upgrade costs for this ability is initialized.
	 */
	private static Map<EnergyLevel, CurrencyTransaction> initUpgradeCostsMap ()
	{
		// Fill the map with the different upgrade cost transactions.
		final Map<EnergyLevel, CurrencyTransaction> upgradeCostsMap = new HashMap<>();
		upgradeCostsMap.put(EnergyLevel.BASE, BASE_TO_IMPROVED_UPGRADE_COSTS);
		upgradeCostsMap.put(EnergyLevel.IMPROVED, IMPROVED_TO_NONE_UPGRADE_COSTS);

		// Logging output
		LOGGER.logf(DEBUG, UPGRADE_COST_MAP_SET_PATTERN, upgradeCostsMap.toString());

		return upgradeCostsMap;
	}


	/**
	 * Initializes and returns the map of ability modifiers, which contains all different ability modifiers for the initiative energy ability.
	 * <br>
	 * This map is created once and then stored in the {@link InitiativeAbility#MODIFIERS} field to be able to re-use it when needed.
	 * <br>
	 * This method is invoked in the static initializer of this class.
	 *
	 * @return The map of ability modifiers for the initiative energy ability.
	 *
	 * @precondition The ability modifiers for this ability exist for the different {@link EnergyLevel}.
	 * @postcondition A map of ability modifiers for this ability is initialized.
	 */
	private static Map<EnergyLevel, Map<AbilityMultiplier.Type, Double>> initModifiersMap ()
	{
		// Create and fill the map with modifiers for the BASE energy ability level.
		final Map<AbilityMultiplier.Type, Double> baseLevelModifiers = new HashMap<>();
		baseLevelModifiers.put(AbilityMultiplier.Type.DODGE, DEFAULT_MULTIPLIER);
		baseLevelModifiers.put(AbilityMultiplier.Type.INITIATIVE, HIGH_MULTIPLIER);
		baseLevelModifiers.put(AbilityMultiplier.Type.MELEE, DEFAULT_MULTIPLIER);

		// Create and fill the map with modifiers for the IMPROVED energy ability level.
		final Map<AbilityMultiplier.Type, Double> improvedLevelModifiers = new HashMap<>();
		improvedLevelModifiers.put(AbilityMultiplier.Type.DODGE, DEFAULT_MULTIPLIER);
		improvedLevelModifiers.put(AbilityMultiplier.Type.INITIATIVE, MAXIMUM_MULTIPLIER);
		improvedLevelModifiers.put(AbilityMultiplier.Type.MELEE, DEFAULT_MULTIPLIER);

		// Insert the map of modifiers for the BASE and IMPROVED energy ability level into the map of modifiers which stores
		// all modifier maps for the different energy ability levels.
		final Map<EnergyLevel, Map<AbilityMultiplier.Type, Double>> abilityModifiersMap = new HashMap<>();
		abilityModifiersMap.put(EnergyLevel.BASE, baseLevelModifiers);
		abilityModifiersMap.put(EnergyLevel.IMPROVED, improvedLevelModifiers);

		// Logging output
		LOGGER.logf(DEBUG, MODIFIERS_MAP_SET_PATTERN, abilityModifiersMap.toString());

		return abilityModifiersMap;
	}


	/**
	 * Initializes and returns the map of names, which contains all different names for the initiative energy ability.
	 * <br>
	 * This map is created once and then stored in the {@link InitiativeAbility#NAMES} field to be able to re-use it when needed.
	 * <br>
	 * This method is invoked in the static initializer of this class.
	 *
	 * @return The map of names for the initiative energy ability.
	 *
	 * @precondition The names for this ability exist for the different {@link EnergyLevel}.
	 * @postcondition A map of the names for this ability is initialized.
	 */
	private static Map<EnergyLevel, String> initNamesMap ()
	{
		// Fill the map with the names.
		final Map<EnergyLevel, String> namesMap = new HashMap<>();
		namesMap.put(EnergyLevel.BASE, Initiative.BASE_NAME);
		namesMap.put(EnergyLevel.IMPROVED, Initiative.IMPROVED_NAME);

		// Logging output
		LOGGER.logf(DEBUG, NAME_MAP_SET_PATTERN, namesMap.toString());

		return namesMap;
	}


	/**
	 * Initializes and returns the map of sprites, which contains all different names for the initiative energy ability.
	 * <br>
	 * This map is created once and then stored in the {@link InitiativeAbility#SPRITES} field to be able to re-use it when needed.
	 * <br>
	 * This method is invoked in the static initializer of this class.
	 *
	 * @return The map of sprites for the initiative energy ability.
	 *
	 * @precondition The sprites for this ability exist for the different {@link EnergyLevel}.
	 * @postcondition A map of the sprites for this ability is initialized.
	 */
	private static Map<EnergyLevel, MetaDataImage> initSpritesMap ()
	{
		// Fill the map with the sprites.
		final Map<EnergyLevel, MetaDataImage> spritesMap = new HashMap<>();
		spritesMap.put(EnergyLevel.BASE, ResourceLoader.loadImage(Initiative.BASE_SPRITE_PATH));
		spritesMap.put(EnergyLevel.IMPROVED, ResourceLoader.loadImage(Initiative.IMPROVED_SPRITE_PATH));

		// Logging output
		LOGGER.logf(DEBUG, SPRITE_MAP_SET_PATTERN, spritesMap.toString());

		return spritesMap;
	}


	/**
	 * Returns the singleton instance of this class.
	 *
	 * @return The singleton instance of this class.
	 *
	 * @precondition The singleton Instance exists.
	 * @postcondition The singleton Instance can be accessed in the program.
	 */
	public static InitiativeAbility getInstance ()
	{
		return INSTANCE;
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public @NotNull Map<EnergyLevel, CurrencyTransaction> getAllUpgradeCosts ()
	{
		return UPGRADE_COSTS;
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public @NotNull Map<EnergyLevel, String> getAllNames ()
	{
		return NAMES;
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	@NotNull
	public Map<EnergyLevel, MetaDataImage> getAllSprites ()
	{
		return SPRITES;
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	@NotNull
	public Map<EnergyLevel, Map<AbilityMultiplier.Type, Double>> getAllModifiers ()
	{
		return MODIFIERS;
	}

}