package me.vault.game.model.artifact.implementation;


import javafx.scene.image.Image;
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

import static me.vault.game.utility.interfaces.constant.ArtifactConstants.Damage.*;
import static me.vault.game.utility.interfaces.constant.ArtifactConstants.*;
import static me.vault.game.utility.interfaces.constant.LoggingConstants.Artifact.*;
import static me.vault.game.utility.logging.ILogger.Level.DEBUG;


/**
 * This class is an implementation of {@link Artifact}.
 * <br>
 * As this specification is a damage artifact, it mainly provides positive attribute modifiers towards the damage attribute.
 * Other attribute modifiers might be affected as well by the damage artifact, the highest multiplier is for the damage though
 * for obvious reasons.
 *
 * @author Vincent Wolf, Lasse-Leander Hillen, Timothy Hoegen-Jupp, Alexander Goethel
 * @version 1.0.0
 * @see Artifact
 * @since 05.06.2024
 */
public final class DamageArtifact extends Artifact
{

	/**
	 * The {@link Logger} object for this class used for writing to the console.
	 */
	private static final ILogger LOGGER = new Logger(DamageArtifact.class.getSimpleName());

	/**
	 * Singleton instance, as there's never a reason to have more than one {@link DamageArtifact}. Instead of using a singleton,
	 * the entire class could've been created using solely static methods and fields.
	 */
	private static final DamageArtifact INSTANCE;

	/**
	 * All possible names of the damage artifact are stored in this {@link Map}, with the {@link ArtifactLevel} as key to denote
	 * which name corresponds to which {@link ArtifactLevel}.
	 */
	private static final Map<ArtifactLevel, String> NAMES;

	/**
	 * All possible sprites ({@link Image}) of the damage artifact are stored in this {@link Map}, with the {@link ArtifactLevel}
	 * as key to denote which sprite corresponds to which {@link ArtifactLevel}.
	 */
	private static final Map<ArtifactLevel, MetaDataImage> SPRITES;

	/**
	 * All possible modifier sets of the damage artifact are stored in this {@link Map}, with the {@link ArtifactLevel} as key
	 * to denote which set of modifiers corresponds to which {@link ArtifactLevel}.
	 */
	private static final Map<ArtifactLevel, Map<AttributeMultiplier.Type, Double>> MODIFIERS;

	/**
	 * All possible upgrade cost {@link CurrencyTransaction}'s of the damage artifact are stored in this {@link Map}, with the
	 * {@link ArtifactLevel} as key to denote which set of upgrade costs corresponds to which {@link ArtifactLevel}.
	 */
	private static final Map<ArtifactLevel, CurrencyTransaction> UPGRADE_COSTS;


	static
	{
		/*
		    To ensure that the static fields are initialized in the correct order, a static initializer is used
		    instead of a direct initialization behind the declaration.
		 */

		// Fill the maps with the corresponding data.
		NAMES = initNamesMap();
		SPRITES = initSpritesMap();
		MODIFIERS = initModifiersMap();
		UPGRADE_COSTS = initUpgradeCostsMap();

		/*
		    Create the singleton instance at last, so all maps are filled with values as the data in these maps is required to
		    create an instance of this class.
		*/
		INSTANCE = new DamageArtifact();
	}


	/**
	 * As this class is a singleton, no other class should be able to instantiate it, hence why a private constructor is used
	 * here to prohibit that.
	 *
	 * @precondition Constructor gets called from within the class.
	 * @postcondition A new instance of DamageArtifact is created.
	 */
	private DamageArtifact () {}


