package me.vault.game.model.currency;


import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.image.Image;
import me.vault.game.control.CurrencyController;
import me.vault.game.interfaces.Displayable;
import me.vault.game.model.arena.Arena;
import me.vault.game.utility.loading.ResourceLoader;
import me.vault.game.utility.struct.MetaDataImage;

import java.net.URL;
import java.text.MessageFormat;
import java.util.ResourceBundle;

import static me.vault.game.utility.constant.GameConstants.ASSETS_PATH;


/**
 * The {@code Currency} enum represents the resources or currencies which the user can use to upgrade troops and
 * buildings. Currencies are earned by
 * completing missions and progressing in the story. The class in controlled by the {@link CurrencyController} class,
 * which manages mission rewards
 * and building costs.
 *
 * @author Vincent Wolf, Lasse-Leander Hillen, Timothy Hoegen-Jupp, Alexander Goethel
 * @see CurrencyController
 * @since 21.05.2024
 */
public enum Currency implements Displayable
{
	/**
	 * The steel-currency, which is the main-resource used to upgrade buildings.
	 */
	STEEL(new SimpleIntegerProperty(0), ResourceLoader.loadImage(ASSETS_PATH + "currency/steel_icon.png")),


	/**
	 * The composite-currency, which is the rarer resource used to upgrade buildings.
	 */
	COMPOSITE(new SimpleIntegerProperty(0), ResourceLoader.loadImage(ASSETS_PATH + "currency/composite_icon.png")),


	/**
	 * The food rations currency, which is the main-resource used to upgrade troops.
	 */
	FOOD_RATION(new SimpleIntegerProperty(0), ResourceLoader.loadImage(ASSETS_PATH + "currency/food_ration_icon.png")),


	/**
	 * The science currency, which is the rarer resource used to upgrade troops.
	 */
	SCIENCE(new SimpleIntegerProperty(0), ResourceLoader.loadImage(ASSETS_PATH + "currency/science_icon.png")),


	/**
	 * The energy-credits currency, which is the rarest resource used to upgrade troops.
	 */
	ENERGY_CREDIT(new SimpleIntegerProperty(0), ResourceLoader.loadImage(ASSETS_PATH + "currency/credit_icon.png"));


	/**
	 * The {@link MessageFormat} pattern, which is used, when the {@link Arena#toString()} is
	 * called.
	 */
	private static final String TO_STRING_PATTERN = "Currency'{'sprite={0}, amount={1}'}'";


	/**
	 * This property is used to store and dynamically display the sprite of the currency.
	 * If the sprite is updated within this property, JavaFX instantly applies the change, so it's visible in the GUI.
	 *
	 * @see SimpleObjectProperty
	 * @see MetaDataImage
	 */
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
	 * Gets the current amount of the currency and returns it.
	 *
	 * @return The amount property of the currency object as an {@link Integer}.
	 */
	public int getAmount ()
	{
		return this.amountProperty.get();
	}


	/**
	 * Sets the amount property to a specified amount.
	 *
	 * @param amount The amount which the amount property from the currency is set to. As an {@link Integer}.
	 */
	public void setAmount (final int amount)
	{
		this.amountProperty.set(amount);
	}


	/**
	 * Returns the property that contains the amount of the currency.
	 * <br>
	 * This property is bound to an element in the GUI. Check {@link CurrencyController#initialize(URL, ResourceBundle)}
	 * to see the binding process.
	 *
	 * @return The property that contains the amount of the currency.
	 */
	public SimpleIntegerProperty getAmountProperty ()
	{
		return this.amountProperty;
	}


	/**
	 * Adds the specified amount to the currency property.
	 *
	 * @param amount The amount which is added to the currency as an {@link Integer}.
	 */
	public void addAmount (final int amount)
	{
		this.amountProperty.set(this.amountProperty.get() + amount);
	}


	/**
	 * Returns the current sprite of the currency.
	 *
	 * @return The current sprite of the currency.
	 * @see MetaDataImage
	 */
	@Override
	public MetaDataImage getSprite ()
	{
		return this.spriteProperty.get();
	}


	/**
	 * Sets the sprite of the currency to the supplied sprite.
	 * <br>
	 * The sprite is set within the {@link Currency#spriteProperty}, so the sprite gets automatically updated in the
	 * GUI.
	 *
	 * @param sprite The new sprite for the currency.
	 */
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
	 * Builds a formatted {@link String}, which represents the object, and it's current state using the
	 * {@link Currency#TO_STRING_PATTERN}.
	 *
	 * @return A {@link String} which has been formatted in the {@link Currency#TO_STRING_PATTERN}.
	 * @precondition The {@link Currency#TO_STRING_PATTERN} is {@code != null}.
	 * @postcondition The method returned a {@link String} which represents the object.
	 */
	@Override
	public String toString ()
	{
		return MessageFormat.format(TO_STRING_PATTERN, this.spriteProperty.get().toString(), this.amountProperty.get());
	}
}
