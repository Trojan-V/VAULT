package me.vault.game.control;


import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import me.vault.game.interfaces.Placeable;
import me.vault.game.model.arena.*;
import me.vault.game.model.player.Player;
import me.vault.game.model.troop.Troop;
import me.vault.game.model.troop.TroopStatistics.Defensive;
import me.vault.game.model.troop.TroopStatistics.Offensive;
import me.vault.game.utility.logging.ILogger;
import me.vault.game.utility.logging.Logger;
import org.jetbrains.annotations.NotNull;

import java.util.List;


/**
 * Controller class to handle allie actions in the arena, such as moving or attacking.
 *
 * @author Vincent Wolf
 * @version 1.0.0
 * @see EnemyController
 * @since 29.07.2024
 */
public final class FigureController
{

	/**
	 * The {@link Logger} object for this class used for writing to the console.
	 */
	private static final ILogger LOGGER = new Logger(FigureController.class.getName());


	/**
	 * The radius of the drop shadow effect that is rendered around the sprites which display the allied figures.
	 */
	private static final int DROP_SHADOW_RADIUS = 15;


	/**
	 * The spread of the drop shadow effect that is rendered around the sprites which display the allied figures.
	 */
	private static final double DROP_SHADOW_SPREAD = 0.5;


	/**
	 * As this class solely contains static methods and therefore is a utility class,
	 * no other class should be able to instantiate it.
	 * <br>
	 * To prohibit the instantiation from anywhere else but within the class, a private constructor is used.
	 */
	private FigureController ()
	{
	}


	/**
	 * Moves the {@link Placeable} on the {@link GameBoard} to the supplied {@link Position}.
	 *
	 * @param gameBoard    The {@link GameBoard} where the encounter is happening.
	 * @param placeable    Should be either a {@link Figure <? extends Troop>} or a {@link Player}. But generally
	 *                     speaking, this is the {@link Placeable} that will be moved on the {@link GameBoard}.
	 * @param nextPosition The position the {@link Placeable} should be moved to.
	 */
	public static void move (final GameBoard gameBoard, final Placeable placeable, final Position nextPosition)
	{
		final Position previousTroopPosition = gameBoard.getPosition(placeable);
		gameBoard.placeIfAccessibleTile(nextPosition, placeable);

		// Set the previous position of the troop back to an accessible tile
		// so the troop isn't displayed multiple times.
		gameBoard.place(previousTroopPosition, new AccessibleTileAppearance());
	}


	/**
	 * Attacks another {@link Figure} in the arena.
	 *
	 * @param arena    The {@link Arena} instance where the encounter is happening.
	 * @param attacker The {@link Figure} who is the attacker.
	 * @param defender The {@link Figure} who is the defender.
	 */
	public static void attack (final Arena arena, final Figure<? extends Troop> attacker,
		final Figure<? extends Troop> defender)
	{
		// Get the statistics of the attacker and defender so the damage can be calculated.
		final Offensive attackerOffensiveStats = attacker.getStatistics().getOffensive();
		final Defensive defenderDefensiveStats = defender.getStatistics().getDefensive();

		// TODO: remove prints
		System.out.println("attacker = " + attackerOffensiveStats);
		System.out.println("defender = " + defenderDefensiveStats);

		final int calculatedDamage = calculateDamage(attackerOffensiveStats, defenderDefensiveStats);
		final int newDefenderHealthPoints = defenderDefensiveStats.getHealth() - calculatedDamage;

		// TODO: remove prints
		System.out.println("calculatedDamage = " + calculatedDamage);
		System.out.println("newDefenderHealthPoints = " + newDefenderHealthPoints);

		// Remove the defender from the arena if his HP dropped to zero or below, as the unit died.
		if (newDefenderHealthPoints <= 0)
		{
			arena.removeTroopFigure(defender);
			return;
		}
		defenderDefensiveStats.setHealth(newDefenderHealthPoints);
	}


