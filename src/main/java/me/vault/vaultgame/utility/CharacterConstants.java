package me.vault.vaultgame.utility;


import me.vault.vaultgame.utility.ConstantInterface.Constant;


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

	/** A constant which represents the default whitespace character. */
	@Constant
	public static final char WHITESPACE = ' ';


	/** A constant which represents the dash character. */
	@Constant
	public static final char DASH = '-';
}
