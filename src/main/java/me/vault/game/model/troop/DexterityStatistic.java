package me.vault.game.model.troop;


public class DexterityStatistic
{

	private int movementTiles;

	private int initiative;


	public DexterityStatistic (final int movementTiles, final int initiative)
	{
		this.movementTiles = movementTiles;
		this.initiative = initiative;
	}


	public int getMovementTiles ()
	{
		return this.movementTiles;
	}


	public void setMovementTiles (final int movementTiles)
	{
		this.movementTiles = movementTiles;
	}


	public int getInitiative ()
	{
		return this.initiative;
	}


	public void setInitiative (final int initiative)
	{
		this.initiative = initiative;
	}

}
