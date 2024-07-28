package me.vault.game.model.arena;


import me.vault.game.interfaces.Placeable;


public class Tile
{

	private final String tileName;

	private final int row;

	private final int column;


	private Placeable currentElement;


	public Tile (final String tileName, final int row, final int column, final Placeable currentElement)
	{
		this.tileName = tileName;
		this.row = row;
		this.column = column;
		this.currentElement = currentElement;
	}


	public Placeable getCurrentElement ()
	{
		return this.currentElement;
	}


	public void setCurrentElement (final Placeable placeable)
	{
		this.currentElement = placeable;
	}


	public String getTileName ()
	{
		return this.tileName;
	}


	@Override
	public String toString ()
	{
		return this.tileName;
	}


	public int getRow ()
	{
		return this.row;
	}


	public int getColumn ()
	{
		return this.column;
	}

}
