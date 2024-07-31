package me.vault.game.utility.math;


import java.util.Random;


/**
 * Utility class that provides a method to roll a dice to generate a "random" number.
 *
 * @author Vincent Wolf, Lasse-Leander Hillen, Timothy Hoegen-Jupp, Alexander Goethel
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
	 * The upper bound of a D100.
	 * As the highest possible roll of a D100 is the number twenty, the upper bound has to be set to 100.
	 */
	private static final int D100_UPPER_BOUND = 100;


	/**
	 * As this class is a singleton, no other class should be able to instantiate it.
	 * <br>
	 * To prohibit the instantiation from anywhere else but within the class, a private constructor is used.
	 *
	 * @precondition None.
	 * @postcondition An instance of this class was constructed.
	 */
	private Dice () {}


	/**
	 * The dice used here's the D100 dice.
	 * <br>
	 * Therefore, an extra method is provided here for convenience.
	 *
	 * @return An integer between one and 100.
	 *
	 * @precondition None.
	 * @postcondition An integer between {@link Dice#LOWER_BOUND} and {@link Dice#D100_UPPER_BOUND} was returned.
	 */
	public static int rollD100 ()
	{
		return roll(D100_UPPER_BOUND);
	}


	/**
	 * Rolls any dice that has a minimum roll of one.
	 * <br>
	 * The type of dice is determined by the supplied parameter.
	 * <br>
	 * For instance, if a 100 is supplied as a parameter, the roll corresponds to the lesser-known D100 dice.
	 *
	 * @param diceSize The dice type. Passing a 100 here means rolling a D100 dice, for instance.
	 *
	 * @return An integer between {@link Dice#LOWER_BOUND} and the supplied diceSize parameter.
	 *
	 * @precondition An integer that determines the size of the dice has to be supplied as a parameter. This integer shouldn't be smaller than one.
	 * @postcondition An integer between {@link Dice#LOWER_BOUND} and the supplied integer as parameter was returned.
	 */
	public static int roll (final int diceSize)
	{
		final Random random = new Random();
		return random.nextInt(LOWER_BOUND, diceSize);
	}

}
