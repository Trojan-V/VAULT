package me.vault.game.model.energy;


import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.image.Image;
import me.vault.game.control.EnergyAbilityController;
import me.vault.game.interfaces.Displayable;
import me.vault.game.interfaces.Nameable;
import me.vault.game.interfaces.Upgradable;
import me.vault.game.model.arena.Arena;
import me.vault.game.model.currency.CurrencyTransaction;
import me.vault.game.model.energy.impl.DodgeAbility;
import me.vault.game.model.energy.impl.InitiativeAbility;
import me.vault.game.model.energy.impl.MeleeAbility;
import me.vault.game.utility.logging.ILogger;
import me.vault.game.utility.logging.Logger;
import me.vault.game.utility.struct.MetaDataImage;
import me.vault.game.view.city.building.LaboratoryDelegate;
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
 * This class provides a blueprint for energy ability, which provide different buffs the player can apply in an
 * encounter.
 * <br>
 * <b>Important technical note:</b> any subclass of this class must ensure that the data the abstract methods provide
 * is available before the constructor of this abstract class is invoked. The constructor of this class relies on
 * this data being available at construction time.
 * <br> <br>
 * To ensure that the data is available at construction time, the initialization of the static fields who carry this
 * data must happen before the
 * constructor of {@link EnergyAbility} is invoked. The overridden methods {@link EnergyAbility#getAllSprites()},
 * {@link EnergyAbility#getAllNames()},
 * {@link EnergyAbility#getAllModifiers()} and {@link EnergyAbility#getAllUpgradeCosts()} provide these static fields of the
 * subclass to the {@link EnergyAbility}
 * class by returning them. A protected API is used to pass this layer of data to the {@link EnergyAbility} class.
 * <br> <br>
 * <u>How can this be ensured?</u> <br>
 * Now, to ensure that the data is available, first of all the singleton pattern should be used in every subclass of
 * {@link EnergyAbility}. Then, it's
 * important that the instantiation of the static singleton INSTANCE field happens after the instantiation of the
 * other static fields who carry the
 * required data for the constructor of {@link EnergyAbility}.
 * <br> <br>
 * To do so, a static initializer can be used whose last statement is {@code INSTANCE = new AbsEnergy();}.
 *
 * @author Vincent Wolf, Lasse-Leander Hillen, Timothy Hoegen-Jupp, Alexander Goethel
 * @version 2.0.0
 * @see DodgeAbility
 * @see InitiativeAbility
 * @see MeleeAbility
 * @see AbilityMultiplier
 * @see AbilityMultiplier
 * @see EnergyLevel
 * @since 25.07.2024
 */
public abstract class EnergyAbility implements Displayable, Upgradable<EnergyLevel>, Nameable
{
	/**
	 * The {@link Logger} object for this class used for writing to the console.
	 */
	private static final ILogger LOGGER = new Logger(EnergyAbility.class.getSimpleName());


	/**
	 * The {@link MessageFormat} pattern, which is used, when the {@link Arena#toString()} is
	 * called.
	 */
	private static final String TO_STRING_PATTERN =
		"Energy'{'nameProperty={0}, spriteProperty={1}, isMaxLevelProperty={2}, abilityMultiplier={3}, currentLevel={4}, currentUpgradeCost={5}'}'";


	/**
	 * This property is used to store and dynamically display the name of the energy ability.
	 * If the name is updated within this property, JavaFX instantly applies the change, so it's visible in the GUI.
	 *
	 * @see SimpleStringProperty
	 */
	private final SimpleStringProperty nameProperty;


	/**
	 * This {@link SimpleObjectProperty} is used to store and dynamically display the sprite ({@link MetaDataImage}) of the energy ability.
	 * If the sprite is updated within this property, JavaFX instantly applies the change, so it's visible in the GUI.
	 */
	private final SimpleObjectProperty<MetaDataImage> spriteProperty;


	/**
	 * This property is used to store and dynamically display if the energy is at the maximum level.
	 * If the data is updated within this property, JavaFX instantly applies the change, so it's visible in the GUI.
	 *
	 * @see SimpleBooleanProperty
	 */
	private final SimpleBooleanProperty isMaxLevelProperty;


	/**
	 * This field contains the ability modifiers, which are the status effects the player receives in the form of
	 * buffs on the energy ability.
	 *
	 * @see AbilityMultiplier
	 */
	private final AbilityMultiplier abilityMultiplier;


	/**
	 * This field stores the current {@link EnergyLevel} of the ability. The value of this field controls the values of many
	 * attributes the ability consists of.
	 * <br>
	 * Check the constructor {@link EnergyAbility#EnergyAbility()} and the
	 * {@link EnergyAbilityController#updateValues(EnergyAbility)} method to see the control flow.
	 */
	private EnergyLevel currentLevel;


	/**
	 * This field contains the resource price to upgrade the ability to the next level. The price is always denoted
	 * in negative numbers within the
	 * {@link CurrencyTransaction} instance.
	 * <br>
	 * It's important to keep that into account to ensure no algebraic sign issues are coming up. It's not hard to
	 * mess that up, as upgrade costs
	 * could be thought about with a positive algebraic sign instead of a negative one.
	 *
	 * @see CurrencyTransaction
	 */
	private CurrencyTransaction currentUpgradeCost;


	/**
	 * Constructs an instance of this class. The constructor is on the protected API to ensure that subclasses have
	 * access to it, as only subclasses
	 * of this abstract class should be able to create instances of this class.
	 * <br>
	 * It's important to note that the constructor accesses overridable methods of the subclass. These methods provide
	 * the data for the energy ability,
	 * which can then be accessed and used by using the {@link EnergyAbility#currentLevel} as key to retrieve the correct
	 * data for the current level.
	 * <br>
	 * To understand the side effects of these method invocations, read the documentation of this class.
	 */
	@SuppressWarnings ({OVERRIDDEN_METHOD_CALL, OVERRIDABLE_METHOD_CALL})
	protected EnergyAbility ()
	{
		this.currentLevel = EnergyLevel.getMinimum();

		this.currentUpgradeCost = this.getAllUpgradeCosts().get(this.currentLevel);
		this.abilityMultiplier = new AbilityMultiplier(this.getAllModifiers().get(EnergyLevel.getMinimum()));
		this.spriteProperty = new SimpleObjectProperty<>(this.getAllSprites().get(this.currentLevel));
		this.nameProperty = new SimpleStringProperty(this.getAllNames().get(this.currentLevel));
		this.isMaxLevelProperty = new SimpleBooleanProperty(this.currentLevel == EnergyLevel.getMaximum());

		// Logging outputs
		LOGGER.logf(DEBUG, LEVEL_SET_PATTERN, this.currentLevel.name());
		LOGGER.logf(DEBUG, UPGRADE_COST_SET_PATTERN, this.currentUpgradeCost.toString());
		LOGGER.logf(DEBUG, ATTRIBUTE_MODIFIERS_SET_PATTERN, this.abilityMultiplier.toString());
		LOGGER.logf(DEBUG, SPRITE_PROPERTY_SET_PATTERN, this.spriteProperty.toString());
		LOGGER.logf(DEBUG, NAME_PROPERTY_SET_PATTERN, this.nameProperty.get());
	}


	/**
	 * Returns the ability multipliers the energy ability at its current level provides.
	 *
	 * @return The ability multipliers of the energy ability, which are the status effects the player receives in the
	 * form of buffs.
	 * @see AbilityMultiplier
	 */
	public AbilityMultiplier getAbilityMultiplier ()
	{
		return this.abilityMultiplier;
	}


	/**
	 * Returns the map of ability multipliers the energy ability at the supplied level as parameter provides.
	 * <br>
	 * This method is used to be able to access the map of all ability multipliers to be able to set the new values
	 * after an energy ability was upgraded.
	 * <br>
	 * This method is invoked by {@link EnergyAbilityController#updateValues(EnergyAbility)}.
	 *
	 * @param level The energy ability level whose map of ability multipliers should be returned.
	 * @return The map of ability multipliers for the supplied level.
	 */
	public Map<AbilityMultiplier.Type, Double> getAbilityMultipliers (final EnergyLevel level)
	{
		return this.getAllModifiers().get(level);
	}


	/**
	 * Returns the current name of the energy ability. The name changes as it depends on the level of the energy ability.
	 *
	 * @return The current name of the energy ability.
	 */
	@Override
	public String getName ()
	{
		return this.nameProperty.get();
	}


	/**
	 * Sets the name of the energy ability to the supplied name.
	 * <br>
	 * The name is set within the {@link EnergyAbility#nameProperty}, so the name gets automatically updated in the GUI.
	 *
	 * @param name The new name for the energy ability.
	 */
	@Override
	public void setName (final String name)
	{
		this.nameProperty.set(name);
	}


	/**
	 * Returns the name of the energy ability for the supplied {@link EnergyLevel}.
	 *
	 * @param level The energy ability level whose name should be returned.
	 * @return The name of the energy ability for the supplied {@link EnergyLevel}.
	 */
	public String getName (final EnergyLevel level)
	{
		return this.getAllNames().get(level);
	}


	/**
	 * Returns the current sprite of the energy ability.
	 * <br>
	 * The sprite may or may not change. It technically depends on the level of the energy ability, but in some cases, the
	 * same sprite is used for multiple
	 * energy ability levels, hence why it doesn't change visually in that case.
	 *
	 * @return The current sprite of the energy ability.
	 * @see MetaDataImage
	 */
	@Override
	public MetaDataImage getSprite ()
	{
		return this.spriteProperty.get();
	}


	/**
	 * Sets the sprite of the energy ability to the supplied sprite.
	 * <br>
	 * The sprite is set within the {@link EnergyAbility#spriteProperty}, so the sprite gets automatically updated in the
	 * GUI.
	 *
	 * @param sprite The new sprite for the energy ability.
	 */
	@Override
	public void setSprite (final MetaDataImage sprite)
	{
		this.spriteProperty.set(sprite);
	}


	/**
	 * Returns the sprite of the energy ability for the supplied {@link EnergyLevel}.
	 *
	 * @param level The energy ability level whose sprite should be returned.
	 * @return The sprite of the energy ability for the supplied {@link EnergyLevel}.
	 */
	public MetaDataImage getSprite (final EnergyLevel level)
	{
		return this.getAllSprites().get(level);
	}


	/**
	 * Returns the property that contains the name of the energy ability.
	 * <br>
	 * This property is bound to an element in the GUI. Check {@link LaboratoryDelegate#initialize(URL, ResourceBundle)}
	 * to see the binding process.
	 *
	 * @return The property that contains the name of the energy ability.
	 * @see WorkshopDelegate
	 * @see SimpleStringProperty
	 */
	@Override
	public SimpleStringProperty getNameProperty ()
	{
		return this.nameProperty;
	}


	/**
	 * Returns the current sprite property of the energy ability. The sprite may or may not change. It technically depends
	 * on the level of the energy ability, but
	 * in some cases, the same sprite is used for multiple energy ability levels, hence why it doesn't change visually in
	 * that case.
	 * <br>
	 * This property is bound to an element in the GUI. Check {@link LaboratoryDelegate#initialize(URL, ResourceBundle)}
	 * to see the binding process.
	 *
	 * @return The current sprite property of the energy ability.
	 * @see SimpleObjectProperty
	 * @see Image
	 */
	@Override
	public SimpleObjectProperty<MetaDataImage> getSpriteProperty ()
	{
		return this.spriteProperty;
	}


	/**
	 * Returns the property used to store the isMaxLevel data.
	 *
	 * @return The property used to store the isMaxLevel data.
	 */
	public SimpleBooleanProperty getIsMaxLevelProperty ()
	{
		return this.isMaxLevelProperty;
	}


	/**
	 * Sets the isMaxLevel status of the artifact to the supplied boolean value.
	 *
	 * @param value True if the artifact should isMaxLevel, otherwise false.
	 */
	public void setIsMaxLevel (final boolean value)
	{
		this.isMaxLevelProperty.set(value);
	}


	/**
	 * Returns true if the artifact is at the maximum level, otherwise false.
	 *
	 * @return True if the artifact is at the maximum level, otherwise false.
	 */
	public boolean isMaxLevel ()
	{
		return this.isMaxLevelProperty.get();
	}


	/**
	 * Returns the current level of the energy ability.
	 * <br>
	 * Many components of the energy ability are directly dependent on the level, for instance, the value of the
	 * {@link EnergyAbility#nameProperty} and the
	 * {@link EnergyAbility#spriteProperty}. Therefore, the level determines the data of other attributes, as the key in
	 * the 'data maps' which the
	 * subclasses of this class provide is this level and the data is extracted by using this key. The subclasses
	 * provide this data by implementing
	 * the abstract methods {@link EnergyAbility#getAllUpgradeCosts()}, {@link EnergyAbility#getAllNames()},
	 * {@link EnergyAbility#getAllSprites()} and
	 * {@link EnergyAbility#getAllModifiers()}.
	 *
	 * @return The current level of the energy ability.
	 * @see EnergyLevel
	 */
	@Override
	public EnergyLevel getLevel ()
	{
		return this.currentLevel;
	}


	/**
	 * Sets the level of the energy ability to a new level.
	 *
	 * @param level The new level of the artifact in form of an instance of {@link EnergyLevel}.
	 * @see EnergyLevel
	 */
	@Override
	public void setLevel (final EnergyLevel level)
	{
		this.currentLevel = level;
	}


	/**
	 * Returns the current price to upgrade the energy ability.
	 *
	 * @return The current price to upgrade the energy ability to the next level.
	 * @see CurrencyTransaction
	 */
	@Override
	public CurrencyTransaction getUpgradeCosts ()
	{
		return this.currentUpgradeCost;
	}


	/**
	 * Sets the upgrade cost {@link CurrencyTransaction} to a new value, which represents the upgrade costs that are
	 * required to upgrade the energy ability to the next level.
	 * <br>
	 * This method should be invoked each time the energy ability is upgraded, as the upgrade costs usually increase the
	 * higher the energy ability level gets.
	 *
	 * @param upgradeCosts The new upgrade costs the energy ability requires to be upgraded to the next level.
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
	public CurrencyTransaction getUpgradeCosts (final EnergyLevel level)
	{
		return this.getAllUpgradeCosts().get(level);
	}


	/**
	 * Returns all upgrade cost {@link CurrencyTransaction}'s which are used to determine whether the player can or
	 * can't upgrade the energy ability
	 * depending on the number of currencies he owns.
	 * <br>
	 * These {@link CurrencyTransaction}'s are sorted by the {@link EnergyLevel} as key within this {@link Map},
	 * allowing for easy access by using
	 * this meaningful key ({@link EnergyLevel}).
	 *
	 * @return The {@link Map} which contains all upgrade cost transactions for the energy ability.
	 * @see Map
	 * @see EnergyLevel
	 * @see CurrencyTransaction
	 */
	@NotNull
	protected abstract Map<EnergyLevel, CurrencyTransaction> getAllUpgradeCosts ();


	/**
	 * Returns all possible names the energy ability can have.
	 * An energy ability has different names depending on its level.
	 * <br>
	 * Therefore, these names are sorted by the {@link EnergyLevel} as key in a {@link Map}, allowing for easy
	 * access by using this meaningful key
	 * ({@link EnergyLevel}).
	 *
	 * @return The {@link Map} which contains all names for the energy ability.
	 * @see Map
	 * @see EnergyLevel
	 */
	@NotNull
	protected abstract Map<EnergyLevel, String> getAllNames ();


	/**
	 * Returns all sprites the energy ability can have.
	 * An energy ability can, but not necessarily, have different sprites depending on its level.
	 * <br>
	 * Therefore, these sprites are sorted by the {@link EnergyLevel} as key in a {@link Map}, allowing for easy
	 * access by using this meaningful key
	 * ({@link EnergyLevel}).
	 *
	 * @return The {@link Map} which contains all sprites for the energy ability.
	 * @see Map
	 * @see EnergyLevel
	 * @see Image
	 */
	@NotNull
	protected abstract Map<EnergyLevel, MetaDataImage> getAllSprites ();


	/**
	 * Returns all sets of modifiers the energy ability can have, depending on it's level.
	 * <br>
	 * Therefore, these sets of modifiers are sorted by the {@link EnergyLevel} as key in a {@link Map}, allowing
	 * for easy access by using this
	 * meaningful key ({@link EnergyLevel}).
	 *
	 * @return The {@link Map} which contains all different sets of modifiers the energy ability can have, depending on it's
	 * level.
	 * @see Map
	 * @see EnergyLevel
	 * @see AbilityMultiplier.Type
	 */
	@NotNull
	protected abstract Map<EnergyLevel, Map<AbilityMultiplier.Type, Double>> getAllModifiers ();


	/**
	 * Builds a formatted {@link String}, which represents the object, and it's current state using the
	 * {@link EnergyAbility#TO_STRING_PATTERN}.
	 *
	 * @return A {@link String} which has been formatted in the {@link EnergyAbility#TO_STRING_PATTERN}.
	 * @precondition The {@link EnergyAbility#TO_STRING_PATTERN} is {@code != null}.
	 * @postcondition The method returned a {@link String} which represents the object.
	 */
	@Override
	public String toString ()
	{
		return MessageFormat.format(TO_STRING_PATTERN, this.nameProperty.get(), this.spriteProperty.get()
				.toString(), this.isMaxLevelProperty.get(), this.abilityMultiplier.toString(),
			this.currentLevel.toString(),
			this.currentUpgradeCost.toString());
	}
}