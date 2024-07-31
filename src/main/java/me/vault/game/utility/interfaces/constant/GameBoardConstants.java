package me.vault.game.utility.interfaces.constant;


import me.vault.game.model.gameboard.GameBoard;

import static me.vault.game.utility.interfaces.constant.ConstantInterface.Constant;


/**
 * This interface contains constants related to the {@link GameBoard}.
 *
 * @author Vincent Wolf, Lasse-Leander Hillen, Timothy Hoegen-Jupp, Alexander Goethel
 * @version 1.0.0
 * @see GameBoard
 * @since 28.07.2024
 */
@ConstantInterface
public interface GameBoardConstants
{

	/**
	 * The character that represents the player start tile in the game board map files.
	 */
	@Constant
	char PLAYER_START_TILE = 'd';


	/**
	 * The character that represents blocked tiles in the game board map files.
	 */
	@Constant
	char BLOCKED_TILE = 'h';


	/**
	 * The character that represents resource tiles in the game board map files.
	 */
	@Constant
	char RESOURCE_TILE = 'r';


	/**
	 * The character that represents arena encounter tiles in the game board map files.
	 */
	@Constant
	char ARENA_TILE = 'e';


	/**
	 * The character that represents the mission finish tile in the game board map files.
	 */
	@Constant
	char MISSION_FINISH_TILE = 'm';


	/**
	 * The number of rows the {@link GameBoard} consists of.
	 */
	@Constant
	int GAME_BOARD_ROW_COUNT = 12;


	/**
	 * The number of columns the {@link GameBoard} consists of.
	 */
	@Constant
	int GAME_BOARD_COLUMN_COUNT = 12;


	/**
	 * The maximum index for the internal data structure of the {@link GameBoard}, as it's zero-indexed.
	 */
	@Constant
	int GAME_BOARD_MAXIMUM_INDEX = 11;

}
