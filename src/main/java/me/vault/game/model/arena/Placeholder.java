package me.vault.game.model.arena;


import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import me.vault.game.interfaces.Placable;
import me.vault.game.utility.loading.ResourceLoader;
import me.vault.game.utility.struct.MetaDataImage;


public class Placeholder implements Placable
{

	private static final String SPRITE_PATH = "src/main/resources/me/vault/game/assets/tile.png";


	private static final SimpleObjectProperty<MetaDataImage> SPRITE_PROPERTY = new SimpleObjectProperty<>(ResourceLoader.loadImage(SPRITE_PATH));


	public Placeholder ()
	{

	}


	/**
	 * Returns the sprite that is stored within the property of the displayable object as an {.
	 *
	 * @return The sprite of the displayable object.
	 */
	@Override
	public MetaDataImage getSprite ()
	{
		return SPRITE_PROPERTY.get();
	}


	/**
	 * Sets the sprite of the displayable object to the supplied sprite.
	 *
	 * @param sprite The new sprite for the displayable object.
	 */
	@Override
	public void setSprite (final MetaDataImage sprite)
	{
		SPRITE_PROPERTY.set(sprite);
	}


	/**
	 * Returns the sprite property of the displayable object.
	 *
	 * @return The sprite property of the displayable object.
	 */
	@Override
	public SimpleObjectProperty<MetaDataImage> getSpriteProperty ()
	{
		return SPRITE_PROPERTY;
	}


	/**
	 * Returns the name stored within the property of the nameable object as a {@link String}.
	 *
	 * @return The name of the nameable object.
	 */
	@Override
	public String getName ()
	{
		return "";
	}


	/**
	 * Sets the name of the nameable object to the supplied name.
	 *
	 * @param name The new name for the nameable object.
	 */
	@Override
	public void setName (final String name)
	{

	}


	/**
	 * Returns the name property of the nameable object.
	 *
	 * @return The name property of the nameable object.
	 */
	@Override
	public SimpleStringProperty getNameProperty ()
	{
		return null;
	}

}
