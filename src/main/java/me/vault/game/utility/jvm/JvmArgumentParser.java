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
	private static final ILogger LOGGER = new Logger(JvmArgumentParser.class.getSimpleName());


	private static final int REMOVE_LEADING_DASH_SUBSTRING_INDEX = 1;


	private static final int NEXT_ARGUMENT_ADDITION_INDEX = 1;


	private static final int CHEAT_CURRENCY_STARTING_AMOUNT = 100000;


	private static int currentArgumentIndex = 0;


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
			LOGGER.log(WARNING, MessageFormat.format(INVALID_ARGUMENT_AT_POSITION_MSG, args[currentArgumentIndex],
				currentArgumentIndex));
			LOGGER.log(NORMAL, MessageFormat.format(VALID_ARGUMENT_LIST_MSG, (Object[]) JvmArgument.values()));
		}
		finally
		{
			printJvmArgumentStatus();
		}
	}


	private static void applyJvmArguments (final String[] args)
	{
		LOGGER.log(DEBUG, APPLY_JVM_ARGUMENTS_METHOD_ENTERED_MSG);
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
				LOGGER.log(WARNING, MessageFormat.format(INVALID_ARGUMENT_AT_POSITION_MSG, args[currentArgumentIndex],
					currentArgumentIndex));
				continue;
			}

			final JvmArgument jvmArgument = JvmArgument.valueOf(currentArgument.toUpperCase(Locale.GERMANY));

			LOGGER.log(DEBUG, MessageFormat.format(ARGUMENT_AT_INDEX_MSG, currentArgumentIndex,
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


	private static void handleLogDepthArgument (final String[] args)
	{
		LOGGER.log(DEBUG, HANDLE_LOG_DEPTH_METHOD_ENTERED_MSG);
		if (args.length <= 1)
		{
			LOGGER.log(DEBUG, MessageFormat.format(NO_LOG_DEPTH_ARGUMENT_MSG, Logger.getDepth().name()));
			return;
		}

		final Level[] logLevels = values();
		for (final Level level : logLevels)
		{
			if (!checkIsValidLogDepthArgument(args, level))
			{
				LOGGER.log(DEBUG, MessageFormat.format(INVALID_LOG_DEPTH_ARGUMENT_MSG, args[currentArgumentIndex +
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
		LOGGER.log(DEBUG, MessageFormat.format(LOG_DEPTH_HAS_BEEN_SET_TO_MSG, Logger.getDepth().name()));
		currentArgumentIndex++;
	}


	private static void handleCheatsArgument ()
	{
		// Currencies are set to specified value
		for (final Currency currency : Currency.values())
		{
			currency.setAmount(CHEAT_CURRENCY_STARTING_AMOUNT);
		}
		Cache.setAreCheatsEnabled(true);
	}


	private static boolean checkIsValidLogDepthArgument (final String[] args, final Level level)
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
		LOGGER.log(NORMAL, MessageFormat.format(LOG_DEPTH_STATUS_MSG, Logger.getDepth().name()));
		LOGGER.log(NORMAL, MessageFormat.format(CHEATS_STATUS_MSG, Cache.getAreCheatsEnabled()));
		LOGGER.log(NORMAL, DIVIDER);
	}
}
