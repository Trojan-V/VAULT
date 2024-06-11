package me.vault.game.model.artifact.impl;

import javafx.scene.image.Image;
import me.vault.game.model.artifact.Artifact;
import me.vault.game.model.artifact.ArtifactLevel;
import me.vault.game.model.artifact.AttributeMultiplier;
import me.vault.game.model.currency.CurrencyTransaction;
import me.vault.game.utility.loading.ResourceLoader;
import me.vault.game.utility.logging.ILogger;
import me.vault.game.utility.logging.Logger;
import me.vault.game.utility.struct.MetaDataImage;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

import static me.vault.game.utility.constant.ArtifactConstants.*;
import static me.vault.game.utility.constant.NewLoggingConstants.Artifact.*;
import static me.vault.game.utility.logging.ILogger.Level.DEBUG;

/**
 * This class is an implementation of {@link Artifact}.
 * <br>
 * As this specification is a health artifact, it mainly provides positive attribute modifiers towards the health attribute. Other attribute modifiers
 * might be affected as well by the health artifact, the highest multiplier is for the health though for obvious reasons.
 *
 * @author Vincent Wolf, Lasse-Leander Hillen
 * @version 1.0.0
 * @see Artifact
 * @since 05.06.2024
 */
public final class HealthArtifact extends Artifact
{
	/**
	 * The logger object for this class used for writing to the console.
	 *
	 * @see Logger
	 */
	private static final ILogger LOGGER = new Logger(HealthArtifact.class.getSimpleName());

	/**
	 * Singleton instance, as there's never a reason to have more than one {@link HealthArtifact}. Instead of using a singleton, the entire class
	 * could've been created using solely static methods and fields.
	 */
	private static final HealthArtifact INSTANCE;

	/**
	 * All possible names of the health artifact are stored in this map, with the {@link HealthArtifact} as key to denote which name corresponds to
	 * which {@link HealthArtifact}.
	 *
	 * @see Map
	 * @see ArtifactLevel
	 */
	private static final Map<ArtifactLevel, String> NAMES;

	/**
	 * All possible sprites of the health artifact are stored in this map, with the {@link ArtifactLevel} as key to denote which sprite corresponds to
	 * which {@link ArtifactLevel}.
	 *
	 * @see Map
	 * @see ArtifactLevel
	 * @see Image
	 */
	private static final Map<ArtifactLevel, MetaDataImage> SPRITES;

	/**
	 * All possible modifier sets of the health artifact are stored in this map, with the {@link ArtifactLevel} as key to denote which set of
	 * modifiers corresponds to which {@link ArtifactLevel}.
	 *
	 * @see Map
	 * @see ArtifactLevel
	 * @see AttributeMultiplier.Type
	 */
	private static final Map<ArtifactLevel, Map<AttributeMultiplier.Type, Double>> MODIFIERS;

	/**
	 * All possible upgrade cost {@link CurrencyTransaction}'s of the health artifact are stored in this map, with the {@link ArtifactLevel} as key to
	 * denote which set of upgrade costs corresponds to which {@link ArtifactLevel}.
	 *
	 * @see Map
	 * @see ArtifactLevel
	 * @see CurrencyTransaction
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

		// Ensure the instance is created after all the other static fields are initialized.
		INSTANCE = new HealthArtifact();
	}

	/**
	 * As this class is a singleton, no other class should be able to instantiate it, hence why a private constructor is used here to prohibit that.
	 */
	private HealthArtifact () {}


	/**
	 * Initializes and returns the map of upgrade costs, which contains all different upgrade costs for the health artifact.
	 * <br>
	 * This map is created once and then stored in the {@link HealthArtifact#UPGRADE_COSTS} field to be able to re-use it when needed.
	 * <br>
	 * This method is invoked in the static initializer of this class.
	 *
	 * @return The map of upgrade costs for the health artifact.
	 * @see Map
	 * @see ArtifactLevel
	 * @see CurrencyTransaction
	 */
	private static Map<ArtifactLevel, CurrencyTransaction> initUpgradeCostsMap ()
	{
		// Fill the map with the different upgrade cost transactions.
		final Map<ArtifactLevel, CurrencyTransaction> upgradeCostsMap = new HashMap<>();
		upgradeCostsMap.put(ArtifactLevel.BASE, Health.BASE_TO_IMPROVED_UPGRADE_COSTS);
		upgradeCostsMap.put(ArtifactLevel.IMPROVED, Health.IMPROVED_TO_NONE_UPGRADE_COSTS);

		// Logging output
		LOGGER.logf(DEBUG, UPGRADE_COST_MAP_SET, upgradeCostsMap.toString());

		return upgradeCostsMap;
	}


