package me.vault.game.model.building;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import me.vault.game.interfaces.Displayable;
import me.vault.game.model.currency.CurrencyTransaction;
import me.vault.game.utility.struct.MetaDataImage;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

/**
 * Description
 *
 * @author Vincent Wolf
 * @version 1.0.0
 * @see
 * @since 06.06.2024
 */
public abstract class AbsCityBuilding implements Displayable
{
	/**
	 * This property is used to store and dynamically display the name of the city building. If the name is updated within this property, JavaFX
	 * instantly applies the change, so it's visible in the GUI.
	 *
	 * @see SimpleStringProperty
	 */
	private final SimpleStringProperty nameProperty;

	/**
	 * This property is used to store and dynamically display the sprite of the city building. If the sprite is updated within this property, JavaFX
	 * instantly applies the change, so it's visible in the GUI.
	 *
	 * @see SimpleObjectProperty
	 * @see MetaDataImage
	 */
	private final SimpleObjectProperty<MetaDataImage> spriteProperty;

	private final Scene scene;

	/**
	 * This field stores the current level of the city building. The value of this field controls the values of many attributes the city building
	 * consists of.
	 * <br>
	 * Check the constructor {@link AbsCityBuilding#AbsCityBuilding()} and the {@link AbsCityBuilding#updatePropertyValues()} method to see the
	 * control flow.
	 *
	 * @see CityBuildingLevel
	 */
	private final CityBuildingLevel currentLevel;

	/**
	 * This field contains the resource price to upgrade the city building to the next level. The price is always denoted in negative numbers within
	 * the {@link CurrencyTransaction} instance.
	 * <br>
	 * It's important to keep that into account to ensure no algebraic sign issues are coming up. It's not hard to mess that up, as upgrade costs
	 * could be thought about with a positive algebraic sign instead of a negative one.
	 *
	 * @see CurrencyTransaction
	 */
	private CurrencyTransaction currentUpgradeCost;


	/**
	 * Constructs an instance of this class.
	 * <br>
	 * It's important to note that the constructor accesses overridable methods of the subclass. These methods provide the data for the city building,
	 * which can then be accessed and used by using the {@link AbsCityBuilding#currentLevel} as key to retrieve the correct data for the current
	 * level.
	 * <br>
	 * To understand the side effects of these method invocations, read the documentation of this class.
	 */
	protected AbsCityBuilding ()
	{
		// TODO: currentLevel aus Config einlesen
		this.currentLevel = CityBuildingLevel.getMinimumCityBuildingLevel();

		this.scene = this.getScene();
		this.currentUpgradeCost = this.getUpgradeCosts().get(this.currentLevel);
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
	public Image getSprite ()
	{
		return this.spriteProperty.get();
	}


	@Override
	public SimpleObjectProperty<MetaDataImage> getSpriteProperty ()
	{
		return this.spriteProperty;
	}


	// TODO: Mosemann fragen, ob diese updateProperties() als Geschäftslogik im Modell ok sind, oder ob sie in eine
	//  dedizierte Controller-Klasse ausgelagert werden sollen.
	@Override
	public void updatePropertyValues ()
	{
		this.nameProperty.set(this.getNames().get(this.currentLevel));
		this.spriteProperty.set(this.getSprites().get(this.currentLevel));
		this.currentUpgradeCost = this.getUpgradeCosts().get(this.currentLevel);
	}


	// TODO: Interface Layer?
	@NotNull
	protected abstract Map<CityBuildingLevel, CurrencyTransaction> getUpgradeCosts ();


	@NotNull
	protected abstract Map<CityBuildingLevel, String> getNames ();


	@NotNull
	protected abstract Map<CityBuildingLevel, MetaDataImage> getSprites ();


	@NotNull
	public abstract Scene getScene ();

}
