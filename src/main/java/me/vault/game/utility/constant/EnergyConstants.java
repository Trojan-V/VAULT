package me.vault.game.utility.constant;


import me.vault.game.model.currency.CurrencyTransaction;

import static me.vault.game.utility.constant.GameConstants.ASSETS_PATH;


/**
 * This interface provides constants for the energy ability statistics.
 *
 * @author Alexander Goethel
 * @version 1.0.0
 * @since 25.07.2024
 */

public interface EnergyConstants
{

	double DEFAULT = 1.0D;


	double HIGH = 1.25D;


	double MAXIMUM = 1.5D;

	interface Dodge
	{

		String BASE_NAME = "Dodge Ability";


		String IMPROVED_NAME = "Improved Dodge Ability";


		String BASE_SPRITE_PATH = ASSETS_PATH + "energy/dodge_energyability.png";


		String IMPROVED_SPRITE_PATH = ASSETS_PATH + "energy/dodge_energyability.png";


		CurrencyTransaction BASE_TO_IMPROVED_UPGRADE_COSTS = new CurrencyTransaction(-1000, -1000, -1000, -1000, -1000);


		CurrencyTransaction IMPROVED_TO_NONE_UPGRADE_COSTS = CurrencyTransaction.EMPTY;

	}

	interface Initiative
	{

		String BASE_NAME = "Initiative Ability";


		String IMPROVED_NAME = "Improved Initiative Ability";


		String BASE_SPRITE_PATH = ASSETS_PATH + "energy/initiative_energyabiltiy.png";


		String IMPROVED_SPRITE_PATH = ASSETS_PATH + "energy/initiative_energyabiltiy.png";


		CurrencyTransaction BASE_TO_IMPROVED_UPGRADE_COSTS = new CurrencyTransaction(-1000, -1000, -1000, -1000, -1000);


		CurrencyTransaction IMPROVED_TO_NONE_UPGRADE_COSTS = CurrencyTransaction.EMPTY;

	}

	interface Melee
	{

		String BASE_NAME = "Melee Ability";


		String IMPROVED_NAME = "Improved Melee Ability";


		String BASE_SPRITE_PATH = ASSETS_PATH + "energy/melee_energyability.png";


		String IMPROVED_SPRITE_PATH = ASSETS_PATH + "energy/melee_energyability.png";


		CurrencyTransaction BASE_TO_IMPROVED_UPGRADE_COSTS = new CurrencyTransaction(-1000, -1000, -1000, -1000, -1000);


		CurrencyTransaction IMPROVED_TO_NONE_UPGRADE_COSTS = CurrencyTransaction.EMPTY;

	}
}