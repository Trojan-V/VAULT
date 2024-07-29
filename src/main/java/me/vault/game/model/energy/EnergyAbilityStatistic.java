package me.vault.game.model.energy;


/**
 * Description
 *
 * @author Vincent Wolf, Lasse-Leander Hillen, Timothy Hoegen-Jupp, Alexander Goethel
 * @version 1.0.0
 * @see EnergyAbility
 * @since 25.06.2024
 */

public class EnergyAbilityStatistic
{

	private final DexterityEnergyStatistic dexterityStatistic;

	private final DefensivStatistic defensivStatistic;

	private final OffensiveEnergyStatistic offensiveStatistic;


	public EnergyAbilityStatistic (final DexterityEnergyStatistic dexterityStatistic, final DefensivStatistic defensivStatistic,
		final OffensiveEnergyStatistic offensiveStatistic)
	{
		this.dexterityStatistic = dexterityStatistic;
		this.defensivStatistic = defensivStatistic;
		this.offensiveStatistic = offensiveStatistic;
	}


	public DexterityEnergyStatistic getDexterityStatistic ()
	{
		return this.dexterityStatistic;
	}


	public DefensivStatistic getDefensiveStatistic ()
	{
		return this.defensivStatistic;
	}


	public OffensiveEnergyStatistic getOffensiveStatistic ()
	{
		return this.offensiveStatistic;
	}

}

