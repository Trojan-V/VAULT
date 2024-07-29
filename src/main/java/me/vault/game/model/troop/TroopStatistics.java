package me.vault.game.model.troop;


/**
 * Description
 *
 * @author Vincent Wolf, Lasse-Leander Hillen, Timothy Hoegen-Jupp, Alexander Goethel
 * @version 1.0.0
 * @see
 * @since 23.05.2024
 */
public class TroopStatistics
{

	private final DexterityStatistic dexterityStatistic;

	private final DefensiveStatistic defensiveStatistic;

	private final OffensiveStatistics offensiveStatistics;


	public TroopStatistics (final DexterityStatistic dexterityStatistic, final DefensiveStatistic defensiveStatistic, final OffensiveStatistics offensiveStatistics)
	{
		this.dexterityStatistic = dexterityStatistic;
		this.defensiveStatistic = defensiveStatistic;
		this.offensiveStatistics = offensiveStatistics;
	}


	public TroopStatistics (final TroopStatistics troopStatistics)
	{
		this.dexterityStatistic = new DexterityStatistic(troopStatistics.getDexterityStatistic());
		this.defensiveStatistic = new DefensiveStatistic(troopStatistics.getDefensiveStatistic());
		this.offensiveStatistics = new OffensiveStatistics(troopStatistics.getOffensiveStatistic());
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
