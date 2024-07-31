package me.vault.game.utility.interfaces;


import me.vault.game.model.Player;
import me.vault.game.model.gameboard.Figure;


/**
 * An interface for objects that are placeable.
 * <br>
 * For instance, {@link Figure}s and {@link Player}s are placeable, as they need to be placed in the arena or in the
 * mission.
 * <br>
 * There are a lot more placeable objects than these two, but they just serve as examples.
 *
 * @author Vincent Wolf, Lasse-Leander Hillen, Timothy Hoegen-Jupp, Alexander Goethel
 * @version 1.0.0
 * @see Figure
 * @see Player
 * @since 29.07.2024
 */
public interface Placeable extends Displayable
{
}
