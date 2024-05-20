package me.vault.vaultgame.city;


import javafx.scene.image.Image;


public enum Currency
{
	STEEL(0, new Image("")),

	COMPOSITES(0, new Image("")),

	FOOD_RATIONS(0, new Image("")),

	SCIENCE(0, new Image("")),

	ENERGY_CREDITS(0, new Image(""));


	private int amount = 0;


	private final Image sprite;


	Currency (final int amount, final Image sprite)
	{
		this.amount = amount;
		this.sprite = sprite;
	}


	public int getAmount ()
	{
		return this.amount;
	}


	public void addAmount (final int amount)
	{
		this.amount += amount;
	}


	public void subtractAmount (final int amount)
	{
		this.amount -= amount;
	}


	public void setAmount (final int amount)
	{
		this.amount = amount;
	}


	public Image getSprite ()
	{
		return this.sprite;
	}


	@Override
	public String toString ()
	{
		return "Currency { amount = " + amount + ", sprite = " + this.sprite + '}';
	}
}
