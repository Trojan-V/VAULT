package me.vault.game.model.troop;


import javafx.beans.property.SimpleIntegerProperty;
import me.vault.game.model.arena.Figure;

import java.text.MessageFormat;


/**
 * This class provides the model for all different statistics a {@link Troop} has.
 * <br>
 * These statistics are important for the interactions in the arena and determine how far a troop can move, how much
 * damage they deal, how high their defense is and more.
 * <br>
 * The statistics are split into several "sub-statistics" such as {@link Dexterity}, {@link Defensive} and
 * {@link Offensive} statistics.
 *
 * @author Lasse-Leander Hillen, Vincent Wolf
 * @version 1.0.0
 * @see Troop
 * @see Dexterity
 * @see Defensive
 * @see Offensive
 * @since 23.05.2024
 */
public class TroopStatistics
{


	private static final String TO_STRING_PATTERN = "TroopStatistics'{'dexterity={0}, defensive={1}, offensive={2}'}'";


	/**
	 * The dexterity statistics of the {@link Troop}.
	 */
	private final Dexterity dexterity;


	/**
	 * The defensive statistics of the {@link Troop}.
	 */
	private final Defensive defensive;


	/**
	 * The offensive statistics of the {@link Troop}.
	 */
	private final Offensive offensive;


	/**
	 * Constructs an instance of this class by assembling the supplied {@link Dexterity} statistics,
	 * {@link Defensive} statistics and {@link Offensive} statistics.
	 *
	 * @param dexterity The dexterity statistics of the troop.
	 * @param defensive The defensive statistics of the troop.
	 * @param offensive The offensive statistics of the troop.
	 */
	public TroopStatistics (final Dexterity dexterity, final Defensive defensive, final Offensive offensive)
	{
		this.dexterity = dexterity;
		this.defensive = defensive;
		this.offensive = offensive;
	}


	/**
	 * This constructor creates a new instance of this class by providing an instance of this class itself.
	 * <br>
	 * This is required for the {@link Figure}s in the arena as they have to have their own statistics and cannot use
	 * the same instance as the {@link Troop} itself. The {@link Figure} is in the arena, while the troop is in the
	 * selection screen that is part of the city.
	 * <br>
	 * This is due to Java objects are called by reference and not called by value, and therefore the {@link Troop}
	 * would use
	 * the same instance as the {@link Figure} if this constructor wouldn't be used to create a separate instance
	 * with similar values.
	 *
	 * @param troopStatistics The statistics of the troop which are essentially copied to create a new instance with
	 *                        identical values.
	 */
	public TroopStatistics (final TroopStatistics troopStatistics)
	{
		this.dexterity = new Dexterity(troopStatistics.getDexterity());
		this.defensive = new Defensive(troopStatistics.getDefensive());
		this.offensive = new Offensive(troopStatistics.getOffensive());
	}


	/**
	 * Returns the dexterity statistics of the {@link Troop}.
	 *
	 * @return The dexterity statistics of the {@link Troop}.
	 */
	public Dexterity getDexterity ()
	{
		return this.dexterity;
	}


	/**
	 * Returns the defensive statistics of the {@link Troop}.
	 *
	 * @return The defensive statistics of the {@link Troop}.
	 */
	public Defensive getDefensive ()
	{
		return this.defensive;
	}


	/**
	 * Returns the offensive statistics of the {@link Troop}.
	 *
	 * @return The offensive statistics of the {@link Troop}.
	 */
	public Offensive getOffensive ()
	{
		return this.offensive;
	}


	/**
	 * Returns the instance of this class in a human-readable format by creating a string.
	 *
	 * @return The instance in its string representation.
	 */
	@Override
	public String toString ()
	{
		return MessageFormat.format(TO_STRING_PATTERN, this.dexterity.toString(), this.defensive.toString(),
			this.offensive.toString());
	}