	/**
	 * Initializes and returns the map of upgrade costs, which contains all different upgrade costs for the damage artifact.
	 * <br>
	 * This map is created once and then stored in the {@link DamageArtifact#UPGRADE_COSTS} field to be able to re-use it when
	 * needed.
	 * <br>
	 * This method is invoked in the static initializer of this class.
	 *
	 * @return The map of upgrade costs for the damage artifact.
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
	 * Initializes and returns the map of attribute modifiers, which contains all different attribute modifiers for the
	 * damage artifact.
	 * <br>
	 * This map is created once and then stored in the {@link DamageArtifact#MODIFIERS} field to be able to re-use it
	 * when needed.
	 * <br>
	 * This method is invoked in the static initializer of this class.
	 *
	 * @return The map of attribute modifiers for the damage artifact.
	 *
	 * @precondition The attribute modifiers for this artifact exist for the different {@link ArtifactLevel}.
	 * @postcondition A map of attribute modifiers for this artifact is initialized.
	 */
	private static Map<ArtifactLevel, Map<AttributeMultiplier.Type, Double>> initModifiersMap ()
	{
		// Create and fill the map with modifiers for the base artifact level.
		final Map<AttributeMultiplier.Type, Double> baseLevelModifiers = new HashMap<>();
		baseLevelModifiers.put(AttributeMultiplier.Type.DAMAGE, MULTIPLIER_HIGH);
		baseLevelModifiers.put(AttributeMultiplier.Type.DEFENSE, MULTIPLIER_MINIMUM);
		baseLevelModifiers.put(AttributeMultiplier.Type.HEALTH, MULTIPLIER_DEFAULT);

		// Create and fill the map with modifiers for the improved artifact level.
		final Map<AttributeMultiplier.Type, Double> improvedLevelModifiers = new HashMap<>();
		improvedLevelModifiers.put(AttributeMultiplier.Type.DAMAGE, MULTIPLIER_MAXIMUM);
		improvedLevelModifiers.put(AttributeMultiplier.Type.DEFENSE, MULTIPLIER_LOW);
		improvedLevelModifiers.put(AttributeMultiplier.Type.HEALTH, MULTIPLIER_DEFAULT);

		// Insert the map of modifiers for the base and improved artifact level into the map of modifiers which stores
		// all modifier maps for the different artifact levels.
		final Map<ArtifactLevel, Map<AttributeMultiplier.Type, Double>> attributeModifiersMap = new HashMap<>();
		attributeModifiersMap.put(ArtifactLevel.BASE, baseLevelModifiers);
		attributeModifiersMap.put(ArtifactLevel.IMPROVED, improvedLevelModifiers);

		// Logging output
		LOGGER.logf(DEBUG, MODIFIERS_MAP_SET_PATTERN, attributeModifiersMap.toString());

		return attributeModifiersMap;
	}


	/**
	 * Initializes and returns the map of names, which contains all different names for the damage artifact.
	 * <br>
	 * This map is created once and then stored in the {@link DamageArtifact#NAMES} field to be able to re-use it
	 * when needed.
	 * <br>
	 * This method is invoked in the static initializer of this class.
	 *
	 * @return The map of names for the damage artifact.
	 *
	 * @precondition The names for this artifact exist for the different {@link ArtifactLevel}.
	 * @postcondition A map of the names for this artifact is initialized.
	 */
	private static Map<ArtifactLevel, String> initNamesMap ()
	{
		// Fill the map with the names.
		final Map<ArtifactLevel, String> namesMap = new HashMap<>();
		namesMap.put(ArtifactLevel.BASE, BASE_NAME);
		namesMap.put(ArtifactLevel.IMPROVED, IMPROVED_NAME);

		// Logging output
		LOGGER.logf(DEBUG, NAME_MAP_SET_PATTERN, namesMap.toString());

		return namesMap;
	}


