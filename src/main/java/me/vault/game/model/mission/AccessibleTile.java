package me.vault.game.model.mission;


import javafx.beans.property.SimpleObjectProperty;
import me.vault.game.utility.struct.MetaDataImage;


public class AccessibleTile implements MapObject
{

	/**
	 * Returns the sprite that is stored within the property of the displayable object as an {@link }.
	 *
	 * @return The sprite of the displayable object.
	 */
	@Override
	public MetaDataImage getSprite ()
	{
		return null;
	}


	/**
	 * Sets the sprite of the displayable object to the supplied sprite.
	 *
	 * @param sprite The new sprite for the displayable object.
	 */
	@Override
	public void setSprite (final MetaDataImage sprite)
	{

	}


	/**
	 * Returns the sprite property of the displayable object.
	 *
	 * @return The sprite property of the displayable object.
	 */
	@Override
	public SimpleObjectProperty<MetaDataImage> getSpriteProperty ()
	{
		return null;
	}

}
