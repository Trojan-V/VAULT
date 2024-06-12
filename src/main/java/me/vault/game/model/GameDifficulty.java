package me.vault.game.model;


public enum GameDifficulty
{
	EASY_MODE("easy", 1.0),
	NORMAL_MODE("normal", 1.5),
	HARD_MODE("hard", 2);

	private final String difficulty;

	private final double modifyer;


	GameDifficulty (final String difficulty, final double modifyer)
	{
		this.difficulty = difficulty;
		this.modifyer = modifyer;
	}


	public double getModifyer ()
	{
		return this.modifyer;
	}


	public String getDifficulty ()
	{
		return this.difficulty;
	}

}
