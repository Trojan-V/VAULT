package me.vault.game.interfaces;


import javafx.scene.image.Image;


public interface IDisplayable
{
	/**
	 * Returns the sprite property of the currency object.
	 *
	 * @return The sprite property of the currency object as an {@link Image}
	 */
	public Image getSprite ();


	public default void setSprite (final Image sprite)
	{}
}
