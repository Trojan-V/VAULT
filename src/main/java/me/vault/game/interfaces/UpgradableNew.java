package me.vault.game.interfaces;


import me.vault.game.model.currency.CurrencyTransaction;


/**
 * Description
 *
 * @author Vincent Wolf
 * @version 1.0.0
 * @see
 * @since 06.06.2024
 */
public interface UpgradableNew<E>
{

	E getLevel ();


	void setLevel (final E level);


	CurrencyTransaction getCurrentUpgradeCosts ();

	void setCurrentUpgradeCosts (final CurrencyTransaction upgradeCosts);
}
