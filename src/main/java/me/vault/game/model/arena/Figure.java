package me.vault.game.model.arena;


import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import me.vault.game.interfaces.Movable;
import me.vault.game.interfaces.Nameable;
import me.vault.game.model.artifact.impl.DamageArtifact;
import me.vault.game.model.gameboard.GameBoard;
import me.vault.game.model.mission.Mission;
import me.vault.game.model.troop.Troop;
import me.vault.game.model.troop.TroopStatistics;
import me.vault.game.utility.struct.MetaDataImage;

import java.text.MessageFormat;


/**
 * A figure can be placed and moved on the {@link GameBoard}.
 * <br>
 * Figures can be either allies or enemies and fight each other in the arena.
 * <br>
 * Additionally, figures can also appear on the {@link GameBoard} of {@link Mission}s.
 *
 * @author Vincent Wolf
 * @version 1.0.0
 * @see GameBoard
 * @see Mission
 * @see Movable
 * @see Nameable
 * @since 29.07.2024
 */
public final class Figure implements Movable, Nameable
{
	/**
	 * The {@link MessageFormat} pattern, which is used, when the {@link Figure#toString()} is called.
	 */
	private static final String TO_STRING_PATTERN =
		"Figure'{'troop={0}, name={1}, spriteProperty={2}, statistics={3}'}'";


	/**
	 * The troop that'll be used to generate the figure.
	 * <br>
	 * The figure is basically just a copy of this troop, but the values of the figure are changed during the fight
	 * to reflect the outcomes of battles.
	 */
	private final Troop troop;


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
	public Figure (final Troop troop)
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
	public Troop getTroop ()
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


	/**
	 * Builds a formatted {@link String}, which represents the object, and it's current state using the
	 * {@link Figure#TO_STRING_PATTERN}.
	 *
	 * @return A {@link String} which has been formatted in the {@link Figure#TO_STRING_PATTERN}.
	 * @precondition The {@link Figure#TO_STRING_PATTERN} is {@code != null}.
	 * @postcondition The method returned a {@link String} which represents the object.
	 */
	@Override
	public String toString ()
	{
		return MessageFormat.format(TO_STRING_PATTERN, this.troop.toString(), this.name.get(),
			this.spriteProperty.get()
				.toString(), this.statistics.toString());
	}
}
