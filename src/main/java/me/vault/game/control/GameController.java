package me.vault.game.control;


import me.vault.game.model.GameDifficulty;


public class GameController
{
	private static final GameController INSTANCE = new GameController();

	private GameDifficulty gameDifficulty = GameDifficulty.EASY_MODE;

	private GameController () {}

	public static GameController getInstance()
	{
		return INSTANCE;
	}

	public double getDifficultyModifyer ()
	{
		return this.gameDifficulty.getModifyer();
	}

	public void setDifficultyModifyer (final GameDifficulty difficulty)
	{
		this.gameDifficulty = difficulty;
	}
}
