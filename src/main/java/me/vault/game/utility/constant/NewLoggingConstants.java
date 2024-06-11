package me.vault.game.utility.constant;

/**
 * Description
 *
 * @author Vincent Wolf
 * @version 1.0.0
 * @see
 * @since 06.06.2024
 */
public interface NewLoggingConstants
{
	String STATIC_INITIALIZER_ENTERED = "The static initializer of {0} was entered.";

	String STATIC_INITIALIZER_LEFT = "The static initializer of {0} was left.";

	String INITIALIZER_ENTERED = "The static initializer of {0} was entered.";

	String INITIALIZER_LEFT = "The static initializer of {0} was left.";

	String CONSTRUCTOR_ENTERED = "The constructor of {0} was entered.";

	String CONSTRUCTOR_LEFT = "The constructor of {0} was left.";

	String METHOD_ENTERED = "The method {0} was entered.";

	String METHOD_LEFT = "The method {0} was left.";

	String LEVEL_SET = "currentLevel was set to: {0}";

	String RETURNING_TRUE = "Returning true.";

	String RETURNING_FALSE = "Returning false.";

	String UPGRADE_COST_SET = "currentUpgradeCost was set to: {0}";

	String UPGRADE_COST = "Upgrade costs: {0}";

	String SPRITE_PROPERTY_SET = "spriteProperty was set to: {0}";

	String NAME_PROPERTY_SET = "nameProperty was set to: {0}";

	String INSUFFICIENT_CURRENCY_AMOUNT = "Not enough {0} to perform the requested upgrade. Cost: {1} {0}";

	interface Artifact
	{
		String ATTRIBUTE_MODIFIERS_SET = "attributeModifiers was set to: {0}";

		String NAME_MAP_SET = "Map of names was set to: {0}";

		String SPRITE_MAP_SET = "Map of sprites was set to: {0}";

		String UPGRADE_COST_MAP_SET = "Map of upgrade cost was set to: {0}";

		String MODIFIERS_MAP_SET = "Map of attribute modifiers was set to: {0}";

		String ARTIFACT_MAXED = "The artifact {0} is maxed, can't upgrade any further.";

		String ARTIFACT_IS_LOWEST = "The artifact {0} is at the lowest level.";

		String CURRENT_ARTIFACT_LEVEL = "Current artifact level: {0}";

		String UPGRADED_ARTIFACT_LEVEL = "Upgraded the artifact to the level: {0}";

	}

}
