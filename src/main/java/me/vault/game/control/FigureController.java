package me.vault.game.control;


import me.vault.game.model.arena.*;
import me.vault.game.model.troop.DefensiveStatistic;
import me.vault.game.model.troop.OffensiveStatistics;
import me.vault.game.model.troop.Troop;

import java.util.List;


public final class FigureController
{

	private FigureController () {}


	public static void moveFigure (final Arena arena, final Figure<Troop> troopFigure, final int i, final int j)
	{
		final GameBoard arenaGameBoard = arena.getGameBoard();
		final int[] previousTroopPosition = arenaGameBoard.getFigurePosition(troopFigure);
		arenaGameBoard.placeFigure(i, j, troopFigure);
		arenaGameBoard.setPlaceable(previousTroopPosition[0], previousTroopPosition[1], new Placeholder());
	}


	public static void attackFigure (final Arena arena, final Figure<Troop> attackerFigure, final Figure<Troop> defenderFigure)
	{
		final OffensiveStatistics attackerOffensiveStats = attackerFigure.getStatistics().getOffensiveStatistic();
		final DefensiveStatistic defenderDefensiveStats = defenderFigure.getStatistics().getDefensiveStatistic();

		System.out.println("attackerFigure = " + attackerFigure);
		System.out.println("defenderFigure = " + defenderFigure);
	}

	public static boolean figureCanMoveToPosition (final Arena arena, final Figure<Troop> troopFigure, final int i, final int j)
	{
		final GameBoard arenaGameBoard = arena.getGameBoard();
		final int[] previousTroopPosition = arenaGameBoard.getFigurePosition(troopFigure);
		final int troopMovementRange = troopFigure.getStatistics().getDexterityStatistic().getMovementTiles();
		final List<Tile> accessibleTiles = arenaGameBoard.getAdjacentAccessibleTiles(previousTroopPosition, troopMovementRange);
		return accessibleTiles.contains(arena.getGameBoard().getTile(i, j));
	}


	public static boolean figureCanAttackFigure (final Arena arena, final Figure<Troop> attackerFigure, final int row, final int column)
	{
		try
		{
			final Figure<Troop> defender = arena.getGameBoard().getFigure(row, column);
			final int[] attackerPos = arena.getGameBoard().getFigurePosition(attackerFigure);
			final List<Tile> reachableTiles = arena.getGameBoard().getAdjacentTiles(attackerPos[0], attackerPos[1], attackerFigure.getStatistics().getOffensiveStatistic().getGrenadeRange());

			final List<Figure<Troop>> defenderGroup = arena.getPlayerOneTroops().contains(defender) ? arena.getPlayerOneTroops() : arena.getPlayerTwoTroops();
			return !defenderGroup.contains(attackerFigure) && reachableTiles.contains(arena.getGameBoard().getTile(row, column));
		}
		catch (final Exception e)
		{
			throw new RuntimeException(e);
		}
	}
}
