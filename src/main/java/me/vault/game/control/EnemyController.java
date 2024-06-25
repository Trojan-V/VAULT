package me.vault.game.control;


import javafx.application.Platform;
import me.vault.game.model.GameDifficulty;
import me.vault.game.model.arena.Arena;
import me.vault.game.model.arena.EnemyActionRunnable;
import me.vault.game.model.arena.Tile;
import me.vault.game.model.troop.Troop;
import me.vault.game.model.troop.TroopLevel;
import me.vault.game.view.ArenaDelegate;

import java.util.ArrayList;


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
		return false;
	}


	public static ArrayList<Troop> adjustEnemiesByDifficulty (final ArrayList<Troop> encounterEnemies)
	{
		final TroopLevel troopLevelForDifficulty = getTroopLevelForDifficulty();

		for (final Troop enemy : encounterEnemies)
		{
			enemy.setLevel(troopLevelForDifficulty);
			TroopController.getInstance().updateValues(enemy);
		}
		return encounterEnemies;
	}


	private static TroopLevel getTroopLevelForDifficulty ()
	{
		final GameDifficulty difficulty = GameController.getInstance().getDifficulty();
		TroopLevel adjustLevel = null;
		switch (difficulty)
		{
			case EASY_MODE -> adjustLevel = TroopLevel.SINGLE_COMBATANT;
			case NORMAL_MODE -> adjustLevel = TroopLevel.COUPLE;
			case HARD_MODE -> adjustLevel = TroopLevel.SQUAD;
		}
		return adjustLevel;
	}

}
