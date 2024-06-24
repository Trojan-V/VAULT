package me.vault.game.model.encounter;


import me.vault.game.model.mission.AccessibleTile;
import me.vault.game.model.mission.MapObject;
import me.vault.game.model.troop.Troop;
import me.vault.game.utility.loading.ResourceLoader;

import java.util.List;


public class EncounterMap
{

	private static final int ROW_POSTITION = 0;


	private static final int COLUMN_POSITION = 1;


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
		final int randomYCoordinate = (int) Math.round(Math.random() * 11); //TODO: Magic Numbers
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


	public int[] getTroopPosition (final Troop troop)
	{
		for (int i = 0; i < this.mapArray.length; i++)
		{
			for (int j = 0; j < this.mapArray[0].length; j++)
			{
				if (this.mapArray[i][j] == troop)
				{
					return new int[]{i, j};
				}
			}
		}
		throw new NullPointerException(); //TODO: Add Exception Message
	}


	public void setTroopPosition (final Troop troop, final int row, final int column)
	{
		final int currentRow = this.getTroopPosition(troop)[ROW_POSTITION];
		final int currentColumn = this.getTroopPosition(troop)[COLUMN_POSITION];

		if (!(this.mapArray[row][column].getClass() == AccessibleTile.class))
		{
			throw new IllegalArgumentException(); //TODO: create own exception
		}

		if (row > this.mapArray.length | column > this.mapArray.length)
		{
			throw new IllegalArgumentException(); //TODO: create own exception
		}
		this.mapArray[row][column] = troop;
		this.mapArray[currentRow][currentColumn] = new AccessibleTile();
	}
}
