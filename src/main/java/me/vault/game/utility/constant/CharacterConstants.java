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
	 * Represents the dash character.
	 */
	@Constant
	char DASH = '-';


	/**
	 * Represents the equals' character.
	 */
	@Constant
	char EQUALS = '=';


	/**
	 * Represents the semicolon character.
	 */
	@Constant
	char SEMICOLON = ';';


	/**
	 * Represents an empty string.
	 */
	@Constant
	String EMPTY_STRING = "";
}
