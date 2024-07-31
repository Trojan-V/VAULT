package me.vault.game.model.arena;


import me.vault.game.model.gameboard.Figure;
import me.vault.game.model.gameboard.GameBoard;

import java.util.List;


public class ArenaObject
{
	private static ArenaObject instance;

	private Arena arena = null;

	private ArenaObject (Arena arena)
	{
		this.arena = arena;
	}

	public static ArenaObject getInstance()
	{
		return instance;
	}

	public Arena getArena()
	{
		return this.arena;
	}

	public void setArena(Arena arena)
	{
		this.arena = arena;
	}
}
