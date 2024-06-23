package me.vault.game.model.encounter;


import me.vault.game.model.mission.AccessibleTile;
import me.vault.game.model.mission.MapObject;
import me.vault.game.model.troop.Troop;
import me.vault.game.utility.loading.ResourceLoader;

import java.util.List;


public class EncounterMap
{

	List<Troop> allies;

	List<Troop> enemies;

	private final MapObject[][] mapArray;

	private final String mapFilePath;


	public EncounterMap (final String mapFilePath, final List<Troop> allies, final List<Troop> enemies)
	{
		this.mapFilePath = mapFilePath;
		this.allies = allies;
		this.enemies = enemies;
		this.mapArray = ResourceLoader.readMapFile(mapFilePath);

		this.setAlliedPositions();
		this.setEnemiesPositions();
	}


	private void setEnemiesPositions ()
	{
		for (final Troop troop : this.enemies)
		{
			this.placeEnemiesTroopAtRandomPosition(troop);
		}
	}


	private void placeEnemiesTroopAtRandomPosition (final Troop troop)
	{
		final int randomYCoordinate = (int) Math.round(Math.random() * 11);
		final int randomXCoordinate = (int) Math.round(Math.random() + 10);

		if (this.mapArray[randomYCoordinate][randomXCoordinate].getClass() == AccessibleTile.class)
		{
			this.mapArray[randomYCoordinate][randomXCoordinate] = troop;
			return;
		}
		this.placeEnemiesTroopAtRandomPosition(troop);
	}


	private void setAlliedPositions ()
	{
		for (final Troop troop : this.allies)
		{
			this.placeAlliedTroopAtRandomPosition(troop);
		}
	}


	private void placeAlliedTroopAtRandomPosition (final Troop troop)
	{
		final int randomYCoordinate = (int) Math.round(Math.random() * 11);
		final int randomXCoordinate = (int) Math.round(Math.random());

		if (this.mapArray[randomYCoordinate][randomXCoordinate].getClass() == AccessibleTile.class)
		{
			this.mapArray[randomYCoordinate][randomXCoordinate] = troop;
			return;
		}
		this.placeAlliedTroopAtRandomPosition(troop);
	}


	public MapObject[][] getMapArray ()
	{
		return this.mapArray;
	}


	public String getMapFilePath ()
	{
		return this.mapFilePath;
	}

}
