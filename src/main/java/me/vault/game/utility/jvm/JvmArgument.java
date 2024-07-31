package me.vault.game.utility.jvm;


import static me.vault.game.utility.interfaces.constant.CharacterConstants.DASH;


/**
 * This enum stores all JVM arguments supported by the program.
 *
 * @author Vincent Wolf
 * @see JvmArgumentParser
 * @since 07.05.2024
 */
public enum JvmArgument
{
	/**
	 * This JVM argument can be passed into the program to set the log depth the program uses. Depending on the log
	 * depth, more or less logging messages are printed into the console.
	 * <br>
	 * To pass this argument into the program, the following string is for instance a valid option: {@code -log_depth
	 * DEBUG}.
	 * To see a full list of all available log depth options, check the {@link JvmArgument} enum.
	 */
	LOG_DEPTH("log_depth"),


	/**
	 * This JVM argument can be passed into the program to enable cheats.
	 * If cheats are enabled, a huge number of currencies are granted to the player directly at the start of the game
	 * so everything can be bought immediately.
	 * <br>
	 * This is especially useful for debugging purposes.
	 * <br>
	 * To pass this argument into the program, the following string is valid: {@code -cheats}
	 */
	CHEATS("cheats");


	/**
	 * The argument as string. This is how the argument has to be passed into the program.
	 */
	private final String argument;


	/**
	 * Constructs the enum object.
	 *
	 * @param argument The message stored as first entry in each enum entry.
	 * @precondition A string that describes how the argument can be passed into the program has to be supplied as parameter.
	 * @postcondition An instance of this class was constructed.
	 */
	JvmArgument (final String argument)
	{
		// Append a dash to each JvmArgument to require the following JvmArgument format: -verbose, -max_age, etc.
		this.argument = DASH + argument;
	}


	/**
	 * @return The JVM argument in its string representation.
	 * @precondition The {@link JvmArgument#argument} is not equal to null.
	 * @postcondition The string representation of the JVM argument was returned.
	 */
	@Override
	public String toString ()
	{
		return this.argument;
	}
}