package me.vault.game.model.troop;


import javafx.beans.property.SimpleIntegerProperty;
import me.vault.game.model.gameboard.Figure;

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
 * @author Vincent Wolf, Lasse-Leander Hillen, Timothy Hoegen-Jupp, Alexander Goethel
 * @version 1.0.0
 * @see Troop
 * @see Dexterity
 * @see Defensive
 * @see Offensive
 * @since 23.05.2024
 */
public class TroopStatistics
{

	/**
	 * The {@link MessageFormat} pattern, which is used, when the {@link TroopStatistics#toString()} is
	 * called.
	 */
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
	 *
	 * @precondition The parameters dexterity, defensive and offensive must be != null.
	 * @precondition Constructs an instance with the provided parameters as attributes.
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
	 * This is required for the {@link Figure}s in the arena as they have to have their own statistics and can't use
	 * the same instance as the {@link Troop} itself. The {@link Figure} is in the arena, while the troop is in the
	 * selection screen that's part of the city.
	 * <br>
	 * This is due to Java objects are called by reference and not called by value, and therefore the {@link Troop}
	 * would use
	 * the same instance as the {@link Figure} if this constructor wouldn't be used to create a separate instance
	 * with similar values.
	 *
	 * @param troopStatistics The statistics of the troop which are essentially copied to create a new instance with
	 *                        identical values.
	 *
	 * @precondition The parameter troopStatistics has to be != null.
	 * @postcondition Constructs an instance that equals the provided parameter.
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
	 *
	 * @precondition none.
	 * @postcondition The 'dexterity' attribute is returned.
	 */
	public Dexterity getDexterity ()
	{
		return this.dexterity;
	}


	/**
	 * Returns the defensive statistics of the {@link Troop}.
	 *
	 * @return The defensive statistics of the {@link Troop}.
	 *
	 * @precondition none.
	 * @postcondition The 'defensive' attribute is returned.
	 */
	public Defensive getDefensive ()
	{
		return this.defensive;
	}


	/**
	 * Returns the offensive statistics of the {@link Troop}.
	 *
	 * @return The offensive statistics of the {@link Troop}.
	 *
	 * @precondition none.
	 * @postcondition The 'offensive' attribute is returned.
	 */
	public Offensive getOffensive ()
	{
		return this.offensive;
	}


	/**
	 * Builds a formatted {@link String}, which represents the object, and it's current state using the
	 * {@link TroopStatistics#TO_STRING_PATTERN}.
	 *
	 * @return A {@link String} which has been formatted in the {@link TroopStatistics#TO_STRING_PATTERN}.
	 *
	 * @precondition The {@link TroopStatistics#TO_STRING_PATTERN} is {@code != null}.
	 * @postcondition The method returned a {@link String} which represents the object.
	 */
	@Override
	public String toString ()
	{
		return MessageFormat.format(TO_STRING_PATTERN, this.dexterity.toString(), this.defensive.toString(), this.offensive.toString());
	}


	/**
	 * This class encapsulates all the offensive statistics of the {@link Troop}.
	 * <br>
	 * It provides getters and setters for these statistics that can be used to manipulate their values.
	 *
	 * @author Vincent Wolf, Lasse-Leander Hillen, Timothy Hoegen-Jupp, Alexander Goethel
	 * @version 1.0.0
	 * @see TroopStatistics
	 * @see SimpleIntegerProperty
	 * @since 29.07.2024
	 */
	public static class Offensive
	{

