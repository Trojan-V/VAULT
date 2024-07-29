package me.vault.game.utility.constant;


import me.vault.game.model.arena.Arena;
import me.vault.game.model.arena.GameBoard;
import me.vault.game.utility.constant.ConstantInterface.Constant;
import me.vault.game.utility.loading.ResourceLoader;

import static me.vault.game.utility.constant.EncounterConstants.ALLIES;
import static me.vault.game.utility.constant.EncounterConstants.ENCOUNTER_ONE_ENEMIES;


/**
 * This class provides constants directly related to the game.
 * <br>
 * For instance, the path to asset files such as sprites is stored in a constant here.
 *
 * @author Vincent Wolf
 * @version 1.0.0
 * @since 23.05.2024
 */
@ConstantInterface
public interface GameConstants
{
	/**
	 * The top level path to the assets directory which contains all sprites used within the game.
	 */
	@Constant
	String ASSETS_PATH = "src/main/resources/me/vault/game/assets/";

	@Constant
	String WINDOW_ICON_PATH = ASSETS_PATH + "VAULT_Logo.png";

	/**
	 * The window title which will be displayed in the top bar of the game window.
	 */
	@Constant
	String WINDOW_TITLE = "VAULT Game";

	@Constant
	String BACKGROUND_FILENAME = ASSETS_PATH + "general_background.png";

	@Constant
	String TAB_PANE_STYLE = "floating";

	@Constant
	String GAME_SAVE_FOLDER_FILE_PATH = "src/main/resources/me/vault/game/config/";

	@Constant
	String CONFIG_FILE = "config.json";

	@Constant
	String DEFAULT_CONFIG_FILE = "defaults.json";

	@Constant
	Arena ARENA = new Arena(ALLIES, ENCOUNTER_ONE_ENEMIES, new GameBoard(ResourceLoader.createGameBoardFromFile(
		"src/main/resources/me/vault/game/map/Encounter_2.txt")));

}
