package me.vault.game.model.arena;


import me.vault.game.control.EnemyController;
import me.vault.game.model.troop.Troop;

import java.util.List;


public class EnemyActionRunnable implements Runnable
{


	private final Arena arena;

	private final Figure<Troop> troop;


	public EnemyActionRunnable (final Arena arena, final Figure<Troop> troopFigure)
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
		final Position position = this.arena.getGameBoard().getFigurePosition(this.troop);
		final int range = this.troop.getStatistics().getOffensiveStatistic().getGrenadeRange();
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
			EnemyController.moveToAdjacentTile(this.arena, adjacentAccessibleTiles.getFirst(), this.troop);
		}
	}

}
