package me.vault.game.model.currency;


import javafx.scene.image.Image;


/**
 * Description
 *
 * @author Vincent Wolf
 * @version 1.0.0
 * @see Currency
 * @since 30.05.2024
 */
public interface ICurrency
{
	public int getAmount ();


	public void setAmount (final int amount);


	public void addAmount (final int amount);


	public Image getSprite ();
}
