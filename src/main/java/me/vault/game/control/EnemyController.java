package me.vault.game.control;


import me.vault.game.model.GameDifficulty;
import me.vault.game.model.arena.Arena;
import me.vault.game.model.arena.Figure;
import me.vault.game.model.arena.Tile;
import me.vault.game.model.troop.Troop;
import me.vault.game.model.troop.TroopLevel;
import me.vault.game.view.ArenaDelegate;

import java.util.ArrayList;


public class EnemyController
{

	public static void handleEnemyAction (final ArenaDelegate instance, final Arena arena, final Figure<Troop> troop)
	{
		// Platform.runLater(new EnemyActionRunnable(instance, arena, troop));
	}


	public static void moveToAdjacentTile (final Arena arena, final Tile adjacentAccessibleTile, final Figure<Troop> troopFigure)
	{
		FigureController.moveFigure(arena.getGameBoard(), troopFigure, adjacentAccessibleTile.getPosition());
	}


	public static boolean attackAdjacentTroop (final Arena arena, final Iterable<Tile> adjacentTroopTiles, final Figure<? extends Troop> troopFigure)
	{
		for (final Tile tile : adjacentTroopTiles)
		{
			final Figure<? extends Troop> adjacentTroopFigure = (Figure<? extends Troop>) tile.getCurrentElement();
			if (arena.getPlayerOneTroops().contains(adjacentTroopFigure))
			{
				FigureController.attackFigure(arena, troopFigure, adjacentTroopFigure);
				System.out.println(troopFigure.getName() + " attacked " + adjacentTroopFigure.getName());
				return true;
			}
		}
		return false;
	}


	public static ArrayList<? extends Troop> adjustEnemiesByDifficulty (final ArrayList<? extends Troop> encounterEnemies)
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