	/**
	 * Initializes and returns the map of attribute modifiers, which contains all different attribute modifiers for the health artifact.
	 * <br>
	 * This map is created once and then stored in the {@link HealthArtifact#MODIFIERS} field to be able to re-use it when needed.
	 * <br>
	 * This method is invoked in the static initializer of this class.
	 *
	 * @return The map of attribute modifiers for the health artifact.
	 * @see Map
	 * @see ArtifactLevel
	 * @see AttributeMultiplier.Type
	 */
	private static Map<ArtifactLevel, Map<AttributeMultiplier.Type, Double>> initModifiersMap ()
	{
		// Create and fill the map with modifiers for the BASE artifact level.
		final Map<AttributeMultiplier.Type, Double> baseLevelModifiers = new HashMap<>();
		baseLevelModifiers.put(AttributeMultiplier.Type.DAMAGE, MULTIPLIER_MINIMUM);
		baseLevelModifiers.put(AttributeMultiplier.Type.DEFENSE, MULTIPLIER_DEFAULT);
		baseLevelModifiers.put(AttributeMultiplier.Type.HEALTH, MULTIPLIER_HIGH);

		// Create and fill the map with modifiers for the IMPROVED artifact level.
		final Map<AttributeMultiplier.Type, Double> improvedLevelModifiers = new HashMap<>();
		improvedLevelModifiers.put(AttributeMultiplier.Type.DAMAGE, MULTIPLIER_LOW);
		improvedLevelModifiers.put(AttributeMultiplier.Type.DEFENSE, MULTIPLIER_HIGH);
		improvedLevelModifiers.put(AttributeMultiplier.Type.HEALTH, MULTIPLIER_MAXIMUM);

		// Insert the map of modifiers for the BASE and IMPROVED artifact level into the map of modifiers which stores
		// all modifier maps for the different artifact levels.
		final Map<ArtifactLevel, Map<AttributeMultiplier.Type, Double>> attributeModifiersMap = new HashMap<>();
		attributeModifiersMap.put(ArtifactLevel.BASE, baseLevelModifiers);
		attributeModifiersMap.put(ArtifactLevel.IMPROVED, improvedLevelModifiers);

		// Logging output
		LOGGER.logf(DEBUG, MODIFIERS_MAP_SET, attributeModifiersMap.toString());

		return attributeModifiersMap;
	}


	/**
	 * Initializes and returns the map of names, which contains all different names for the damage artifact.
	 * <br>
	 * This map is created once and then stored in the {@link HealthArtifact#NAMES} field to be able to re-use it when needed.
	 * <br>
	 * This method is invoked in the static initializer of this class.
	 *
	 * @return The map of names for the health artifact.
	 * @see Map
	 * @see ArtifactLevel
	 */
	private static Map<ArtifactLevel, String> initNamesMap ()
	{
		// Fill the map with the names.
		final Map<ArtifactLevel, String> namesMap = new HashMap<>();
		namesMap.put(ArtifactLevel.BASE, Health.BASE_NAME);
		namesMap.put(ArtifactLevel.IMPROVED, Health.IMPROVED_NAME);

		// Logging output
		LOGGER.logf(DEBUG, NAME_MAP_SET, namesMap.toString());

		return namesMap;
	}


	/**
	 * Initializes and returns the map of sprites, which contains all different names for the health artifact.
	 * <br>
	 * This map is created once and then stored in the {@link HealthArtifact#SPRITES} field to be able to re-use it when needed.
	 * <br>
	 * This method is invoked in the static initializer of this class.
	 *
	 * @return The map of sprites for the health artifact.
	 * @see Map
	 * @see ArtifactLevel
	 */
	private static Map<ArtifactLevel, MetaDataImage> initSpritesMap ()
	{
		// Fill the map with the sprites.
		final Map<ArtifactLevel, MetaDataImage> spritesMap = new HashMap<>();
		spritesMap.put(ArtifactLevel.BASE, ResourceLoader.loadImage(Health.BASE_SPRITE_PATH));
		spritesMap.put(ArtifactLevel.IMPROVED, ResourceLoader.loadImage(Health.IMPROVED_SPRITE_PATH));

		// Logging output
		LOGGER.logf(DEBUG, SPRITE_MAP_SET, spritesMap.toString());

		return spritesMap;
	}


	/**
	 * Returns the singleton instance of this class.
	 *
	 * @return The singleton instance of this class.
	 */
	public static HealthArtifact getInstance ()
	{
		return INSTANCE;
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	protected @NotNull Map<ArtifactLevel, CurrencyTransaction> getAllUpgradeCosts ()
	{
		return UPGRADE_COSTS;
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	protected @NotNull Map<ArtifactLevel, String> getAllNames ()
	{
		return NAMES;
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	protected @NotNull Map<ArtifactLevel, MetaDataImage> getAllSprites ()
	{
		return SPRITES;
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	protected @NotNull Map<ArtifactLevel, Map<AttributeMultiplier.Type, Double>> getAllModifiers ()
	{
		return MODIFIERS;
	}

}
