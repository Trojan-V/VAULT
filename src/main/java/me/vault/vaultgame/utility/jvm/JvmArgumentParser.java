package me.vault.vaultgame.utility.jvm;


import me.vault.vaultgame.utility.IO;
import me.vault.vaultgame.utility.IO.ConsoleColor;

import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

// TODO: Konstanten


/**
 * This class is used to apply the JVM arguments which may be passed into the program on startup.
 * <br>
 * <u>Valid arguments are:</u>
 * <p>
 * -verbose
 * <br>
 * -timestamp_prefix
 * </p>
 *
 * @author Vincent Wolf
 * @see JvmArgument
 * @see JvmArgumentMessage
 * @since 07.05.2024
 */
public final class JvmArgumentParser
{
	private static final Logger LOGGER = Logger.getLogger(JvmArgumentParser.class.getName());


	/**
	 * As this class is solely a collection of static methods, there is no use-case where an instantiation of this
	 * class
	 * would be beneficial, hence why a private constructor is used here to prohibit that.
	 */
	private JvmArgumentParser () {}


	/**
	 * Iterates through all JVM arguments supplied to the program, and if a valid argument is found, the proper actions
	 * will be executed, such as enabling the verboseMode or adding the timestamp prefix in front of console output.
	 *
	 * @param args The JVM arguments passed into the program at startup. These have to be acquired through the main
	 *             method of the program.
	 */
	public static void apply (final String[] args)
	{
		for (int i = 0; i < args.length; i++)
		{
			try
			{
				// Start at substring(1) to remove the leading dash.
				final JvmArgument jvmArgument = JvmArgument.valueOf(args[i].substring(1).toUpperCase(Locale.GERMANY));
				switch (jvmArgument)
				{
					case VERBOSE:
						IO.setVerboseMode(true);
						break;
					case TIMESTAMP_PREFIX:
						IO.setShouldPrefixWithTimestamp(true);
						break;
				}
			}
			catch (final IllegalArgumentException ignored)
			{
				LOGGER.log(Level.WARNING, JvmArgumentMessage.INVALID.toString(), new Object[]{args[i], i});
				LOGGER.log(Level.INFO, JvmArgumentMessage.VALID_ARGUMENT_LIST.toString(), JvmArgument.values());
			}
		}

		printJvmArgumentStatus();
	}


	/**
	 * Prints the values of the JVM arguments in the console window.
	 */
	private static void printJvmArgumentStatus ()
	{
		LOGGER.log(Level.INFO, JvmArgumentMessage.HEADER.toString());
		LOGGER.log(Level.INFO, JvmArgumentMessage.DIVIDER.toString());
		LOGGER.log(Level.INFO, JvmArgumentMessage.VERBOSE.toString());


		// TODO: Replace IO.print() invocations with LOGGER
		/* System.out is used here instead of the MyIO class to ensure these messages will always get printed,
		 * even if the verboseMode is set to false.
		 */
		// IO.print(JvmArgumentMessage.HEADER, ConsoleColor.CYAN_BOLD);
		// IO.print(JvmArgumentMessage.DIVIDER, ConsoleColor.CYAN);

		IO.printf(JvmArgumentMessage.VERBOSE, ConsoleColor.CYAN, IO.isVerboseMode());
		IO.printf(JvmArgumentMessage.TIMESTAMP, ConsoleColor.CYAN, IO.getShouldPrefixWithTimestamp());

		IO.print(JvmArgumentMessage.DIVIDER, ConsoleColor.CYAN);
	}
}
