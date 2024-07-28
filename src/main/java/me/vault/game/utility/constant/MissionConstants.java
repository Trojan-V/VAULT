package me.vault.game.utility.constant;


import me.vault.game.model.arena.GameBoard;
import me.vault.game.model.currency.CurrencyTransaction;
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
		String MISSION_ONE_NAME = "";

		@Constant
		String MISSION_ONE_DESCRIPTION = "";

		@Constant
		GameBoard MISSION_ONE_GAME_BOARD =
			new GameBoard(ResourceLoader.createGameBoardFromFile("src/main/resources/me/vault/game/map" +
			                                                     "/story_mission_one.txt"));

		@Constant
		CurrencyTransaction MISSION_ONE_REWARDS = new CurrencyTransaction(1000, 1000, 1000, 1000, 1000);

		@Constant
		Mission MISSION_ONE =
			new Mission(MISSION_ONE_NAME, MISSION_ONE_DESCRIPTION, MISSION_ONE_GAME_BOARD, MISSION_ONE_REWARDS);

	}


	@ConstantInterface
	interface MissionTwo
	{

		@Constant
		String MISSION_TWO_NAME = "";

		@Constant
		String MISSION_TWO_DESCRIPTION = "";

		@Constant
		GameBoard MISSION_TWO_MAP = new GameBoard(null);    // TODO: null remove

		@Constant
		CurrencyTransaction MISSION_TWO_REWARDS = new CurrencyTransaction(1000, 1000, 1000, 1000, 1000);

		@Constant
		Mission MISSION_TWO = new Mission(MISSION_TWO_NAME, MISSION_TWO_DESCRIPTION, MISSION_TWO_MAP, MISSION_TWO_REWARDS);

	}


	@ConstantInterface
	interface MissionThree
	{

		@Constant
		String MISSION_THREE_NAME = "";

		@Constant
		String MISSION_THREE_DESCRIPTION = "";

		@Constant
		GameBoard MISSION_THREE_MAP = new GameBoard(null);  // TODO: null remove

		@Constant
		CurrencyTransaction MISSION_THREE_REWARDS = new CurrencyTransaction(1000, 1000, 1000, 1000, 1000);

		@Constant
		Mission MISSION_THREE = new Mission(MISSION_THREE_NAME, MISSION_THREE_DESCRIPTION, MISSION_THREE_MAP, MISSION_THREE_REWARDS);

	}


	@ConstantInterface
	interface MissionFour
	{

		@Constant
		String MISSION_FOUR_NAME = "";

		@Constant
		String MISSION_FOUR_DESCRIPTION = "";

		@Constant
		GameBoard MISSION_FOUR_MAP = new GameBoard(null); // TODO: null remove

		@Constant
		CurrencyTransaction MISSION_FOUR_REWARDS = new CurrencyTransaction(1000, 1000, 1000, 1000, 1000);

		@Constant
		Mission MISSION_FOUR = new Mission(MISSION_FOUR_NAME, MISSION_FOUR_DESCRIPTION, MISSION_FOUR_MAP, MISSION_FOUR_REWARDS);

	}

}
