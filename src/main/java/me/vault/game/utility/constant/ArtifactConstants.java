package me.vault.game.utility.constant;


import me.vault.game.currency.CurrencyTransaction;

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


		String BASE_SPRITE_PATH = ASSETS_PATH + "Item_Pack/defense_artifact_icon.png";


		String IMPROVED_SPRITE_PATH = ASSETS_PATH + "Item_Pack/defense_artifact_icon.png";


		// TODO: Balancing der Upgrade-Kosten
		CurrencyTransaction BASE_TO_IMPROVED_UPGRADE_COSTS = new CurrencyTransaction(-10, -10, -10, -10, -10);


		CurrencyTransaction IMPROVED_TO_NONE_UPGRADE_COSTS = CurrencyTransaction.EMPTY;
	}


	interface Damage
	{
		String BASE_NAME = "Damage Artifact";


		String IMPROVED_NAME = "Improved Damage Artifact";


		String BASE_SPRITE_PATH = ASSETS_PATH + "Item_Pack/damage_artifact_icon.png";


		String IMPROVED_SPRITE_PATH = ASSETS_PATH + "Item_Pack/damage_artifact_icon.png";


		CurrencyTransaction BASE_TO_IMPROVED_UPGRADE_COSTS = new CurrencyTransaction(-10, -10, -10, -10, -10);


		CurrencyTransaction IMPROVED_TO_NONE_UPGRADE_COSTS = CurrencyTransaction.EMPTY;
	}


	interface Health
	{
		String BASE_NAME = "Health Artifact";


		String IMPROVED_NAME = "Improved Health Artifact";


		String BASE_SPRITE_PATH = ASSETS_PATH + "Item_Pack/health_artifact_icon.png";


		String IMPROVED_SPRITE_PATH = ASSETS_PATH + "Item_Pack/health_artifact_icon.png";


		CurrencyTransaction BASE_TO_IMPROVED_UPGRADE_COSTS = new CurrencyTransaction(-10, -10, -10, -10, -10);


		CurrencyTransaction IMPROVED_TO_NONE_UPGRADE_COSTS = CurrencyTransaction.EMPTY;
	}




	public static final double NO_CHANGE = 0;

	// health addition
	public static final double HEALTH_BASE = 10;


	public static final double HEALTH_IMPROVED = 22;


	// armour addition
	public static final double ARMOUR_BASE = 0.05;


	public static final double ARMOUR_IMPROVED = 0.12;


	// melee damage addition
	public static final double MELEE_DAMAGE_BASE = 6;


	public static final double MELEE_DAMAGE_IMPROVED = 112;


	// grenade damage addition
	public static final double GRENADE_DAMAGE_BASE = 6;


	public static final double GRENADE_DAMAGE_IMPROVED = 15;


	// energy damage addition
	public static final double ENERGY_DAMAGE_BASE = 6;


	public static final double ENERGY_DAMAGE_IMPROVED = 15;



	// resistenz addition
	public static final double RESISTENZ_BASE = 0.05;


	public static final double RESISTENZ_IMPROVED = 0.12;



	// artifact names
	public static final String DAMAGE_ARTIFACT = "Damage Artifact";


	public static final String IMPROVED_DAMAGE_ARTIFACT = "Improved Damage Artifact";


	public static final String DEFENSE_ARTIFACT = "Defense Artifact";


	public static final String IMPROVED_DEFENSE_ARTIFACT = "Improved Defense Artifact";


	public static final String HEALTH_ARTIFACT = "Health Artifact";


	public static final String IMPROVED_HEALTH_ARTIFACT = "Improved Health Artifact";

}
