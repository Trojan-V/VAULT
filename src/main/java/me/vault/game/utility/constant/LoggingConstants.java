package me.vault.game.utility.constant;


import me.vault.game.utility.logging.ConsoleColor;

import java.util.Arrays;

import static me.vault.game.utility.constant.ConstantInterface.Constant;


/**
 * This interface is a collection of constants that are used throughout various logging messages.
 * <br>
 * There are several sub-interfaces in this class to organize the logging messages based on their category.
 *
 * @author Vincent Wolf, Lasse-Leander Hillen, Timothy Hoegen-Jupp, Alexander Goethel
 * @version 1.0.0
 * @see ConstantInterface
 * @since 06.06.2024
 */
@ConstantInterface
public interface LoggingConstants
{

	/**
	 * Divider that can be printed into the console to separate different pieces of information.
	 */
	@Constant
	String DIVIDER = "------------------------------------------------------------";


	/**
	 * Message pattern to print out the view that's currently shown.
	 */
	@Constant
	String SHOWING_VIEW_PATTERN = "Showing {0} view.";


	/**
	 * Message that informs the user that the program's execution isn't possible anymore.
	 */
	@Constant
	String EXECUTION_NOT_POSSIBLE_ANYMORE = "Exiting the program because a meaningful execution isn't possible anymore.";


	/**
	 * Message pattern to print out the level that an object was set to.
	 */
	@Constant
	String LEVEL_SET_PATTERN = "currentLevel was set to: {0}";


	/**
	 * Message pattern to print out the upgrade costs that an object was set to.
	 */
	@Constant
	String UPGRADE_COST_SET_PATTERN = "currentUpgradeCost was set to: {0}";


	/**
	 * Message pattern to print out the sprite that an object was set to.
	 */
	@Constant
	String SPRITE_PROPERTY_SET_PATTERN = "spriteProperty was set to: {0}";


	/**
	 * Message pattern to print out the name that an object was set to.
	 */
	@Constant
	String NAME_PROPERTY_SET_PATTERN = "namePropertyProperty was set to: {0}";


	/**
	 * Message pattern to print out the name of a class and that it was initialized.
	 */
	@Constant
	String CLASS_INITIALIZED_PATTERN = "{0} initialized.";


	/**
	 * Message pattern to print out that something couldn't be displayed.
	 */
	@Constant
	String DISPLAY_FAILED_PATTERN = "Couldn't display: {0}";


	/**
	 * Message pattern to print out that an upgrade dialog couldn't be displayed.
	 */
	@Constant
	String UPGRADE_DIALOG_FAIL_PATTERN = "Couldn't display upgrade dialog for {0}";


	/**
	 * Message pattern to print out that something was upgraded.
	 */
	@Constant
	String UPGRADING = "Upgrading {0}: {1} -> {2}";


	/**
	 * This subinterface contains logging constants related to the {@link Artifact}.
	 *
	 * @author Vincent Wolf, Lasse-Leander Hillen, Timothy Hoegen-Jupp, Alexander Goethel
	 * @version 1.0.0
	 * @see Artifact
	 * @since 30.07.2024
	 */
	interface Artifact
	{

		/**
		 * Message pattern to print out the attribute modifiers that an object was set to.
		 */
		@Constant
		String ATTRIBUTE_MODIFIERS_SET_PATTERN = "attributeModifiers was set to: {0}";


		/**
		 * Message pattern to print out the map of names that an object was set to.
		 */
		@Constant
		String NAME_MAP_SET_PATTERN = "Map of names was set to: {0}";


		/**
		 * Message pattern to print out the map of sprites that an object was set to.
		 */
		@Constant
		String SPRITE_MAP_SET_PATTERN = "Map of sprites was set to: {0}";


		/**
		 * Message pattern to print out the map of upgrade costs that an object was set to.
		 */
		@Constant
		String UPGRADE_COST_MAP_SET_PATTERN = "Map of upgrade cost was set to: {0}";


		/**
		 * Message pattern to print out the map of modifiers that an object was set to.
		 */
		@Constant
		String MODIFIERS_MAP_SET_PATTERN = "Map of attribute modifiers was set to: {0}";


		/**
		 * Message pattern to print out that an artifact is maxed and can't be upgraded any further.
		 */
		@Constant
		String ARTIFACT_MAXED = "The artifact {0} is maxed, can't upgrade any further.";


		/**
		 * Message pattern to print out that a troop is maxed and can't be upgraded any further.
		 */
		@Constant
		String TROOP_MAXED = "The troop {0} is maxed, can't upgrade any further.";


		/**
		 * Message pattern to print out that an energy ability is maxed and can't be upgraded any further.
		 */
		@Constant
		String ENERGY_ABILITY_MAXED = "The energy {0} is maxed, can't upgrade any further.";


		/**
		 * Message pattern to print out that an artifact is at the lowest possible level.
		 */
		@Constant
		String ARTIFACT_IS_LOWEST = "The artifact {0} is at the lowest level.";


		/**
		 * Message pattern to print out that a troop is at the lowest possible level.
		 */
		@Constant
		String TROOP_IS_LOWEST = "The troop {0} is at the lowest level.";


