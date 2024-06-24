package me.vault.game.model.arena;


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
}
