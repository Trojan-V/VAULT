package me.vault.vaultgame.utility.constant;


import me.vault.vaultgame.utility.annotation.ConstantInterface;
import me.vault.vaultgame.utility.annotation.ConstantInterface.Constant;


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
	public static final String ASSETS_PATH = "src/main/resources/me/vault/game/assets/";
}
