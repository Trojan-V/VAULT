package me.vault.game.control;


import javafx.application.Platform;
import javafx.scene.layout.GridPane;
import me.vault.game.interfaces.Upgrader;
import me.vault.game.model.building.CityBuildingLevel;
import me.vault.game.model.city.TrainingFacility;
import me.vault.game.model.currency.Currency;
import me.vault.game.model.troop.Troop;
import me.vault.game.model.troop.TroopLevel;
import me.vault.game.model.troop.TroopStatistics;
import me.vault.game.utility.fx.SingleStatisticHBox;
import me.vault.game.utility.struct.UpgradeRunnable;
import me.vault.game.view.city.building.TrainingFacilityDelegate;

import static me.vault.game.model.troop.TroopStatistics.*;
import static me.vault.game.utility.constant.AttributeConstants.*;


/**
 * Controller class to handle all different actions related to troops.
 * <br>
 * For instance, this class contains update methods so the values of troops can be updated after they have been
 * upgraded to the next level. It's important that these methods actually get called after the upgrade, as otherwise
 * no changes will actually happen, neither in the model nor in the GUI.
 * <br>
 * Additionally, this controller provides methods to create the required GUI elements to display the
 * {@link TrainingFacility} accordingly.
 *
 * @author Vincent Wolf
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
	 * Represents the spacing of the troop attributes in the attribute grid pane.
	 */
	private static final int ATTRIBUTE_SPACING = 10;


	/**
	 * As this class is a singleton, no other class should be able to instantiate it.
	 * To prohibit the instantiation from anywhere else but within the class, a private constructor is used.
	 */
	private TroopController () {}


	/**
	 * Returns the singleton instance of this class.
	 *
	 * @return The singleton instance of this class.
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
	 * Creates the {@link GridPane} that displays the attributes of the {@link Troop} within the
	 * {@link TrainingFacility}.
	 *
	 * @param troop The {@link Troop} for which the {@link GridPane} will be created.
	 *
	 * @return The {@link GridPane} which was created.
	 */
	public static GridPane createAttributeGridPane (final Troop troop)
	{
		final GridPane attributeGridPane = new GridPane();
		attributeGridPane.setVgap(ATTRIBUTE_SPACING);
		attributeGridPane.setHgap(ATTRIBUTE_SPACING);

		addDexterityStatistics(troop, attributeGridPane);
		addDefensiveStatistics(troop, attributeGridPane);
		addOffensiveStatistics(troop, attributeGridPane);

		return attributeGridPane;
	}


	/**
	 * Adds the statistics found in the {@link Dexterity} instance of the {@link Troop} to the {@link GridPane}.
	 *
	 * @param troop    The {@link Troop} for which the {@link GridPane} is getting created.
	 * @param gridPane The {@link GridPane} which contains the graphically displayable information.
	 */
	private static void addDexterityStatistics (final Troop troop, final GridPane gridPane)
	{
		final Dexterity dexterity = troop.getStatistics().getDexterity();

		gridPane.add(new SingleStatisticHBox(MOVEMENT_ATTRIBUTE_ICON_PATH, MOVEMENT_ATTRIBUTE_NAME, dexterity.getMovementTileProperty()), MOVEMENT_ATTRIBUTE_GRID_X, MOVEMENT_ATTRIBUTE_GRID_Y);

		gridPane.add(new SingleStatisticHBox(INITIATIVE_ATTRIBUTE_ICON_PATH, INITIATIVE_ATTRIBUTE_NAME, dexterity.getInitiativeProperty()), INITIATIVE_ATTRIBUTE_GRID_X, INITIATIVE_ATTRIBUTE_GRID_Y);
	}


	/**
	 * Adds the statistics found in the {@link Defensive} instance of the {@link Troop} to the {@link GridPane}.
	 *
	 * @param troop    The {@link Troop} for which the {@link GridPane} is getting created.
	 * @param gridPane The {@link GridPane} which contains the graphically displayable information.
	 */
	private static void addDefensiveStatistics (final Troop troop, final GridPane gridPane)
	{
		final Defensive defensive = troop.getStatistics().getDefensive();

		gridPane.add(new SingleStatisticHBox(DODGE_ATTRIBUTE_ICON_PATH, DODGE_ATTRIBUTE_NAME, defensive.getDodgeRateProperty()), DODGE_ATTRIBUTE_GRID_X, DODGE_ATTRIBUTE_GRID_Y);

		gridPane.add(new SingleStatisticHBox(HEALTH_ATTRIBUTE_ICON_PATH, HEALTH_ATTRIBUTE_NAME, defensive.getHealthProperty()), HEALTH_ATTRIBUTE_GRID_X, HEALTH_ATTRIBUTE_GRID_Y);

		gridPane.add(new SingleStatisticHBox(ARMOR_ATTRIBUTE_ICON_PATH, ARMOR_ATTRIBUTE_NAME, defensive.getArmorProperty()), ARMOR_ATTRIBUTE_GRID_X, ARMOR_ATTRIBUTE_GRID_Y);

		gridPane.add(new SingleStatisticHBox(RESISTANCE_ATTRIBUTE_ICON_PATH, RESISTANCE_ATTRIBUTE_NAME, defensive.getResistanceProperty()), RESISTANCE_ATTRIBUTE_GRID_X, RESISTANCE_ATTRIBUTE_GRID_Y);
	}


	/**
	 * Adds the statistics found in the {@link Offensive} instance of the {@link Troop} to the {@link GridPane}.
	 *
	 * @param troop    The {@link Troop} for which the {@link GridPane} is getting created.
	 * @param gridPane The {@link GridPane} which contains the graphically displayable information.
	 */
	private static void addOffensiveStatistics (final Troop troop, final GridPane gridPane)
	{
		final Offensive offensive = troop.getStatistics().getOffensive();

		gridPane.add(new SingleStatisticHBox(MELEE_ATTACK_ATTRIBUTE_ICON_PATH, MELEE_ATTRIBUTE_NAME, offensive.getMeleeDamageProperty()), MELEE_ATTACK_ATTRIBUTE_GRID_X,
			MELEE_ATTACK_ATTRIBUTE_GRID_Y);

		gridPane.add(new SingleStatisticHBox(GRENADE_ATTACK_ATTRIBUTE_ICON_PATH, GRENADE_ATTACK_ATTRIBUTE_NAME, offensive.getGrenadeDamageProperty()), GRENADE_ATTACK_ATTRIBUTE_GRID_X,
			GRENADE_ATTACK_ATTRIBUTE_GRID_Y);

		gridPane.add(new SingleStatisticHBox(GRENADE_AMOUNT_ATTRIBUTE_ICON_PATH, GRENADE_AMOUNT_ATTRIBUTE_NAME, offensive.getGrenadeAmountProperty()), GRENADE_AMOUNT_ATTRIBUTE_GRID_X,
			GRENADE_AMOUNT_ATTRIBUTE_GRID_Y);

		gridPane.add(new SingleStatisticHBox(GRENADE_RANGE_ATTRIBUTE_ICON_PATH, GRENADE_RANGE_ATTRIBUTE_NAME, offensive.getGrenadeRangeProperty()), GRENADE_RANGE_ATTRIBUTE_GRID_X,
			GRENADE_RANGE_ATTRIBUTE_GRID_Y);

		gridPane.add(new SingleStatisticHBox(ENERGY_ATTRIBUTE_ICON_PATH, ENERGY_ATTRIBUTE_NAME, offensive.getEnergyPointsProperty()), ENERGY_ATTRIBUTE_GRID_X, ENERGY_ATTRIBUTE_GRID_Y);
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
