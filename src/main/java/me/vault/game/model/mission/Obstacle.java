package me.vault.game.model.mission;


import javafx.beans.property.SimpleObjectProperty;
import me.vault.game.utility.loading.ResourceLoader;
import me.vault.game.utility.struct.MetaDataImage;


public class Obstacle implements MapObject
{

	private static final String SPRITE_PATH = "src/main/resources/me/vault/game/assets/attributes/resistance_icon.png";

	private static final SimpleObjectProperty<MetaDataImage> SPRITE_PROPERTY = new SimpleObjectProperty<>(ResourceLoader.loadImage(SPRITE_PATH));


	/**
	 * Returns the sprite that is stored within the property of the displayable object as an {.
	 *
	 * @return The sprite of the displayable object.
	 */
	@Override
	public MetaDataImage getSprite ()
	{
		return SPRITE_PROPERTY.get();
	}


	/**
	 * Sets the sprite of the displayable object to the supplied sprite.
	 *
	 * @param sprite The new sprite for the displayable object.
	 */
	@Override
	public void setSprite (final MetaDataImage sprite)
	{
		SPRITE_PROPERTY.set(sprite);
	}


	/**
	 * Returns the sprite property of the displayable object.
	 *
	 * @return The sprite property of the displayable object.
	 */
	@Override
	public SimpleObjectProperty<MetaDataImage> getSpriteProperty ()
	{
		return SPRITE_PROPERTY;
	}

}
