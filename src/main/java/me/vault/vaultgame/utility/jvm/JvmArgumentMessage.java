package me.vault.vaultgame.utility.jvm;


/**
 * This enum provides a collection of messages related to the JVM argument processing.
 *
 * @author Vincent Wolf
 * @see JvmArgument
 * @see JvmArgumentParser
 * @since 07.05.2024
 */
public enum JvmArgumentMessage
{
	/**
	 * Represents the header message of the JVM arguments which are printed into the console at program launch.
	 */
	HEADER("JVM Arguments"),


	/**
	 * Divider to create a visual differentiation between different parts of the JVM argument messages.
	 */
	DIVIDER("------------------------------------------------------------"),


	/**
	 * Used by {@link JvmArgumentParser#apply(String[])} to print an error message into the console if invalid JVM
	 * arguments have been passed into the program.
	 */
	INVALID("Invalid argument {0} found at position {1}."),


	/**
	 * Message to print a list of valid JVM arguments.
	 */
	VALID_ARGUMENT_LIST("Valid arguments are: {0}, {1}"),


	/**
	 * Message which prints the status of the {@code verboseMode}. Check {@link JvmArgument#VERBOSE} for more
	 * information.
	 */
	VERBOSE("verboseMode is %s."),


	/**
	 * Message which prints the status of the {@code timestamp_prefix} option. Check
	 * {@link JvmArgument#TIMESTAMP_PREFIX} for more information.
	 */
	TIMESTAMP("timestamp_prefix is %s.");


	/**
	 * The message in its string representation.
	 */
	private final String message;


	/**
	 * Constructs an instance of the enum entry.
	 *
	 * @param message The message in its string representation.
	 */
	JvmArgumentMessage (final String message)
	{
		this.message = message;
	}


	/**
	 * @return The message in its string representation.
	 */
	@Override
	public String toString ()
	{
		return this.message;
	}
}
