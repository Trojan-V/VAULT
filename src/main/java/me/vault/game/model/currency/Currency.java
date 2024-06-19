package me.vault.game.model.currency;


import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.image.Image;
import me.vault.game.control.CurrencyController;
import me.vault.game.interfaces.Displayable;
import me.vault.game.utility.loading.ResourceLoader;
import me.vault.game.utility.struct.MetaDataImage;

import java.text.MessageFormat;

import static me.vault.game.utility.constant.GameConstants.ASSETS_PATH;

// TODO: Amount should either be retrieved by Serialization or JSON config file.


/**
 * The {@code Currency} enum represents the resources or currencies which the user can use to upgrade troops and buildings. Currencies are earned by
 * completing missions and progressing in the story. The class in controlled by the {@link CurrencyController} class, which manages mission rewards
 * and building costs.
 *
 * @author Lasse-Leander Hillen
 * @see CurrencyController
 * @since 21.05.2024
 */
public enum Currency implements ICurrency, Displayable
{
	/**
	 * The steel-currency, which is the main-resource used to upgrade buildings.
	 */
	STEEL(new SimpleIntegerProperty(0), ResourceLoader.loadImage(ASSETS_PATH + "Item_Pack/steel_icon.png")),


	/**
	 * The composite-currency, which is the rarer resource used to upgrade buildings.
	 */
	COMPOSITE(new SimpleIntegerProperty(0), ResourceLoader.loadImage(ASSETS_PATH + "Item_Pack/composite_icon.png")),


	/**
	 * The food rations currency, which is the main-resource used to upgrade troops.
	 */
	FOOD_RATION(new SimpleIntegerProperty(0), ResourceLoader.loadImage(ASSETS_PATH + "Item_Pack/food_ration_icon" + ".png")),


	/**
	 * The science currency, which is the rarer resource used to upgrade troops.
	 */
	SCIENCE(new SimpleIntegerProperty(0), ResourceLoader.loadImage(ASSETS_PATH + "Item_Pack/science_icon.png")),


	/**
	 * The energy-credits currency, which is the rarest resource used to upgrade troops.
	 */
	ENERGY_CREDIT(new SimpleIntegerProperty(0), ResourceLoader.loadImage(ASSETS_PATH + "Item_Pack/credit_icon.png"));

	private static final String TO_STRING_PATTERN = "{0}[{1}]";

	private final SimpleObjectProperty<MetaDataImage> spriteProperty;

	/**
	 * The current amount of the currency.
	 */
	private final SimpleIntegerProperty amountProperty;


	/**
	 * The constructor of the {@code Currency} enum, which accepts an amount and a sprite.
	 *
	 * @param amountProperty The amount of the currency as an {@link Integer}.
	 * @param image          The sprite of the currency as an {@link Image}.
	 */
	Currency (final SimpleIntegerProperty amountProperty, final MetaDataImage image)
	{
		this.amountProperty = amountProperty;
		this.spriteProperty = new SimpleObjectProperty<>(image);
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getAmount ()
	{
		return this.amountProperty.get();
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setAmount (final int amount)
	{
		this.amountProperty.set(amount);
	}


	@Override
	public SimpleIntegerProperty getAmountProperty ()
	{
		return this.amountProperty;
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addAmount (final int amount)
	{
		this.amountProperty.set(this.amountProperty.get() + amount);
	}


	@Override
	public MetaDataImage getSprite ()
	{
		return this.spriteProperty.get();
	}


	@Override
	public void setSprite (final MetaDataImage sprite)
	{
		this.spriteProperty.set(sprite);
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public SimpleObjectProperty<MetaDataImage> getSpriteProperty ()
	{
		return this.spriteProperty;
	}


	/**
	 * Overrides the {@link Object#toString()} method, that returns a {@link String}, which represents the object with its properties.
	 *
	 * @return A {@link String} value, which represents the object with its properties.
	 */
	@Override
	public String toString ()
	{
		return MessageFormat.format(TO_STRING_PATTERN, this.name(), this.amountProperty.get());
	}
}
