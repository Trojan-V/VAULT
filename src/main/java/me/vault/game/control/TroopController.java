package me.vault.game.control;


import javafx.application.Platform;
import javafx.beans.binding.NumberExpression;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import me.vault.game.interfaces.Upgrader;
import me.vault.game.model.troop.*;
import me.vault.game.utility.loading.ResourceLoader;
import me.vault.game.utility.logging.Logger;
import me.vault.game.utility.struct.UpgradeRunnable;

import static me.vault.game.utility.constant.AttributeConstants.*;


public final class TroopController implements Upgrader<Troop, TroopLevel>
{

	/**
	 * The {@link Logger} object for this class used for writing to the console.
	 */
	private static final Logger LOGGER = new Logger(TroopController.class.getSimpleName());

	/**
	 * Singleton instance, as there's no reason to have more than one {@link TroopController}.
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
	private TroopController ()
	{}


	/**
	 * Returns the singleton instance of this class.
	 *
	 * @return The singleton instance of this class.
	 */
	public static TroopController getInstance ()
	{
		return INSTANCE;
	}


	private static void updateDexterityStatistic (final Troop troop)
	{
		final DexterityStatistic dexterityStatistic = troop.getStatistic().getDexterityStatistic();
		final float dexterityLevelMultiplier = troop.getFaction().getDexterityLevelMultiplier();

		dexterityStatistic.setInitiative(dexterityStatistic.getInitiative() * dexterityLevelMultiplier);
		dexterityStatistic.setMovementTiles(dexterityStatistic.getMovementTiles() * dexterityLevelMultiplier);

	}


	private static void updateDefensiveStatistic (final Troop troop)
	{
		final DefensiveStatistic defensiveStatistic = troop.getStatistic().getDefensiveStatistic();
		final float defensiveLevelMultiplier = troop.getFaction().getDefensiveLevelMultiplier();

		defensiveStatistic.setDodgeRate(defensiveStatistic.getDodgeRate() * defensiveLevelMultiplier);
		defensiveStatistic.setHealthPoints(defensiveStatistic.getHealthPoints() * defensiveLevelMultiplier);
		defensiveStatistic.setResistance(defensiveStatistic.getResistance() * defensiveLevelMultiplier);
		defensiveStatistic.setArmour(defensiveStatistic.getArmour() * defensiveLevelMultiplier);

	}


	private static void updateOffensiveStatistic (final Troop troop)
	{
		final OffensiveStatistic offensiveStatistic = troop.getStatistic().getOffensiveStatistic();
		final float offensiveLevelMultiplier = troop.getFaction().getOffensiveLevelMultiplier();

		offensiveStatistic.setEnergyPoints(offensiveStatistic.getEnergyPoints() * offensiveLevelMultiplier);
		offensiveStatistic.setGrenadeAmount(offensiveStatistic.getGrenadeAmount() * offensiveLevelMultiplier);
		offensiveStatistic.setGrenadeRange(offensiveStatistic.getGrenadeRange() * offensiveLevelMultiplier);
		offensiveStatistic.setMeleeDamage(offensiveStatistic.getMeleeDamage() * offensiveLevelMultiplier);
		offensiveStatistic.setGrenadeDamage(offensiveStatistic.getGrenadeDamage() * offensiveLevelMultiplier);

	}


	public static GridPane getAttributeGridPane (final Troop troop)
	{
		final GridPane attributeGridPane = new GridPane();
		attributeGridPane.setVgap(ATTRIBUTE_SPACING);
		attributeGridPane.setHgap(ATTRIBUTE_SPACING);

		addDexterityAttributesToGrid(troop, attributeGridPane);
		addDefensiveAttributesToGrid(troop, attributeGridPane);
		addOffensiveAttributesToGrid(troop, attributeGridPane);
		return attributeGridPane;
	}


	private static void addDexterityAttributesToGrid (final Troop troop, final GridPane gridPane)
	{
		final DexterityStatistic dexterityStatistic = troop.getStatistic().getDexterityStatistic();

		gridPane.add(getSingleAttributeHBox(MOVEMENT_ATTRIBUTE_ICON_PATH, MOVEMENT_ATTRIBUTE_NAME, dexterityStatistic.getMovementTileProperty()),
			MOVEMENT_ATTRIBUTE_GRID_X, MOVEMENT_ATTRIBUTE_GRID_Y);

		gridPane.add(getSingleAttributeHBox(INITIATIVE_ATTRIBUTE_ICON_PATH, INITIATIVE_ATTRIBUTE_NAME, dexterityStatistic.getInitiativeProperty()),
			INITIATIVE_ATTRIBUTE_GRID_X, INITIATIVE_ATTRIBUTE_GRID_Y);
	}


