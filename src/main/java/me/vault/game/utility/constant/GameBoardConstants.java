package me.vault.game.utility.constant;


import static me.vault.game.utility.constant.ConstantInterface.Constant;


/**
 * Description
 *
 * @author Vincent Wolf
 * @version 1.0.0
 * @see
 * @since 28.07.2024
 */
public interface GameBoardConstants
{

	char PLAYER_START_TILE = 'd';

	char OBSTACLE_TILE = 'h';

	char RESOURCE_TILE = 'r';

	char ARENA_TILE = 'e';

	char MISSION_FINISH_TILE = 'm';


	@Constant
	int GAME_BOARD_ROW_COUNT = 12;

	@Constant
	int GAME_BOARD_MAXIMUM_INDEX = 11;

	@Constant
	int GAME_BOARD_COLUMN_COUNT = 12;

}
