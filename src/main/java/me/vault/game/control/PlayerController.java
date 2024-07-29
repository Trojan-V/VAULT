package me.vault.game.control;


import me.vault.game.model.arena.Position;
import me.vault.game.model.arena.Tile;
import me.vault.game.model.gameboard.GameBoard;
import me.vault.game.model.mission.Mission;
import me.vault.game.model.player.Player;
import me.vault.game.model.troop.Faction;

import java.util.List;


/**
 * Controller class to handle the movement of the player on the mission {@link GameBoard}.
 * <br>
 * Generally contains methods related to the player though; also things within the city, for instance, changing the
 * selected faction.
 *
 * @author Vincent Wolf
 * @version 1.0.0
 * @see GameBoard
 * @see Faction
 * @since 29.07.2024
 */
public final class PlayerController
{
	/**
	 * As this class solely contains static methods and therefore is a utility class,
	 * no other class should be able to instantiate it.
	 * <br>
	 * To prohibit the instantiation from anywhere else but within the class, a private constructor is used.
	 */
	private PlayerController ()
	{
	}


	/**
	 * Changes the {@link Faction} the {@link Player} selected to the supplied {@link Faction}.
	 *
	 * @param player The instance of the player whose {@link Faction} should be changed.
	 * @param newFaction The new {@link Faction} the player changes to.
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
	 * @param player The {@link Player} for whom is checked if he can move to the {@link Position}.
	 * @param position The {@link Position} the player wants to move to.
	 * @return True if the {@link Player} can move to the supplied {@link Position}, otherwise false.
	 */
	public static boolean canMoveToPosition (final GameBoard missionGameBoard, final Player player,
		final Position position)
	{
		final Position previousTroopPosition = missionGameBoard.getPosition(player);
		final List<Tile> accessibleTiles = missionGameBoard.getAdjacentAccessibleTiles(previousTroopPosition);
		return accessibleTiles.contains(missionGameBoard.getTile(position));
	}


	/**
	 * Checks if the {@link Player} can reach to the supplied {@link Position} on the {@link GameBoard} of the
	 * {@link Mission}.
	 *
	 * @param missionGameBoard The {@link GameBoard} where the mission takes place.
	 * @param player The {@link Player} for whom is checked if he can reach to the {@link Position}.
	 * @param position The {@link Position} the player wants to reach.
	 * @return True if the {@link Player} can reach the supplied {@link Position}, otherwise false.
	 */
	public static boolean canReachPosition (final GameBoard missionGameBoard, final Player player,
		final Position position)
	{
		final Position previousTroopPosition = missionGameBoard.getPosition(player);
		final List<Tile> accessibleTiles = missionGameBoard.getAdjacentTiles(previousTroopPosition);
		return accessibleTiles.contains(missionGameBoard.getTile(position));
	}

}
