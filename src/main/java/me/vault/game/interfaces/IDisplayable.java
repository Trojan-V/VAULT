package me.vault.game.interfaces;


import javafx.scene.image.Image;


public interface IDisplayable
{
	/**
	 * Returns the sprite property of the displayable object.
	 *
	 * @return The sprite property of the displayable object as an {@link Image}
	 */
	public abstract Image getSprite ();


	public default void setSprite (final Image sprite) {}


	public abstract void updateProperties ();
}
