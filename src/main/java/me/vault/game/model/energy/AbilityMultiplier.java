package me.vault.game.model.energy;


import javafx.beans.property.SimpleDoubleProperty;
import me.vault.game.exception.InvalidAttributeMultiplierException;

import me.vault.game.utility.logging.ILogger;
import me.vault.game.utility.logging.Logger;

import java.text.MessageFormat;
import java.util.Map;

import static me.vault.game.utility.constant.LoggingConstants.EXECUTION_NOT_POSSIBLE_ANYMORE;
import static me.vault.game.utility.constant.MiscConstants.ERROR_EXIT_CODE;

/**
 * This class is used as a data structure to store buffs in the form of multipliers which are then
 * applied to all troops that
 * are eligible to receive buffs.
 * <br>
 * For instance, these multipliers are used by the {@link me.vault.game.model.energy.Energy} class to store the buffs
 * the energy ability provides.
 *
 * @author Alexander Göthel
 * @version 1.0.0
 * @see me.vault.game.model.energy.Energy
 * @see AbilityMultiplier
 * @since 25.07.2024
 */

public class AbilityMultiplier
{

	/**
	 * The {@link Logger} object for this class used for writing to the console.
	 */
	private static final ILogger LOGGER = new Logger(me.vault.game.model.energy.AbilityMultiplier.class.getSimpleName());


	/**
	 * The pattern used to create the string which describes the class in a human-readable format.
	 */
	private static final String TO_STRING_PATTERN = "AttributeMultiplier[damage={0}x, health={1}x, defense={2}x]";


	/**
	 * This property is used to store and dynamically display the damage multiplier the energy ability provides. If the
	 * value is updated within this
	 * property, JavaFX instantly applies the change, so it's visible in the GUI.
	 *
	 * @see SimpleDoubleProperty
	 */
	private final SimpleDoubleProperty dodgeMultiplierProperty;


	/**
	 * This property is used to store and dynamically display the health multiplier the energy ability provides. If the
	 * value is updated within this
	 * property, JavaFX instantly applies the change, so it's visible in the GUI.
	 *
	 * @see SimpleDoubleProperty
	 */
	private final SimpleDoubleProperty initiativeMultiplierProperty;


	/**
	 * This property is used to store and dynamically display the defense multiplier the energy ability provides. If the
	 * value is updated within this
	 * property, JavaFX instantly applies the change, so it's visible in the GUI.
	 *
	 * @see SimpleDoubleProperty
	 */
	private final SimpleDoubleProperty meleeMultiplierProperty;


	/**
	 * Constructs an instance of this class.
	 * <br>
	 * The instance is only created if the supplied modifiers were valid. Check the
	 * {@link AbilityMultiplier#validate()} method for more
	 * information.
	 *
	 * @param modifiers The modifiers which are applied to the properties.
	 */
	public AbilityMultiplier (final Map<AbilityMultiplier.Type, Double> modifiers)
	{
		this.dodgeMultiplierProperty = new SimpleDoubleProperty(modifiers.get(Type.DODGE));
		this.initiativeMultiplierProperty = new SimpleDoubleProperty(modifiers.get(Type.INITIATIVE));
		this.meleeMultiplierProperty = new SimpleDoubleProperty(modifiers.get(Type.MELEE));

		try
		{
			this.validate();
		}
		catch (final InvalidAttributeMultiplierException e)
		{
			LOGGER.log(ILogger.Level.ERROR, e.getMessage());
			LOGGER.log(ILogger.Level.ERROR, EXECUTION_NOT_POSSIBLE_ANYMORE);

			// TODO: System.exit überarbeiten
			System.exit(ERROR_EXIT_CODE);
		}
	}


