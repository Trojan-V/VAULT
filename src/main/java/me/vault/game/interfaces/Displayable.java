package me.vault.game.interfaces;


import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.image.Image;
import me.vault.game.utility.struct.MetaDataImage;


/**
 * Any class that's a displayable object should implement this interface.
 * It provides getters to access the sprite
 * property and the sprite of the displayable object.
 * <br>
 * This is especially important to ensure the model view controller paradigm can be implemented correctly, as the
 * controller is responsible for updating the values of the properties and therefore the controller needs a method to
 * be able to access these inner properties of the displayable object.
 *
 * @author Vincent Wolf
 * @version 2.0.0
 * @since 12.06.2024
 */
public interface Displayable
{

	/**
	 * Returns the sprite that is stored within the property of the displayable object as an {@link Image}.
	 *
	 * @return The sprite of the displayable object.
	 */
	MetaDataImage getSprite ();


	/**
	 * Sets the sprite of the displayable object to the supplied sprite.
	 *
	 * @param sprite The new sprite for the displayable object.
	 */
	void setSprite (final MetaDataImage sprite);


	/**
	 * Returns the sprite property of the displayable object.
	 *
	 * @return The sprite property of the displayable object.
	 */
	SimpleObjectProperty<MetaDataImage> getSpriteProperty ();

}
