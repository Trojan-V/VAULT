package me.vault.game.model.currency;

// TODO: Interface ist für die EA an sich unnötig.

import javafx.beans.property.SimpleIntegerProperty;

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
	/**
	 * Gets the current amount of the currency and returns it.
	 *
	 * @return The amount property of the currency object as an {@link Integer}.
	 */
	int getAmount ();

	/**
	 * Sets the amount property to a specified amount.
	 *
	 * @param amount The amount which the amount property from the currency is set to. As an {@link Integer}.
	 */
	void setAmount (final int amount);

	SimpleIntegerProperty getAmountProperty ();

	/**
	 * Adds the specified amount to the currency property.
	 *
	 * @param amount The amount which is added to the currency as an {@link Integer}.
	 */
	void addAmount (final int amount);

}
