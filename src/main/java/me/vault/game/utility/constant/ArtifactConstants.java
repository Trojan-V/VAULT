package me.vault.game.utility.constant;


import me.vault.game.model.currency.CurrencyTransaction;

import static me.vault.game.utility.constant.ConstantInterface.Constant;
import static me.vault.game.utility.constant.GameConstants.ASSETS_PATH;


/**
 * This class provides constants for the artifact statistics.
 *
 * @author Vincent Wolf, Alexander Goethel
 * @version 1.0.0
 * @since 05.06.2024
 */
@ConstantInterface
public interface ArtifactConstants
{

	@Constant
	double MULTIPLIER_MINIMUM = 0.5D;


	@Constant
	double MULTIPLIER_LOW = 0.75D;


	@Constant
	double MULTIPLIER_DEFAULT = 1.0D;


	@Constant
	double MULTIPLIER_HIGH = 1.25D;


	@Constant
	double MULTIPLIER_MAXIMUM = 1.5D;


	@ConstantInterface
	interface Defense
	{

		@Constant
		String BASE_NAME = "Defense Artifact";


		@Constant
		String IMPROVED_NAME = "Improved Defense Artifact";


		@Constant
		String BASE_SPRITE_PATH = ASSETS_PATH + "artifact/defense_artifact_icon.png";


		@Constant
		String IMPROVED_SPRITE_PATH = ASSETS_PATH + "artifact/defense_artifact_icon.png";


		@Constant
		CurrencyTransaction BASE_TO_IMPROVED_UPGRADE_COSTS = new CurrencyTransaction(-1000, -1000, -1000, -1000, -1000);


		@Constant
		CurrencyTransaction IMPROVED_TO_NONE_UPGRADE_COSTS = CurrencyTransaction.EMPTY;

	}



	@ConstantInterface
	interface Damage
	{

		@Constant
		String BASE_NAME = "Damage Artifact";


		@Constant
		String IMPROVED_NAME = "Improved Damage Artifact";


		@Constant
		String BASE_SPRITE_PATH = ASSETS_PATH + "artifact/damage_artifact_icon.png";


		@Constant
		String IMPROVED_SPRITE_PATH = ASSETS_PATH + "artifact/damage_artifact_icon.png";


		@Constant
		CurrencyTransaction BASE_TO_IMPROVED_UPGRADE_COSTS = new CurrencyTransaction(-1000, -1000, -1000, -1000, -1000);


		@Constant
		CurrencyTransaction IMPROVED_TO_NONE_UPGRADE_COSTS = CurrencyTransaction.EMPTY;

	}


	@ConstantInterface
	interface Health
	{

		@Constant
		String BASE_NAME = "Health Artifact";


		@Constant
		String IMPROVED_NAME = "Improved Health Artifact";


		@Constant
		String BASE_SPRITE_PATH = ASSETS_PATH + "artifact/health_artifact_icon.png";


		@Constant
		String IMPROVED_SPRITE_PATH = ASSETS_PATH + "artifact/health_artifact_icon.png";


		@Constant
		CurrencyTransaction BASE_TO_IMPROVED_UPGRADE_COSTS = new CurrencyTransaction(-1000, -1000, -1000, -1000, -1000);


		@Constant
		CurrencyTransaction IMPROVED_TO_NONE_UPGRADE_COSTS = CurrencyTransaction.EMPTY;

	}

}
