package me.vault.vaultgame.city;


import javafx.scene.image.Image;

import java.text.MessageFormat;


/**
 * The {@code Currency} class/enum represents the resources or currencies which the user can use to upgrade troops and
 * buildings. Currencies are earned by completing missions and progressing in the story. The class in controlled by the
 * {@link CurrencyController} class, which manages mission rewards and building costs.
 *
 * @author Lasse-Leander Hillen
 * @see CurrencyController
 * @since 21.05.2024
 */
public enum Currency
{
	/** The steel-currency, which is the main-resource used to upgrade buildings. */
	STEEL(
			0,
			new Image("")),


	/** The composite-currency, which is the rarer resource used to upgrade buildings. */
	COMPOSITES(
			0,
			new Image("")),


	/** The food rations currency, which is the main-resource used to upgrade troops. */
	FOOD_RATIONS(
			0,
			new Image("")),


	/** The science currency, which is the rarer resource used to upgrade troops. */
	SCIENCE(
			0,
			new Image("")),


	/** The energy-credits currency, which is the rarest resource used to upgrade troops. */
	ENERGY_CREDITS(
			0,
			new Image(""));


	/** The format, which is used to display the object with its properties. */
	private static final String STRING_FORMAT = "Currency [amount = {0,number,integer}, sprite = \"{1}\"]";


	/** The sprite of the currency. */
	private final Image sprite;


	/** The current amount of the currency. */
	private int amount = 0;


	/**
	 * The constructor of the {@code Currency} enum, which accepts an amount and a sprite.
	 *
	 * @param amount The amount of the currency as an {@link Integer}.
	 * @param sprite The sprite of the currency as an {@link Image}.
	 */
	Currency (final int amount, final Image sprite)
	{
		this.amount = amount;
		this.sprite = sprite;
	}


	/**
	 * Gets the current amount of the currency and returns it.
	 *
	 * @return The amount property of the currency object as an {@link Integer}.
	 */
	public int getAmount ()
	{
		return this.amount;
	}


	/**
	 * Sets the amount property to a specified amount.
	 *
	 * @param amount The amount which the amount property from the currency is set to. As an {@link Integer}.
	 */
	public void setAmount (final int amount)
	{
		this.amount = amount;
	}


	/**
	 * Adds a specified amount to the currency property.
	 *
	 * @param amount The amount which is added to the currency as an {@link Integer}.
	 */
	public void addAmount (final int amount)
	{
		this.amount += amount;
	}


	/**
	 * Subtracts a specified amount from the currency property.
	 *
	 * @param amount The amount which is subtracted from the currency as an {@link Integer}.
	 */
	public void subtractAmount (final int amount)
	{
		this.amount -= amount;
	}


	/**
	 * Returns the sprite property of the currency object.
	 *
	 * @return The sprite property of the currency object as an {@link Image}
	 */
	public Image getSprite ()
	{
		return this.sprite;
	}


	/**
	 * Overrides the {@link Object#toString()} method, that returns a {@link String}, which represents the object with
	 * its properties.
	 *
	 * @return A {@link String} value, which represents the object with its properties.
	 */
	@Override
	public String toString ()
	{
		return MessageFormat.format(STRING_FORMAT, this.amount, this.sprite);
	}
}
