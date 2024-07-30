package me.vault.game.model.building;


import me.vault.game.control.CityBuildingController;
import me.vault.game.interfaces.Level;

import static me.vault.game.utility.constant.MiscConstants.*;


/**
 * This enum provides all different levels a {@link CityBuilding} can have.
 * <br>
 * <u>Technical note</u> <br>
 * It's important that the level entries in the enum are in the correct order, from minimum to maximum.
 * This is required to ensure that the methods {@link CityBuildingLevel#getMinimum()}, {@link CityBuildingLevel#getMaximum()},
 * {@link Level#isMinimum()} and {@link Level#isMaximum()} function correctly.
 *
 * @author Vincent Wolf, Lasse-Leander Hillen, Timothy Hoegen-Jupp, Alexander Goethel
 * @version 1.0.0
 * @see CityBuilding
 * @see CityBuildingController
 * @since 08.06.2024
 */
public enum CityBuildingLevel implements Level
{
	/**
	 * The lowest level a {@link CityBuilding} can have. Every {@link CityBuilding} starts at this level.
	 */
	OLD,


	/**
	 * The second possible level a {@link CityBuilding} can have.
	 * <br>
	 * A {@link CityBuilding} reaches this level after upgrading it once.
	 */
	NORMAL,


	/**
	 * The third and maximum level a {@link CityBuilding} can have.
	 * <br>
	 * A {@link CityBuilding} reaches this level after upgrading it twice.
	 */
	SUPER;


	/**
	 * Returns the minimum level a {@link CityBuilding} can have. The minimum level is determined by the ordinal of the first enum entry.
	 *
	 * @return The minimum level a {@link CityBuilding} can have.
	 *
	 * @precondition The method gets called and CityBuildingLevel was initialized.
	 * @postcondition The minimum of CityBuildingLevel was returned.
	 */
	public static CityBuildingLevel getMinimum ()
	{
		return values()[MINIMUM_LEVEL_ORDINAL];
	}


	/**
	 * Returns the maximum level a {@link CityBuilding} can have. The maximum level is determined by the ordinal of the last enum entry.
	 *
	 * @return The maximum level a {@link CityBuilding} can have.
	 *
	 * @precondition The method gets called and CityBuildingLevel was initialized.
	 * @postcondition The maximum of CityBuildingLevel was returned.
	 */
	public static CityBuildingLevel getMaximum ()
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
	public CityBuildingLevel getNextLowerLevel ()
	{
		// Check if the artifact level is already the lowest level.
		if (this.isMinimum())
		{
			return this;
		}
		return values()[this.ordinal() - PREVIOUS_LEVEL_SUBTRACTION_ORDINAL];
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public CityBuildingLevel getNextHigherLevel ()
	{
		// Check if the last entry was already reached, so there's no higher level for the artifact as it's
		// already at the maximum level.
		if (this.isMaximum())
		{
			return this;
		}
		return values()[this.ordinal() + NEXT_LEVEL_ADDITION_ORDINAL];
	}
}

