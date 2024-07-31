package me.vault.game.model.artifact.implementation;


import me.vault.game.model.artifact.Artifact;
import me.vault.game.model.artifact.ArtifactLevel;
import me.vault.game.model.artifact.AttributeMultiplier;
import me.vault.game.model.currency.CurrencyTransaction;
import me.vault.game.utility.datatypes.MetaDataImage;
import me.vault.game.utility.loading.ResourceLoader;
import me.vault.game.utility.logging.ILogger;
import me.vault.game.utility.logging.Logger;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

import static me.vault.game.utility.interfaces.constant.ArtifactConstants.*;
import static me.vault.game.utility.interfaces.constant.ArtifactConstants.Defense.BASE_TO_IMPROVED_UPGRADE_COSTS;
import static me.vault.game.utility.interfaces.constant.ArtifactConstants.Defense.IMPROVED_TO_NONE_UPGRADE_COSTS;
import static me.vault.game.utility.interfaces.constant.LoggingConstants.Artifact.*;
import static me.vault.game.utility.logging.ILogger.Level.DEBUG;
import static me.vault.game.utility.logging.ILogger.Level.NORMAL;


/**
 * This class is an implementation of {@link Artifact}.
 * <br>
 * As this specification is a defense artifact, it mainly provides positive attribute modifiers towards the defense attribute.
 * Other attribute modifiers might be affected as well by the defense artifact, the highest multiplier is for the defense though
 * for obvious reasons.
 *
 * @author Vincent Wolf, Lasse-Leander Hillen, Timothy Hoegen-Jupp, Alexander Goethel
 * @version 1.0.0
 * @see Artifact
 * @since 05.06.2024
 */
public final class DefenseArtifact extends Artifact
{

	/**
	 * The {@link Logger} object for this class used for writing to the console.
	 */
	private static final ILogger LOGGER = new Logger(DefenseArtifact.class.getSimpleName());

	/**
	 * Singleton instance, as there's never a reason to have more than one {@link DefenseArtifact}. Instead of using a singleton,
	 * the entire class could've been created using solely static methods and fields.
	 */
	private static final DefenseArtifact INSTANCE;

	/**
	 * All possible names of the defense artifact are stored in this map, with the {@link ArtifactLevel} as key to denote which
	 * name corresponds to which {@link ArtifactLevel}.
	 */
	private static final Map<ArtifactLevel, String> NAMES;

	/**
	 * All possible sprites of the defense artifact are stored in this map, with the {@link ArtifactLevel} as key to denote which
	 * sprite corresponds to which {@link ArtifactLevel}.
	 */
	private static final Map<ArtifactLevel, MetaDataImage> SPRITES;

	/**
	 * All possible modifier sets of the defense artifact are stored in this map, with the {@link ArtifactLevel} as key to denote
	 * which set of modifiers corresponds to which {@link ArtifactLevel}.
	 */
	private static final Map<ArtifactLevel, Map<AttributeMultiplier.Type, Double>> MODIFIERS;

	/**
	 * All possible upgrade cost {@link CurrencyTransaction}'s of the defense artifact are stored in this map, with the
	 * {@link ArtifactLevel} as key to denote which set of upgrade costs corresponds to which {@link ArtifactLevel}.
	 */
	private static final Map<ArtifactLevel, CurrencyTransaction> UPGRADE_COSTS;


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

