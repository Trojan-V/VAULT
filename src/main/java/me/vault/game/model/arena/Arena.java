package me.vault.game.model.arena;


import me.vault.game.model.troop.Troop;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class Arena
{

	private static final int MULTIPLIER = 11;


	private static final int OFFSET = 10;


	private final List<Figure<? extends Troop>> playerOneTroops;


	private final List<Figure<? extends Troop>> playerTwoTroops;


	private final TroopTimeline troopTimeline;


	private final GameBoard gameBoard;


	private Figure<? extends Troop> selectedFigure;


	public Arena (final List<Figure<? extends Troop>> playerOneTroops, final List<Figure<? extends Troop>> playerTwoTroops, final GameBoard gameBoard)
	{
		this.playerOneTroops = playerOneTroops;
		this.playerTwoTroops = playerTwoTroops;
		this.gameBoard = gameBoard;
		this.troopTimeline = this.initializeTimeline(playerOneTroops, playerTwoTroops);

		this.setPlayerOneTroopPositions();
		this.setPlayerTwoTroopPositions();

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

		if (this.getGameBoard().getTile(randomPosition).getCurrentElement().getClass() == Placeholder.class)
		{
			this.getGameBoard().placeFigure(randomPosition, troop);
			return;
		}
		this.placePlayerOneTroopAtRandomPosition(troop);
	}


	private void placePlayerTwoTroopAtRandomPosition (final Figure<? extends Troop> troop)
	{
		final Position randomPosition = new Position((int) Math.round(Math.random() + +OFFSET), (int) Math.round(Math.random() * MULTIPLIER));

		if (this.getGameBoard().getTile(randomPosition).getCurrentElement().getClass() == Placeholder.class)
		{
			this.getGameBoard().placeFigure(randomPosition, troop);
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

}
