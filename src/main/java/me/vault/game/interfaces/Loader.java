package me.vault.game.interfaces;


import me.vault.game.utility.loading.ConfigLoader;

import java.io.File;


/**
 * An interface for any class that provides some kind of loading and saving capability.
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
	 *
	 * @precondition The method gets called.
	 * @precondition The loader saved the data to the default location.
	 */
	void save ();


	/**
	 * Saves the data the loader has in memory to the specified {@link File}.
	 *
	 * @param configFile The configuration file the data is loaded from.
	 *
	 * @precondition The method gets called and an existing File is passed.
	 * @precondition The loader saved the data to the specified file.
	 */
	void save (final File configFile);


	/**
	 * Loads data from the file in the default location into the memory.
	 *
	 * @precondition The method gets called.
	 * @precondition The loader loaded the data from the default location/file.
	 */
	void load ();


	/**
	 * Loads data from the specified {@link File} into the memory.
	 *
	 * @param configFile The configuration file the data is loaded from.
	 *
	 * @precondition The method gets called and an existing file is passed.
	 * @precondition The loader loaded the data from the default file.
	 */
	void load (final File configFile);

}