	/**
	 * This class encapsulates all the offensive statistics of the {@link Troop}.
	 * <br>
	 * It provides getters and setters for these statistics that can be used to manipulate their values.
	 *
	 * @author Vincent Wolf
	 * @version 1.0.0
	 * @see TroopStatistics
	 * @see SimpleIntegerProperty
	 * @since 29.07.2024
	 */
	public static class Offensive
	{
		private static final String TO_STRING_PATTERN =
			"Offensive'{'energyPoints={0}, meleeDamage={1}, grenadeDamage={2}, grenadeAmount={3}, grenadeRange={4}'}'";


		/**
		 * This property is used to store and display the energy points of the {@link Troop}. If the value is updated
		 * within this property, JavaFX instantly applies the change, so it's visible in the GUI.
		 */
		private final SimpleIntegerProperty energyPoints;


		/**
		 * This property is used to store and display the melee damage the {@link Troop} deals. If the value is
		 * updated within this property, JavaFX instantly applies the change, so it's visible in the GUI.
		 */
		private final SimpleIntegerProperty meleeDamage;


		/**
		 * This property is used to store and display the amount of grenade damage the {@link Troop} deals. If the
		 * value is updated within this property, JavaFX instantly applies the change, so it's visible in the GUI.
		 */
		private final SimpleIntegerProperty grenadeDamage;


		/**
		 * This property is used to store and display the number of grenades the {@link Troop} has access to.
		 * If the value is updated within this property, JavaFX instantly applies the change, so it's visible in the
		 * GUI.
		 */
		private final SimpleIntegerProperty grenadeAmount;


		/**
		 * This property is used to store and display the range of the {@link Troop}'s grenades.
		 * If the value is updated within this property, JavaFX instantly applies the change, so it's visible in the
		 * GUI.
		 */
		private final SimpleIntegerProperty grenadeRange;


		/**
		 * Constructs an instance of this class to encapsulate the offensive statistics of the {@link Troop}.
		 *
		 * @param energyPoints  The number of energy points that are available to the {@link Troop}.
		 * @param meleeDamage   The number of melee damage the {@link Troop} deals to an enemy.
		 * @param grenadeDamage The number of grenade damage the {@link Troop} deals.
		 * @param grenadeAmount The number of grenades that are available to the {@link Troop}.
		 * @param grenadeRange  The range of the {@link Troop}'s grenades.
		 */
		public Offensive (final int energyPoints, final int meleeDamage, final int grenadeDamage,
			final int grenadeAmount, final int grenadeRange)
		{
			this.energyPoints = new SimpleIntegerProperty(energyPoints);
			this.meleeDamage = new SimpleIntegerProperty(meleeDamage);
			this.grenadeDamage = new SimpleIntegerProperty(grenadeDamage);
			this.grenadeAmount = new SimpleIntegerProperty(grenadeAmount);
			this.grenadeRange = new SimpleIntegerProperty(grenadeRange);
		}


		/**
		 * This constructor creates a new instance of this class by providing an instance of this class itself.
		 * <br>
		 * This is required for the {@link Figure}s in the arena as they have to have their own statistics and cannot
		 * use
		 * the same instance as the {@link Troop} itself. The {@link Figure} is in the arena, while the troop is in the
		 * selection screen that is part of the city.
		 * <br>
		 * This is due to Java objects are called by reference and not called by value, and therefore the {@link Troop}
		 * would use
		 * the same instance as the {@link Figure} if this constructor wouldn't be used to create a separate instance
		 * with similar values.
		 *
		 * @param offensiveStatistics The offensive statistics of the troop which are essentially copied to create a
		 *                            new instance with identical values.
		 */
		public Offensive (final Offensive offensiveStatistics)
		{
			this.energyPoints = new SimpleIntegerProperty(offensiveStatistics.getEnergyPoints());
			this.meleeDamage = new SimpleIntegerProperty(offensiveStatistics.getMeleeDamage());
			this.grenadeDamage = new SimpleIntegerProperty(offensiveStatistics.getGrenadeDamage());
			this.grenadeAmount = new SimpleIntegerProperty(offensiveStatistics.getGrenadeAmount());
			this.grenadeRange = new SimpleIntegerProperty(offensiveStatistics.getGrenadeRange());
		}


