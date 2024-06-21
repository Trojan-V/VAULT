package me.vault.game.model.troop.impl;


import me.vault.game.model.GameMap;
import me.vault.game.model.Vertex;
import me.vault.game.model.artifact.AttributeMultiplier;
import me.vault.game.model.currency.CurrencyTransaction;
import me.vault.game.model.troop.Faction;
import me.vault.game.model.troop.Troop;
import me.vault.game.model.troop.TroopLevel;
import me.vault.game.model.troop.TroopStatistic;
import me.vault.game.utility.constant.TroopConstants;
import me.vault.game.utility.logging.Logger;
import me.vault.game.utility.struct.MetaDataImage;
import me.vault.game.utility.struct.ValidatedEntriesHashMap;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

import static me.vault.game.utility.constant.TroopConstants.Sniper.SNIPER_STATISTIC;


public final class Sniper extends Troop
{

	private static final Logger LOGGER = new Logger(Sniper.class.getSimpleName());

	private static final Sniper INSTANCE;

	private static final Map<TroopLevel, String> NAMES = new ValidatedEntriesHashMap<>();

	private static final Map<TroopLevel, MetaDataImage> SPRITES = new ValidatedEntriesHashMap<>();

	private static final Map<TroopLevel, CurrencyTransaction> UPGRADE_COSTS = new ValidatedEntriesHashMap<>();

	private static final TroopStatistic STATISTIC = SNIPER_STATISTIC;

	private static final Faction FACTION = Faction.NEW_TERRA;


	static
	{
		NAMES.put(TroopLevel.SINGLE_COMBATANT, TroopConstants.Sniper.SINGLE_NAME);
		NAMES.put(TroopLevel.COUPLE, TroopConstants.Sniper.COUPLE_NAME);
		NAMES.put(TroopLevel.SQUAD, TroopConstants.Sniper.SQUAD_NAME);

		SPRITES.put(TroopLevel.SINGLE_COMBATANT, TroopConstants.Sniper.SINGLE_SPRITE);
		SPRITES.put(TroopLevel.COUPLE, TroopConstants.Sniper.COUPLE_SPRITE);
		SPRITES.put(TroopLevel.SQUAD, TroopConstants.Sniper.SQUAD_SPRITE);

		UPGRADE_COSTS.put(TroopLevel.SINGLE_COMBATANT, TroopConstants.Sniper.SINGLE_UPGRADE_COST);
		UPGRADE_COSTS.put(TroopLevel.COUPLE, TroopConstants.Sniper.COUPLE_UPGRADE_COST);
		UPGRADE_COSTS.put(TroopLevel.SQUAD, TroopConstants.Sniper.SQUAD_UPGRADE_COST);

		INSTANCE = new Sniper(null, null);
	}


	private Sniper (final GameMap map, final Vertex tile)
	{
		super(map, tile, FACTION, STATISTIC);
	}


	public static Sniper getInstance ()
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
	protected @NotNull Map<TroopLevel, Map<AttributeMultiplier.Type, Double>> getAllModifiers ()
	{
		return Map.of();
	}

}
