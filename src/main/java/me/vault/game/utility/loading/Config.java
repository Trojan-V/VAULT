package me.vault.game.utility.loading;


import me.vault.game.model.GameDifficulty;
import me.vault.game.model.artifact.ArtifactLevel;


/**
 * Description
 *
 * @author Vincent Wolf
 * @version 1.0.0
 * @see
 * @since 24.06.2024
 */
public class Config
{
	// TODO: Wenn der "Exit" Button gedrückt wird, kommt ein Dialog, dass noch nicht gespeichert wurde und es wird
	//  gefragt, ob gespeichert werden soll.
	//  (Außerdem sollte ein Autosave implementiert werden, der alle 15 Minuten o.Ä. speichert).


	// TODO: isDefault getter and setter and attribute. Set isDefault from ConfigLoader. If isDefault == true, gray
	//  out continue button in main menu.
	private static Config instance = new Config();


	private GameDifficulty difficulty = GameDifficulty.HARD_MODE;


	private int coins = 2000;


	private ArtifactLevel healthArtifactLevel = ArtifactLevel.IMPROVED;


	private Config () {}


	public static Config getInstance ()
	{
		return instance;
	}


	public static void setInstance (final Config config)
	{
		instance = config;
	}


	public void setCoins (final int coins)
	{
		this.coins = coins;
	}


	public void setDifficulty (final GameDifficulty difficulty)
	{
		this.difficulty = difficulty;
	}


	public void setHealthArtifactLevel (final ArtifactLevel healthArtifactLevel)
	{
		this.healthArtifactLevel = healthArtifactLevel;
	}
}
