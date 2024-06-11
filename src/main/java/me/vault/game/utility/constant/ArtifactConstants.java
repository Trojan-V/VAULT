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

	double NO_CHANGE = 0;

	// health addition
	double HEALTH_BASE = 10;

	double HEALTH_IMPROVED = 22;

	// armour addition
	double ARMOUR_BASE = 0.05;

	double ARMOUR_IMPROVED = 0.12;

	// melee damage addition
	double MELEE_DAMAGE_BASE = 6;

	double MELEE_DAMAGE_IMPROVED = 112;

	// grenade damage addition
	double GRENADE_DAMAGE_BASE = 6;

	double GRENADE_DAMAGE_IMPROVED = 15;

	// energy damage addition
	double ENERGY_DAMAGE_BASE = 6;

	double ENERGY_DAMAGE_IMPROVED = 15;

	// resistenz addition
	double RESISTENZ_BASE = 0.05;

	double RESISTENZ_IMPROVED = 0.12;

	// artifact names
	String DAMAGE_ARTIFACT = "Damage Artifact";

	String IMPROVED_DAMAGE_ARTIFACT = "Improved Damage Artifact";

	String DEFENSE_ARTIFACT = "Defense Artifact";

	String IMPROVED_DEFENSE_ARTIFACT = "Improved Defense Artifact";

	String HEALTH_ARTIFACT = "Health Artifact";

	String IMPROVED_HEALTH_ARTIFACT = "Improved Health Artifact";

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

}
