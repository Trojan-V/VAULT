package me.vault.game.model.mission;

import javafx.scene.Scene;
import javafx.scene.image.Image;

public abstract class GameMap
{
	private final TileMap tileMap;

	private final Image background;

	private final Scene scene;


	protected GameMap (final TileMap tileMap, final Image background, final Scene scene)
	{
		this.tileMap = tileMap;
		this.background = background;
		this.scene = scene;
	}

}
