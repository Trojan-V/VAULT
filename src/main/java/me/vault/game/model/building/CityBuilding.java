package me.vault.game.model.building;


import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import me.vault.game.control.CityBuildingController;
import me.vault.game.interfaces.Displayable;
import me.vault.game.interfaces.Nameable;
import me.vault.game.interfaces.Upgradable;
import me.vault.game.model.artifact.Artifact;
import me.vault.game.model.currency.CurrencyTransaction;
import me.vault.game.utility.struct.MetaDataImage;
import org.jetbrains.annotations.NotNull;

import java.text.MessageFormat;
import java.util.Map;

import static me.vault.game.utility.constant.SupressionConstants.OVERRIDABLE_METHOD_CALL;
import static me.vault.game.utility.constant.SupressionConstants.OVERRIDDEN_METHOD_CALL;


/**
 * Description
 *
 * @author Vincent Wolf, Lasse-Leander Hillen, Timothy Hoegen-Jupp, Alexander Goethel
 * @version 1.0.0
 * @see CityBuildingLevel
 * @since 06.06.2024
 */
public abstract class CityBuilding implements Displayable, Nameable, Upgradable<CityBuildingLevel>
{

	/**
	 * The {@link MessageFormat} pattern, which is used, when the {@link Artifact#toString()} is called.
	 */
	private static final String TO_STRING_PATTERN = "CityBuilding'{'nameProperty={0}, spriteProperty={1}, " +
	                                                "isMaxLevelProperty={2}, currentLevel={3}, currentUpgradeCost={4}'}'";


	/**
	 * This property is used to store and dynamically display the name of the city building.
	 * If the name is updated within this property, JavaFX instantly applies the change, so it's visible in the GUI.
	 */
	private final SimpleStringProperty nameProperty;


	/**
	 * This property is used to store and dynamically display the sprite of the city building.
	 * If the sprite is updated within this property, JavaFX instantly applies the change, so it's visible in the GUI.
	 */
	private final SimpleObjectProperty<MetaDataImage> spriteProperty;


	/**
	 * This property is used to store and dynamically display if the city building is at the maximum level.
	 * If the data is updated within this property, JavaFX instantly applies the change, so it's visible in the GUI.
	 */
	private final SimpleBooleanProperty isMaxLevelProperty;


	/**
	 * This field stores the current level of the city building.
	 * The value of this field controls the values of many attributes the city building consists of.
	 * <br>
	 * Check the constructor {@link CityBuilding#CityBuilding()} and the
	 * {@link CityBuildingController#updateValues(CityBuilding)} method to see the control flow.
	 */
	private CityBuildingLevel currentLevel;


	/**
	 * This field contains the resource price to upgrade the city building to the next level.
	 * The price is always denoted in negative numbers within the {@link CurrencyTransaction} instance.
	 * <br>
	 * It's important to keep that into account to ensure no algebraic sign issues are coming up.
	 * It's not hard to mess that up, as upgrade costs could be thought about with a positive algebraic sign instead
	 * of a negative one.
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
	 *
	 * @precondition The CityBuilding constructor was called from a subclass.
	 * @postcondition A new instance of the CityBuilding was created.
	 */
	@SuppressWarnings ({OVERRIDDEN_METHOD_CALL, OVERRIDABLE_METHOD_CALL})
	protected CityBuilding ()
	{
		this.currentLevel = CityBuildingLevel.getMinimum();
		this.currentUpgradeCost = this.getAllUpgradeCosts().get(this.currentLevel);
		this.nameProperty = new SimpleStringProperty(this.getAllNames().get(this.currentLevel));
		this.spriteProperty = new SimpleObjectProperty<>(this.getAllSprites().get(this.currentLevel));
		this.isMaxLevelProperty = new SimpleBooleanProperty(this.currentLevel == CityBuildingLevel.getMaximum());
	}


	/**
	 * Returns the sprite for the supplied level of the city building.
	 *
	 * @param level The level whose sprite should be returned.
	 *
	 * @return The sprite for the supplied level.
	 *
	 * @precondition A {@link CityBuildingLevel} is passed into the method.
	 * @postcondition The corresponding sprite for the {@link CityBuildingLevel} was returned.
	 */
	public MetaDataImage getSprite (final CityBuildingLevel level)
	{
		return this.getAllSprites().get(level);
	}


	/**
	 * Returns true if the city building is at the maximum level, otherwise false.
	 *
	 * @return True if the city building is at the maximum level, otherwise false.
	 *
	 * @precondition Method gets called and the isMaxLevelProperty has been set within the instance.
	 * @postcondition A boolean gets returned, that describes, if the Citybuilding is already at the maximum level.
	 */
	public boolean isMaxLevel ()
	{
		return this.isMaxLevelProperty.get();
	}


	/**
	 * Sets the isMaxLevel status of the city building to the supplied boolean value.
	 *
	 * @param value True if the city building should be at the maximum level, otherwise false.
	 *
	 * @precondition A valid boolean value is passed into the method.
	 * @postcondition The isMaxLevelProperty attribute within the object is set to the passed value.
	 */
	public void setIsMaxLevel (final boolean value)
	{
		this.isMaxLevelProperty.set(value);
	}


	/**
	 * Returns the property used to store the isMaxLevel data.
	 *
	 * @return The property used to store the isMaxLevel data.
	 *
	 * @precondition Method gets called and the isMaxLevelProperty has been set within the instance.
	 * @postcondition The isMaxLevelProperty of the object has been returned.
	 */
	public SimpleBooleanProperty getIsMaxLevelProperty ()
	{
		return this.isMaxLevelProperty;
	}


