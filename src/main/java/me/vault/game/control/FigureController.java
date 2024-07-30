package me.vault.game.control;


import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import me.vault.game.exception.ElementNotFoundOnGameBoardException;
import me.vault.game.exception.NotAFigureException;
import me.vault.game.model.arena.Arena;
import me.vault.game.model.arena.Figure;
import me.vault.game.model.arena.Position;
import me.vault.game.model.arena.Tile;
import me.vault.game.model.artifact.Artifact;
import me.vault.game.model.energy.Energy;
import me.vault.game.model.gameboard.GameBoard;
import me.vault.game.model.player.Player;
import me.vault.game.model.troop.TroopStatistics.Defensive;
import me.vault.game.utility.logging.ILogger;
import me.vault.game.utility.logging.Logger;
import me.vault.game.utility.math.Dice;
import me.vault.game.view.ArenaDelegate;
import org.jetbrains.annotations.NotNull;

import java.util.List;

import static me.vault.game.utility.logging.ILogger.Level.WARNING;


/**
 * Controller class to handle enemy actions in the arena, such as attacking.
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
	private static final ILogger LOGGER = new Logger(FigureController.class.getSimpleName());

	/**
	 * The radius of the drop shadow effect that is rendered around the sprites which display the allied figures.
	 */
	private static final int DROP_SHADOW_RADIUS = 15;


	/**
	 * The spread of the drop shadow effect that is rendered around the sprites which display the allied figures.
	 */
	private static final double DROP_SHADOW_SPREAD = 0.5;


	/**
	 * The divisor changes a natural number from zero to hundred to a rational number from zero to one. The Number
	 * represent the armor value of the defending troop.
	 */
	private static final int DIVISOR_TO_CHANGE_ARMOR_TO_A_PERCENT_NUMBER = 100;


	/**
	 * A multiplier from which the armor of the defender will be subtracted before being multiplied with the melee
	 * damage from the attacker.
	 */
	private static final int MULTIPLIER_FOR_DAMAGE = 1;


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
	 * Attacks another {@link Figure} in the arena.
	 *
	 * @param arena    The {@link Arena} instance where the encounter is happening.
	 * @param attacker The {@link Figure} who is the attacker.
	 * @param defender The {@link Figure} who is the defender.
	 * @pre.condition The attacking and defending unit stand on adjacent tiles.
	 * @post.condition The attacking unit may or may not deal damage to the defending troop.
	 */
	public static void attack (final Arena arena, final Figure attacker,
		final Figure defender)
	{
		// Get the statistics of the attacker and defender so the damage can be calculated.
		final Defensive defenderDefensiveStats = defender.getStatistics().getDefensive();
		final int dice = Dice.rollD100();

		if (dice >= defenderDefensiveStats.getDodgeRate())
		{
			final int calculatedDamage = calculateDamage(attacker, defender,arena);
			final int newDefenderHealthPoints = defenderDefensiveStats.getHealth() - calculatedDamage;
			if (newDefenderHealthPoints <= 0)
			{
				// Remove the defender from the arena if his HP dropped to zero or below, as the unit died.
				try
				{
					final Position defenderPosition = arena.getGameBoard().getPosition(defender);
					arena.eliminateFigure(defender);
					MovableController.move(arena.getGameBoard(), attacker, defenderPosition);
					return;
				}
				catch (ElementNotFoundOnGameBoardException e)
				{
					LOGGER.log(WARNING, e.getMessage());
				}

			}
			defenderDefensiveStats.setHealth(newDefenderHealthPoints);
		}
		else
		{
			defenderDefensiveStats.setHealth(defenderDefensiveStats.getHealth());
		}
	}


	/**
	 * Calculates the damage the attacker will deal to the defender.
	 * @param attackerStats                 The {@link Figure} statistics of the
	 * 	                                     attacking unit.
	 * @param defenderDefensiveStats        The {@link Figure} statistics of the
	 * 	                                    defensive unit.
	 * @param arena                         The arena where the encounter takes place.
	 * @return The amount of damage the defender will receive.
	 * @pre.condition The attacker did hit the defender.
	 * @post.condition The defender will receive damage.
	 */
	private static int calculateDamage (final Figure attackerStats, final Figure defenderDefensiveStats,
		final @NotNull Arena arena)
	{
		final Artifact currentArtifact = Player.getInstance().getSelectedArtifact();
		final Energy currenrEnergy = Player.getInstance().getSelectedEnergy();
		final Figure troopFigure = arena.getSelectedFigure();
		final double damageMultiplier = currentArtifact.getAttributeMultipliers().getDamageMultiplierProperty().get();
		final double defenseMultiplier = currentArtifact.getAttributeMultipliers().getDefenseMultiplierProperty().get();
		final double meleeMultiplier = currenrEnergy.getAbilityMultiplier().getMeleeMultiplierProperty().get();
		final int meleeDamage = attackerStats.getStatistics().getOffensive().getMeleeDamage();
		final int armor = defenderDefensiveStats.getStatistics().getDefensive().getArmor();
		double dealtDamage = 0;
		if (isAlly(arena, troopFigure))
		{
			dealtDamage =
				(meleeDamage * (MULTIPLIER_FOR_DAMAGE - (armor * defenseMultiplier) / DIVISOR_TO_CHANGE_ARMOR_TO_A_PERCENT_NUMBER) * damageMultiplier) * meleeMultiplier;
		}
		else if (isEnemy(arena,troopFigure))
		{
			dealtDamage =
				(meleeDamage * (MULTIPLIER_FOR_DAMAGE - (armor * defenseMultiplier) / DIVISOR_TO_CHANGE_ARMOR_TO_A_PERCENT_NUMBER));
		}
		return (int) dealtDamage;
	}


	/**
	 * Checks if the {@link Figure} can move to the supplied {@link Position}.
	 *
	 * @param arena       The arena where the encounter takes place.
	 * @param troopFigure The {@link Figure} for which will be checked if it can move to the supplied position.
	 * @param position    The position the {@link Figure} wants to move to.
	 *
	 * @return True if the {@link Figure} can move to the supplied {@link Position}, otherwise false.
	 * @pre.condition The parameters needed for the check do exist.
	 * @post.condition Gives a boolean that states if the troop can move or not.
	 */
	public static boolean canMoveToPosition (final Arena arena, final Figure troopFigure, final Position position)
	{
		final GameBoard arenaGameBoard = arena.getGameBoard();

		try
		{
			final Position previousTroopPosition = arenaGameBoard.getPosition(troopFigure);
			final int troopMovementRange = troopFigure.getStatistics().getDexterity().getMovementTiles();
			final List<Tile> accessibleTiles = arenaGameBoard.getAdjacentAccessibleTiles(previousTroopPosition, troopMovementRange);
			return accessibleTiles.contains(arenaGameBoard.getTile(position));
		}
		catch (ElementNotFoundOnGameBoardException e)
		{
			LOGGER.log(WARNING, e.getMessage());
		}

		return false;
	}


	/**
	 * Checks if the {@link Figure} can attack the other {@link Figure} at the supplied {@link Position}.
	 *
	 * @param arena          The arena where the encounter takes place.
	 * @param attackerFigure The {@link Figure} which wants to attack another {@link Figure}.
	 * @param position       The position the {@link Figure} wants to attack at.
	 *
	 * @return True if the {@link Figure} can attack the {@link Figure} at the supplied {@link Position}, otherwise
	 * false.
	 * @pre.condition The parameters needed for the check do exist.
	 * @post.condition Gives a boolean that states if the troop can attack or not.
	 */
	public static boolean canAttackAtPosition (final Arena arena, final Figure attackerFigure, final Position position)
	{
		try
		{
			final GameBoard arenaGameBoard = arena.getGameBoard();
			final Figure defender = arenaGameBoard.getFigure(position);
			final Position attackerPos = arenaGameBoard.getPosition(attackerFigure);
			final List<Tile> reachableTiles = arenaGameBoard.getAdjacentTiles(attackerPos, attackerFigure.getStatistics().getOffensive().getGrenadeRange());

			final List<Figure> defenderGroup = arena.getPlayerOneFigures().contains(defender) ? arena.getPlayerOneFigures() : arena.getPlayerTwoFigures();
			return !defenderGroup.contains(attackerFigure) && reachableTiles.contains(arenaGameBoard.getTile(position));
		}
		catch (final NotAFigureException | ElementNotFoundOnGameBoardException e)
		{
			LOGGER.log(WARNING, e.getMessage());
			return false;
		}
	}


	/**
	 * Sets the glow effect of the supplied {@link Figure}.
	 *
	 * @param arena       The arena where the figure is located.
	 * @param imageView   The image view (basically the sprite) which gets manipulated to apply the glow effect.
	 * @param troopFigure The {@link Figure} whose glow effect should be set. There are two checks happening:
	 *                    If the {@link Figure} is an ally, the glow effect will be colored blue, if the {@link Figure} is
	 *                    an enemy, the glow effect will be colored red.
	 * @pre.condition It is possible to differentiate between ally and enemy.
	 * @post.condition The troops glow depending on if there are an ally or enemy.
	 */
	public static void setGlow (final @NotNull Arena arena, final @NotNull ImageView imageView, final @NotNull Figure troopFigure)
	{
		// Define the DropShadow (the glow) depending on the Figure's team: Blue glow means ally, red glow means enemy.
		final DropShadow playerIdentity;
		if (isAlly(arena, troopFigure))
		{
			playerIdentity = new DropShadow(DROP_SHADOW_RADIUS, Color.BLUE);
		}
		else if (isEnemy(arena, troopFigure))
		{
			playerIdentity = new DropShadow(DROP_SHADOW_RADIUS, Color.RED);
		}

		// This case should never happen, as the supplied Figure should always be either an ally or an enemy.
		// This case is just here to satisfy the compiler that there's no NullPointerException.
		else
		{
			return;
		}

		playerIdentity.setSpread(DROP_SHADOW_SPREAD);
		imageView.setEffect(playerIdentity);
	}


	/**
	 * Checks if the {@link Figure} is an enemy.
	 *
	 * @param arena       The arena where the {@link Figure} stands in.
	 * @param troopFigure The {@link Figure} which is checked if it's an enemy or not.
	 *
	 * @return True if the {@link Figure} is an enemy, otherwise false.
	 * @pre.condition Player Two exists.
	 * @post.condition PlayerTwo is labeled as an enemy.
	 */
	private static boolean isEnemy (@NotNull final Arena arena, @NotNull final Figure troopFigure)
	{
		return arena.getPlayerTwoFigures().contains(troopFigure);
	}


	/**
	 * Checks if the {@link Figure} is an ally.
	 *
	 * @param arena       The arena where the {@link Figure} stands in.
	 * @param troopFigure The {@link Figure} which is checked if it's an ally or not.
	 *
	 * @return True if the {@link Figure} is an ally, otherwise false.
	 *  * @pre.condition Player Two exists.
	 * 	 * @post.condition PlayerTwo is labeled as an ally.
	 */
	private static boolean isAlly (@NotNull final Arena arena, @NotNull final Figure troopFigure)
	{
		return arena.getPlayerOneFigures().contains(troopFigure);
	}

}
