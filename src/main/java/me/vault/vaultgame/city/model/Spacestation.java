package me.vault.vaultgame.city.model;

import java.util.ArrayList;

/**
 *
 */
public class Spacestation
{
	private static Spacestation instance = null;
	private static ArrayList<Building> buildings = null;


	private Spacestation ()
	{
		buildings = new ArrayList<Building>();
	}


	public static Spacestation getInstance ()
	{
		if (instance == null)
		{
			instance = new Spacestation();
		}
		return instance;
	}

}