		/**
		 * Message pattern to print out that an energy ability is at the lowest possible level.
		 */
		@Constant
		String ENERGY_IS_LOWEST = "The energy {0} is at the lowest level.";

	}


	/**
	 * This subinterface contains logging constants related to {@link Currency}.
	 *
	 * @author Vincent Wolf, Lasse-Leander Hillen, Timothy Hoegen-Jupp, Alexander Goethel
	 * @version 1.0.0
	 * @see Artifact
	 * @since 30.07.2024
	 */
	interface Currency
	{

		/**
		 * Message pattern to print out that a transaction was factored.
		 */
		@Constant
		String FACTORED_TRANSACTION = "Factored transaction - transaction amounts: {0}";


		/**
		 * Message pattern to print out that the currency values have been set to new ones.
		 */
		@Constant
		String NEW_CURRENCY_VALUES = "New currency values: {0}";

	}


	/**
	 * This subinterface contains logging constants related to the {@link JvmArgument}s.
	 *
	 * @author Vincent Wolf, Lasse-Leander Hillen, Timothy Hoegen-Jupp, Alexander Goethel
	 * @version 1.0.0
	 * @see Artifact
	 * @since 30.07.2024
	 */
	interface JvmArgument
	{

		/**
		 * The header message that introduces the console output of the JVM arguments.
		 */
		@Constant
		String HEADER = ConsoleColor.MAGENTA_UNDERLINED + "JVM Arguments" + ConsoleColor.RESET;


		/**
		 * Message pattern to print out that no argument was supplied after the {@link me.vault.game.utility.jvm.JvmArgument#LOG_DEPTH} argument.
		 */
		@Constant
		String NO_LOG_DEPTH_ARGUMENT = "No argument found after -log_depth, the default depth " + "value {0} is now applied.";


		/**
		 * Message pattern to print out that an invalid argument was supplied after the {@link me.vault.game.utility.jvm.JvmArgument#LOG_DEPTH} argument.
		 */
		@Constant
		String INVALID_LOG_DEPTH_ARGUMENT = "Invalid argument {0} found after -log_depth, the default depth value {1} is now " + "applied.";


		/**
		 * Message pattern to print out that the {@link me.vault.game.utility.jvm.JvmArgument#LOG_DEPTH} was set.
		 */
		@Constant
		String LOG_DEPTH_SET = "The log depth has been set to {0}";


		/**
		 * Message pattern to print out the argument at an index.
		 */
		@Constant
		String ARGUMENT_AT_INDEX = "Argument at index {0}: {1}";

		/**
		 * Message pattern to print out that an argument is invalid.
		 */
		@Constant
		String INVALID_ARGUMENT = "Invalid argument {0} found at position {1}.";


		/**
		 * Message to print out all arguments that are valid.
		 */
		@Constant
		String VALID_ARGUMENT_LIST = "Valid arguments are: " + Arrays.toString(me.vault.game.utility.jvm.JvmArgument.values());

		/**
		 * Message pattern to print out the log_depth status.
		 */
		@Constant
		String LOG_DEPTH_STATUS = ConsoleColor.MAGENTA_BOLD + "logDepth is set to: {0}" + ConsoleColor.RESET;

		/**
		 * Message pattern to print out the cheat status.
		 */
		@Constant
		String CHEATS_STATUS = ConsoleColor.MAGENTA_BOLD + "Cheats are set to: {0}" + ConsoleColor.RESET;


		/**
		 * Message pattern to print out that a construction error happened for a JVM argument.
		 */
		@Constant
		String JVM_ARGUMENT_CONSTRUCTION_ERROR = "The construction process of entries in the " + "JvmArgument enum is invalid. [expected = {0}" + " | actual = {1}]";

	}


	/**
	 * This subinterface contains logging constants related to the {@link me.vault.game.view.ArenaDelegate}.
	 *
	 * @author Vincent Wolf, Lasse-Leander Hillen, Timothy Hoegen-Jupp, Alexander Goethel
	 * @version 1.0.0
	 * @see Artifact
	 * @since 30.07.2024
	 */
	interface ArenaDelegate
	{

		/**
		 * Message pattern to print out that the {@link me.vault.game.view.ArenaDelegate} couldn't be loaded.
		 */
		@Constant
		String ARENA_DISPLAY_FAILED = "Failed to load ArenaDelegate for an arena: {0}";


		/**
		 * Message pattern to print out that a {@link me.vault.game.model.arena.Figure} attacked another {@link me.vault.game.model.arena.Figure}.
		 */
		@Constant
		String ATTACKED_MSG = "{0} attacked {1}.";

	}


	/**
	 * This subinterface contains logging constants related to the {@link me.vault.game.view.mission.MissionDelegate}.
	 *
	 * @author Vincent Wolf, Lasse-Leander Hillen, Timothy Hoegen-Jupp, Alexander Goethel
	 * @version 1.0.0
	 * @see Artifact
	 * @since 30.07.2024
	 */
	interface MissionDelegate
	{

		/**
		 * Message pattern to print out that the {@link me.vault.game.view.mission.MissionDelegate} couldn't be loaded.
		 */
		@Constant
		String MISSION_DISPLAY_FAILED = "Failed to load MissionDelegate for a mission: {0}";

	}

}