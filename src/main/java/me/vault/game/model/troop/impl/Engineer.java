package me.vault.game.model.troop.impl;


import javafx.scene.image.Image;
import me.vault.game.model.currency.CurrencyTransaction;
import me.vault.game.model.troop.Faction;
import me.vault.game.model.troop.Troop;
import me.vault.game.model.troop.TroopLevel;
import me.vault.game.model.troop.TroopStatistics;
import me.vault.game.utility.logging.Logger;
import me.vault.game.utility.struct.MetaDataImage;
import me.vault.game.utility.struct.ValidatedEntriesHashMap;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

import static me.vault.game.utility.constant.TroopConstants.Engineer.*;


/**
 * This class is an implementation of {@link Troop}.
 * <br>
 * There are two available instances of this class.
 * One instance is the allied engineer, and the other instance is there for the enemy engineer.
 *
 * @author Vincent Wolf
 * @version 1.0.0
 * @see Troop
 * @since 30.07.2024
 */
public final class Engineer extends Troop
{

	/**
	 * The {@link Logger} object for this class used for writing to the console.
	 */
	private static final Logger LOGGER = new Logger(Engineer.class.getSimpleName());


	/**
	 * The allied instance.
	 */
	private static final Engineer ALLY_INSTANCE;


	/**
	 * The enemy instance.
	 */
	private static final Engineer ENEMY_INSTANCE;

	/**
	 * All possible names of the troop are stored in this {@link Map}, with the {@link TroopLevel} as key to denote which name corresponds to
	 * which {@link TroopLevel}.
	 */
	private static final Map<TroopLevel, String> NAMES = new ValidatedEntriesHashMap<>();

	/**
	 * All possible sprites ({@link Image}) of the troop are stored in this {@link Map}, with the {@link TroopLevel} as key to denote which sprite corresponds to
	 * which {@link TroopLevel}.
	 */
	private static final Map<TroopLevel, MetaDataImage> SPRITES = new ValidatedEntriesHashMap<>();

	/**
	 * All possible upgrade cost {@link CurrencyTransaction}'s of the troop are stored in this {@link Map}, with the {@link TroopLevel} as key to
	 * denote which set of upgrade costs corresponds to which {@link TroopLevel}.
	 */
	private static final Map<TroopLevel, CurrencyTransaction> UPGRADE_COSTS = new ValidatedEntriesHashMap<>();


	/**
	 * All possible {@link TroopStatistics} of the troop are stored in this {@link Map}, with the {@link TroopLevel} as key to
	 * denote which set of upgrade costs corresponds to which {@link TroopLevel}.
	 */
	private static final Map<TroopLevel, TroopStatistics> TROOP_STATISTICS = new ValidatedEntriesHashMap<>();


	static
	{
		NAMES.put(TroopLevel.SINGLE_COMBATANT, SINGLE_NAME);
		NAMES.put(TroopLevel.COUPLE, COUPLE_NAME);
		NAMES.put(TroopLevel.SQUAD, SQUAD_NAME);

		SPRITES.put(TroopLevel.SINGLE_COMBATANT, SINGLE_SPRITE);
		SPRITES.put(TroopLevel.COUPLE, COUPLE_SPRITE);
		SPRITES.put(TroopLevel.SQUAD, SQUAD_SPRITE);

		UPGRADE_COSTS.put(TroopLevel.SINGLE_COMBATANT, SINGLE_UPGRADE_COST);
		UPGRADE_COSTS.put(TroopLevel.COUPLE, COUPLE_UPGRADE_COST);
		UPGRADE_COSTS.put(TroopLevel.SQUAD, SQUAD_UPGRADE_COST);


		TROOP_STATISTICS.put(TroopLevel.SINGLE_COMBATANT, ENGINEER_STATISTICS);
		TROOP_STATISTICS.put(TroopLevel.COUPLE, ENGINEER_COUPLE_STATISTICS);
		TROOP_STATISTICS.put(TroopLevel.SQUAD, ENGINEER_SQUAD_STATISTICS);

		// Create the singleton instance at last, so all maps are filled with values as the data in these maps is required to create an instance of this class.
		ALLY_INSTANCE = new Engineer();
		ENEMY_INSTANCE = new Engineer();
	}


	private Engineer ()
	{
		super(Faction.MILITARISTIC_GOVERNMENT);
	}


	/**
	 * Returns the singleton instance of this class.
	 *
	 * @return The singleton instance of this class.
	 */
	public static Engineer getAllyInstance ()
	{
		return ALLY_INSTANCE;
	}


	public static Engineer getEnemyInstance ()
	{
		return ENEMY_INSTANCE;
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	protected @NotNull Map<TroopLevel, CurrencyTransaction> getAllUpgradeCosts ()
	{
		return UPGRADE_COSTS;
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	protected @NotNull Map<TroopLevel, String> getAllNames ()
	{
		return NAMES;
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	protected @NotNull Map<TroopLevel, MetaDataImage> getAllSprites ()
	{
		return SPRITES;
	}


	@Override
	protected @NotNull Map<TroopLevel, TroopStatistics> getAllStatistics ()
	{
		return TROOP_STATISTICS;
	}

}