		/**
		 * Returns the number of energy points the {@link Troop} has available.
		 *
		 * @return The number of energy points the {@link Troop} has available.
		 */
		public int getEnergyPoints ()
		{
			return this.energyPoints.get();
		}


		/**
		 * Sets the number of energy points of the {@link Troop}.
		 *
		 * @param energyPoints The number of energy points.
		 */
		public void setEnergyPoints (final int energyPoints)
		{
			this.energyPoints.set(energyPoints);
		}


		/**
		 * Sets the number of energy points of the {@link Troop}.
		 * <br>
		 * As the number is provided as float value, the float value will be rounded to an integer value.
		 *
		 * @param energyPoints The number of energy points.
		 */
		public void setEnergyPoints (final float energyPoints)
		{
			this.energyPoints.set(Math.round(energyPoints));
		}


		/**
		 * Returns the property used to store and display the number of energy points that are available to the
		 * {@link Troop}.
		 *
		 * @return The property used to store and display the energy points that are available to the {@link Troop}.
		 */
		public SimpleIntegerProperty getEnergyPointsProperty ()
		{
			return this.energyPoints;
		}


		/**
		 * Returns the number of melee damage the {@link Troop} deals to an enemy.
		 *
		 * @return The number of melee damage the {@link Troop} deals to an enemy.
		 */
		public int getMeleeDamage ()
		{
			return this.meleeDamage.get();
		}


		/**
		 * Sets the number of melee damage the {@link Troop} deals to an enemy.
		 *
		 * @param meleeDamage The number of melee damage the {@link Troop} deals to an enemy.
		 */
		public void setMeleeDamage (final int meleeDamage)
		{
			this.meleeDamage.set(meleeDamage);
		}


		/**
		 * Sets the number of melee damage the {@link Troop} deals to an enemy.
		 * <br>
		 * As the number is provided as float value, the float value will be rounded to an integer value.
		 *
		 * @param meleeDamage The number of melee damage the {@link Troop} deals to an enemy.
		 */
		public void setMeleeDamage (final float meleeDamage)
		{
			this.meleeDamage.set(Math.round(meleeDamage));
		}


		/**
		 * Returns the property used to store and display the number of melee damage the {@link Troop} deals to an
		 * enemy.
		 *
		 * @return The property used to store and display the number of melee damage the {@link Troop} deals to an
		 * enemy.
		 */
		public SimpleIntegerProperty getMeleeDamageProperty ()
		{
			return this.meleeDamage;
		}


		/**
		 * Returns the amount of grenade damage the {@link Troop} deals to enemies.
		 *
		 * @return The amount of grenade damage the {@link Troop} deals to enemies.
		 */
		public int getGrenadeDamage ()
		{
			return this.grenadeDamage.get();
		}


		/**
		 * Sets the amount of grenade damage the {@link Troop} deals to enemies.
		 *
		 * @param grenadeDamage The amount of grenade damage the {@link Troop} deals to enemies.
		 */
		public void setGrenadeDamage (final int grenadeDamage)
		{
			this.grenadeDamage.set(grenadeDamage);
		}


		/**
		 * Sets the amount of grenade damage the {@link Troop} deals to enemies.
		 * <br>
		 * As the number is provided as float value, the float value will be rounded to an integer value.
		 *
		 * @param grenadeDamage The amount of grenade damage the {@link Troop} deals to enemies.
		 */
		public void setGrenadeDamage (final float grenadeDamage)
		{
			this.grenadeDamage.set(Math.round(grenadeDamage));
		}


		/**
		 * Returns the property used to store and display the amount of grenade damage the {@link Troop} deals to
		 * enemies.
		 *
		 * @return The property used to store and display the amount of grenade damage the {@link Troop} deals to
		 * enemies.
		 */
		public SimpleIntegerProperty getGrenadeDamageProperty ()
		{
			return this.grenadeDamage;
		}


