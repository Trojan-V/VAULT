package me.vault.game.model.energy;


import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import me.vault.game.interfaces.Nameable;
import me.vault.game.interfaces.Upgradable;
import me.vault.game.model.GameMap;
import me.vault.game.model.Vertex;
import me.vault.game.model.currency.CurrencyTransaction;
import me.vault.game.model.mission.MapObject;
import me.vault.game.model.troop.Faction;
import me.vault.game.model.troop.TroopStatistic;
import me.vault.game.utility.logging.Logger;
import me.vault.game.utility.struct.MetaDataImage;
import org.jetbrains.annotations.NotNull;

import java.util.Map;


public abstract class Energy implements Nameable, Upgradable<EnergyLevel>, MapObject
{

	/**
	 * The {@link Logger} object for this class used for writing to the console.
	 */
	private static final Logger LOGGER = new Logger(Energy.class.getSimpleName());

	/**
	 * This {@link SimpleObjectProperty <>} is used to store and dynamically display the sprite ({@link MetaDataImage}) of the troop.
	 * If the sprite is updated within this property, JavaFX instantly applies the change, so it's visible in the GUI.
	 */
	private final SimpleObjectProperty<MetaDataImage> spriteProperty;

	/**
	 * This {@link SimpleBooleanProperty} is used to store and dynamically display the boolean value if the troop is already at max level.
	 * If the boolean value is updated within this property, JavaFX instantly applies the change, so it's visible in the GUI.
	 */
	private final SimpleBooleanProperty isMaxLevelProperty;

	/**
	 * This {@link SimpleStringProperty} is used to store and dynamically display the name of the troop.
	 * If the name is updated within this property, JavaFX instantly applies the change, so it's visible in the GUI.
	 */
	private final SimpleStringProperty nameProperty;

	private final TroopStatistic statistic;


	/**
	 * This field contains the resource price to upgrade the energy ability to the next level.
	 * The price is always denoted in negative numbers within the {@link CurrencyTransaction} instance.
	 * <br>
	 * It's important to keep that into account to ensure no algebraic sign issues are coming up.
	 * It's not hard to mess that up, as upgrade costs could be thought about with a positive algebraic sign instead of a negative one.
	 */
	private CurrencyTransaction upgradeCost;

	/**
	 * This field stores the current {@link EnergyLevel} of the troop. The value of this field controls the values of many
	 * attributes the troop consists of.
	 * <br>
	 * Check the constructor and the {@link EnergyController#updateValues(Energy)} method to see the control flow.
	 */
	private EnergyLevel currentLevel;


	protected Energy (final TroopStatistic statistic)
	{
		this.currentLevel = EnergyLevel.getMinimum();
		this.upgradeCost = this.getAllUpgradeCosts().get(this.currentLevel);
		this.nameProperty = new SimpleStringProperty(this.getAllNames().get(this.currentLevel));
		this.spriteProperty = new SimpleObjectProperty<>(this.getAllSprites().get(this.currentLevel));
		this.isMaxLevelProperty = new SimpleBooleanProperty(this.currentLevel == EnergyLevel.getMaxLevel());
		this.statistic = statistic;
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public EnergyLevel getLevel ()
	{
		return this.currentLevel;
	}


	public SimpleBooleanProperty getIsMaxLevelProperty ()
	{
		return this.isMaxLevelProperty;
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setLevel (final EnergyLevel level)
	{
		this.currentLevel = level;
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
	public CurrencyTransaction getUpgradeCosts (final EnergyLevel level)
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


	public MetaDataImage getSprite (final EnergyLevel level)
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


	public String getName (final EnergyLevel level)
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
	 * Returns all upgrade cost {@link CurrencyTransaction}'s which are used to determine whether the player can or
	 * can't upgrade the energy depending on the number of currencies he owns.
	 * <br>
	 * These {@link CurrencyTransaction}'s are sorted by the {@link EnergyLevel} as key within this {@link Map},
	 * allowing for easy access by using this meaningful key ({@link EnergyLevel}).
	 *
	 * @return The {@link Map} which contains all upgrade cost transactions for the energy.
	 */
	@NotNull
	protected abstract Map<EnergyLevel, CurrencyTransaction> getAllUpgradeCosts ();


	/**
	 * Returns all names the energy can have. A troop has different names depending on its level.
	 * <br>
	 * Therefore, these names are sorted by the {@link EnergyLevel} as key in a {@link Map}, allowing for easy
	 * access by using this meaningful key ({@link EnergyLevel}).
	 *
	 * @return The {@link Map} which contains all names for the energy.
	 */
	@NotNull
	protected abstract Map<EnergyLevel, String> getAllNames ();


	/**
	 * Returns all sprites the energy can have. A troop can have, but doesn't always have, different sprites
	 * depending on its level.
	 * <br>
	 * Therefore, these sprites are sorted by the {@link EnergyLevel} as key in a {@link Map}, allowing for easy
	 * access by using this meaningful key ({@link EnergyLevel}).
	 *
	 * @return The {@link Map} which contains all sprites for the energy.
	 */
	@NotNull
	protected abstract Map<EnergyLevel, MetaDataImage> getAllSprites ();


//	public EnergyStatistic getStatistic ()
//	{
//		return this.statistic;
//	}


	public void setIsMaxLevel (final boolean value)
	{
		this.isMaxLevelProperty.set(value);
	}


}