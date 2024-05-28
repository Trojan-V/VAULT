package me.vault.vaultgame.utility;


import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.Instant;
import java.util.Date;
import java.util.Locale;

import static me.vault.vaultgame.utility.constant.CharacterConstants.*;


/**
 * The {@code Logger} class provides a logging utility with different levels of log messages, which are all formatted in their respective way.
 * The provided levels are {@link Level#DEBUG},{@link Level#NORMAL},{@link Level#WARNING} and {@link Level#ERROR} and represent the different types of
 * logging messages.
 *
 * @author Lasse-Leander Hillen
 * @see Level
 * @since 28.05.2024
 */
public class Logger
{
	/** The {@link String} pattern which is used in the {@link Logger#toString()} method and formats the loggers properties. */
	private static final String TO_STRING_PATTERN = "Logger[\"{0}\" | depth = \"{1}\"]";


	/** The colorcode, which, when printed into the console, resets the applied console-colors. */
	private static final String COLOR_RESET = "\033[0m";


	/** The {@link SimpleDateFormat} which is used to represent the logging-timestamps. */
	private static final SimpleDateFormat DATETIME_FORMAT = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss:SS", Locale.GERMANY);


	/** The name of the class, which the {@link Logger} is applied to. */
	private final String className;


	/** The depth of the {@link Logger}. Represents how deep level of the {@link Logger#log(Level, String)} calls must be to be shown in the console window. */
	private Level depth;


	/**
	 * Constructs a Logger for a specific class name with the default logging level of DEBUG.
	 *
	 * @param className the name of the class for which the logger is being created
	 */
	public Logger (final String className)
	{
		this(className, Level.DEBUG);
	}


	/**
	 * Constructs a Logger for a specific class name with a specified logging level.
	 *
	 * @param className the name of the class for which the logger is being created
	 * @param depth     the logging level
	 */
	public Logger (final String className, final Level depth)
	{
		this.className = className;
		this.depth = depth;
	}


	/**
	 * Logs a message at the specified logging level.
	 *
	 * @param level   the logging level
	 * @param message the message to log
	 */
	public void log (final Level level, final String message)
	{
		if (level.ordinal() >= this.depth.ordinal())
		{
			System.out.println(level.toString() + this.getPrefix() + message + COLOR_RESET);
		}
	}


	/**
	 * Logs a message at the DEBUG level.
	 *
	 * @param message the message to log
	 */
	public void logDebug (final String message)
	{
		this.log(Level.DEBUG, message);
	}


	/**
	 * Logs a message at the NORMAL level.
	 *
	 * @param message the message to log
	 */
	public void logNormal (final String message)
	{
		this.log(Level.NORMAL, message);
	}


	/**
	 * Logs a message at the WARNING level.
	 *
	 * @param message the message to log
	 */
	public void logWarning (final String message)
	{
		this.log(Level.WARNING, message);
	}


	/**
	 * Logs a message at the ERROR level.
	 *
	 * @param message the message to log
	 */
	public void logError (final String message)
	{
		this.log(Level.ERROR, message);
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
	 * Gets the name of the class for which this logger is created.
	 *
	 * @return the class name
	 */
	private String getClassName ()
	{
		return this.className;
	}


	/**
	 * Generates a prefix for log messages including timestamp and class name.
	 *
	 * @return the prefix for log messages
	 */
	private String getPrefix ()
	{
		return OPENING_BRACKET + getTimestamp() + WHITESPACE + PIPE + WHITESPACE + this.getClassName() + CLOSING_BRACKET + WHITESPACE;
	}


	/**
	 * Gets the current logging level.
	 *
	 * @return the logging level
	 */
	public Level getDepth ()
	{
		return this.depth;
	}


	/**
	 * Sets the logging level.
	 *
	 * @param depth the new logging level
	 */
	public void setDepth (final Level depth)
	{
		this.depth = depth;
	}


	/**
	 * Returns a string representation of the logger including class name and logging level.
	 *
	 * @return a string representation of the logger
	 */
	@Override
	public String toString ()
	{
		return MessageFormat.format(TO_STRING_PATTERN, this.className, this.depth);
	}


	/**
	 * Enum representing logging levels with associated color codes.
	 */
	public enum Level
	{
		/** LOWEST: The debug logging level used to display the finest information in cyan formatting. */
		DEBUG("\033[0;36m"),

		/** NORMAL: The normal logging level used to display general information in white formatting. */
		NORMAL("\033[0m"),

		/** HIGH: The normal logging level used to display warnings and important information in yellow formatting. */
		WARNING("\033[0;33m"),

		/** HIGHEST: The error logging level used to display only error messages in red formatting. */
		ERROR("\033[0;31m");


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