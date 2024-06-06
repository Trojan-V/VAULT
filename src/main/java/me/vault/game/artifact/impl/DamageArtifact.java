package me.vault.game.artifact.impl;


import javafx.scene.image.Image;
import me.vault.game.artifact.AbsArtifact;
import me.vault.game.artifact.ArtifactLevel;
import me.vault.game.artifact.AttributeModifiers.Type;
import me.vault.game.currency.CurrencyTransaction;
import me.vault.game.utility.loading.ResourceLoader;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

import static me.vault.game.utility.constant.GameConstants.ASSETS_PATH;


/**
 * Description
 *
 * @author Vincent Wolf
 * @version 1.0.0
 * @see
 * @since 05.06.2024
 */
public final class DamageArtifact extends AbsArtifact
{
	private static final DamageArtifact INSTANCE;

	private static final Map<ArtifactLevel, String> NAMES = new HashMap<>();
	private static final Map<ArtifactLevel, Image> SPRITES = new HashMap<>();
	private static final Map<ArtifactLevel, Map<Type, Double>> MODIFIERS = new HashMap<>();


	private static final Map<ArtifactLevel, CurrencyTransaction> UPGRADE_COSTS = new HashMap<>();

	static
	{
		UPGRADE_COSTS.put(ArtifactLevel.BASE, new CurrencyTransaction(-10, -10, -10, -10, -10));
		UPGRADE_COSTS.put(ArtifactLevel.IMPROVED, null);

		NAMES.put(ArtifactLevel.BASE, "Damage Artifact");
		NAMES.put(ArtifactLevel.IMPROVED, "Improved Damage Artifact");

		SPRITES.put(ArtifactLevel.BASE, ResourceLoader.loadImage(ASSETS_PATH + "Item_Pack/damage_artifact_icon.png"));
		SPRITES.put(ArtifactLevel.IMPROVED, ResourceLoader.loadImage(
			ASSETS_PATH + "Item_Pack/damage_artifact_icon.png"));

		final Map<Type, Double> baseLevelModifiers = new HashMap<>();
		baseLevelModifiers.put(Type.DAMAGE, 1.5D);
		baseLevelModifiers.put(Type.DEFENSE, 1.5D);
		baseLevelModifiers.put(Type.HEALTH, 1.5D);

		MODIFIERS.put(ArtifactLevel.BASE, baseLevelModifiers);

		final Map<Type, Double> improvedLevelModifiers = new HashMap<>();
		improvedLevelModifiers.put(Type.DAMAGE, 2.0D);
		improvedLevelModifiers.put(Type.DEFENSE, 2.0D);
		improvedLevelModifiers.put(Type.HEALTH, 2.0D);

		MODIFIERS.put(ArtifactLevel.IMPROVED, improvedLevelModifiers);


		// Ensure the instance is created after static fields are initialized
		INSTANCE = new DamageArtifact();
	}

	private DamageArtifact ()
	{
		// Call to superclass constructor
	}


	public static DamageArtifact getInstance ()
	{
		return INSTANCE;
	}


	@Override
	protected @NotNull Map<ArtifactLevel, CurrencyTransaction> getUpgradeCosts ()
	{
		return UPGRADE_COSTS;
	}


	@Override
	protected @NotNull Map<ArtifactLevel, String> getNames ()
	{
		return NAMES;
	}


	@Override
	protected @NotNull Map<ArtifactLevel, Image> getSprites ()
	{
		return SPRITES;
	}


	@Override
	protected @NotNull Map<ArtifactLevel, Map<Type, Double>> getModifiers ()
	{
		return MODIFIERS;
	}
}