	/**
	 * Returns the name for the supplied level of the city building.
	 *
	 * @param level The level whose name should be returned.
	 *
	 * @return The name for the supplied level.
	 *
	 * @precondition A {@link CityBuildingLevel} is passed into the method.
	 * @postcondition The corresponding name for the {@link CityBuildingLevel} was returned.
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
	@Override
	public SimpleStringProperty getNameProperty ()
	{
		return this.nameProperty;
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


	/**
	 * {@inheritDoc}
	 */
	@Override
	public CurrencyTransaction getUpgradeCosts (final CityBuildingLevel level)
	{
		return this.getAllUpgradeCosts().get(level);
	}


	/**
	 * This method provides a {@link Map} of all {@link CurrencyTransaction}s which are mapped to the {@link CityBuildingLevel} they belong to.
	 * These {@link CurrencyTransaction}s represent the upgrade costs to upgrade the city building to the next level.
	 * <br>
	 * It is important that the {@link Map} of {@link CurrencyTransaction}s that is returned by this method is ready before this method gets invoked.
	 * <br>
	 * As this method is invoked within the constructor of this class to extract the data from it, the map can't be created during the instantiation of the
	 * subclass, as the constructor of this class will always be invoked first (because the first call in the constructor of a subclass is always a call to
	 * the constructor of the superclass).
	 * <br>
	 * Therefore, this {@link Map} has to be created during class initialization instead of instance initialization.
	 * <br>
	 * Due to that,every subclass of this class declares a static block where the order of operations during the class initialization is written.
	 * Note that the singleton instance of the subclass is getting created last, so it's ensured that this {@link Map} is filled with data.
	 *
	 * @return A {@link Map} of all {@link CurrencyTransaction}s which are mapped to the {@link CityBuildingLevel} they belong to.
	 * These key-value combinations represent the upgrade costs to upgrade the city building to the next level.
	 *
	 * @precondition The method has been implemented by a subclass and is called from there.
	 * @postcondition A Map with the CityBuildingLevels as keys and the CurrencyTransactions as values of all the different upgrade costs is returned.
	 */
	@NotNull
	public abstract Map<CityBuildingLevel, CurrencyTransaction> getAllUpgradeCosts ();


	/**
	 * This method provides a {@link Map} of all {@link String}s that are mapped to the {@link CityBuildingLevel} they belong to.
	 * These {@link String}s represent the name of the city building at the selected level.
	 * <br>
	 * It is important that the {@link Map} of {@link String}s that is returned by this method is ready before this method gets invoked.
	 * <br>
	 * As this method is invoked within the constructor of this class to extract the data from it, the map can't be created during the instantiation of the
	 * subclass, as the constructor of this class will always be invoked first (because the first call in the constructor of a subclass is always a call to
	 * the constructor of the superclass).
	 * <br>
	 * Therefore, this {@link Map} has to be created during class initialization instead of instance initialization.
	 * <br>
	 * Due to that,every subclass of this class declares a static block where the order of operations during the class initialization is written.
	 * Note that the singleton instance of the subclass is getting created last, so it's ensured that this {@link Map} is filled with data.
	 *
	 * @return A {@link Map} of all {@link String}s which are mapped to the {@link CityBuildingLevel} they belong to.
	 * These key-value combinations represent the name of the city building at the selected level.
	 *
	 * @precondition The method has been implemented by a subclass and is called from there.
	 * @postcondition A Map with the CityBuildingLevels as keys and the Name-String as values of all the different upgrade costs is returned.
	 */
	@NotNull
	public abstract Map<CityBuildingLevel, String> getAllNames ();


	/**
	 * This method provides a {@link Map} of all {@link MetaDataImage}s that are mapped to the {@link CityBuildingLevel} they belong to.
	 * These {@link MetaDataImage}s represent the sprite of the city building at the selected level.
	 * <br>
	 * It is important that the {@link Map} of {@link MetaDataImage}s that is returned by this method is ready before this method gets invoked.
	 * <br>
	 * As this method is invoked within the constructor of this class to extract the data from it, the map can't be created during the instantiation of the
	 * subclass, as the constructor of this class will always be invoked first (because the first call in the constructor of a subclass is always a call to
	 * the constructor of the superclass).
	 * <br>
	 * Therefore, this {@link Map} has to be created during class initialization instead of instance initialization.
	 * <br>
	 * Due to that,every subclass of this class declares a static block where the order of operations during the class initialization is written.
	 * Note that the singleton instance of the subclass is getting created last, so it's ensured that this {@link Map} is filled with data.
	 *
	 * @return A {@link Map} of all {@link MetaDataImage}s which are mapped to the {@link CityBuildingLevel} they belong to.
	 * These key-value combinations represent the sprite of the city building at the selected level.
	 *
	 * @precondition The method has been implemented by a subclass and is called from there.
	 * @postcondition A Map with the CityBuildingLevels as keys and the MetaDataImages as values of all the different upgrade costs is returned.
	 */
	@NotNull
	public abstract Map<CityBuildingLevel, MetaDataImage> getAllSprites ();


	/**
	 * Builds a formatted {@link String}, which represents the object, and it's current state using the
	 * {@link CityBuilding#TO_STRING_PATTERN}.
	 *
	 * @return A {@link String} which has been formatted in the {@link CityBuilding#TO_STRING_PATTERN}.
	 *
	 * @precondition The {@link CityBuilding#TO_STRING_PATTERN} is {@code != null}.
	 * @postcondition The method returned a {@link String} which represents the object.
	 */
	@Override
	public String toString ()
	{
		return MessageFormat.format(TO_STRING_PATTERN, this.nameProperty.get(), this.spriteProperty.get()
			.toString(), this.isMaxLevelProperty.get(), this.currentLevel.toString(), this.currentUpgradeCost.toString());
	}

}
