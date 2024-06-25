package me.vault.game.model.arena;


import me.vault.game.interfaces.Placable;
import me.vault.game.model.troop.Troop;

import java.util.ArrayList;
import java.util.List;


public class GameBoard implements GameBoardConstants
{

	private final Tile[][] gameBoard;


	public GameBoard (final Tile[][] gameBoard)
	{
		this.gameBoard = gameBoard;
	}


	public Tile[][] getGameBoard ()
	{
		return this.gameBoard;
	}


	public int[] getTroopPosition (final Troop troop)
	{
		for (int i = 0; i < this.gameBoard.length; i++)
		{
			for (int j = 0; j < this.gameBoard[0].length; j++)
			{
				if (this.gameBoard[i][j].getCurrentElement() == troop)
				{
					return new int[]{i, j};
				}
			}
		}
		throw new NullPointerException(); // TODO: Add Exception Message
	}


	public Tile getTile (final int row, final int column)
	{
		return this.gameBoard[row][column];
	}


	public Troop getTroop (final int row, final int column) throws Exception
	{
		if (!(this.gameBoard[row][column].getCurrentElement() instanceof Troop))
		{
			throw new Exception("Not a troop exception..."); // TODO: Implementieren der neuen exception
		}
		return (Troop) this.gameBoard[row][column].getCurrentElement();
	}


	public void setTroop (final int row, final int column, final Troop troop)
	{
		if (this.gameBoard[row][column].getCurrentElement().getClass() == Placeholder.class)
		{
			this.gameBoard[row][column].setCurrentElement(troop);
		}
	}


	public void setPlaceable (final int row, final int column, final Placable placeable)
	{
		this.gameBoard[row][column].setCurrentElement(placeable);
	}


	public List<Tile> getAdjacentTroopTiles (final int[] position)
	{
		final List<Tile> adjacentTiles = this.getAdjacentTiles(position[0], position[1]);
		adjacentTiles.removeIf(tile -> !(tile.getCurrentElement() instanceof Troop));
		return adjacentTiles;
	}


	private List<Tile> getAdjacentTiles (final int row, final int column)
	{
		final List<Tile> adjacentTiles = new ArrayList<>();
		for (int i = (row - 1); i <= row + 1; i++)
		{
			for (int j = column - 1; j <= column + 1; j++)
			{
				try
				{
					adjacentTiles.add(this.gameBoard[i][j]);
				}
				catch (IndexOutOfBoundsException e)
				{
					System.out.println("Out of bound" + i + " " + j);
				}
			}
		}
		adjacentTiles.remove(this.gameBoard[row][column]);
		return adjacentTiles;
	}


	public List<Tile> getAdjacentAccessibleTiles (final int[] position)
	{
		final List<Tile> adjacentTiles = this.getAdjacentTiles(position[0], position[1]);
		adjacentTiles.removeIf(tile -> !(tile.getCurrentElement() instanceof Placeholder));
		return adjacentTiles;
	}

}