		/**
		 * The {@link MessageFormat} pattern, which is used, when the {@link Offensive#toString()} is
		 * called.
		 */
		private static final String TO_STRING_PATTERN = "Offensive'{'energyPoints={0}, meleeDamage={1}, grenadeDamage={2}, grenadeAmount={3}, grenadeRange={4}'}'";


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
		 *
		 * @precondition The parameters must be != null.
		 * @postcondition Creates a new Instance with the provided parameters as attributes.
		 */
		public Offensive (final int energyPoints, final int meleeDamage, final int grenadeDamage, final int grenadeAmount, final int grenadeRange)
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
		 * This is required for the {@link Figure}s in the arena as they have to have their own statistics and can't
		 * use
		 * the same instance as the {@link Troop} itself. The {@link Figure} is in the arena, while the troop is in the
		 * selection screen that's part of the city.
		 * <br>
		 * This is due to Java objects are called by reference and not called by value, and therefore the {@link Troop}
		 * would use
		 * the same instance as the {@link Figure} if this constructor wouldn't be used to create a separate instance
		 * with similar values.
		 *
		 * @param offensiveStatistics The offensive statistics of the troop which are essentially copied to create a
		 *                            new instance with identical values.
		 *
		 * @precondition The parameter must be != null.
		 * @postcondition Constructs an instance that is equal to the provided parameter.
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
		 *
		 * @precondition none
		 * @postcondition The value of the 'energyPoints' attribute is returned.
		 */
		public int getEnergyPoints ()
		{
			return this.energyPoints.get();
		}


		/**
		 * Sets the number of energy points of the {@link Troop}.
		 *
		 * @param energyPoints The number of energy points.
		 *
		 * @precondition The parameter is >= 0.
		 * @postcondition The value of the attribute 'energyPoints' is set to the value of the parameter.
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
		 *
		 * @precondition The parameter is >= 0.0.
		 * @postcondition The value of the attribute 'energyPoints' is set to the rounded (integer) value of the
		 * parameter.
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
		 *
		 * @precondition none.
		 * @postcondition The value of the 'energyPoints' attribute is returned as a {@link SimpleIntegerProperty}.
		 */
		public SimpleIntegerProperty getEnergyPointsProperty ()
		{
			return this.energyPoints;
		}


		/**
		 * Returns the number of melee damage the {@link Troop} deals to an enemy.
		 *
		 * @return The number of melee damage the {@link Troop} deals to an enemy.
		 *
		 * @precondition none.
		 * @postcondition The value of the attribute 'meleeDamage' is returned.
		 */
		public int getMeleeDamage ()
		{
			return this.meleeDamage.get();
		}


		/**
		 * Sets the number of melee damage the {@link Troop} deals to an enemy.
		 *
		 * @param meleeDamage The number of melee damage the {@link Troop} deals to an enemy.
		 *
		 * @precondition none.
		 * @postcondition The value of the parameter is set as the value of the attribute 'meleeDamage'.
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
		 *
		 * @precondition none.
		 * @postcondition The rounded value (int) of the parameter is set as the value of the attribute 'meleeDamage'.
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
		 *
		 * @precondition none.
		 * @postcondition The value of the attribute 'meleeDamage' is returned.
		 */
		public SimpleIntegerProperty getMeleeDamageProperty ()
		{
			return this.meleeDamage;
		}


		/**
		 * Returns the amount of grenade damage the {@link Troop} deals to enemies.
		 *
		 * @return The amount of grenade damage the {@link Troop} deals to enemies.
		 *
		 * @precondition none.
		 * @postcondition The value of the 'grenadeDamage' attribute is returned.
		 */
		public int getGrenadeDamage ()
		{
			return this.grenadeDamage.get();
		}


		/**
		 * Sets the amount of grenade damage the {@link Troop} deals to enemies.
		 *
		 * @param grenadeDamage The amount of grenade damage the {@link Troop} deals to enemies.
		 *
		 * @precondition The parameter is >= 0.
		 * @postcondition The value of the parameter is set as the value of the attribute 'grenadeDamage'.
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
		 *
		 * @precondition The parameter is >= 0.0.
		 * @postcondition The rounded value (int) of the parameter is set as the value of the attribute 'grenadeDamage'.
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
		 *
		 * @precondition none.
		 * @postcondition The value of the 'grenadeDamage' attribute is returned.
		 */
		public SimpleIntegerProperty getGrenadeDamageProperty ()
		{
			return this.grenadeDamage;
		}


