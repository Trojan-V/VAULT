package me.vault.game.utility.interfaces.constant;


import me.vault.game.model.currency.CurrencyTransaction;

import static me.vault.game.utility.interfaces.constant.ConstantInterface.Constant;


/**
 * This interface provides constants for the artifact statistics.
 *
 * @author Vincent Wolf, Lasse-Leander Hillen, Timothy Hoegen-Jupp, Alexander Goethel
 * @version 1.0.0
 * @since 05.06.2024
 */
@ConstantInterface
public interface ArtifactConstants
{

	/**
	 * The minimum multiplier for the artifact statistics.
	 */
	@Constant
	double MULTIPLIER_MINIMUM = 0.5D;


	/**
	 * The low multiplier for the artifact statistics.
	 */
	@Constant
	double MULTIPLIER_LOW = 0.75D;


	/**
	 * The default multiplier for the artifact statistics.
	 */
	@Constant
	double MULTIPLIER_DEFAULT = 1.0D;


	/**
	 * The high multiplier for the artifact statistics.
	 */
	@Constant
	double MULTIPLIER_HIGH = 1.25D;


	/**
	 * The maximum multiplier for the artifact statistics.
	 */
	@Constant
	double MULTIPLIER_MAXIMUM = 1.5D;


	/**
	 * This interface provides constants for the defense artifact.
	 *
	 * @author Vincent Wolf, Lasse-Leander Hillen, Timothy Hoegen-Jupp, Alexander Goethel
	 * @version 1.0.0
	 * @since 30.07.2024
	 */
	@ConstantInterface
	interface Defense
	{

		/**
		 * The display name of the defense artifact at the base level.
		 */
		@Constant
		String BASE_NAME = "Defense Artifact";


		/**
		 * The display name of the defense artifact at the improved level.
		 */
		@Constant
		String IMPROVED_NAME = "Improved Defense Artifact";


		/**
		 * The display name of the defense artifact at the base level.
		 */
		@Constant
		String BASE_SPRITE_PATH = GameConstants.ASSETS_PATH + "artifact/defense_artifact_icon.png";


		/**
		 * The sprite of the defense artifact at the improved level.
		 */
		@Constant
		String IMPROVED_SPRITE_PATH = GameConstants.ASSETS_PATH + "artifact/defense_artifact_icon.png";


		/**
		 * The upgrade costs of the defense artifact at the base level.
		 */
		@Constant
		CurrencyTransaction BASE_TO_IMPROVED_UPGRADE_COSTS = new CurrencyTransaction(-1000, -1000, -1000, -1000, -1000);


		/**
		 * The upgrade costs of the defense artifact at the improved level.
		 */
		@Constant
		CurrencyTransaction IMPROVED_TO_NONE_UPGRADE_COSTS = CurrencyTransaction.EMPTY;

	}


	/**
	 * This interface provides constants for the damage artifact.
	 *
	 * @author Vincent Wolf, Lasse-Leander Hillen, Timothy Hoegen-Jupp, Alexander Goethel
	 * @version 1.0.0
	 * @since 30.07.2024
	 */
	@ConstantInterface
	interface Damage
	{

		/**
		 * The display name of the damage artifact at the base level.
		 */
		@Constant
		String BASE_NAME = "Damage Artifact";


		/**
		 * The display name of the damage artifact at the improved level.
		 */
		@Constant
		String IMPROVED_NAME = "Improved Damage Artifact";


		/**
		 * The sprite of the damage artifact at the base level.
		 */
		@Constant
		String BASE_SPRITE_PATH = GameConstants.ASSETS_PATH + "artifact/damage_artifact_icon.png";


		/**
		 * The sprite of the damage artifact at the improved level.
		 */
		@Constant
		String IMPROVED_SPRITE_PATH = GameConstants.ASSETS_PATH + "artifact/damage_artifact_icon.png";


		/**
		 * The upgrade costs of the damage artifact at the base level.
		 */
		@Constant
		CurrencyTransaction BASE_TO_IMPROVED_UPGRADE_COSTS = new CurrencyTransaction(-1000, -1000, -1000, -1000, -1000);


		/**
		 * The upgrade costs of the damage artifact at the improved level.
		 */
		@Constant
		CurrencyTransaction IMPROVED_TO_NONE_UPGRADE_COSTS = CurrencyTransaction.EMPTY;

	}


	/**
	 * This interface provides constants for the health artifact.
	 *
	 * @author Vincent Wolf, Lasse-Leander Hillen, Timothy Hoegen-Jupp, Alexander Goethel
	 * @version 1.0.0
	 * @since 30.07.2024
	 */
	@ConstantInterface
	interface Health
	{

		/**
		 * The display name of the damage artifact at the base level.
		 */
		@Constant
		String BASE_NAME = "Health Artifact";


		/**
		 * The display name of the damage artifact at the improved level.
		 */
		@Constant
		String IMPROVED_NAME = "Improved Health Artifact";


		/**
		 * The sprite of the damage artifact at the base level.
		 */
		@Constant
		String BASE_SPRITE_PATH = GameConstants.ASSETS_PATH + "artifact/health_artifact_icon.png";


		/**
		 * The sprite of the damage artifact at the improved level.
		 */
		@Constant
		String IMPROVED_SPRITE_PATH = GameConstants.ASSETS_PATH + "artifact/health_artifact_icon.png";


		/**
		 * The upgrade costs of the damage artifact at the base level.
		 */
		@Constant
		CurrencyTransaction BASE_TO_IMPROVED_UPGRADE_COSTS = new CurrencyTransaction(-1000, -1000, -1000, -1000, -1000);


		/**
		 * The upgrade costs of the damage artifact at the improved level.
		 */
		@Constant
		CurrencyTransaction IMPROVED_TO_NONE_UPGRADE_COSTS = CurrencyTransaction.EMPTY;

	}

}
