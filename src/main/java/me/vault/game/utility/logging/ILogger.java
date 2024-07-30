package me.vault.game.utility.logging;


/**
 * An interface that can be implemented to create a logger.
 * <br>
 * For an implementation of this interface, check the {@link Logger} class.
 *
 * @author Vincent Wolf
 * @version 1.0.0
 * @see Logger
 * @since 30.05.2024
 */
public interface ILogger
{

	/**
	 * Logs a message at the specified logging level.
	 * <br>
	 * The message only actually gets logged into the console if the log depth of the program is deeper or at least
	 * at the same depth as the desired log level.
	 *
	 * @param level   The desired logging level.
	 * @param message The message that's about to get logged.
	 * @precondition The logging level in form of a {@link ILogger.Level} and the logging message have to be supplied as parameters.
	 * @postcondition The supplied message was logged at the specified logging level.
	 */
	void log (final Level level, final String message);


	/**
	 * Logs a message at the specified logging level.
	 * <br>
	 * This method uses message formatting to apply message patterns.
	 * <br>
	 * The message only actually gets logged into the console if the log depth of the program is deeper or at least
	 * at the same depth as the desired log level.
	 *
	 * @param level     The logging level.
	 * @param pattern   The message pattern that's about to get logged.
	 * @param arguments The arguments that are applied to the message pattern before the message is logged.
	 * @precondition The logging level in form of a {@link ILogger.Level} and the logging message pattern have to be supplied as parameters.
	 *                  Additionally, the arguments that are going to be formatted by the logging message pattern have to be supplied as parameter.
	 */
	void logf (final Level level, final String pattern, final Object... arguments);


	/**
	 * This enum represents the different available logging levels with their associated color codes.
	 */
	enum Level
	{
		/**
		 * The lowest logging level.
		 * <br>
		 * The debug logging level is used to display the finest information in cyan formatting.
		 */
		DEBUG(ConsoleColor.CYAN.toString()),

		/**
		 * The default logging level.
		 * <br>
		 * The normal logging level is used to display general information in white formatting.
		 */
		NORMAL(ConsoleColor.RESET.toString()),

		/**
		 * A higher logging level than normal, but not the highest.
		 * <br>
		 * The warning logging level is used to display warnings and important information in yellow formatting.
		 */
		WARNING(ConsoleColor.YELLOW.toString()),

		/**
		 * The highest logging level.
		 * <br>
		 * The error logging level is used to display only error messages in red formatting.
		 */
		ERROR(ConsoleColor.RED.toString());


		/**
		 * Represents the color code that is used to print a different color for different logging levels.
		 */
		private final String colorCode;


		/**
		 * Constructs a level instance with the specified color code.
		 *
		 * @param colorCode The color code associated with the logging level.
		 * @precondition A color code that represents the logging level was supplied as a parameter.
		 * @postcondition An instance of this class was constructed.
		 */
		Level (final String colorCode)
		{
			this.colorCode = colorCode;
		}


		/**
		 * The code returned here has to be printed into the console to change the color displayed in the console.
		 *
		 * @return The console color as ANSI string.
		 * @precondition The {@link ILogger.Level#colorCode} is not equal to null.
		 * @postcondition The string representation of the logging level was returned.
		 */
		@Override
		public String toString ()
		{
			return this.colorCode;
		}
	}

}
