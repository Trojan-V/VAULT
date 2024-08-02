package me.vault.game.model.gameboard.tile.implementation;


import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.image.Image;
import me.vault.game.model.Mission;
import me.vault.game.model.Player;
import me.vault.game.model.arena.Arena;
import me.vault.game.model.gameboard.Figure;
import me.vault.game.model.gameboard.GameBoard;
import me.vault.game.utility.datatypes.MetaDataImage;
import me.vault.game.utility.interfaces.Placeable;
import me.vault.game.utility.loading.ResourceLoader;


/**
 * This class represents a {@link Placeable} object that can be placed on the {@link GameBoard}, so either on the
 * {@link GameBoard} of an arena or on the {@link GameBoard} of a mission.
 * <br>
 * This object is an accessible tile, so {@link Player}s and {@link Figure}s can move onto it.
 * <br>
 * This tile type is available on the {@link GameBoard} of the {@link Mission} as well as the {@link Arena}.
 *
 * @author Vincent Wolf, Lasse-Leander Hillen, Timothy Hoegen-Jupp, Alexander Goethel
 * @version 1.0.0
 * @see Placeable
 * @see GameBoard
 * @since 29.07.2024
 */
public class AccessibleElement implements Placeable
{

	/**
	 * The path to the sprite that represents an accessible tile.
	 */
	private static final String SPRITE_PATH = "src/main/resources/me/vault/game/assets/tile.png";


	/**
	 * The property that contains the sprite. This property is bound to the GUI.
	 */
	private static final SimpleObjectProperty<MetaDataImage> SPRITE_PROPERTY = new SimpleObjectProperty<>(ResourceLoader.loadImage(SPRITE_PATH));


	/**
	 * Returns the sprite stored within the property of the displayable object as an {@link Image}.
	 *
	 * @return The sprite of the displayable object.
	 *
	 * @precondition The sprite attribute of the Displayable has been set and is != null.
	 * @postcondition The sprite attribute of the Displayable was returned.
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
	 *
	 * @precondition A valid instance of {@link MetaDataImage} that isn't equal to null has been passed into the method.
	 * @postcondition The sprite attribute in the Displayable has been set to the passed {@link MetaDataImage}.
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
	 *
	 * @precondition The spriteProperty attribute of the Displayable has been set and is != null.
	 * @postcondition The spriteProperty attribute of the Displayable was returned.
	 */
	@Override
	public SimpleObjectProperty<MetaDataImage> getSpriteProperty ()
	{
		return SPRITE_PROPERTY;
	}

}
