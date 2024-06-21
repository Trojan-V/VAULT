package me.vault.game.model.troop;


import me.vault.game.interfaces.Level;
import me.vault.game.model.artifact.Artifact;
import me.vault.game.utility.logging.Logger;

import static me.vault.game.utility.constant.LoggingConstants.Artifact.ARTIFACT_IS_LOWEST;
import static me.vault.game.utility.constant.LoggingConstants.Artifact.ARTIFACT_MAXED;
import static me.vault.game.utility.constant.MiscConstants.*;
import static me.vault.game.utility.logging.ILogger.Level.DEBUG;


/**
 * @author Alexander Göthel
 * @version 1.0.0
 * @since 28.05.2024
 */
public enum TroopLevel implements Level
{
	SINGLE_COMBATANT,
	COUPLE,
	SQUAD;

	private static final Logger LOGGER = new Logger(TroopLevel.class.getSimpleName());


	/**
	 * Returns the minimum level an {@link Artifact} can have. The minimum level is determined by the ordinal of the first enum entry.
	 *
	 * @return The minimum level an {@link Artifact} can have.
	 */
	public static TroopLevel getMinimum ()
	{
		return values()[MINIMUM_LEVEL_ORDINAL];
	}


	/**
	 * Returns the maximum level an {@link Artifact} can have. The maximum level is determined by the ordinal of the last enum entry.
	 *
	 * @return The maximum level an {@link Artifact} can have.
	 */
	public static TroopLevel getMaxLevel ()
	{
		return values()[values().length - ZERO_INDEXED_LENGTH_CORRECTION];
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public TroopLevel getNextLowerLevel ()
	{
		// Check if the artifact level is already the lowest level.
		if (checkIsMinimumLevel(this))
		{
			LOGGER.logf(DEBUG, ARTIFACT_IS_LOWEST, this.name());
			return this;
		}
		return values()[this.ordinal() - PREVIOUS_LEVEL_SUBTRACTION_ORDINAL];
	}


	/**
	 * {@inheritDoc}
	 */
	private static boolean checkIsMaximumLevel (final TroopLevel level)
	{
		return level.ordinal() + NEXT_LEVEL_ADDITION_ORDINAL >= values().length;
	}


	/**
	 * {@inheritDoc}
	 */
	private static boolean checkIsMinimumLevel (final TroopLevel level)
	{
		return level.ordinal() - ZERO_INDEXED_LENGTH_CORRECTION < MINIMUM_LEVEL_ORDINAL;
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public TroopLevel getNextHigherLevel ()
	{
		// Check if the last entry was already reached, so there would be no higher level for the artifact as it's
		// already at the maximum level.
		if (checkIsMaximumLevel(this))
		{
			LOGGER.logf(DEBUG, ARTIFACT_MAXED, this.name());
			return this;
		}
		return values()[this.ordinal() + NEXT_LEVEL_ADDITION_ORDINAL];
	}
}
