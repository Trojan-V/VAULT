package me.vault.game.model.mission;


import javafx.beans.property.SimpleBooleanProperty;
import me.vault.game.model.arena.Arena;
import me.vault.game.model.arena.GameBoard;
import me.vault.game.model.currency.CurrencyTransaction;
import me.vault.game.utility.constant.EncounterConstants;
import me.vault.game.utility.loading.ResourceLoader;

import java.util.ArrayList;
import java.util.List;


public class Mission
{

	private final String name;

	private final String description;

	private final GameBoard gameBoard;

	private final CurrencyTransaction missionReward;

	private SimpleBooleanProperty completedProperty;


	private final List<Arena> availableArenaEncounters = new ArrayList<>();


	public Mission (final String name, final String description, final GameBoard gameBoard, final CurrencyTransaction missionReward)
	{
		this.name = name;
		this.completedProperty = new SimpleBooleanProperty(false);
		this.gameBoard = gameBoard;
		this.description = description;
		this.missionReward = missionReward;
		this.availableArenaEncounters.add(new Arena(List.of(), EncounterConstants.ENCOUNTER_ONE_ENEMIES,
			new GameBoard(ResourceLoader.createGameBoardFromFile("src/main/resources/me/vault/game/map/Encounter_2.txt"))));
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
		return this.availableArenaEncounters;
	}

}
