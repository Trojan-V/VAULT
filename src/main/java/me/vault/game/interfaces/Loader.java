package me.vault.game.interfaces;


import me.vault.game.utility.loading.ConfigLoader;

import java.io.File;


/**
 * An interface for any class that provides some kind of loading and saving functionality.
 *
 * @author Vincent Wolf, Lasse-Leander Hillen, Timothy Hoegen-Jupp, Alexander Goethel
 * @version 1.0.0
 * @see ConfigLoader
 * @since 24.06.2024
 */
public interface Loader
{
	/**
	 * Saves the data the loader has in memory to the default location, so there's no need to specify a file.
	 */
	void save ();


	/**
	 * Saves the data the loader has in memory to the specified {@link File}.
	 *
	 * @param configFile The configuration file the data is loaded from.
	 */
	void save (final File configFile);


	/**
	 * Loads data from the file in the default location into the memory.
	 */
	void load ();


	/**
	 * Loads data from the specified {@link File} into the memory.
	 *
	 * @param configFile The configuration file the data is loaded from.
	 */
	void load (final File configFile);

}