		/**
		 * Returns the number of grenades that are available to the {@link Troop}.
		 *
		 * @return The number of grenades that are available to the {@link Troop}.
		 */
		public int getGrenadeAmount ()
		{
			return this.grenadeAmount.get();
		}


		/**
		 * Sets the number of grenades that are available to the {@link Troop}.
		 *
		 * @param grenadeAmount The number of grenades that are available to the {@link Troop}.
		 */
		public void setGrenadeAmount (final int grenadeAmount)
		{
			this.grenadeAmount.set(grenadeAmount);
		}


		/**
		 * Sets the number of grenades that are available to the {@link Troop}.
		 * <br>
		 * As the number is provided as float value, the float value will be rounded to an integer value.
		 *
		 * @param grenadeAmount The number of grenades that are available to the {@link Troop}.
		 */
		public void setGrenadeAmount (final float grenadeAmount)
		{
			this.grenadeAmount.set(Math.round(grenadeAmount));
		}


		/**
		 * Returns the property used to store and display the number of grenades that are available to the
		 * {@link Troop}.
		 *
		 * @return The property used to store and display the number of grenades that are available to the
		 * {@link Troop}.
		 */
		public SimpleIntegerProperty getGrenadeAmountProperty ()
		{
			return this.grenadeAmount;
		}


		/**
		 * Returns the grenade range.
		 *
		 * @return The grenade range.
		 */
		public int getGrenadeRange ()
		{
			return this.grenadeRange.get();
		}


		/**
		 * Sets the grenade range.
		 *
		 * @param grenadeRange The grenade range.
		 */
		public void setGrenadeRange (final int grenadeRange)
		{
			this.grenadeRange.set(grenadeRange);
		}


		/**
		 * Sets the grenade range.
		 * <br>
		 * As the number is provided as float value, the float value will be rounded to an integer value.
		 *
		 * @param grenadeRange The grenade range.
		 */
		public void setGrenadeRange (final float grenadeRange)
		{
			this.grenadeRange.set(Math.round(grenadeRange));
		}


		/**
		 * Returns the property used to store and display the range of the grenades.
		 *
		 * @return The property used to store and display the range of the grenades.
		 */
		public SimpleIntegerProperty getGrenadeRangeProperty ()
		{
			return this.grenadeRange;
		}


		/**
		 * Returns the instance of this class in a human-readable format by creating a string.
		 *
		 * @return The instance in its string representation.
		 */
		@Override
		public String toString ()
		{
			return MessageFormat.format(TO_STRING_PATTERN, this.energyPoints.get(), this.meleeDamage.get(),
				this.grenadeDamage.get(),
				this.grenadeAmount.get(), this.grenadeRange.get());
		}
	}


	/**
	 * This class encapsulates all the defensive statistics of the {@link Troop}.
	 * <br>
	 * It provides getters and setters for these statistics that can be used to manipulate their values.
	 *
	 * @author Vincent Wolf
	 * @version 1.0.0
	 * @see TroopStatistics
	 * @see SimpleIntegerProperty
	 * @since 29.07.2024
	 */
	public static class Defensive
	{


		private static final String TO_STRING_PATTERN =
			"Defensive'{'health={0}, armor={1}, dodgeRate={2}, resistance={3}'}'";


		/**
		 * This property is used to store and display the health points of the {@link Troop}. If the value is updated
		 * within this property, JavaFX instantly applies the change, so it's visible in the GUI.
		 */
		private final SimpleIntegerProperty health;


		/**
		 * This property is used to store and display the armor points of the {@link Troop}. If the value is updated
		 * within this property, JavaFX instantly applies the change, so it's visible in the GUI.
		 */
		private final SimpleIntegerProperty armor;


		/**
		 * This property is used to store and display the dodge rate of the {@link Troop}. If the value is updated
		 * within this property, JavaFX instantly applies the change, so it's visible in the GUI.
		 */
		private final SimpleIntegerProperty dodgeRate;


		/**
		 * This property is used to store and display the resistance points of the {@link Troop}. If the value is
		 * updated
		 * within this property, JavaFX instantly applies the change, so it's visible in the GUI.
		 */
		private final SimpleIntegerProperty resistance;


