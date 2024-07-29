package me.vault.game.model;


public enum GameDifficulty
{
	EASY("easy", 1.0),
	NORMAL("normal", 1.5),
	HARD("hard", 2);

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
