package me.vault.game.utility.constant;


import me.vault.game.model.currency.CurrencyTransaction;
import me.vault.game.model.energy.impl.DodgeAbility;
import me.vault.game.model.energy.impl.InitiativeAbility;
import me.vault.game.model.energy.impl.MeleeAbility;

import static me.vault.game.utility.constant.ConstantInterface.Constant;
import static me.vault.game.utility.constant.GameConstants.ASSETS_PATH;


/**
 * This interface provides constants which contain information about the energy abilities of the game.
 * The interface uses the {@link ConstantInterface} annotation which is a marker annotation for interfaces that only contain constants.
 *
 * @author Vincent Wolf, Lasse-Leander Hillen, Timothy Hoegen-Jupp, Alexander Goethel
 * @version 1.0.0
 * @since 30.05.2024
 */
@ConstantInterface
public interface EnergyConstants
{

	/**
	 * The default multiplier for the buffs of the different energy abilities.
	 */
	@Constant
	double DEFAULT_MULTIPLIER = 1.0D;

	/**
	 * The multiplier for the high buffs of the different energy abilities.
	 */
	@Constant
	double HIGH_MULTIPLIER = 1.25D;

	/**
	 * The maximum multiplier the buffs of the different energy abilities can reach.
	 */
	@Constant
	double MAXIMUM_MULTIPLIER = 1.5D;


	/**
	 * This interface provides constants which contain information about the {@link DodgeAbility} of the game.
	 * The interface uses the {@link ConstantInterface} annotation which is a marker annotation for interfaces that only contain constants.
	 *
	 * @author Vincent Wolf, Lasse-Leander Hillen, Timothy Hoegen-Jupp, Alexander Goethel
	 * @version 1.0.0
	 * @since 30.05.2024
	 */
	@ConstantInterface
	interface Dodge
	{

		/**
		 * The standard/base name of the {@link DodgeAbility}.
		 */
		@Constant
		String BASE_NAME = "Dodge Ability";

		/**
		 * The name of the improved {@link DodgeAbility}.
		 */
		@Constant
		String IMPROVED_NAME = "Improved Dodge Ability";

		/**
		 * The path to the standard/base sprite of the {@link DodgeAbility}.
		 */
		@Constant
		String BASE_SPRITE_PATH = ASSETS_PATH + "energy/dodge_energyability.png";

		/**
		 * The path to the sprite of the improved sprite of the {@link DodgeAbility}.
		 */
		@Constant
		String IMPROVED_SPRITE_PATH = ASSETS_PATH + "energy/dodge_energyability.png";

		/**
		 * The upgrade cost from the base version of the {@link DodgeAbility} to the improved version.
		 */
		@Constant
		CurrencyTransaction BASE_TO_IMPROVED_UPGRADE_COSTS = new CurrencyTransaction(-1000, -1000, -1000, -1000, -1000);

		/**
		 * The upgrade cost for every upgrade past the improved version of the {@link DodgeAbility}.
		 */
		@Constant
		CurrencyTransaction IMPROVED_TO_NONE_UPGRADE_COSTS = CurrencyTransaction.EMPTY;

	}


	/**
	 * This interface provides constants which contain information about the {@link InitiativeAbility} of the game.
	 * The interface uses the {@link ConstantInterface} annotation which is a marker annotation for interfaces that only contain constants.
	 *
	 * @author Vincent Wolf, Lasse-Leander Hillen, Timothy Hoegen-Jupp, Alexander Goethel
	 * @version 1.0.0
	 * @since 30.05.2024
	 */
	@ConstantInterface
	interface Initiative
	{

		/**
		 * The standard/base name of the {@link InitiativeAbility}.
		 */
		@Constant
		String BASE_NAME = "Initiative Ability";

		/**
		 * The name of the improved {@link InitiativeAbility}.
		 */
		@Constant
		String IMPROVED_NAME = "Improved Initiative Ability";

		/**
		 * The path to the standard/base sprite of the {@link InitiativeAbility}.
		 */
		@Constant
		String BASE_SPRITE_PATH = ASSETS_PATH + "energy/initiative_energyabiltiy.png";

		/**
		 * The path to the sprite of the improved sprite of the {@link InitiativeAbility}.
		 */
		@Constant
		String IMPROVED_SPRITE_PATH = ASSETS_PATH + "energy/initiative_energyabiltiy.png";

		/**
		 * The upgrade cost from the base version of the {@link InitiativeAbility} to the improved version.
		 */
		@Constant
		CurrencyTransaction BASE_TO_IMPROVED_UPGRADE_COSTS = new CurrencyTransaction(-1000, -1000, -1000, -1000, -1000);

		/**
		 * The upgrade cost for every upgrade past the improved version of the {@link InitiativeAbility}.
		 */
		@Constant
		CurrencyTransaction IMPROVED_TO_NONE_UPGRADE_COSTS = CurrencyTransaction.EMPTY;

	}


	/**
	 * This interface provides constants which contain information about the {@link MeleeAbility} of the game.
	 * The interface uses the {@link ConstantInterface} annotation which is a marker annotation for interfaces that only contain constants.
	 *
	 * @author Vincent Wolf, Lasse-Leander Hillen, Timothy Hoegen-Jupp, Alexander Goethel
	 * @version 1.0.0
	 * @since 30.05.2024
	 */
	@ConstantInterface
	interface Melee
	{

		/**
		 * The standard/base name of the {@link MeleeAbility}.
		 */
		@Constant
		String BASE_NAME = "Melee Ability";

		/**
		 * The name of the improved {@link MeleeAbility}.
		 */
		@Constant
		String IMPROVED_NAME = "Improved Melee Ability";

		/**
		 * The path to the standard/base sprite of the {@link MeleeAbility}.
		 */
		@Constant
		String BASE_SPRITE_PATH = ASSETS_PATH + "energy/melee_energyability.png";

		/**
		 * The path to the sprite of the improved sprite of the {@link MeleeAbility} .
		 */
		@Constant
		String IMPROVED_SPRITE_PATH = ASSETS_PATH + "energy/melee_energyability.png";

		/**
		 * The upgrade cost from the base version of the {@link MeleeAbility} to the improved version.
		 */
		@Constant
		CurrencyTransaction BASE_TO_IMPROVED_UPGRADE_COSTS = new CurrencyTransaction(-1000, -1000, -1000, -1000, -1000);

		/**
		 * The upgrade cost for every upgrade past the improved version of the {@link MeleeAbility}.
		 */
		@Constant
		CurrencyTransaction IMPROVED_TO_NONE_UPGRADE_COSTS = CurrencyTransaction.EMPTY;

	}

}