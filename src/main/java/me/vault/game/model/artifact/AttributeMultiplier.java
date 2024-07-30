package me.vault.game.model.artifact;


import javafx.beans.property.SimpleDoubleProperty;
import me.vault.game.exception.InvalidAttributeMultiplierException;
import me.vault.game.utility.logging.ILogger;
import me.vault.game.utility.logging.ILogger.Level;
import me.vault.game.utility.logging.Logger;

import java.text.MessageFormat;
import java.util.Map;

import static me.vault.game.utility.constant.LoggingConstants.EXECUTION_NOT_POSSIBLE_ANYMORE;
import static me.vault.game.utility.constant.MiscConstants.ERROR_EXIT_CODE;


/**
 * This class is used as a data structure to store buffs and de-buffs in the form of multipliers which are then
 * applied to all players or troops that
 * are eligible to receive buffs and de-buffs.
 * <br>
 * For instance, these multipliers are used by the {@link Artifact} class to store the buffs and de-buffs the
 * artifact provides.
 *
 * @author Vincent Wolf, Lasse-Leander Hillen, Timothy Hoegen-Jupp, Alexander Goethel
 * @version 1.0.0
 * @see Artifact
 * @see AttributeMultiplier.Type
 * @see InvalidAttributeMultiplierException
 * @since 05.06.2024
 */
public class AttributeMultiplier
{

	/**
	 * The {@link Logger} object for this class used for writing to the console.
	 */
	private static final ILogger LOGGER = new Logger(AttributeMultiplier.class.getSimpleName());


	/**
	 * The pattern used to create the string which describes the class in a human-readable format.
	 */
	private static final String TO_STRING_PATTERN = "AttributeMultiplier[damage={0}x, health={1}x, defense={2}x]";


	/**
	 * This property is used to store and dynamically display the damage multiplier the artifact provides. If the
	 * value is updated within this
	 * property, JavaFX instantly applies the change, so it's visible in the GUI.
	 *
	 * @see SimpleDoubleProperty
	 */
	private final SimpleDoubleProperty damageMultiplierProperty;


	/**
	 * This property is used to store and dynamically display the health multiplier the artifact provides. If the
	 * value is updated within this
	 * property, JavaFX instantly applies the change, so it's visible in the GUI.
	 *
	 * @see SimpleDoubleProperty
	 */
	private final SimpleDoubleProperty healthMultiplierProperty;


	/**
	 * This property is used to store and dynamically display the defense multiplier the artifact provides. If the
	 * value is updated within this
	 * property, JavaFX instantly applies the change, so it's visible in the GUI.
	 *
	 * @see SimpleDoubleProperty
	 */
	private final SimpleDoubleProperty defenseMultiplierProperty;


	/**
	 * Constructs an instance of this class.
	 * <br>
	 * The instance is only created if the supplied modifiers were valid. Check the
	 * {@link AttributeMultiplier#validate()} method for more information.
	 *
	 * @param modifiers The modifiers which are applied to the properties.
	 * @precondition The map of the attribute modifiers exists.
	 * @postcondition Constructs an instance of {@link AttributeMultiplier} with the supplied modifies.
	 */
	AttributeMultiplier (final Map<Type, Double> modifiers)
	{
		this.damageMultiplierProperty = new SimpleDoubleProperty(modifiers.get(Type.DAMAGE));
		this.defenseMultiplierProperty = new SimpleDoubleProperty(modifiers.get(Type.DEFENSE));
		this.healthMultiplierProperty = new SimpleDoubleProperty(modifiers.get(Type.HEALTH));

		try
		{
			this.validate();
		}
		catch (final InvalidAttributeMultiplierException e)
		{
			LOGGER.log(Level.ERROR, e.getMessage());
			LOGGER.log(Level.ERROR, EXECUTION_NOT_POSSIBLE_ANYMORE);

			System.exit(ERROR_EXIT_CODE);
		}
	}


	/**
	 * Validates that the supplied modifiers are valid.
	 * <br>
	 * Checks if the health multiplier isn't equal or below zero, because negative health or defense wouldn't make any
	 * sense. Zero health multiplier
	 * wouldn't make any sense either, as the unit would instantly be dead in that case, as the health would always be
	 * equal to zero if you multiply it with zero.
	 * <br>
	 * The damage and defense multiplier is validated as well: this method checks if these aren't below zero, because
	 * negative damage or defense
	 * values wouldn't make any sense. Zero damage or defense could technically be valid in niche cases, hence why
	 * this check isn't performed as part
	 * of the validation.
	 *
	 * @exception InvalidAttributeMultiplierException When one of the supplied modifiers was invalid.
	 * @precondition The modifiers are supplied.
	 * @postcondition The modifiers are validated.
	 */
	private void validate () throws InvalidAttributeMultiplierException
	{
		if (this.healthMultiplierProperty.get() <= 0)
		{
			throw new InvalidAttributeMultiplierException(this.healthMultiplierProperty.get());
		}
		if (this.damageMultiplierProperty.get() <= 0)
		{
			throw new InvalidAttributeMultiplierException(this.damageMultiplierProperty.get());
		}
		if (this.defenseMultiplierProperty.get() <= 0)
		{
			throw new InvalidAttributeMultiplierException(this.defenseMultiplierProperty.get());
		}
	}


