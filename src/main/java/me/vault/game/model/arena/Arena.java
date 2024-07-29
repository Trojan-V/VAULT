package me.vault.game.model.arena;


import me.vault.game.model.gameboard.GameBoard;
import me.vault.game.model.gameboard.tiles.AccessibleTileAppearance;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import static me.vault.game.utility.constant.ArenaConstants.MULTIPLIER;
import static me.vault.game.utility.constant.ArenaConstants.OFFSET;


/**
 * This class is the model for the arena where the encounters take place.
 *
 * @author Vincent Wolf
 * @version 1.0.0
 * @see
 * @since 29.07.2024
 */
public class Arena
{
	/**
	 * A list of all figures that belong to player two.
	 * <br>
	 * In Singleplayer, this is the computer player one fights against.
	 */
	private final List<Figure> playerTwoTroops;


	private final List<Figure> eliminatedTroops = new ArrayList<>();


	/**
	 * The result of the encounter.
	 * Determines if the encounter was won or lost.
	 * <br>
	 * As long as the arena fight isn't finished, the {@link ArenaResult} is undefined.
	 */
	private ArenaResult arenaResult = ArenaResult.UNDEFINED;

	private TroopTimeline troopTimeline = null;


	private final GameBoard gameBoard;


	/**
	 * A list of all figures that belong to player one.
	 * <br>
	 * In Singleplayer, this is the player who plays the game.
	 */
	private List<Figure> playerOneTroops;


	private Figure selectedFigure = null;


	public Arena (final List<Figure> playerOneTroops,
		final List<Figure> playerTwoTroops, final GameBoard gameBoard)
	{
		this.playerOneTroops = playerOneTroops;
		this.playerTwoTroops = playerTwoTroops;
		this.gameBoard = gameBoard;
	}


	private TroopTimeline initializeTimeline (final Collection<Figure> playerOneTroops,
		final Collection<Figure> playerTwoTroops)
	{
		final ArrayList<Figure> troops = new ArrayList<>();
		troops.addAll(playerOneTroops);
		troops.addAll(playerTwoTroops);

		return new TroopTimeline(troops);
	}


	public GameBoard getGameBoard ()
	{
		return this.gameBoard;
	}


	public TroopTimeline getTimeline ()
	{
		return this.troopTimeline;
	}


	private void placePlayerOneTroopAtRandomPosition (final Figure troop)
	{
		final Position randomPosition =
			new Position((int) Math.round(Math.random()), (int) Math.round(Math.random() * MULTIPLIER));

		if (this.getGameBoard().getTile(randomPosition).getCurrentElement().getClass() ==
		    AccessibleTileAppearance.class)
		{
			this.getGameBoard().placeIfAccessibleTile(randomPosition, troop);
			return;
		}
		this.placePlayerOneTroopAtRandomPosition(troop);
	}


	private void placePlayerTwoTroopAtRandomPosition (final Figure troop)
	{
		final Position randomPosition =
			new Position((int) Math.round(Math.random() + OFFSET), (int) Math.round(Math.random() * MULTIPLIER));

		if (this.getGameBoard().getTile(randomPosition).getCurrentElement().getClass() ==
		    AccessibleTileAppearance.class)
		{
			this.getGameBoard().placeIfAccessibleTile(randomPosition, troop);
			return;
		}
		this.placePlayerTwoTroopAtRandomPosition(troop);
	}


	private void setPlayerOneTroopPositions ()
	{
		for (final Figure troopFigure : this.playerOneTroops)
		{
			this.placePlayerOneTroopAtRandomPosition(troopFigure);
		}
	}


	private void setPlayerTwoTroopPositions ()
	{
		for (final Figure troopFigure : this.playerTwoTroops)
		{
			this.placePlayerTwoTroopAtRandomPosition(troopFigure);
		}
	}


	public Figure getSelectedFigure ()
	{
		return this.selectedFigure;
	}


	public void setSelectedFigure (final Figure selectedTroop)
	{
		this.selectedFigure = selectedTroop;
	}


	public List<Figure> getPlayerOneTroops ()
	{
		return this.playerOneTroops;
	}


	public void setPlayerOneTroops (final List<Figure> playerOneTroops)
	{
		this.playerOneTroops = playerOneTroops;
		this.setPlayerOneTroopPositions();
		this.setPlayerTwoTroopPositions();
		this.troopTimeline = this.initializeTimeline(playerOneTroops, this.playerTwoTroops);
	}


	public List<Figure> getPlayerTwoTroops ()
	{
		return this.playerTwoTroops;
	}


	public void removeTroopFigure (final Figure troopFigure)
	{
		this.gameBoard.remove(troopFigure);
		this.troopTimeline.removeTimelineElement(troopFigure);
		this.eliminatedTroops.add(troopFigure);
		this.checkForChangedState();
	}


	private void checkForChangedState ()
	{
		if (new HashSet<>(this.eliminatedTroops).containsAll(this.playerOneTroops))
		{
			this.arenaResult = ArenaResult.LOST;
		}
		else if (new HashSet<>(this.eliminatedTroops).containsAll(this.playerTwoTroops))
		{
			this.arenaResult = ArenaResult.WON;
		}
		else
		{
			this.arenaResult = ArenaResult.UNDEFINED;
		}
	}


	public List<Figure> getEliminatedFigures ()
	{
		return this.eliminatedTroops;
	}


	public ArenaResult getState ()
	{
		return this.arenaResult;
	}

}
