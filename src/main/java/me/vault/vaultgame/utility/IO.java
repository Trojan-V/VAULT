package me.vault.vaultgame.utility;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static me.vault.vaultgame.utility.CharacterConstants.WHITESPACE;


/**
 * All methods found in this class are related to input or output in some way.
 * Mostly, this class can be used to print data into the console window.
 *
 * @author Prof. Dr. Ing. Heiko Mosemann
 * @author Vincent Wolf
 * @see ConsoleColor
 * @since 07.05.2024
 */
public final class IO
{
	/**
	 * Prefix which gets appended when a "sender class" is supplied as second parameter to the
	 * {@link IO#print(String, Class)} method.
	 */
	private static final String CLASS_SENDER_MESSAGE_PREFIX = "From ";


	/**
	 * The date/time format. Can be used by {@link DateTimeFormatter#ofPattern(String)} to format the date and time
	 * accordingly.
	 */
	private static final String DATE_TIME_FORMAT = "dd-MM-yyyy HH:mm:ss:SSS";


	/**
	 * String which is being appended if {@link IO#shouldPrefixWithTimestamp} is enabled to display that the timestamp
	 * ends and the message starts.
	 */
	private static final String PROMPT = "-> ";


	/**
	 * Determines if every message that will be printed into the console with the {@link IO#print(String)} method
	 * should
	 * be prefixed with the current timestamp.
	 * <p>
	 * Pass {@code -timestamp_prefix} as JVM argument to enable the verbose mode.
	 * </p>
	 */
	private static boolean shouldPrefixWithTimestamp = false;


	/**
	 * Determines if the program should print a ton of debugging information into the console. If disabled, almost no
	 * information will be printed into the console.
	 * <p>
	 * Pass {@code -verbose} as JVM argument to enable the verbose mode.
	 * </p>
	 */
	private static boolean isVerboseMode = false;


	/**
	 * As this class is solely a collection of static methods, there is no use-case where an instantiation of this
	 * class
	 * would be beneficial, hence why a private constructor is used here to prohibit that.
	 */
	private IO () {}


	/**
	 * Convenience method to invoke {@link java.io.PrintStream#println()} easily.
	 * <p>
	 * Also provides other convenience options, such as only sending misc.messages if {@link IO#isVerboseMode} is
	 * enabled and optional timestamp prefixes in front of each message.
	 * </p>
	 *
	 * @param text The text which should be printed into the console.
	 */
	public static void print (final String text)
	{
		String textToPrint = text;
		if (! isVerboseMode)
		{
			return;
		}
		// ...
		if (shouldPrefixWithTimestamp)
		{
			textToPrint = LocalDateTime.now().format(DateTimeFormatter.ofPattern(DATE_TIME_FORMAT)) + PROMPT + text;
		}

		System.out.println(textToPrint);
	}


	/**
	 * Solely prints a console into the console.
	 *
	 * @param consoleColor The color which should be printed into the console.
	 */
	public static void print (final ConsoleColor consoleColor)
	{
		if (isVerboseMode)
		{
			System.out.print(consoleColor);
		}
	}


	/**
	 * Convenience method to print out any object's string representation directly by invoking
	 * {@link Object#toString()}
	 * on the supplied object.
	 *
	 * @param object The object which string representation should be printed out.
	 */
	public static void print (final Object object)
	{
		print(object.toString());
	}


	/**
	 * @param object The object which string representation should be printed out.
	 * @param color  The color of the font.
	 */
	public static void print (final Object object, final ConsoleColor color)
	{
		print(object.toString(), color);
	}


	/**
	 * @param object          The object which string representation should be printed out.
	 * @param color           The color of the font.
	 * @param backgroundColor The background color which is displayed behind the text.
	 */
	public static void print (final Object object, final ConsoleColor color, final ConsoleColor backgroundColor)
	{
		print(object.toString(), color, backgroundColor);
	}


	/**
	 * Uses string formatting to replace the passed object ellipse with their actual values.
	 *
	 * @param text The text which should be printed into the console.
	 * @param args The objects which will be replaced within the text.
	 */
	public static void printf (final String text, final Object... args)
	{
		String textToPrint = text;
		if (! isVerboseMode)
		{
			return;
		}

		if (shouldPrefixWithTimestamp)
		{
			textToPrint = LocalDateTime.now().format(DateTimeFormatter.ofPattern(DATE_TIME_FORMAT)) + PROMPT + text;
		}

		System.out.printf(textToPrint, args);
		System.out.println();
	}


