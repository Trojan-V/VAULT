package me.vault.game.model.troop;


import me.vault.game.control.TroopController;
import me.vault.game.interfaces.Level;
import me.vault.game.model.artifact.ArtifactLevel;
import me.vault.game.utility.logging.ILogger;
import me.vault.game.utility.logging.Logger;

import static me.vault.game.utility.constant.LoggingConstants.Artifact.TROOP_IS_LOWEST;
import static me.vault.game.utility.constant.LoggingConstants.Artifact.TROOP_MAXED;
import static me.vault.game.utility.constant.MiscConstants.*;
import static me.vault.game.utility.logging.ILogger.Level.DEBUG;


/**
 * This enum provides all different levels a {@link Troop} can have.
 * <br>
 * <u>Technical note</u> <br>
 * It's important that the level entries in the enum are in the correct order, from minimum to maximum.
 * This is required to ensure that the methods {@link ArtifactLevel#getMinimum()}, {@link ArtifactLevel#getMaximum()},
 * {@link Level#isMinimum()} and {@link Level#isMaximum()} function correctly.
 *
 * @author Vincent Wolf, Lasse-Leander Hillen, Timothy Hoegen-Jupp, Alexander Goethel
 * @version 1.0.0
 * @see Troop
 * @see TroopController
 * @since 08.06.2024
 */
public enum TroopLevel implements Level
{
	/**
	 * The "single combatant" level. Every troop starts with this level.
	 */
	SINGLE_COMBATANT,


	/**
	 * The "couple" troop level. This level is reached after upgrading a troop once.
	 */
	COUPLE,


	/**
	 * The "squad" troop level.
	 * This level is reached after upgrading a troop twice.
	 * <br>
	 * This is currently the maximum achievable level for troops.
	 */
	SQUAD;


	/**
	 * The {@link Logger} object for this class used for writing to the console.
	 */
	private static final ILogger LOGGER = new Logger(TroopLevel.class.getSimpleName());


	/**
	 * Returns the minimum level an {@link Troop} can have. The minimum level is determined by the ordinal of the first
	 * enum entry.
	 *
	 * @return The minimum level an {@link Troop} can have.
	 *
	 * @precondition The {@link Troop} can have multiple level and has a minimum level.
	 * @postcondition The minimum level of a {@link Troop} is accessible for the program.
	 */
	public static TroopLevel getMinimum ()
	{
		return values()[MINIMUM_LEVEL_ORDINAL];
	}


	/**
	 * Returns the maximum level an {@link Troop} can have. The maximum level is determined by the ordinal of the last enum entry.
	 *
	 * @return The maximum level an {@link Troop} can have.
	 *
	 * @precondition The {@link Troop} can have multiple level and has a maximum level.
	 * @postcondition The minimum level of an {@link Troop} is accessible for the program.
	 */
	public static TroopLevel getMaximum ()
	{
		return values()[Level.getLastIndex(values().length)];
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isMinimum ()
	{
		return this.ordinal() == MINIMUM_LEVEL_ORDINAL;
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isMaximum ()
	{
		return this.ordinal() == Level.getLastIndex(values().length);
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public TroopLevel getNextLowerLevel ()
	{
		// Check if the troop level is already the lowest level.
		if (this.isMinimum())
		{
			LOGGER.logf(DEBUG, TROOP_IS_LOWEST, this.name());
			return this;
		}
		return values()[this.ordinal() - PREVIOUS_LEVEL_SUBTRACTION_ORDINAL];
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public TroopLevel getNextHigherLevel ()
	{
		// Check if the last entry was already reached, so there would be no higher level for the troop as it's
		// already at the maximum level.
		if (this.isMaximum())
		{
			LOGGER.logf(DEBUG, TROOP_MAXED, this.name());
			return this;
		}
		return values()[this.ordinal() + NEXT_LEVEL_ADDITION_ORDINAL];
	}
}
