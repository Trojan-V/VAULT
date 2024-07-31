package me.vault.game.utility.interfaces.constant;


import static me.vault.game.utility.interfaces.constant.ConstantInterface.Constant;


/**
 * This class provides miscellaneous constants which don't belong to one specific topic under which they could be bundled together, hence why these
 * constants are stored in a miscellaneous constant interface.
 *
 * @author Vincent Wolf, Lasse-Leander Hillen, Timothy Hoegen-Jupp, Alexander Goethel
 * @version 1.0.0
 * @since 27.05.2024
 */
@ConstantInterface
public interface MiscConstants
{

	/**
	 * This constant represents the error code which is used by {@link System#exit(int)}.
	 * <br>
	 * It means that an abnormal error occurred which leads to a state of the program where the continuation of the program's execution doesn't make
	 * sense anymore and therefore should be stopped.
	 */
	@Constant
	int ERROR_EXIT_CODE = -1;


	/**
	 * This is the ordinal of the lowest possible level.
	 * <br>
	 * This ordinal is equal to zero because an enum is zero-indexed and the levels in the enum are sorted in the correct order, from lowest to highest.
	 */
	@Constant
	int MINIMUM_LEVEL_ORDINAL = 0;


	/**
	 * This is the ordinal that has to be added to the index of a level to get to the index of the next level.
	 */
	@Constant
	int NEXT_LEVEL_ADDITION_ORDINAL = 1;


	/**
	 * This is the ordinal that has to be subtracted from the index of a level to get to the index of the previous level.
	 */
	@Constant
	int PREVIOUS_LEVEL_SUBTRACTION_ORDINAL = 1;


	/**
	 * This ordinal has to be subtracted from the result the length() method of an enum provides to account for the fact that enums are zero-indexed.
	 * Therefore, the index of the last entry will always be one smaller than the return value of the length() method.
	 */
	@Constant
	int ZERO_INDEXED_LENGTH_CORRECTION_SUBTRACTION_ORDINAL = 1;


	/**
	 * This constant represents that a file was mismatched.
	 */
	@Constant
	long FILE_MISMATCH_INDICATOR = -1L;

	/**
	 * This string contains the ending for the format JSON.
	 */
	String JSON_FILE_ENDING = ".json";

	/**
	 * This string contains the starting phrase for the save files.
	 */
	String SAVE_NAME = "save";

	/**
	 * This string contains the date time pattern for the save files.
	 */
	String DATE_TIME_PATTERN = "yyyyMMdd_HHmmss";

	//TODO: Javadoc
	int TWO_HUNDRED = 200;

	int TEN = 10;

}
