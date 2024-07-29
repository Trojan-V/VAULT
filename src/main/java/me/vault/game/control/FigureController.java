package me.vault.game.control;


import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import me.vault.game.model.arena.*;
import me.vault.game.model.artifact.Artifact;
import me.vault.game.model.energy.Energy;
import me.vault.game.model.gameboard.GameBoard;
import me.vault.game.model.player.Player;
import me.vault.game.model.troop.TroopStatistics.Defensive;
import me.vault.game.model.troop.TroopStatistics.Offensive;
import me.vault.game.utility.logging.ILogger;
import me.vault.game.utility.logging.Logger;
import org.jetbrains.annotations.NotNull;

import java.util.List;


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
	private static final ILogger LOGGER = new Logger(FigureController.class.getName());


	/**
	 * The radius of the drop shadow effect that is rendered around the sprites which display the allied figures.
	 */
	private static final int DROP_SHADOW_RADIUS = 15;


	/**
	 * The spread of the drop shadow effect that is rendered around the sprites which display the allied figures.
	 */
	private static final double DROP_SHADOW_SPREAD = 0.5;


	private static final int HUNDRED = 100;


	private static final int ONE = 1;


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
	 */
	public static void attack (final Arena arena, final Figure attacker, final Figure defender)
	{
		// Get the statistics of the attacker and defender so the damage can be calculated.
		final Defensive defenderDefensiveStats = defender.getStatistics().getDefensive();
		final double dice = DiceRoll.getDice();

		if (dice < defenderDefensiveStats.getDodgeRate())
		{
			final int calculatedDamage = calculateDamage(attacker, defender);
			final int newDefenderHealthPoints = defenderDefensiveStats.getHealth() - calculatedDamage;
			if (newDefenderHealthPoints <= 0)
			{
				// Remove the defender from the arena if his HP dropped to zero or below, as the unit died.
				arena.eliminateFigure(defender);
				return;
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
	 * <br>
	 * The formula takes the melee damage the attacker deals into account as well as the armor the defender has.
	 *
	 * @param attackerStats          The {@link Figure} statistics of the
	 *                               attacking unit.
	 * @param defenderDefensiveStats The {@link Figure} statistics of the
	 *                               defensive unit.
	 * @return The amount of damage the defender will receive.
	 */
	private static int calculateDamage (final Figure attackerStats, final Figure defenderDefensiveStats)

	{
		Artifact currentArtifact = Player.getInstance().getSelectedArtifact();
		Energy currenrEnergy = Player.getInstance().getSelectedEnergy();
		double damageMultiplier = currentArtifact.getAttributeMultipliers().getDamageMultiplierProperty().get();
		double defenseMultiplier = currentArtifact.getAttributeMultipliers().getDefenseMultiplierProperty().get();
		double meleeMultiplier = currenrEnergy.getAbilityMultiplier().getMeleeMultiplierProperty().get();
		int meleeDamage = attackerStats.getStatistics().getOffensive().getMeleeDamage();
		int armor = defenderDefensiveStats.getStatistics().getDefensive().getArmor();
		return (int) (meleeDamage * (ONE - (armor * defenseMultiplier) / HUNDRED) * damageMultiplier * meleeMultiplier);
	}


	/**
	 * Checks if the {@link Figure} can move to the supplied {@link Position}.
	 *
	 * @param arena       The arena where the encounter takes place.
	 * @param troopFigure The {@link Figure} for which will be checked if it can move to the supplied position.
	 * @param position    The position the {@link Figure} wants to move to.
	 * @return True if the {@link Figure} can move to the supplied {@link Position}, otherwise false.
	 */
	public static boolean canMoveToPosition (final Arena arena,
		final Figure troopFigure, final Position position)
	{
		final GameBoard arenaGameBoard = arena.getGameBoard();

		final Position previousTroopPosition = arenaGameBoard.getPosition(troopFigure);
		final int troopMovementRange = troopFigure.getStatistics().getDexterity().getMovementTiles();
		final List<Tile> accessibleTiles = arenaGameBoard.getAdjacentAccessibleTiles(previousTroopPosition, troopMovementRange);
		return accessibleTiles.contains(arenaGameBoard.getTile(position));
	}


	/**
	 * Checks if the {@link Figure} can attack the other {@link Figure} at the supplied {@link Position}.
	 *
	 * @param arena          The arena where the encounter takes place.
	 * @param attackerFigure The {@link Figure} which wants to attack another {@link Figure}.
	 * @param position       The position the {@link Figure} wants to attack at.
	 * @return True if the {@link Figure} can attack the {@link Figure} at the supplied {@link Position}, otherwise
	 * false.
	 */
	public static boolean canAttackAtPosition (final Arena arena, final Figure attackerFigure,
		final Position position)
	{
		try
		{
			GameBoard arenaGameBoard = arena.getGameBoard();
			final Figure defender = arenaGameBoard.getFigure(position);
			final Position attackerPos = arenaGameBoard.getPosition(attackerFigure);
			final List<Tile> reachableTiles = arenaGameBoard
				.getAdjacentTiles(attackerPos, attackerFigure.getStatistics().getOffensive().getGrenadeRange());

			final List<Figure> defenderGroup =
				arena.getPlayerOneFigures().contains(defender) ? arena.getPlayerOneFigures() :
				arena.getPlayerOneFigures();
			return !defenderGroup.contains(attackerFigure) &&
			       reachableTiles.contains(arenaGameBoard.getTile(position));
		}
		catch (final Exception e)
		{
			throw new RuntimeException(e);
		}
	}


	/**
	 * Sets the glow effect of the supplied {@link Figure}.
	 *
	 * @param arena       The arena where the figure is located.
	 * @param imageView   The image view (basically the sprite) which gets manipulated to apply the glow effect.
	 * @param troopFigure The {@link Figure} whose glow effect should be set. There are two checks happening: If the
	 *                    {@link Figure} is an ally, the glow effect will be colored blue, if the {@link Figure} is
	 *                    an enemy, the glow effect will be colored red.
	 */
	public static void setGlow (final @NotNull Arena arena, final @NotNull ImageView imageView,
		final @NotNull Figure troopFigure)
	{
		// Define the DropShadow (the glow) depending on the Figure's team: Blue glow means ally, red glow means enemy.
		DropShadow playerIdentity = null;
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
	 * @return True if the {@link Figure} is an enemy, otherwise false.
	 */
	private static boolean isEnemy (@NotNull Arena arena, @NotNull Figure troopFigure)
	{
		return arena.getPlayerTwoFigures().contains(troopFigure);
	}


	/**
	 * Checks if the {@link Figure} is an ally.
	 *
	 * @param arena       The arena where the {@link Figure} stands in.
	 * @param troopFigure The {@link Figure} which is checked if it's an ally or not.
	 * @return True if the {@link Figure} is an ally, otherwise false.
	 */
	private static boolean isAlly (@NotNull Arena arena, @NotNull Figure troopFigure)
	{
		return arena.getPlayerTwoFigures().contains(troopFigure);
	}
}
