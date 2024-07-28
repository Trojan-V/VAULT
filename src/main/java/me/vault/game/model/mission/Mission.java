package me.vault.game.model.mission;


import me.vault.game.model.arena.GameBoard;
import me.vault.game.model.currency.CurrencyTransaction;


public class Mission
{

	private final String name;

	private final String description;


	private final GameBoard gameBoard;

	private final CurrencyTransaction missionReward;

	private boolean completed;


	public Mission (final String name, final String description, final GameBoard gameBoard,
		final CurrencyTransaction missionReward)
	{
		this.name = name;
		this.completed = false;
		this.gameBoard = gameBoard;
		this.description = description;
		this.missionReward = missionReward;
	}


	public boolean isCompleted ()
	{
		return this.completed;
	}


	public void setCompleted (final boolean completed)
	{
		this.completed = completed;
	}


	public String getName ()
	{
		return this.name;
	}


	public String getDescription ()
	{
		return this.description;
	}


	public GameBoard getGameBoard ()
	{
		return this.gameBoard;
	}


	public CurrencyTransaction getMissionReward ()
	{
		return this.missionReward;
	}

}
