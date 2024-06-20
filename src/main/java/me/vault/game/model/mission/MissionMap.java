package me.vault.game.model.mission;


import me.vault.game.model.Graph;
import me.vault.game.model.encounter.Encounter;
import me.vault.game.model.GameMap;

import java.util.ArrayList;


public class MissionMap extends GameMap
{
	private ArrayList<Encounter> encounters;

	private ArrayList<Obstacle> obstacles;

	private ArrayList<Collectible> collectibles;


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
