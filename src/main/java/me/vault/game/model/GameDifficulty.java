package me.vault.game.model;


public enum GameDifficulty
{
	EASY_MODE("easy", 1.0),
	NORMAL_MODE("normal", 1.5),
	HARD_MODE("hard", 2);

	private final String difficulty;

	private final double modifier;


	GameDifficulty (final String difficulty, final double modifier)
	{
		this.difficulty = difficulty;
		this.modifier = modifier;
	}


	public double getModifier ()
	{
		return this.modifier;
	}


	public String getDifficulty ()
	{
		return this.difficulty;
	}

}
