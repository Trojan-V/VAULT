package me.vault.game.utility.constant;


import me.vault.game.model.currency.CurrencyTransaction;
import me.vault.game.model.gameboard.GameBoard;
import me.vault.game.model.mission.Mission;
import me.vault.game.utility.constant.ConstantInterface.Constant;
import me.vault.game.utility.loading.ResourceLoader;


@ConstantInterface
public interface MissionConstants
{

	@ConstantInterface
	interface MissionOne
	{

		@Constant
		String MISSION_ONE_FILE_PATH = "src/main/resources/me/vault/game/map/Story_1.txt";

		@Constant
		GameBoard MISSION_ONE_GAME_BOARD = new GameBoard(ResourceLoader.createTileArrayFromFile(MISSION_ONE_FILE_PATH));

		@Constant
		CurrencyTransaction MISSION_ONE_REWARDS = new CurrencyTransaction(1000, 1000, 1000, 1000, 1000);

		@Constant
		Mission MISSION_ONE = new Mission(MISSION_ONE_GAME_BOARD, MISSION_ONE_REWARDS);

	}


	@ConstantInterface
	interface MissionTwo
	{

		@Constant
		String MISSION_TWO_FILE_PATH = "src/main/resources/me/vault/game/map/Story_2.txt";

		@Constant
		GameBoard MISSION_TWO_GAME_BOARD = new GameBoard(ResourceLoader.createTileArrayFromFile(MISSION_TWO_FILE_PATH));

		@Constant
		CurrencyTransaction MISSION_TWO_REWARDS = new CurrencyTransaction(2000, 2000, 2000, 2000, 2000);

		@Constant
		Mission MISSION_TWO = new Mission(MISSION_TWO_GAME_BOARD, MISSION_TWO_REWARDS);

	}


	@ConstantInterface
	interface MissionThree
	{

		@Constant
		String MISSION_THREE_FILE_PATH = "src/main/resources/me/vault/game/map/Repeatable_1.txt";

		@Constant
		GameBoard MISSION_THREE_GAME_BOARD = new GameBoard(ResourceLoader.createTileArrayFromFile(MISSION_THREE_FILE_PATH));

		@Constant
		CurrencyTransaction MISSION_THREE_REWARDS = new CurrencyTransaction(3000, 3000, 3000, 3000, 3000);

		@Constant
		Mission MISSION_THREE = new Mission(MISSION_THREE_GAME_BOARD, MISSION_THREE_REWARDS);

	}


	@ConstantInterface
	interface MissionFour
	{

		@Constant
		String MISSION_FOUR_FILE_PATH = "src/main/resources/me/vault/game/map/Repeatable_2.txt";

		@Constant
		GameBoard MISSION_FOUR_GAME_BOARD = new GameBoard(ResourceLoader.createTileArrayFromFile(MISSION_FOUR_FILE_PATH));

		@Constant
		CurrencyTransaction MISSION_FOUR_REWARDS = new CurrencyTransaction(4000, 4000, 4000, 4000, 4000);

		@Constant
		Mission MISSION_FOUR = new Mission(MISSION_FOUR_GAME_BOARD, MISSION_FOUR_REWARDS);

	}

}
