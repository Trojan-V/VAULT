import me.vault.game.control.GameController;
import me.vault.game.model.GameDifficulty;
import me.vault.game.utility.Config;
import me.vault.game.utility.loading.ConfigLoader;


/**
 * Description
 *
 * @author Vincent Wolf
 * @version 1.0.0
 * @see
 * @since 24.06.2024
 */
public class ConfigTest
{

	public static void main (final String[] args)
	{
		ConfigLoader.getInstance();
		GameController.setDifficulty(GameDifficulty.HARD);
		Config.getInstance().updateConfigFromModels();
		ConfigLoader.getInstance().save();
	}

}