		/**
		 * Constructs an instance of this class to encapsulate the defensive statistics of the {@link Troop}.
		 *
		 * @param health     The number of health points that are available to the {@link Troop}.
		 * @param armor      The number of armor points that are available to the {@link Troop}.
		 * @param dodgeRate  The dodge rate of the {@link Troop}.
		 * @param resistance The number of resistance points that are available to the {@link Troop}.
		 */
		public Defensive (final int health, final int armor, final int dodgeRate,
			final int resistance)
		{
			this.health = new SimpleIntegerProperty(health);
			this.armor = new SimpleIntegerProperty(armor);
			this.dodgeRate = new SimpleIntegerProperty(dodgeRate);
			this.resistance = new SimpleIntegerProperty(resistance);
		}


		/**
		 * This constructor creates a new instance of this class by providing an instance of this class itself.
		 * <br>
		 * This is required for the {@link Figure}s in the arena as they have to have their own statistics and cannot
		 * use
		 * the same instance as the {@link Troop} itself. The {@link Figure} is in the arena, while the troop is in the
		 * selection screen that is part of the city.
		 * <br>
		 * This is due to Java objects are called by reference and not called by value, and therefore the {@link Troop}
		 * would use
		 * the same instance as the {@link Figure} if this constructor wouldn't be used to create a separate instance
		 * with similar values.
		 *
		 * @param defensiveStatistics The defensive statistics of the troop which are essentially copied to create a
		 *                            new instance with identical values.
		 */
		public Defensive (final Defensive defensiveStatistics)
		{
			this.health = new SimpleIntegerProperty(defensiveStatistics.getHealth());
			this.armor = new SimpleIntegerProperty(defensiveStatistics.getArmor());
			this.dodgeRate = new SimpleIntegerProperty(defensiveStatistics.getDodgeRate());
			this.resistance = new SimpleIntegerProperty(defensiveStatistics.getResistance());
		}


		/**
		 * Returns the number of health points the {@link Troop} has available.
		 *
		 * @return The number of health points the {@link Troop} has available.
		 */
		public int getHealth ()
		{
			return this.health.get();
		}


		/**
		 * Sets the number of health points of the {@link Troop}.
		 *
		 * @param health The number of health points of the {@link Troop}.
		 */
		public void setHealth (final int health)
		{
			this.health.set(health);
		}


		/**
		 * Sets the number of health points of the {@link Troop}.
		 * <br>
		 * As the number is provided as float value, the float value will be rounded to an integer value.
		 *
		 * @param healthPoints The number of health points of the {@link Troop}.
		 */
		public void setHealthPoints (final float healthPoints)
		{
			this.health.set(Math.round(healthPoints));
		}


		/**
		 * Returns the property used to store and display the number of health points that are available to the
		 * {@link Troop}.
		 *
		 * @return The property used to store and display the health points that are available to the {@link Troop}.
		 */
		public SimpleIntegerProperty getHealthPointsProperty ()
		{
			return this.health;
		}


		/**
		 * Returns the number of armor points the {@link Troop} has available.
		 *
		 * @return The number of armor points the {@link Troop} has available.
		 */
		public int getArmor ()
		{
			return this.armor.get();
		}


		/**
		 * Sets the number of armor points of the {@link Troop}.
		 *
		 * @param armor The number of armor points of the {@link Troop}.
		 */
		public void setArmor (final int armor)
		{
			this.armor.set(armor);
		}


		/**
		 * Sets the number of armor points of the {@link Troop}.
		 * <br>
		 * As the number is provided as float value, the float value will be rounded to an integer value.
		 *
		 * @param armorPoints The number of armor points of the {@link Troop}.
		 */
		public void setArmorPoints (final float armorPoints)
		{
			this.armor.set(Math.round(armorPoints));
		}


		/**
		 * Returns the property used to store and display the number of armor points that are available to the
		 * {@link Troop}.
		 *
		 * @return The property used to store and display the armor points that are available to the {@link Troop}.
		 */
		public SimpleIntegerProperty getArmorProperty ()
		{
			return this.armor;
		}


