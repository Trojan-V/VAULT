package me.vault.game.utility.interfaces.constant;


import static me.vault.game.utility.interfaces.constant.ConstantInterface.Constant;


/**
 * This interface is a collection of literals that are wrapped into constants because the code style guidelines prohibit the usage of literals
 * directly within the code.
 *
 * @author Vincent Wolf, Lasse-Leander Hillen, Timothy Hoegen-Jupp, Alexander Goethel
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

	/**
	 * Represents the dot character.
	 */
	@Constant
	char DOT = '.';

}
