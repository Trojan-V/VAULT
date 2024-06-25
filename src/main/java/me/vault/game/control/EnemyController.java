package me.vault.game.control;


import javafx.application.Platform;
import me.vault.game.model.arena.Arena;
import me.vault.game.model.arena.EnemyActionRunnable;
import me.vault.game.model.arena.Tile;
import me.vault.game.model.troop.Troop;
import me.vault.game.view.ArenaDelegate;


public class EnemyController
{

	public static void handleEnemyAction (final ArenaDelegate instance, final Arena arena, final Troop troop)
	{
		Platform.runLater(new EnemyActionRunnable(instance, arena, troop));

	}


	public static void moveToAdjacentTile (final Arena arena, final Tile adjacentAccessibleTile, final Troop troop)
	{
		TroopController.getInstance().moveTroop(arena, troop, adjacentAccessibleTile.getRow(), adjacentAccessibleTile.getColumn());
	}


	public static boolean attackAdjacentTroop (final Arena arena, final Iterable<Tile> adjacentTroopTiles, final Troop troop)
	{
		for (final Tile tile : adjacentTroopTiles)
		{
			final Troop adjacentTroop = (Troop) tile.getCurrentElement();
			if (arena.getPlayerOneTroops().contains(adjacentTroop))
			{
				TroopController.getInstance().attackTroop(arena, troop, adjacentTroop);
				System.out.println(troop.getName() + " attacked " + adjacentTroop.getName());
				return true;
			}
		}
		System.out.println(troop.getName() + " -> No attack in range");
		return false;
	}


	private static void wait (int ms)
	{
		try
		{
			Thread.sleep(ms);
		}
		catch (InterruptedException ex)
		{
			Thread.currentThread().interrupt();
		}
	}

}