	/**
	 * Has an extra argument to set the color of the font.
	 *
	 * @param text  The text which should be printed into the console.
	 * @param color The color in which the font should appear.
	 * @param args  The objects which will be replaced within the text.
	 */
	public static void printf (final String text, final ConsoleColor color, final Object... args)
	{
		print(color);
		printf(text, args);
		print(ConsoleColor.RESET);
	}


	/**
	 * Has an extra argument to set the color of the background.
	 *
	 * @param text            The text which should be printed into the console.
	 * @param color           The color in which the font should appear.
	 * @param backgroundColor The color which should be displayed as the background.
	 * @param args            The objects which will be replaced within the text.
	 */
	public static void printf (final String text, final ConsoleColor color, final ConsoleColor backgroundColor,
			final Object... args)
	{
		print(color);
		printf(text, backgroundColor, args);
	}


	/**
	 * Convenience method to print out any object's string representation directly by invoking
	 * {@link Object#toString()}
	 * on the supplied object.
	 *
	 * @param object The object which string representation should be printed out.
	 * @param color  The color in which the font should appear.
	 * @param args   The objects which will be replaced within the text.
	 */
	public static void printf (final Object object, final ConsoleColor color, final Object... args)
	{
		printf(object.toString(), color, args);
	}


	/**
	 * Convenience method to print out any object's string representation directly by invoking
	 * {@link Object#toString()}
	 * on the supplied object.
	 *
	 * @param object          The object which string representation should be printed out.
	 * @param color           The color in which the font should appear.
	 * @param backgroundColor The color which should be displayed as the background.
	 * @param args            The objects which will be replaced within the text.
	 */
	public static void printf (final Object object, final ConsoleColor color, final ConsoleColor backgroundColor,
			final Object... args)
	{
		printf(object.toString(), color, backgroundColor, args);
	}


	/**
	 * Additionally provides a parameter to set the color in which the text should appear in the console.
	 * <p>
	 * After the color and text have been printed out, the reset color code is being printed out to reset the color to
	 * default for the next time the print method gets invoked.
	 * </p>
	 * <p>
	 * Check {@link IO#print(String)} for more information.
	 *
	 * @param text  The text which should be printed into the console.
	 * @param color The color in which the text should appear in the console.
	 */
	public static void print (final String text, final ConsoleColor color)
	{
		print(color);
		print(text);
		print(ConsoleColor.RESET);
	}


	/**
	 * Additionally provides a parameter to set the color in which the background should be displayed. Check
	 * {@link IO#print(String, ConsoleColor)} for more information.
	 *
	 * @param text            The text which should be printed into the console.
	 * @param color           The color in which the text should appear in the console.
	 * @param backgroundColor The background color which should be displayed behind the text.
	 */
	public static void print (final String text, final ConsoleColor color, final ConsoleColor backgroundColor)
	{
		print(color);
		print(text, backgroundColor);
	}


	/**
	 * Prints the text into the console but adds the name of the class who invoked this method.
	 * <p>
	 * Especially useful for debugging if it's unsure where certain misc.messages are being sent from.
	 * </p>
	 *
	 * @param text        The text which should be printed into the console.
	 * @param senderClazz The class which invoked this method.
	 */
	public static void print (final String text, final Class<?> senderClazz)
	{
		print(CLASS_SENDER_MESSAGE_PREFIX + senderClazz.getSimpleName() + WHITESPACE + PROMPT + WHITESPACE + text);
	}


	/**
	 * Check {@link IO#print(String, Class)} and {@link IO#print(String, ConsoleColor)} for more information.
	 *
	 * @param text        The text which should be printed into the console.
	 * @param color       The color in which the text should appear in the console.
	 * @param senderClazz The class which invoked this method.
	 */
	public static void print (final String text, final ConsoleColor color, final Class<?> senderClazz)
	{
		print(color);
		print(text, senderClazz);
	}


	/**
	 * Check {@link IO#print(String, Class)} and {@link IO#print(String, ConsoleColor, ConsoleColor)} for more
	 * information.
	 *
	 * @param text            The text which should be printed into the console.
	 * @param color           The color in which the text should appear in the console.
	 * @param backgroundColor The background color which should be displayed behind the text.
	 * @param senderClazz     The class which invoked this method.
	 */
	public static void print (final String text, final ConsoleColor color, final ConsoleColor backgroundColor,
			final Class<?> senderClazz)
	{
		print(color);
		print(backgroundColor);
		print(text, senderClazz);
	}


