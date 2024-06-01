package me.vault.game.utility.constant;


import me.vault.game.utility.constant.ConstantInterface.Constant;


/**
 * This interface is a collection of literals that are wrapped into constants because the code style guidelines prohibit
 * the usage of literals directly within the code.
 *
 * @author Vincent Wolf
 * @version 1.0.0
 * @since 10.05.2024
 */
@ConstantInterface
public interface CharacterConstants
{
	/**
	 * Represents the default whitespace character.
	 */
	@Constant
	public static final char WHITESPACE = ' ';


	/**
	 * Represents the line separator character for the operating system the program is executed on.
	 *
	 * @see System#lineSeparator() for more information.
	 */
	@Constant
	public static final String NEWLINE = System.lineSeparator();


	public static final String DIVIDER = "---------------------------------------------------------------------";


	/**
	 * Represents the dash character.
	 */
	@Constant
	public static final char DASH = '-';


	/**
	 * Represents the opening bracket character.
	 * <br>
	 * Here, the American English standard is used to denote the names of different bracket types.
	 */
	@Constant
	public static final char OPENING_BRACKET = '[';


	/**
	 * Represents the closing bracket character.
	 * <br>
	 * Here, the American English standard is used to denote the names of different bracket types.
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Bracket">Wikipedia &ndash; Bracket types</a>
	 */
	@Constant
	public static final char CLOSING_BRACKET = ']';


	/**
	 * Represents the opening parentheses' character.
	 * <br>
	 * Here, the American English standard is used to denote the names of different bracket types.
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Bracket">Wikipedia &ndash; Bracket types</a>
	 */
	@Constant
	public static final char OPENING_PARENTHESES = '(';


	/**
	 * Represents the closing parentheses' character.
	 * <br>
	 * Here, the American English standard is used to denote the names of different bracket types.
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Bracket">Wikipedia &ndash; Bracket types</a>
	 */
	@Constant
	public static final char CLOSING_PARENTHESES = ')';


	/**
	 * Represents the pipe character.
	 */
	@Constant
	public static final char PIPE = '|';
}
