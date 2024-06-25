package me.vault.game.control;


import javafx.application.Platform;
import javafx.beans.binding.NumberExpression;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import me.vault.game.interfaces.Upgrader;
import me.vault.game.model.energy.*;
import me.vault.game.utility.loading.ResourceLoader;
import me.vault.game.utility.logging.Logger;
import me.vault.game.utility.struct.UpgradeRunnable;

import static me.vault.game.utility.constant.AttributeConstants.*;


public class EnergyAbilityConroller implements Upgrader <EnergyAbility, EnergyAbilityLevel>
{

	/**
	 * The {@link Logger} object for this class used for writing to the console.
	 */
	private static final Logger LOGGER = new Logger(EnergyAbilityConroller.class.getSimpleName());

	/**
	 * Singleton instance, as there's no reason to have more than one {@link EnergyAbilityConroller}.
	 * Instead of using a singleton, the entire class could've been created using solely static methods and fields.
	 */
	private static final EnergyAbilityConroller ENERGY_INSTANCE = new EnergyAbilityConroller();

	/**
	 * Represents the spacing of the troop attributes in the attribute grid pane.
	 */
	private static final int ATTRIBUTE_SPACING = 10;


	/**
	 * As this class is a singleton, no other class should be able to instantiate it.
	 * To prohibit the instantiation from anywhere else but within the class, a private constructor is used.
	 */
	private EnergyAbilityConroller ()
	{}


	/**
	 * Returns the singleton instance of this class.
	 *
	 * @return The singleton instance of this class.
	 */
	public static EnergyAbilityConroller getEnergyInstance ()
	{
		return ENERGY_INSTANCE;
	}


	private static void updateDexterityStatistic (final EnergyAbility energyAbility)
	{
		final DexterityEnergyStatistic dexterityStatistic = energyAbility.getStatistic().getDexterityStatistic();
		final float dexterityLevelMultiplier = energyAbility.getMultiplicationFactor().getDexterityLevelMultiplier();

		dexterityStatistic.setInitiative(dexterityStatistic.getInitiative() * dexterityLevelMultiplier);
		dexterityStatistic.setMovementTiles(dexterityStatistic.getMovementTiles() * dexterityLevelMultiplier);

	}


	private static void updateDefensiveStatistic (final EnergyAbility energyAbility)
	{
		final DefensivStatistic defensivStatistic = energyAbility.getStatistic().getDefensiveStatistic();
		final float defensiveLevelMultiplier = energyAbility.getMultiplicationFactor().getDefensiveLevelMultiplier();

		defensivStatistic.setDodgeRate(defensivStatistic.getDodgeRate() * defensiveLevelMultiplier);
		defensivStatistic.setResistance(defensivStatistic.getResistance() * defensiveLevelMultiplier);
		defensivStatistic.setArmour(defensivStatistic.getArmour() * defensiveLevelMultiplier);

	}


	private static void updateOffensiveStatistic (final EnergyAbility energyAbility)
	{
		final OffensiveEnergyStatistic offensiveStatistic = energyAbility.getStatistic().getOffensiveStatistic();
		final float offensiveLevelMultiplier = energyAbility.getMultiplicationFactor().getOffensiveLevelMultiplier();
		offensiveStatistic.setMeleeDamage(offensiveStatistic.getMeleeDamage() * offensiveLevelMultiplier);

	}


	public static GridPane getAttributeGridPane (final EnergyAbility energyAbility)
	{
		final GridPane attributeGridPane = new GridPane();
		attributeGridPane.setVgap(ATTRIBUTE_SPACING);
		attributeGridPane.setHgap(ATTRIBUTE_SPACING);

		addDexterityAttributesToGrid(energyAbility, attributeGridPane);
		addDefensiveAttributesToGrid(energyAbility, attributeGridPane);
		addOffensiveAttributesToGrid(energyAbility, attributeGridPane);
		return attributeGridPane;
	}


