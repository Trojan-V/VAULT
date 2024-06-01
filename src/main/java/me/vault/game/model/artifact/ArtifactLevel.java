package me.vault.game.model.artifact;


import me.vault.game.utility.logging.ILogger;
import me.vault.game.utility.logging.Logger;

import java.text.MessageFormat;

import static me.vault.game.utility.constant.LoggingConstants.Artifact.*;
import static me.vault.game.utility.logging.ILogger.Level.DEBUG;


public enum ArtifactLevel
{
	BASE,
	SUPER;


	/**
	 * The logger object for this class used for writing to the console.
	 *
	 * @see Logger
	 */
	private static final ILogger LOGGER = new Logger(ArtifactLevel.class.getSimpleName());


	private static final int MINIMUM_LEVEL_ORDINAL = 0;


	private static final int NEXT_LEVEL_ADDITION_ORDINAL = 1;


	private static final int PREVIOUS_LEVEL_SUBTRACTION_ORDINAL = 1;


	public static ArtifactLevel getMaximumArtifactLevel ()
	{
		LOGGER.log(DEBUG, MessageFormat.format(GET_MAXIMUM_LEVEL_METHOD_ENTERED_MSG, values()[values().length -
		                                                                                      PREVIOUS_LEVEL_SUBTRACTION_ORDINAL].name()));
		return values()[values().length - PREVIOUS_LEVEL_SUBTRACTION_ORDINAL];
	}


	public static ArtifactLevel getNextHigherLevel (final ArtifactLevel currentArtifactLevel)
	{
		LOGGER.log(DEBUG, MessageFormat.format(GET_NEXT_HIGHER_LEVEL_METHOD_ENTERED_MSG, currentArtifactLevel.name()));


		// Check if the last entry was already reached, so there would be no higher level for the artifact as it's
		// already at the maximum level.
		if (checkIsMaximumLevel(currentArtifactLevel))
		{
			LOGGER.log(DEBUG, MessageFormat.format(ARTIFACT_IS_MAX_LEVEL_MSG, currentArtifactLevel.name()));
			return currentArtifactLevel;
		}

		LOGGER.log(DEBUG, MessageFormat.format(GET_NEXT_HIGHER_LEVEL_METHOD_LEFT_MSG, values()[
			currentArtifactLevel.ordinal() + NEXT_LEVEL_ADDITION_ORDINAL].name()));
		return values()[currentArtifactLevel.ordinal() + NEXT_LEVEL_ADDITION_ORDINAL];
	}


	public static ArtifactLevel getNextLowerLevel (final ArtifactLevel level)
	{
		LOGGER.log(DEBUG, MessageFormat.format(GET_NEXT_LOWER_LEVEL_METHOD_ENTERED_MSG, level.name()));
		// Check if the artifact level is already the lowest level.
		if (checkIsMinimumLevel(level))
		{
			LOGGER.log(DEBUG, MessageFormat.format(ARTIFACT_IS_MIN_LEVEL_MSG, level.name()));
			return level;
		}
		LOGGER.log(DEBUG, MessageFormat.format(GET_NEXT_LOWER_LEVEL_METHOD_LEFT_MSG, values()[level.ordinal() -
		                                                                                      PREVIOUS_LEVEL_SUBTRACTION_ORDINAL].name()));
		return values()[level.ordinal() - PREVIOUS_LEVEL_SUBTRACTION_ORDINAL];
	}


	private static boolean checkIsMinimumLevel (final ArtifactLevel level)
	{
		return level.ordinal() - PREVIOUS_LEVEL_SUBTRACTION_ORDINAL < MINIMUM_LEVEL_ORDINAL;
	}


	private static boolean checkIsMaximumLevel (final ArtifactLevel level)
	{
		return level.ordinal() + NEXT_LEVEL_ADDITION_ORDINAL >= values().length;
	}
}