	private static void addDefensiveAttributesToGrid (final Troop troop, final GridPane gridPane)
	{
		final DefensiveStatistic defensiveStatistic = troop.getStatistic().getDefensiveStatistic();

		gridPane.add(getSingleAttributeHBox(DODGE_ATTRIBUTE_ICON_PATH, DODGE_ATTRIBUTE_NAME, defensiveStatistic.getDodgeRateProperty()),
			DODGE_ATTRIBUTE_GRID_X, DODGE_ATTRIBUTE_GRID_Y);

		gridPane.add(getSingleAttributeHBox(HEALTH_ATTRIBUTE_ICON_PATH, HEALTH_ATTRIBUTE_NAME, defensiveStatistic.getHealthPointsProperty()),
			HEALTH_ATTRIBUTE_GRID_X, HEALTH_ATTRIBUTE_GRID_Y);

		gridPane.add(getSingleAttributeHBox(ARMOR_ATTRIBUTE_ICON_PATH, ARMOR_ATTRIBUTE_NAME, defensiveStatistic.getMeleeDamageReductionProperty()),
			ARMOR_ATTRIBUTE_GRID_X, ARMOR_ATTRIBUTE_GRID_Y);

		gridPane.add(getSingleAttributeHBox(RESISTANCE_ATTRIBUTE_ICON_PATH, RESISTANCE_ATTRIBUTE_NAME, defensiveStatistic.getEnergyDamageReductionProperty()),
			RESISTANCE_ATTRIBUTE_GRID_X, RESISTANCE_ATTRIBUTE_GRID_Y);
	}


	private static void addOffensiveAttributesToGrid (final Troop troop, final GridPane gridPane)
	{
		final OffensiveStatistic offensiveStatistic = troop.getStatistic().getOffensiveStatistic();

		gridPane.add(getSingleAttributeHBox(MELEE_ATTACK_ATTRIBUTE_ICON_PATH, MELEE_ATTRIBUTE_NAME, offensiveStatistic.getMeleeDamageProperty()),
			MELEE_ATTACK_ATTRIBUTE_GRID_X, MELEE_ATTACK_ATTRIBUTE_GRID_Y);

		gridPane.add(getSingleAttributeHBox(GRENADE_ATTACK_ATTRIBUTE_ICON_PATH, GRENADE_ATTACK_ATTRIBUTE_NAME, offensiveStatistic.getGrenadeDamageProperty()),
			GRENADE_ATTACK_ATTRIBUTE_GRID_X, GRENADE_ATTACK_ATTRIBUTE_GRID_Y);

		gridPane.add(getSingleAttributeHBox(GRENADE_AMOUNT_ATTRIBUTE_ICON_PATH, GRENADE_AMOUNT_ATTRIBUTE_NAME, offensiveStatistic.getGrenadeAmountProperty()),
			GRENADE_AMOUNT_ATTRIBUTE_GRID_X, GRENADE_AMOUNT_ATTRIBUTE_GRID_Y);

		gridPane.add(getSingleAttributeHBox(GRENADE_RANGE_ATTRIBUTE_ICON_PATH, GRENADE_RANGE_ATTRIBUTE_NAME, offensiveStatistic.getGrenadeRangeProperty()),
			GRENADE_RANGE_ATTRIBUTE_GRID_X, GRENADE_RANGE_ATTRIBUTE_GRID_Y);

		gridPane.add(getSingleAttributeHBox(ENERGY_ATTRIBUTE_ICON_PATH, ENERGY_ATTRIBUTE_NAME, offensiveStatistic.getEnergyPointsProperty()),
			ENERGY_ATTRIBUTE_GRID_X, ENERGY_ATTRIBUTE_GRID_Y);
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
	public void upgrade (final Troop troop)
	{
		Platform.runLater(new UpgradeRunnable(troop, TroopController.getInstance()));
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean checkIsUpgradable (final Troop troop)
	{
		return true;
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updateValues (final Troop troop)
	{
		if (troop.getLevel() == TroopLevel.getMaxLevel())
		{
			troop.setIsMaxLevel(true);
		}

		troop.setName(troop.getName(troop.getLevel()));
		troop.setSprite(troop.getSprite(troop.getLevel()));
		troop.setUpgradeCosts(troop.getUpgradeCosts(troop.getLevel()));

		updateOffensiveStatistic(troop);
		updateDexterityStatistic(troop);
		updateDefensiveStatistic(troop);
	}

}