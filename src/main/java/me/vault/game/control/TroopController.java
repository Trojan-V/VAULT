package me.vault.game.control;


import javafx.application.Platform;
import me.vault.game.model.city.CityBuildingLevel;
import me.vault.game.model.city.implementation.TrainingFacility;
import me.vault.game.model.currency.Currency;
import me.vault.game.model.troop.Troop;
import me.vault.game.model.troop.TroopLevel;
import me.vault.game.model.troop.TroopStatistics;
import me.vault.game.utility.concurrency.UpgradeRunnable;
import me.vault.game.utility.interfaces.Upgrader;
import me.vault.game.view.city.building.TrainingFacilityDelegate;

import static me.vault.game.model.troop.TroopStatistics.*;

// TODO: Pre und post


/**
 * Controller class to handle all different actions related to troops.
 * <br>
 * For instance, this class contains update methods so the values of troops can be updated after they've been
 * upgraded to the next level. It's important that these methods actually get called after the upgrade, as otherwise
 * no changes will actually happen, neither in the model nor in the GUI.
 * <br>
 * Additionally, this controller provides methods to create the required GUI elements to display the
 * {@link TrainingFacility} accordingly.
 *
 * @author Vincent Wolf, Lasse-Leander Hillen, Timothy Hoegen-Jupp, Alexander Goethel
 * @version 1.0.0
 * @see TrainingFacility
 * @see TrainingFacilityDelegate
 * @see TroopStatistics
 * @since 29.07.2024
 */
public final class TroopController implements Upgrader<Troop, TroopLevel>
{

	/**
	 * Singleton instance, as there's no reason to have more than one {@link TroopController}.
	 * <br>
	 * Instead of using a singleton, the entire class could've been created using solely static methods and fields.
	 */
	private static final TroopController INSTANCE = new TroopController();


	/**
	 * As this class is a singleton, no other class should be able to instantiate it.
	 * To prohibit the instantiation from anywhere else but within the class, a private constructor is used.
	 *
	 * @precondition Constructor gets called from within the class
	 * @postcondition A new instance of TroopController is created.
	 */
	private TroopController () {}


	/**
	 * Returns the singleton instance of this class.
	 *
	 * @return The singleton instance of this class.
	 *
	 * @precondition The singleton Instance exists.
	 * @postcondition The singleton Instance of this class has been returned.
	 */
	public static TroopController getInstance ()
	{
		return INSTANCE;
	}


	/**
	 * This method updates the {@link Dexterity} statistics by grabbing the {@link TroopLevel} from the supplied
	 * {@link Troop} and then grabbing the {@link Dexterity} statistics that correspond to the {@link TroopLevel}.
	 * <br>
	 * This method should always be invoked after a {@link Troop} was upgraded.
	 * <br>
	 * It would be more convenient to simply replace the entire {@link Dexterity} instance as soon as the statistics
	 * change, but that's not possible due to JavaFX property binding regulations, as the property, which was
	 * previously bound to the GUI, would be replaced entirely if the instance that contains the property gets
	 * replaced with another instance.
	 * <br>
	 * Therefore, it's required to disassemble the {@link Dexterity} instances, grab the internal data from them and
	 * change the internal accordingly to ensure the properties are still bound to the GUI.
	 *
	 * @param troop The {@link Troop} whose dexterity statistics should be updated.
	 *
	 * @precondition The {@link Dexterity} instance exists and can be upgraded.
	 * @postcondition The {@link Dexterity} instances gets upgraded.
	 */
	private static void updateDexterityStatistics (final Troop troop)
	{
		final Dexterity dexterityStats = troop.getStatistics().getDexterity();
		final Dexterity newDexterityStats = troop.getStatistics(troop.getLevel()).getDexterity();

		dexterityStats.setInitiative(newDexterityStats.getInitiativePoints());
		dexterityStats.setMovementTiles(newDexterityStats.getMovementTiles());
	}


