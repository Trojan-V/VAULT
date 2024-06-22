package me.vault.game.model.troop.impl;


import javafx.scene.image.Image;
import me.vault.game.model.currency.CurrencyTransaction;
import me.vault.game.model.troop.Faction;
import me.vault.game.model.troop.Troop;
import me.vault.game.model.troop.TroopLevel;
import me.vault.game.utility.constant.TroopConstants;
import me.vault.game.utility.logging.Logger;
import me.vault.game.utility.struct.MetaDataImage;
import me.vault.game.utility.struct.ValidatedEntriesHashMap;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

import static me.vault.game.utility.constant.TroopConstants.Ranger.RANGER_STATISTIC;
import static me.vault.game.utility.constant.TroopConstants.Sniper.SNIPER_STATISTIC;


public final class Ranger extends Troop
{

	/**
	 * The {@link Logger} object for this class used for writing to the console.
	 */
	private static final Logger LOGGER = new Logger(Ranger.class.getSimpleName());

	/**
	 * Singleton instance, as there's never a reason to have more than one {@link Ranger}.
	 * Instead of using a singleton, the entire class could've been created using solely static methods and fields.
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


	static
	{
		NAMES.put(TroopLevel.SINGLE_COMBATANT, TroopConstants.Ranger.SINGLE_NAME);
		NAMES.put(TroopLevel.COUPLE, TroopConstants.Ranger.COUPLE_NAME);
		NAMES.put(TroopLevel.SQUAD, TroopConstants.Ranger.SQUAD_NAME);

		SPRITES.put(TroopLevel.SINGLE_COMBATANT, TroopConstants.Ranger.SINGLE_SPRITE);
		SPRITES.put(TroopLevel.COUPLE, TroopConstants.Ranger.COUPLE_SPRITE);
		SPRITES.put(TroopLevel.SQUAD, TroopConstants.Ranger.SQUAD_SPRITE);

		UPGRADE_COSTS.put(TroopLevel.SINGLE_COMBATANT, TroopConstants.Ranger.SINGLE_UPGRADE_COST);
		UPGRADE_COSTS.put(TroopLevel.COUPLE, TroopConstants.Ranger.COUPLE_UPGRADE_COST);
		UPGRADE_COSTS.put(TroopLevel.SQUAD, TroopConstants.Ranger.SQUAD_UPGRADE_COST);

		INSTANCE = new Ranger();
	}


	private Ranger ()
	{
		super(null, null, Faction.EXPLORER_ASSOCIATION, RANGER_STATISTIC);
	}


	/**
	 * Returns the singleton instance of this class.
	 *
	 * @return The singleton instance of this class.
	 */
	public static Ranger getInstance ()
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

}
