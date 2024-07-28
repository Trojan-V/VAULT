package me.vault.game.model;


import me.vault.game.interfaces.Placeable;


public class Vertex
{

	private final String vertexName;


	private Placeable currentElement;


	private boolean marked = false;


	public Vertex (final String vertexName, final Placeable currentElement)
	{
		this.vertexName = vertexName;
		this.currentElement = currentElement;
	}


	public String getVertexName (final Vertex vertex)
	{
		return this.vertexName;
	}


	public Placeable getCurrentElement ()
	{
		return this.currentElement;
	}


	public void setCurrentElement (final Placeable newElement)
	{
		this.currentElement = newElement;
	}


	public void mark ()
	{
		this.marked = true;
	}


	public void unmark ()
	{
		this.marked = false;
	}

}
