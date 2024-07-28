package me.vault.game.model.arena;


import me.vault.game.interfaces.Placeable;
import me.vault.game.model.player.Player;
import me.vault.game.model.troop.Troop;

import java.util.ArrayList;
import java.util.List;


public class GameBoard
{

	private static final int DEFAULT_RANGE = 1;


	private final Tile[][] gameBoard;


	public GameBoard (final Tile[][] gameBoard)
	{
		this.gameBoard = gameBoard;
	}


	public Tile[][] getGameBoard ()
	{
		return this.gameBoard;
	}


	public Position getFigurePosition (final Figure<? extends Troop> figure)
	{
		return this.getEntityPosition(figure);
	}


	public Position getFigurePosition (final Player player)
	{
		return this.getEntityPosition(player);
	}


	private Position getEntityPosition (final Placeable placeable)
	{
		for (int i = 0; i < this.gameBoard.length; i++)
		{
			for (int j = 0; j < this.gameBoard[0].length; j++)
			{
				if (this.gameBoard[i][j].getCurrentElement() == placeable)
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


	public Figure<? extends Troop> getFigure (final Position position) throws Exception
	{
		if (!(this.gameBoard[position.x()][position.y()].getCurrentElement() instanceof Figure))
		{
			throw new Exception("Not a troop exception..."); // TODO: Implementieren der neuen exception
		}
		return (Figure<? extends Troop>) this.gameBoard[position.x()][position.y()].getCurrentElement();
	}


	public void placeIfPlaceholder (final Position position, final Placeable troopFigure)
	{
		if (this.gameBoard[position.x()][position.y()].getCurrentElement().getClass() ==
		    PlaceholderTileAppearance.class)
		{
			this.place(position, troopFigure);
		}
	}


	public void place (final Position position, final Placeable placeable)
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
		return this.getAdjacentTiles(position, DEFAULT_RANGE);
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
				catch (final IndexOutOfBoundsException _)
				{
				}
			}
		}
		adjacentTiles.remove(this.gameBoard[position.x()][position.y()]);
		return adjacentTiles;
	}


	public List<Tile> getAdjacentPlaceholderTiles (final Position position)
	{
		final List<Tile> adjacentTiles = this.getAdjacentTiles(position);
		adjacentTiles.removeIf(tile -> !(tile.getCurrentElement() instanceof PlaceholderTileAppearance));
		return adjacentTiles;
	}


	public List<Tile> getAdjacentPlaceholderTiles (final Position position, final int range)
	{
		final List<Tile> adjacentTiles = this.getAdjacentTiles(position, range);
		adjacentTiles.removeIf(tile -> !(tile.getCurrentElement() instanceof PlaceholderTileAppearance));
		return adjacentTiles;
	}


	public void removeFigure (final Figure<? extends Troop> troopFigure)
	{
		this.place(this.getFigurePosition(troopFigure), new PlaceholderTileAppearance());
	}

}
