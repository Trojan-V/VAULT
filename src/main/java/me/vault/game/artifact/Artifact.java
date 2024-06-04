package me.vault.game.artifact;

import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.image.Image;
import me.vault.game.currency.CurrencyController;
import me.vault.game.interfaces.IUpgradable;
import me.vault.game.utility.loading.ResourceLoader;
import me.vault.game.utility.struct.ValidatedEntriesHashMap;

import static me.vault.game.utility.constant.GameConstants.ASSETS_PATH;

public enum Artifact implements IUpgradable<ArtifactLevel, ArtifactProperties>
{
	/**
	 * The damage-artifact with its specified properties
	 */
	DAMAGE(new ValidatedEntriesHashMap<>()
	{{
		this.put(ArtifactLevel.BASE, new ArtifactProperties("Damage Artifact",
			new SimpleObjectProperty<Image>(ResourceLoader.loadImage(ASSETS_PATH + "Item_Pack/damage_artifact_icon.png")),
				CurrencyController.createTransaction(-10, -10, -10, -10, -10)));

		this.put(ArtifactLevel.SUPER, new ArtifactProperties("Super Damage Artifact",
			new SimpleObjectProperty<Image>(ResourceLoader.loadImage(ASSETS_PATH + "Item_Pack/damage_artifact_icon.png")),
				CurrencyController.createTransaction(-10, -10, -10, -10, -10)));
	}}),


	/**
	 * The defense-artifact with its specified properties
	 */
	DEFENSE(new ValidatedEntriesHashMap<>()
	{{
		this.put(ArtifactLevel.BASE, new ArtifactProperties("Defense Artifact",
			new SimpleObjectProperty<Image>(ResourceLoader.loadImage(ASSETS_PATH + "Item_Pack/defense_artifact_icon.png")),
				CurrencyController.createTransaction(-10, -10, -10, -10, -10)));

		this.put(ArtifactLevel.SUPER,new ArtifactProperties("Super Defense Artifact",
			new SimpleObjectProperty<Image>(ResourceLoader.loadImage(ASSETS_PATH + "Item_Pack/defense_artifact_icon.png")),
				CurrencyController.createTransaction(-10, -10, -10, -10, -10)));
	}}),


	/**
	 * The health-artifact with its specified properties
	 */
	HEALTH(new ValidatedEntriesHashMap<>()
	{{
		// TODO: Richtiges Sprite hinzufügen anstelle von 'null'.
		this.put(ArtifactLevel.BASE, new ArtifactProperties("Health Artifact",
			new SimpleObjectProperty<Image>(ResourceLoader.loadImage(ASSETS_PATH + "Item_Pack/health_artifact_icon.png")),
				CurrencyController.createTransaction(-10, -10, -10, -10, -10)));

		this.put(ArtifactLevel.SUPER, new ArtifactProperties("Super Health Artifact",
			new SimpleObjectProperty<Image>(ResourceLoader.loadImage(ASSETS_PATH + "Item_Pack/health_artifact_icon.png")),
				CurrencyController.createTransaction(-10, -10, -10, -10, -10)));
	}});


	private final ValidatedEntriesHashMap<ArtifactLevel, ArtifactProperties> propertyMap;

	private ArtifactLevel currentLevel;


	Artifact (final ValidatedEntriesHashMap<ArtifactLevel, ArtifactProperties> propertyMap)
	{
		// TODO: Load ArtifactLevel from config
		this.currentLevel = ArtifactLevel.BASE;
		this.propertyMap = propertyMap;
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public ValidatedEntriesHashMap<ArtifactLevel, ArtifactProperties> getAllProperties ()
	{
		return this.propertyMap;
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public ArtifactProperties getCurrentProperties ()
	{
		return this.propertyMap.get(this.currentLevel);
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public ArtifactLevel getLevel ()
	{
		return this.currentLevel;
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setLevel (final ArtifactLevel artifactLevel)
	{
		this.currentLevel = artifactLevel;
	}


	// FIXME
	@Override
	public String toString ()
	{
		return "Artifact{" + "propertyMap=" + this.propertyMap + ", currentLevel=" + this.currentLevel + '}';
	}
}
