package me.vault.game.model.energy;


import me.vault.game.interfaces.Level;
import me.vault.game.utility.logging.ILogger;
import me.vault.game.utility.logging.Logger;

import static me.vault.game.utility.constant.LoggingConstants.Artifact.ENERGY_IS_LOWEST;
import static me.vault.game.utility.constant.LoggingConstants.Artifact.ENERGY_MAXED;
import static me.vault.game.utility.constant.MiscConstants.*;
import static me.vault.game.utility.logging.ILogger.Level.DEBUG;


public enum EnergyLevel implements Level
{
	/**
	 * The base energy ability level. This is the lowest possible energy ability level. Every energy ability starts with this level.
	 */
	BASE,

	/**
	 * The improved energy ability level. This is currently the maximum possible energy ability level. This level is reached
	 * after upgrading an energy ability once.
	 */
	IMPROVED;

	/**
	 * The {@link Logger} object for this class used for writing to the console.
	 */
	private static final ILogger LOGGER = new Logger(EnergyLevel.class.getSimpleName());


	/**
	 * Returns the minimum level an {@link Energy} can have. The minimum level is determined by the ordinal of the first
	 * enum entry.
	 *
	 * @return The minimum level an {@link Energy} can have.
	 */
	public static EnergyLevel getMinimum ()
	{
		return values()[MINIMUM_LEVEL_ORDINAL];
	}


	/**
	 * Returns the maximum level an {@link Energy} can have. The maximum level is determined by the ordinal of the last
	 * enum entry.
	 *
	 * @return The maximum level an {@link Energy} can have.
	 */
	public static EnergyLevel getMaximum ()
	{
		return values()[values().length - ZERO_INDEXED_LENGTH_CORRECTION];
	}


	/**
	 * Checks if the supplied energy ability level is the minimum level.
	 *
	 * @param level The level which is checked.
	 *
	 * @return True if the supplied level is the minimum level, otherwise false.
	 */
	private static boolean checkIsMinimumLevel (final EnergyLevel level)
	{
		return level.ordinal() - ZERO_INDEXED_LENGTH_CORRECTION < MINIMUM_LEVEL_ORDINAL;
	}


	/**
	 * Checks if the supplied energy ability level is the maximum level.
	 *
	 * @param level The level which is checked.
	 *
	 * @return True if the supplied level is the maximum level, otherwise false.
	 */
	private static boolean checkIsMaximumLevel (final EnergyLevel level)
	{
		return level.ordinal() + NEXT_LEVEL_ADDITION_ORDINAL >= values().length;
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public EnergyLevel getNextLowerLevel ()
	{
		// Check if the energy ability level is already the lowest level.
		if (checkIsMinimumLevel(this))
		{
			LOGGER.logf(DEBUG, ENERGY_IS_LOWEST, this.name());
			return this;
		}
		return values()[this.ordinal() - PREVIOUS_LEVEL_SUBTRACTION_ORDINAL];
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public EnergyLevel getNextHigherLevel ()
	{
		// Check if the last entry was already reached, so there would be no higher level for the energy ability as it's
		// already at the maximum level.
		if (checkIsMaximumLevel(this))
		{
			LOGGER.logf(DEBUG, ENERGY_MAXED, this.name());
			return this;
		}
		return values()[this.ordinal() + NEXT_LEVEL_ADDITION_ORDINAL];
	}
}