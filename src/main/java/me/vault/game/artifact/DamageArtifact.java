package me.vault.game.artifact;


import javafx.scene.image.Image;
import me.vault.game.artifact.AttributeModifiers.Type;
import me.vault.game.currency.CurrencyController;
import me.vault.game.currency.CurrencyTransaction;
import me.vault.game.utility.loading.ResourceLoader;

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
public class DamageArtifact extends AbsArtifact
{
	private static final DamageArtifact INSTANCE = new DamageArtifact();


	private static final Map<ArtifactLevel, CurrencyTransaction> UPGRADE_COSTS = new HashMap<>();


	private static final Map<ArtifactLevel, String> NAMES = new HashMap<>();


	private static final Map<ArtifactLevel, Image> SPRITES = new HashMap<>();


	private static final Map<ArtifactLevel, Map<Type, Double>> MODIFIERS = new HashMap<>();
	static
	{
		UPGRADE_COSTS.put(ArtifactLevel.BASE, CurrencyController.createTransaction(-10, -10, -10, -10, -10));
		UPGRADE_COSTS.put(ArtifactLevel.IMPROVED, null);

		NAMES.put(ArtifactLevel.BASE, "Damage Artifact");
		NAMES.put(ArtifactLevel.BASE, "Improved Damage Artifact");

		SPRITES.put(ArtifactLevel.BASE, ResourceLoader.loadImage(ASSETS_PATH + "Item_Pack/damage_artifact_icon.png"));

		final HashMap<Type, Double> baseLevelModifiers = new HashMap<>();
		baseLevelModifiers.put(Type.DAMAGE, 1.5D);
		baseLevelModifiers.put(Type.DEFENSE, 1.5D);
		baseLevelModifiers.put(Type.HEALTH, 1.5D);

		MODIFIERS.put(ArtifactLevel.BASE, baseLevelModifiers);

		final HashMap<Type, Double> improvedLevelModifiers = new HashMap<>();
		improvedLevelModifiers.put(Type.DAMAGE, 2.0D);
		improvedLevelModifiers.put(Type.DEFENSE, 2.0D);
		improvedLevelModifiers.put(Type.HEALTH, 2.0D);

		MODIFIERS.put(ArtifactLevel.IMPROVED, improvedLevelModifiers);
	}


	private DamageArtifact ()
	{}


	public static DamageArtifact getInstance ()
	{
		return INSTANCE;
	}


	@Override
	protected Map<ArtifactLevel, CurrencyTransaction> getUpgradeCostMap ()
	{
		return UPGRADE_COSTS;
	}


	@Override
	protected Map<ArtifactLevel, Map<Type, Double>> getAttributeModifiersMap ()
	{
		return MODIFIERS;
	}


	@Override
	protected Map<ArtifactLevel, String> getNameMap ()
	{
		return NAMES;
	}


	@Override
	protected Map<ArtifactLevel, Image> getSpriteMap ()
	{
		return SPRITES;
	}
}
