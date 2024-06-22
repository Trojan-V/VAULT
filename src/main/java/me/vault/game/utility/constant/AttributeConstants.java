package me.vault.game.utility.constant;


import static me.vault.game.utility.constant.ConstantInterface.Constant;
import static me.vault.game.utility.constant.GameConstants.ASSETS_PATH;


@ConstantInterface
public interface AttributeConstants
{

	@Constant
	String ATTRIBUTE_ASSETS_PATH = ASSETS_PATH + "attributes/";

	@Constant
	String HEALTH_ATTRIBUTE_NAME = "Health";

	@Constant
	String HEALTH_ATTRIBUTE_ICON_PATH = ATTRIBUTE_ASSETS_PATH + "health_icon.png";

	@Constant
	String MELEE_ATTRIBUTE_NAME = "M.-Damage";

	@Constant
	String MELEE_ATTACK_ATTRIBUTE_ICON_PATH = ATTRIBUTE_ASSETS_PATH + "melee_attack_icon.png";

	@Constant
	String GRENADE_ATTACK_ATTRIBUTE_NAME = "G.-Damage";

	@Constant
	String GRENADE_ATTACK_ATTRIBUTE_ICON_PATH = ATTRIBUTE_ASSETS_PATH + "range_attack_icon.png";

	@Constant
	String ARMOR_ATTRIBUTE_NAME = "Armor";

	@Constant
	String ARMOR_ATTRIBUTE_ICON_PATH = ATTRIBUTE_ASSETS_PATH + "armor_icon.png";

	@Constant
	String INITIATIVE_ATTRIBUTE_NAME = "Initiative";

	@Constant
	String INITIATIVE_ATTRIBUTE_ICON_PATH = ATTRIBUTE_ASSETS_PATH + "initiative_icon.png";

	@Constant
	String RESISTANCE_ATTRIBUTE_NAME = "Resistance";

	@Constant
	String RESISTANCE_ATTRIBUTE_ICON_PATH = ATTRIBUTE_ASSETS_PATH + "resistance_icon.png";

	@Constant
	String MOVEMENT_ATTRIBUTE_NAME = "Movement";

	@Constant
	String MOVEMENT_ATTRIBUTE_ICON_PATH = ATTRIBUTE_ASSETS_PATH + "movement_icon.png";

	@Constant
	String ENERGY_ATTRIBUTE_NAME = "Energy";

	@Constant
	String ENERGY_ATTRIBUTE_ICON_PATH = ATTRIBUTE_ASSETS_PATH + "energy_icon.png";

	@Constant
	String GRENADE_AMOUNT_ATTRIBUTE_NAME = "G.-Amount";

	@Constant
	String GRENADE_AMOUNT_ATTRIBUTE_ICON_PATH = ATTRIBUTE_ASSETS_PATH + "grenade_icon.png";

	@Constant
	String GRENADE_RANGE_ATTRIBUTE_NAME = "G.-Range";

	@Constant
	String GRENADE_RANGE_ATTRIBUTE_ICON_PATH = ATTRIBUTE_ASSETS_PATH + "grenade_icon.png";

	@Constant
	String DODGE_ATTRIBUTE_NAME = "DODGE";

	@Constant
	String DODGE_ATTRIBUTE_ICON_PATH = ATTRIBUTE_ASSETS_PATH + "dodge_icon.png";

}
