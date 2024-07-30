package me.vault.game.utility.constant;


import me.vault.game.model.arena.Arena;
import me.vault.game.model.arena.Figure;
import me.vault.game.model.gameboard.GameBoard;
import me.vault.game.model.troop.impl.Lieutenant;
import me.vault.game.model.troop.impl.Ranger;
import me.vault.game.model.troop.impl.Recruit;
import me.vault.game.model.troop.impl.Sniper;
import me.vault.game.utility.loading.ResourceLoader;

import java.util.ArrayList;
import java.util.List;

import static me.vault.game.utility.constant.ConstantInterface.Constant;


/**
 * This interface provides constants which contain information about the different playable arenas of the game.
 * The interface is split into several subinterfaces to further differentiate between the different arenas.
 * The interface uses the {@link ConstantInterface} annotation which is a marker annotation for interfaces that only contain constants.
 *
 * @author Vincent Wolf, Lasse-Leander Hillen, Timothy Hoegen-Jupp, Alexander Goethel
 * @version 5.0.0
 * @since 30.05.2024
 */
@ConstantInterface
public interface ArenaConstants
{
	/**
	 * The path to the respective fxml file of the arenas as a {@link String}.
	 */
	@Constant
	String ARENA_FXML = "arena.fxml";


	/**
	 * The tile offset between the allied troops and the enemy troops on the game board and grid pane.
	 */
	@Constant
	int ENEMY_UNIT_TILE_OFFSET = 10;


	/**
	 * This subinterface provides constants which contain information about the first playable arena of the game.
	 * The subinterface uses the {@link ConstantInterface} annotation which is a marker annotation for interfaces that only contain constants.
	 *
	 * @author Vincent Wolf, Lasse-Leander Hillen, Timothy Hoegen-Jupp, Alexander Goethel
	 * @version 5.0.0
	 * @since 30.05.2024
	 */
	@ConstantInterface
	interface ArenaOne
	{
		/**
		 * The path to the map-file that contains the board information for the first arena game board and the grid pane.
		 */
		@Constant
		String ARENA_ONE_FILEPATH = "src/main/resources/me/vault/game/map/Encounter_1.txt";


		/**
		 * A list of figures that resemble the enemies the user has to fight in the first arena.
		 */
		@Constant
		ArrayList<Figure> ARENA_ONE_ENEMIES = new ArrayList<>()
		{{
			this.add(new Figure(Sniper.getInstance()));
			this.add(new Figure(Sniper.getInstance()));
			this.add(new Figure(Sniper.getInstance()));
		}};


		/**
		 * The {@link Arena}, which represents the first playable arena of the game.
		 */
		@Constant
		Arena ARENA_ONE = new Arena(List.of(), ARENA_ONE_ENEMIES, new GameBoard(ResourceLoader.createTileArrayFromFile(ARENA_ONE_FILEPATH)));

	}


	/**
	 * This subinterface provides constants which contain information about the second playable arena of the game.
	 * The subinterface uses the {@link ConstantInterface} annotation which is a marker annotation for interfaces that only contain constants.
	 *
	 * @author Vincent Wolf, Lasse-Leander Hillen, Timothy Hoegen-Jupp, Alexander Goethel
	 * @version 5.0.0
	 * @since 30.05.2024
	 */
	@ConstantInterface
	interface ArenaTwo
	{
		/**
		 * The path to the map-file that contains the board information for the second arena game board and the grid pane.
		 */
		@Constant
		String ARENA_TWO_FILEPATH = "src/main/resources/me/vault/game/map/Encounter_2.txt";


		/**
		 * A list of figures that resemble the enemies the user has to fight in the second arena.
		 */
		@Constant
		ArrayList<Figure> ARENA_TWO_ENEMIES = new ArrayList<>()
		{{
			this.add(new Figure(Ranger.getInstance()));
			this.add(new Figure(Ranger.getInstance()));
			this.add(new Figure(Ranger.getInstance()));
		}};


		/**
		 * The {@link Arena}, which represents the second playable arena of the game.
		 */
		@Constant
		Arena ARENA_TWO = new Arena(List.of(), ARENA_TWO_ENEMIES, new GameBoard(ResourceLoader.createTileArrayFromFile(ARENA_TWO_FILEPATH)));

	}


	/**
	 * This subinterface provides constants which contain information about the third playable arena of the game.
	 * The subinterface uses the {@link ConstantInterface} annotation which is a marker annotation for interfaces that only contain constants.
	 *
	 * @author Vincent Wolf, Lasse-Leander Hillen, Timothy Hoegen-Jupp, Alexander Goethel
	 * @version 5.0.0
	 * @since 30.05.2024
	 */
	@ConstantInterface
	interface ArenaThree
	{
		/**
		 * The path to the map-file that contains the board information for the three arena game board and the grid pane.
		 */
		@Constant
		String ARENA_THREE_FILEPATH = "src/main/resources/me/vault/game/map/Encounter_3.txt";


		/**
		 * A list of figures that resemble the enemies the user has to fight in the third arena.
		 */
		@Constant
		ArrayList<Figure> ARENA_THREE_ENEMIES = new ArrayList<>()
		{{
			this.add(new Figure(Lieutenant.getInstance()));
			this.add(new Figure(Lieutenant.getInstance()));
			this.add(new Figure(Lieutenant.getInstance()));
		}};


		/**
		 * The {@link Arena}, which represents the third playable arena of the game.
		 */
		@Constant
		Arena ARENA_THREE = new Arena(List.of(), ARENA_THREE_ENEMIES, new GameBoard(ResourceLoader.createTileArrayFromFile(ARENA_THREE_FILEPATH)));

	}


	/**
	 * This subinterface provides constants which contain information about the fourth playable arena of the game.
	 * The subinterface uses the {@link ConstantInterface} annotation which is a marker annotation for interfaces that only contain constants.
	 *
	 * @author Vincent Wolf, Lasse-Leander Hillen, Timothy Hoegen-Jupp, Alexander Goethel
	 * @version 5.0.0
	 * @since 30.05.2024
	 */
	@ConstantInterface
	interface ArenaFour
	{
		/**
		 * The path to the map-file that contains the board information for the fourth arena game board and the grid pane.
		 */
		@Constant
		String ARENA_FOUR_FILEPATH = "src/main/resources/me/vault/game/map/Encounter_4.txt";


		/**
		 * A list of figures that resemble the enemies the user has to fourth in the second arena.
		 */
		@Constant
		ArrayList<Figure> ARENA_FOUR_ENEMIES = new ArrayList<>()
		{{
			this.add(new Figure(Recruit.getInstance()));
			this.add(new Figure(Recruit.getInstance()));
			this.add(new Figure(Recruit.getInstance()));
			this.add(new Figure(Recruit.getInstance()));
		}};


		/**
		 * The {@link Arena}, which represents the fourth playable arena of the game.
		 */
		@Constant
		Arena ARENA_FOUR = new Arena(List.of(), ARENA_FOUR_ENEMIES, new GameBoard(ResourceLoader.createTileArrayFromFile(ARENA_FOUR_FILEPATH)));

	}

}
