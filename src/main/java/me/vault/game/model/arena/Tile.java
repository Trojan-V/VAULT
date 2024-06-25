package me.vault.game.model.arena;


import me.vault.game.interfaces.Placable;


public class Tile
{

	private final String tileName;

	private final int row;

	private final int column;

	private Placable currentElement;


	public Tile (final String tileName, final int row, final int column, final Placable currentElement)
	{
		this.tileName = tileName;
		this.row = row;
		this.column = column;
		this.currentElement = currentElement;
	}


	public Placable getCurrentElement ()
	{
		return this.currentElement;
	}


	public String getTileName ()
	{
		return this.tileName;
	}


	public void setCurrentElement (final Placable placable)
	{
		this.currentElement = placable;
	}


	/**
	 * {@return a string representation of the object}
	 */
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
