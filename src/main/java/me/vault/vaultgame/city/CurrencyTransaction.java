package me.vault.vaultgame.city;

import java.util.Currency;
import java.util.HashMap;

public class CurrencyTransaction
{
	private final HashMap<Currency, Integer> amountMap;


	public CurrencyTransaction (HashMap<Currency, Integer> amountMap)
	{
		this.amountMap = amountMap;
	}


	public HashMap<Currency, Integer> getAmountMap ()
	{
		return this.amountMap;
	}


	public int getAmount (Currency currency)
	{
		return amountMap.get(currency);
	}
}
