package me.vault.game.control;


import me.vault.game.model.arena.Arena;
import me.vault.game.model.arena.Tile;
import me.vault.game.model.troop.Troop;

import java.util.List;
import java.util.SequencedCollection;


public class EnemyController
{

	public static void handleEnemyAction (final Arena arena, final Troop troop)
	{
		final int[] position = arena.getGameBoard().getTroopPosition(troop);

		final List<Tile> adjacentTroopTiles = arena.getGameBoard().getAdjacentTroopTiles(position);

		final List<Tile> adjacentAccessibleTiles = arena.getGameBoard().getAdjacentAccessibleTiles(position);

		System.out.println("getAdjacentAccessibleTiles = " + adjacentAccessibleTiles);
		System.out.println("getAdjacentTroopTiles = " + adjacentTroopTiles);

		if (!adjacentTroopTiles.isEmpty())
		{
			attackAdjacentTroop(arena, adjacentTroopTiles, troop);
		}
		else if (!adjacentAccessibleTiles.isEmpty())
		{
			moveToAdjacentTile(arena, adjacentAccessibleTiles.getFirst(), troop);
		}
	}


	private static void moveToAdjacentTile (final Arena arena, final Tile adjacentAccessibleTile, final Troop troop)
	{
		TroopController.getInstance().moveTroop(arena, troop, adjacentAccessibleTile.getRow(), adjacentAccessibleTile.getColumn());
	}


	private static void attackAdjacentTroop (final Arena arena, final Iterable<Tile> adjacentTroopTiles, final Troop troop)
	{
		for (final Tile tile : adjacentTroopTiles)
		{
			final Troop adjacentTroop = (Troop) tile.getCurrentElement();
			if (arena.getPlayerOneTroops().contains(adjacentTroop))
			{
				TroopController.getInstance().attackTroop(arena, troop, adjacentTroop);
				System.out.println(troop.getName() + " attacked " + adjacentTroop.getName());
				break;
			}
		}
		System.out.println(troop.getName() + " -> No attack in range");

	}

}
