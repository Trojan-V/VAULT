package me.vault.game.model.arena;


import me.vault.game.model.troop.Troop;

import java.util.ArrayList;


public class Arena
{

	private final ArrayList<Troop> playerOneTroops;


	private final ArrayList<Troop> playerTwoTroops;


	private final Timeline timeline;


	private final GameBoard gameBoard;


	private Troop selectedTroop;


	public Arena (final ArrayList<Troop> playerOneTroops, final ArrayList<Troop> playerTwoTroops, final GameBoard gameBoard)
	{
		this.playerOneTroops = playerOneTroops;
		this.playerTwoTroops = playerTwoTroops;
		this.gameBoard = gameBoard;
		this.timeline = this.initializeTimeline(playerOneTroops, playerTwoTroops);

		this.setPlayerOneTroopPositions();
		this.setPlayerTwoTroopPositions();

	}


	private Timeline initializeTimeline (final ArrayList<Troop> playerOneTroops, final ArrayList<Troop> playerTwoTroops)
	{
		final ArrayList<Troop> troops = new ArrayList<>();

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


	private void placePlayerOneTroopAtRandomPosition (final Troop troop)
	{
		final int randomYCoordinate = (int) Math.round(Math.random() * 11);
		final int randomXCoordinate = (int) Math.round(Math.random());

		if (this.getGameBoard().getTile(randomXCoordinate, randomYCoordinate).getCurrentElement().getClass() ==
		    Placeholder.class)
		{
			this.getGameBoard().setTroop(randomXCoordinate, randomYCoordinate, troop);
			return;
		}
		this.placePlayerOneTroopAtRandomPosition(troop);
	}


	private void placePlayerTwoTroopAtRandomPosition (final Troop troop)
	{
		final int randomYCoordinate = (int) Math.round(Math.random() * 11);
		final int randomXCoordinate = (int) Math.round(Math.random() + 10);

		if (this.getGameBoard().getTile(randomXCoordinate, randomYCoordinate).getCurrentElement().getClass() ==
		    Placeholder.class)
		{
			this.getGameBoard().setTroop(randomXCoordinate, randomYCoordinate, troop);
			return;
		}
		this.placePlayerTwoTroopAtRandomPosition(troop);
	}


	private void setPlayerOneTroopPositions ()
	{
		for (final Troop troop : this.playerOneTroops)
		{
			this.placePlayerOneTroopAtRandomPosition(troop);
		}
	}


	private void setPlayerTwoTroopPositions ()
	{
		for (final Troop troop : this.playerTwoTroops)
		{
			this.placePlayerTwoTroopAtRandomPosition(troop);
		}
	}


	public Troop getSelectedTroop ()
	{
		return this.selectedTroop;
	}


	public void setSelectedTroop (final Troop selectedTroop)
	{
		this.selectedTroop = selectedTroop;
	}


	public ArrayList<Troop> getPlayerOneTroops ()
	{
		return this.playerOneTroops;
	}


	public ArrayList<Troop> getPlayerTwoTroops ()
	{
		return this.playerTwoTroops;
	}

}
