package me.vault.game.model.gameboard.tile.implementation;


import javafx.beans.property.SimpleObjectProperty;
import me.vault.game.model.Mission;
import me.vault.game.model.Player;
import me.vault.game.model.gameboard.GameBoard;
import me.vault.game.utility.datatypes.MetaDataImage;
import me.vault.game.utility.interfaces.Placeable;
import me.vault.game.utility.loading.ResourceLoader;


/**
 * This class represents a {@link Placeable} object that can be placed on the {@link GameBoard}, so either on the
 * {@link GameBoard} of an arena or on the {@link GameBoard} of a mission.
 * <br>
 * This object represents a tile that starts an encounter, so once the {@link Player} is next to this tile and
 * attempts to move onto it, the encounter will be started.
 * <br>
 * This tile type is only available on the {@link GameBoard} of the {@link Mission}.
 *
 * @author Vincent Wolf, Lasse-Leander Hillen, Timothy Hoegen-Jupp, Alexander Goethel
 * @version 1.0.0
 * @see Placeable
 * @see GameBoard
 * @since 29.07.2024
 */
public class ArenaStartElement implements Placeable
{

	/**
	 * The path to the sprite that represents a start arena/start encounter tile.
	 */
	private static final String SPRITE_PATH = "src/main/resources/me/vault/game/assets/troops/engineer_icon.png";


	/**
	 * The property that contains the sprite. This property is bound to the GUI.
	 */
	private static final SimpleObjectProperty<MetaDataImage> SPRITE_PROPERTY =
		new SimpleObjectProperty<>(ResourceLoader.loadImage(SPRITE_PATH));


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