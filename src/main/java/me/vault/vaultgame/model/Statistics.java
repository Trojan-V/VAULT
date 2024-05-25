package me.vault.vaultgame.model;


/**
 * Description
 *
 * @author Vincent Wolf
 * @version 1.0.0
 * @see
 * @since 23.05.2024
 */
public class Statistics
{
	private int healthPoints;


	private int meleeDamageReduction;


	/**
	 * The same as magic points, but named for space environment.
	 */
	private int energyPoints;


	private int meleeDamage;


	private int grenadeDamage;


	private int grenadeAmount;


	private int dodgeRate;


	/**
	 * Resistence
	 */
	private int energyDamageReduction;


	private int movementTiles;


	private int initiative;


	private int meleeRange;


	private int grenadeRange;


	public Statistics (final int healthPoints, final int meleeDamageReduction, final int energyPoints,
		final int meleeDamage, final int grenadeDamage,
		final int grenadeAmount, final int dodgeRate, final int energyDamageReduction, final int movementTiles,
		final int initiative, final int meleeRange,
		final int grenadeRange)
	{
		this.healthPoints = healthPoints;
		this.meleeDamageReduction = meleeDamageReduction;
		this.energyPoints = energyPoints;
		this.meleeDamage = meleeDamage;
		this.grenadeDamage = grenadeDamage;
		this.grenadeAmount = grenadeAmount;
		this.dodgeRate = dodgeRate;
		this.energyDamageReduction = energyDamageReduction;
		this.movementTiles = movementTiles;
		this.initiative = initiative;
		this.meleeRange = meleeRange;
		this.grenadeRange = grenadeRange;
	}
}
