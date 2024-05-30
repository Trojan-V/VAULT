package me.vault.vaultgame.utility.jvm;


import me.vault.vaultgame.utility.Logger;
import me.vault.vaultgame.utility.Logger.Level;

import java.text.MessageFormat;
import java.util.Locale;

import static me.vault.vaultgame.utility.Logger.Level.NORMAL;
import static me.vault.vaultgame.utility.Logger.Level.WARNING;
import static me.vault.vaultgame.utility.jvm.JvmArgumentMessage.*;


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
	private static final Logger LOGGER = new Logger(JvmArgumentParser.class.getSimpleName());


	private static int currentArgumentPointer = 0;


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
		try
		{
			applyJvmArguments(args);
		}
		catch (final IllegalArgumentException ignored)
		{
			LOGGER.log(WARNING, MessageFormat.format(INVALID.toString(), args[currentArgumentPointer],
				currentArgumentPointer));
			LOGGER.log(NORMAL, MessageFormat.format(VALID_ARGUMENT_LIST.toString(), (Object[]) JvmArgument.values()));
		}
		finally
		{
			printJvmArgumentStatus();
		}

	}


	private static void applyJvmArguments (final String[] args)
	{
		for (; currentArgumentPointer < args.length; currentArgumentPointer++)
		{

			// Start at substring(1) to remove the leading dash.
			final JvmArgument jvmArgument = JvmArgument.valueOf(args[currentArgumentPointer].substring(1)
				.toUpperCase(Locale.GERMANY));
			switch (jvmArgument)
			{
				case LOG_DEPTH:
					handleLogDepth(args);
			}
		}
	}


	private static void handleLogDepth (final String[] args)
	{
		if (args.length <= 1)
		{
			return;
		}
		final String desiredLogDepth = args[currentArgumentPointer + 1];
		Logger.setDepth(Level.valueOf(args[currentArgumentPointer + 1]));
		currentArgumentPointer++;
	}


	/**
	 * Prints the values of the JVM arguments in the console window.
	 */
	private static void printJvmArgumentStatus ()
	{
		LOGGER.log(NORMAL, HEADER.toString());
		LOGGER.log(NORMAL, DIVIDER.toString());
		LOGGER.log(NORMAL, MessageFormat.format(LOG_DEPTH.toString(), Logger.getDepth().name()));
		LOGGER.log(NORMAL, DIVIDER.toString());
	}
}
