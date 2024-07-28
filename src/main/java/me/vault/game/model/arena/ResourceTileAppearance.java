package me.vault.game.model.arena;


import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import me.vault.game.interfaces.Placeable;
import me.vault.game.utility.loading.ResourceLoader;
import me.vault.game.utility.struct.MetaDataImage;


/**
 * Description
 *
 * @author Vincent Wolf
 * @version 1.0.0
 * @see
 * @since 28.07.2024
 */
public class ResourceTileAppearance implements Placeable
{
	private static final String SPRITE_PATH = "src/main/resources/me/vault/game/assets/currency/credit_icon.png";


	private static final SimpleObjectProperty<MetaDataImage> SPRITE_PROPERTY =
		new SimpleObjectProperty<>(ResourceLoader.loadImage(SPRITE_PATH));


	public ResourceTileAppearance () {}


	@Override
	public MetaDataImage getSprite ()
	{
		return SPRITE_PROPERTY.get();
	}


	@Override
	public void setSprite (final MetaDataImage sprite)
	{
		SPRITE_PROPERTY.set(sprite);
	}


	@Override
	public SimpleObjectProperty<MetaDataImage> getSpriteProperty ()
	{
		return SPRITE_PROPERTY;
	}


	// TODO: set some name or some type shit
	@Override
	public String getName ()
	{
		return "";
	}


	@Override
	public void setName (final String name)
	{

	}


	@Override
	public SimpleStringProperty getNameProperty ()
	{
		return null;
	}
}
