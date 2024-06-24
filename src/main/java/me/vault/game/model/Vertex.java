package me.vault.game.model;


import me.vault.game.interfaces.Placable;


public class Vertex
{

	private final String vertexName;


	private Placable currentElement;


	private boolean marked = false;


	public Vertex (final String vertexName, final Placable currentElement)
	{
		this.vertexName = vertexName;
		this.currentElement = currentElement;
	}

	public String getVertexName (final Vertex vertex)
	{
		return this.vertexName;
	}


	public Placable getCurrentElement ()
	{
		return this.currentElement;
	}


	public void setCurrentElement (final Placable newElement)
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
