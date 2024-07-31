package me.vault.game.utility.interfaces.constant;


import static me.vault.game.utility.interfaces.constant.ConstantInterface.Constant;


/**
 * This class provides constants directly related to the game.
 * <br>
 * For instance, the path to asset files such as sprites is stored in a constant here.
 *
 * @author Vincent Wolf, Lasse-Leander Hillen, Timothy Hoegen-Jupp, Alexander Goethel
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
	 * The path to the icon that is used for the window of this program.
	 */
	@Constant
	String WINDOW_ICON_PATH = "src/main/resources/me/vault/game/assets/VAULT_Logo.png";

	/**
	 * The window title which will be displayed in the top bar of the game window.
	 */
	@Constant
	String WINDOW_TITLE = "VAULT Game";


	/**
	 * The style of the tab pane, used by JavaFX to set the tab pane style.
	 */
	@Constant
	String TAB_PANE_STYLE = "floating";


	/**
	 * The path to the directory where the game saves are stored.
	 */
	@Constant
	String GAME_SAVE_DIRECTORY_PATH = "src/main/resources/me/vault/game/saves/";


	/**
	 * The name and extension of the configuration file.
	 */
	@Constant
	String CONFIG_FILE = "config.json";


	/**
	 * The name and extension of the default configuration file.
	 */
	@Constant
	String DEFAULT_CONFIG_FILE = "defaults.json";


	/**
	 * The name and extension of the button long.
	 */
	@Constant
	String BUTTON_LONG_CSS_FILE = "button_long.css";

}
