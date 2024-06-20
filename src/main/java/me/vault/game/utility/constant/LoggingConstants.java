package me.vault.game.utility.constant;


import me.vault.game.utility.logging.ConsoleColor;

import java.util.Arrays;


/**
 * This interface is a collection of constants that are used throughout various logging messages.
 * <br>
 * There are several sub-interfaces in this class to organize the logging messages based on their category.
 *
 * @author Vincent Wolf
 * @version 1.0.0
 * @see ConstantInterface
 * @since 06.06.2024
 */
@ConstantInterface
public interface LoggingConstants
{

	String DIVIDER = "------------------------------------------------------------";


	String SHOWING_VIEW_MSG = "Showing {0} view.";


	String PROGRAM_START = "Program started - arguments: {0}";


	String EXECUTION_NOT_POSSIBLE_ANYMORE =
		"Exiting the program because a meaningful execution isn't possible anymore.";


	String STATIC_INITIALIZER_ENTERED = "The static initializer of {0} was entered.";


	String STATIC_INITIALIZER_LEFT = "The static initializer of {0} was left.";


	String INITIALIZER_ENTERED = "The initializer of {0} was entered.";


	String INITIALIZER_LEFT = "The initializer of {0} was left.";


	String CONSTRUCTOR_ENTERED = "The constructor of {0} was entered.";


	String CONSTRUCTOR_LEFT = "The constructor of {0} was left.";


	String METHOD_ENTERED = "The method {0} was entered.";


	String METHOD_LEFT = "The method {0} was left.";


	String LEVEL_SET = "currentLevel was set to: {0}";


	String RETURNING_TRUE = "Returning true.";


	String RETURNING_FALSE = "Returning false.";


	String UPGRADE_COST_SET = "currentUpgradeCost was set to: {0}";


	String UPGRADE_COST = "Upgrade costs: {0}";


	String SPRITE_PROPERTY_SET = "spriteProperty was set to: {0}";


	String NAME_PROPERTY_SET = "namePropertyProperty was set to: {0}";


	String INSUFFICIENT_CURRENCY_AMOUNT = "Not enough {0} to perform the requested upgrade. Cost: {1} {0}";


	String CLASS_INITIALISED = "{0} initialised.";


	String UPGRADE_DIALOG_FAIL = "Couldn't display upgrade dialog for {0}";


	interface Artifact
	{

		String ATTRIBUTE_MODIFIERS_SET = "attributeModifiers was set to: {0}";


		String NAME_MAP_SET = "Map of names was set to: {0}";


		String SPRITE_MAP_SET = "Map of sprites was set to: {0}";


		String UPGRADE_COST_MAP_SET = "Map of upgrade cost was set to: {0}";


		String MODIFIERS_MAP_SET = "Map of attribute modifiers was set to: {0}";


		String ARTIFACT_MAXED = "The artifact {0} is maxed, can't upgrade any further.";


		String ARTIFACT_IS_LOWEST = "The artifact {0} is at the lowest level.";


		String CURRENT_ARTIFACT_LEVEL = "Current artifact level: {0}";


		String UPGRADED_ARTIFACT_LEVEL = "Upgraded the artifact to the level: {0}";

	}


	interface CityBuildingController
	{

		String UPGRADING_BUILDING = "Upgrading {0}: {1} -> {2}";

	}


	interface Currency
	{

		String FACTORED_TRANSACTION = "Factored transaction - transaction amounts: {0}";


		String NEW_CURRENCY_VALUES = "New currency values: {0}";

	}


	interface JvmArgument
	{

		String HEADER = ConsoleColor.MAGENTA_UNDERLINED + "JVM Arguments" + ConsoleColor.RESET;


		String NO_LOG_DEPTH_ARGUMENT =
			"No argument found after -log_depth, the default depth " + "value {0} is now applied.";


		String INVALID_LOG_DEPTH_ARGUMENT =
			"Invalid argument {0} found after -log_depth, the default depth value {1} is now " + "applied.";


		String LOG_DEPTH_SET = "The log depth has been set to {0}";


		String ARGUMENT_AT_INDEX = "Argument at index {0}: {1}";


		String INVALID_ARGUMENT = "Invalid argument {0} found at position {1}.";


		String VALID_ARGUMENT_LIST =
			"Valid arguments are: " + Arrays.toString(me.vault.game.utility.jvm.JvmArgument.values());


		String LOG_DEPTH_STATUS = ConsoleColor.MAGENTA_BOLD + "logDepth is set to: {0}" + ConsoleColor.RESET;


		String CHEATS_STATUS = ConsoleColor.MAGENTA_BOLD + "Cheats are set to: {0}" + ConsoleColor.RESET;


		String JVM_ARGUMENT_CONSTRUCTION_ERROR =
			"The construction process of entries in the " + "JvmArgument enum is invalid. [expected = {0}" +
			" | actual = {1}]";

	}

}
