package me.vault.game.model.energy;


import javafx.beans.property.SimpleIntegerProperty;


public class DexterityEnergyStatistic
{

	private final SimpleIntegerProperty movementTiles;

	private final SimpleIntegerProperty initiative;


	public DexterityEnergyStatistic (final int movementTiles, final int initiative)
	{
		this.movementTiles = new SimpleIntegerProperty(movementTiles);
		this.initiative = new SimpleIntegerProperty(initiative);
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

