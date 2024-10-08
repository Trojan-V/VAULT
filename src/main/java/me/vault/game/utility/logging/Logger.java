package me.vault.game.utility.logging;


import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.Instant;
import java.util.Date;
import java.util.Locale;

import static me.vault.game.utility.logging.ILogger.Level.NORMAL;


/**
 * The {@code Logger} class provides a logging utility with different levels of log messages, which are all formatted
 * in their respective way. The
 * provided levels are {@link Level#DEBUG},{@link Level#NORMAL},{@link Level#WARNING} and {@link Level#ERROR} and
 * represent the different types of
 * logging messages.
 *
 * @author Vincent Wolf, Lasse-Leander Hillen, Timothy Hoegen-Jupp, Alexander Goethel
 * @version 1.0.0
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
	private static final SimpleDateFormat DATETIME_FORMAT = new SimpleDateFormat("HH:mm:ss:SSS", Locale.GERMANY);


	/**
	 * The prefix for the logging message. The first parameter is the time, the second parameter is the class name
	 * and the third parameter is the name of the current method.
	 */
	private static final String LOG_MESSAGE_PREFIX = "[{0} | {1}.{2}] ";


	/**
	 * The index where the method that is currently invoked is located on the stacktrace.
	 */
	private static final int STACKTRACE_METHOD_INDEX = 4;


	/**
	 * The depth of the {@link Logger}. Represents how deep level of the {@link Logger#log(Level, String)} calls must
	 * be to be shown in the console
	 * window.
	 */
	private static Level depth = NORMAL;


	/**
	 * The name of the class, which the {@link Logger} is applied to.
	 */
	private final String className;


	/**
	 * Constructs a Logger for a specific class name with the default logging level of DEBUG.
	 *
	 * @param className the name of the class for which the logger is being created.
	 *
	 * @precondition The name of the class this logger object will correspond to has to be supplied as a parameter.
	 * @postcondition An instance of this class was constructed.
	 */
	public Logger (final String className)
	{
		this.className = className;
	}


	/**
	 * Generates a timestamp for the current date and time.
	 *
	 * @return a string representation of the current timestamp
	 *
	 * @precondition None.
	 * @postcondition The timestamp for the timezone that's configured on the local machine was returned in form of a {@link String}.
	 */
	private static String getTimestamp ()
	{
		return DATETIME_FORMAT.format(Date.from(Instant.now(Clock.systemDefaultZone())));
	}


	/**
	 * Gets the current logging level.
	 *
	 * @return the logging level
	 *
	 * @precondition None.
	 * @postcondition The configured logging depth was returned.
	 */
	public static Level getDepth ()
	{
		return depth;
	}


	/**
	 * Sets the logging depth to the supplied logging level.
	 *
	 * @param depth The new logging level.
	 *
	 * @precondition The desired logging depth has to be supplied as a parameter.
	 * @postcondition The logging depth was set to the supplied value.
	 */
	public static void setDepth (final Level depth)
	{
		Logger.depth = depth;
	}


	/**
	 * Retrieves the method name of the currently executed method.
	 *
	 * @return The method name of the currently executed method.
	 *
	 * @precondition None.
	 * @postcondition The name of the method that's currently of interest was returned.
	 */
	private static String getMethodName ()
	{
		return Thread.currentThread().getStackTrace()[STACKTRACE_METHOD_INDEX].getMethodName();
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public void log (final Level level, final String message)
	{
		if (level.ordinal() >= depth.ordinal())
		{
			System.out.println(level + this.createPrefix() + message + COLOR_RESET);
		}
	}


	/**
	 * {@inheritDoc}
	 * <br>
	 * To apply the message formatting, the {@link MessageFormat#format(String, Object...)} method is used.
	 */
	@Override
	public void logf (final Level level, final String pattern, final Object... arguments)
	{
		if (level.ordinal() >= depth.ordinal())
		{
			final String message = MessageFormat.format(pattern, arguments);
			System.out.println(level + this.createPrefix() + message + COLOR_RESET);
		}
	}


	/**
	 * Generates a prefix for log messages including timestamp and class name.
	 *
	 * @return The prefix for log messages.
	 *
	 * @precondition None.
	 * @postcondition The prefix that's used by the logger to print out the message was created and returned.
	 */
	private String createPrefix ()
	{
		return MessageFormat.format(LOG_MESSAGE_PREFIX, getTimestamp(), this.className, getMethodName());
	}


	/**
	 * Returns a string representation of the logger including class name and logging level.
	 *
	 * @return A string representation of the logger.
	 *
	 * @precondition None.
	 * @postcondition The string representation of this class was returned.
	 */
	@Override
	public String toString ()
	{
		return MessageFormat.format(TO_STRING_PATTERN, this.className, depth);
	}

}