	/**
	 * Reprint supplies a method to overwrite a message which has been sent in the line the cursor is currently at.
	 * <p>
	 * That works by printing the carriage return character '\r' before the text, as carriage return sets the cursor
	 * back at the beginning of the current line without swapping to a new line.
	 * </p>
	 *
	 * @param text The text which should be printed into the console.
	 */
	public static void reprint (final String text)
	{
		System.out.print("\r" + text);
		System.out.flush();
	}


	/**
	 * Additionally provides a parameter to set the color in which the text should appear in the console.
	 *
	 * @param text  The text which should be printed into the console.
	 * @param color The color in which the text should appear in the console.
	 */
	public static void reprint (final String text, final ConsoleColor color)
	{
		print(color);
		reprint(text);
		print(ConsoleColor.RESET);
	}


	/**
	 * Additionally provides a parameter to set the color in which the background should be displayed.
	 *
	 * @param text            The text which should be printed into the console.
	 * @param color           The color in which the text should appear in the console.
	 * @param backgroundColor The background color which should be displayed behind the text.
	 */
	public static void reprint (final String text, final ConsoleColor color, final ConsoleColor backgroundColor)
	{
		print(backgroundColor);
		reprint(text, color);
	}


	/**
	 * Reprints the supplied text into the console but adds the name of the class who invoked this method.
	 * Additionally,
	 * it provides an option to set the color of the font.
	 *
	 * @param text        The text which should be printed into the console.
	 * @param color       The color in which the text should appear in the console.
	 * @param senderClazz The class which invoked this method.
	 */
	public static void reprint (final String text, final ConsoleColor color, final Class<?> senderClazz)
	{
		final String textToPrint =
				CLASS_SENDER_MESSAGE_PREFIX + senderClazz.getSimpleName() + WHITESPACE + PROMPT + WHITESPACE + text;
		reprint(textToPrint, color);
	}


	/**
	 * Reprints the supplied text into the console but adds the name of the class who invoked this method.
	 * Additionally,
	 * it provides an option to set the color of the font as well as the background.
	 *
	 * @param text            The text which should be printed into the console.
	 * @param color           The color in which the text should appear in the console.
	 * @param backgroundColor The background color which should be displayed behind the text.
	 * @param senderClazz     The class which invoked this method.
	 */
	public static void reprint (final String text, final ConsoleColor color, final ConsoleColor backgroundColor,
			final Class<?> senderClazz)
	{
		print(backgroundColor);
		reprint(text, color, senderClazz);
	}


	/**
	 * @return True if verboseMode is enabled, otherwise false.
	 */
	public static boolean isVerboseMode ()
	{
		return isVerboseMode;
	}


	/**
	 * Setter method for the {@link IO#isVerboseMode} configuration option. This setter is only invoked if the
	 * {@code -verbose} JVM argument is supplied to the program on startup.
	 *
	 * @param isVerboseMode If false, no message will be sent by {@link IO#print(String)}, otherwise the message
	 *                      will be
	 *                      sent.
	 */
	public static void setVerboseMode (final boolean isVerboseMode)
	{
		IO.isVerboseMode = isVerboseMode;
	}


	/**
	 * @return True if shouldPrefixWithTimestamp is enabled, otherwise false.
	 */
	public static boolean getShouldPrefixWithTimestamp ()
	{
		return shouldPrefixWithTimestamp;
	}


	/**
	 * Setter method for the {@link IO#shouldPrefixWithTimestamp} configuration option. This setter is only invoked if
	 * the {@code -timestamp_prefix} JVM argument is supplied to the program on startup.
	 *
	 * @param shouldPrefixWithTimestamp If true, every message sent by {@link IO#print(String)} is prefixed with a
	 *                                  timestamp.
	 */
	public static void setShouldPrefixWithTimestamp (final boolean shouldPrefixWithTimestamp)
	{
		IO.shouldPrefixWithTimestamp = shouldPrefixWithTimestamp;
	}


