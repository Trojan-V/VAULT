package me.vault.game.model.artifact;


import me.vault.game.control.ArtifactController;
import me.vault.game.utility.interfaces.Level;
import me.vault.game.utility.logging.ILogger;
import me.vault.game.utility.logging.Logger;

import static me.vault.game.utility.interfaces.constant.LoggingConstants.Artifact.ARTIFACT_IS_LOWEST;
import static me.vault.game.utility.interfaces.constant.LoggingConstants.Artifact.ARTIFACT_MAXED;
import static me.vault.game.utility.interfaces.constant.MiscConstants.*;
import static me.vault.game.utility.logging.ILogger.Level.DEBUG;


/**
 * This enum provides all different levels an {@link Artifact} can have.
 * <br>
 * <u>Technical note</u> <br>
 * It's important that the level entries in the enum are in the correct order, from minimum to maximum. This is required to ensure that the methods
 * {@link ArtifactLevel#getMinimum()}, {@link ArtifactLevel#getMaximum()} ,
 * {@link Level#isMinimum()} and {@link Level#isMaximum()} function correctly.
 *
 * @author Vincent Wolf, Lasse-Leander Hillen, Timothy Hoegen-Jupp, Alexander Goethel
 * @version 1.0.0
 * @see Artifact
 * @see ArtifactController
 * @since 08.06.2024
 */
public enum ArtifactLevel implements Level
{
	/**
	 * The base artifact level. This is the lowest possible artifact level. Every artifact starts with this level.
	 */
	BASE,


	/**
	 * The improved artifact level. This is currently the maximum possible artifact level. This level is reached after upgrading an artifact once.
	 */
	IMPROVED;


	/**
	 * The {@link Logger} object for this class used for writing to the console.
	 */
	private static final ILogger LOGGER = new Logger(ArtifactLevel.class.getSimpleName());


	/**
	 * Returns the minimum level an {@link Artifact} can have. The minimum level is determined by the ordinal of the first enum entry.
	 *
	 * @return The minimum level an {@link Artifact} can have.
	 *
	 * @precondition The {@link Artifact} can have multiple level and has a minimum level.
	 * @postcondition The minimum level of an {@link Artifact} is accessible for the program.
	 */
	public static ArtifactLevel getMinimum ()
	{
		return values()[MINIMUM_LEVEL_ORDINAL];
	}


	/**
	 * Returns the maximum level an {@link Artifact} can have. The maximum level is determined by the ordinal of the last enum entry.
	 *
	 * @return The maximum level an {@link Artifact} can have.
	 *
	 * @precondition The {@link Artifact} can have multiple level and has a maximum level.
	 * @postcondition The maximum level of an {@link Artifact} is accessible for the program.
	 */
	public static ArtifactLevel getMaximum ()
	{
		return values()[Level.getLastIndex(values().length)];
	}


	/**
	 * Checks if the level of the current level instance is the minimum level.
	 *
	 * @return True if the level of the current level instance is the minimum level, otherwise false.
	 *
	 * @precondition The method gets called.
	 * @precondition If the level is the minimum, then true was returned.
	 */
	@Override
	public boolean isMinimum ()
	{
		return this.ordinal() == MINIMUM_LEVEL_ORDINAL;
	}


	/**
	 * Checks if the level of the current level instance is the maximum level.
	 *
	 * @return True if the level of the current level instance is the maximum level, otherwise false.
	 *
	 * @precondition The method gets called.
	 * @precondition If the level is the maximum, then true was returned.
	 */
	@Override
	public boolean isMaximum ()
	{
		return this.ordinal() == Level.getLastIndex(values().length);
	}


	/**
	 * Returns the next lower level for the current level instance.
	 *
	 * @return The next lower level for the current level instance.
	 *
	 * @precondition The method gets called.
	 * @precondition The next lower level of the Level is returned.
	 */
	@Override
	public ArtifactLevel getNextLowerLevel ()
	{
		// Check if the artifact level is already the lowest level.
		if (this.isMinimum())
		{
			LOGGER.logf(DEBUG, ARTIFACT_IS_LOWEST, this.name());
			return this;
		}
		return values()[this.ordinal() - PREVIOUS_LEVEL_SUBTRACTION_ORDINAL];
	}


	/**
	 * Returns the next higher level for the current level instance.
	 *
	 * @return The next higher level for the current level instance.
	 *
	 * @precondition The method gets called.
	 * @precondition The next higher level of the Level is returned.
	 */
	@Override
	public ArtifactLevel getNextHigherLevel ()
	{
		// Check if the last entry was already reached, so there would be no higher level for the artifact as it's
		// already at the maximum level.
		if (this.isMaximum())
		{
			LOGGER.logf(DEBUG, ARTIFACT_MAXED, this.name());
			return this;
		}
		return values()[this.ordinal() + NEXT_LEVEL_ADDITION_ORDINAL];
	}
}