		/**
		 * Returns the number of grenades that are available to the {@link Troop}.
		 *
		 * @return The number of grenades that are available to the {@link Troop}.
		 *
		 * @precondition none.
		 * @postcondition The value of the 'grenadeAmount' attribute is returned.
		 */
		public int getGrenadeAmount ()
		{
			return this.grenadeAmount.get();
		}


		/**
		 * Sets the number of grenades that are available to the {@link Troop}.
		 *
		 * @param grenadeAmount The number of grenades that are available to the {@link Troop}.
		 *
		 * @precondition The parameter is >= 0.
		 * @postcondition The value of the parameter is set as the value of the attribute 'grenadeAmount'.
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
		 *
		 * @precondition The parameter is >= 0.0.
		 * @postcondition The value of the parameter is set as the value of the attribute 'grenadeAmount'.
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
		 *
		 * @precondition none.
		 * @postcondition The value of the 'grenadeAmount' attribute is returned.
		 */
		public SimpleIntegerProperty getGrenadeAmountProperty ()
		{
			return this.grenadeAmount;
		}


		/**
		 * Returns the grenade range.
		 *
		 * @return The grenade range.
		 *
		 * @precondition none.
		 * @postcondition The value of the 'grenadeRange' attribute is returned.
		 */
		public int getGrenadeRange ()
		{
			return this.grenadeRange.get();
		}


		/**
		 * Sets the grenade range.
		 *
		 * @param grenadeRange The grenade range.
		 *
		 * @precondition The parameter is >= 0.
		 * @postcondition The value of the parameter is set as the value of the attribute 'grenadeRange'.
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
		 *
		 * @precondition The parameter is >= 0.0.
		 * @postcondition The value of the parameter is set as the value of the attribute 'grenadeRange'.
		 */
		public void setGrenadeRange (final float grenadeRange)
		{
			this.grenadeRange.set(Math.round(grenadeRange));
		}


		/**
		 * Returns the property used to store and display the range of the grenades.
		 *
		 * @return The property used to store and display the range of the grenades.
		 *
		 * @precondition none.
		 * @postcondition The value of the attribute 'grenadeRange' is returned.
		 */
		public SimpleIntegerProperty getGrenadeRangeProperty ()
		{
			return this.grenadeRange;
		}


		/**
		 * Builds a formatted {@link String}, which represents the object, and it's current state using the
		 * {@link Offensive#TO_STRING_PATTERN}.
		 *
		 * @return A {@link String} which has been formatted in the {@link Offensive#TO_STRING_PATTERN}.
		 *
		 * @precondition The {@link Offensive#TO_STRING_PATTERN} is {@code != null}.
		 * @postcondition The method returned a {@link String} which represents the object.
		 */
		@Override
		public String toString ()
		{
			return MessageFormat.format(TO_STRING_PATTERN, this.energyPoints.get(), this.meleeDamage.get(), this.grenadeDamage.get(), this.grenadeAmount.get(), this.grenadeRange.get());
		}

	}


	/**
	 * This class encapsulates all the defensive statistics of the {@link Troop}.
	 * <br>
	 * It provides getters and setters for these statistics that can be used to manipulate their values.
	 *
	 * @author Vincent Wolf, Lasse-Leander Hillen, Timothy Hoegen-Jupp, Alexander Goethel
	 * @version 1.0.0
	 * @see TroopStatistics
	 * @see SimpleIntegerProperty
	 * @since 29.07.2024
	 */
	public static class Defensive
	{

		/**
		 * The {@link MessageFormat} pattern, which is used, when the {@link Defensive#toString()} is
		 * called.
		 */
		private static final String TO_STRING_PATTERN = "Defensive'{'health={0}, armor={1}, dodgeRate={2}, resistance={3}'}'";


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
		 *
		 * @precondition The parameters must be != null.
		 * @postcondition Creates a new {@code Defensive}-Instance with the provided parameters values as attribute
		 * values.
		 */
		public Defensive (final int health, final int armor, final int dodgeRate, final int resistance)
		{
			this.health = new SimpleIntegerProperty(health);
			this.armor = new SimpleIntegerProperty(armor);
			this.dodgeRate = new SimpleIntegerProperty(dodgeRate);
			this.resistance = new SimpleIntegerProperty(resistance);
		}


