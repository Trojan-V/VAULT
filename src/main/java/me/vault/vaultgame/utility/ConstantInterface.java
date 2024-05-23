package me.vault.vaultgame.utility;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * Description
 *
 * @author Vincent Wolf
 * @version 1.0.0
 * @since 15.05.2024
 */
@Retention (RetentionPolicy.RUNTIME)
@Target (ElementType.TYPE)
public @interface ConstantInterface
{
	/**
	 *
	 */
	@Retention (RetentionPolicy.RUNTIME)
	@Target (ElementType.FIELD)
	public static @interface Constant
	{}
}
