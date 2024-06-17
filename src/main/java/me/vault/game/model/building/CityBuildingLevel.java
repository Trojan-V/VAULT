package me.vault.game.model.building;


import me.vault.game.interfaces.Level;
import me.vault.game.utility.logging.ILogger;
import me.vault.game.utility.logging.Logger;

import java.text.MessageFormat;

import static me.vault.game.utility.constant.LoggingConstants.Artifact.*;
import static me.vault.game.utility.logging.ILogger.Level.DEBUG;


public enum CityBuildingLevel implements Level
{
	OLD,
	NORMAL,
	SUPER;

	/**
	 * The {@link Logger} object for this class used for writing to the console.
	 */
	private static final ILogger LOGGER = new Logger(CityBuildingLevel.class.getSimpleName());

	private static final int MINIMUM_LEVEL_ORDINAL = 0;

	private static final int NEXT_LEVEL_ADDITION_ORDINAL = 1;

	private static final int PREVIOUS_LEVEL_SUBTRACTION_ORDINAL = 1;


	public static CityBuildingLevel getMinimumCityBuildingLevel ()
	{
		// TODO: Logging Messages
		return values()[MINIMUM_LEVEL_ORDINAL];
	}


	public static CityBuildingLevel getMaximumCityBuildingLevel ()
	{
		return values()[values().length - PREVIOUS_LEVEL_SUBTRACTION_ORDINAL];
	}


	@Override
	public  CityBuildingLevel getNextHigherLevel ()
	{
		// Check if the last entry was already reached, so there would be no higher level for the artifact as it's
		// already at the maximum level.
		if (checkIsMaximumLevel(this))
		{
			return this;
		}
		return values()[this.ordinal() + NEXT_LEVEL_ADDITION_ORDINAL];
	}


	@Override
	public CityBuildingLevel getNextLowerLevel ()
	{
		// Check if the artifact level is already the lowest level.
		if (checkIsMinimumLevel(this))
		{
			return this;
		}
		return values()[this.ordinal() - PREVIOUS_LEVEL_SUBTRACTION_ORDINAL];
	}


	private static boolean checkIsMinimumLevel (final CityBuildingLevel level)
	{
		return level.ordinal() - PREVIOUS_LEVEL_SUBTRACTION_ORDINAL < MINIMUM_LEVEL_ORDINAL;
	}


	private static boolean checkIsMaximumLevel (final CityBuildingLevel level)
	{
		return level.ordinal() + NEXT_LEVEL_ADDITION_ORDINAL >= values().length;
	}
}

