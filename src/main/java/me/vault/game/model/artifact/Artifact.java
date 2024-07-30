package me.vault.game.model.artifact;


import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.image.Image;
import me.vault.game.control.ArtifactController;
import me.vault.game.interfaces.Displayable;
import me.vault.game.interfaces.Nameable;
import me.vault.game.interfaces.Upgradable;
import me.vault.game.model.artifact.impl.DamageArtifact;
import me.vault.game.model.artifact.impl.DefenseArtifact;
import me.vault.game.model.artifact.impl.HealthArtifact;
import me.vault.game.model.currency.CurrencyTransaction;
import me.vault.game.utility.logging.ILogger;
import me.vault.game.utility.logging.Logger;
import me.vault.game.utility.struct.MetaDataImage;
import me.vault.game.view.city.building.WorkshopDelegate;
import org.jetbrains.annotations.NotNull;

import java.net.URL;
import java.text.MessageFormat;
import java.util.Map;
import java.util.ResourceBundle;

import static me.vault.game.utility.constant.LoggingConstants.Artifact.ATTRIBUTE_MODIFIERS_SET_PATTERN;
import static me.vault.game.utility.constant.LoggingConstants.*;
import static me.vault.game.utility.constant.SuppressionConstants.OVERRIDABLE_METHOD_CALL;
import static me.vault.game.utility.constant.SuppressionConstants.OVERRIDDEN_METHOD_CALL;
import static me.vault.game.utility.logging.ILogger.Level.DEBUG;


/**
 * This class provides a blueprint for artifacts, which provide different buffs or de-buffs to the player.
 * <br>
 * <b>Important technical note:</b> any subclass of this class must ensure that the data the abstract methods provide
 * is available before the constructor of this abstract class is invoked. The constructor of this class relies on
 * this data being available at construction time.
 * <br> <br>
 * To ensure that the data is available at construction time, the initialization of the static fields who carry this
 * data must happen before the
 * constructor of {@link Artifact} is invoked. The overridden methods {@link Artifact#getAllSprites()},
 * {@link Artifact#getAllNames()},
 * {@link Artifact#getAllModifiers()} and {@link Artifact#getAllUpgradeCosts()} provide these static fields of the
 * subclass to the {@link Artifact}
 * class by returning them. A protected API is used to pass this layer of data to the {@link Artifact} class.
 * <br> <br>
 * <u>How can this be ensured?</u> <br>
 * Now, to ensure that the data is available, first of all the singleton pattern should be used in every subclass of
 * {@link Artifact}. Then, it's
 * important that the instantiation of the static singleton INSTANCE field happens after the instantiation of the
 * other static fields who carry the
 * required data for the constructor of {@link Artifact}.
 * <br> <br>
 * To do so, a static initializer can be used whose last statement is {@code INSTANCE = new AbsArtifact();}.
 *
 * @author Vincent Wolf, Lasse-Leander Hillen, Timothy Hoegen-Jupp, Alexander Goethel
 * @version 1.0.0
 * @see DamageArtifact
 * @see DefenseArtifact
 * @see HealthArtifact
 * @see AttributeMultiplier
 * @see ArtifactController
 * @see ArtifactLevel
 * @since 05.06.2024
 */
public abstract class Artifact implements Displayable, Upgradable<ArtifactLevel>, Nameable
{

	/**
	 * The {@link Logger} object for this class used for writing to the console.
	 */
	private static final ILogger LOGGER = new Logger(Artifact.class.getSimpleName());


	/**
	 * The {@link MessageFormat} pattern, which is used, when the {@link Artifact#toString()} is
	 * called.
	 */
	private static final String TO_STRING_PATTERN = "Artifact[level={0}, name={1}, sprite={2}, modifiers={3}, upgradeCost={4}, isMaxLevel={5}]";


	/**
	 * This property is used to store and dynamically display the name of the artifact. If the name is updated within
	 * this property, JavaFX instantly applies the change, so it's visible in the GUI.
	 */
	private final SimpleStringProperty nameProperty;


