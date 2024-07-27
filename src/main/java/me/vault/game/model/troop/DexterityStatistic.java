package me.vault.game.model.troop;


import javafx.beans.property.SimpleIntegerProperty;


public class DexterityStatistic
{

	private final SimpleIntegerProperty movementTiles;

	private final SimpleIntegerProperty initiative;


	public DexterityStatistic (final int movementTiles, final int initiative)
	{
		this.movementTiles = new SimpleIntegerProperty(movementTiles);
		this.initiative = new SimpleIntegerProperty(initiative);
	}


	public DexterityStatistic (final DexterityStatistic dexterityStatistic)
	{
		this.movementTiles = new SimpleIntegerProperty(dexterityStatistic.getMovementTiles());
		this.initiative = new SimpleIntegerProperty(dexterityStatistic.getInitiative());
	}


	public int getMovementTiles ()
	{
		return this.movementTiles.get();
	}


	public void setMovementTiles (final int movementTiles)
	{
		this.movementTiles.set(movementTiles);
	}


	public void setMovementTiles (final float movementTiles)
	{
		this.movementTiles.set(Math.round(movementTiles));
	}


	public SimpleIntegerProperty getMovementTileProperty ()
	{
		return this.movementTiles;
	}


	public int getInitiative ()
	{
		return this.initiative.get();
	}


	public void setInitiative (final int initiative)
	{
		this.initiative.set(initiative);
	}


	public void setInitiative (final float initiative)
	{
		this.initiative.set(Math.round(initiative));
	}


	public SimpleIntegerProperty getInitiativeProperty ()
	{
		return this.initiative;
	}

}
