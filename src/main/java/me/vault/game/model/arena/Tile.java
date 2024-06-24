package me.vault.game.model.arena;


import me.vault.game.interfaces.Placable;


public class Tile
{
	private final String tileName;


	private final Placable currentElement;


	public Tile (final String tileName, final Placable currentElement)
	{
		this.tileName = tileName;
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
}
