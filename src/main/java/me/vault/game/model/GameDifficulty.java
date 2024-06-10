package me.vault.game.model;


public enum GameDifficulty
{
	EASY_MODE ("easy",1.0),
	NORMAL_MODE ("normal",1.5),
	HARD_MODE ("hard",2);

	private String difficulty;
	private double modifyer;

	GameDifficulty (String difficulty, double modifyer)
	{
		this.difficulty = difficulty;
		this.modifyer = modifyer;
	}

	public double getModifyer()
	{
		return this.modifyer;
	}

	public String getDifficulty()
	{
		return this.difficulty;
	}

}
