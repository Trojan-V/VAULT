package me.vault.game.interfaces;


import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.image.Image;


public interface Displayable
{
	/**
	 * Returns the sprite property of the displayable object.
	 *
	 * @return The sprite property of the displayable object as an {@link Image}
	 */
	public abstract Image getSprite ();


	public abstract SimpleObjectProperty<Image> getSpriteProperty ();


	public abstract void updatePropertyValues ();
}
