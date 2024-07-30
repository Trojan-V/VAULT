package me.vault.game;


/**
 * This class serves as a cache for values that need to be stored in the memory of the program.
 * <br>
 * Currently, it only stores the information if the game was started with cheats enabled or disabled.
 *
 * @author Vincent Wolf
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
	 * it as there is no value that can be gained by allowing instantiation.
	 * <br>
	 * To prohibit the instantiation from anywhere else but within the class, a private constructor is used.
	 */
	private Cache () {}


	/**
	 * Returns if the cheats are enabled or not.
	 *
	 * @return True, if the cheats are enabled, otherwise false.
	 */
	public static boolean areCheatsEnabled ()
	{
		return areCheatsEnabled;
	}


	/**
	 * Sets cheats to be enabled or disabled depending on the supplied boolean parameter.
	 *
	 * @param enabled If the cheats should be enabled or not.
	 */
	public static void setAreCheatsEnabled (final boolean enabled)
	{
		areCheatsEnabled = enabled;
	}

}
