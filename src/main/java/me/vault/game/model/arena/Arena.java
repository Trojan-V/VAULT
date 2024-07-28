package me.vault.game.model.arena;


import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import me.vault.game.interfaces.Placeable;
import me.vault.game.model.troop.Troop;
import me.vault.game.utility.loading.ResourceLoader;
import me.vault.game.utility.struct.MetaDataImage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import static me.vault.game.utility.constant.ArenaConstants.MULTIPLIER;
import static me.vault.game.utility.constant.ArenaConstants.OFFSET;
import static me.vault.game.utility.constant.GameConstants.WINDOW_ICON_PATH;


public class Arena implements Placeable
{
	private final SimpleStringProperty nameProperty = new SimpleStringProperty();


	private final SimpleObjectProperty<MetaDataImage> spriteProperty = new SimpleObjectProperty<>();

	private State state = State.RUNNING;


	public enum State
	{
		RUNNING,
		LOST,
		WON
	}


	private final List<Figure<? extends Troop>> playerOneTroops;


	private final List<Figure<? extends Troop>> playerTwoTroops;


	private final TroopTimeline troopTimeline;


	private final GameBoard gameBoard;


	private Figure<? extends Troop> selectedFigure = null;

	private final List<Figure<? extends Troop>> eliminatedTroops = new ArrayList<>();


	public Arena (final List<Figure<? extends Troop>> playerOneTroops, final List<Figure<? extends Troop>> playerTwoTroops, final GameBoard gameBoard)
	{
		this.spriteProperty.set(ResourceLoader.loadImage(WINDOW_ICON_PATH));
		this.playerOneTroops = playerOneTroops;
		this.playerTwoTroops = playerTwoTroops;
		this.gameBoard = gameBoard;
		this.troopTimeline = this.initializeTimeline(playerOneTroops, playerTwoTroops);

		this.setPlayerOneTroopPositions();
		this.setPlayerTwoTroopPositions();

	}


	private TroopTimeline initializeTimeline (final Collection<Figure<? extends Troop>> playerOneTroops, final Collection<Figure<? extends Troop>> playerTwoTroops)
	{
		final ArrayList<Figure<? extends Troop>> troops = new ArrayList<>();
		troops.addAll(playerOneTroops);
		troops.addAll(playerTwoTroops);

		return new TroopTimeline(troops);
	}


	public GameBoard getGameBoard ()
	{
		return this.gameBoard;
	}


	public TroopTimeline getTimeline ()
	{
		return this.troopTimeline;
	}


	private void placePlayerOneTroopAtRandomPosition (final Figure<? extends Troop> troop)
	{
		final Position randomPosition = new Position((int) Math.round(Math.random()), (int) Math.round(Math.random() * MULTIPLIER));

		if (this.getGameBoard().getTile(randomPosition).getCurrentElement().getClass() == Placeholder.class)
		{
			this.getGameBoard().placeFigure(randomPosition, troop);
			return;
		}
		this.placePlayerOneTroopAtRandomPosition(troop);
	}


	private void placePlayerTwoTroopAtRandomPosition (final Figure<? extends Troop> troop)
	{
		final Position randomPosition = new Position((int) Math.round(Math.random() + OFFSET), (int) Math.round(Math.random() * MULTIPLIER));

		if (this.getGameBoard().getTile(randomPosition).getCurrentElement().getClass() == Placeholder.class)
		{
			this.getGameBoard().placeFigure(randomPosition, troop);
			return;
		}
		this.placePlayerTwoTroopAtRandomPosition(troop);
	}


	private void setPlayerOneTroopPositions ()
	{
		for (final Figure<? extends Troop> troopFigure : this.playerOneTroops)
		{
			this.placePlayerOneTroopAtRandomPosition(troopFigure);
		}
	}


	private void setPlayerTwoTroopPositions ()
	{
		for (final Figure<? extends Troop> troopFigure : this.playerTwoTroops)
		{
			this.placePlayerTwoTroopAtRandomPosition(troopFigure);
		}
	}


	public Figure<? extends Troop> getSelectedFigure ()
	{
		return this.selectedFigure;
	}


	public void setSelectedFigure (final Figure<? extends Troop> selectedTroop)
	{
		this.selectedFigure = selectedTroop;
	}


	public List<Figure<? extends Troop>> getPlayerOneTroops ()
	{
		return this.playerOneTroops;
	}


	public List<Figure<? extends Troop>> getPlayerTwoTroops ()
	{
		return this.playerTwoTroops;
	}


	public void removeTroopFigure (final Figure<? extends Troop> troopFigure)
	{
		this.gameBoard.removeFigure(troopFigure);
		this.troopTimeline.removeTimelineElement(troopFigure);
		this.eliminatedTroops.add(troopFigure);
		this.checkForChangedState();
	}


	private void checkForChangedState ()
	{
		if (new HashSet<>(this.eliminatedTroops).containsAll(this.playerOneTroops))
		{
			this.state = State.LOST;
		}
		else if (new HashSet<>(this.eliminatedTroops).containsAll(this.playerTwoTroops))
		{
			this.state = State.WON;
		}
		else
		{
			this.state = State.RUNNING;
		}
	}


	public List<Figure<? extends Troop>> getEliminatedFigures ()
	{
		return this.eliminatedTroops;
	}


	public State getState ()
	{
		return this.state;
	}


	/**
	 * Returns the sprite that is stored within the property of the displayable object as an {@link MetaDataImage}.
	 *
	 * @return The sprite of the displayable object.
	 */
	@Override
	public MetaDataImage getSprite ()
	{
		return this.spriteProperty.get();
	}


	/**
	 * Sets the sprite of the displayable object to the supplied sprite.
	 *
	 * @param sprite The new sprite for the displayable object.
	 */
	@Override
	public void setSprite (final MetaDataImage sprite)
	{
		this.spriteProperty.set(sprite);
	}


	/**
	 * Returns the sprite property of the displayable object.
	 *
	 * @return The sprite property of the displayable object.
	 */
	@Override
	public SimpleObjectProperty<MetaDataImage> getSpriteProperty ()
	{
		return this.spriteProperty;
	}


	/**
	 * Returns the name stored within the property of the nameable object as a {@link String}.
	 *
	 * @return The name of the nameable object.
	 */
	@Override
	public String getName ()
	{
		return this.nameProperty.get();
	}


	/**
	 * Sets the name of the nameable object to the supplied name.
	 *
	 * @param name The new name for the nameable object.
	 */
	@Override
	public void setName (final String name)
	{
		this.nameProperty.set(name);
	}


	/**
	 * Returns the name property of the nameable object.
	 *
	 * @return The name property of the nameable object.
	 */
	@Override
	public SimpleStringProperty getNameProperty ()
	{
		return this.nameProperty;
	}
}
