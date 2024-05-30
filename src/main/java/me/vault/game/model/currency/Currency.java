package me.vault.game.model.currency;


import javafx.scene.image.Image;
import me.vault.game.controller.CurrencyController;
import me.vault.game.utility.ResourceLoader;

import java.text.MessageFormat;

import static me.vault.game.utility.constant.GameConstants.ASSETS_PATH;

// TODO: Interface für Sprites
// TODO: Amount should either be retrieved by Serialization or JSON config file.


/**
 * The {@code Currency} enum represents the resources or currencies which the user can use to upgrade troops and
 * buildings. Currencies are earned by completing missions and progressing in the story. The class in controlled by the
 * {@link CurrencyController} class, which manages mission rewards and building costs.
 *
 * @author Lasse-Leander Hillen
 * @see CurrencyController
 * @since 21.05.2024
 */
public enum Currency implements ICurrency
{
	/**
	 * The steel-currency, which is the main-resource used to upgrade buildings.
	 */
	STEEL(0, ResourceLoader.loadImage(ASSETS_PATH + "Item_Pack/steel_icon.png")),

	/**
	 * The composite-currency, which is the rarer resource used to upgrade buildings.
	 */
	COMPOSITE(0, ResourceLoader.loadImage(ASSETS_PATH + "Item_Pack/composite_icon.png")),

	/**
	 * The food rations currency, which is the main-resource used to upgrade troops.
	 */
	FOOD_RATION(0, ResourceLoader.loadImage(ASSETS_PATH + "Item_Pack/food_ration_icon.png")),

	/**
	 * The science currency, which is the rarer resource used to upgrade troops.
	 */
	SCIENCE(0, ResourceLoader.loadImage(ASSETS_PATH + "Item_Pack/science_icon.png")),

	/**
	 * The energy-credits currency, which is the rarest resource used to upgrade troops.
	 */
	ENERGY_CREDIT(0, ResourceLoader.loadImage(ASSETS_PATH + "Item_Pack/credit_icon.png"));


	/**
	 * The format, which is used to display the object with its properties.
	 */
	private static final String TO_STRING_FORMAT = "{0} [amount={1} | image={2}]";


	/**
	 * The sprite of the currency.
	 */
	private final Image image;


	/**
	 * The current amount of the currency.
	 */
	private int amount;


	/**
	 * The constructor of the {@code Currency} enum, which accepts an amount and a sprite.
	 *
	 * @param amount The amount of the currency as an {@link Integer}.
	 * @param image  The sprite of the currency as an {@link Image}.
	 */
	Currency (final int amount, final Image image)
	{
		this.amount = amount;
		this.image = image;
	}


	/**
	 * Gets the current amount of the currency and returns it.
	 *
	 * @return The amount property of the currency object as an {@link Integer}.
	 */
	@Override
	public int getAmount ()
	{
		return this.amount;
	}


	/**
	 * Sets the amount property to a specified amount.
	 *
	 * @param amount The amount which the amount property from the currency is set to. As an {@link Integer}.
	 */
	@Override
	public void setAmount (final int amount)
	{
		this.amount = amount;
	}


	/**
	 * Adds a specified amount to the currency property.
	 *
	 * @param amount The amount which is added to the currency as an {@link Integer}.
	 */
	@Override
	public void addAmount (final int amount)
	{
		this.amount += amount;
	}


	/**
	 * Returns the sprite property of the currency object.
	 *
	 * @return The sprite property of the currency object as an {@link Image}
	 */
	@Override
	public Image getSprite ()
	{
		return this.image;
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
		return MessageFormat.format(TO_STRING_FORMAT, this.name(), this.amount, this.image);
	}
}
