package me.vault.game.model;


public abstract class GameMap
{

	private Graph tileMap;


	protected GameMap ()
	{
		this.tileMap = new Graph(); // TODO: Oder create?
	}


	protected GameMap (final Graph tileMap)
	{
		this.tileMap = tileMap;
	}


	public Graph getTileMap ()
	{
		return this.tileMap;
	}


	private void setTileMap (final Graph tileMap)
	{
		this.tileMap = tileMap;
	}

}
