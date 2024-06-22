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


public class TroopController implements Upgrader<Troop, TroopLevel>
{

	private static final TroopController INSTANCE = new TroopController();

	/**
	 * The {@link Logger} object for this class used for writing to the console.
	 */
	private static final Logger LOGGER = new Logger(TroopController.class.getSimpleName());


	public static TroopController getInstance ()
	{
		return INSTANCE;
	}


	private static void updateDexterityStatistic (final Troop troop)
	{
		final DexterityStatistic dexterityStatistic = troop.getStatistic().getDexterityStatistic();
		dexterityStatistic.setInitiative((int) (dexterityStatistic.getInitiative() * troop.getFaction().getDexterityLevelMultiplier()));
		dexterityStatistic.setMovementTiles((int) (dexterityStatistic.getMovementTiles() * troop.getFaction().getDexterityLevelMultiplier()));
	}


	private static void updateDefensiveStatistic (final Troop troop)
	{
		final DefensiveStatistic defensiveStatistic = troop.getStatistic().getDefensiveStatistic();
		defensiveStatistic.setDodgeRate((int) (defensiveStatistic.getDodgeRate() * troop.getFaction().getDefensiveLevelMultiplier()));
		defensiveStatistic.setHealthPoints((int) (defensiveStatistic.getHealthPoints() * troop.getFaction().getDefensiveLevelMultiplier()));
		defensiveStatistic.setEnergyDamageReduction((int) (defensiveStatistic.getEnergyDamageReduction() * troop.getFaction().getDefensiveLevelMultiplier()));
		defensiveStatistic.setMeleeDamageReduction((int) (defensiveStatistic.getMeleeDamageReduction() * troop.getFaction().getDefensiveLevelMultiplier()));
	}


	private static void updateOffensiveStatistic (final Troop troop)
	{
		final OffensiveStatistic offensiveStatistic = troop.getStatistic().getOffensiveStatistic();
		offensiveStatistic.setEnergyPoints((int) (offensiveStatistic.getEnergyPoints() * troop.getFaction().getOffensiveLevelMultiplier()));
		offensiveStatistic.setGrenadeAmount((int) (offensiveStatistic.getGrenadeAmount() * troop.getFaction().getOffensiveLevelMultiplier()));
		offensiveStatistic.setGrenadeRange((int) (offensiveStatistic.getGrenadeRange() * troop.getFaction().getOffensiveLevelMultiplier()));
		offensiveStatistic.setMeleeDamage((int) (offensiveStatistic.getMeleeDamage() * troop.getFaction().getOffensiveLevelMultiplier()));
		offensiveStatistic.setGrenadeDamage((int) (offensiveStatistic.getGrenadeDamage() * troop.getFaction().getOffensiveLevelMultiplier()));
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


	// TODO: LITERALE ENTFERNEN!!!!!!!!!!!!!!
	public static GridPane buildAttributeGridPane (final Troop troop)
	{
		final OffensiveStatistic offensiveStatistic = troop.getStatistic().getOffensiveStatistic();
		final DefensiveStatistic defensiveStatistic = troop.getStatistic().getDefensiveStatistic();
		final DexterityStatistic dexterityStatistic = troop.getStatistic().getDexterityStatistic();

		final GridPane attributeGridPane = new GridPane();
		attributeGridPane.setVgap(10);
		attributeGridPane.setHgap(10);

		attributeGridPane.add(buildAttributeHBox(MOVEMENT_ATTRIBUTE_ICON_PATH, MOVEMENT_ATTRIBUTE_NAME, dexterityStatistic.getMovementTileProperty()), 0, 0);
		attributeGridPane.add(buildAttributeHBox(INITIATIVE_ATTRIBUTE_ICON_PATH, INITIATIVE_ATTRIBUTE_NAME, dexterityStatistic.getInitiativeProperty()), 0, 1);

		attributeGridPane.add(buildAttributeHBox(DODGE_ATTRIBUTE_ICON_PATH, DODGE_ATTRIBUTE_NAME, defensiveStatistic.getDodgeRateProperty()), 0, 2);
		attributeGridPane.add(buildAttributeHBox(HEALTH_ATTRIBUTE_ICON_PATH, HEALTH_ATTRIBUTE_NAME, defensiveStatistic.getHealthPointsProperty()), 0, 3);
		attributeGridPane.add(buildAttributeHBox(ARMOR_ATTRIBUTE_ICON_PATH, ARMOR_ATTRIBUTE_NAME, defensiveStatistic.getMeleeDamageReductionProperty()), 1, 0);
		attributeGridPane.add(buildAttributeHBox(RESISTANCE_ATTRIBUTE_ICON_PATH, RESISTANCE_ATTRIBUTE_NAME, defensiveStatistic.getEnergyDamageReductionProperty()), 1, 1);

		attributeGridPane.add(buildAttributeHBox(MELEE_ATTACK_ATTRIBUTE_ICON_PATH, MELEE_ATTRIBUTE_NAME, offensiveStatistic.getMeleeDamageProperty()), 1, 2);
		attributeGridPane.add(buildAttributeHBox(GRENADE_ATTACK_ATTRIBUTE_ICON_PATH, GRENADE_ATTACK_ATTRIBUTE_NAME, offensiveStatistic.getGrenadeDamageProperty()), 1, 3);
		attributeGridPane.add(buildAttributeHBox(GRENADE_AMOUNT_ATTRIBUTE_ICON_PATH, GRENADE_AMOUNT_ATTRIBUTE_NAME, offensiveStatistic.getGrenadeAmountProperty()), 2, 0);
		attributeGridPane.add(buildAttributeHBox(GRENADE_RANGE_ATTRIBUTE_ICON_PATH, GRENADE_RANGE_ATTRIBUTE_NAME, offensiveStatistic.getGrenadeRangeProperty()), 2, 1);
		attributeGridPane.add(buildAttributeHBox(ENERGY_ATTRIBUTE_ICON_PATH, ENERGY_ATTRIBUTE_NAME, offensiveStatistic.getEnergyPointsProperty()), 2, 2);
		return attributeGridPane;
	}

	// TODO: LITERALE ENTFERNEN!!!!!!!!!!!!!!
	private static HBox buildAttributeHBox (final String imagePath, final String attributeName, final NumberExpression attributeProperty)
	{
		final ImageView attributeIconImageView = new ImageView(ResourceLoader.loadImage(imagePath));
		final Label attributeNameLabel = new Label(attributeName);
		final Label attributeValueLabel = new Label();
		attributeValueLabel.textProperty().bind(attributeProperty.asString());

		final HBox attributeHBox = new HBox();
		attributeHBox.getChildren().add(attributeIconImageView);
		attributeHBox.getChildren().add(attributeNameLabel);
		attributeHBox.getChildren().add(attributeValueLabel);
		attributeHBox.setSpacing(5);
		attributeHBox.setAlignment(Pos.CENTER_LEFT);

		return attributeHBox;
	}

}
