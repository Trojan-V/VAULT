package me.vault.game.model.mission;


import me.vault.game.model.player.Tile;

import java.util.ArrayList;
import java.util.Map;


public class TileMap
{

	private final Map<Tile, ArrayList<Tile>> tileGraph;


	public TileMap (final String tileMapFilepath)
	{
		this.tileGraph = TileFileParser.parseFile(tileMapFilepath);
	}

}
