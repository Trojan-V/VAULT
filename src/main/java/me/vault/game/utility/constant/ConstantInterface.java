package me.vault.game.utility.constant;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * This annotation provides a way to mark an interface as {@link ConstantInterface}, which is useful to determine if an interface should be
 * implemented by another class.
 * <br>
 * If an interface is annotated by {@link ConstantInterface}, it should never be implemented by another class. The reason is that implementing an
 * interface usually suggests that there's some API which has to be implemented. Also, the class which implements the interface is of the type of the
 * interface, which doesn't make sense because a concrete will never be an instance of a {@link ConstantInterface}.
 * <br>
 * To allow easy access to the constants the interface provides without having to specify the fully qualified name of the constant, static imports for
 * the desired constants can be used.
 *
 * @author Vincent Wolf, Lasse-Leander Hillen, Timothy Hoegen-Jupp, Alexander Goethel
 * @version 1.0.0
 * @since 15.05.2024
 */
@Retention (RetentionPolicy.CLASS)
@Target (ElementType.TYPE)
@interface ConstantInterface
{

	/**
	 * Decorator that just clarifies that the element is a constant.
	 *
	 * @author Vincent Wolf
	 * @version 1.0.0
	 * @since 30.07.2024
	 */
	@Retention (RetentionPolicy.CLASS)
	@Target (ElementType.FIELD)
	@interface Constant
	{}

}