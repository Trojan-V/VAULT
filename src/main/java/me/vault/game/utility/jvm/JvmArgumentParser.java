package me.vault.game.utility.jvm;


import me.vault.game.Cache;
import me.vault.game.model.currency.Currency;
import me.vault.game.utility.logging.ILogger;
import me.vault.game.utility.logging.ILogger.Level;
import me.vault.game.utility.logging.Logger;

import java.text.MessageFormat;
import java.util.Locale;

import static me.vault.game.utility.constant.CharacterConstants.DASH;
import static me.vault.game.utility.constant.LoggingConstants.DIVIDER;
import static me.vault.game.utility.constant.LoggingConstants.JvmArgument.*;
import static me.vault.game.utility.logging.ILogger.Level.*;


/**
 * This class is used to apply the JVM arguments which may be passed into the program on startup.
 *
 * @author Vincent Wolf
 * @see JvmArgument
 * @since 07.05.2024
 */
public final class JvmArgumentParser
{

	/**
	 * The {@link Logger} object for this class used for writing to the console.
	 */
	private static final ILogger LOGGER = new Logger(JvmArgumentParser.class.getSimpleName());


	/**
	 * This constant provides the numeral that is required to remove the leading dash, which is the first character
	 * of the JVM argument when it's passed into the console.
	 * To remove the leading dash, as the internal data structure doesn't contain this dash, the substring()
	 * operation has to be called on the provided string.
	 * This constant should be passed into the substring() operation as the index to get rid of the leading dash.
	 */
	private static final int REMOVE_LEADING_DASH_SUBSTRING_INDEX = 1;


	/**
	 * This constant should be added to the {@link JvmArgumentParser#currentArgumentIndex} to access the next argument.
	 * <br>
	 * It's used to parse parameters of arguments, for instance to parse {@link JvmArgument#LOG_DEPTH}, as this JVM
	 * argument requires a parameter.
	 * After the next argument was accessed, it's important to increment the
	 * {@link JvmArgumentParser#currentArgumentIndex} by one to ensure the parameter of the parsed argument is not
	 * attempted to be parsed as the next argument.
	 */
	private static final int NEXT_ARGUMENT_ADDITION_INDEX = 1;


	/**
	 * This constant provides the number of currencies that are rewarded instantly to the player if the JVM argument
	 * {@link JvmArgument#CHEATS} is provided.
	 */
	private static final int CHEAT_CURRENCY_STARTING_AMOUNT = 100000;


	/**
	 * The index of the currently parsed argument.
	 */
	private static int currentArgumentIndex = 0;


	/**
	 * As this class is solely a collection of static methods, there is no use-case where an instantiation of this
	 * class would be beneficial, hence
	 * why a private constructor is used here to prohibit that.
	 */
	private JvmArgumentParser () {}


	/**
	 * This wrapper method attempts to run the {@link JvmArgumentParser#applyJvmArguments(String[])} method. If an
	 * exception is thrown, this method catches the exception and prints information about the exception into the
	 * console.
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
			LOGGER.log(WARNING, MessageFormat.format(INVALID_ARGUMENT, args[currentArgumentIndex],
				currentArgumentIndex));
			LOGGER.log(NORMAL, MessageFormat.format(VALID_ARGUMENT_LIST, (Object[]) JvmArgument.values()));
		}
		finally
		{
			printJvmArgumentStatus();
		}
	}


	/**
	 * Iterates through all JVM arguments supplied to the program, and if a valid argument is found, the proper
	 * actions are executed, such as enabling cheats or setting the log depth.
	 *
	 * @param args The JVM arguments passed into the program at startup. These have to be acquired through the main
	 *             method of the program.
	 */
	private static void applyJvmArguments (final String[] args)
	{
		for (; currentArgumentIndex < args.length; currentArgumentIndex++)
		{
			String currentArgument = args[currentArgumentIndex];

			// Remove the leading dash if it's present for the current argument to proceed evaluating the argument.
			if (currentArgument.startsWith(String.valueOf(DASH)))
			{
				currentArgument = currentArgument.substring(REMOVE_LEADING_DASH_SUBSTRING_INDEX);
			}

			if (!checkIsValidJvmArgument(currentArgument))
			{
				LOGGER.log(WARNING, MessageFormat.format(INVALID_ARGUMENT, args[currentArgumentIndex],
					currentArgumentIndex));
				continue;
			}

			final JvmArgument jvmArgument = JvmArgument.valueOf(currentArgument.toUpperCase(Locale.GERMANY));

			LOGGER.log(DEBUG, MessageFormat.format(ARGUMENT_AT_INDEX, currentArgumentIndex,
				args[currentArgumentIndex]));

			// As there's only one JVM argument at the moment, an if-statement is used here.
			// Should be replaced by a switch-statement if there are more arguments in the future.
			if (jvmArgument == JvmArgument.LOG_DEPTH)
			{
				handleLogDepthArgument(args);
			}
			else if (jvmArgument == JvmArgument.CHEATS)
			{
				handleCheatsArgument();
			}
		}
	}


