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

import static me.vault.game.utility.interfaces.constant.TroopConstants.Ranger.*;


/**
 * This class is an implementation of {@link Troop}.
 *
 * @author Vincent Wolf, Lasse-Leander Hillen, Timothy Hoegen-Jupp, Alexander Goethel
 * @version 1.0.0
 * @see Troop
 * @since 30.07.2024
 */
public final class Ranger extends Troop
{

	/**
	 * The instance of the troop.
	 */
	private static final Ranger INSTANCE;


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

		TROOP_STATISTICS.put(TroopLevel.SINGLE_COMBATANT, RANGER_STATISTICS);
		TROOP_STATISTICS.put(TroopLevel.COUPLE, RANGER_COUPLE_STATISTICS);
		TROOP_STATISTICS.put(TroopLevel.SQUAD, RANGER_SQUAD_STATISTICS);

		INSTANCE = new Ranger();
	}


	/**
	 * Constructs an instance of this class.
	 * <br>
	 * The constructor is private because there should only ever be one instance of this class.
	 *
	 * @precondition Constructor gets called from within the class.
	 * @postcondition A new instance of Ranger is created.
	 */
	private Ranger ()
	{
		super(Faction.EXPLORER_ASSOCIATION);
	}


	/**
	 * Returns the singleton instance of this class.
	 *
	 * @return The singleton instance of this class.
	 *
	 * @precondition The singleton Instance exists.
	 * @postcondition The singleton Instance can be accessed in the program.
	 */
	public static Ranger getInstance ()
	{
		return INSTANCE;
	}


	/**
	 * Returns all upgrade cost {@link CurrencyTransaction}'s which are used to determine whether the player can or
	 * can't upgrade the troop depending on the number of currencies he owns.
	 * <br>
	 * These {@link CurrencyTransaction}'s are sorted by the {@link TroopLevel} as key within this {@link Map},
	 * allowing for easy access by using this meaningful key ({@link TroopLevel}).
	 *
	 * @return The {@link Map} which contains all upgrade cost transactions for the troop.
	 *
	 * @precondition The upgrade costs for the upgrade of the TroopLevel have to be supplied.
	 * @postcondition The {@link Map} which contains all upgrade cost transactions for the troop is accessible for
	 * the program.
	 */
	@Override
	protected @NotNull Map<TroopLevel, CurrencyTransaction> getAllUpgradeCosts ()
	{
		return UPGRADE_COSTS;
	}


	/**
	 * Returns all names the troop can have. A troop has different names depending on its level.
	 * <br>
	 * Therefore, these names are sorted by the {@link TroopLevel} as key in a {@link Map}, allowing for easy
	 * access by using this meaningful key ({@link TroopLevel}).
	 *
	 * @return The {@link Map} which contains all names for the troop.
	 *
	 * @precondition The names of the TroopLevels have to be supplied.
	 * @postcondition The {@link Map} which contains all names for the troop is accessible for
	 * the program.
	 */
	@Override
	protected @NotNull Map<TroopLevel, String> getAllNames ()
	{
		return NAMES;
	}


	/**
	 * Returns all sprites the troop can have. A troop can have, but doesn't always have, different sprites
	 * depending on its level.
	 * <br>
	 * Therefore, these sprites are sorted by the {@link TroopLevel} as key in a {@link Map}, allowing for easy
	 * access by using this meaningful key ({@link TroopLevel}).
	 *
	 * @return The {@link Map} which contains all sprites for the troop.
	 *
	 * @precondition The sprites of the TroopLevels have to be supplied.
	 * @postcondition The {@link Map} which contains all sprites for the troop is accessible for
	 * the program.
	 */
	@Override
	protected @NotNull Map<TroopLevel, MetaDataImage> getAllSprites ()
	{
		return SPRITES;
	}


	/**
	 * Returns all statistics the troop can have.
	 * Depending on the level, the statistics of the troop change.
	 * <br>
	 * Therefore, these statistics are sorted by the {@link TroopLevel} as key in a {@link Map}, allowing for easy
	 * access by using this meaningful key ({@link TroopLevel}).
	 *
	 * @return The {@link Map} which contains all statistics for the troop.
	 *
	 * @precondition The statistics for the troops of the TroopLevels have to be supplied.
	 * @postcondition The {@link Map} which contains all statistics of the troops for the troop is accessible for
	 * the program.
	 */
	@Override
	protected @NotNull Map<TroopLevel, TroopStatistics> getAllStatistics ()
	{
		return TROOP_STATISTICS;
	}

}
