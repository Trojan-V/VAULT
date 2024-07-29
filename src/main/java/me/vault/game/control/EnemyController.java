package me.vault.game.control;


import me.vault.game.model.GameDifficulty;
import me.vault.game.model.arena.Arena;
import me.vault.game.model.arena.Figure;
import me.vault.game.model.arena.Tile;
import me.vault.game.model.troop.Troop;
import me.vault.game.model.troop.TroopLevel;
import me.vault.game.utility.logging.ILogger;
import me.vault.game.utility.logging.Logger;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import static me.vault.game.utility.constant.ArenaConstants.ATTACKED_MSG;
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
	 */
	private EnemyController () {}


	/**
	 * Moves the enemy to the supplied tile.
	 *
	 * @param arena       The instance of the arena where the encounter is happening.
	 * @param tile        The tile the enemy should move to.
	 * @param troopFigure The enemy {@link Figure}.
	 */
	public static void moveTo (final Arena arena, final Tile tile, final Figure<Troop> troopFigure)
	{
		FigureController.moveFigure(arena.getGameBoard(), troopFigure, tile.getPosition());
	}


	/**
	 * Scans the area around the enemy. If an allied troop (so an enemy for the enemy) is next to the enemy, it'll
	 * attack.
	 *
	 * @param arena The instance of the arena where the encounter is happening.
	 * @param adjacentTroopTiles An {@link Iterable} of all tiles that are adjacent to the enemy.
	 * @param troopFigure The enemy {@link Figure}.
	 * @return True, if the enemy attacked an allied troop, otherwise false.
	 */
	public static boolean attackAdjacentTroop (final Arena arena, final Iterable<Tile> adjacentTroopTiles, final Figure<? extends Troop> troopFigure)
	{
		for (final Tile tile : adjacentTroopTiles)
		{
			final Figure<? extends Troop> adjacentTroopFigure = (Figure<? extends Troop>) tile.getCurrentElement();
			if (arena.getPlayerOneTroops().contains(adjacentTroopFigure))
			{
				FigureController.attackFigure(arena, troopFigure, adjacentTroopFigure);
				LOGGER.log(DEBUG, MessageFormat.format(ATTACKED_MSG, troopFigure.getName(),
					adjacentTroopFigure.getName()));
				return true;
			}
		}
		return false;
	}


	/**
	 * The level of the enemies is increased depending on the difficulty that was selected in the main menu.
	 *
	 * @param encounterEnemies A list of all enemies that appear in the encounter.
	 * @return A {@link List} of the supplied enemies with the adjusted difficulty level.
	 */
	public static ArrayList<? extends Troop> adjustEnemiesByDifficulty (final ArrayList<? extends Troop> encounterEnemies)
	{
		for (final Troop enemy : encounterEnemies)
		{
			enemy.setLevel(getEnemyLevelForDifficulty());
			TroopController.getInstance().updateValues(enemy);
		}
		return encounterEnemies;
	}


	/**
	 * Returns the level the enemies should have depending on the configured difficulty.
	 *
	 * @return The level of the enemies depending on the configured difficulty.
	 */
	private static TroopLevel getEnemyLevelForDifficulty ()
	{
		final GameDifficulty difficulty = GameController.getInstance().getDifficulty();
		TroopLevel adjustedLevel = null;
		switch (difficulty)
		{
			case EASY_MODE -> adjustedLevel = TroopLevel.SINGLE_COMBATANT;
			case NORMAL_MODE -> adjustedLevel = TroopLevel.COUPLE;
			case HARD_MODE -> adjustedLevel = TroopLevel.SQUAD;
		}
		return adjustedLevel;
	}

}
