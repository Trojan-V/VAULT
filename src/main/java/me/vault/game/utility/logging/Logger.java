package me.vault.game.utility.logging;


import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.Instant;
import java.util.Date;
import java.util.Locale;

import static me.vault.game.utility.constant.NewLoggingConstants.*;
import static me.vault.game.utility.logging.ILogger.Level.NORMAL;


/**
 * The {@code Logger} class provides a logging utility with different levels of log messages, which are all formatted in
 * their respective way. The provided levels are {@link Level#DEBUG},{@link Level#NORMAL},{@link Level#WARNING} and
 * {@link Level#ERROR} and represent the different types of logging messages.
 *
 * @author Lasse-Leander Hillen
 * @see Level
 * @since 28.05.2024
 */
public class Logger implements ILogger
{
	/**
	 * The {@link String} pattern which is used in the {@link Logger#toString()} method and formats the logger
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


	private static final int STACKTRACE_METHOD_INDEX = 4;


	private static final String CLASS_NOT_FOUND = "Class not found";


	private static final String SIMPLE_CLASS_NAME_DELIMITER = ".";


	private static final byte SIMPLE_CLASS_NAME_REMOVE_DOT_INDEX = 1;


	/**
	 * The depth of the {@link Logger}. Represents how deep level of the {@link Logger#log(Level, String)} calls
	 * must be
	 * to be shown in the console window.
	 */
	private static Level depth = NORMAL;


	/**
	 * The name of the class, which the {@link Logger} is applied to.
	 */
	private final String className;


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
	 * Generates a timestamp for the current date and time.
	 *
	 * @return a string representation of the current timestamp
	 */
	private static String getTimestamp ()
	{
		return DATETIME_FORMAT.format(Date.from(Instant.now(Clock.systemDefaultZone())));
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


	// TODO: Make private
	public static String getMethodName ()
	{
		final StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
		return Thread.currentThread().getStackTrace()[STACKTRACE_METHOD_INDEX].getMethodName();
	}


	private static String getClassName ()
	{
		final StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
		final String className = Thread.currentThread().getStackTrace()[STACKTRACE_METHOD_INDEX].getClassName();
		return className.substring(
			className.lastIndexOf(SIMPLE_CLASS_NAME_DELIMITER) + SIMPLE_CLASS_NAME_REMOVE_DOT_INDEX);
	}


	/**
	 * Logs a message at the specified logging level.
	 *
	 * @param level   the logging level
	 * @param message the message to log
	 */
	@Override
	public void log (final Level level, final String message)
	{
		if (level.ordinal() >= depth.ordinal())
		{
			System.out.println(level.toString() + this.getPrefix() + message + COLOR_RESET);
		}
	}


	@Override
	@Override
	public void logf (final Level level, final String pattern, final String... arguments)
	{
		if (level.ordinal() >= depth.ordinal())
		{
			final String message = MessageFormat.format(pattern, (Object[]) arguments);
			System.out.println(level.toString() + this.getPrefix() + message + COLOR_RESET);
		}
	}


	private static String getMessageForProcedure (final ProcedureType procedureType, final TraverseType traverseType)
	{
		return switch (procedureType)
		{
			case METHOD -> MessageFormat.format(traverseType == TraverseType.ENTERED ? METHOD_ENTERED : METHOD_LEFT,
				getMethodName());
			case CONSTRUCTOR ->
				MessageFormat.format(traverseType == TraverseType.ENTERED ? CONSTRUCTOR_ENTERED : CONSTRUCTOR_LEFT,
					getClassName());
			case INITIALIZER ->
				MessageFormat.format(traverseType == TraverseType.ENTERED ? INITIALIZER_ENTERED : INITIALIZER_LEFT,
					getClassName());
			case STATIC_INITIALIZER -> MessageFormat.format(
				traverseType == TraverseType.ENTERED ? STATIC_INITIALIZER_ENTERED : STATIC_INITIALIZER_LEFT,
				getClassName());
		};
	}


	public void logEntered (final ProcedureType procedureType)
	{
		System.out.println(ConsoleColor.BLACK_BACKGROUND_BRIGHT.toString() + this.getPrefix() +
		                   getMessageForProcedure(procedureType, TraverseType.ENTERED) + COLOR_RESET);
	}


	public void logLeft (final ProcedureType procedureType)
	{
		System.out.println(ConsoleColor.BLACK_BACKGROUND_BRIGHT.toString() + this.getPrefix() +
		                   getMessageForProcedure(procedureType, TraverseType.LEFT) + COLOR_RESET);
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
	 * Returns a string representation of the logger including class name and logging level.
	 *
	 * @return a string representation of the logger
	 */
	@Override
	public String toString ()
	{
		return MessageFormat.format(TO_STRING_PATTERN, this.className, depth);
	}


	public enum ProcedureType
	{
		CONSTRUCTOR,
		STATIC_INITIALIZER,
		INITIALIZER,
		METHOD
	}


	private enum TraverseType
	{
		ENTERED,
		LEFT
	}
}