	private static void addDexterityAttributesToGrid (final EnergyAbility energyAbility, final GridPane gridPane)
	{
		final DexterityEnergyStatistic dexterityStatistic = energyAbility.getStatistic().getDexterityStatistic();

		gridPane.add(getSingleAttributeHBox(MOVEMENT_ATTRIBUTE_ICON_PATH, MOVEMENT_ATTRIBUTE_NAME, dexterityStatistic.getMovementTileProperty()),
			MOVEMENT_ATTRIBUTE_GRID_X, MOVEMENT_ATTRIBUTE_GRID_Y);

		gridPane.add(getSingleAttributeHBox(INITIATIVE_ATTRIBUTE_ICON_PATH, INITIATIVE_ATTRIBUTE_NAME, dexterityStatistic.getInitiativeProperty()),
			INITIATIVE_ATTRIBUTE_GRID_X, INITIATIVE_ATTRIBUTE_GRID_Y);
	}


	private static void addDefensiveAttributesToGrid (final EnergyAbility energyAbility, final GridPane gridPane)
	{
		final DefensivStatistic defensivStatistic = energyAbility.getStatistic().getDefensiveStatistic();

		gridPane.add(getSingleAttributeHBox(DODGE_ATTRIBUTE_ICON_PATH, DODGE_ATTRIBUTE_NAME, defensivStatistic.getDodgeRateProperty()),
			DODGE_ATTRIBUTE_GRID_X, DODGE_ATTRIBUTE_GRID_Y);


		gridPane.add(getSingleAttributeHBox(ARMOR_ATTRIBUTE_ICON_PATH, ARMOR_ATTRIBUTE_NAME, defensivStatistic.getMeleeDamageReductionProperty()),
			ARMOR_ATTRIBUTE_GRID_X, ARMOR_ATTRIBUTE_GRID_Y);

		gridPane.add(getSingleAttributeHBox(RESISTANCE_ATTRIBUTE_ICON_PATH, RESISTANCE_ATTRIBUTE_NAME,
				defensivStatistic.getResistanceProperty()),
			RESISTANCE_ATTRIBUTE_GRID_X, RESISTANCE_ATTRIBUTE_GRID_Y);
	}


	private static void addOffensiveAttributesToGrid (final EnergyAbility energyAbility, final GridPane gridPane)
	{
		final OffensiveEnergyStatistic offensiveStatistic = energyAbility.getStatistic().getOffensiveStatistic();

		gridPane.add(getSingleAttributeHBox(MELEE_ATTACK_ATTRIBUTE_ICON_PATH, MELEE_ATTRIBUTE_NAME, offensiveStatistic.getMeleeDamageProperty()),
			MELEE_ATTACK_ATTRIBUTE_GRID_X, MELEE_ATTACK_ATTRIBUTE_GRID_Y);
	}


	private static HBox getSingleAttributeHBox (final String imagePath, final String attributeName, final NumberExpression attributeProperty)
	{
		final HBox attributeHBox = new HBox();
		attributeHBox.setAlignment(Pos.CENTER_LEFT);
		attributeHBox.setSpacing(ATTRIBUTE_SPACING);

		final Label attributeValueLabel = new Label();
		attributeValueLabel.textProperty().bind(attributeProperty.asString());

		attributeHBox.getChildren().add(new ImageView(ResourceLoader.loadImage(imagePath)));
		attributeHBox.getChildren().add(new Label(attributeName));
		attributeHBox.getChildren().add(attributeValueLabel);

		return attributeHBox;
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public void upgrade (final EnergyAbility energyAbility)
	{
		Platform.runLater(new UpgradeRunnable(energyAbility, EnergyAbilityConroller.getEnergyInstance()));
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean checkIsUpgradable (final EnergyAbility energyAbility)
	{
		return true;
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updateValues (final EnergyAbility energyAbility)
	{
		if (energyAbility.getLevel() == EnergyAbilityLevel.getMaxLevel())
		{
			energyAbility.setIsMaxLevel(true);
		}

		energyAbility.setName(energyAbility.getName(energyAbility.getLevel()));
		energyAbility.setSprite(energyAbility.getSprite(energyAbility.getLevel()));
		energyAbility.setUpgradeCosts(energyAbility.getUpgradeCosts(energyAbility.getLevel()));

		updateOffensiveStatistic(energyAbility);
		updateDexterityStatistic(energyAbility);
		updateDefensiveStatistic(energyAbility);
	}

}