	/**
	 * Checks if the supplied JVM argument string is a valid JVM argument.
	 *
	 * @param argumentToValidate The JVM argument that gets checked if it's valid or not.
	 *
	 * @return True if the supplied argument is valid, otherwise false.
	 */
	private static boolean checkIsValidJvmArgument (final String argumentToValidate)
	{
		for (final JvmArgument arg : JvmArgument.values())
		{
			if (argumentToValidate.equals(arg.toString().substring(REMOVE_LEADING_DASH_SUBSTRING_INDEX)))
			{
				return true;
			}
		}
		return false;
	}


	/**
	 * Executes the logic that is required to execute if the {@link JvmArgument#LOG_DEPTH} argument was supplied.
	 *
	 * @param args The JVM arguments passed into the program at startup. These have to be acquired through the main
	 *             method of the program.
	 */
	private static void handleLogDepthArgument (final String[] args)
	{
		if (args.length <= 1)
		{
			LOGGER.log(DEBUG, MessageFormat.format(NO_LOG_DEPTH_ARGUMENT, Logger.getDepth().name()));
			return;
		}

		final Level[] logLevels = values();
		for (final Level level : logLevels)
		{
			if (!checkIsValidLogDepthParameter(args, level))
			{
				LOGGER.log(DEBUG, MessageFormat.format(INVALID_LOG_DEPTH_ARGUMENT, args[currentArgumentIndex +
				                                                                        NEXT_ARGUMENT_ADDITION_INDEX], Logger.getDepth()
					.name()));
				currentArgumentIndex++;
				return;
			}
			else
			{
				break;
			}
		}

		final String desiredLogDepth = args[currentArgumentIndex + NEXT_ARGUMENT_ADDITION_INDEX];
		Logger.setDepth(valueOf(desiredLogDepth.toUpperCase(Locale.GERMANY)));
		LOGGER.log(DEBUG, MessageFormat.format(LOG_DEPTH_SET, Logger.getDepth().name()));
		currentArgumentIndex++;
	}


	/**
	 * Executes the logic that is required to execute if the {@link JvmArgument#CHEATS} argument was supplied.
	 */
	private static void handleCheatsArgument ()
	{
		// Currencies are set to specified value
		for (final Currency currency : Currency.values())
		{
			currency.setAmount(CHEAT_CURRENCY_STARTING_AMOUNT);
		}
		Cache.setAreCheatsEnabled(true);
	}


	/**
	 * Checks if the supplied parameter for the {@link JvmArgument#LOG_DEPTH} argument is a valid parameter.
	 *
	 * @param args The JVM arguments passed into the program at startup. These have to be acquired through the main
	 *             method of the program.
	 *
	 * @return True if the supplied parameter is valid, otherwise false.
	 */
	private static boolean checkIsValidLogDepthParameter (final String[] args, final Level level)
	{
		return args[currentArgumentIndex + NEXT_ARGUMENT_ADDITION_INDEX].equalsIgnoreCase(level.name());
	}


	/**
	 * Prints the values of the JVM arguments in the console window.
	 */
	private static void printJvmArgumentStatus ()
	{
		LOGGER.log(NORMAL, DIVIDER);
		LOGGER.log(NORMAL, HEADER);
		LOGGER.log(NORMAL, MessageFormat.format(LOG_DEPTH_STATUS, Logger.getDepth().name()));
		LOGGER.log(NORMAL, MessageFormat.format(CHEATS_STATUS, Cache.getAreCheatsEnabled()));
		LOGGER.log(NORMAL, DIVIDER);
	}

}
