package me.vault.game.model;


import java.text.MessageFormat;


/**
 * This enum provides all different game difficulties that are available.
 *
 * @author Vincent Wolf, Lasse-Leander Hillen, Timothy Hoegen-Jupp, Alexander Goethel
 * @version 1.0.0
 * @since 30.07.2024
 */
public enum GameDifficulty
{
	/**
	 * "Easy": The first difficulty, which marks the easiest one out of all available ones.
	 */
	EASY("easy", 1.0),


	/**
	 * "Normal": The second difficulty.
	 */
	NORMAL("normal", 1.5),


	/**
	 * "Hard": The third and currently the highest available difficulty.
	 */
	HARD("hard", 2);


	/**
	 * The {@link MessageFormat} pattern, which is used, when the {@link GameDifficulty#toString()} is
	 * called.
	 */
	private static final String TO_STRING_PATTERN = "GameDifficulty'{'name=''{0}'', multiplier={1}'}'";


	/**
	 * The name of the difficulty.
	 */
	private final String name;


	/**
	 * The multiplier the difficulty adds to the calculation of the enemies statistics, for instance, regarding damage and/or health.
	 */
	private final double multiplier;


	/**
	 * Constructs an instance of this enum.
	 *
	 * @param name       The name of the difficulty.
	 * @param multiplier The multiplier added to the calculation of the enemies' statistics.
	 *
	 * @precondition The attributes for {@link GameDifficulty} are supplied.
	 * @postcondition A new instance of {@link GameDifficulty} is created with the supplied attributes.
	 */
	GameDifficulty (final String name, final double multiplier)
	{
		this.name = name;
		this.multiplier = multiplier;
	}


	/**
	 * Returns the multiplier the difficulty adds to the calculation of the enemies' statistics.
	 *
	 * @return The multiplier the difficulty adds to the calculation of the enemies' statistics.
	 *
	 * @precondition The multiplier of the {@link GameDifficulty} is at least declared.
	 * @postcondition The multiplier of the {@link GameDifficulty} is accessible for the program.
	 */
	public double getMultiplier ()
	{
		return this.multiplier;
	}


	/**
	 * {@inheritDoc}
	 */
	public String getName ()
	{
		return this.name;
	}


	/**
	 * Builds a formatted {@link String}, which represents the object, and it's current state using the
	 * {@link GameDifficulty#TO_STRING_PATTERN}.
	 *
	 * @return A {@link String} which has been formatted in the {@link GameDifficulty#TO_STRING_PATTERN}.
	 *
	 * @precondition The {@link GameDifficulty#TO_STRING_PATTERN} is {@code != null}.
	 * @postcondition The method returned a {@link String} which represents the object.
	 */
	@Override
	public String toString ()
	{
		return MessageFormat.format(TO_STRING_PATTERN, this.name, this.multiplier);
	}
}
