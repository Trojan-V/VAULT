package me.vault.game.model.troop.implementation;


import javafx.scene.image.Image;
import me.vault.game.model.currency.CurrencyTransaction;
import me.vault.game.model.troop.Faction;
import me.vault.game.model.troop.Troop;
import me.vault.game.model.troop.TroopLevel;
import me.vault.game.model.troop.TroopStatistics;
import me.vault.game.utility.datatypes.MetaDataImage;
import me.vault.game.utility.datatypes.ValidatedEntriesHashMap;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

import static me.vault.game.utility.interfaces.constant.TroopConstants.Guard.*;


/**
 * This class is an implementation of {@link Troop}.
 *
 * @author Vincent Wolf, Lasse-Leander Hillen, Timothy Hoegen-Jupp, Alexander Goethel
 * @version 1.0.0
 * @see Troop
 * @since 30.07.2024
 */
public final class Guard extends Troop
{

	/**
	 * The instance of the troop.
	 */
	private static final Guard INSTANCE;

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
	private static final Map<TroopLevel, TroopStatistics> TROOP_STATISTICS = new HashMap<>();


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

		TROOP_STATISTICS.put(TroopLevel.SINGLE_COMBATANT, GUARD_STATISTIC);
		TROOP_STATISTICS.put(TroopLevel.COUPLE, GUARD_COUPLE_STATISTICS);
		TROOP_STATISTICS.put(TroopLevel.SQUAD, GUARD_SQUAD_STATISTICS);

		INSTANCE = new Guard();
	}


	/**
	 * Constructs an instance of this class.
	 * <br>
	 * The constructor is private because there should only ever be one instance of this class.
	 *
	 * @precondition Constructor gets called from within the class.
	 * @postcondition A new instance of Guard is created.
	 */
	private Guard ()
	{
		super(Faction.MEGA_CORPORATION);
	}


	/**
	 * Returns the singleton instance of this class.
	 *
	 * @return The singleton instance of this class.
	 *
	 * @precondition The singleton Instance exists.
	 * @postcondition The singleton Instance can be accessed in the program.
	 */
	public static Guard getInstance ()
	{
		return INSTANCE;
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


	/**
	 * {@inheritDoc}
	 */
	@Override
	protected @NotNull Map<TroopLevel, TroopStatistics> getAllStatistics ()
	{
		return TROOP_STATISTICS;
	}

}