		/**
		 * This constructor creates a new instance of this class by providing an instance of this class itself.
		 * <br>
		 * This is required for the {@link Figure}s in the arena as they have to have their own statistics and can't
		 * use
		 * the same instance as the {@link Troop} itself. The {@link Figure} is in the arena, while the troop is in the
		 * selection screen that's part of the city.
		 * <br>
		 * This is due to Java objects are called by reference and not called by value, and therefore the {@link Troop}
		 * would use
		 * the same instance as the {@link Figure} if this constructor wouldn't be used to create a separate instance
		 * with similar values.
		 *
		 * @param defensiveStatistics The defensive statistics of the troop which are essentially copied to create a
		 *                            new instance with identical values.
		 *
		 * @precondition The parameter must be != null.
		 * @postcondition Creates a new {@code Defensive}-Instance that has the same values as the parameter.
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
		 *
		 * @precondition none.
		 * @postcondition The value of the 'health' attribute is returned.
		 */
		public int getHealth ()
		{
			return this.health.get();
		}


		/**
		 * Sets the number of health points of the {@link Troop}.
		 *
		 * @param health The number of health points of the {@link Troop}.
		 *
		 * @precondition The parameter is >= 0.
		 * @postcondition The value of the parameter is set as the value of the attribute.
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
		 * @param health The number of health points of the {@link Troop}.
		 *
		 * @precondition The parameter is >= 0.0.
		 * @postcondition The rounded value of the parameter is set as the value of the attribute.
		 */
		public void setHealth (final float health)
		{
			this.health.set(Math.round(health));
		}


		/**
		 * Returns the property used to store and display the number of health points that are available to the
		 * {@link Troop}.
		 *
		 * @return The property used to store and display the health points that are available to the {@link Troop}.
		 *
		 * @precondition none.
		 * @postcondition The value of the 'health' attribute is returned.
		 */
		public SimpleIntegerProperty getHealthProperty ()
		{
			return this.health;
		}


		/**
		 * Returns the number of armor points the {@link Troop} has available.
		 *
		 * @return The number of armor points the {@link Troop} has available.
		 *
		 * @precondition none.
		 * @postcondition The value of the 'armor' attribute is returned.
		 */
		public int getArmor ()
		{
			return this.armor.get();
		}


		/**
		 * Sets the number of armor points of the {@link Troop}.
		 *
		 * @param armor The number of armor points of the {@link Troop}.
		 *
		 * @precondition The parameter is >= 0.
		 * @precondition The value of the parameter is as the value of the attribute 'armor'.
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
		 * @param armor The number of armor points of the {@link Troop}.
		 *
		 * @precondition The parameter is >= 0.0.
		 * @postcondition The rounded value of the parameter is as the value of the attribute 'armor'.
		 */
		public void setArmor (final float armor)
		{
			this.armor.set(Math.round(armor));
		}


		/**
		 * Returns the property used to store and display the number of armor points that are available to the
		 * {@link Troop}.
		 *
		 * @return The property used to store and display the armor points that are available to the {@link Troop}.
		 *
		 * @precondition none.
		 * @postcondition The value of the attribute 'armor' is returned.
		 */
		public SimpleIntegerProperty getArmorProperty ()
		{
			return this.armor;
		}


		/**
		 * Returns the dodge rate of the {@link Troop}.
		 *
		 * @return The dodge rate of the {@link Troop}.
		 *
		 * @precondition none.
		 * @postcondition The value of the attribute 'dodgeRate' is returned.
		 */
		public int getDodgeRate ()
		{
			return this.dodgeRate.get();
		}


		/**
		 * Sets the dodge rate of the {@link Troop}.
		 *
		 * @param dodgeRate The dodge rate of the {@link Troop}.
		 *
		 * @precondition The parameter is >= 0.
		 * @postcondition The value of the parameter is set as the value of the attribute 'dodgeRate'.
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
		 *
		 * @precondition The parameter is >= 0.0.
		 * @postcondition The rounded value of the parameter is set as the value of the attribute 'dodgeRate'.
		 */
		public void setDodgeRate (final float dodgeRate)
		{
			this.dodgeRate.set(Math.round(dodgeRate));
		}