		// Create the singleton instance at last, so all maps are filled with values as the data in these maps is required to create an instance of this class.
		INSTANCE = new DefenseArtifact();
	}


	/**
	 * As this class is a singleton, no other class should be able to instantiate it, hence why a private constructor is used here to prohibit that.
	 * @precondition Constructor gets called from within the class.
	 * @postcondition A new instance of DefenceArtifact is created.
	 */
	private DefenseArtifact () {}


	/**
	 * Initializes and returns the map of upgrade costs, which contains all different upgrade costs for the defense artifact.
	 * <br>
	 * This map is created once and then stored in the {@link DefenseArtifact#UPGRADE_COSTS} field to be able to re-use it when needed.
	 * <br>
	 * This method is invoked in the static initializer of this class.
	 *
	 * @return The map of upgrade costs for the defense artifact.
	 *
	 * @precondition The upgrade costs for different {@link ArtifactLevel} exists.
	 * @postcondition A map of upgrade costs for this artifact is initialized.
	 */
	private static Map<ArtifactLevel, CurrencyTransaction> initUpgradeCostsMap ()
	{
		// Fill the map with the different upgrade cost transactions.
		final Map<ArtifactLevel, CurrencyTransaction> upgradeCostsMap = new HashMap<>();
		upgradeCostsMap.put(ArtifactLevel.BASE, BASE_TO_IMPROVED_UPGRADE_COSTS);
		upgradeCostsMap.put(ArtifactLevel.IMPROVED, IMPROVED_TO_NONE_UPGRADE_COSTS);

		// Logging output
		LOGGER.logf(DEBUG, UPGRADE_COST_MAP_SET_PATTERN, upgradeCostsMap.toString());

		return upgradeCostsMap;
	}


	/**
	 * Initializes and returns the map of attribute modifiers, which contains all different attribute modifiers for the defense artifact.
	 * <br>
	 * This map is created once and then stored in the {@link DefenseArtifact#MODIFIERS} field to be able to re-use it when needed.
	 * <br>
	 * This method is invoked in the static initializer of this class.
	 *
	 * @return The map of attribute modifiers for the defense artifact.
	 *
	 * @precondition The attribute modifiers for this artifact exist for the different {@link ArtifactLevel}.
	 * @postcondition A map of attribute modifiers for this artifact is initialized.
	 */
	private static Map<ArtifactLevel, Map<AttributeMultiplier.Type, Double>> initModifiersMap ()
	{
		// Create and fill the map with modifiers for the BASE artifact level.
		final Map<AttributeMultiplier.Type, Double> baseLevelModifiers = new HashMap<>();
		baseLevelModifiers.put(AttributeMultiplier.Type.DAMAGE, MULTIPLIER_MINIMUM);
		baseLevelModifiers.put(AttributeMultiplier.Type.DEFENSE, MULTIPLIER_HIGH);
		baseLevelModifiers.put(AttributeMultiplier.Type.HEALTH, MULTIPLIER_DEFAULT);

		// Create and fill the map with modifiers for the IMPROVED artifact level.
		final Map<AttributeMultiplier.Type, Double> improvedLevelModifiers = new HashMap<>();
		improvedLevelModifiers.put(AttributeMultiplier.Type.DAMAGE, MULTIPLIER_LOW);
		improvedLevelModifiers.put(AttributeMultiplier.Type.DEFENSE, MULTIPLIER_MAXIMUM);
		improvedLevelModifiers.put(AttributeMultiplier.Type.HEALTH, MULTIPLIER_DEFAULT);

		// Insert the map of modifiers for the BASE and IMPROVED artifact level into the map of modifiers which stores
		// all modifier maps for the different artifact levels.
		final Map<ArtifactLevel, Map<AttributeMultiplier.Type, Double>> attributeModifiersMap = new HashMap<>();
		attributeModifiersMap.put(ArtifactLevel.BASE, baseLevelModifiers);
		attributeModifiersMap.put(ArtifactLevel.IMPROVED, improvedLevelModifiers);

		// Logging output
		LOGGER.logf(NORMAL, MODIFIERS_MAP_SET_PATTERN, attributeModifiersMap.toString());

		return attributeModifiersMap;
	}


	/**
	 * Initializes and returns the map of names, which contains all different names for the defense artifact.
	 * <br>
	 * This map is created once and then stored in the {@link DefenseArtifact#NAMES} field to be able to re-use it when needed.
	 * <br>
	 * This method is invoked in the static initializer of this class.
	 *
	 * @return The map of names for the defense artifact.
	 *
	 * @precondition The names for this artifact exist for the different {@link ArtifactLevel}.
	 * @postcondition A map of the names for this artifact is initialized.
	 */
	private static Map<ArtifactLevel, String> initNamesMap ()
	{
		// Fill the map with the names.
		final Map<ArtifactLevel, String> namesMap = new HashMap<>();
		namesMap.put(ArtifactLevel.BASE, Defense.BASE_NAME);
		namesMap.put(ArtifactLevel.IMPROVED, Defense.IMPROVED_NAME);

		// Logging output
		LOGGER.logf(DEBUG, NAME_MAP_SET_PATTERN, namesMap.toString());

		return namesMap;
	}


	/**
	 * Initializes and returns the map of sprites, which contains all different names for the defense artifact.
	 * <br>
	 * This map is created once and then stored in the {@link DefenseArtifact#SPRITES} field to be able to re-use it when needed.
	 * <br>
	 * This method is invoked in the static initializer of this class.
	 *
	 * @return The map of sprites for the defense artifact.
	 *
	 * @precondition The sprites for this artifact exist for the different {@link ArtifactLevel}.
	 * @postcondition A map of the sprites for this artifact is initialized.
	 */
	private static Map<ArtifactLevel, MetaDataImage> initSpritesMap ()
	{
		// Fill the map with the sprites.
		final Map<ArtifactLevel, MetaDataImage> spritesMap = new HashMap<>();
		spritesMap.put(ArtifactLevel.BASE, ResourceLoader.loadImage(Defense.BASE_SPRITE_PATH));
		spritesMap.put(ArtifactLevel.IMPROVED, ResourceLoader.loadImage(Defense.IMPROVED_SPRITE_PATH));

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
	public static DefenseArtifact getInstance ()
	{
		return INSTANCE;
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	@NotNull
	public Map<ArtifactLevel, CurrencyTransaction> getAllUpgradeCosts ()
	{
		return UPGRADE_COSTS;
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	@NotNull
	public Map<ArtifactLevel, String> getAllNames ()
	{
		return NAMES;
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	@NotNull
	public Map<ArtifactLevel, MetaDataImage> getAllSprites ()
	{
		return SPRITES;
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	@NotNull
	public Map<ArtifactLevel, Map<AttributeMultiplier.Type, Double>> getAllModifiers ()
	{
		return MODIFIERS;
	}

}
