package me.vault.game.model.arena;


import java.util.Random;


/**
 * Utility class that provides a method to roll a dice to generate a "random" number.
 *
 * @author Vincent Wolf
 * @version 1.0.0
 * @see Random
 * @since 30.07.2024
 */
public final class Dice
{
	/**
	 * The lower bound of a usual dice.
	 * A usual dice always starts with the number one and doesn't have a zero or any negative numbers.
	 * <br>
	 * Therefore, the one can be considered as the lower bound of any dice.
	 * This doesn't take any special, unusual dices into account.
	 */
	private static final int LOWER_BOUND = 1;


	/**
	 * The upper bound of a D20. As the highest possible roll of a D20 is the number twenty, the upper bound has to be set to 20.
	 */
	private static final int D20_UPPER_BOUND = 20;


	/**
	 * As this class is a singleton, no other class should be able to instantiate it.
	 * <br>
	 * To prohibit the instantiation from anywhere else but within the class, a private constructor is used.
	 */
	private Dice () {}


	/**
	 * A very common dice is the D20 dice.
	 * <br>
	 * Therefore, an extra method is provided here for convenience.
	 *
	 * @return An integer between one and 20.
	 */
	public static int rollD20 ()
	{
		return roll(D20_UPPER_BOUND);
	}


	/**
	 * Rolls any dice that has a minimum roll of one.
	 * <br>
	 * The type of dice is determined by the supplied parameter.
	 * <br>
	 * For instance, if a 20 is supplied as a parameter, the roll corresponds to the well-known D20 dice.
	 *
	 * @param diceNumber The dice type. Passing a 20 here means rolling a D20 dice, for instance.
	 * @return An integer between {@link Dice#LOWER_BOUND} and the supplied diceNumber parameter.
	 */
	public static int roll (final int diceNumber)
	{
		final Random random = new Random();
		return random.nextInt(LOWER_BOUND, diceNumber);
	}
}
