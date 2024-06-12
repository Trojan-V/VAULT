package me.vault.game.model.mission;


import javafx.scene.Scene;
import javafx.scene.image.Image;
import me.vault.game.VaultApplication;
import me.vault.game.model.player.Tile;

import java.util.ArrayList;
import java.util.List;


public class MissionMap extends GameMap
{

	public MissionMap ()
	{
		super(new TileMap("lala"), new Image("lalal"), new Scene(VaultApplication.getStage().getScene().getRoot()));
	}


	public List<Tile> getCollectibleTiles ()
	{
		return new ArrayList<Tile>();
	}


	public List<Tile> getEncounterTiles ()
	{
		return new ArrayList<Tile>();
	}


	public Tile getPlayerTile ()
	{
		return new Tile();
	}


	public Tile getEndFile ()
	{
		return new Tile();
	}


	public Tile getStartTile ()
	{
		return new Tile();
	}

}
