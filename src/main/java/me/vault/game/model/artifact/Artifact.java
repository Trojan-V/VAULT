package me.vault.game.model.artifact;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.image.Image;
import me.vault.game.control.ArtifactController;
import me.vault.game.interfaces.Displayable;
import me.vault.game.interfaces.Nameable;
import me.vault.game.interfaces.UpgradableNew;
import me.vault.game.model.artifact.impl.DamageArtifact;
import me.vault.game.model.artifact.impl.DefenseArtifact;
import me.vault.game.model.artifact.impl.HealthArtifact;
import me.vault.game.model.currency.CurrencyTransaction;
import me.vault.game.utility.logging.ILogger;
import me.vault.game.utility.logging.Logger;
import me.vault.game.utility.struct.MetaDataImage;
import me.vault.game.view.city.buildings.WorkshopDelegate;
import org.jetbrains.annotations.NotNull;

import java.net.URL;
import java.text.MessageFormat;
import java.util.Map;
import java.util.ResourceBundle;

import static me.vault.game.utility.constant.NewLoggingConstants.Artifact.ATTRIBUTE_MODIFIERS_SET;
import static me.vault.game.utility.constant.NewLoggingConstants.*;
import static me.vault.game.utility.constant.SupressionConstants.OVERRIDABLE_METHOD_CALL;
import static me.vault.game.utility.constant.SupressionConstants.OVERRIDDEN_METHOD_CALL;
import static me.vault.game.utility.logging.ILogger.Level.DEBUG;

/**
 * This class provides a blueprint for artifacts, which provide different buffs or de-buffs to the player.
 * <br>
 * <b>Important technical note:</b> any subclass of this class must ensure that the data the abstract methods provide
 * is available before the constructor of this abstract class is invoked. The constructor of this class relies on this data being available at
 * construction time.
 * <br> <br>
 * To ensure that the data is available at construction time, the initialization of the static fields who carry this data must happen before the
 * constructor of {@link Artifact} is invoked. The overridden methods {@link Artifact#getAllSprites()}, {@link Artifact#getAllNames()},
 * {@link Artifact#getAllModifiers()} and {@link Artifact#getAllUpgradeCosts()} provide these static fields of the subclass to the {@link Artifact}
 * class by returning them. A protected API is used to pass this layer of data to the {@link Artifact} class.
 * <br> <br>
 * <u>How can this be ensured?</u> <br>
 * Now, to ensure that the data is available, first of all the singleton pattern should be used in every subclass of {@link Artifact}. Then, it's
 * important that the instantiation of the static singleton INSTANCE field happens after the instantiation of the other static fields who carry the
 * required data for the constructor of {@link Artifact}.
 * <br> <br>
 * To do so, a static initializer can be used whose last statement is {@code INSTANCE = new AbsArtifact();}.
 *
 * @author Vincent Wolf, Lasse-Leander Hillen
 * @version 2.0.0
 * @see DamageArtifact
 * @see DefenseArtifact
 * @see HealthArtifact
 * @see AttributeMultiplier
 * @see ArtifactController
 * @see ArtifactLevel
 * @since 05.06.2024
 */
public abstract class Artifact implements Displayable, UpgradableNew<ArtifactLevel>, Nameable
{
	/**
	 * The logger object for this class used for writing to the console.
	 *
	 * @see Logger
	 */
	private static final ILogger LOGGER = new Logger(Artifact.class.getSimpleName());

	/**
	 * The pattern used to create the string which describes the class in a human-readable format.
	 */
	private static final String TO_STRING_PATTERN = "Artifact[level={0}, name={1}, sprite={2}, modifiers={3}, upgradeCost={4}]";

	/**
	 * This property is used to store and dynamically display the name of the artifact. If the name is updated within this property, JavaFX instantly
	 * applies the change, so it's visible in the GUI.
	 *
	 * @see SimpleStringProperty
	 */
	private final SimpleStringProperty nameProperty;

	/**
	 * This property is used to store and dynamically display the sprite of the artifact. If the sprite is updated within this property, JavaFX
	 * instantly applies the change, so it's visible in the GUI.
	 *
	 * @see SimpleObjectProperty
	 * @see MetaDataImage
	 */
	private final SimpleObjectProperty<MetaDataImage> spriteProperty;

	/**
	 * This field contains the attribute modifiers, which are the status effects the player receives in the form of buffs or de-buffs depending on the
	 * equipped artifact.
	 *
	 * @see AttributeMultiplier
	 */
	private final AttributeMultiplier attributeMultiplier;

	/**
	 * This field stores the current level of the artifact. The value of this field controls the values of many attributes the artifact consists of.
	 * <br>
	 * Check the constructor {@link Artifact#Artifact()} and the {@link Artifact#updatePropertyValues()} method to see the control flow.
	 *
	 * @see ArtifactLevel
	 */
	private ArtifactLevel currentLevel;

