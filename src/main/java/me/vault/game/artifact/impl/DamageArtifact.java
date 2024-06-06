package me.vault.game.artifact.impl;


import javafx.scene.image.Image;
import me.vault.game.artifact.Artifact;
import me.vault.game.artifact.ArtifactLevel;
import me.vault.game.artifact.AttributeModifiers;
import me.vault.game.artifact.AttributeModifiers.Type;
import me.vault.game.currency.CurrencyTransaction;
import me.vault.game.utility.constant.NewLoggingConstants;
import me.vault.game.utility.loading.ResourceLoader;
import me.vault.game.utility.logging.Logger;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

import static me.vault.game.utility.constant.ArtifactConstants.*;
import static me.vault.game.utility.logging.ILogger.Level.DEBUG;


/**
 * This class is an implementation of {@link Artifact}.
 * <br>
 * As this specification is a damage artifact, it mainly provides positive attribute modifiers towards the damage
 * attribute.
 * Other attribute modifiers might be affected as well by the damage attribute, the highest multiplier is for the
 * damage though for obvious reasons.
 *
 * @author Vincent Wolf
 * @version 1.0.0
 * @see Artifact
 * @since 05.06.2024
 */
public final class DamageArtifact extends Artifact
{
	private static final Logger LOGGER = new Logger(DamageArtifact.class.getSimpleName());


	/**
	 * Singleton instance, as there's never a reason to have more than one {@link DamageArtifact}.
	 * Instead of using a singleton, the entire class could've been created using solely static methods and fields.
	 */
	private static final DamageArtifact INSTANCE;


	/**
	 * All possible names of the damage artifact are stored in this map, with the {@link ArtifactLevel} as key to
	 * denote which name corresponds to which {@link ArtifactLevel}.
	 *
	 * @see Map
	 * @see ArtifactLevel
	 */
	private static final Map<ArtifactLevel, String> NAMES = new HashMap<>();


	/**
	 * All possible sprites of the damage artifact are stored in this map, with the {@link ArtifactLevel} as key to
	 * denote which sprite corresponds to which {@link ArtifactLevel}.
	 *
	 * @see Map
	 * @see ArtifactLevel
	 * @see Image
	 */
	private static final Map<ArtifactLevel, Image> SPRITES = new HashMap<>();


	/**
	 * All possible modifier sets of the damage artifact are stored in this map, with the {@link ArtifactLevel} as
	 * key to denote which set of modifiers corresponds to which {@link ArtifactLevel}.
	 *
	 * @see Map
	 * @see ArtifactLevel
	 * @see AttributeModifiers.Type
	 */
	private static final Map<ArtifactLevel, Map<Type, Double>> MODIFIERS = new HashMap<>();


	/**
	 * All possible upgrade cost {@link CurrencyTransaction}'s of the damage artifact are stored in this map, with the
	 * {@link ArtifactLevel} as
	 * key to denote which set of upgrade costs corresponds to which {@link ArtifactLevel}.
	 *
	 * @see Map
	 * @see ArtifactLevel
	 * @see CurrencyTransaction
	 */
	private static final Map<ArtifactLevel, CurrencyTransaction> UPGRADE_COSTS = new HashMap<>();


	static
	{
		LOGGER.logf(DEBUG, NewLoggingConstants.STATIC_INITIALIZER_ENTERED, DamageArtifact.class.getSimpleName());


		// Fill the map with the different upgrade cost transactions.
		UPGRADE_COSTS.put(ArtifactLevel.BASE, Damage.BASE_TO_IMPROVED_UPGRADE_COSTS);
		UPGRADE_COSTS.put(ArtifactLevel.IMPROVED, Damage.IMPROVED_TO_NONE_UPGRADE_COSTS);


		// Fill the map with the names.
		NAMES.put(ArtifactLevel.BASE, Damage.BASE_NAME);
		NAMES.put(ArtifactLevel.IMPROVED, Damage.IMPROVED_NAME);


		// Fill the map with the sprites.
		SPRITES.put(ArtifactLevel.BASE, ResourceLoader.loadImage(Damage.BASE_SPRITE_PATH));
		SPRITES.put(ArtifactLevel.IMPROVED, ResourceLoader.loadImage(Damage.IMPROVED_SPRITE_PATH));


		// Create and fill the map with modifiers for the BASE artifact level.
		final Map<Type, Double> baseLevelModifiers = new HashMap<>();
		baseLevelModifiers.put(Type.DAMAGE, MULTIPLIER_HIGH);
		baseLevelModifiers.put(Type.DEFENSE, MULTIPLIER_MINIMUM);
		baseLevelModifiers.put(Type.HEALTH, MULTIPLIER_DEFAULT);


		// Insert the map of modifiers for the BASE artifact level into the map of modifiers which stores all modifier
		// maps for the different artifact levels.
		MODIFIERS.put(ArtifactLevel.BASE, baseLevelModifiers);


		// Create and fill the map with modifiers for the IMPROVED artifact level.
		final Map<Type, Double> improvedLevelModifiers = new HashMap<>();
		improvedLevelModifiers.put(Type.DAMAGE, MULTIPLIER_MAXIMUM);
		improvedLevelModifiers.put(Type.DEFENSE, MULTIPLIER_LOW);
		improvedLevelModifiers.put(Type.HEALTH, MULTIPLIER_DEFAULT);


		// Insert the map of modifiers for the IMPROVED artifact level into the map of modifiers which stores all
		// modifier maps for the different artifact levels.
		MODIFIERS.put(ArtifactLevel.IMPROVED, improvedLevelModifiers);


		// Ensure the instance is created after the static fields are initialized. For more reasoning, check the
		// Javadoc of the Artifact class.
		INSTANCE = new DamageArtifact();


		LOGGER.logf(DEBUG, NewLoggingConstants.STATIC_INITIALIZER_LEFT, DamageArtifact.class.getSimpleName());
	}


	/**
	 * As this class is a singleton, no other class should be able to instantiate it,
	 * hence why a private constructor is used here to prohibit that.
	 */
	private DamageArtifact () {}


	/**
	 * Returns the singleton instance of this class.
	 *
	 * @return The singleton instance of this class.
	 */
	public static DamageArtifact getInstance ()
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
	protected @NotNull Map<ArtifactLevel, Image> getAllSprites ()
	{
		return SPRITES;
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	protected @NotNull Map<ArtifactLevel, Map<Type, Double>> getAllModifiers ()
	{
		return MODIFIERS;
	}
}
