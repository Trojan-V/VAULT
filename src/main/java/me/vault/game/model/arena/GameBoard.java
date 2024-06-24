package me.vault.game.model.arena;


import me.vault.game.interfaces.Placable;
import me.vault.game.model.troop.Troop;


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
		throw new NullPointerException(); //TODO: Add Exception Message
	}


	public Tile getTile (final int row, final int column)
	{
		return this.gameBoard[row][column];
	}

	public Troop getTroop (final int row, final int column) throws Exception
	{
		if (!(this.gameBoard[row][column].getCurrentElement() instanceof Troop))
		{
			throw new Exception("Not a troop exception..."); //TODO: Implementieren der neuen exception
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
}
