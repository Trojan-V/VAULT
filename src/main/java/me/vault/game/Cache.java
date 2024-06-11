package me.vault.game;

/**
 * Description
 *
 * @author Vincent Wolf
 * @version 1.0.0
 * @see
 * @since 05.06.2024
 */
public class Cache
{
	// TODO: Mosemann fragen, ob eine Cache-Klasse sinnvoll ist.
	private static boolean areCheatsEnabled = false; // öaöaöaö


	public static boolean getAreCheatsEnabled ()
	{
		return areCheatsEnabled;
	}


	public static void setAreCheatsEnabled (final boolean enabled)
	{
		areCheatsEnabled = enabled;
	}

}
