package me.vault.game.utility.constant;


import static me.vault.game.utility.constant.ConstantInterface.Constant;
import static me.vault.game.utility.constant.GameConstants.ASSETS_PATH;


@ConstantInterface
public interface AttributeConstants
{

	@Constant
	String ATTRIBUTE_ASSETS_PATH = ASSETS_PATH + "attributes/";

	// Health-Attribute ----------------------------------------------------------------------------------------------

	@Constant
	String HEALTH_ATTRIBUTE_NAME = "Health";

	@Constant
	String HEALTH_ATTRIBUTE_ICON_PATH = ATTRIBUTE_ASSETS_PATH + "health_icon.png";

	@Constant
	Integer HEALTH_ATTRIBUTE_GRID_X = 0;

	@Constant
	Integer HEALTH_ATTRIBUTE_GRID_Y = 0;

	// Melee-Attack-Attribute ----------------------------------------------------------------------------------------

	@Constant
	String MELEE_ATTRIBUTE_NAME = "M.-Damage";

	@Constant
	String MELEE_ATTACK_ATTRIBUTE_ICON_PATH = ATTRIBUTE_ASSETS_PATH + "melee_attack_icon.png";

	@Constant
	Integer MELEE_ATTACK_ATTRIBUTE_GRID_X = 0;

	@Constant
	Integer MELEE_ATTACK_ATTRIBUTE_GRID_Y = 1;

	// Grenade-Attack Attribute --------------------------------------------------------------------------------------

	@Constant
	String GRENADE_ATTACK_ATTRIBUTE_NAME = "G.-Damage";

	@Constant
	String GRENADE_ATTACK_ATTRIBUTE_ICON_PATH = ATTRIBUTE_ASSETS_PATH + "range_attack_icon.png";

	@Constant
	Integer GRENADE_ATTACK_ATTRIBUTE_GRID_X = 1;

	@Constant
	Integer GRENADE_ATTACK_ATTRIBUTE_GRID_Y = 1;

	// Armor-Attribute -----------------------------------------------------------------------------------------------

	@Constant
	String ARMOR_ATTRIBUTE_NAME = "Armor";

	@Constant
	String ARMOR_ATTRIBUTE_ICON_PATH = ATTRIBUTE_ASSETS_PATH + "armor_icon.png";

	@Constant
	Integer ARMOR_ATTRIBUTE_GRID_X = 1;

	@Constant
	Integer ARMOR_ATTRIBUTE_GRID_Y = 0;

	// Initiative-Attribute ------------------------------------------------------------------------------------------

	@Constant
	String INITIATIVE_ATTRIBUTE_NAME = "Initiative";

	@Constant
	String INITIATIVE_ATTRIBUTE_ICON_PATH = ATTRIBUTE_ASSETS_PATH + "initiative_icon.png";

	@Constant
	Integer INITIATIVE_ATTRIBUTE_GRID_X = 0;

	@Constant
	Integer INITIATIVE_ATTRIBUTE_GRID_Y = 3;

	// Resistance-Attribute ------------------------------------------------------------------------------------------

	@Constant
	String RESISTANCE_ATTRIBUTE_NAME = "Resistance";

	@Constant
	String RESISTANCE_ATTRIBUTE_ICON_PATH = ATTRIBUTE_ASSETS_PATH + "resistance_icon.png";

	@Constant
	Integer RESISTANCE_ATTRIBUTE_GRID_X = 2;

	@Constant
	Integer RESISTANCE_ATTRIBUTE_GRID_Y = 0;

	// Movement-Attribute --------------------------------------------------------------------------------------------

	@Constant
	String MOVEMENT_ATTRIBUTE_NAME = "Movement";

	@Constant
	String MOVEMENT_ATTRIBUTE_ICON_PATH = ATTRIBUTE_ASSETS_PATH + "movement_icon.png";

	@Constant
	Integer MOVEMENT_ATTRIBUTE_GRID_X = 1;

	@Constant
	Integer MOVEMENT_ATTRIBUTE_GRID_Y = 3;

	// Energy-Attribute ---------------------------------------------------------------------------------------------

	@Constant
	String ENERGY_ATTRIBUTE_NAME = "Energy";

	@Constant
	String ENERGY_ATTRIBUTE_ICON_PATH = ATTRIBUTE_ASSETS_PATH + "energy_icon.png";

	@Constant
	Integer ENERGY_ATTRIBUTE_GRID_X = 2;

	@Constant
	Integer ENERGY_ATTRIBUTE_GRID_Y = 1;

	// Grenade-Amount-Attribute --------------------------------------------------------------------------------------

	@Constant
	String GRENADE_AMOUNT_ATTRIBUTE_NAME = "G.-Amount";

	@Constant
	String GRENADE_AMOUNT_ATTRIBUTE_ICON_PATH = ATTRIBUTE_ASSETS_PATH + "grenade_icon.png";

	@Constant
	Integer GRENADE_AMOUNT_ATTRIBUTE_GRID_X = 0;

	@Constant
	Integer GRENADE_AMOUNT_ATTRIBUTE_GRID_Y = 2;

	// Grenade-Range-Attribute ---------------------------------------------------------------------------------------

	@Constant
	String GRENADE_RANGE_ATTRIBUTE_NAME = "G.-Range";

	@Constant
	String GRENADE_RANGE_ATTRIBUTE_ICON_PATH = ATTRIBUTE_ASSETS_PATH + "grenade_icon.png";

	@Constant
	Integer GRENADE_RANGE_ATTRIBUTE_GRID_X = 1;

	@Constant
	Integer GRENADE_RANGE_ATTRIBUTE_GRID_Y = 2;

	// Dodge-Attribute -----------------------------------------------------------------------------------------------

	@Constant
	String DODGE_ATTRIBUTE_NAME = "DODGE";

	@Constant
	String DODGE_ATTRIBUTE_ICON_PATH = ATTRIBUTE_ASSETS_PATH + "dodge_icon.png";

	@Constant
	Integer DODGE_ATTRIBUTE_GRID_X = 2;

	@Constant
	Integer DODGE_ATTRIBUTE_GRID_Y = 2;

}
