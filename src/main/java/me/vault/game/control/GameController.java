package me.vault.game.control;


import me.vault.game.model.GameDifficulty;


/**
 * Controller class to handle actions related to the game in general, such as adjusting the difficulty.
 *
 * @author Vincent Wolf, Lasse-Leander Hillen, Timothy Hoegen-Jupp, Alexander Goethel
 * @version 1.0.0
 * @see GameDifficulty
 * @since 29.07.2024
 */
public final class GameController
{

	/**
	 * The difficulty the game is set to.
	 * <br>
	 * The default value is {@link GameDifficulty#EASY}.
	 */
	private static GameDifficulty gameDifficulty = GameDifficulty.EASY;


	/**
	 * As this class solely contains static methods and therefore is a utility class,
	 * no other class should be able to instantiate it.
	 * <br>
	 * To prohibit the instantiation from anywhere else but within the class, a private constructor is used.
	 *
	 * @precondition Constructor gets called from within the class
	 * @postcondition A new instance of GameController is created.
	 */
	private GameController () {}


	/**
	 * Returns the difficulty the game is currently set to.
	 *
	 * @return The difficulty the game is currently set to.
	 *
	 * @precondition The method gets called.
	 * @postcondition The current {@link GameDifficulty} was returned.
	 */
	public static GameDifficulty getDifficulty ()
	{
		return gameDifficulty;
	}


	/**
	 * Sets the difficulty of the game to the supplied {@link GameDifficulty}.
	 *
	 * @param difficulty The {@link GameDifficulty} the game should be set to.
	 *
	 * @precondition A {@link GameDifficulty} != null is passed into the method.
	 * @postcondition The current {@link GameDifficulty} attribute within the controller was set to the passed one.
	 */
	public static void setDifficulty (final GameDifficulty difficulty)
	{
		gameDifficulty = difficulty;
	}

}
