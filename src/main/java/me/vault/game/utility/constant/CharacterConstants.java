package me.vault.game.utility.constant;

import me.vault.game.utility.constant.ConstantInterface.Constant;

/**
 * This interface is a collection of literals that are wrapped into constants because the code style guidelines prohibit the usage of literals
 * directly within the code.
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
	char WHITESPACE = ' ';

	/**
	 * Represents the line separator character for the operating system the program is executed on.
	 *
	 * @see System#lineSeparator() for more information.
	 */
	@Constant
	String NEWLINE = System.lineSeparator();

	String DIVIDER = "---------------------------------------------------------------------";

	/**
	 * Represents the dash character.
	 */
	@Constant
	char DASH = '-';

	/**
	 * Represents the opening bracket character.
	 * <br>
	 * Here, the American English standard is used to denote the names of different bracket types.
	 */
	@Constant
	char OPENING_BRACKET = '[';

	/**
	 * Represents the closing bracket character.
	 * <br>
	 * Here, the American English standard is used to denote the names of different bracket types.
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Bracket">Wikipedia &ndash; Bracket types</a>
	 */
	@Constant
	char CLOSING_BRACKET = ']';

	/**
	 * Represents the opening parentheses' character.
	 * <br>
	 * Here, the American English standard is used to denote the names of different bracket types.
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Bracket">Wikipedia &ndash; Bracket types</a>
	 */
	@Constant
	char OPENING_PARENTHESES = '(';

	@Constant
	char EQUALS = '=';

	@Constant
	char SEMICOLON = ';';

	/**
	 * Represents the closing parentheses' character.
	 * <br>
	 * Here, the American English standard is used to denote the names of different bracket types.
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Bracket">Wikipedia &ndash; Bracket types</a>
	 */
	@Constant
	char CLOSING_PARENTHESES = ')';

	/**
	 * Represents the pipe character.
	 */
	@Constant
	char PIPE = '|';

	@Constant
	String EMPTY_STRING = "";

}
