package me.vault.game.control;


import javafx.application.Platform;
import javafx.beans.binding.NumberExpression;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import me.vault.game.interfaces.Upgrader;
import me.vault.game.model.arena.Arena;
import me.vault.game.model.arena.GameBoard;
import me.vault.game.model.arena.Placeholder;
import me.vault.game.model.arena.Tile;
import me.vault.game.model.troop.*;
import me.vault.game.utility.loading.ResourceLoader;
import me.vault.game.utility.logging.Logger;
import me.vault.game.utility.struct.UpgradeRunnable;

import java.util.List;

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
		final DexterityStatistic dexterityStats = troop.getStatistics().getDexterityStatistic();
		final DexterityStatistic newDexterityStats = troop.getStatistics(troop.getLevel()).getDexterityStatistic();

		dexterityStats.setInitiative(newDexterityStats.getInitiative());
		dexterityStats.setMovementTiles(newDexterityStats.getMovementTiles());
	}


	private static void updateDefensiveStatistic (final Troop troop)
	{
		final DefensiveStatistic defenseStats = troop.getStatistics().getDefensiveStatistic();
		final DefensiveStatistic newDefenseStats = troop.getStatistics(troop.getLevel()).getDefensiveStatistic();

		defenseStats.setArmor(newDefenseStats.getArmor());
		defenseStats.setDodgeRate(newDefenseStats.getDodgeRate());
		defenseStats.setHealthPoints(newDefenseStats.getHealthPoints());
		defenseStats.setResistance(newDefenseStats.getResistance());
	}


	private static void updateOffensiveStatistic (final Troop troop)
	{
		final OffensiveStatistics offensiveStats = troop.getStatistics().getOffensiveStatistic();
		final OffensiveStatistics newOffensiveStats = troop.getStatistics(troop.getLevel()).getOffensiveStatistic();

		offensiveStats.setEnergyPoints(newOffensiveStats.getEnergyPoints());
		offensiveStats.setGrenadeAmount(newOffensiveStats.getGrenadeAmount());
		offensiveStats.setGrenadeDamage(newOffensiveStats.getGrenadeDamage());
		offensiveStats.setGrenadeRange(newOffensiveStats.getGrenadeRange());
		offensiveStats.setMeleeDamage(newOffensiveStats.getMeleeDamage());
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
		final DexterityStatistic dexterityStatistic = troop.getStatistics().getDexterityStatistic();

		gridPane.add(getSingleAttributeHBox(MOVEMENT_ATTRIBUTE_ICON_PATH, MOVEMENT_ATTRIBUTE_NAME, dexterityStatistic.getMovementTileProperty()),
			MOVEMENT_ATTRIBUTE_GRID_X, MOVEMENT_ATTRIBUTE_GRID_Y);

		gridPane.add(getSingleAttributeHBox(INITIATIVE_ATTRIBUTE_ICON_PATH, INITIATIVE_ATTRIBUTE_NAME, dexterityStatistic.getInitiativeProperty()),
			INITIATIVE_ATTRIBUTE_GRID_X, INITIATIVE_ATTRIBUTE_GRID_Y);
	}


	private static void addDefensiveAttributesToGrid (final Troop troop, final GridPane gridPane)
	{
		final DefensiveStatistic defensiveStatistic = troop.getStatistics().getDefensiveStatistic();

		gridPane.add(getSingleAttributeHBox(DODGE_ATTRIBUTE_ICON_PATH, DODGE_ATTRIBUTE_NAME, defensiveStatistic.getDodgeRateProperty()),
			DODGE_ATTRIBUTE_GRID_X, DODGE_ATTRIBUTE_GRID_Y);

		gridPane.add(getSingleAttributeHBox(HEALTH_ATTRIBUTE_ICON_PATH, HEALTH_ATTRIBUTE_NAME, defensiveStatistic.getHealthPointsProperty()),
			HEALTH_ATTRIBUTE_GRID_X, HEALTH_ATTRIBUTE_GRID_Y);

		gridPane.add(getSingleAttributeHBox(ARMOR_ATTRIBUTE_ICON_PATH, ARMOR_ATTRIBUTE_NAME, defensiveStatistic.getMeleeDamageReductionProperty()),
			ARMOR_ATTRIBUTE_GRID_X, ARMOR_ATTRIBUTE_GRID_Y);

		gridPane.add(getSingleAttributeHBox(RESISTANCE_ATTRIBUTE_ICON_PATH, RESISTANCE_ATTRIBUTE_NAME,
				defensiveStatistic.getResistanceProperty()),
			RESISTANCE_ATTRIBUTE_GRID_X, RESISTANCE_ATTRIBUTE_GRID_Y);
	}


	private static void addOffensiveAttributesToGrid (final Troop troop, final GridPane gridPane)
	{
		final OffensiveStatistics offensiveStatistics = troop.getStatistics().getOffensiveStatistic();

		gridPane.add(getSingleAttributeHBox(MELEE_ATTACK_ATTRIBUTE_ICON_PATH, MELEE_ATTRIBUTE_NAME, offensiveStatistics.getMeleeDamageProperty()),
			MELEE_ATTACK_ATTRIBUTE_GRID_X, MELEE_ATTACK_ATTRIBUTE_GRID_Y);

		gridPane.add(getSingleAttributeHBox(GRENADE_ATTACK_ATTRIBUTE_ICON_PATH, GRENADE_ATTACK_ATTRIBUTE_NAME, offensiveStatistics.getGrenadeDamageProperty()),
			GRENADE_ATTACK_ATTRIBUTE_GRID_X, GRENADE_ATTACK_ATTRIBUTE_GRID_Y);

		gridPane.add(getSingleAttributeHBox(GRENADE_AMOUNT_ATTRIBUTE_ICON_PATH, GRENADE_AMOUNT_ATTRIBUTE_NAME, offensiveStatistics.getGrenadeAmountProperty()),
			GRENADE_AMOUNT_ATTRIBUTE_GRID_X, GRENADE_AMOUNT_ATTRIBUTE_GRID_Y);

		gridPane.add(getSingleAttributeHBox(GRENADE_RANGE_ATTRIBUTE_ICON_PATH, GRENADE_RANGE_ATTRIBUTE_NAME, offensiveStatistics.getGrenadeRangeProperty()),
			GRENADE_RANGE_ATTRIBUTE_GRID_X, GRENADE_RANGE_ATTRIBUTE_GRID_Y);

		gridPane.add(getSingleAttributeHBox(ENERGY_ATTRIBUTE_ICON_PATH, ENERGY_ATTRIBUTE_NAME, offensiveStatistics.getEnergyPointsProperty()),
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
		Platform.runLater(new UpgradeRunnable(troop, getInstance()));
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
		troop.setIsMaxLevel(troop.getLevel() == TroopLevel.getMaximum());

		troop.setName(troop.getName(troop.getLevel()));
		troop.setSprite(troop.getSprite(troop.getLevel()));
		troop.setUpgradeCosts(troop.getUpgradeCosts(troop.getLevel()));

		updateOffensiveStatistic(troop);
		updateDexterityStatistic(troop);
		updateDefensiveStatistic(troop);
	}


	public static boolean troopCanMoveToPosition (final Arena arena, final Troop troop, final int i, final int j)
	{
		final GameBoard arenaGameBoard = arena.getGameBoard();
		final int[] previousTroopPosition = arenaGameBoard.getTroopPosition(troop);
		final int troopMovementRange = troop.getStatistics().getDexterityStatistic().getMovementTiles();
		final List<Tile> accessibleTiles = arenaGameBoard.getAdjacentAccessibleTiles(previousTroopPosition, troopMovementRange);
		return accessibleTiles.contains(arena.getGameBoard().getTile(i, j));
	}


	public static boolean troopCanAttackTroop (final Arena arena, final Troop attacker, final int row, final int column)
	{
		try
		{
			final Troop defender = arena.getGameBoard().getTroop(row, column);
			final int[] attackerPos = arena.getGameBoard().getTroopPosition(attacker);
			final List<Tile> reachableTiles = arena.getGameBoard().getAdjacentTiles(attackerPos[0], attackerPos[1], attacker.getStatistics().getOffensiveStatistic().getGrenadeRange());

			final List<Troop> defenderGroup = arena.getPlayerOneTroops().contains(defender) ? arena.getPlayerOneTroops() : arena.getPlayerTwoTroops();
			return !defenderGroup.contains(attacker) && reachableTiles.contains(arena.getGameBoard().getTile(row, column));
		}
		catch (final Exception e)
		{
			throw new RuntimeException(e);
		}
	}


	public static void moveTroop (final Arena arena, final Troop troop, final int i, final int j)
	{
		final GameBoard arenaGameBoard = arena.getGameBoard();
		final int[] previousTroopPosition = arenaGameBoard.getTroopPosition(troop);
		arenaGameBoard.setTroop(i, j, troop);
		arenaGameBoard.setPlaceable(previousTroopPosition[0], previousTroopPosition[1], new Placeholder());
	}


	public static void attackTroop (final Arena arena, final Troop attacker, final Troop defender)
	{
		final OffensiveStatistics attackerOffensiveStats = attacker.getStatistics().getOffensiveStatistic();
		final DefensiveStatistic defenderDefensiveStats = defender.getStatistics().getDefensiveStatistic();
		System.out.println("attacker = " + attacker);
		System.out.println("defender = " + defender);

	}


	public void resetStatistics (final Troop troop)
	{
		troop.setStatistics(troop.getStatistics(troop.getLevel()));
	}

}
