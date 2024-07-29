package me.vault.game.model.arena;


import me.vault.game.model.troop.Troop;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import static me.vault.game.utility.constant.ArenaConstants.MULTIPLIER;
import static me.vault.game.utility.constant.ArenaConstants.OFFSET;


public class Arena
{
	private State state = State.RUNNING;


	public enum State
	{
		RUNNING,
		LOST,
		WON
	}


	private List<Figure<? extends Troop>> playerOneTroops;


	private final List<Figure<? extends Troop>> playerTwoTroops;


	private TroopTimeline troopTimeline = null;


	private final GameBoard gameBoard;


	private Figure<? extends Troop> selectedFigure = null;

	private final List<Figure<? extends Troop>> eliminatedTroops = new ArrayList<>();


	public Arena (final List<Figure<? extends Troop>> playerOneTroops, final List<Figure<? extends Troop>> playerTwoTroops, final GameBoard gameBoard)
	{
		this.playerOneTroops = playerOneTroops;
		this.playerTwoTroops = playerTwoTroops;
		this.gameBoard = gameBoard;
	}


	private TroopTimeline initializeTimeline (final Collection<Figure<? extends Troop>> playerOneTroops, final Collection<Figure<? extends Troop>> playerTwoTroops)
	{
		final ArrayList<Figure<? extends Troop>> troops = new ArrayList<>();
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


	private void placePlayerOneTroopAtRandomPosition (final Figure<? extends Troop> troop)
	{
		final Position randomPosition = new Position((int) Math.round(Math.random()), (int) Math.round(Math.random() * MULTIPLIER));

		if (this.getGameBoard().getTile(randomPosition).getCurrentElement().getClass() ==
		    AccessibleTileAppearance.class)
		{
			this.getGameBoard().placeIfAccessibleTile(randomPosition, troop);
			return;
		}
		this.placePlayerOneTroopAtRandomPosition(troop);
	}


	private void placePlayerTwoTroopAtRandomPosition (final Figure<? extends Troop> troop)
	{
		final Position randomPosition = new Position((int) Math.round(Math.random() + OFFSET), (int) Math.round(Math.random() * MULTIPLIER));

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
		for (final Figure<? extends Troop> troopFigure : this.playerOneTroops)
		{
			this.placePlayerOneTroopAtRandomPosition(troopFigure);
		}
	}


	private void setPlayerTwoTroopPositions ()
	{
		for (final Figure<? extends Troop> troopFigure : this.playerTwoTroops)
		{
			this.placePlayerTwoTroopAtRandomPosition(troopFigure);
		}
	}


	public void setPlayerOneTroops (final List<Figure<? extends Troop>> playerOneTroops)
	{
		this.playerOneTroops = playerOneTroops;
		this.setPlayerOneTroopPositions();
		this.setPlayerTwoTroopPositions();
		this.troopTimeline = this.initializeTimeline(playerOneTroops, this.playerTwoTroops);
	}


	public Figure<? extends Troop> getSelectedFigure ()
	{
		return this.selectedFigure;
	}


	public void setSelectedFigure (final Figure<? extends Troop> selectedTroop)
	{
		this.selectedFigure = selectedTroop;
	}


	public List<Figure<? extends Troop>> getPlayerOneTroops ()
	{
		return this.playerOneTroops;
	}


	public List<Figure<? extends Troop>> getPlayerTwoTroops ()
	{
		return this.playerTwoTroops;
	}


	public void removeTroopFigure (final Figure<? extends Troop> troopFigure)
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
			this.state = State.LOST;
		}
		else if (new HashSet<>(this.eliminatedTroops).containsAll(this.playerTwoTroops))
		{
			this.state = State.WON;
		}
		else
		{
			this.state = State.RUNNING;
		}
	}


	public List<Figure<? extends Troop>> getEliminatedFigures ()
	{
		return this.eliminatedTroops;
	}


	public State getState ()
	{
		return this.state;
	}
}