		/**
		 * Returns the dodge rate of the {@link Troop}.
		 *
		 * @return The dodge rate of the {@link Troop}.
		 */
		public int getDodgeRate ()
		{
			return this.dodgeRate.get();
		}


		/**
		 * Sets the dodge rate of the {@link Troop}.
		 *
		 * @param dodgeRate The dodge rate of the {@link Troop}.
		 */
		public void setDodgeRate (final int dodgeRate)
		{
			this.dodgeRate.set(dodgeRate);
		}


		/**
		 * Sets the dodge rate of the {@link Troop}.
		 * <br>
		 * As the number is provided as float value, the float value will be rounded to an integer value.
		 *
		 * @param dodgeRate The dodge rate of the {@link Troop}.
		 */
		public void setDodgeRate (final float dodgeRate)
		{
			this.dodgeRate.set(Math.round(dodgeRate));
		}


		/**
		 * Returns the property used to store and display the dodge rate of the {@link Troop}.
		 *
		 * @return The property used to store and display the dodge rate of the {@link Troop}.
		 */
		public SimpleIntegerProperty getDodgeRateProperty ()
		{
			return this.dodgeRate;
		}


		/**
		 * Returns the number of resistance points the {@link Troop} has available.
		 *
		 * @return The number of resistance points the {@link Troop} has available.
		 */
		public int getResistance ()
		{
			return this.resistance.get();
		}


		/**
		 * Sets the number of resistance points of the {@link Troop}.
		 *
		 * @param resistance The number of resistance points of the {@link Troop}.
		 */
		public void setResistance (final int resistance)
		{
			this.resistance.set(resistance);
		}


		/**
		 * Sets the number of resistance points of the {@link Troop}.
		 * <br>
		 * As the number is provided as float value, the float value will be rounded to an integer value.
		 *
		 * @param resistancePoints The number of resistance points of the {@link Troop}.
		 */
		public void setResistancePoints (final float resistancePoints)
		{
			this.resistance.set(Math.round(resistancePoints));
		}


		/**
		 * Returns the property used to store and display the number of resistance points that are available to the
		 * {@link Troop}.
		 *
		 * @return The property used to store and display the resistance points that are available to the
		 * {@link Troop}.
		 */
		public SimpleIntegerProperty getResistanceProperty ()
		{
			return this.resistance;
		}


		/**
		 * Returns the instance of this class in a human-readable format by creating a string.
		 *
		 * @return The instance in its string representation.
		 */
		@Override
		public String toString ()
		{
			return MessageFormat.format(TO_STRING_PATTERN, this.health.get(), this.armor.get(), this.dodgeRate.get(),
				this.resistance.get());
		}
	}


	/**
	 * This class encapsulates all the dexterity statistics of the {@link Troop}.
	 * <br>
	 * It provides getters and setters for these statistics that can be used to manipulate their values.
	 *
	 * @author Vincent Wolf
	 * @version 1.0.0
	 * @see TroopStatistics
	 * @see SimpleIntegerProperty
	 * @since 29.07.2024
	 */
	public static class Dexterity
	{


		private static final String TO_STRING_PATTERN = "Dexterity'{'movementTiles={0}, initiative={1}'}'";


		/**
		 * This property is used to store and display the number of tiles the {@link Troop} is allowed to move in one
		 * turn.
		 * If the value is updated within this property, JavaFX instantly applies the change,
		 * so it's visible in the GUI.
		 */
		private final SimpleIntegerProperty movementTiles;


		/**
		 * This property is used to store and display the number of initiative points that are available to
		 * the {@link Troop}.
		 * <br>
		 * The initiative determines in which order the troops will move in each turn. The troop with the highest
		 * initiative value will always move first.
		 * <br>
		 * If the value is updated within this property, JavaFX instantly applies the change,
		 * so it's visible in the GUI.
		 */
		private final SimpleIntegerProperty initiative;


