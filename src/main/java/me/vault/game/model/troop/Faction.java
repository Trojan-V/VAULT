package me.vault.game.model.troop;


import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.image.Image;
import me.vault.game.model.artifact.Artifact;
import me.vault.game.utility.datatypes.MetaDataImage;
import me.vault.game.utility.interfaces.Displayable;
import me.vault.game.utility.loading.ResourceLoader;

import java.text.MessageFormat;


/**
 * This enum provides all Factions that exist in the game.
 * <br>
 * Each faction consists of a different sprite as well as a different multiplier for the offensive, defensive and dexterity multiplier.
 *
 * @author Vincent Wolf, Lasse-Leander Hillen, Timothy Hoegen-Jupp, Alexander Goethel
 * @version 1.0.0
 * @see Displayable
 * @since 30.07.2024
 */
public enum Faction implements Displayable
{
	/**
	 * Very strong on dexterity.
	 */
	EXPLORER_ASSOCIATION(1.2f, 1.0f, 1.5f, ResourceLoader.loadImage("src/main/resources/me/vault/game/assets/Forge_Button_16x16.png")),


	/**
	 * Very strong at the defense.
	 */
	MILITARISTIC_GOVERNMENT(1.25f, 1.5f, 1.0f, ResourceLoader.loadImage("src/main/resources/me/vault/game/assets/Forge_Button_16x16.png")),


	/**
	 * Very strong on the offensive.
	 */
	MEGA_CORPORATION(1.5f, 1.25f, 1.25f, ResourceLoader.loadImage("src/main/resources/me/vault/game/assets/Forge_Button_16x16.png")),


	/**
	 * A balanced faction that's decent at all the preceding three, but not great at any of those.
	 */
	NEW_TERRA(1.25f, 1.25f, 1.25f, ResourceLoader.loadImage("src/main/resources/me/vault/game/assets/Forge_Button_16x16.png"));


	/**
	 * The {@link MessageFormat} pattern, which is used, when the {@link Artifact#toString()} is
	 * called.
	 */
	private static final String TO_STRING_PATTERN = "Faction'{'spriteProperty={0}, isSelectedProperty={1}, offensiveMultiplier={2}, " + "defensiveMultiplier={3}, dexterityMultiplier={4}'}'";


	/**
	 * This {@link SimpleObjectProperty} is used to store and dynamically display the sprite ({@link MetaDataImage}) of the faction.
	 * If the sprite is updated within this property, JavaFX instantly applies the change, so it's visible in the GUI.
	 */
	private final SimpleObjectProperty<MetaDataImage> spriteProperty;


	/**
	 * This {@link SimpleBooleanProperty} is used to store and dynamically display if the faction is selected or not.
	 */
	private final SimpleBooleanProperty isSelectedProperty;


	/**
	 * The multiplier for the offensive statistics of the faction.
	 */
	private final float offensiveMultiplier;


	/**
	 * The multiplier for the defensive statistics of the faction.
	 */
	private final float defensiveMultiplier;


	/**
	 * The multiplier for the dexterity statistics of the faction.
	 */
	private final float dexterityMultiplier;


	/**
	 * Constructs an instance of this class.
	 *
	 * @param offensiveMultiplier The multiplier that'll be used for the offensive statistics.
	 * @param defensiveMultiplier The multiplier that'll be used for the defensive statistics.
	 * @param dexterityMultiplier The multiplier that'll be used for the dexterity statistics.
	 * @param sprite              The sprite that represents the faction.
	 *
	 * @precondition The supplied parameters exist and are accessible.
	 * @postcondition An instance of this class is created with the supplied parameter.
	 */
	Faction (final float offensiveMultiplier, final float defensiveMultiplier, final float dexterityMultiplier, final MetaDataImage sprite)
	{
		this.offensiveMultiplier = offensiveMultiplier;
		this.defensiveMultiplier = defensiveMultiplier;
		this.dexterityMultiplier = dexterityMultiplier;
		this.isSelectedProperty = new SimpleBooleanProperty(false);
		this.spriteProperty = new SimpleObjectProperty<>(sprite);
	}


	/**
	 * Returns the multiplier for the offensive statistics of the faction.
	 *
	 * @return The multiplier for the offensive statistics of the faction.
	 *
	 * @precondition The offensiveMultiplier attribute has been set and contains a float.
	 * @postcondition The offensiveMultiplier attribute of the instance was returned.
	 */
	public float getOffensiveMultiplier ()
	{
		return this.offensiveMultiplier;
	}