	/**
	 * This {@link SimpleObjectProperty} is used to store and dynamically display the sprite ({@link MetaDataImage}) of the artifact.
	 * If the sprite is updated within this property, JavaFX instantly applies the change, so it's visible in the GUI.
	 */
	private final SimpleObjectProperty<MetaDataImage> spriteProperty;


	/**
	 * This property is used to store and dynamically display if the artifact is at the maximum level.
	 * If the data is updated within this property, JavaFX instantly applies the change, so it's visible in the GUI.
	 */
	private final SimpleBooleanProperty isMaxLevelProperty;


	/**
	 * This field contains the attribute modifiers, which are the status effects the player receives in the form of
	 * buffs or de-buffs depending on the
	 * equipped artifact.
	 */
	private final AttributeMultiplier attributeMultiplier;


	/**
	 * This field stores the current {@link ArtifactLevel} of the artifact. The value of this field controls the values of many
	 * attributes the artifact consists of.
	 * <br>
	 * Check the constructor {@link Artifact#Artifact()} and the
	 * {@link ArtifactController#updateValues(Artifact)} method to see the control flow.
	 */
	private ArtifactLevel currentLevel;


	/**
	 * This field contains the resource price to upgrade the artifact to the next level. The price is always denoted
	 * in negative numbers within the
	 * {@link CurrencyTransaction} instance.
	 * <br>
	 * It's important to keep that into account to ensure no algebraic sign issues are coming up. It's not hard to
	 * mess that up, as upgrade costs
	 * could be thought about with a positive algebraic sign instead of a negative one.
	 */
	private CurrencyTransaction currentUpgradeCost;


	/**
	 * Constructs an instance of this class. The constructor is on the protected API to ensure that subclasses have
	 * access to it, as only subclasses
	 * of this abstract class should be able to create instances of this class.
	 * <br>
	 * It's important to note that the constructor accesses overridable methods of the subclass. These methods provide
	 * the data for the artifact,
	 * which can then be accessed and used by using the {@link Artifact#currentLevel} as key to retrieve the correct
	 * data for the current level.
	 * <br>
	 * To understand the side effects of these method invocations, read the documentation of this class.
	 * @precondition The attributes for the {@link Artifact} exists.
	 * @postcondition Constructs an {@link Artifact} instance with the given attributes.
	 */
	@SuppressWarnings ({OVERRIDDEN_METHOD_CALL, OVERRIDABLE_METHOD_CALL})
	protected Artifact ()
	{
		this.currentLevel = ArtifactLevel.getMinimum();
		this.currentUpgradeCost = this.getAllUpgradeCosts().get(this.currentLevel);
		this.attributeMultiplier = new AttributeMultiplier(this.getAllModifiers().get(ArtifactLevel.getMinimum()));
		this.spriteProperty = new SimpleObjectProperty<>(this.getAllSprites().get(this.currentLevel));
		this.nameProperty = new SimpleStringProperty(this.getAllNames().get(this.currentLevel));
		this.isMaxLevelProperty = new SimpleBooleanProperty(this.currentLevel == ArtifactLevel.getMaximum());

		// Logging outputs
		LOGGER.logf(DEBUG, LEVEL_SET_PATTERN, this.currentLevel.name());
		LOGGER.logf(DEBUG, UPGRADE_COST_SET_PATTERN, this.currentUpgradeCost.toString());
		LOGGER.logf(DEBUG, ATTRIBUTE_MODIFIERS_SET_PATTERN, this.attributeMultiplier.toString());
		LOGGER.logf(DEBUG, SPRITE_PROPERTY_SET_PATTERN, this.spriteProperty.toString());
		LOGGER.logf(DEBUG, NAME_PROPERTY_SET_PATTERN, this.nameProperty.get());
	}


