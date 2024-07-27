package me.vault.game.model.arena;


import me.vault.game.model.troop.Troop;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class Arena
{

	private static final int MULTIPLIER = 11;


	private static final int OFFSET = 10;


	private final List<Figure<Troop>> playerOneTroops;


	private final List<Figure<Troop>> playerTwoTroops;


	private final Timeline timeline;


	private final GameBoard gameBoard;


	private Figure<Troop> selectedFigure;


	public Arena (final List<Figure<Troop>> playerOneTroops, final List<Figure<Troop>> playerTwoTroops, final GameBoard gameBoard)
	{
		this.playerOneTroops = playerOneTroops;
		this.playerTwoTroops = playerTwoTroops;
		this.gameBoard = gameBoard;
		this.timeline = this.initializeTimeline(playerOneTroops, playerTwoTroops);

		this.setPlayerOneTroopPositions();
		this.setPlayerTwoTroopPositions();

	}


	private Timeline initializeTimeline (final Collection<Figure<Troop>> playerOneTroops, final Collection<Figure<Troop>> playerTwoTroops)
	{
		final ArrayList<Figure<Troop>> troops = new ArrayList<>();
		troops.addAll(playerOneTroops);
		troops.addAll(playerTwoTroops);

		return new Timeline(troops);
	}


	public GameBoard getGameBoard ()
	{
		return this.gameBoard;
	}


	public Timeline getTimeline ()
	{
		return this.timeline;
	}


	private void placePlayerOneTroopAtRandomPosition (final Figure<Troop> troop)
	{
		final Position randomPosition = new Position((int) Math.round(Math.random()), (int) Math.round(Math.random() * MULTIPLIER));

		if (this.getGameBoard().getTile(randomPosition).getCurrentElement().getClass() == Placeholder.class)
		{
			this.getGameBoard().placeFigure(randomPosition, troop);
			return;
		}
		this.placePlayerOneTroopAtRandomPosition(troop);
	}


	private void placePlayerTwoTroopAtRandomPosition (final Figure<Troop> troop)
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
		for (final Figure<Troop> troopFigure : this.playerOneTroops)
		{
			this.placePlayerOneTroopAtRandomPosition(troopFigure);
		}
	}


	private void setPlayerTwoTroopPositions ()
	{
		for (final Figure<Troop> troopFigure : this.playerTwoTroops)
		{
			this.placePlayerTwoTroopAtRandomPosition(troopFigure);
		}
	}


	public Figure<Troop> getSelectedFigure ()
	{
		return this.selectedFigure;
	}


	public void setSelectedFigure (final Figure<Troop> selectedTroop)
	{
		this.selectedFigure = selectedTroop;
	}


	public List<Figure<Troop>> getPlayerOneTroops ()
	{
		return this.playerOneTroops;
	}


	public List<Figure<Troop>> getPlayerTwoTroops ()
	{
		return this.playerTwoTroops;
	}

}