	/**
	 * ConsoleColor is an enum that stores strings which can be printed into the console to display different colors.
	 * <br>
	 * These color codes are ANSI codes that can be used to display colors in the console window.
	 * <u>Example Usage</u>
	 * {@code System.out.print(ConsoleColor.RED);}
	 * <br>
	 * {@code System.out.print(ConsoleColor.BLACK_BACKGROUND);}
	 * <br>
	 * {@code System.out.println("Hello World!");}
	 * <br>
	 * {@code System.out.print(ConsoleColor.RESET);}
	 *
	 * @author Prof. Dr. Ing. Heiko Mosemann
	 * @author Vincent Wolf (added Javadoc)
	 */
	public enum ConsoleColor
	{
		// issue commit #3
		RESET("\033[0m"),

		BLACK("\033[0;30m"),
		RED("\033[0;31m"),
		GREEN("\033[0;32m"),
		YELLOW("\033[0;33m"),
		BLUE("\033[0;34m"),
		MAGENTA("\033[0;35m"),
		CYAN("\033[0;36m"),
		WHITE("\033[0;37m"),

		BLACK_BOLD("\033[1;30m"),
		RED_BOLD("\033[1;31m"),
		GREEN_BOLD("\033[1;32m"),
		YELLOW_BOLD("\033[1;33m"),
		BLUE_BOLD("\033[1;34m"),
		MAGENTA_BOLD("\033[1;35m"),
		CYAN_BOLD("\033[1;36m"),
		WHITE_BOLD("\033[1;37m"),

		BLACK_UNDERLINED("\033[4;30m"),
		RED_UNDERLINED("\033[4;31m"),
		GREEN_UNDERLINED("\033[4;32m"),
		YELLOW_UNDERLINED("\033[4;33m"),
		BLUE_UNDERLINED("\033[4;34m"),
		MAGENTA_UNDERLINED("\033[4;35m"),
		CYAN_UNDERLINED("\033[4;36m"),
		WHITE_UNDERLINED("\033[4;37m"),

		BLACK_BACKGROUND("\033[40m"),
		RED_BACKGROUND("\033[41m"),
		GREEN_BACKGROUND("\033[42m"),
		YELLOW_BACKGROUND("\033[43m"),
		BLUE_BACKGROUND("\033[44m"),
		MAGENTA_BACKGROUND("\033[45m"),
		CYAN_BACKGROUND("\033[46m"),
		WHITE_BACKGROUND("\033[47m"),

		BLACK_BRIGHT("\033[0;90m"),
		RED_BRIGHT("\033[0;91m"),
		GREEN_BRIGHT("\033[0;92m"),
		YELLOW_BRIGHT("\033[0;93m"),
		BLUE_BRIGHT("\033[0;94m"),
		MAGENTA_BRIGHT("\033[0;95m"),
		CYAN_BRIGHT("\033[0;96m"),
		WHITE_BRIGHT("\033[0;97m"),

		BLACK_BOLD_BRIGHT("\033[1;90m"),
		RED_BOLD_BRIGHT("\033[1;91m"),
		GREEN_BOLD_BRIGHT("\033[1;92m"),
		YELLOW_BOLD_BRIGHT("\033[1;93m"),
		BLUE_BOLD_BRIGHT("\033[1;94m"),
		MAGENTA_BOLD_BRIGHT("\033[1;95m"),
		CYAN_BOLD_BRIGHT("\033[1;96m"),
		WHITE_BOLD_BRIGHT("\033[1;97m"),

		BLACK_BACKGROUND_BRIGHT("\033[0;100m"),
		RED_BACKGROUND_BRIGHT("\033[0;101m"),
		GREEN_BACKGROUND_BRIGHT("\033[0;102m"),
		YELLOW_BACKGROUND_BRIGHT("\033[0;103m"),
		BLUE_BACKGROUND_BRIGHT("\033[0;104m"),
		MAGENTA_BACKGROUND_BRIGHT("\033[0;105m"),
		CYAN_BACKGROUND_BRIGHT("\033[0;106m"),
		WHITE_BACKGROUND_BRIGHT("\033[0;107m");


		/**
		 * The value of the console color. This value gets assigned as soon as an enum entry has been called, as the
		 * constructor is invoked automatically as soon as someone uses an entry from the enum.
		 */
		private final String code;


		/**
		 * Constructs an instance of the ConsoleColor enum entry.
		 *
		 * @param code The console color ANSI string which each enum entry holds as it's first parameter.
		 */
		ConsoleColor (final String code)
		{
			this.code = code;
		}


		/**
		 * The code returned here has to be printed into the console to change the color displayed in the console.
		 *
		 * @return The console color as ANSI string.
		 */
		@Override
		public String toString ()
		{
			return this.code;
		}
	}
}


