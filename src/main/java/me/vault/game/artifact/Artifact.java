package me.vault.game.artifact;


import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.image.Image;
import me.vault.game.currency.CurrencyController;
import me.vault.game.interfaces.IDisplayable;
import me.vault.game.interfaces.IUpgradable;
import me.vault.game.utility.loading.ResourceLoader;
import me.vault.game.utility.struct.ValidatedEntriesHashMap;

import static me.vault.game.utility.constant.GameConstants.ASSETS_PATH;


public enum Artifact implements IUpgradable<ArtifactLevel, ArtifactAttributes>, IDisplayable
{
	DAMAGE(ResourceLoader.loadImage(ASSETS_PATH + "Item_Pack/damage_artifact_icon.png"),
		new ValidatedEntriesHashMap<>()
	{{
		this.put(ArtifactLevel.BASE, new ArtifactAttributes("Damage Artifact",
			CurrencyController.createTransaction(-10, -10, -10, -10, -10), new AttributeModifiers(1.5, 1.5, 1.5)));

		this.put(ArtifactLevel.IMPROVED, new ArtifactAttributes("Improved Damage Artifact",
			CurrencyController.createTransaction(-10, -10, -10, -10, -10), new AttributeModifiers(1.5, 1.5, 1.5)));
	}}),


	/**
	 * The defense-artifact with its specified properties
	 */
	DEFENSE(ResourceLoader.loadImage(
		ASSETS_PATH + "Item_Pack/defense_artifact_icon.png"), new ValidatedEntriesHashMap<>()
	{{
		this.put(ArtifactLevel.BASE, new ArtifactAttributes("Defense Artifact",
			CurrencyController.createTransaction(-10, -10, -10, -10, -10), new AttributeModifiers(1.5, 1.5, 1.5)));

		this.put(ArtifactLevel.IMPROVED, new ArtifactAttributes("Improved Defense Artifact",
			CurrencyController.createTransaction(-10, -10, -10, -10, -10), new AttributeModifiers(1.5, 1.5, 1.5)));
	}}),

	/**
	 * The health-artifact with its specified properties
	 */
	HEALTH(ResourceLoader.loadImage(ASSETS_PATH + "Item_Pack/health_artifact_icon.png"),
		new ValidatedEntriesHashMap<>()
	{{
		this.put(ArtifactLevel.BASE, new ArtifactAttributes("Health Artifact",
			CurrencyController.createTransaction(-10, -10, -10, -10, -10), new AttributeModifiers(1.5, 1.5, 1.5)));

		this.put(ArtifactLevel.IMPROVED, new ArtifactAttributes("Improved Health Artifact",
			CurrencyController.createTransaction(-10, -10, -10, -10, -10), new AttributeModifiers(1.5, 1.5, 1.5)));
	}});


	private final ValidatedEntriesHashMap<ArtifactLevel, ArtifactAttributes> attributeMap;


	private final SimpleObjectProperty<Image> spriteProperty;


	private final SimpleStringProperty currentName;


	private ArtifactLevel currentLevel;


	Artifact (final Image sprite, final ValidatedEntriesHashMap<ArtifactLevel, ArtifactAttributes> attributeMap)
	{
		// TODO: Load ArtifactLevel from config
		this.currentLevel = ArtifactLevel.BASE;
		this.spriteProperty = new SimpleObjectProperty<>(sprite);
		this.attributeMap = attributeMap;
		this.currentName = new SimpleStringProperty(this.attributeMap.get(this.currentLevel).getName());
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public ValidatedEntriesHashMap<ArtifactLevel, ArtifactAttributes> getAllAttributes ()
	{
		return this.attributeMap;
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public ArtifactAttributes getCurrentAttributes ()
	{
		return this.attributeMap.get(this.currentLevel);
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


	@Override
	public Image getSprite ()
	{
		return this.spriteProperty.get();
	}


	public SimpleStringProperty getCurrentNameProperty ()
	{
		return this.currentName;
	}


	@Override
	public void updateProperties ()
	{
		this.currentName.setValue(this.attributeMap.get(this.currentLevel).getName());
	}


	// TODO: Diese Methode in das IDisplayable Interface verschieben, wenn möglich!
	public SimpleObjectProperty<Image> getSpriteProperty ()
	{
		return this.spriteProperty;
	}


	// FIXME
	@Override
	public String toString ()
	{
		return "Artifact{" + "propertyMap=" + this.attributeMap + ", currentLevel=" + this.currentLevel + '}';
	}
}
