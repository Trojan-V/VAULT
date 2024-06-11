package me.vault.game.model.mission;

import javafx.beans.property.SimpleStringProperty;

public class Mission
{
	private final SimpleStringProperty nameProperty;

	private final MissionMap map;


	public Mission (String name, MissionMap map)
	{
		this.nameProperty = new SimpleStringProperty(name);
		this.map = map;
	}


	public MissionMap getMap ()
	{
		return map;
	}


	public String getNameProperty ()
	{
		return nameProperty.get();
	}


	public SimpleStringProperty namePropertyProperty ()
	{
		return nameProperty;
	}

}