		/**
		 * Returns the property used to store and display the dodge rate of the {@link Troop}.
		 *
		 * @return The property used to store and display the dodge rate of the {@link Troop}.
		 *
		 * @precondition none.
		 * @postcondition The value of the attribute 'dodgeRate' is returned.
		 */
		public SimpleIntegerProperty getDodgeRateProperty ()
		{
			return this.dodgeRate;
		}


		/**
		 * Returns the number of resistance points the {@link Troop} has available.
		 *
		 * @return The number of resistance points the {@link Troop} has available.
		 *
		 * @precondition none.
		 * @postcondition the value of the 'resistance' attribute is returned.
		 */
		public int getResistance ()
		{
			return this.resistance.get();
		}


		/**
		 * Sets the number of resistance points of the {@link Troop}.
		 *
		 * @param resistance The number of resistance points of the {@link Troop}.
		 *
		 * @precondition The parameter is >= 0.
		 * @postcondition The value of the parameter is set as the value of the attribute 'resistance'.
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
		 * @param resistance The number of resistance points of the {@link Troop}.
		 *
		 * @precondition The parameter is >= 0.0.
		 * @postcondition The rounded value of the parameter is set as the value of the attribute 'resistance'.
		 */
		public void setResistance (final float resistance)
		{
			this.resistance.set(Math.round(resistance));
		}


		/**
		 * Returns the property used to store and display the number of resistance points that are available to the
		 * {@link Troop}.
		 *
		 * @return The property used to store and display the resistance points that are available to the
		 * {@link Troop}.
		 *
		 * @precondition none.
		 * @postcondition The value of the attribute 'resistance' is returned.
		 */
		public SimpleIntegerProperty getResistanceProperty ()
		{
			return this.resistance;
		}


		/**
		 * Builds a formatted {@link String}, which represents the object, and it's current state using the
		 * {@link Defensive#TO_STRING_PATTERN}.
		 *
		 * @return A {@link String} which has been formatted in the {@link Defensive#TO_STRING_PATTERN}.
		 *
		 * @precondition The {@link Defensive#TO_STRING_PATTERN} is {@code != null}.
		 * @postcondition The method returned a {@link String} which represents the object.
		 */
		@Override
		public String toString ()
		{
			return MessageFormat.format(TO_STRING_PATTERN, this.health.get(), this.armor.get(), this.dodgeRate.get(), this.resistance.get());
		}

	}


	/**
	 * This class encapsulates all the dexterity statistics of the {@link Troop}.
	 * <br>
	 * It provides getters and setters for these statistics that can be used to manipulate their values.
	 *
	 * @author Vincent Wolf, Lasse-Leander Hillen, Timothy Hoegen-Jupp, Alexander Goethel
	 * @version 1.0.0
	 * @see TroopStatistics
	 * @see SimpleIntegerProperty
	 * @since 29.07.2024
	 */
	public static class Dexterity
	{

		/**
		 * The {@link MessageFormat} pattern, which is used, when the {@link Dexterity#toString()} is
		 * called.
		 */
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
		 *
		 * @precondition The parameters must be != null.
		 * @postcondition Creates a new {@code Dexterity}-Instance that has the same values as the parameters.
		 */
		public Dexterity (final int movementTiles, final int initiative)
		{
			this.movementTiles = new SimpleIntegerProperty(movementTiles);
			this.initiative = new SimpleIntegerProperty(initiative);
		}


