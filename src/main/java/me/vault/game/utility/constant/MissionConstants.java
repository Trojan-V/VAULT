package me.vault.game.utility.constant;


import javafx.scene.layout.GridPane;
import me.vault.game.model.currency.CurrencyTransaction;
import me.vault.game.model.gameboard.GameBoard;
import me.vault.game.model.mission.Mission;
import me.vault.game.utility.constant.ConstantInterface.Constant;
import me.vault.game.utility.loading.ResourceLoader;


/**
 * This interface provides constants which contain information about the different playable missions of the game.
 * The interface is split into several subinterfaces to further differentiate between the different missions.
 * The interface uses the {@link ConstantInterface} annotation which is a marker annotation for interfaces that only contain constants.
 *
 * @author Vincent Wolf, Lasse-Leander Hillen, Timothy Hoegen-Jupp, Alexander Goethel
 * @version 1.0.0
 * @since 29.05.2024
 */
@ConstantInterface
public interface MissionConstants
{

	/**
	 * This interface provides constants which contain information about the first playable mission of the game.
	 * The interface uses the {@link ConstantInterface} annotation which is a marker annotation for interfaces that only contain constants.
	 *
	 * @author Vincent Wolf, Lasse-Leander Hillen, Timothy Hoegen-Jupp, Alexander Goethel
	 * @version 1.0.0
	 * @since 29.05.2024
	 */
	@ConstantInterface
	interface MissionOne
	{

		/**
		 * The path to the map-file that contains the board information for the first mission game board and the grid pane.
		 */
		@Constant
		String MISSION_ONE_FILE_PATH = "src/main/resources/me/vault/game/map/Story_1.txt";

		/**
		 * The {@link GameBoard} of the first mission used to display and update the {@link GridPane} of the MissionDelegate.
		 */
		@Constant
		GameBoard MISSION_ONE_GAME_BOARD = new GameBoard(ResourceLoader.createTileArrayFromFile(MISSION_ONE_FILE_PATH));


		/**
		 * The {@link CurrencyTransaction}, which represents the rewards for the player, if the first mission is finished successfully.
		 */
		@Constant
		CurrencyTransaction MISSION_ONE_REWARDS = new CurrencyTransaction(1000, 1000, 1000, 1000, 1000);

		/**
		 * The {@link Mission}, which represents the first playable mission of the game.
		 */
		@Constant
		Mission MISSION_ONE = new Mission(MISSION_ONE_GAME_BOARD, MISSION_ONE_REWARDS);

	}


	/**
	 * This interface provides constants which contain information about the second playable mission of the game.
	 * The interface uses the {@link ConstantInterface} annotation which is a marker annotation for interfaces that only contain constants.
	 *
	 * @author Vincent Wolf, Lasse-Leander Hillen, Timothy Hoegen-Jupp, Alexander Goethel
	 * @version 1.0.0
	 * @since 29.05.2024
	 */
	@ConstantInterface
	interface MissionTwo
	{

		/**
		 * The path to the map-file that contains the board information for the second mission game board and the grid pane.
		 */
		@Constant
		String MISSION_TWO_FILE_PATH = "src/main/resources/me/vault/game/map/Story_2.txt";

		/**
		 * The {@link GameBoard} of the second mission used to display and update the {@link GridPane} of the MissionDelegate.
		 */
		@Constant
		GameBoard MISSION_TWO_GAME_BOARD = new GameBoard(ResourceLoader.createTileArrayFromFile(MISSION_TWO_FILE_PATH));


		/**
		 * The {@link CurrencyTransaction}, which represents the rewards for the player, if the second mission is finished successfully.
		 */
		@Constant
		CurrencyTransaction MISSION_TWO_REWARDS = new CurrencyTransaction(2000, 2000, 2000, 2000, 2000);

		/**
		 * The {@link Mission}, which represents the second playable mission of the game.
		 */
		@Constant
		Mission MISSION_TWO = new Mission(MISSION_TWO_GAME_BOARD, MISSION_TWO_REWARDS);

	}


	/**
	 * This interface provides constants which contain information about the third playable mission of the game.
	 * The interface uses the {@link ConstantInterface} annotation which is a marker annotation for interfaces that only contain constants.
	 *
	 * @author Vincent Wolf, Lasse-Leander Hillen, Timothy Hoegen-Jupp, Alexander Goethel
	 * @version 1.0.0
	 * @since 29.05.2024
	 */
	@ConstantInterface
	interface MissionThree
	{

		/**
		 * The path to the map-file that contains the board information for the third mission game board and the grid pane.
		 */
		@Constant
		String MISSION_THREE_FILE_PATH = "src/main/resources/me/vault/game/map/Repeatable_1.txt";

		/**
		 * The {@link GameBoard} of the third mission used to display and update the {@link GridPane} of the MissionDelegate.
		 */
		@Constant
		GameBoard MISSION_THREE_GAME_BOARD = new GameBoard(ResourceLoader.createTileArrayFromFile(MISSION_THREE_FILE_PATH));


		/**
		 * The {@link CurrencyTransaction}, which represents the rewards for the player, if the third mission is finished successfully.
		 */
		@Constant
		CurrencyTransaction MISSION_THREE_REWARDS = new CurrencyTransaction(3000, 3000, 3000, 3000, 3000);

		/**
		 * The {@link Mission}, which represents the third playable mission of the game.
		 */
		@Constant
		Mission MISSION_THREE = new Mission(MISSION_THREE_GAME_BOARD, MISSION_THREE_REWARDS);

	}


	/**
	 * This interface provides constants which contain information about the fourth playable mission of the game.
	 * The interface uses the {@link ConstantInterface} annotation which is a marker annotation for interfaces that only contain constants.
	 *
	 * @author Vincent Wolf, Lasse-Leander Hillen, Timothy Hoegen-Jupp, Alexander Goethel
	 * @version 1.0.0
	 * @since 29.05.2024
	 */
	@ConstantInterface
	interface MissionFour
	{

		/**
		 * The path to the map-file that contains the board information for the fourth mission game board and the grid pane.
		 */
		@Constant
		String MISSION_FOUR_FILE_PATH = "src/main/resources/me/vault/game/map/Repeatable_2.txt";

		/**
		 * The {@link GameBoard} of the fourth mission used to display and update the {@link GridPane} of the MissionDelegate.
		 */
		@Constant
		GameBoard MISSION_FOUR_GAME_BOARD = new GameBoard(ResourceLoader.createTileArrayFromFile(MISSION_FOUR_FILE_PATH));


		/**
		 * The {@link CurrencyTransaction}, which represents the rewards for the player, if the fourth mission is finished successfully.
		 */
		@Constant
		CurrencyTransaction MISSION_FOUR_REWARDS = new CurrencyTransaction(4000, 4000, 4000, 4000, 4000);

		/**
		 * The {@link Mission}, which represents the fourth playable mission of the game.
		 */
		@Constant
		Mission MISSION_FOUR = new Mission(MISSION_FOUR_GAME_BOARD, MISSION_FOUR_REWARDS);

	}

}