	/**
	 * Calculates the damage the attacker will deal to the defender.
	 * <br>
	 * The formula takes the melee damage the attacker deals into account as well as the armor the defender has.
	 *
	 * @param attackerStats          The {@link me.vault.game.model.troop.TroopStatistics.Offensive} statistics of the
	 *                               attacking unit.
	 * @param defenderDefensiveStats The {@link me.vault.game.model.troop.TroopStatistics.Defensive} statistics of the
	 *                               defensive unit.
	 * @return The amount of damage the defender will receive.
	 */
	private static int calculateDamage (final Offensive attackerStats, final Defensive defenderDefensiveStats)
	{
		return attackerStats.getMeleeDamage() * (1 - defenderDefensiveStats.getArmor() / 100);
	}


	public static boolean figureCanMoveToPosition (final GameBoard arenaGameBoard,
		final Figure<? extends Troop> troopFigure, final Position position)
	{
		final Position previousTroopPosition = arenaGameBoard.getPosition(troopFigure);
		final int troopMovementRange = troopFigure.getStatistics().getDexterity().getMovementTiles();
		final List<Tile> accessibleTiles =
			arenaGameBoard.getAdjacentPlaceholderTiles(previousTroopPosition, troopMovementRange);
		return accessibleTiles.contains(arenaGameBoard.getTile(position));
	}


	public static boolean playerCanMoveToPosition (final GameBoard missionGameBoard, final Player player,
		final Position position)
	{
		final Position previousTroopPosition = missionGameBoard.getPosition(player);
		final List<Tile> accessibleTiles = missionGameBoard.getAdjacentPlaceholderTiles(previousTroopPosition);
		return accessibleTiles.contains(missionGameBoard.getTile(position));
	}


	public static boolean figureCanAttackFigure (final Arena arena, final Figure<? extends Troop> attackerFigure,
		final Position position)
	{
		try
		{
			final Figure<? extends Troop> defender = arena.getGameBoard().getFigure(position);
			final Position attackerPos = arena.getGameBoard().getPosition(attackerFigure);
			final List<Tile> reachableTiles = arena.getGameBoard()
				.getAdjacentTiles(attackerPos, attackerFigure.getStatistics().getOffensive().getGrenadeRange());

			final List<Figure<? extends Troop>> defenderGroup =
				arena.getPlayerOneTroops().contains(defender) ? arena.getPlayerOneTroops() :
				arena.getPlayerTwoTroops();
			return !defenderGroup.contains(attackerFigure) &&
			       reachableTiles.contains(arena.getGameBoard().getTile(position));
		}
		catch (final Exception e)
		{
			throw new RuntimeException(e);
		}
	}


	public static boolean playerCanReachPosition (final GameBoard missionGameBoard, final Player player,
		final Position position)
	{
		final Position previousTroopPosition = missionGameBoard.getPosition(player);
		final List<Tile> accessibleTiles = missionGameBoard.getAdjacentTiles(previousTroopPosition);
		return accessibleTiles.contains(missionGameBoard.getTile(position));
	}


	public static void setTroopFigureGlow (final @NotNull Arena arena, final @NotNull ImageView imageView,
		final @NotNull Figure<? extends Troop> troopFigure)
	{
		if (arena.getPlayerOneTroops().contains(troopFigure))
		{
			final DropShadow playerIdentity = new DropShadow(DROP_SHADOW_RADIUS, Color.BLUE);
			playerIdentity.setSpread(DROP_SHADOW_SPREAD);
			imageView.setEffect(playerIdentity);
		}
		else if (arena.getPlayerTwoTroops().contains(troopFigure))
		{
			final DropShadow playerIdentity = new DropShadow(DROP_SHADOW_RADIUS, Color.RED);
			playerIdentity.setSpread(DROP_SHADOW_SPREAD);
			imageView.setEffect(playerIdentity);
		}
	}

}