		/**
		 * This constructor creates a new instance of this class by providing an instance of this class itself.
		 * <br>
		 * This is required for the {@link Figure}s in the arena as they have to have their own statistics and can't
		 * use
		 * the same instance as the {@link Troop} itself. The {@link Figure} is in the arena, while the troop is in the
		 * selection screen that's part of the city.
		 * <br>
		 * This is due to Java objects are called by reference and not called by value, and therefore the {@link Troop}
		 * would use
		 * the same instance as the {@link Figure} if this constructor wouldn't be used to create a separate instance
		 * with similar values.
		 *
		 * @param dexterityStatistics The dexterity statistics of the troop which are essentially copied to create a
		 *                            new instance with identical values.
		 *
		 * @precondition The parameter must be != null.
		 * @postcondition Creates a new {@code Dexterity}-Instance that has the same values as the parameter.
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
		 *
		 * @precondition none.
		 * @postcondition The value of the attribute 'movementTiles' is returned.
		 */
		public int getMovementTiles ()
		{
			return this.movementTiles.get();
		}


		/**
		 * Sets the number of tiles the {@link Troop} can move in one turn.
		 *
		 * @param movementTiles The number of tiles the {@link Troop} can move in one turn.
		 *
		 * @precondition The parameter is >= 0.
		 * @postcondition The value of the parameter is set as the value of the attribute 'movementTiles'.
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
		 *
		 * @precondition The parameter is >= 0.0.
		 * @postcondition The rounded value of the parameter is set as the value of the attribute 'movementTiles'.
		 */
		public void setMovementTiles (final float movementTiles)
		{
			this.movementTiles.set(Math.round(movementTiles));
		}


		/**
		 * Returns the property used to store and display the number of tiles the {@link Troop} can move in one turn.
		 *
		 * @return The property used to store and display the number of tiles the {@link Troop} can move in one turn.
		 *
		 * @precondition none.
		 * @postcondition The value of the attribute 'movementTiles' is returned.
		 */
		public SimpleIntegerProperty getMovementTileProperty ()
		{
			return this.movementTiles;
		}


		/**
		 * Returns the number of initiative points that are available to the {@link Troop}.
		 *
		 * @return The number of initiative points that are available to the {@link Troop}.
		 *
		 * @precondition none
		 * @postcondition The value of the 'initiative' attribute is returned.
		 */
		public int getInitiativePoints ()
		{
			return this.initiative.get();
		}


		/**
		 * Sets the number of initiative points that are available to the {@link Troop}.
		 *
		 * @param initiative The number of initiative points that are available to the {@link Troop}.
		 *
		 * @precondition The parameter is != null.
		 * @postcondition The value of the parameter is set as the value of the attribute 'initiative'.
		 */
		public void setInitiative (final int initiative)
		{
			this.initiative.set(initiative);
		}


		/**
		 * Sets the number of initiative points that are available to the {@link Troop}.
		 * <br>
		 * As the number is provided as float value, the float value will be rounded to an integer value.
		 *
		 * @param initiative The number of initiative points that are available to the {@link Troop}.
		 *
		 * @precondition The parameter is != null.
		 * @postcondition The rounded value of the parameter is set as the value of the attribute 'initiative'.
		 */
		public void setInitiative (final float initiative)
		{
			this.initiative.set(Math.round(initiative));
		}


		/**
		 * Returns the property used to store and display the number of initiative points that are available to the
		 * {@link Troop}.
		 *
		 * @return The property used to store and display the number of initiative points that are available to the
		 * {@link Troop}.
		 *
		 * @precondition none.
		 * @postcondition The value of the 'initiative' attribute is returned.
		 */
		public SimpleIntegerProperty getInitiativeProperty ()
		{
			return this.initiative;
		}


		/**
		 * Builds a formatted {@link String}, which represents the object, and it's current state using the
		 * {@link Dexterity#TO_STRING_PATTERN}.
		 *
		 * @return A {@link String} which has been formatted in the {@link Dexterity#TO_STRING_PATTERN}.
		 *
		 * @precondition The {@link Dexterity#TO_STRING_PATTERN} is {@code != null}.
		 * @postcondition The method returned a {@link String} which represents the object.
		 */
		@Override
		public String toString ()
		{
			return MessageFormat.format(TO_STRING_PATTERN, this.movementTiles.get(), this.initiative.get());
		}

	}

}
