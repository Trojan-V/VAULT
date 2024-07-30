package me.vault.game.model.troop;


import me.vault.game.interfaces.Level;
import me.vault.game.utility.logging.Logger;

import static me.vault.game.utility.constant.LoggingConstants.Artifact.TROOP_IS_LOWEST;
import static me.vault.game.utility.constant.LoggingConstants.Artifact.TROOP_MAXED;
import static me.vault.game.utility.constant.MiscConstants.*;
import static me.vault.game.utility.logging.ILogger.Level.DEBUG;


/**
 * @author Vincent Wolf, Lasse-Leander Hillen, Timothy Hoegen-Jupp, Alexander Goethel
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
	 * Returns the minimum level an {@link Troop} can have. The minimum level is determined by the ordinal of the first
	 * enum entry.
	 *
	 * @return The minimum level an {@link Troop} can have.
	 */
	public static TroopLevel getMinimum ()
	{
		return values()[MINIMUM_LEVEL_ORDINAL];
	}


	/**
	 * Returns the maximum level an {@link Troop} can have. The maximum level is determined by the ordinal of the last enum entry.
	 *
	 * @return The maximum level an {@link Troop} can have.
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