	/**
	 * This method updates the {@link Defensive} statistics by grabbing the {@link TroopLevel} from the supplied
	 * {@link Troop} and then grabbing the {@link Defensive} statistics that correspond to the {@link TroopLevel}.
	 * <br>
	 * This method should always be invoked after a {@link Troop} was upgraded.
	 * <br>
	 * It would be more convenient to simply replace the entire {@link Defensive} instance as soon as the statistics
	 * change, but that's not possible due to JavaFX property binding regulations, as the property, which was
	 * previously bound to the GUI, would be replaced entirely if the instance that contains the property gets
	 * replaced with another instance.
	 * <br>
	 * Therefore, it's required to disassemble the {@link Defensive} instances, grab the internal data from them and
	 * change the internal accordingly to ensure the properties are still bound to the GUI.
	 *
	 * @param troop The {@link Troop} whose dexterity statistics should be updated.
	 *
	 * @precondition The {@link Defensive} instance exists and can be upgraded.
	 * @postcondition The {@link Defensive} instances gets upgraded.
	 */
	private static void updateDefensiveStatistics (final Troop troop)
	{
		final Defensive defenseStats = troop.getStatistics().getDefensive();
		final Defensive newDefenseStats = troop.getStatistics(troop.getLevel()).getDefensive();

		defenseStats.setArmor(newDefenseStats.getArmor());
		defenseStats.setDodgeRate(newDefenseStats.getDodgeRate());
		defenseStats.setHealth(newDefenseStats.getHealth());
		defenseStats.setResistance(newDefenseStats.getResistance());
	}


	/**
	 * This method updates the {@link Offensive} statistics by grabbing the {@link TroopLevel} from the supplied
	 * {@link Troop} and then grabbing the {@link Offensive} statistics that correspond to the {@link TroopLevel}.
	 * <br>
	 * This method should always be invoked after a {@link Troop} was upgraded.
	 * <br>
	 * It would be more convenient to simply replace the entire {@link Offensive} instance as soon as the statistics
	 * change, but that's not possible due to JavaFX property binding regulations, as the property, which was
	 * previously bound to the GUI, would be replaced entirely if the instance that contains the property gets
	 * replaced with another instance.
	 * <br>
	 * Therefore, it's required to disassemble the {@link Offensive} instances, grab the internal data from them and
	 * change the internal accordingly to ensure the properties are still bound to the GUI.
	 *
	 * @param troop The {@link Troop} whose dexterity statistics should be updated.
	 *
	 * @precondition The {@link Offensive} instance exists and can be upgraded.
	 * @postcondition The {@link Offensive} instances gets upgraded.
	 */
	private static void updateOffensiveStatistics (final Troop troop)
	{
		final Offensive offensiveStats = troop.getStatistics().getOffensive();
		final Offensive newOffensiveStats = troop.getStatistics(troop.getLevel()).getOffensive();

		offensiveStats.setEnergyPoints(newOffensiveStats.getEnergyPoints());
		offensiveStats.setGrenadeAmount(newOffensiveStats.getGrenadeAmount());
		offensiveStats.setGrenadeDamage(newOffensiveStats.getGrenadeDamage());
		offensiveStats.setGrenadeRange(newOffensiveStats.getGrenadeRange());
		offensiveStats.setMeleeDamage(newOffensiveStats.getMeleeDamage());
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public void upgrade (final Troop troop)
	{
		Platform.runLater(new UpgradeRunnable(troop, getInstance()));
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean checkIsUpgradable (final Troop troop)
	{
		if (troop.getIsMaxLevelProperty().get())
		{
			return false;
		}
		for (final Currency currency : Currency.values())
		{
			if (currency.getAmount() < troop.getUpgradeCosts().getAbsoluteAmount(currency))
			{
				return false;
			}
		}
		return troop.getLevel().ordinal() < CityBuildingLevel.getMaximum().ordinal();
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updateValues (final Troop troop)
	{
		troop.setIsMaxLevel(troop.getLevel() == TroopLevel.getMaximum());

		troop.setName(troop.getName(troop.getLevel()));
		troop.setSprite(troop.getSprite(troop.getLevel()));
		troop.setUpgradeCosts(troop.getUpgradeCosts(troop.getLevel()));

		updateOffensiveStatistics(troop);
		updateDexterityStatistics(troop);
		updateDefensiveStatistics(troop);
	}

}
