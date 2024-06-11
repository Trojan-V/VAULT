package me.vault.game.model.mission;

import javafx.scene.Scene;
import javafx.scene.image.Image;

public abstract class GameMap
{
	private final TileMap tileMap;

	private final Image background;

	private final Scene scene;


	protected GameMap (TileMap tileMap, Image background, Scene scene)
	{
		this.tileMap = tileMap;
		this.background = background;
		this.scene = scene;
	}

}
