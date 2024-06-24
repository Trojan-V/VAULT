package me.vault.game.model.arena;


import me.vault.game.model.troop.Troop;

import java.util.ArrayList;


public class Arena
{

	private final ArrayList<Troop> playerOneTroops;


	private final ArrayList<Troop> playerTwoTroops;


	private final Timeline timeline;


	private final GameBoard gameBoard;


	public Arena (final ArrayList<Troop> playerOneTroops, final ArrayList<Troop> playerTwoTroops, final GameBoard gameBoard)
	{
		this.playerOneTroops = playerOneTroops;
		this.playerTwoTroops = playerTwoTroops;
		this.gameBoard = gameBoard;
		this.timeline = this.initializeTimeline(playerOneTroops, playerTwoTroops);
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

}
