package me.vault.game.model.mission;


import javafx.beans.property.SimpleStringProperty;


public class Mission
{

	private final SimpleStringProperty nameProperty;

	private final MissionMap map;


	public Mission (final String name, final MissionMap map)
	{
		this.nameProperty = new SimpleStringProperty(name);
		this.map = map;
	}


	public MissionMap getMap ()
	{
		return this.map;
	}


	public String getNameProperty ()
	{
		return this.nameProperty.get();
	}


	public SimpleStringProperty namePropertyProperty ()
	{
		return this.nameProperty;
	}

}
