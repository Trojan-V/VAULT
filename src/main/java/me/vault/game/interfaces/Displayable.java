package me.vault.game.interfaces;


import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.image.Image;
import me.vault.game.utility.struct.MetaDataImage;


public interface Displayable
{

	/**
	 * Returns the sprite property of the displayable object.
	 *
	 * @return The sprite property of the displayable object as an {@link Image}
	 */
	Image getSprite ();


	SimpleObjectProperty<MetaDataImage> getSpriteProperty ();
}
