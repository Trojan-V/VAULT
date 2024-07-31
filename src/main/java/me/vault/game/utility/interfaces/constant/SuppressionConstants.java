package me.vault.game.utility.interfaces.constant;


/**
 * This interface provides constants that can be used as parameter of the {@link SuppressWarnings} annotation to get rid of warnings that show up in the IDE
 * during compile time.
 * <br>
 * {@link SuppressWarnings} should only be used if the warnings have been reviewed carefully, and if it's certain that these warnings won't become an issue
 * during runtime.
 *
 * @author Vincent Wolf, Lasse-Leander Hillen, Timothy Hoegen-Jupp, Alexander Goethel
 * @version 1.0.0
 * @see SuppressWarnings
 * @since 08.06.2024
 */
public interface SuppressionConstants
{

	/**
	 * Suppresses warnings related to overridden method call during the object's construction.
	 */
	String OVERRIDDEN_METHOD_CALL = "OverriddenMethodCallDuringObjectConstruction";


	/**
	 * Suppresses warnings related to overridable method calls during the object's construction.
	 */
	String OVERRIDABLE_METHOD_CALL = "OverridableMethodCallDuringObjectConstruction";

}
