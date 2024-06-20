package me.vault.game.model.mission;


import me.vault.game.model.currency.CurrencyTransaction;
import me.vault.game.model.player.Player;


public class Mission
{

	private Player player;

	private boolean completed;

	private final String name;

	private final String description;

	private final MissionMap missionMap;

	private final CurrencyTransaction missionReward;


	public Mission (final String name, final String description, final MissionMap missionMap, final CurrencyTransaction missionReward)
	{
		this.name = name;
		this.completed = false;
		this.missionMap = missionMap;
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


	public MissionMap getMissionMap ()
	{
		return this.missionMap;
	}


	public CurrencyTransaction getMissionReward ()
	{
		return this.missionReward;
	}

}
