package me.vault.game.utility.constant;


import me.vault.game.model.currency.CurrencyTransaction;

import static me.vault.game.utility.constant.GameConstants.ASSETS_PATH;


/**
 * This class provides constants for the artifact statistics.
 *
 * @author Vincent Wolf, Alexander Goethel
 * @version 1.0.0
 * @since 05.06.2024
 */
public interface ArtifactConstants
{

	double MULTIPLIER_MINIMUM = 0.5D;


	double MULTIPLIER_LOW = 0.75D;


	double MULTIPLIER_DEFAULT = 1.0D;


	double MULTIPLIER_HIGH = 1.25D;


	double MULTIPLIER_MAXIMUM = 1.5D;


	interface Defense
	{

		String BASE_NAME = "Defense Artifact";


		String IMPROVED_NAME = "Improved Defense Artifact";


		String BASE_SPRITE_PATH = ASSETS_PATH + "artifact/defense_artifact_icon.png";


		String IMPROVED_SPRITE_PATH = ASSETS_PATH + "artifact/defense_artifact_icon.png";


		CurrencyTransaction BASE_TO_IMPROVED_UPGRADE_COSTS = new CurrencyTransaction(-1000, -1000, -1000, -1000, -1000);


		CurrencyTransaction IMPROVED_TO_NONE_UPGRADE_COSTS = CurrencyTransaction.EMPTY;

	}


	interface Damage
	{

		String BASE_NAME = "Damage Artifact";


		String IMPROVED_NAME = "Improved Damage Artifact";


		String BASE_SPRITE_PATH = ASSETS_PATH + "artifact/damage_artifact_icon.png";


		String IMPROVED_SPRITE_PATH = ASSETS_PATH + "artifact/damage_artifact_icon.png";


		CurrencyTransaction BASE_TO_IMPROVED_UPGRADE_COSTS = new CurrencyTransaction(-1000, -1000, -1000, -1000, -1000);


		CurrencyTransaction IMPROVED_TO_NONE_UPGRADE_COSTS = CurrencyTransaction.EMPTY;

	}


	interface Health
	{

		String BASE_NAME = "Health Artifact";


		String IMPROVED_NAME = "Improved Health Artifact";


		String BASE_SPRITE_PATH = ASSETS_PATH + "artifact/health_artifact_icon.png";


		String IMPROVED_SPRITE_PATH = ASSETS_PATH + "artifact/health_artifact_icon.png";


		CurrencyTransaction BASE_TO_IMPROVED_UPGRADE_COSTS = new CurrencyTransaction(-1000, -1000, -1000, -1000, -1000);


		CurrencyTransaction IMPROVED_TO_NONE_UPGRADE_COSTS = CurrencyTransaction.EMPTY;

	}

}
