package me.vault.game.artifact;


import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.image.Image;
import me.vault.game.artifact.AttributeModifiers.Type;
import me.vault.game.currency.CurrencyTransaction;
import me.vault.game.interfaces.IDisplayable;

import java.util.Map;


/**
 * Description
 *
 * @author Vincent Wolf
 * @version 1.0.0
 * @see
 * @since 05.06.2024
 */
public abstract class AbsArtifact implements IDisplayable
{
	private final SimpleStringProperty nameProperty;


	private final SimpleObjectProperty<Image> spriteProperty;


	private final ArtifactLevel currentLevel;


	private CurrencyTransaction currentUpgradeCost;


	private final AttributeModifiers attributeModifiers;


	protected AbsArtifact ()
	{
		// TODO: currentLevel aus Config einlesen
		this.currentLevel = ArtifactLevel.getMinimumArtifactLevel();

		this.currentUpgradeCost = this.getUpgradeCostMap().get(this.currentLevel);
		this.attributeModifiers = new AttributeModifiers(this.getAttributeModifiersMap().get(ArtifactLevel.getMinimumArtifactLevel()));
		this.spriteProperty = new SimpleObjectProperty<>(this.getSpriteMap().get(this.currentLevel));
		this.nameProperty = new SimpleStringProperty(this.getNameMap().get(this.currentLevel));
	}


	public SimpleStringProperty getNameProperty ()
	{
		return this.nameProperty;
	}


	public SimpleObjectProperty<Image> getSpriteProperty ()
	{
		return this.spriteProperty;
	}


	public AttributeModifiers getAttributeModifiers ()
	{
		return this.attributeModifiers;
	}


	@Override
	public Image getSprite ()
	{
		return this.spriteProperty.get();
	}


	protected abstract Map<ArtifactLevel, CurrencyTransaction> getUpgradeCostMap ();


	protected abstract Map<ArtifactLevel, Map<Type, Double>> getAttributeModifiersMap ();


	protected abstract Map<ArtifactLevel, String> getNameMap ();


	protected abstract Map<ArtifactLevel, Image> getSpriteMap ();


	// TODO: Mosemann fragen, ob diese updateProperties() als Geschäftslogik im Modell ok sind, oder ob sie in eine dedizierte Controller-Klasse ausgelagert werden sollen.
	@Override
	public void updateProperties ()
	{
		this.nameProperty.set(this.getNameMap().get(this.currentLevel));
		this.spriteProperty.set(this.getSpriteMap().get(this.currentLevel));
		this.currentUpgradeCost = this.getUpgradeCostMap().get(this.currentLevel);
		this.attributeModifiers.updateProperties(this.getAttributeModifiersMap().get(this.currentLevel));
	}
}