	/**
	 * Validates that the supplied modifiers are valid.
	 * <br>
	 * Checks if the dodge multiplier isn't equal or below zero, because negative health or defense wouldn't make any
	 * sense.
	 * <br>
	 * The initiative and melee multiplier is validated as well: this method checks if these aren't below zero,
	 * because
	 * negative initiative or melee
	 * values wouldn't make any sense. Zero initiative or melee could technically be valid in niche cases, hence why
	 * this check is not performed as part
	 * of the validation.
	 *
	 * @exception InvalidAttributeMultiplierException When one of the supplied modifiers was invalid.
	 */
	private void validate () throws InvalidAttributeMultiplierException
	{
		if (this.dodgeMultiplierProperty.get() <= 0)
		{
			throw new InvalidAttributeMultiplierException(this.dodgeMultiplierProperty.get());
		}
		if (this.initiativeMultiplierProperty.get() <= 0)
		{
			throw new InvalidAttributeMultiplierException(this.initiativeMultiplierProperty.get());
		}
		if (this.meleeMultiplierProperty.get() <= 0)
		{
			throw new InvalidAttributeMultiplierException(this.meleeMultiplierProperty.get());
		}
	}


	/**
	 * Sets the dodge multiplier to the supplied value.
	 * <br>
	 * The damage multiplier is set within the {@link AbilityMultiplier#dodgeMultiplierProperty}, so the damage
	 * multiplier value gets automatically updated in the GUI.
	 *
	 * @param dodgeMultiplier The new value for the dodge multiplier.
	 */
	public void setDodgeMultiplier (final double dodgeMultiplier)
	{
		this.dodgeMultiplierProperty.set(dodgeMultiplier);
	}


	/**
	 * Sets the initiative multiplier to the supplied value.
	 * <br>
	 * The initiative multiplier is set within the
	 * {@link AbilityMultiplier#initiativeMultiplierProperty}, so the health
	 * multiplier value gets automatically updated in the GUI.
	 *
	 * @param initiativeMultiplier The new value for the initiative multiplier.
	 */
	public void setInitiativeMultiplier (final double initiativeMultiplier)
	{
		this.initiativeMultiplierProperty.set(initiativeMultiplier);
	}


	/**
	 * Sets the melee multiplier to the supplied value.
	 * <br>
	 * The melee multiplier is set within the
	 * {@link AbilityMultiplier#meleeMultiplierProperty}, so the defense
	 * multiplier value gets automatically updated in the GUI.
	 *
	 * @param meleeMultiplier The new value for the melee multiplier.
	 */
	public void setMeleeMultiplier (final double meleeMultiplier)
	{
		this.meleeMultiplierProperty.set(meleeMultiplier);
	}


	/**
	 * Returns the property which is wrapped around the dodge multiplier. This property needs to be bound to the
	 * corresponding GUI element in order
	 * for JavaFX to be able to update the data in the GUI element automatically.
	 *
	 * @return The property which is wrapped around the dodge multiplier.
	 */
	public SimpleDoubleProperty getDodgeMultiplierProperty ()
	{
		return this.dodgeMultiplierProperty;
	}


	/**
	 * Returns the property which is wrapped around the initiative multiplier. This property needs to be bound to the
	 * corresponding GUI element in order
	 * for JavaFX to be able to update the data in the GUI element automatically.
	 *
	 * @return The property which is wrapped around the initiative multiplier.
	 */
	public SimpleDoubleProperty getInitiativeMultiplierProperty ()
	{
		return this.initiativeMultiplierProperty;
	}


	/**
	 * Returns the property which is wrapped around the melee multiplier. This property needs to be bound to the
	 * corresponding GUI element in order
	 * for JavaFX to be able to update the data in the GUI element automatically.
	 *
	 * @return The property which is wrapped around the melee multiplier.
	 */
	public SimpleDoubleProperty getMeleeMultiplierProperty ()
	{
		return this.meleeMultiplierProperty;
	}


	/**
	 * Returns the instance of this class in a human-readable format by creating a string.
	 *
	 * @return The message in its string representation.
	 */
	@Override
	public String toString ()
	{
		return MessageFormat.format(TO_STRING_PATTERN, this.dodgeMultiplierProperty.get(),
			this.initiativeMultiplierProperty.get(),
			this.meleeMultiplierProperty.get());
	}


	/**
	 * This enum consists of all different types of attribute modifiers.
	 *
	 * @author Alexander Göthel
	 * @version 1.0.0
	 * @see AbilityMultiplier
	 * @since 26.07.2024
	 */
	public enum Type
	{
		/**
		 * Ability-multiplier type for the damage multiplier.
		 */
		DODGE,


		/**
		 * Ability-multiplier type for the initiative multiplier.
		 */
		INITIATIVE,


		/**
		 * Ability-multiplier type for the melee multiplier.
		 */
		MELEE
	}

}