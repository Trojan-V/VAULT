package me.vault.game.model.arena;


import java.util.Random;


public class DiceRoll
{
	private static final int DICE_EYE_SUM = 20;


	private static final double FIVE_PERCENT_MULTIPLICATOR = 0.05;


	private static double dice;

	private static double diceRollD20 (double dice)
	{
		final Random random = new Random();
		dice = random.nextInt(DICE_EYE_SUM);
		dice += DICE_EYE_SUM;
		dice *= FIVE_PERCENT_MULTIPLICATOR;
		return dice;
	}


	public static double getDice ()
	{
		return dice;
	}
}
