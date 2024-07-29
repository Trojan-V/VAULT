package me.vault.game.control;


import me.vault.game.model.arena.GameBoard;
import me.vault.game.model.arena.Position;
import me.vault.game.model.arena.Tile;
import me.vault.game.model.player.Player;
import me.vault.game.model.troop.Faction;
import me.vault.game.utility.logging.Logger;

import java.util.List;


public class PlayerController
{

	private static final PlayerController INSTANCE = new PlayerController();

	private static final Logger LOGGER = new Logger(PlayerController.class.getSimpleName());


	public static PlayerController getInstance ()
	{
		return INSTANCE;
	}


	public static void changeSelectedFaction (final Player player, final Faction newFaction)
	{
		for (final Faction faction : Faction.values())
		{
			if (faction == newFaction)
			{
				faction.getIsSelectedProperty().set(true);
				continue;
			}
			faction.getIsSelectedProperty().set(false);
		}
		player.setSelectedFaction(newFaction);
	}


	public static boolean canMoveToPosition (final GameBoard missionGameBoard, final Player player,
		final Position position)
	{
		final Position previousTroopPosition = missionGameBoard.getPosition(player);
		final List<Tile> accessibleTiles = missionGameBoard.getAdjacentPlaceholderTiles(previousTroopPosition);
		return accessibleTiles.contains(missionGameBoard.getTile(position));
	}


	public static boolean canReachPosition (final GameBoard missionGameBoard, final Player player,
		final Position position)
	{
		final Position previousTroopPosition = missionGameBoard.getPosition(player);
		final List<Tile> accessibleTiles = missionGameBoard.getAdjacentTiles(previousTroopPosition);
		return accessibleTiles.contains(missionGameBoard.getTile(position));
	}

}
