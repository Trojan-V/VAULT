package me.vault.vaultgame.utility;


import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.Instant;
import java.util.Date;
import java.util.Locale;


/**
 * The {@code Logger} class provides a logging utility with different levels of log messages, which are all formatted in
 * their respective way. The provided levels are {@link Level#DEBUG},{@link Level#NORMAL},{@link Level#WARNING} and
 * {@link Level#ERROR} and represent the different types of logging messages.
 *
 * @author Lasse-Leander Hillen
 * @see Level
 * @since 28.05.2024
 */
public class Logger
{
	/**
	 * The {@link String} pattern which is used in the {@link Logger#toString()} method and formats the loggers
	 * properties.
	 */
	private static final String TO_STRING_PATTERN = "Logger[\"{0}\" | depth = \"{1}\"]";


	/**
	 * The color code, which, when printed into the console, resets the applied console-colors.
	 */
	private static final String COLOR_RESET = "\033[0m";


	/**
	 * The {@link SimpleDateFormat} which is used to represent the logging-timestamps.
	 */
	private static final SimpleDateFormat DATETIME_FORMAT = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss:SSS",
		Locale.GERMANY);


	private static final String LOG_MESSAGE_PREFIX = "[{0} | {1}] ";


	/**
	 * The name of the class, which the {@link Logger} is applied to.
	 */
	private final String className;


	/**
	 * The depth of the {@link Logger}. Represents how deep level of the {@link Logger#log(Level, String)} calls
	 * must be
	 * to be shown in the console window.
	 */
	private static Level depth = Level.NORMAL;


	/**
	 * Constructs a Logger for a specific class name with the default logging level of DEBUG.
	 *
	 * @param className the name of the class for which the logger is being created
	 */
	public Logger (final String className)
	{
		this.className = className;
	}


	/**
	 * Logs a message at the specified logging level.
	 *
	 * @param level   the logging level
	 * @param message the message to log
	 */
	public void log (final Level level, final String message)
	{
		if (level.ordinal() >= depth.ordinal())
		{
			System.out.println(level.toString() + this.getPrefix() + message + COLOR_RESET);
		}
	}


	/**
	 * Generates a timestamp for the current date and time.
	 *
	 * @return a string representation of the current timestamp
	 */
	private static String getTimestamp ()
	{
		return DATETIME_FORMAT.format(Date.from(Instant.now(Clock.systemDefaultZone())));
	}


	/**
	 * Generates a prefix for log messages including timestamp and class name.
	 *
	 * @return the prefix for log messages
	 */
	private String getPrefix ()
	{
		return MessageFormat.format(LOG_MESSAGE_PREFIX, getTimestamp(), this.className);
	}


	/**
	 * Gets the current logging level.
	 *
	 * @return the logging level
	 */
	public static Level getDepth ()
	{
		return depth;
	}


	/**
	 * Sets the logging level.
	 *
	 * @param depth the new logging level
	 */
	public static void setDepth (final Level depth)
	{
		Logger.depth = depth;
	}


	/**
	 * Returns a string representation of the logger including class name and logging level.
	 *
	 * @return a string representation of the logger
	 */
	@Override
	public String toString ()
	{
		return MessageFormat.format(TO_STRING_PATTERN, this.className, depth);
	}


	/**
	 * Enum representing logging levels with associated color codes.
	 */
	public enum Level
	{
		/**
		 * LOWEST: The debug logging level used to display the finest information in cyan formatting.
		 */
		DEBUG(ConsoleColor.CYAN.toString()),

		/**
		 * NORMAL: The normal logging level used to display general information in white formatting.
		 */
		NORMAL(ConsoleColor.RESET.toString()),

		/**
		 * HIGH: The normal logging level used to display warnings and important information in yellow formatting.
		 */
		WARNING(ConsoleColor.YELLOW.toString()),

		/**
		 * HIGHEST: The error logging level used to display only error messages in red formatting.
		 */
		ERROR(ConsoleColor.RED.toString());


		private final String colorCode;


		/**
		 * Constructs a logging level with the specified color code.
		 *
		 * @param colorCode the color code associated with the logging level
		 */
		Level (final String colorCode)
		{
			this.colorCode = colorCode;
		}


		/**
		 * Returns the color code as a string.
		 *
		 * @return the color code
		 */
		@Override
		public String toString ()
		{
			return this.colorCode;
		}
	}
}