	/**
	 * Initializes and returns the map of sprites, which contains all different names for the damage artifact.
	 * <br>
	 * This map is created once and then stored in the {@link DamageArtifact#SPRITES} field to be able to re-use
	 * it when needed.
	 * <br>
	 * This method is invoked in the static initializer of this class.
	 *
	 * @return The map of sprites for the damage artifact.
	 *
	 * @precondition The sprites for this artifact exist for the different {@link ArtifactLevel}.
	 * @postcondition A map of the sprites for this artifact is initialized.
	 */
	private static Map<ArtifactLevel, MetaDataImage> initSpritesMap ()
	{
		// Fill the map with the sprites.
		final Map<ArtifactLevel, MetaDataImage> spritesMap = new HashMap<>();
		spritesMap.put(ArtifactLevel.BASE, ResourceLoader.loadImage(BASE_SPRITE_PATH));
		spritesMap.put(ArtifactLevel.IMPROVED, ResourceLoader.loadImage(IMPROVED_SPRITE_PATH));

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
	public static DamageArtifact getInstance ()
	{
		return INSTANCE;
	}


	/**
	 * Returns all upgrade cost {@link CurrencyTransaction}'s which are used to determine whether the player can or
	 * can't upgrade the artifact
	 * depending on the number of currencies he owns.
	 * <br>
	 * These {@link CurrencyTransaction}'s are sorted by the {@link ArtifactLevel} as key within this {@link Map},
	 * allowing for easy access by using
	 * this meaningful key ({@link ArtifactLevel}).
	 *
	 * @return The {@link Map} which contains all upgrade cost transactions for the artifact.
	 *
	 * @precondition The {@link Map} which contains all upgrade cost transactions for the artifact exists.
	 * @postcondition A {@link Map} which contains all upgrade cost transactions for the artifact is accessible for the program.
	 */
	@Override
	@NotNull
	public Map<ArtifactLevel, CurrencyTransaction> getAllUpgradeCosts ()
	{
		return UPGRADE_COSTS;
	}


	/**
	 * Returns all names the artifact can have. An artifact has different names depending on its level.
	 * <br>
	 * Therefore, these names are sorted by the {@link ArtifactLevel} as key in a {@link Map}, allowing for easy
	 * access by using this meaningful key
	 * ({@link ArtifactLevel}).
	 *
	 * @return The {@link Map} which contains all names for the artifact.
	 *
	 * @precondition The {@link Map} which contains all names for the artifact exists.
	 * @postcondition A {@link Map} which contains all names for the artifact is accessible for the program.
	 */
	@Override
	@NotNull
	public Map<ArtifactLevel, String> getAllNames ()
	{
		return NAMES;
	}


	/**
	 * Returns all sprites the artifact can have. An artifact can have, but doesn't always have, different sprites
	 * depending on its level.
	 * <br>
	 * Therefore, these sprites are sorted by the {@link ArtifactLevel} as key in a {@link Map}, allowing for easy
	 * access by using this meaningful key
	 * ({@link ArtifactLevel}).
	 *
	 * @return The {@link Map} which contains all sprites for the artifact.
	 *
	 * @precondition The {@link Map} which contains all sprites for the artifact exists.
	 * @postcondition A {@link Map} which contains all sprites for the artifact is accessible for the program.
	 */
	@Override
	@NotNull
	public Map<ArtifactLevel, MetaDataImage> getAllSprites ()
	{
		return SPRITES;
	}


	/**
	 * Returns all sets of modifiers the artifact can have, depending on it's level.
	 * <br>
	 * Therefore, these sets of modifiers are sorted by the {@link ArtifactLevel} as key in a {@link Map}, allowing
	 * for easy access by using this
	 * meaningful key ({@link ArtifactLevel}).
	 *
	 * @return The {@link Map} which contains all different sets of modifiers the artifact can have, depending on it's
	 * level.
	 *
	 * @precondition The {@link Map} which contains all modifiers for the artifact exists.
	 * @postcondition A {@link Map} which contains all modifiers for the artifact is accessible for the program.
	 */
	@Override
	@NotNull
	public Map<ArtifactLevel, Map<AttributeMultiplier.Type, Double>> getAllModifiers ()
	{
		return MODIFIERS;
	}

}
