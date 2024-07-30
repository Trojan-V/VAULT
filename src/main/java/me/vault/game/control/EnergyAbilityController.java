package me.vault.game.control;


import javafx.application.Platform;
import me.vault.game.interfaces.Upgrader;
import me.vault.game.model.currency.Currency;
import me.vault.game.model.energy.AbilityMultiplier;
import me.vault.game.model.energy.Energy;
import me.vault.game.model.energy.EnergyLevel;
import me.vault.game.utility.logging.ILogger;
import me.vault.game.utility.logging.Logger;
import me.vault.game.utility.struct.UpgradeRunnable;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

import static me.vault.game.utility.constant.LoggingConstants.CityBuildingController.UPGRADING;
import static me.vault.game.utility.constant.LoggingConstants.*;
import static me.vault.game.utility.logging.ILogger.Level.DEBUG;


/**
 * This class contains any methods that are responsible for controlling all the logic that's related to energy
 * ability`s.
 * <br>
 * Currently, it's responsible for upgrading the artifacts to the next level.
 * @author Alexander Goethel, Vincent Wolf
 * @version 1.0.0
 * @see Upgrader
 * @see Energy
 * @see EnergyLevel
 * @since 25.07.2024
 */
public final class EnergyAbilityController implements Upgrader<Energy, EnergyLevel>
{
	/**
	 * Singleton instance, as there's no reason to have more than one {@link EnergyAbilityController}.
	 * <br>
	 * Instead of using a singleton, the entire class could've been created using solely static methods and fields.
	 */
	private static final EnergyAbilityController INSTANCE = new EnergyAbilityController();


	/**
	 * The {@link Logger} object for this class used for writing to the console.
	 */
	private static final ILogger LOGGER = new Logger(EnergyAbilityController.class.getSimpleName());


	/**
	 * As this class is a singleton, no other class should be able to instantiate it.
	 * <br>
	 * To prohibit the instantiation from anywhere else but within the class, a private constructor is used.
	 */
	private EnergyAbilityController ()
	{
	}


	/**
	 * Returns the singleton instance of this class.
	 *
	 * @return The singleton instance of this class.
	 * @pre.condition The singleton Instance exists.
	 * @post.condition The singleton Instance can be accessed in the program.
	 */
	public static EnergyAbilityController getInstance ()
	{
		return INSTANCE;
	}


	/**
	 * Updates the values within the energy ability to the new values of the new level.
	 * <br>
	 * This method should be invoked every time after the energy ability was upgraded.
	 *
	 * @param energy The instance of the {@link Energy} that was upgraded.
	 * @pre.condition Energy ability values are not the maximal level.
	 * @post.condition The values of the energy ability are updated to the value of the new level.
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
	 * @pre.condition The energy ability exists.
	 * @post.condition Gives back if the energy ability is upgradeable.
	 */
	@Override
	public boolean checkIsUpgradable (final @NotNull Energy energy)
	{
		// Checks if the energy ability is already at the maximum level. If yes, it can't be upgraded any further.
		if (energy.getIsMaxLevelProperty().get())
		{
			return false;
		}

		// Checks if the user has enough of each required currency to purchase the upgrade. If the amount of at least
		// one currency isn't enough, the energy ability can't be upgraded.
		for (final Currency currency : Currency.values())
		{
			if (currency.getAmount() < energy.getUpgradeCosts().getAbsoluteAmount(currency))
			{
				return false;
			}
		}
		return energy.getLevel().ordinal() < EnergyLevel.getMaximum().ordinal();
	}


	/**
	 * {@inheritDoc}
	 *
	 * @param energy The {@link Energy} instance that gets upgraded.
	 * @pre.condition The energy ability exists and can be upgraded.
	 * @post.condition The instance of the energy ability gets upgraded.
	 */
	@Override
	public void upgrade (final Energy energy)
	{
		LOGGER.logf(ILogger.Level.NORMAL, UPGRADING, energy.getName(), energy.getLevel(), energy.getLevel().getNextHigherLevel());
		Platform.runLater(new UpgradeRunnable(energy, getInstance()));
	}

}