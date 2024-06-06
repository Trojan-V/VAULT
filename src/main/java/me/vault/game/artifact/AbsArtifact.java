package me.vault.game.artifact;


import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.image.Image;
import me.vault.game.artifact.AttributeModifiers.Type;
import me.vault.game.artifact.impl.DamageArtifact;
import me.vault.game.artifact.impl.DefenseArtifact;
import me.vault.game.artifact.impl.HealthArtifact;
import me.vault.game.currency.CurrencyTransaction;
import me.vault.game.interfaces.IDisplayable;
import me.vault.game.interfaces.IUpgradableNew;
import org.jetbrains.annotations.NotNull;

import java.util.Map;


/**
 * This class provides a blueprint for artifacts, which provide different buffs or de-buffs to the player.
 * <br>
 * <b>Important technical note:</b> any subclass of this class must ensure that the data the abstract methods provide
 * is
 * available before the constructor of this abstract class is invoked. The constructor of this class relies on this data
 * being available at construction time.
 * <br> <br>
 * To ensure that the data is available at construction time, the initialization of the static fields who carry this
 * data must happen before the constructor of {@link AbsArtifact} is invoked. The overridden methods
 * {@link AbsArtifact#getSprites()}, {@link AbsArtifact#getNames()}, {@link AbsArtifact#getModifiers()} and
 * {@link AbsArtifact#getUpgradeCosts()} provide these static fields of the subclass to the {@link AbsArtifact} class by
 * returning them. A protected API is used to pass this layer of data to the {@link AbsArtifact} class.
 * <br> <br>
 * <u>How can this be ensured?</u> <br>
 * Now, to ensure that the data is available, first of all the singleton pattern should be used in every subclass of
 * {@link AbsArtifact}. Then, it's important that the instantiation of the static singleton INSTANCE field happens after
 * the instantiation of the other static fields who carry the required data for the constructor of {@link AbsArtifact}.
 * <br> <br>
 * To do so, a static initializer can be used whose last statement is {@code INSTANCE = new AbsArtifact();}.
 *
 * @author Vincent Wolf
 * @version 1.0.0
 * @see DamageArtifact
 * @see DefenseArtifact
 * @see HealthArtifact
 * @see AttributeModifiers
 * @see ArtifactController
 * @see ArtifactLevel
 * @since 05.06.2024
 */
public abstract class AbsArtifact implements IDisplayable, IUpgradableNew<ArtifactLevel>
{
	/**
	 * This property is used to store and dynamically display the name of the artifact. If the name is updated within
	 * this property, JavaFX instantly applies the change, so it's visible in the GUI.
	 *
	 * @see SimpleStringProperty
	 */
	private final SimpleStringProperty nameProperty;


	/**
	 * This property is used to store and dynamically display the sprite of the artifact. If the sprite is updated
	 * within this property, JavaFX instantly applies the change, so it's visible in the GUI.
	 *
	 * @see SimpleObjectProperty
	 * @see Image
	 */
	private final SimpleObjectProperty<Image> spriteProperty;


	/**
	 * This field contains the attribute modifiers, which are the status effects the player receives in form of
	 * buffs or
	 * de-buffs depending on the equipped artifact.
	 *
	 * @see AttributeModifiers
	 */
	private final AttributeModifiers attributeModifiers;


	/**
	 * This field stores the current level of the artifact. The value of this field controls the values of many
	 * attributes the artifact consists of.
	 * <br>
	 * Check the constructor {@link AbsArtifact#AbsArtifact()} and the {@link AbsArtifact#updateProperties()} method to
	 * see the control flow.
	 *
	 * @see ArtifactLevel
	 */
	private ArtifactLevel currentLevel;


	/**
	 * This field contains the resource price to upgrade the artifact to the next level. The price is always denoted in
	 * negative numbers within the {@link CurrencyTransaction} instance.
	 * <br>
	 * It's important to keep that into account to ensure no algebraic sign issues are coming up. It's not hard to mess
	 * that up, as upgrade costs could be thought about with a positive algebraic sign instead of a negative one.
	 *
	 * @see CurrencyTransaction
	 */
	private CurrencyTransaction currentUpgradeCost;


	/**
	 * Constructs an instance of this class.
	 * <br>
	 * It's important to note that the constructor accesses overridable methods of the subclass. These methods provide
	 * the data for the artifact, which can then be accessed and used by using the {@link AbsArtifact#currentLevel} as
	 * key to retrieve the correct data for the current level.
	 * <br>
	 * To understand the side effects of these method invocations, read the documentation of this class.
	 */
	protected AbsArtifact ()
	{
		// TODO: currentLevel aus Config einlesen
		this.currentLevel = ArtifactLevel.getMinimumArtifactLevel();

		this.currentUpgradeCost = this.getUpgradeCosts().get(this.currentLevel);
		this.attributeModifiers =
			new AttributeModifiers(this.getModifiers().get(ArtifactLevel.getMinimumArtifactLevel()));
		this.spriteProperty = new SimpleObjectProperty<>(this.getSprites().get(this.currentLevel));
		this.nameProperty = new SimpleStringProperty(this.getNames().get(this.currentLevel));
	}


	public SimpleStringProperty getNameProperty ()
	{
		return this.nameProperty;
	}


	public String getName ()
	{
		return this.nameProperty.get();
	}


	@Override
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


	@Override
	public ArtifactLevel getLevel ()
	{
		return this.currentLevel;
	}


	@Override
	public void setLevel (final ArtifactLevel currentLevel)
	{
		this.currentLevel = currentLevel;
	}


	public CurrencyTransaction getCurrentUpgradeCost ()
	{
		return this.currentUpgradeCost;
	}


	@NotNull
	protected abstract Map<ArtifactLevel, CurrencyTransaction> getUpgradeCosts ();


	@NotNull
	protected abstract Map<ArtifactLevel, String> getNames ();


	@NotNull
	protected abstract Map<ArtifactLevel, Image> getSprites ();


	@NotNull
	protected abstract Map<ArtifactLevel, Map<Type, Double>> getModifiers ();


	// TODO: Mosemann fragen, ob diese updateProperties() als Geschäftslogik im Modell ok sind, oder ob sie in eine
	//  dedizierte Controller-Klasse ausgelagert werden sollen.
	public void updateProperties ()
	{
		this.nameProperty.set(this.getNames().get(this.currentLevel));
		this.spriteProperty.set(this.getSprites().get(this.currentLevel));
		this.currentUpgradeCost = this.getUpgradeCosts().get(this.currentLevel);
		this.attributeModifiers.updateProperties(this.getModifiers().get(this.currentLevel));
	}
}
