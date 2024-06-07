package me.vault.game.utility.logging;


/**
 * Description
 *
 * @author Vincent Wolf
 * @version 1.0.0
 * @see Logger
 * @since 30.05.2024
 */
public interface ILogger
{
	public void log (final Level level, final String message);


	public void logf (final Level level, final String pattern, final String... arguments);


	/**
	 * Enum representing logging levels with associated color codes.
	 */
	public static enum Level
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
