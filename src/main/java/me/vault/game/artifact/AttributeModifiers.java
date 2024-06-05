package me.vault.game.artifact;


import me.vault.game.exception.InvalidAttributeModifierException;
import me.vault.game.utility.logging.ILogger.Level;
import me.vault.game.utility.logging.Logger;

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
public class AttributeModifiers
{
	private static final Logger LOGGER = new Logger(AttributeModifiers.class.getSimpleName());


	private final double damageMultiplier;


	private final double healthMultiplier;


	private final double defenseMultiplier;


	public AttributeModifiers (final double damageMultiplier, final double healthMultiplier,
		final double defenseMultiplier)
	{
		this.damageMultiplier = damageMultiplier;
		this.healthMultiplier = healthMultiplier;
		this.defenseMultiplier = defenseMultiplier;

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
		if (this.healthMultiplier <= 0)
		{
			throw new InvalidAttributeModifierException(this.healthMultiplier);
		}
	}
}
