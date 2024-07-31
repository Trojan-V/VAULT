package me.vault.game.control;


import me.vault.game.model.GameDifficulty;
import me.vault.game.model.arena.Arena;
import me.vault.game.model.gameboard.Figure;
import me.vault.game.model.gameboard.tile.Tile;
import me.vault.game.model.troop.TroopLevel;
import me.vault.game.utility.logging.ILogger;
import me.vault.game.utility.logging.Logger;

import static me.vault.game.utility.interfaces.constant.LoggingConstants.ArenaDelegate.ATTACKED_MSG;
import static me.vault.game.utility.logging.ILogger.Level.DEBUG;


/**
 * Controller class to handle enemy actions in the arena, such as moving or attacking.
 * This class basically provides a very simple enemy engine to let the 'computer' enemies move by themselves in the
 * arena.
 *
 * @author Vincent Wolf, Lasse-Leander Hillen, Timothy Hoegen-Jupp, Alexander Goethel
 * @version 1.0.0
 * @since 28.07.2024
 */
public final class EnemyController
{

	/**
	 * The {@link Logger} object for this class used for writing to the console.
	 */
	private static final ILogger LOGGER = new Logger(EnemyController.class.getSimpleName());


	/**
	 * As this class solely contains static methods and therefore is a utility class,
	 * no other class should be able to instantiate it.
	 * <br>
	 * To prohibit the instantiation from anywhere else but within the class, a private constructor is used.
	 *
	 * @precondition Constructor gets called from within the class.
	 * @postcondition A new instance of EnemyController is created.
	 */
	private EnemyController () {}


	/**
	 * Scans the area around the enemy. If an allied troop (so an enemy for the enemy) is next to the enemy, it'll
	 * attack.
	 *
	 * @param arena              The instance of the arena where the encounter is happening.
	 * @param adjacentTroopTiles An {@link Iterable} of all tiles that are adjacent to the enemy.
	 * @param troopFigure        The enemy {@link Figure}.
	 *
	 * @return True, if the enemy attacked an allied troop, otherwise false.
	 *
	 * @precondition An {@link Arena}, {@link Iterable}, and a {@link Figure} != null are passed into the method.
	 * @postcondition The figure tried to attack an adjacent enemy, and the result of that process was returned.
	 */
	public static boolean tryAttackAdjacentTroop (final Arena arena, final Iterable<Tile> adjacentTroopTiles, final Figure troopFigure)
	{
		for (final Tile tile : adjacentTroopTiles)
		{
			final Figure adjacentTroopFigure = (Figure) tile.getCurrentElement();
			if (arena.getPlayerOneFigures().contains(adjacentTroopFigure))
			{
				FigureController.attack(arena, troopFigure, adjacentTroopFigure);
				LOGGER.logf(DEBUG, ATTACKED_MSG, troopFigure.getName(), adjacentTroopFigure.getName());
				return true;
			}
		}
		return false;
	}


	/**
	 * Returns the level the enemies should have depending on the configured difficulty.
	 *
	 * @return The level of the enemies depending on the configured difficulty.
	 *
	 * @precondition Method gets called.
	 * @postcondition The corresponding TroopLevel for the selected game difficulty was returned.
	 */
	private static TroopLevel getEnemyLevelForDifficulty ()
	{
		final GameDifficulty difficulty = GameController.getDifficulty();
		TroopLevel adjustedLevel = null;
		switch (difficulty)
		{
			case EASY -> adjustedLevel = TroopLevel.SINGLE_COMBATANT;
			case NORMAL -> adjustedLevel = TroopLevel.COUPLE;
			case HARD -> adjustedLevel = TroopLevel.SQUAD;
		}
		return adjustedLevel;
	}

}
