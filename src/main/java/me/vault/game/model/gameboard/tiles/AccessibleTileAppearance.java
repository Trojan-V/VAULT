package me.vault.game.model.gameboard.tiles;


import javafx.beans.property.SimpleObjectProperty;
import me.vault.game.interfaces.Placeable;
import me.vault.game.model.arena.Arena;
import me.vault.game.model.arena.Figure;
import me.vault.game.model.gameboard.GameBoard;
import me.vault.game.model.mission.Mission;
import me.vault.game.model.player.Player;
import me.vault.game.utility.loading.ResourceLoader;
import me.vault.game.utility.struct.MetaDataImage;


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
public class AccessibleTileAppearance implements Placeable
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
	 * {@inheritDoc}
	 */
	@Override
	public MetaDataImage getSprite ()
	{
		return SPRITE_PROPERTY.get();
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setSprite (final MetaDataImage sprite)
	{
		SPRITE_PROPERTY.set(sprite);
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public SimpleObjectProperty<MetaDataImage> getSpriteProperty ()
	{
		return SPRITE_PROPERTY;
	}
}
