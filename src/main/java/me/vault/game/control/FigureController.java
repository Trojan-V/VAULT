package me.vault.game.control;


import me.vault.game.model.arena.*;
import me.vault.game.model.troop.DefensiveStatistic;
import me.vault.game.model.troop.OffensiveStatistics;
import me.vault.game.model.troop.Troop;
import me.vault.game.utility.logging.ILogger;
import me.vault.game.utility.logging.Logger;

import java.util.List;


public final class FigureController
{

	/**
	 * The {@link Logger} object for this class used for writing to the console.
	 */
	private static final ILogger Logger = new Logger(FigureController.class.getName());


	private FigureController () {}


	public static void moveFigure (final Arena arena, final Figure<? extends Troop> troopFigure, final Position nextPosition)
	{
		final GameBoard arenaGameBoard = arena.getGameBoard();
		final Position previousTroopPosition = arenaGameBoard.getFigurePosition(troopFigure);
		arenaGameBoard.placeFigure(nextPosition, troopFigure);
		arenaGameBoard.setPlaceable(previousTroopPosition, new Placeholder());
	}


	public static void moveFigure (final Arena arena, final Figure<? extends Troop> troopFigure, final Tile nextTile)
	{
		final GameBoard arenaGameBoard = arena.getGameBoard();
		final Position previousTroopPosition = arenaGameBoard.getFigurePosition(troopFigure);
		final Position nextTroopPosition = new Position(nextTile.getRow(), nextTile.getColumn());
		arenaGameBoard.placeFigure(nextTroopPosition, troopFigure);
		arenaGameBoard.setPlaceable(previousTroopPosition, new Placeholder());
	}


	public static void attackFigure (final Arena arena, final Figure<? extends Troop> attackerFigure, final Figure<? extends Troop> defenderFigure)
	{
		final OffensiveStatistics attackerOffensiveStats = attackerFigure.getStatistics().getOffensiveStatistic();
		final DefensiveStatistic defenderDefensiveStats = defenderFigure.getStatistics().getDefensiveStatistic();

		System.out.println("attackerFigure = " + attackerOffensiveStats);
		System.out.println("defenderFigure = " + defenderDefensiveStats);
	}


	public static boolean figureCanMoveToPosition (final Arena arena, final Figure<? extends Troop> troopFigure, final Position position)
	{
		final GameBoard arenaGameBoard = arena.getGameBoard();
		final Position previousTroopPosition = arenaGameBoard.getFigurePosition(troopFigure);
		final int troopMovementRange = troopFigure.getStatistics().getDexterityStatistic().getMovementTiles();
		final List<Tile> accessibleTiles = arenaGameBoard.getAdjacentAccessibleTiles(previousTroopPosition, troopMovementRange);
		return accessibleTiles.contains(arena.getGameBoard().getTile(position));
	}


	public static boolean figureCanAttackFigure (final Arena arena, final Figure<? extends Troop> attackerFigure, final Position position)
	{
		try
		{
			final Figure<? extends Troop> defender = arena.getGameBoard().getFigure(position);
			final Position attackerPos = arena.getGameBoard().getFigurePosition(attackerFigure);
			final List<Tile> reachableTiles = arena.getGameBoard().getAdjacentTiles(attackerPos, attackerFigure.getStatistics().getOffensiveStatistic().getGrenadeRange());

			final List<Figure<? extends Troop>> defenderGroup = arena.getPlayerOneTroops().contains(defender) ? arena.getPlayerOneTroops() : arena.getPlayerTwoTroops();
			return !defenderGroup.contains(attackerFigure) && reachableTiles.contains(arena.getGameBoard().getTile(position));
		}
		catch (final Exception e)
		{
			throw new RuntimeException(e);
		}
	}

}
