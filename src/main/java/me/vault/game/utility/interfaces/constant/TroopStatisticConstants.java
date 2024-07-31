package me.vault.game.utility.interfaces.constant;


import me.vault.game.model.troop.TroopStatistics;

import static me.vault.game.utility.interfaces.constant.ConstantInterface.Constant;


/**
 * This interface contains constants related to {@link TroopStatistics}.
 *
 * @author Vincent Wolf
 * @version 1.0.0
 * @see TroopStatistics
 * @since 30.07.2024
 */
@ConstantInterface
public interface TroopStatisticConstants
{

	/**
	 * The path to the assets for the {@link TroopStatistics}.
	 */
	@Constant
	String STATISTICS_ASSETS_PATH = GameConstants.ASSETS_PATH + "statistics/";


	/**
	 * The display name of the health statistic.
	 */
	@Constant
	String HEALTH_NAME = "Health";


	/**
	 * The sprite of the health statistic.
	 */
	@Constant
	String HEALTH_ICON_PATH = STATISTICS_ASSETS_PATH + "health_icon.png";


	/**
	 * The X coordinate of the health statistic grid.
	 */
	@Constant
	Integer HEALTH_GRID_X = 0;


	/**
	 * The Y coordinate of the health statistic grid.
	 */
	@Constant
	Integer HEALTH_GRID_Y = 0;


	/**
	 * The display name of the melee damage statistic.
	 */
	@Constant
	String MELEE_NAME = "Melee Damage";


	/**
	 * The sprite of the melee damage statistic.
	 */
	@Constant
	String MELEE_ICON_PATH = STATISTICS_ASSETS_PATH + "melee_attack_icon.png";


	/**
	 * The X coordinate of the melee damage statistic grid.
	 */
	@Constant
	Integer MELEE_GRID_X = 0;


	/**
	 * The Y coordinate of the melee damage statistic grid.
	 */
	@Constant
	Integer MELEE_GRID_Y = 1;


	/**
	 * The display name of the grenade attack statistic.
	 */
	@Constant
	String GRENADE_NAME = "Grenade Damage";


	/**
	 * The sprite of the grenade attack statistic.
	 */
	@Constant
	String GRENADE_ICON_PATH = STATISTICS_ASSETS_PATH + "range_attack_icon.png";


	/**
	 * The X coordinate of the grenade attack statistic grid.
	 */
	@Constant
	Integer GRENADE_GRID_X = 1;


	/**
	 * The Y coordinate of the grenade attack statistic grid.
	 */
	@Constant
	Integer GRENADE_GRID_Y = 1;


	/**
	 * The display name of the armor statistic.
	 */
	@Constant
	String ARMOR_NAME = "Armor";


	/**
	 * The sprite of the armor statistic.
	 */
	@Constant
	String ARMOR_ICON_PATH = STATISTICS_ASSETS_PATH + "armor_icon.png";


	/**
	 * The X coordinate of the armor statistic grid.
	 */
	@Constant
	Integer ARMOR_GRID_X = 1;


	/**
	 * The Y coordinate of the grenade attack statistic grid.
	 */
	@Constant
	Integer ARMOR_GRID_Y = 0;


	/**
	 * The display name of the initiative statistic.
	 */
	@Constant
	String INITIATIVE_NAME = "Initiative";


	/**
	 * The sprite of the initiative statistic.
	 */
	@Constant
	String INITIATIVE_ICON_PATH = STATISTICS_ASSETS_PATH + "initiative_icon.png";


	/**
	 * The X coordinate of the initiative statistic grid.
	 */
	@Constant
	Integer INITIATIVE_GRID_X = 0;


	/**
	 * The Y coordinate of the initiative statistic grid.
	 */
	@Constant
	Integer INITIATIVE_GRID_Y = 3;


	/**
	 * The display name of the resistance statistic.
	 */
	@Constant
	String RESISTANCE_NAME = "Resistance";


	/**
	 * The sprite of the resistance statistic.
	 */
	@Constant
	String RESISTANCE_ICON_PATH = STATISTICS_ASSETS_PATH + "resistance_icon.png";


	/**
	 * The X coordinate of the resistance statistic grid.
	 */
	@Constant
	Integer RESISTANCE_GRID_X = 2;


	/**
	 * The Y coordinate of the resistance statistic grid.
	 */
	@Constant
	Integer RESISTANCE_GRID_Y = 0;


	/**
	 * The display name of the movement statistic.
	 */
	@Constant
	String MOVEMENT_NAME = "Movement";


	/**
	 * The sprite of the movement statistic.
	 */
	@Constant
	String MOVEMENT_ICON_PATH = STATISTICS_ASSETS_PATH + "movement_icon.png";


	/**
	 * The X coordinate of the movement statistic grid.
	 */
	@Constant
	Integer MOVEMENT_GRID_X = 1;


	/**
	 * The Y coordinate of the movement statistic grid.
	 */
	@Constant
	Integer MOVEMENT_GRID_Y = 3;


	/**
	 * The display name of the energy statistic.
	 */
	@Constant
	String ENERGY_NAME = "Energy";


	/**
	 * The sprite of the energy statistic.
	 */
	@Constant
	String ENERGY_ICON_PATH = STATISTICS_ASSETS_PATH + "energy_icon.png";


	/**
	 * The X coordinate of the energy statistic grid.
	 */
	@Constant
	Integer ENERGY_GRID_X = 2;


	/**
	 * The Y coordinate of the energy statistic grid.
	 */
	@Constant
	Integer ENERGY_GRID_Y = 1;


	/**
	 * The display name of the grenade amount statistic.
	 */
	@Constant
	String GRENADE_AMOUNT_NAME = "Grenade Amount";


	/**
	 * The sprite of the grenade amount statistic.
	 */
	@Constant
	String GRENADE_AMOUNT_ICON_PATH = STATISTICS_ASSETS_PATH + "grenade_icon.png";


	/**
	 * The X coordinate of the grenade amount statistic grid.
	 */
	@Constant
	Integer GRENADE_AMOUNT_GRID_X = 0;


	/**
	 * The Y coordinate of the grenade amount statistic grid.
	 */
	@Constant
	Integer GRENADE_AMOUNT_GRID_Y = 2;


	/**
	 * The display name of the grenade range statistic.
	 */
	@Constant
	String GRENADE_RANGE_NAME = "Grenade Range";


	/**
	 * The sprite of the grenade range statistic.
	 */
	@Constant
	String GRENADE_RANGE_ICON_PATH = STATISTICS_ASSETS_PATH + "grenade_icon.png";


	/**
	 * The X coordinate of the grenade range statistic grid.
	 */
	@Constant
	Integer GRENADE_RANGE_GRID_X = 1;


	/**
	 * The Y coordinate of the grenade range statistic grid.
	 */
	@Constant
	Integer GRENADE_RANGE_GRID_Y = 2;


	/**
	 * The display name of the dodge statistic.
	 */
	@Constant
	String DODGE_NAME = "Dodge";


	/**
	 * The sprite of the dodge statistic.
	 */
	@Constant
	String DODGE_ICON_PATH = STATISTICS_ASSETS_PATH + "dodge_icon.png";


	/**
	 * The X coordinate of the dodge statistic grid.
	 */
	@Constant
	Integer DODGE_GRID_X = 2;


	/**
	 * The Y coordinate of the dodge statistic grid.
	 */
	@Constant
	Integer DODGE_GRID_Y = 2;

}
