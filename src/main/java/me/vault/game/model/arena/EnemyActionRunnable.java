package me.vault.game.model.arena;


import javafx.geometry.Pos;
import me.vault.game.control.EnemyController;
import me.vault.game.model.troop.Troop;
import me.vault.game.view.ArenaDelegate;

import java.util.List;


public class EnemyActionRunnable implements Runnable
{

	private final ArenaDelegate arenaDelegate;

	private final Arena arena;

	private final Figure<Troop> troop;


	public EnemyActionRunnable (final ArenaDelegate instance, final Arena arena, final Figure<Troop> troop)
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
		this.arenaDelegate.initializeGameBoard();
	}

}
