package me.vault.game.model.mission;


import me.vault.game.model.GameMap;
import me.vault.game.model.Graph;
import me.vault.game.model.encounter.Encounter;

import java.util.ArrayList;


public class MissionMap extends GameMap
{

	private final ArrayList<Encounter> encounters;

	private final ArrayList<Obstacle> obstacles;

	private final ArrayList<Collectible> collectibles;


	public MissionMap (final ArrayList<Encounter> encounters, final ArrayList<Obstacle> obstacles, final ArrayList<Collectible> collectibles)
	{
		this.encounters = encounters;
		this.obstacles = obstacles;
		this.collectibles = collectibles;
	}


	public MissionMap (final Graph tileMap, final ArrayList<Encounter> encounters, final ArrayList<Obstacle> obstacles, final ArrayList<Collectible> collectibles)
	{
		super(tileMap);
		this.encounters = encounters;
		this.obstacles = obstacles;
		this.collectibles = collectibles;
	}

}
