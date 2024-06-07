package me.vault.game.artifact;


import javafx.beans.property.SimpleDoubleProperty;
import me.vault.game.exception.InvalidAttributeModifierException;
import me.vault.game.utility.logging.ILogger.Level;
import me.vault.game.utility.logging.Logger;

import java.text.MessageFormat;
import java.util.Map;

import static me.vault.game.utility.constant.LoggingConstants.Currency.EXECUTION_NOT_POSSIBLE_ANYMORE_MSG;
import static me.vault.game.utility.constant.MiscConstants.ERROR_EXIT_CODE;


/**
 * Description
 *
 * @author Vincent Wolf
 * @version 1.0.0
 * @see
 * @since 05.06.2024
 */
public class AttributeMultiplier
{
	private static final Logger LOGGER = new Logger(AttributeMultiplier.class.getSimpleName());


	private static final String TO_STRING_PATTERN = "AttributeMultiplier[damage={0}x, health={1}x, defense={2}x]";


	private final SimpleDoubleProperty damageMultiplierProperty;


	private final SimpleDoubleProperty healthMultiplierProperty;


	private final SimpleDoubleProperty defenseMultiplierProperty;


	public AttributeMultiplier (final Map<Type, Double> modifiers)
	{
		this.damageMultiplierProperty = new SimpleDoubleProperty(modifiers.get(Type.DAMAGE));
		this.defenseMultiplierProperty = new SimpleDoubleProperty(modifiers.get(Type.DEFENSE));
		this.healthMultiplierProperty = new SimpleDoubleProperty(modifiers.get(Type.HEALTH));

		try
		{
			this.validate();
		}
		catch (final InvalidAttributeModifierException e)
		{
			LOGGER.log(Level.ERROR, e.getMessage());
			LOGGER.log(Level.ERROR, EXECUTION_NOT_POSSIBLE_ANYMORE_MSG);
			System.exit(ERROR_EXIT_CODE);
		}
	}


	private void validate () throws InvalidAttributeModifierException
	{
		if (this.healthMultiplierProperty.get() <= 0)
		{
			throw new InvalidAttributeModifierException(this.healthMultiplierProperty.get());
		}
	}


	public SimpleDoubleProperty getDamageMultiplierProperty ()
	{
		return this.damageMultiplierProperty;
	}


	public SimpleDoubleProperty getHealthMultiplierProperty ()
	{
		return this.healthMultiplierProperty;
	}


	public SimpleDoubleProperty getDefenseMultiplierProperty ()
	{
		return this.defenseMultiplierProperty;
	}


	public void updatePropertyValues (final Map<Type, Double> modifiers)
	{
		this.damageMultiplierProperty.set(modifiers.get(Type.DAMAGE));
		this.defenseMultiplierProperty.set(modifiers.get(Type.DEFENSE));
		this.healthMultiplierProperty.set(modifiers.get(Type.HEALTH));
	}


	public enum Type
	{
		DAMAGE,
		HEALTH,
		DEFENSE
	}


	@Override
	public String toString ()
	{
		return MessageFormat.format(TO_STRING_PATTERN, this.damageMultiplierProperty.get(),
			this.healthMultiplierProperty.get(),
			this.defenseMultiplierProperty.get());
	}
}
