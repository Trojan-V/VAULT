package me.vault.game.utility.jvm;


import static me.vault.game.utility.constant.CharacterConstants.DASH;


/**
 * This enum stores all JVM arguments supported by the program.
 *
 * @author Vincent Wolf
 * @see JvmArgumentParser
 * @since 07.05.2024
 */
public enum JvmArgument
{
	LOG_DEPTH("log_depth"),


	CHEATS("cheats");


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