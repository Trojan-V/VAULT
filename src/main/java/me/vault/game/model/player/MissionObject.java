package me.vault.game.model.player;


public abstract class MissionObject
{

	private final Tile tile;


	protected MissionObject (final Tile tile)
	{
		this.tile = tile;
	}


	public Tile getTile ()
	{
		return this.tile;
	}

}
