package me.vault.game.model.arena;


import me.vault.game.control.EnemyController;

import java.util.List;


public class EnemyActionRunnable implements Runnable
{


	private final Arena arena;


	private final Figure troop;


	public EnemyActionRunnable (final Arena arena, final Figure troopFigure)
	{
		this.arena = arena;
		this.troop = troopFigure;
	}


	/**
	 * Runs this operation.
	 */
	@Override
	public void run ()
	{
		final Position position = this.arena.getGameBoard().getPosition(this.troop);
		final int range = this.troop.getStatistics().getOffensive().getGrenadeRange();
		final List<Tile> reachableTroopFigureTiles = this.arena.getGameBoard().getReachableTroopFigureTiles(position, range);
		final List<Tile> adjacentAccessibleTiles = this.arena.getGameBoard().getAdjacentAccessibleTiles(position);

		System.out.println("getAdjacentAccessibleTiles = " + adjacentAccessibleTiles);
		System.out.println("getAdjacentTroopTiles = " + reachableTroopFigureTiles);

		boolean hasAttacked = false;
		if (!reachableTroopFigureTiles.isEmpty())
		{
			hasAttacked = EnemyController.attackAdjacentTroop(this.arena, reachableTroopFigureTiles, this.troop);
		}
		if (!adjacentAccessibleTiles.isEmpty() && !hasAttacked)
		{
			EnemyController.moveTo(this.arena, adjacentAccessibleTiles.getFirst(), this.troop);
		}
	}
}