	/**
	 * This field contains the resource price to upgrade the artifact to the next level. The price is always denoted in negative numbers within the
	 * {@link CurrencyTransaction} instance.
	 * <br>
	 * It's important to keep that into account to ensure no algebraic sign issues are coming up. It's not hard to mess that up, as upgrade costs
	 * could be thought about with a positive algebraic sign instead of a negative one.
	 *
	 * @see CurrencyTransaction
	 */
	private CurrencyTransaction currentUpgradeCost;


	/**
	 * Constructs an instance of this class. The constructor is on the protected API to ensure that subclasses have access to it, as only subclasses
	 * of this abstract class should be able to create instances of this class.
	 * <br>
	 * It's important to note that the constructor accesses overridable methods of the subclass. These methods provide the data for the artifact,
	 * which can then be accessed and used by using the {@link Artifact#currentLevel} as key to retrieve the correct data for the current level.
	 * <br>
	 * To understand the side effects of these method invocations, read the documentation of this class.
	 */
	@SuppressWarnings ({OVERRIDDEN_METHOD_CALL, OVERRIDABLE_METHOD_CALL})
	protected Artifact ()
	{
		// TODO: currentLevel aus Config einlesen
		this.currentLevel = ArtifactLevel.getMinimum();

		this.currentUpgradeCost = this.getAllUpgradeCosts().get(this.currentLevel);
		this.attributeMultiplier = new AttributeMultiplier(this.getAllModifiers().get(ArtifactLevel.getMinimum()));
		this.spriteProperty = new SimpleObjectProperty<>(this.getAllSprites().get(this.currentLevel));
		this.nameProperty = new SimpleStringProperty(this.getAllNames().get(this.currentLevel));

		// Logging outputs
		LOGGER.logf(DEBUG, LEVEL_SET, this.currentLevel.name());
		LOGGER.logf(DEBUG, UPGRADE_COST_SET, this.currentUpgradeCost.toString());
		LOGGER.logf(DEBUG, ATTRIBUTE_MODIFIERS_SET, this.attributeMultiplier.toString());
		LOGGER.logf(DEBUG, SPRITE_PROPERTY_SET, this.spriteProperty.toString());
		LOGGER.logf(DEBUG, NAME_PROPERTY_SET, this.nameProperty.get());
	}


	/**
	 * Returns the attribute modifiers the artifact provides.
	 *
	 * @return The attribute modifiers of the artifact, which are the status effects the player receives in the form of buffs or de-buffs depending on
	 * the equipped artifact.
	 * @see AttributeMultiplier
	 */
	public AttributeMultiplier getAttributeModifiers ()
	{
		return this.attributeMultiplier;
	}


	/**
	 * Returns the property that contains the name of the artifact.
	 * <br>
	 * This property is bound to an element in the GUI. Check {@link WorkshopDelegate#initialize(URL, ResourceBundle)} to see the binding process.
	 *
	 * @return The property that contains the name of the artifact.
	 * @see WorkshopDelegate
	 * @see SimpleStringProperty
	 */
	@Override
	public SimpleStringProperty getNameProperty ()
	{
		return this.nameProperty;
	}


	/**
	 * Returns the current name of the artifact. The name changes as it depends on the level of the artifact.
	 *
	 * @return The current name of the artifact.
	 */
	@Override
	public String getName ()
	{
		return this.nameProperty.get();
	}


	/**
	 * Returns the current sprite of the artifact.
	 * <br>
	 * The sprite may or may not change. It technically depends on the level of the artifact, but in some cases, the same sprite is used for multiple
	 * artifact levels, hence why it doesn't change visually in that case.
	 *
	 * @return The current sprite of the artifact.
	 * @see Image
	 */
	@Override
	public Image getSprite ()
	{
		return this.spriteProperty.get();
	}


	/**
	 * Returns the current sprite property of the artifact. The sprite may or may not change. It technically depends on the level of the artifact, but
	 * in some cases, the same sprite is used for multiple artifact levels, hence why it doesn't change visually in that case.
	 * <br>
	 * This property is bound to an element in the GUI. Check {@link WorkshopDelegate#initialize(URL, ResourceBundle)} to see the binding process.
	 *
	 * @return The current sprite property of the artifact.
	 * @see SimpleObjectProperty
	 * @see Image
	 */
	@Override
	public SimpleObjectProperty<MetaDataImage> getSpriteProperty ()
	{
		return this.spriteProperty;
	}


