package me.vault.game.model.arena;


import me.vault.game.interfaces.Placeable;

import java.text.MessageFormat;


public class Tile
{


	private static final String TO_STRING_PATTERN = "Tile'{'position={0}, currentElement={1}'}'";


	private final Position position;


	private Placeable currentElement;


	public Tile (final Position position, final Placeable currentElement)
	{
		this.position = position;
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


	@Override
	public String toString ()
	{
		return MessageFormat.format(TO_STRING_PATTERN, this.position, this.currentElement);
	}


	public Position getPosition ()
	{
		return this.position;
	}
}
