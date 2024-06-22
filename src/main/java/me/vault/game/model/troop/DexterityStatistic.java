package me.vault.game.model.troop;


import javafx.beans.property.SimpleIntegerProperty;


public class DexterityStatistic
{

	private SimpleIntegerProperty movementTiles;

	private SimpleIntegerProperty initiative;


	public DexterityStatistic (final int movementTiles, final int initiative)
	{
		this.movementTiles = new SimpleIntegerProperty(movementTiles);
		this.initiative = new SimpleIntegerProperty(initiative);
	}


	public int getMovementTiles ()
	{
		return this.movementTiles.get();
	}


	public SimpleIntegerProperty getMovementTileProperty ()
	{
		return this.movementTiles;
	}


	public void setMovementTiles (final int movementTiles)
	{
		this.movementTiles.set(movementTiles);
	}


	public int getInitiative ()
	{
		return this.initiative.get();
	}


	public SimpleIntegerProperty getInitiativeProperty ()
	{
		return this.initiative;
	}


	public void setInitiative (final int initiative)
	{
		this.initiative.set(initiative);
	}

}
