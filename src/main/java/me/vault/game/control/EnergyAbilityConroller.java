package me.vault.game.control;


import javafx.application.Platform;

import me.vault.game.interfaces.Upgrader;

import me.vault.game.model.currency.Currency;
import me.vault.game.model.currency.CurrencyTransaction;
import me.vault.game.model.energy.*;

import me.vault.game.utility.logging.ILogger;
import me.vault.game.utility.logging.Logger;
import me.vault.game.utility.struct.UpgradeRunnable;

import java.util.Map;


import static me.vault.game.utility.constant.LoggingConstants.*;

import static me.vault.game.utility.constant.LoggingConstants.Artifact.ENERGY_MAXED;
import static me.vault.game.utility.constant.LoggingConstants.CityBuildingController.UPGRADING;
import static me.vault.game.utility.constant.LoggingConstants.RETURNING_TRUE;
import static me.vault.game.utility.logging.ILogger.Level.DEBUG;

/**
 * @author Alexander Göthel
 * @version 1.0.0
 * @see Upgrader
 * @see Energy
 * @see EnergyLevel
 * @since 25.07.2024
 */

public class EnergyAbilityConroller implements Upgrader<Energy, EnergyLevel>
{

	/**
	 * Singleton instance, as there's no reason to have more than one {@link EnergyAbilityConroller}.
	 * <br>
	 * Instead of using a singleton, the entire class could've been created using solely static methods and fields.
	 */
	private static final EnergyAbilityConroller INSTANCE = new EnergyAbilityConroller();


	/**
	 * The {@link Logger} object for this class used for writing to the console.
	 */
	private static final ILogger LOGGER = new Logger(EnergyAbilityConroller.class.getSimpleName());


	/**
	 * As this class is a singleton, no other class should be able to instantiate it.
	 * <br>
	 * To prohibit the instantiation from anywhere else but within the class, a private constructor is used.
	 */
	private EnergyAbilityConroller ()
	{}


	/**
	 * Checks if the supplied energy ability is at the maximum level. If yes, true is returned, otherwise false.
	 *
	 * @param energy The instance of {@link Energy} which is checked.
	 *
	 * @return True if the energy ability is maxed, otherwise false.
	 */
	private static boolean checkIsEnergyMaxed (final Energy energy)
	{
		return energy.getLevel() == EnergyLevel.getMaximum();
	}


	/**
	 * Returns the singleton instance of this class.
	 *
	 * @return The singleton instance of this class.
	 */
	public static EnergyAbilityConroller getInstance ()
	{
		return INSTANCE;
	}


	/**
	 * Updates the values within the energy ability to the new values of the new level.
	 * <br>
	 * This method should be invoked every time after the energy ability was upgraded.
	 *
	 * @param energy The instance of the {@link Energy} that was upgraded.
	 */
	@Override
	public void updateValues (final Energy energy)
	{
		if (energy.getLevel() == EnergyLevel.getMaximum())
		{
			energy.setIsMaxLevel(true);
		}

		energy.setName(energy.getName(energy.getLevel()));
		energy.setSprite(energy.getSprite(energy.getLevel()));
		energy.setUpgradeCosts(energy.getUpgradeCosts(energy.getLevel()));

		final Map<AbilityMultiplier.Type, Double> abilityMultipliersMap = energy.getAbilityMultipliers(energy.getLevel());
		final AbilityMultiplier currentAbilityMultipliers = energy.getAbilityMultiplier();

		currentAbilityMultipliers.setDodgeMultiplier(abilityMultipliersMap.get(AbilityMultiplier.Type.DODGE));
		currentAbilityMultipliers.setInitiativeMultiplier(abilityMultipliersMap.get(AbilityMultiplier.Type.INITIATIVE));
		currentAbilityMultipliers.setMeleeMultiplier(abilityMultipliersMap.get(AbilityMultiplier.Type.MELEE));

		// Logging output
		LOGGER.logf(DEBUG, NAME_PROPERTY_SET, energy.getNameProperty().get());
		LOGGER.logf(DEBUG, SPRITE_PROPERTY_SET, energy.getSpriteProperty().get().toString());
		LOGGER.logf(DEBUG, UPGRADE_COST_SET, energy.getUpgradeCosts().toString());
	}


	/**
	 * {@inheritDoc}
	 *
	 * @param energy The {@link Energy} instance which is checked if it can be upgraded to the next level.
	 *
	 * @return True if the {@link Energy} can be upgraded, otherwise false.
	 */
	@Override
	public boolean checkIsUpgradable (final Energy energy)
	{
		// Checks if the energy ability is already at the maximum level. If yes, it can't be upgraded any further.
		if (checkIsEnergyMaxed(energy))
		{
			LOGGER.logf(DEBUG, ENERGY_MAXED, energy.getName());
			LOGGER.log(DEBUG, RETURNING_FALSE);
			return false;
		}

		final CurrencyTransaction upgradeCosts = energy.getUpgradeCosts();
		LOGGER.logf(DEBUG, UPGRADE_COST, upgradeCosts.toString());


		// Checks if the user has enough of each required currency to purchase the upgrade. If the amount of at least
		// one currency isn't enough, the artifact can't be upgraded.
		for (final Currency currency : Currency.values())
		{
			if (currency.getAmount() < upgradeCosts.getAbsoluteAmount(currency))
			{
				LOGGER.logf(DEBUG, INSUFFICIENT_CURRENCY_AMOUNT, currency.name(), upgradeCosts.getAmount(currency));
				LOGGER.log(DEBUG, RETURNING_FALSE);
				return false;
			}
		}
		// If all checks are passed, the method returns true.
		LOGGER.log(DEBUG, RETURNING_TRUE);
		return true;
	}


	/**
	 * {@inheritDoc}
	 *
	 * @param energy The {@link Energy} instance that gets upgraded.
	 */
	@Override
	public void upgrade (final Energy energy)
	{
		LOGGER.logf(ILogger.Level.NORMAL, UPGRADING, energy.getName(), energy.getLevel(),
			energy.getLevel().getNextHigherLevel());
		Platform.runLater(new UpgradeRunnable(energy, getInstance()));
	}

}
