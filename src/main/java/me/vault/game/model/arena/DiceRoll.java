package me.vault.game.model.arena;


import java.util.Random;


public class DiceRoll
{
	private static double dice;

	private static double diceRoll (double dice)
	{
		Random rand = new Random();
		dice = rand.nextInt(20);
		dice += 20;
		dice = dice * 0.05;
		return dice;
	}


	public static double getDice ()
	{
		return dice;
	}
}
