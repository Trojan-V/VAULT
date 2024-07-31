package me.vault.game.control;


import me.vault.game.model.Mission;
import me.vault.game.model.Player;
import me.vault.game.model.gameboard.GameBoard;
import me.vault.game.model.gameboard.tile.Tile;
import me.vault.game.model.troop.Faction;
import me.vault.game.utility.exception.ElementNotFoundOnGameBoardException;
import me.vault.game.utility.logging.ILogger;
import me.vault.game.utility.logging.Logger;
import me.vault.game.utility.math.Position;

import java.util.List;

import static me.vault.game.utility.logging.ILogger.Level.WARNING;


/**
 * Controller class to handle the movement of the player on the mission {@link GameBoard}.
 * <br>
 * Generally contains methods related to the player though; also things within the city, for instance, changing the
 * selected faction.
 *
 * @author Vincent Wolf, Lasse-Leander Hillen, Timothy Hoegen-Jupp, Alexander Goethel
 * @version 1.0.0
 * @see GameBoard
 * @see Faction
 * @since 29.07.2024
 */
public final class PlayerController
{

	/**
	 * The {@link Logger} object for this class used for writing to the console.
	 */
	private static final ILogger LOGGER = new Logger(PlayerController.class.getSimpleName());


	/**
	 * As this class solely contains static methods and therefore is a utility class,
	 * no other class should be able to instantiate it.
	 * <br>
	 * To prohibit the instantiation from anywhere else but within the class, a private constructor is used.
	 *
	 * @precondition Constructor gets called from within the class
	 * @postcondition A new instance of PlayerController is created.
	 */
	private PlayerController () {}


	/**
	 * Changes the {@link Faction} the {@link Player} selected to the supplied {@link Faction}.
	 *
	 * @param player     The instance of the player whose {@link Faction} should be changed.
	 * @param newFaction The new {@link Faction} the player changes to.
	 *
	 * @precondition The Player has been initialized and is able to set a selected faction.
	 * @postcondition The currently selected faction in the player was changed.
	 */
	public static void changeSelectedFaction (final Player player, final Faction newFaction)
	{
		for (final Faction faction : Faction.values())
		{
			if (faction == newFaction)
			{
				faction.setIsSelected(true);
				continue;
			}
			faction.setIsSelected(false);
		}
		player.setSelectedFaction(newFaction);
	}


	/**
	 * Checks if the {@link Player} can move to the supplied {@link Position} on the {@link GameBoard} of the
	 * {@link Mission}.
	 *
	 * @param missionGameBoard The {@link GameBoard} where the mission takes place.
	 * @param player           The {@link Player} for whom is checked if he can move to the {@link Position}.
	 * @param position         The {@link Position} the player wants to move to.
	 *
	 * @return True if the {@link Player} can move to the supplied {@link Position}, otherwise false.
	 *
	 * @precondition A game board, the player and a position are passed into the method.
	 * @postcondition The method returned the appropriate boolean.
	 */
	public static boolean canMoveToPosition (final GameBoard missionGameBoard, final Player player, final Position position)
	{
		try
		{
			final Position previousTroopPosition = missionGameBoard.getPosition(player);
			final List<Tile> accessibleTiles = missionGameBoard.getAdjacentAccessibleTiles(previousTroopPosition);
			return accessibleTiles.contains(missionGameBoard.getTile(position));
		}
		catch (final ElementNotFoundOnGameBoardException e)
		{
			LOGGER.log(WARNING, e.getMessage());
		}
		return false;
	}


	/**
	 * Checks if the {@link Player} can reach to the supplied {@link Position} on the {@link GameBoard} of the
	 * {@link Mission}.
	 *
	 * @param missionGameBoard The {@link GameBoard} where the mission takes place.
	 * @param player           The {@link Player} for whom is checked if he can reach to the {@link Position}.
	 * @param position         The {@link Position} the player wants to reach.
	 *
	 * @return True if the {@link Player} can reach the supplied {@link Position}, otherwise false.
	 *
	 * @precondition A game board, the player and a position are passed into the method.
	 * @postcondition The method returned the appropriate boolean about the reachability of the position.
	 */
	public static boolean canReachPosition (final GameBoard missionGameBoard, final Player player, final Position position)
	{
		try
		{
			final Position previousTroopPosition = missionGameBoard.getPosition(player);
			final List<Tile> accessibleTiles = missionGameBoard.getAdjacentTiles(previousTroopPosition);
			return accessibleTiles.contains(missionGameBoard.getTile(position));
		}
		catch (final ElementNotFoundOnGameBoardException e)
		{
			LOGGER.log(WARNING, e.getMessage());
		}
		return false;
	}

}