		/**
		 * Constructs an instance of this class to encapsulate the dexterity statistics of the {@link Troop}.
		 *
		 * @param movementTiles The number of tiles the {@link Troop} is allowed to move in one turn.
		 * @param initiative    The number of initiative points that are available to the {@link Troop}.
		 */
		public Dexterity (final int movementTiles, final int initiative)
		{
			this.movementTiles = new SimpleIntegerProperty(movementTiles);
			this.initiative = new SimpleIntegerProperty(initiative);
		}


		/**
		 * This constructor creates a new instance of this class by providing an instance of this class itself.
		 * <br>
		 * This is required for the {@link Figure}s in the arena as they have to have their own statistics and cannot
		 * use
		 * the same instance as the {@link Troop} itself. The {@link Figure} is in the arena, while the troop is in the
		 * selection screen that is part of the city.
		 * <br>
		 * This is due to Java objects are called by reference and not called by value, and therefore the {@link Troop}
		 * would use
		 * the same instance as the {@link Figure} if this constructor wouldn't be used to create a separate instance
		 * with similar values.
		 *
		 * @param dexterityStatistics The dexterity statistics of the troop which are essentially copied to create a
		 *                            new instance with identical values.
		 */
		public Dexterity (final Dexterity dexterityStatistics)
		{
			this.movementTiles = new SimpleIntegerProperty(dexterityStatistics.getMovementTiles());
			this.initiative = new SimpleIntegerProperty(dexterityStatistics.getInitiativePoints());
		}


		/**
		 * Returns the number of tiles the {@link Troop} can move in one turn.
		 *
		 * @return The number of tiles the {@link Troop} can move in one turn.
		 */
		public int getMovementTiles ()
		{
			return this.movementTiles.get();
		}


		/**
		 * Sets the number of tiles the {@link Troop} can move in one turn.
		 *
		 * @param movementTiles The number of tiles the {@link Troop} can move in one turn.
		 */
		public void setMovementTiles (final int movementTiles)
		{
			this.movementTiles.set(movementTiles);
		}


		/**
		 * Sets the number of tiles the {@link Troop} can move in one turn.
		 * <br>
		 * As the number is provided as float value, the float value will be rounded to an integer value.
		 *
		 * @param movementTiles The number of tiles the {@link Troop} can move in one turn.
		 */
		public void setMovementTiles (final float movementTiles)
		{
			this.movementTiles.set(Math.round(movementTiles));
		}


		/**
		 * Returns the property used to store and display the number of tiles the {@link Troop} can move in one turn.
		 *
		 * @return The property used to store and display the number of tiles the {@link Troop} can move in one turn.
		 */
		public SimpleIntegerProperty getMovementTileProperty ()
		{
			return this.movementTiles;
		}


		/**
		 * Returns the number of initiative points that are available to the {@link Troop}.
		 *
		 * @return The number of initiative points that are available to the {@link Troop}.
		 */
		public int getInitiativePoints ()
		{
			return this.initiative.get();
		}


		/**
		 * Sets the number of initiative points that are available to the {@link Troop}.
		 *
		 * @param initiative The number of initiative points that are available to the {@link Troop}.
		 */
		public void setInitiativePoints (final int initiative)
		{
			this.initiative.set(initiative);
		}


		/**
		 * Sets the number of initiative points that are available to the {@link Troop}.
		 * <br>
		 * As the number is provided as float value, the float value will be rounded to an integer value.
		 *
		 * @param initiative The number of initiative points that are available to the {@link Troop}.
		 */
		public void setInitiativePoints (final float initiative)
		{
			this.initiative.set(Math.round(initiative));
		}


		/**
		 * Returns the property used to store and display the number of initiative points that are available to the
		 * {@link Troop}.
		 *
		 * @return The property used to store and display the number of initiative points that are available to the
		 * {@link Troop}.
		 */
		public SimpleIntegerProperty getInitiativeProperty ()
		{
			return this.initiative;
		}


		@Override
		public String toString ()
		{
			return MessageFormat.format(TO_STRING_PATTERN, this.movementTiles.get(), this.initiative.get());
		}
	}
}
