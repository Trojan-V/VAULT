package me.vault.game.utility.constant;


import me.vault.game.model.currency.CurrencyTransaction;
import me.vault.game.model.energy.DefensivStatistic;
import me.vault.game.model.energy.DexterityEnergyStatistic;
import me.vault.game.model.energy.EnergyAbilityStatistic;
import me.vault.game.model.energy.OffensiveEnergyStatistic;
import me.vault.game.utility.loading.ResourceLoader;
import me.vault.game.utility.struct.MetaDataImage;


public interface EnergyAbilityConstants
{

	/**
 * The {@link TroopConstants.Sniper} subinterface contains all constants, which apply to the Sniper troop class.
 *
 * @author Alexander Göthel
 * @see me.vault.game.model.troop.impl.Sniper
 * @see me.vault.game.model.energy.EnergyAbility
 * @since 25.06.2024
 */
@ConstantInterface
interface AcidGrenade
{

	/**
	 * A constant which represents the base name of the acid grenade energy ability.
	 */
	@ConstantInterface.Constant
	String RUDIMENTARY_NAME = "Rudimentary acid grenade";

	/**
	 * A constant which represents the name of the improved acid grenade energy ability.
	 */
	@ConstantInterface.Constant
	String ADVANCED_NAME = "Advanced acid grenade";

	/**
	 * A constant which represents the name of the maxed acid grenade energy ability.
	 */
	@ConstantInterface.Constant
	String SOPHISTICATED_NAME = "Sophisticated acid grenade";

	/**
	 * A constant which represents the base sprite of the acid grenade energy ability.
	 */
	@ConstantInterface.Constant
	MetaDataImage RUDIMENTARY_SPRITE = ResourceLoader.loadImage(GameConstants.ASSETS_PATH + "troops/sniper_icon.png");

	/**
	 * A constant which represents the sprite of the improved acid grenade energy ability.
	 */
	@ConstantInterface.Constant
	MetaDataImage ADVANCED_SPRITE = ResourceLoader.loadImage(GameConstants.ASSETS_PATH + "troops/sniper_icon.png");

	/**
	 * A constant which represents the sprite of the maxed acid grenade energy ability.
	 */
	@ConstantInterface.Constant
	MetaDataImage SOPHISTICATED_SPRITE = ResourceLoader.loadImage(GameConstants.ASSETS_PATH + "troops/sniper_icon.png");

	/**
	 * A constant which represents the base upgrade cost of the acid grenade energy ability.
	 */
	@ConstantInterface.Constant
	CurrencyTransaction RUDIMENTARY_UPGRADE_COST = new CurrencyTransaction(-100, -100, -100, -100, -100);

	/**
	 * A constant which represents the upgrade cost of the improved acid grenade energy ability.
	 */
	@ConstantInterface.Constant
	CurrencyTransaction ADVANCED_UPGRADE_COST = new CurrencyTransaction(-150, -150, -150, -150, -150);

	/**
	 * A constant which represents the upgrade cost of the maxed acid grenade energy ability.
	 */
	@ConstantInterface.Constant
	CurrencyTransaction SOPHISTICATED_UPGRADE_COST = CurrencyTransaction.EMPTY;

	/**
	 * A constant which represents the attributes of the acid grenade energy ability.
	 */
	@ConstantInterface.Constant
	EnergyAbilityStatistic ACID_GRENADE_STATISTIC = new EnergyAbilityStatistic(
		new DexterityEnergyStatistic(0, 0),
		new DefensivStatistic( 0,0, -10),
		new OffensiveEnergyStatistic( 0));

}
}
