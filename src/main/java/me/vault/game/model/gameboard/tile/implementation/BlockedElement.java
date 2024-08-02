package me.vault.game.model.gameboard.tile.implementation;


import javafx.beans.property.SimpleObjectProperty;
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
 * This object represents a tile that is blocked, so it's an obstacle and neither the {@link Player} nor any other
 * {@link Figure} can move onto it.
 * <br>
 * This tile type is available on the {@link GameBoard} of the {@link Mission} as well as the {@link Arena}.
 *
 * @author Vincent Wolf, Lasse-Leander Hillen, Timothy Hoegen-Jupp, Alexander Goethel
 * @version 1.0.0
 * @see Placeable
 * @see GameBoard
 * @since 29.07.2024
 */
public class BlockedElement implements Placeable
{

	/**
	 * The path to the sprite that represents a blocked tile.
	 */
	private static final String SPRITE_PATH = "src/main/resources/me/vault/game/assets/statistics/resistance_icon.png";


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
