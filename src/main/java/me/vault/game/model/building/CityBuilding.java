package me.vault.game.model.building;


import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.Scene;
import me.vault.game.control.CityBuildingController;
import me.vault.game.interfaces.Displayable;
import me.vault.game.interfaces.Nameable;
import me.vault.game.interfaces.Upgradable;
import me.vault.game.model.currency.CurrencyTransaction;
import me.vault.game.utility.struct.MetaDataImage;
import org.jetbrains.annotations.NotNull;

import java.util.Map;


/**
 * Description
 *
 * @author Vincent Wolf
 * @version 1.0.0
 * @see CityBuildingLevel
 * @since 06.06.2024
 */
public abstract class CityBuilding implements Displayable, Nameable, Upgradable<CityBuildingLevel>
{

	/**
	 * This property is used to store and dynamically display the name of the city building.
	 * If the name is updated within this property, JavaFX instantly applies the change, so it's visible in the GUI.
	 *
	 * @see SimpleStringProperty
	 */
	private final SimpleStringProperty nameProperty;


	/**
	 * This property is used to store and dynamically display the sprite of the city building.
	 * If the sprite is updated within this property, JavaFX instantly applies the change, so it's visible in the GUI.
	 *
	 * @see SimpleObjectProperty
	 * @see MetaDataImage
	 */
	private final SimpleObjectProperty<MetaDataImage> spriteProperty;

	private final SimpleBooleanProperty isMaxLevelProperty;

	private final Scene scene;


	/**
	 * This field stores the current level of the city building.
	 * The value of this field controls the values of many attributes the city building consists of.
	 * <br>
	 * Check the constructor {@link CityBuilding#CityBuilding()} and the
	 * {@link CityBuildingController#updateValues(CityBuilding)} method to see the
	 * control flow.
	 *
	 * @see CityBuildingLevel
	 */
	private CityBuildingLevel currentLevel;


	/**
	 * This field contains the resource price to upgrade the city building to the next level.
	 * The price is always denoted in negative numbers within the {@link CurrencyTransaction} instance.
	 * <br>
	 * It's important to keep that into account to ensure no algebraic sign issues are coming up.
	 * It's not hard to mess that up, as upgrade costs could be thought about with a positive algebraic sign instead
	 * of a negative one.
	 *
	 * @see CurrencyTransaction
	 */
	private CurrencyTransaction currentUpgradeCost;


	/**
	 * Constructs an instance of this class.
	 * <br>
	 * It's important to note that the constructor accesses overridable methods of the subclass. These methods provide
	 * the data for the city building,
	 * which can then be accessed and used by using the {@link CityBuilding#currentLevel} as key to retrieve the
	 * correct data for the current
	 * level.
	 * <br>
	 * To understand the side effects of these method invocations, read the documentation of this class.
	 */
	protected CityBuilding ()
	{
		// TODO: currentLevel aus Config einlesen
		this.currentLevel = CityBuildingLevel.getMinLevel();
		this.scene = this.getScene();

		this.currentUpgradeCost = this.getAllUpgradeCosts().get(this.currentLevel);
		this.nameProperty = new SimpleStringProperty(this.getAllNames().get(this.currentLevel));
		this.spriteProperty = new SimpleObjectProperty<>(this.getAllSprites().get(this.currentLevel));
		this.isMaxLevelProperty = new SimpleBooleanProperty(this.currentLevel == CityBuildingLevel.getMaxLevel());
	}


	/**
	 * {@inheritDoc}
	 * Returns the name for the current level of the city building.
	 */
	@Override
	public String getName ()
	{
		return this.nameProperty.get();
	}


	// TODO: Vielleicht ins Interface Nameable schieben.


	@Override
	public void setName (final String name)
	{
		this.nameProperty.set(name);
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
	 * Returns the name for the supplied level of the city building.
	 *
	 * @param level The level whose name should be returned.
	 *
	 * @return The name for the supplied level.
	 */
	public String getName (final CityBuildingLevel level)
	{
		return this.getAllNames().get(level);
	}


	/**
	 * {@inheritDoc}
	 * Returns the name for the current level of the city building.
	 */
	@Override
	public MetaDataImage getSprite ()
	{
		return this.spriteProperty.get();
	}


	@Override
	public void setSprite (final MetaDataImage sprite)
	{
		this.spriteProperty.set(sprite);
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
	public CityBuildingLevel getLevel ()
	{
		return this.currentLevel;
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setLevel (final CityBuildingLevel level)
	{
		this.currentLevel = level;
	}


	/**
	 * Returns the sprite for the supplied level of the city building.
	 *
	 * @param level The level whose sprite should be returned.
	 *
	 * @return The sprite for the supplied level.
	 */
	public MetaDataImage getSprite (final CityBuildingLevel level)
	{
		return this.getAllSprites().get(level);
	}


	public boolean isMaxLevel ()
	{
		return this.isMaxLevelProperty.get();
	}


	public void setIsMaxLevel (final boolean value)
	{
		this.isMaxLevelProperty.set(value);
	}


	public SimpleBooleanProperty getMaxLevelProperty ()
	{
		return this.isMaxLevelProperty;
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public CurrencyTransaction getUpgradeCosts ()
	{
		return this.currentUpgradeCost;
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setUpgradeCosts (final CurrencyTransaction upgradeCosts)
	{
		this.currentUpgradeCost = upgradeCosts;
	}


	@Override
	public CurrencyTransaction getUpgradeCosts (final CityBuildingLevel level)
	{
		return this.getAllUpgradeCosts().get(level);
	}


	// TODO: Interface Layer?
	@NotNull
	public abstract Map<CityBuildingLevel, CurrencyTransaction> getAllUpgradeCosts ();


	@NotNull
	public abstract Map<CityBuildingLevel, String> getAllNames ();


	@NotNull
	public abstract Map<CityBuildingLevel, MetaDataImage> getAllSprites ();


	@NotNull
	public abstract Scene getScene ();

}
