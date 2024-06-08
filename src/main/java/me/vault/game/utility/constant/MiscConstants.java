package me.vault.game.utility.constant;


import me.vault.game.currency.CurrencyTransaction;
import me.vault.game.utility.constant.ConstantInterface.Constant;


/**
 * This class provides miscellaneous constants which do not belong to one specific topic under which they could be
 * bundled together, hence why these constants are stored in a miscellaneous constant interface.
 *
 * @author Vincent Wolf
 * @version 1.0.0
 * @since 27.05.2024
 */
@ConstantInterface
public interface MiscConstants
{
	/**
	 * This constant represents the error code which is used by {@link System#exit(int)}.
	 * <br>
	 * It means that an abnormal error occurred which leads to a state of the program where the continuation of the
	 * program's execution does not make sense anymore and therefore should be stopped.
	 *
	 * @see CurrencyTransaction#CurrencyTransaction(int, int, int, int, int)
	 */
	@Constant
	public static final int ERROR_EXIT_CODE = - 1;


	public static final int MINIMUM_LEVEL_ORDINAL = 0;


	public static final int NEXT_LEVEL_ADDITION_ORDINAL = 1;


	public static final int PREVIOUS_LEVEL_SUBTRACTION_ORDINAL = 1;


	public static final int ZERO_INDEXED_LENGTH_CORRECTION = 1;
}
