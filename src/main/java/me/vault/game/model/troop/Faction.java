package me.vault.game.model.troop;


import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import me.vault.game.interfaces.Displayable;
import me.vault.game.utility.loading.ResourceLoader;
import me.vault.game.utility.struct.MetaDataImage;


public enum Faction implements Displayable
{
	EXPLORER_ASSOCIATION(1.2f, 1.0f, 1.5f,
		new SimpleBooleanProperty(false), ResourceLoader.loadImage("src/main/resources/me/vault/game/assets/Forge_Button_16x16.png")),

	MILITARISTIC_GOVERNMENT(1.25f, 1.5f, 1.0f,
		new SimpleBooleanProperty(false), ResourceLoader.loadImage("src/main/resources/me/vault/game/assets/Forge_Button_16x16.png")),

	MEGA_CORPORATION(1.5f, 1.25f, 1.25f,
		new SimpleBooleanProperty(false), ResourceLoader.loadImage("src/main/resources/me/vault/game/assets/Forge_Button_16x16.png")),

	NEW_TERRA(1.25f, 1.25f, 1.25f,
		new SimpleBooleanProperty(false), ResourceLoader.loadImage("src/main/resources/me/vault/game/assets/Forge_Button_16x16.png"));


	private final SimpleObjectProperty<MetaDataImage> spriteProperty;

	private final SimpleBooleanProperty isSelectedProperty;

	private final float offensiveLevelMultiplier;

	private final float defensiveLevelMultiplier;

	private final float dexterityLevelMultiplier;


	Faction (final float offensiveLevelMultiplier, final float defensiveLevelMultiplier, final float dexterityLevelMultiplier, final SimpleBooleanProperty isSelectedProperty,
		final MetaDataImage sprite)
	{
		this.offensiveLevelMultiplier = offensiveLevelMultiplier;
		this.defensiveLevelMultiplier = defensiveLevelMultiplier;
		this.dexterityLevelMultiplier = dexterityLevelMultiplier;
		this.isSelectedProperty = isSelectedProperty;
		this.spriteProperty = new SimpleObjectProperty<>(sprite);
	}


	public float getOffensiveLevelMultiplier ()
	{
		return this.offensiveLevelMultiplier;
	}


	public float getDefensiveLevelMultiplier ()
	{
		return this.defensiveLevelMultiplier;
	}


	public float getDexterityLevelMultiplier ()
	{
		return this.dexterityLevelMultiplier;
	}


	public SimpleBooleanProperty getIsSelectedProperty ()
	{
		return this.isSelectedProperty;
	}


	public boolean getIsSelected ()
	{
		return this.isSelectedProperty.get();
	}


	public void setIsSelected (final boolean isSelected)
	{
		this.isSelectedProperty.set(isSelected);
	}


	/**
	 * Returns the sprite that is stored within the property of the displayable object as an {@link MetaDataImage}.
	 *
	 * @return The sprite of the displayable object.
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
	 */
	@Override
	public SimpleObjectProperty<MetaDataImage> getSpriteProperty ()
	{
		return this.spriteProperty;
	}
}