	/**
	 * Returns the attribute multipliers the artifact at its current level provides.
	 *
	 * @return The attribute multipliers of the artifact, which are the status effects the player receives in the form
	 * of buffs or de-buffs depending on the equipped artifact.
	 * @precondition The {@link AttributeMultiplier} exists.
	 * @postcondition The {@link AttributeMultiplier}s are accessible for the program.
	 */
	public AttributeMultiplier getAttributeMultipliers ()
	{
		return this.attributeMultiplier;
	}


	/**
	 * Returns the map of attribute multipliers the artifact at the supplied level as parameter provides.
	 * <br>
	 * This method is used to be able to access the map of all attribute multipliers to be able to set the new values
	 * after an artifact was upgraded.
	 * <br>
	 * This method is invoked by {@link ArtifactController#updateValues(Artifact)}.
	 *
	 * @param level The artifact level whose map of attribute multipliers should be returned.
	 *
	 * @return The map of attribute multipliers for the supplied level.
	 * @precondition The {@link AttributeMultiplier} exists.
	 * @postcondition The map of the {@link AttributeMultiplier}s are accessible for the program.
	 */
	public Map<AttributeMultiplier.Type, Double> getAttributeMultipliers (final ArtifactLevel level)
	{
		return this.getAllModifiers().get(level);
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getName ()
	{
		return this.nameProperty.get();
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setName (final String name)
	{
		this.nameProperty.set(name);
	}


	/**
	 * {@inheritDoc}
	 */

	public String getName (final ArtifactLevel level)
	{
		return this.getAllNames().get(level);
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public MetaDataImage getSprite ()
	{
		return this.spriteProperty.get();
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setSprite (final MetaDataImage sprite)
	{
		this.spriteProperty.set(sprite);
	}


	/**
	 * {@inheritDoc}
	 */
	public MetaDataImage getSprite (final ArtifactLevel level)
	{
		return this.getAllSprites().get(level);
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public SimpleStringProperty getNameProperty ()
	{
		return this.nameProperty;
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public SimpleObjectProperty<MetaDataImage> getSpriteProperty ()
	{
		return this.spriteProperty;
	}


	/**
	 * Sets the isMaxLevel status of the artifact to the supplied boolean value.
	 *
	 * @param value True if the artifact should be marked as max level, otherwise false.
	 * @precondition The {@link Artifact} can have multiple level.
	 * @postcondition Sets if {@link ArtifactLevel} is maximal.
	 */
	public void setIsMaxLevel (final boolean value)
	{
		this.isMaxLevelProperty.set(value);
	}


	/**
	 * Returns the property used to store the isMaxLevel data.
	 *
	 * @return The property used to store the isMaxLevel data.
	 * @precondition The data of isMaxLevel exists.
	 * @postcondition The property used to store the isMaxLevel data is accessible for the program.
	 */
	public SimpleBooleanProperty getIsMaxLevelProperty ()
	{
		return this.isMaxLevelProperty;
	}


	/**
	 * Returns the current level of the artifact.
	 * <br>
	 * Many components of the artifact are directly dependent on the level, for instance, the value of the
	 * {@link Artifact#nameProperty} and the
	 * {@link Artifact#spriteProperty}. Therefore, the level determines the data of other attributes, as the key in
	 * the 'data maps' which the
	 * subclasses of this class provide is this level and the data is extracted by using this key. The subclasses
	 * provide this data by implementing
	 * the abstract methods {@link Artifact#getAllUpgradeCosts()}, {@link Artifact#getAllNames()},
	 * {@link Artifact#getAllSprites()} and
	 * {@link Artifact#getAllModifiers()}.
	 *
	 * @return The current level of the artifact.
	 * @precondition The {@link Artifact} has a level.
	 * @postcondition The current level of the {@link Artifact} is accessible for the program.
	 */
	@Override
	public ArtifactLevel getLevel ()
	{
		return this.currentLevel;
	}


	/**
	 * Sets the level of the artifact to a new level.
	 *
	 * @param level The new level of the artifact in form of an instance of {@link ArtifactLevel}.
	 *
	 * @precondition The {@link Artifact} has a level.
	 * @postcondition The current level of the {@link Artifact} is set.
	 */
	@Override
	public void setLevel (final ArtifactLevel level)
	{
		this.currentLevel = level;
	}


	/**
	 * Returns the current price to upgrade the artifact.
	 *
	 * @return The current price to upgrade the artifact to the next level.
	 *
	 * @precondition The {@link CurrencyTransaction} exists.
	 * @postcondition The price for the {@link CurrencyTransaction} is accessible for the program.
	 */
	@Override
	public CurrencyTransaction getUpgradeCosts ()
	{
		return this.currentUpgradeCost;
	}


	/**
	 * Sets the upgrade cost {@link CurrencyTransaction} to a new value, which represents the upgrade costs that are
	 * required to upgrade the artifact to the next level.
	 * <br>
	 * This method should be invoked each time the artifact is upgraded, as the upgrade costs usually increase the
	 * higher the artifact level gets.
	 *
	 * @param upgradeCosts The new upgrade costs the artifact requires to be upgraded to the next level.
	 * @precondition The {@link CurrencyTransaction} exists.
	 * @postcondition The price for the {@link CurrencyTransaction} is set.
	 */
	@Override
	public void setUpgradeCosts (final CurrencyTransaction upgradeCosts)
	{
		this.currentUpgradeCost = upgradeCosts;
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public CurrencyTransaction getUpgradeCosts (final ArtifactLevel level)
	{
		return this.getAllUpgradeCosts().get(level);
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
	 * @precondition The {@link Map} which contains all upgrade cost transactions for the {@link Artifact} exists.
	 * @postcondition A {@link Map} which contains all upgrade cost transactions for the {@link Artifact} is
	 * accessible for the program.
	 */
	@NotNull
	protected abstract Map<ArtifactLevel, CurrencyTransaction> getAllUpgradeCosts ();


	/**
	 * Returns all names the artifact can have. An artifact has different names depending on its level.
	 * <br>
	 * Therefore, these names are sorted by the {@link ArtifactLevel} as key in a {@link Map}, allowing for easy
	 * access by using this meaningful key
	 * ({@link ArtifactLevel}).
	 *
	 * @return The {@link Map} which contains all names for the artifact.
	 *
	 * @precondition The {@link Map} which contains all names for the {@link Artifact} exists.
	 * @postcondition A {@link Map} which contains all names for the {@link Artifact} is
	 * accessible for the program.
	 */
	@NotNull
	protected abstract Map<ArtifactLevel, String> getAllNames ();


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
	 * @precondition The {@link Map} which contains all sprites for the {@link Artifact} exists.
	 * @postcondition A {@link Map} which contains all sprites for the {@link Artifact} is
	 * accessible for the program.
	 */
	@NotNull
	protected abstract Map<ArtifactLevel, MetaDataImage> getAllSprites ();


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
	 * @precondition The {@link Map} which contains all modifiers for the {@link Artifact} exists.
	 * @postcondition A {@link Map} which contains all modifiers for the {@link Artifact} is
	 * accessible for the program.
	 */
	@NotNull
	protected abstract Map<ArtifactLevel, Map<AttributeMultiplier.Type, Double>> getAllModifiers ();


	/**
	 * Builds a formatted {@link String}, which represents the object, and it's current state using the
	 * {@link Artifact#TO_STRING_PATTERN}.
	 *
	 * @return A {@link String} which has been formatted in the {@link Artifact#TO_STRING_PATTERN}.
	 *
	 * @precondition The {@link Artifact#TO_STRING_PATTERN} is {@code != null}.
	 * @postcondition The method returned a {@link String} which represents the object.
	 */
	@Override
	public String toString ()
	{
		return MessageFormat.format(TO_STRING_PATTERN, this.currentLevel.name(), this.nameProperty.get(), this.spriteProperty.get()
			.toString(), this.attributeMultiplier.toString(), this.currentUpgradeCost.toString(), this.isMaxLevelProperty.get());
	}

}
