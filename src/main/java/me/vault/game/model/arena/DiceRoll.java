package me.vault.game.model.arena;


import java.util.Random;


public class DiceRoll
{


	private static final int D20_UPPER_BOUND = 20;

	private static final int D20_LOWER_BOUND = 1;


	public static double D20 ()
	{
		final Random random = new Random();
		return random.nextInt(D20_LOWER_BOUND, D20_UPPER_BOUND);
	}

}
