package me.vault.game.model.troop;


/**
 * Description
 *
 * @author Lasse-Leander Hillen
 * @version 1.0.0
 * @see
 * @since 23.05.2024
 */
public class TroopStatistic
{

	private final DexterityStatistic dexterityStatistic;

	private final DefensiveStatistic defensiveStatistic;

	private final OffensiveStatistic offensiveStatistic;


	public TroopStatistic (final DexterityStatistic dexterityStatistic, final DefensiveStatistic defensiveStatistic, final OffensiveStatistic offensiveStatistic)
	{
		this.dexterityStatistic = dexterityStatistic;
		this.defensiveStatistic = defensiveStatistic;
		this.offensiveStatistic = offensiveStatistic;
	}


	public DexterityStatistic getDexterityStatistic ()
	{
		return this.dexterityStatistic;
	}


	public DefensiveStatistic getDefensiveStatistic ()
	{
		return this.defensiveStatistic;
	}


	public OffensiveStatistic getOffensiveStatistic ()
	{
		return this.offensiveStatistic;
	}

}
