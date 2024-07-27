package me.vault.game.model.arena;


import me.vault.game.interfaces.Placable;
import me.vault.game.model.troop.Troop;

import java.util.ArrayList;
import java.util.List;


// TODO imple.
public class GameBoard
{

	private static final int RANGE = 1;


	private final Tile[][] gameBoard;


	public GameBoard (final Tile[][] gameBoard)
	{
		this.gameBoard = gameBoard;
	}


	public Tile[][] getGameBoard ()
	{
		return this.gameBoard;
	}


	public Position getFigurePosition (final Figure<? extends Troop> troop)
	{
		for (int i = 0; i < this.gameBoard.length; i++)
		{
			for (int j = 0; j < this.gameBoard[0].length; j++)
			{
				if (this.gameBoard[i][j].getCurrentElement() == troop)
				{
					return new Position(i, j);
				}
			}
		}
		throw new NullPointerException(); // TODO: Add Exception Message
	}


	public Tile getTile (final Position position)
	{
		return this.gameBoard[position.x()][position.y()];
	}


	public Figure<Troop> getFigure (final Position position) throws Exception
	{
		if (!(this.gameBoard[position.x()][position.y()].getCurrentElement() instanceof Figure))
		{
			throw new Exception("Not a troop exception..."); // TODO: Implementieren der neuen exception
		}
		return (Figure<Troop>) this.gameBoard[position.x()][position.y()].getCurrentElement();
	}


	public void placeFigure (final Position position, final Figure<? extends Troop> troopFigure)
	{
		if (this.gameBoard[position.x()][position.y()].getCurrentElement().getClass() == Placeholder.class)
		{
			this.setPlaceable(position, troopFigure);
		}
	}


	public void setPlaceable (final Position position, final Placable placeable)
	{
		this.gameBoard[position.x()][position.y()].setCurrentElement(placeable);
	}


	public List<Tile> getReachableTroopFigureTiles (final Position position, final int attackRange)
	{
		final List<Tile> adjacentTiles = this.getAdjacentTiles(position, attackRange);
		adjacentTiles.removeIf(tile -> !(tile.getCurrentElement() instanceof Figure<? extends Troop>));
		return adjacentTiles;
	}


	public List<Tile> getAdjacentTiles (final Position position)
	{
		return this.getAdjacentTiles(position, RANGE);
	}


	public List<Tile> getAdjacentTiles (final Position position, final int range)
	{
		final List<Tile> adjacentTiles = new ArrayList<>();
		for (int i = (position.x() - range); i <= position.x() + range; i++)
		{
			for (int j = position.y() - range; j <= position.y() + range; j++)
			{
				try
				{
					adjacentTiles.add(this.gameBoard[i][j]);
				}
				catch (final IndexOutOfBoundsException ignored)
				{
				}
			}
		}
		adjacentTiles.remove(this.gameBoard[position.x()][position.y()]);
		return adjacentTiles;
	}


	public List<Tile> getAdjacentAccessibleTiles (final Position position)
	{
		final List<Tile> adjacentTiles = this.getAdjacentTiles(position);
		adjacentTiles.removeIf(tile -> !(tile.getCurrentElement() instanceof Placeholder));
		return adjacentTiles;
	}


	public List<Tile> getAdjacentAccessibleTiles (final Position position, final int range)
	{
		final List<Tile> adjacentTiles = this.getAdjacentTiles(position, range);
		adjacentTiles.removeIf(tile -> !(tile.getCurrentElement() instanceof Placeholder));
		return adjacentTiles;
	}

}
