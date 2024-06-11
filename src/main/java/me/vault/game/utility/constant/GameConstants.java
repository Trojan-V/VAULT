package me.vault.game.utility.constant;

import me.vault.game.utility.constant.ConstantInterface.Constant;

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

	/**
	 * The window title which will be displayed in the top bar of the game window.
	 */
	String WINDOW_TITLE = "VAULT Game";

	String GENERAL_BACKGROUND_FILENAME = "general_background.png";

	String TAB_PANE_STYLE = "floating";

	String GAME_SAVE_FOLDER_FILE_PATH = "src/main/resources/me/vault/game/save_files";

}
