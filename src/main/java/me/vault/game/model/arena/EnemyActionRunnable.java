package me.vault.game.model.arena;


import me.vault.game.control.EnemyController;
import me.vault.game.model.troop.Troop;
import me.vault.game.view.ArenaDelegate;

import java.util.List;


public class EnemyActionRunnable implements Runnable
{

	private final ArenaDelegate arenaDelegate;

	private final Arena arena;

	private final Troop troop;


	public EnemyActionRunnable (ArenaDelegate instance, final Arena arena, final Troop troop)
	{
		this.arenaDelegate = instance;
		this.arena = arena;
		this.troop = troop;
	}


	/**
	 * Runs this operation.
	 */
	@Override
	public void run ()
	{
		final int[] position = this.arena.getGameBoard().getTroopPosition(this.troop);
		final List<Tile> adjacentTroopTiles = this.arena.getGameBoard().getAdjacentTroopTiles(position);
		final List<Tile> adjacentAccessibleTiles = this.arena.getGameBoard().getAdjacentAccessibleTiles(position);

		System.out.println("getAdjacentAccessibleTiles = " + adjacentAccessibleTiles);
		System.out.println("getAdjacentTroopTiles = " + adjacentTroopTiles);

		boolean hasAttacked = false;
		if (!adjacentTroopTiles.isEmpty())
		{
			hasAttacked = EnemyController.attackAdjacentTroop(this.arena, adjacentTroopTiles, this.troop);
		}
		if (!adjacentAccessibleTiles.isEmpty() && !hasAttacked)
		{
			EnemyController.moveToAdjacentTile(this.arena, adjacentAccessibleTiles.getFirst(), this.troop);
		}
		this.arenaDelegate.initializeGameBoard();
	}

}
