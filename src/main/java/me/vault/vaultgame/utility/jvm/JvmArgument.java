package me.vault.vaultgame.utility.jvm;


import static me.vault.vaultgame.utility.constant.CharacterConstants.DASH;


/**
 * This enum stores all JVM arguments supported by the program.
 *
 * @author Vincent Wolf
 * @see JvmArgumentMessage
 * @see JvmArgumentParser
 * @since 07.05.2024
 */
public enum JvmArgument
{
	/**
	 * Determines if the program should print a ton of debugging information into the console. If disabled, almost no
	 * information will be printed into the console.
	 * <p>
	 * Pass {@code -verbose} as JVM argument to enable the verbose mode.
	 * </p>
	 */
	VERBOSE("verbose"),


	/**
	 * Determines if every message that will be printed into the console with the
	 * {@link me.vault.vaultgame.utility.IO#print(String)} method should be prefixed with the current timestamp.
	 * <p>
	 * Pass {@code -timestamp_prefix} as JVM argument to enable the verbose mode.
	 * </p>
	 */
	TIMESTAMP_PREFIX("timestamp_prefix");


	/**
	 * The argument as string. This is how the argument has to be passed into the program.
	 */
	private final String argument;


	/**
	 * Constructs the enum object.
	 *
	 * @param argument The message stored as first entry in each enum entry.
	 */
	JvmArgument (final String argument)
	{
		// Append a dash to each JvmArgument to require the following JvmArgument format: -verbose, -max_age, -...
		this.argument = DASH + argument;
	}


	/**
	 * @return The JVM argument in its string representation.
	 */
	@Override
	public String toString ()
	{
		return this.argument;
	}
}