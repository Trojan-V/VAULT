package me.vault.game.model.arena;


import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import me.vault.game.interfaces.Movable;
import me.vault.game.interfaces.Nameable;
import me.vault.game.model.gameboard.GameBoard;
import me.vault.game.model.mission.Mission;
import me.vault.game.model.troop.Troop;
import me.vault.game.model.troop.TroopStatistics;
import me.vault.game.utility.struct.MetaDataImage;


/**
 * A figure can be placed and moved on the {@link GameBoard}.
 * <br>
 * Figures can be either allies or enemies and fight each other in the arena.
 * <br>
 * Additionally, figures can also appear on the {@link GameBoard} of {@link Mission}s.
 *
 * @param <T> // TODO: What is the T for?
 * @author Vincent Wolf
 * @version 1.0.0
 * @see GameBoard
 * @see Mission
 * @see Movable
 * @see Nameable
 * @since 29.07.2024
 */
public final class Figure<T extends Troop> implements Movable, Nameable
{
	// TODO: VIncent mach mal
	private final T troop;


	/**
	 * This property is used to store and display the name of the figure.
	 * If the value is updated within this property, JavaFX instantly applies the change,
	 * so it's visible in the GUI.
	 */
	private final SimpleStringProperty name;


	/**
	 * This property is used to store and display the sprite that represents the figure.
	 * If the value is updated within this property, JavaFX instantly applies the change,
	 * so it's visible in the GUI.
	 */
	private final SimpleObjectProperty<MetaDataImage> spriteProperty;


	/**
	 * The statistics the figure has. Contains information about offensive, defensive and dexterity statistics.
	 */
	private final TroopStatistics statistics;


	/**
	 * Constructs an instance of a figure by using the data from the specified {@link Troop}.
	 * <br>
	 * The figure essentially reflects exactly the statistics the {@link Troop} has. The difference is that the troop
	 * represents the model displayed in the city (the one that can be upgraded etc.), while the figure represents
	 * the movable object on the {@link GameBoard} in the arena.
	 *
	 * @param troop The troop model whose statistics are used to create the corresponding figure to it.
	 */
	public Figure (final T troop)
	{
		this.troop = troop;
		this.name = troop.getNameProperty();
		this.spriteProperty = troop.getSpriteProperty();
		this.statistics = new TroopStatistics(troop.getStatistics());
	}


	/**
	 * Returns the troop whose statistics were used to create this figure instance.
	 *
	 * @return The troop whose statistics were used to create this figure instance.
	 */
	public T getTroop ()
	{
		return this.troop;
	}


	/**
	 * Returns the current statistics of the figure.
	 *
	 * @return The current statistics of the figure.
	 */
	public TroopStatistics getStatistics ()
	{
		return this.statistics;
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public MetaDataImage getSprite ()
	{
		return this.spriteProperty.get();
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setSprite (final MetaDataImage sprite)
	{
		this.spriteProperty.set(sprite);
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public SimpleObjectProperty<MetaDataImage> getSpriteProperty ()
	{
		return this.spriteProperty;
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getName ()
	{
		return this.name.get();
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setName (final String name)
	{
		this.name.set(name);
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public SimpleStringProperty getNameProperty ()
	{
		return this.name;
	}
}
