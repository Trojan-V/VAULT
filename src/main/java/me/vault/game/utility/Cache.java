package me.vault.game.utility;


/**
 * This class serves as a cache for values that need to be stored in the memory of the program.
 * <br>
 * Currently, it only stores the information if the game was started with cheats enabled or disabled.
 *
 * @author Vincent Wolf, Lasse-Leander Hillen, Timothy Hoegen-Jupp, Alexander Goethel
 * @version 1.0.0
 * @since 05.06.2024
 */
public final class Cache
{

	/**
	 * Stores the information if cheats are enabled or disabled.
	 */
	private static boolean areCheatsEnabled = false;


	/**
	 * As this class is a utility class, only used to store values and provide getters/setters for these values, no other class should be able to instantiate
	 * it as there's no value that can be gained by allowing instantiation.
	 * <br>
	 * To prohibit the instantiation from anywhere else but within the class, a private constructor is used.
	 *
	 * @precondition Constructor gets called from within the class.
	 * @postcondition A new instance of ArtifactController is created.
	 */
	private Cache () {}

	/**
	 * Returns if the cheats are enabled or not.
	 *
	 * @return True, if the cheats are enabled, otherwise false.
	 *
	 * @precondition Method is called.
	 * @postcondition {@link Cache#areCheatsEnabled} is returned.
	 */
	public static boolean areCheatsEnabled ()
	{
		return areCheatsEnabled;
	}


	/**
	 * Sets cheats to be enabled or turn off depending on the supplied boolean parameter.
	 *
	 * @param enabled If the cheats should be enabled or not.
	 *
	 * @precondition the parameter must be true or false.
	 * @postcondition {@link Cache#areCheatsEnabled} is set to the parameter.
	 */
	public static void setAreCheatsEnabled (final boolean enabled)
	{
		areCheatsEnabled = enabled;
	}
}
