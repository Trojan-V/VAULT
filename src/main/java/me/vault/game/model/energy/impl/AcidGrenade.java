package me.vault.game.model.energy.impl;


import javafx.scene.image.Image;
import me.vault.game.model.currency.CurrencyTransaction;
import me.vault.game.model.energy.EnergyAbility;
import me.vault.game.model.energy.EnergyAbilityLevel;
import me.vault.game.model.energy.MultiplicationFactor;
import me.vault.game.utility.constant.EnergyAbilityConstants;
import me.vault.game.utility.logging.Logger;
import me.vault.game.utility.struct.MetaDataImage;
import me.vault.game.utility.struct.ValidatedEntriesHashMap;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

import static me.vault.game.utility.constant.EnergyAbilityConstants.AcidGrenade.ACID_GRENADE_STATISTIC;


public class AcidGrenade extends EnergyAbility
{

	/**
	 * The {@link Logger} object for this class used for writing to the console.
	 */
	private static final Logger LOGGER = new Logger(AcidGrenade.class.getSimpleName());

	/**
	 * Singleton instance, as there's never a reason to have more than one {@link AcidGrenade}.
	 * Instead of using a singleton, the entire class could've been created using solely static methods and fields.
	 */
	private static final AcidGrenade INSTANCE;

	/**
	 * All possible names of the troop are stored in this {@link Map}, with the {@link EnergyAbilityLevel} as key to denote which name
	 * corresponds to
	 * which {@link EnergyAbilityLevel}.
	 */
	private static final Map<EnergyAbilityLevel, String> NAMES = new ValidatedEntriesHashMap<>();

	/**
	 * All possible sprites ({@link Image}) of the troop are stored in this {@link Map}, with the {@link EnergyAbilityLevel} as key to
	 * denote which sprite corresponds to
	 * which {@link EnergyAbilityLevel}.
	 */
	private static final Map<EnergyAbilityLevel, MetaDataImage> SPRITES = new ValidatedEntriesHashMap<>();

	/**
	 * All possible upgrade cost {@link CurrencyTransaction}'s of the troop are stored in this {@link Map}, with the
	 * {@link EnergyAbilityLevel} as key to
	 * denote which set of upgrade costs corresponds to which {@link EnergyAbilityLevel}.
	 */
	private static final Map<EnergyAbilityLevel, CurrencyTransaction> UPGRADE_COSTS = new ValidatedEntriesHashMap<>();


	static
	{
		NAMES.put(EnergyAbilityLevel.RUDIMENTARY, EnergyAbilityConstants.AcidGrenade.RUDIMENTARY_NAME);
		NAMES.put(EnergyAbilityLevel.ADVANCED, EnergyAbilityConstants.AcidGrenade.ADVANCED_NAME);
		NAMES.put(EnergyAbilityLevel.SOPHISTICATED, EnergyAbilityConstants.AcidGrenade.SOPHISTICATED_NAME);

		SPRITES.put(EnergyAbilityLevel.RUDIMENTARY, EnergyAbilityConstants.AcidGrenade.RUDIMENTARY_SPRITE);
		SPRITES.put(EnergyAbilityLevel.ADVANCED, EnergyAbilityConstants.AcidGrenade.ADVANCED_SPRITE);
		SPRITES.put(EnergyAbilityLevel.SOPHISTICATED, EnergyAbilityConstants.AcidGrenade.SOPHISTICATED_SPRITE);

		UPGRADE_COSTS.put(EnergyAbilityLevel.RUDIMENTARY, EnergyAbilityConstants.AcidGrenade.RUDIMENTARY_UPGRADE_COST);
		UPGRADE_COSTS.put(EnergyAbilityLevel.ADVANCED, EnergyAbilityConstants.AcidGrenade.ADVANCED_UPGRADE_COST);
		UPGRADE_COSTS.put(EnergyAbilityLevel.SOPHISTICATED, EnergyAbilityConstants.AcidGrenade.SOPHISTICATED_UPGRADE_COST);

		INSTANCE = new AcidGrenade();
	}


	private AcidGrenade ()
	{
		super(MultiplicationFactor.TROOPS, ACID_GRENADE_STATISTIC);
	}


	/**
	 * Returns the singleton instance of this class.
	 *
	 * @return The singleton instance of this class.
	 */
	public static AcidGrenade getInstance ()
	{
		return INSTANCE;
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	protected @NotNull Map<EnergyAbilityLevel, CurrencyTransaction> getAllUpgradeCosts ()
	{
		return UPGRADE_COSTS;
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	protected @NotNull Map<EnergyAbilityLevel, String> getAllNames ()
	{
		return NAMES;
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	protected @NotNull Map<EnergyAbilityLevel, MetaDataImage> getAllSprites ()
	{
		return SPRITES;
	}

}
