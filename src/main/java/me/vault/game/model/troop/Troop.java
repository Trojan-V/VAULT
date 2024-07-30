package me.vault.game.model.troop;


import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import me.vault.game.control.TroopController;
import me.vault.game.interfaces.Nameable;
import me.vault.game.interfaces.Placeable;
import me.vault.game.interfaces.Upgradable;
import me.vault.game.model.arena.Figure;
import me.vault.game.model.currency.CurrencyTransaction;
import me.vault.game.utility.struct.MetaDataImage;
import org.jetbrains.annotations.NotNull;

import java.text.MessageFormat;
import java.util.Map;

import static me.vault.game.utility.constant.SuppressionConstants.OVERRIDABLE_METHOD_CALL;
import static me.vault.game.utility.constant.SuppressionConstants.OVERRIDDEN_METHOD_CALL;


/**
 * This class is a blueprint for troops.
 * Do not confuse troops with {@link Figure}s, these are not used for the same thing.
 * <br>
 * A {@link Figure} is essentially a wrapper for a troop, so the data of the troop does not need to be manipulated, as the troop should constantly keep the
 * same set of data.
 * The troop is basically what's displayed in the city in the building where the troops can be selected (i.e., before selecting the mission).
 * {@link Figure}s on the other side carry the same statistics that the troop has, but the statistics of the {@link Figure}s are going to be manipulated
 * during the arena encounters to reflect attacks that happen in the battles.
 * <br>
 * To sum up, {@link Figure}s are fighting against each other, while troops are just the models that can be selected.
 * <br>
 * These selected troop models will then be spawned on the game board of the arena and can fight against each other.
 *
 * @author Vincent Wolf
 * @version 1.0.0
 * @see Figure
 * @see Upgradable
 * @see TroopController
 * @see TroopLevel
 * @see TroopStatistics
 * @see Placeable
 * @see Nameable
 * @since 30.07.2024
 */
public abstract class Troop implements Upgradable<TroopLevel>, Placeable, Nameable
{

	/**
	 * The {@link MessageFormat} pattern, which is used, when the {@link Troop#toString()} is
	 * called.
	 */
	private static final String TO_STRING_PATTERN =
		"Troop'{'nameProperty={0}, spriteProperty={1}, isMaxLevelProperty={2}, faction={3}, currentLevel={4}, statistics={5}, upgradeCost={6}'}'";


	/**
	 * This {@link SimpleStringProperty} is used to store and dynamically display the name of the troop.
	 * If the name is updated within this property, JavaFX instantly applies the change, so it's visible in the GUI.
	 */
	private final SimpleStringProperty nameProperty;


	/**
	 * This {@link SimpleObjectProperty<>} is used to store and dynamically display the sprite ({@link MetaDataImage}) of the troop.
	 * If the sprite is updated within this property, JavaFX instantly applies the change, so it's visible in the GUI.
	 */
	private final SimpleObjectProperty<MetaDataImage> spriteProperty;


	/**
	 * This {@link SimpleBooleanProperty} is used to store and dynamically display the boolean value if the troop is already at max level.
	 * If the boolean value is updated within this property, JavaFX instantly applies the change, so it's visible in the GUI.
	 */
	private final SimpleBooleanProperty isMaxLevelProperty;


	/**
	 * The {@link Faction} the troop is a member of. Every troop can only belong to one faction.
	 */
	private final Faction faction;


	/**
	 * This field stores the current {@link TroopLevel} of the troop. The value of this field controls the values of many
	 * attributes the troop consists of.
	 * <br>
	 * Check the constructor and the {@link TroopController#updateValues(Troop)} method to see the control flow.
	 */
	private TroopLevel currentLevel;


	/**
	 * The statistics of the troop.
	 * <br>
	 * These are the values that are important in the arena encounters, as they decide how much damage is dealt, how much range the troop has, how fast it is,
	 * etc.
	 */
	private TroopStatistics statistics;


	/**
	 * This field contains the resource price to upgrade the troop to the next level.
	 * The price is always denoted in negative numbers within the {@link CurrencyTransaction} instance.
	 * <br>
	 * It's important to keep that into account to ensure no algebraic sign issues are coming up.
	 * It's not hard to mess that up, as upgrade costs could be thought about with a positive algebraic sign instead of a negative one.
	 */
	private CurrencyTransaction upgradeCost;