	/**
	 * Sets the damage multiplier to the supplied value.
	 * <br>
	 * The damage multiplier is set within the {@link AttributeMultiplier#damageMultiplierProperty}, so the damage
	 * multiplier value gets automatically updated in the GUI.
	 *
	 * @param damageMultiplier The new value for the damage multiplier.
	 * @precondition The property of the damage multiplier exists.
	 * @postcondition The property of the damage multiplier is set.
	 */
	public void setDamageMultiplier (final double damageMultiplier)
	{
		this.damageMultiplierProperty.set(damageMultiplier);
	}


	/**
	 * Sets the health multiplier to the supplied value.
	 * <br>
	 * The health multiplier is set within the {@link AttributeMultiplier#healthMultiplierProperty}, so the health
	 * multiplier value gets automatically updated in the GUI.
	 *
	 * @param healthMultiplier The new value for the health multiplier.
	 * @precondition The property of the health multiplier exists.
	 * @postcondition The property of the health multiplier is set.
	 */
	public void setHealthMultiplier (final double healthMultiplier)
	{
		this.healthMultiplierProperty.set(healthMultiplier);
	}


	/**
	 * Sets the defense multiplier to the supplied value.
	 * <br>
	 * The defense multiplier is set within the {@link AttributeMultiplier#defenseMultiplierProperty}, so the defense
	 * multiplier value gets automatically updated in the GUI.
	 *
	 * @param defenseMultiplier The new value for the defense multiplier.
	 * @precondition The property of the defence multiplier exists.
	 * @postcondition The property of the defence multiplier is set.
	 */
	public void setDefenseMultiplier (final double defenseMultiplier)
	{
		this.defenseMultiplierProperty.set(defenseMultiplier);
	}


	/**
	 * Returns the property which is wrapped around the damage multiplier. This property needs to be bound to the
	 * corresponding GUI element in order
	 * for JavaFX to be able to update the data in the GUI element automatically.
	 *
	 * @return The property which is wrapped around the damage multiplier.
	 * @precondition The property of the damage multiplier exists.
	 * @postcondition The property of the damage multiplier is accessible for the program.
	 */
	public SimpleDoubleProperty getDamageMultiplierProperty ()
	{
		return this.damageMultiplierProperty;
	}


	/**
	 * Returns the property which is wrapped around the health multiplier. This property needs to be bound to the
	 * corresponding GUI element in order
	 * for JavaFX to be able to update the data in the GUI element automatically.
	 *
	 * @return The property which is wrapped around the health multiplier.
	 * @precondition The property of the health multiplier exists.
	 * @postcondition The property of the health multiplier is accessible for the program.
	 */
	public SimpleDoubleProperty getHealthMultiplierProperty ()
	{
		return this.healthMultiplierProperty;
	}


	/**
	 * Returns the property which is wrapped around the defense multiplier. This property needs to be bound to the
	 * corresponding GUI element in order
	 * for JavaFX to be able to update the data in the GUI element automatically.
	 *
	 * @return The property which is wrapped around the defense multiplier.
	 * @precondition The property of the defense multiplier exists.
	 * @postcondition The property of the defense multiplier is accessible for the program.
	 */
	public SimpleDoubleProperty getDefenseMultiplierProperty ()
	{
		return this.defenseMultiplierProperty;
	}


	/**
	 * Returns the instance of this class in a human-readable format by creating a string.
	 *
	 * @return The message in its string representation.
	 * @precondition The {@link Artifact} is {@code != null}.
	 * @postcondition The method returned a {@link String} which represents the object.
	 */
	@Override
	public String toString ()
	{
		return MessageFormat.format(TO_STRING_PATTERN, this.damageMultiplierProperty.get(),
			this.healthMultiplierProperty.get(), this.defenseMultiplierProperty.get());
	}


	/**
	 * This enum consists of all different types of attribute modifiers.
	 *
	 * @author Vincent Wolf, Lasse-Leander Hillen, Timothy Hoegen-Jupp, Alexander Goethel
	 * @version 1.0.0
	 * @see AttributeMultiplier
	 * @since 08.06.2024
	 */
	public enum Type
	{
		/**
		 * Attribute-multiplier type for the damage multiplier.
		 */
		DAMAGE,


		/**
		 * Attribute-multiplier type for the health multiplier.
		 */
		HEALTH,


		/**
		 * Attribute-multiplier type for the defense multiplier.
		 */
		DEFENSE
	}

}
