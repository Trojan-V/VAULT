package me.vault.game.model.mission;


import javafx.beans.property.SimpleBooleanProperty;
import me.vault.game.model.arena.Arena;
import me.vault.game.model.currency.CurrencyTransaction;
import me.vault.game.model.gameboard.GameBoard;
import me.vault.game.utility.constant.ArenaConstants;

import java.util.ArrayList;
import java.util.List;


public class Mission
{

	private final String name;

	private final String description;

	private final GameBoard gameBoard;

	private final CurrencyTransaction missionReward;

	private final SimpleBooleanProperty completedProperty;

	private static final List<Arena> AVAILABLE_ARENA_ENCOUNTERS = new ArrayList<>();


	static
	{
		AVAILABLE_ARENA_ENCOUNTERS.add(ArenaConstants.ARENA_ONE);
		AVAILABLE_ARENA_ENCOUNTERS.add(ArenaConstants.ARENA_TWO);
		AVAILABLE_ARENA_ENCOUNTERS.add(ArenaConstants.ARENA_THREE);
		AVAILABLE_ARENA_ENCOUNTERS.add(ArenaConstants.ARENA_FOUR);
	}


	public Mission (final String name, final String description, final GameBoard gameBoard, final CurrencyTransaction missionReward)
	{
		this.name = name;
		this.completedProperty = new SimpleBooleanProperty(false);
		this.gameBoard = gameBoard;
		this.description = description;
		this.missionReward = missionReward;
	}


	public boolean isCompleted ()
	{
		return this.completedProperty.get();
	}


	public void setCompleted (final boolean completed)
	{
		this.completedProperty.set(completed);
	}


	public SimpleBooleanProperty getCompletedProperty ()
	{
		return this.completedProperty;
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


	public List<Arena> getAvailableArenaEncounters ()
	{
		return this.AVAILABLE_ARENA_ENCOUNTERS;
	}

}