	/**
	 * Constructs an instance of this class.
	 * The constructor is on the protected API to ensure that subclasses have access to it, as only subclasses
	 * of this abstract class should be able to create instances of this class.
	 * <br>
	 * It's important to note that the constructor accesses overridable methods of the subclass.
	 * These methods provide the data for the troop, which can then be accessed and used by using the {@link Troop#currentLevel} as key to retrieve the
	 * correct data for the current level.
	 * <br>
	 *
	 * @param faction The {@link Faction} the troop is member of.
	 */
	@SuppressWarnings ({OVERRIDDEN_METHOD_CALL, OVERRIDABLE_METHOD_CALL})
	protected Troop (final Faction faction)
	{
		this.currentLevel = TroopLevel.getMinimum();
		this.upgradeCost = this.getAllUpgradeCosts().get(this.currentLevel);
		this.nameProperty = new SimpleStringProperty(this.getAllNames().get(this.currentLevel));
		this.spriteProperty = new SimpleObjectProperty<>(this.getAllSprites().get(this.currentLevel));
		this.isMaxLevelProperty = new SimpleBooleanProperty(this.currentLevel == TroopLevel.getMaximum());
		this.statistics = this.getAllStatistics().get(this.currentLevel);
		this.faction = faction;
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public TroopLevel getLevel ()
	{
		return this.currentLevel;
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setLevel (final TroopLevel level)
	{
		this.currentLevel = level;
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
	 * {@inheritDoc}
	 */
	@Override
	public CurrencyTransaction getUpgradeCosts ()
	{
		return this.upgradeCost;
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setUpgradeCosts (final CurrencyTransaction upgradeCosts)
	{
		this.upgradeCost = upgradeCosts;
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public CurrencyTransaction getUpgradeCosts (final TroopLevel level)
	{
		return this.getAllUpgradeCosts().get(level);
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
	 * Returns the sprite of the troop for the supplied {@link TroopLevel}.
	 *
	 * @param level The {@link TroopLevel} whose sprite should be returned.
	 * @return The sprite of the troop for the supplied {@link TroopLevel}.
	 */
	public MetaDataImage getSprite (final TroopLevel level)
	{
		return this.getAllSprites().get(level);
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
	 * Returns the current name of the troop. The name changes as it depends on the level of the troop.
	 *
	 * @param level The {@link TroopLevel} whose name should be returned.
	 * @return The current name of the troop.
	 */
	public String getName (final TroopLevel level)
	{
		return this.getAllNames().get(level);
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
	 * Returns the {@link Faction} the troop is member of.
	 *
	 * @return The {@link Faction} the troop is member of.
	 */
	public Faction getFaction ()
	{
		return this.faction;
	}


	/**
	 * Returns all upgrade cost {@link CurrencyTransaction}'s which are used to determine whether the player can or
	 * can't upgrade the troop depending on the number of currencies he owns.
	 * <br>
	 * These {@link CurrencyTransaction}'s are sorted by the {@link TroopLevel} as key within this {@link Map},
	 * allowing for easy access by using this meaningful key ({@link TroopLevel}).
	 *
	 * @return The {@link Map} which contains all upgrade cost transactions for the troop.
	 */
	@NotNull
	protected abstract Map<TroopLevel, CurrencyTransaction> getAllUpgradeCosts ();


	/**
	 * Returns all names the troop can have. A troop has different names depending on its level.
	 * <br>
	 * Therefore, these names are sorted by the {@link TroopLevel} as key in a {@link Map}, allowing for easy
	 * access by using this meaningful key ({@link TroopLevel}).
	 *
	 * @return The {@link Map} which contains all names for the troop.
	 */
	@NotNull
	protected abstract Map<TroopLevel, String> getAllNames ();


	/**
	 * Returns all sprites the troop can have. A troop can have, but doesn't always have, different sprites
	 * depending on its level.
	 * <br>
	 * Therefore, these sprites are sorted by the {@link TroopLevel} as key in a {@link Map}, allowing for easy
	 * access by using this meaningful key ({@link TroopLevel}).
	 *
	 * @return The {@link Map} which contains all sprites for the troop.
	 */
	@NotNull
	protected abstract Map<TroopLevel, MetaDataImage> getAllSprites ();


	/**
	 * Returns all statistics the troop can have.
	 * Depending on the level, the statistics of the troop change.
	 * <br>
	 * Therefore, these statistics are sorted by the {@link TroopLevel} as key in a {@link Map}, allowing for easy
	 * access by using this meaningful key ({@link TroopLevel}).
	 *
	 * @return The {@link Map} which contains all statistics for the troop.
	 */
	@NotNull
	protected abstract Map<TroopLevel, TroopStatistics> getAllStatistics ();


	/**
	 * Returns the current statistics of the troop.
	 *
	 * @return The current statistics of the troop.
	 */
	public TroopStatistics getStatistics ()
	{
		return this.statistics;
	}


	/**
	 * Sets the current statistics of the troop.
	 *
	 * @param statistics The statistics that'll be applied to the troop.
	 */
	public void setStatistics (final TroopStatistics statistics)
	{
		this.statistics = statistics;
	}


	/**
	 * Returns the current statistics of the troop for the supplied {@link TroopLevel}.
	 *
	 * @param level The {@link TroopLevel} whose statistics should be returned.
	 * @return The current statistics of the troop for the supplied {@link TroopLevel}.
	 */
	public TroopStatistics getStatistics (final TroopLevel level)
	{
		return this.getAllStatistics().get(level);
	}


	/**
	 * Sets the isMaxLevel status of the troop to the supplied boolean value.
	 *
	 * @param value True if the troop should be marked as max level, otherwise false.
	 */
	public void setIsMaxLevel (final boolean value)
	{
		this.isMaxLevelProperty.set(value);
	}


	/**
	 * Builds a formatted {@link String}, which represents the object, and it's current state using the
	 * {@link Troop#TO_STRING_PATTERN}.
	 *
	 * @return A {@link String} which has been formatted in the {@link Troop#TO_STRING_PATTERN}.
	 * @precondition The {@link Troop#TO_STRING_PATTERN} is {@code != null}.
	 * @postcondition The method returned a {@link String} which represents the object.
	 */
	@Override
	public String toString ()
	{
		return MessageFormat.format(TO_STRING_PATTERN, this.nameProperty.get(), this.spriteProperty.get()
				.toString(), this.isMaxLevelProperty.get(), this.faction.toString(),
			this.currentLevel.toString(),
			this.statistics.toString(),
			this.upgradeCost.toString());
	}
}
