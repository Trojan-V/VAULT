package me.vault.game.model.mission;


import me.vault.game.model.GameMap;
import me.vault.game.model.Vertex;


public abstract class MapObject
{
	private GameMap map;

	private Vertex tile;


	protected MapObject (final GameMap map, final Vertex tile)
	{
		this.map = map;
		this.tile = tile;
	}

}