	/**
	 * Returns the multiplier for the defensive statistics of the faction.
	 *
	 * @return The multiplier for the defensive statistics of the faction.
	 *
	 * @precondition The defensiveMultiplier attribute has been set and contains a float.
	 * @postcondition The defensiveMultiplier attribute of the instance was returned.
	 */
	public float getDefensiveMultiplier ()
	{
		return this.defensiveMultiplier;
	}


	/**
	 * Returns the multiplier for the dexterity statistics of the faction.
	 *
	 * @return The multiplier for the dexterity statistics of the faction.
	 *
	 * @precondition The dexterityMultiplier attribute has been set and contains a float.
	 * @postcondition The dexterityMultiplier attribute of the instance was returned.
	 */
	public float getDexterityMultiplier ()
	{
		return this.dexterityMultiplier;
	}


	/**
	 * Returns the property used to store and dynamically display if the faction is selected or not.
	 *
	 * @return The property used to store and dynamically display if the faction is selected or not.
	 *
	 * @precondition The isSelectedProperty attribute has been set and contains a SimpleBooleanProperty.
	 * @postcondition The isSelectedProperty attribute of the instance was returned.
	 */
	public SimpleBooleanProperty getIsSelectedProperty ()
	{
		return this.isSelectedProperty;
	}


	/**
	 * Returns true if the faction is currently selected, otherwise false.
	 *
	 * @return True if the faction is currently selected, otherwise false.
	 *
	 * @precondition The isSelectedProperty attribute has been set and contains a SimpleBooleanProperty.
	 * @postcondition The boolean value of the isSelectedProperty attribute of the instance was returned.
	 */
	public boolean isSelected ()
	{
		return this.isSelectedProperty.get();
	}


	/**
	 * Sets the isSelected state of the faction to the supplied boolean parameter.
	 *
	 * @param isSelected If the faction should be marked as selected or not.
	 *
	 * @precondition The isSelectedProperty attribute has been set and contains a SimpleBooleanProperty.
	 * @postcondition The boolean value of the isSelectedProperty attribute is set to the passed value.
	 */
	public void setIsSelected (final boolean isSelected)
	{
		this.isSelectedProperty.set(isSelected);
	}


	/**
	 * Returns the sprite stored within the property of the displayable object as an {@link Image}.
	 *
	 * @return The sprite of the displayable object.
	 *
	 * @precondition The sprite attribute of the Displayable has been set and is != null.
	 * @postcondition The sprite attribute of the Displayable was returned.
	 */
	@Override
	public MetaDataImage getSprite ()
	{
		return this.spriteProperty.get();
	}


	/**
	 * Sets the sprite of the displayable object to the supplied sprite.
	 *
	 * @param sprite The new sprite for the displayable object.
	 *
	 * @precondition A valid instance of {@link MetaDataImage} that isn't equal to null has been passed into the method.
	 * @postcondition The sprite attribute in the Displayable has been set to the passed {@link MetaDataImage}.
	 */
	@Override
	public void setSprite (final MetaDataImage sprite)
	{
		this.spriteProperty.set(sprite);
	}


	/**
	 * Returns the sprite property of the displayable object.
	 *
	 * @return The sprite property of the displayable object.
	 *
	 * @precondition The spriteProperty attribute of the Displayable has been set and is != null.
	 * @postcondition The spriteProperty attribute of the Displayable was returned.
	 */
	@Override
	public SimpleObjectProperty<MetaDataImage> getSpriteProperty ()
	{
		return this.spriteProperty;
	}


	/**
	 * Builds a formatted {@link String}, which represents the object, and it's current state using the
	 * {@link Faction#TO_STRING_PATTERN}.
	 *
	 * @return A {@link String} which has been formatted in the {@link Faction#TO_STRING_PATTERN}.
	 *
	 * @precondition The {@link Faction#TO_STRING_PATTERN} is {@code != null}.
	 * @postcondition The method returned a {@link String} which represents the object.
	 */
	@Override
	public String toString ()
	{
		return MessageFormat.format(TO_STRING_PATTERN, this.spriteProperty.get()
			.toString(), this.isSelectedProperty.get(), this.offensiveMultiplier, this.defensiveMultiplier, this.dexterityMultiplier);
	}
}

