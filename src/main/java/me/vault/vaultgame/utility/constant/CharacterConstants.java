package me.vault.vaultgame.utility.constant;


import me.vault.vaultgame.utility.constant.ConstantInterface.Constant;


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

	public static final char NEWLINE = '\n';
	/**
	 * Represents the dash character.
	 */
	@Constant
	public static final char DASH = '-';


	@Constant
	public static final char STARTING_BRACKET = '[';


	@Constant
	public static final char CLOSING_BRACKET = ']';


	@Constant
	public static final char PIPE = '|';
}
