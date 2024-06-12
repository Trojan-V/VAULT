package me.vault.game.utility.logging;


/**
 * ConsoleColor is an enum that stores strings which can be printed into the console to display different colors.
 * <br>
 * These color codes are ANSI codes that can be used to display colors in the console window.
 * <br>
 * <u>Example Usage</u>
 * <br>
 * {@code System.out.print(ConsoleColor.RED);}
 * <br>
 * {@code System.out.print(ConsoleColor.BLACK_BACKGROUND);}
 * <br>
 * {@code System.out.println("Hello World!");}
 * <br>
 * {@code System.out.print(ConsoleColor.RESET);}
 *
 * @author Prof. Dr. Ing. Heiko Mosemann
 * @author Vincent Wolf
 */
public enum ConsoleColor
{
	/**
	 * Represents the ANSI code for a reset text and background color.
	 * <br>
	 * Printing this character resets the printed color to the default color.
	 */
	RESET("\033[0m"),

	/**
	 * Represents the ANSI code for a black text color.
	 */
	BLACK("\033[0;30m"),


	/**
	 * Represents the ANSI code for a red text color.
	 */
	RED("\033[0;31m"),


	/**
	 * Represents the ANSI code for a green text color.
	 */
	GREEN("\033[0;32m"),


	/**
	 * Represents the ANSI code for a yellow text color.
	 */
	YELLOW("\033[0;33m"),


	/**
	 * Represents the ANSI code for a blue text color.
	 */
	BLUE("\033[0;34m"),


	/**
	 * Represents the ANSI code for a magenta text color.
	 */
	MAGENTA("\033[0;35m"),


	/**
	 * Represents the ANSI code for a cyan text color.
	 */
	CYAN("\033[0;36m"),


	/**
	 * Represents the ANSI code for a white text color.
	 */
	WHITE("\033[0;37m"),


	/**
	 * Represents the ANSI code for a black text color with bold formatting.
	 */
	BLACK_BOLD("\033[1;30m"),


	/**
	 * Represents the ANSI code for a red text color with bold formatting.
	 */
	RED_BOLD("\033[1;31m"),


	/**
	 * Represents the ANSI code for a green text color with bold formatting.
	 */
	GREEN_BOLD("\033[1;32m"),


	/**
	 * Represents the ANSI code for a yellow text color with bold formatting.
	 */
	YELLOW_BOLD("\033[1;33m"),


	/**
	 * Represents the ANSI code for a blue text color with bold formatting.
	 */
	BLUE_BOLD("\033[1;34m"),


	/**
	 * Represents the ANSI code for a magenta text color with bold formatting.
	 */
	MAGENTA_BOLD("\033[1;35m"),


	/**
	 * Represents the ANSI code for a cyan text color with bold formatting.
	 */
	CYAN_BOLD("\033[1;36m"),


	/**
	 * Represents the ANSI code for a white text color with bold formatting.
	 */
	WHITE_BOLD("\033[1;37m"),


	/**
	 * Represents the ANSI code for a black text color with underlined formatting.
	 */
	BLACK_UNDERLINED("\033[4;30m"),


	/**
	 * Represents the ANSI code for a red text color with underlined formatting.
	 */
	RED_UNDERLINED("\033[4;31m"),


	/**
	 * Represents the ANSI code for a green text color with underlined formatting.
	 */
	GREEN_UNDERLINED("\033[4;32m"),


	/**
	 * Represents the ANSI code for a yellow text color with underlined formatting.
	 */
	YELLOW_UNDERLINED("\033[4;33m"),


	/**
	 * Represents the ANSI code for a blue text color with underlined formatting.
	 */
	BLUE_UNDERLINED("\033[4;34m"),


	/**
	 * Represents the ANSI code for a magenta text color with underlined formatting.
	 */
	MAGENTA_UNDERLINED("\033[4;35m"),


	/**
	 * Represents the ANSI code for a cyan text color with underlined formatting.
	 */
	CYAN_UNDERLINED("\033[4;36m"),


	/**
	 * Represents the ANSI code for a white text color with underlined formatting.
	 */
	WHITE_UNDERLINED("\033[4;37m"),


	/**
	 * Represents the ANSI code for a black background color.
	 */
	BLACK_BACKGROUND("\033[40m"),


	/**
	 * Represents the ANSI code for a red background color.
	 */
	RED_BACKGROUND("\033[41m"),


	/**
	 * Represents the ANSI code for a green background color.
	 */
	GREEN_BACKGROUND("\033[42m"),


