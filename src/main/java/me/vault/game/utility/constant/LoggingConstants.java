package me.vault.game.utility.constant;


import me.vault.game.utility.annotation.ConstantInterface;
import me.vault.game.utility.logging.ConsoleColor;
import me.vault.game.utility.logging.Logger;

import java.util.Arrays;


/**
 * Description
 *
 * @author Vincent Wolf
 * @version 1.0.0
 * @see me.vault.game.controller.ArtifactController
 * @see Logger
 * @see java.text.MessageFormat#format(String, Object...)
 * @since 30.05.2024
 */
@ConstantInterface
public interface LoggingConstants
{
	public static final String DIVIDER = "------------------------------------------------------------";


	public static interface Artifact
	{
		public static final String UPGRADE_METHOD_ENTERED_MSG = "Entered the upgrade()-method for the artifact {0}.";


		public static final String CURRENT_ARTIFACT_LEVEL_MSG = "Current artifact level: {0}";


		public static final String UPGRADED_ARTIFACT_LEVEL_MSG = "Upgraded the artifact to the level: {0}";


		public static final String CHECK_IS_UPGRADABLE_METHOD_ENTERED_MSG =
			"Entered the checkIsUpgradable() method " + "for the artifact {0}.";


		public static final String ARTIFACT_IS_MIN_LEVEL_MSG =
			"The artifact with the current level {0} is already " + "at" + " the minimum level";


		public static final String ARTIFACT_IS_MAX_LEVEL_MSG =
			"The artifact with the current level {0} is already at the maximum level and cannot be upgraded any " +
			"further.";


		public static final String UPGRADE_COSTS_MSG = "Upgrade costs: {0}";


		public static final String INSUFFICIENT_CURRENCIES_MSG =
			"The available amount of {0} is insufficient to perform the requested upgrade. The cost for the upgrade " +
			"is" + " at {1} {2}.";


		public static final String CHECK_IS_UPGRADABLE_METHOD_LEFT_MSG =
			"The artifact can be upgraded to the next " + "level, leaving the checkIsUpgradable() " + "method.";


		public static final String MAX_ARTIFACT_LEVEL_NOT_SUPER_MSG =
			"The maximum artifact level is not the expected " + "level {0}, the maximum level which was returned" +
			" is {1}.";


		public static final String NEXT_ARTIFACT_LEVEL_INCORRECT_MSG =
			"The next artifact level after {0} was not the " + "expected level {1}, it was {2} instead for " +
			"some reason.";


		public static final String PREVIOUS_ARTIFACT_LEVEL_INCORRECT_MSG =
			"The previous artifact level before {0} was not the expected level {1}, it was {2} instead for some " +
			"reason.";


		public static final String GET_MAXIMUM_LEVEL_METHOD_ENTERED_MSG =
			"Entered the getMaximumArtifactLevel()" + "-method and leaving it, returning {0}.";


		public static final String GET_NEXT_HIGHER_LEVEL_METHOD_ENTERED_MSG =
			"Entered the getNextHigherLevel()-method" + " for level {0}.";


		public static final String GET_NEXT_HIGHER_LEVEL_METHOD_LEFT_MSG =
			"Leaving the getNextHigherLevel()-method," + " " + "returning {0}.";


		public static final String GET_NEXT_LOWER_LEVEL_METHOD_ENTERED_MSG =
			"Entered the getNextLowerLevel()-method" + " " + "for level {0}.";


		public static final String GET_NEXT_LOWER_LEVEL_METHOD_LEFT_MSG =
			"Leaving the getNextLowerLevel()-method, " + "returning {0}.";

	}


	public static interface Currency
	{
		public static final String EXECUTION_NOT_POSSIBLE_ANYMORE_MSG =
			"Exiting the program because a meaningful " + "execution is not possible anymore.";
	}


	public static interface JvmArgument
	{
		public static final String HEADER =
			ConsoleColor.MAGENTA_UNDERLINED.toString() + "JVM Arguments" + ConsoleColor.RESET.toString();


		public static final String APPLY_METHOD_ENTERED_MSG =
			"Entered the apply()-method which attempts to apply the " + "JVM arguments.";


		public static final String APPLY_METHOD_LEFT_MSG =
			"Left the apply()-method which attempted to apply the JVM" + " " + "arguments.";


		public static final String NO_LOG_DEPTH_ARGUMENT_MSG =
			"No argument found after -log_depth, the default depth " + "value {0} is now applied.";


		public static final String INVALID_LOG_DEPTH_ARGUMENT_MSG =
			"Invalid argument {0} found after -log_depth, the default depth value {1} is now " + "applied.";


		public static final String LOG_DEPTH_HAS_BEEN_SET_TO_MSG = "The log depth has been set to {0}";


		public static final String APPLY_JVM_ARGUMENTS_METHOD_ENTERED_MSG =
			"Entered applyJvmArguments()-method. Starting to loop through all arguments in the args[] array...";


		public static final String ARGUMENT_AT_INDEX_MSG = "Argument at index {0}: {1}";


		public static final String HANDLE_LOG_DEPTH_METHOD_ENTERED_MSG = "Entered handleLogDepth()-method.";


		public static final String INVALID_ARGUMENT_AT_POSITION_MSG = "Invalid argument {0} found at position {1}.";


		public static final String VALID_ARGUMENT_LIST_MSG =
			"Valid arguments are: " + Arrays.toString(me.vault.game.utility.jvm.JvmArgument.values());


		public static final String LOG_DEPTH_STATUS_MSG =
			ConsoleColor.MAGENTA_BOLD.toString() + "logDepth is set to: {0}" + ConsoleColor.RESET.toString();


		public static final String JVM_ARGUMENT_CONSTRUCTION_ERROR_MSG =
			"The construction process of entries in the " + "JvmArgument enum is invalid. [expected = {0}" +
			" | actual = {1}]";
	}
}
