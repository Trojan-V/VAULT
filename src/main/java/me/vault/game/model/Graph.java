package me.vault.game.model;


import me.vault.game.exception.AlreadyExistsException;
import me.vault.game.utility.constant.StringConstants;

import java.util.HashMap;
import java.util.LinkedList;


public class Graph
{

	private final HashMap<Vertex, LinkedList<Vertex>> adjacencyList;


	public Graph (final HashMap<Vertex, LinkedList<Vertex>> adjacencyList)
	{
		this.adjacencyList = adjacencyList;
	}


	public Graph ()
	{
		this.adjacencyList = new HashMap<>();
	}


	public void addVertex (final Vertex vertex) throws AlreadyExistsException
	{
		if (this.adjacencyList.containsKey(vertex))
		{
			throw new AlreadyExistsException(StringConstants.ALREADY_EXIST_EXCEPTION_MESSAGE);
		}
		this.adjacencyList.put(vertex, new LinkedList<Vertex>());
	}


	public void addEdge (final Vertex startVertex, final Vertex endVertex)
	{
		if (!this.adjacencyList.containsKey(startVertex) || !this.adjacencyList.containsKey(endVertex))
		{
			throw new NullPointerException(StringConstants.VERTEX_DOES_NOT_EXIST);
		}

	}


	public void removeEdge ()
	{

	}

}