	/**
	 * This method is invoked by the {@link ArtifactController#upgrade(Artifact)} method.
	 * <br>
	 * This method updates the properties of this class which are bound to the GUI to ensure the correct data is shown after an upgrade happened.
	 */
	@Override
	public void updatePropertyValues ()
	{
		this.nameProperty.set(this.getAllNames().get(this.currentLevel));
		this.spriteProperty.set(this.getAllSprites().get(this.currentLevel));
		this.currentUpgradeCost = this.getAllUpgradeCosts().get(this.currentLevel);
		this.attributeMultiplier.updatePropertyValues(this.getAllModifiers().get(this.currentLevel));


		// Logging output
		LOGGER.logf(DEBUG, NAME_PROPERTY_SET, this.nameProperty.get());
		LOGGER.logf(DEBUG, SPRITE_PROPERTY_SET, this.spriteProperty.get().toString());
		LOGGER.logf(DEBUG, UPGRADE_COST_SET, this.currentUpgradeCost.toString());
	}


	/**
	 * Returns the current level of the artifact.
	 * <br>
	 * Many components of the artifact are directly dependent on the level, for instance, the value of the {@link Artifact#nameProperty} and the
	 * {@link Artifact#spriteProperty}. Therefore, the level determines the data of other attributes, as the key in the 'data maps' which the
	 * subclasses of this class provide is this level and the data is extracted by using this key. The subclasses provide this data by implementing
	 * the abstract methods {@link Artifact#getAllUpgradeCosts()}, {@link Artifact#getAllNames()}, {@link Artifact#getAllSprites()} and
	 * {@link Artifact#getAllModifiers()}.
	 *
	 * @return The current level of the artifact.
	 * @see ArtifactLevel
	 */
	@Override
	public ArtifactLevel getLevel ()
	{
		return this.currentLevel;
	}


	/**
	 * Sets the level of the artifact to a new level.
	 *
	 * @param currentLevel The new level of the artifact in form of an instance of {@link ArtifactLevel}.
	 *
	 * @see ArtifactLevel
	 */
	@Override
	public void setLevel (final ArtifactLevel currentLevel)
	{
		this.currentLevel = currentLevel;
	}


	/**
	 * Returns the current price to upgrade the artifact.
	 *
	 * @return The current price to upgrade the artifact to the next level.
	 * @see CurrencyTransaction
	 */
	@Override
	public CurrencyTransaction getCurrentUpgradeCosts ()
	{
		return this.currentUpgradeCost;
	}


	/**
	 * Returns all upgrade cost {@link CurrencyTransaction}'s which are used to determine whether the player can or can't upgrade the artifact
	 * depending on the number of currencies he owns.
	 * <br>
	 * These {@link CurrencyTransaction}'s are sorted by the {@link ArtifactLevel} as key within this {@link Map}, allowing for easy access by using
	 * this meaningful key ({@link ArtifactLevel}).
	 *
	 * @return The {@link Map} which contains all upgrade cost transactions for the artifact.
	 * @see Map
	 * @see ArtifactLevel
	 * @see CurrencyTransaction
	 */
	@NotNull
	protected abstract Map<ArtifactLevel, CurrencyTransaction> getAllUpgradeCosts ();


	/**
	 * Returns all names the artifact can have. An artifact has different names depending on its level.
	 * <br>
	 * Therefore, these names are sorted by the {@link ArtifactLevel} as key in a {@link Map}, allowing for easy access by using this meaningful key
	 * ({@link ArtifactLevel}).
	 *
	 * @return The {@link Map} which contains all names for the artifact.
	 * @see Map
	 * @see ArtifactLevel
	 */
	@NotNull
	protected abstract Map<ArtifactLevel, String> getAllNames ();


	/**
	 * Returns all sprites the artifact can have. An artifact can have, but doesn't always have, different sprites depending on its level.
	 * <br>
	 * Therefore, these sprites are sorted by the {@link ArtifactLevel} as key in a {@link Map}, allowing for easy access by using this meaningful key
	 * ({@link ArtifactLevel}).
	 *
	 * @return The {@link Map} which contains all sprites for the artifact.
	 * @see Map
	 * @see ArtifactLevel
	 * @see Image
	 */
	@NotNull
	protected abstract Map<ArtifactLevel, MetaDataImage> getAllSprites ();


	/**
	 * Returns all sets of modifiers the artifact can have, depending on it's level.
	 * <br>
	 * Therefore, these sets of modifiers are sorted by the {@link ArtifactLevel} as key in a {@link Map}, allowing for easy access by using this
	 * meaningful key ({@link ArtifactLevel}).
	 *
	 * @return The {@link Map} which contains all different sets of modifiers the artifact can have, depending on it's level.
	 * @see Map
	 * @see ArtifactLevel
	 * @see AttributeMultiplier.Type
	 */
	@NotNull
	protected abstract Map<ArtifactLevel, Map<AttributeMultiplier.Type, Double>> getAllModifiers ();


	/**
	 * Returns the instance of this class in a human-readable format by creating a string.
	 *
	 * @return The message in its string representation.
	 */
	@Override
	public String toString ()
	{
		return MessageFormat.format(TO_STRING_PATTERN, this.currentLevel.name(), this.nameProperty.get(), this.spriteProperty.get().toString(),
		                            this.attributeMultiplier.toString(), this.currentUpgradeCost.toString());
	}

}
