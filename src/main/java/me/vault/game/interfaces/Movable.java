package me.vault.game.interfaces;


import me.vault.game.model.arena.Figure;
import me.vault.game.model.player.Player;


/**
 * An interface for objects that are movable.
 * <br>
 * For instance, {@link Figure}s and {@link Player}s are movable, as they need to be moved in the arena (and the
 * {@link Player} also needs to move on the mission map).
 *
 * @author Vincent Wolf, Lasse-Leander Hillen, Timothy Hoegen-Jupp, Alexander Goethel
 * @version 1.0.0
 * @see Placeable
 * @since 29.07.2024
 */
public interface Movable extends Placeable
{
}