	/**
	 * Represents the ANSI code for a yellow background color.
	 */
	YELLOW_BACKGROUND("\033[43m"),


	/**
	 * Represents the ANSI code for a blue background color.
	 */
	BLUE_BACKGROUND("\033[44m"),


	/**
	 * Represents the ANSI code for a magenta background color.
	 */
	MAGENTA_BACKGROUND("\033[45m"),


	/**
	 * Represents the ANSI code for a cyan background color.
	 */
	CYAN_BACKGROUND("\033[46m"),


	/**
	 * Represents the ANSI code for a white background color.
	 */
	WHITE_BACKGROUND("\033[47m"),


	/**
	 * Represents the ANSI code for a black text color with bright formatting.
	 */
	BLACK_BRIGHT("\033[0;90m"),


	/**
	 * Represents the ANSI code for a red text color with bright formatting.
	 */
	RED_BRIGHT("\033[0;91m"),


	/**
	 * Represents the ANSI code for a green text color with bright formatting.
	 */
	GREEN_BRIGHT("\033[0;92m"),


	/**
	 * Represents the ANSI code for a yellow text color with bright formatting.
	 */
	YELLOW_BRIGHT("\033[0;93m"),


	/**
	 * Represents the ANSI code for a blue text color with bright formatting.
	 */
	BLUE_BRIGHT("\033[0;94m"),


	/**
	 * Represents the ANSI code for a magenta text color with bright formatting.
	 */
	MAGENTA_BRIGHT("\033[0;95m"),


	/**
	 * Represents the ANSI code for a cyan text color with bright formatting.
	 */
	CYAN_BRIGHT("\033[0;96m"),


	/**
	 * Represents the ANSI code for a white text color with bright formatting.
	 */
	WHITE_BRIGHT("\033[0;97m"),


	/**
	 * Represents the ANSI code for a black text color with bold and bright formatting.
	 */
	BLACK_BOLD_BRIGHT("\033[1;90m"),


	/**
	 * Represents the ANSI code for a red text color with bold and bright formatting.
	 */
	RED_BOLD_BRIGHT("\033[1;91m"),


	/**
	 * Represents the ANSI code for a green text color with bold and bright formatting.
	 */
	GREEN_BOLD_BRIGHT("\033[1;92m"),


	/**
	 * Represents the ANSI code for a yellow text color with bold and bright formatting.
	 */
	YELLOW_BOLD_BRIGHT("\033[1;93m"),


	/**
	 * Represents the ANSI code for a blue text color with bold and bright formatting.
	 */
	BLUE_BOLD_BRIGHT("\033[1;94m"),


	/**
	 * Represents the ANSI code for a magenta text color with bold and bright formatting.
	 */
	MAGENTA_BOLD_BRIGHT("\033[1;95m"),


	/**
	 * Represents the ANSI code for a cyan text color with bold and bright formatting.
	 */
	CYAN_BOLD_BRIGHT("\033[1;96m"),


	/**
	 * Represents the ANSI code for a white text color with bold and bright formatting.
	 */
	WHITE_BOLD_BRIGHT("\033[1;97m"),


	/**
	 * Represents the ANSI code for a black background color with bright formatting.
	 */
	BLACK_BACKGROUND_BRIGHT("\033[0;100m"),


	/**
	 * Represents the ANSI code for a black background color with bright formatting.
	 */
	RED_BACKGROUND_BRIGHT("\033[0;101m"),


	/**
	 * Represents the ANSI code for a green background color with bright formatting.
	 */
	GREEN_BACKGROUND_BRIGHT("\033[0;102m"),


	/**
	 * Represents the ANSI code for a yellow background color with bright formatting.
	 */
	YELLOW_BACKGROUND_BRIGHT("\033[0;103m"),


	/**
	 * Represents the ANSI code for a blue background color with bright formatting.
	 */
	BLUE_BACKGROUND_BRIGHT("\033[0;104m"),


	/**
	 * Represents the ANSI code for a magenta background color with bright formatting.
	 */
	MAGENTA_BACKGROUND_BRIGHT("\033[0;105m"),


	/**
	 * Represents the ANSI code for a cyan background color with bright formatting.
	 */
	CYAN_BACKGROUND_BRIGHT("\033[0;106m"),


	/**
	 * Represents the ANSI code for a white background color with bright formatting.
	 */
	WHITE_BACKGROUND_BRIGHT("\033[0;107m");

	/**
	 * The value of the console color. This value gets assigned as soon as an enum entry has been called, as the constructor is invoked automatically
	 * as soon as someone uses an entry from the enum.
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
