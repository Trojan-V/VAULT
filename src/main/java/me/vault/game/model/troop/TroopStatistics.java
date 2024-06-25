package me.vault.game.model.troop;


/**
 * Description
 *
 * @author Lasse-Leander Hillen
 * @version 1.0.0
 * @see
 * @since 23.05.2024
 */
public class TroopStatistics
{

	private final DexterityStatistic dexterityStatistic;

	private final DefensiveStatistic defensiveStatistic;

	private final OffensiveStatistics offensiveStatistics;


	public TroopStatistics (final DexterityStatistic dexterityStatistic, final DefensiveStatistic defensiveStatistic,
		final OffensiveStatistics offensiveStatistics)
	{
		this.dexterityStatistic = dexterityStatistic;
		this.defensiveStatistic = defensiveStatistic;
		this.offensiveStatistics = offensiveStatistics;
	}


	public DexterityStatistic getDexterityStatistic ()
	{
		return this.dexterityStatistic;
	}


	public DefensiveStatistic getDefensiveStatistic ()
	{
		return this.defensiveStatistic;
	}


	public OffensiveStatistics getOffensiveStatistic ()
	{
		return this.offensiveStatistics;
	}

}
