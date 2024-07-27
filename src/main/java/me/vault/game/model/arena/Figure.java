package me.vault.game.model.arena;


import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import me.vault.game.interfaces.Placable;
import me.vault.game.model.troop.Troop;
import me.vault.game.model.troop.TroopStatistics;
import me.vault.game.utility.logging.ILogger;
import me.vault.game.utility.logging.Logger;
import me.vault.game.utility.struct.MetaDataImage;


public final class Figure<T extends Troop> implements Placable
{

	private static final ILogger LOGGER = new Logger(Figure.class.getSimpleName());

	private T troop = null;

	private SimpleStringProperty name = null;

	private SimpleObjectProperty<MetaDataImage> spriteProperty = null;

	private TroopStatistics statistics = null;


	public Figure (final T troop)
	{
		this.troop = troop;
		this.name = troop.getNameProperty();
		this.spriteProperty = troop.getSpriteProperty();
		this.statistics = new TroopStatistics(troop.getStatistics());
	}


	public T getTroop ()
	{
		return this.troop;
	}


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
