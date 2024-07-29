package me.vault.game.utility.loading;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import me.vault.game.interfaces.Loader;
import me.vault.game.utility.constant.GameConstants;
import me.vault.game.utility.constant.MiscConstants;
import me.vault.game.utility.constant.StringConstants;
import me.vault.game.utility.logging.ILogger;
import me.vault.game.utility.logging.Logger;

import java.io.*;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import static me.vault.game.utility.logging.ILogger.Level.NORMAL;
import static me.vault.game.utility.logging.ILogger.Level.WARNING;


/**
 * Description
 *
 * @author Vincent Wolf
 * @version 1.0.0
 * @see
 * @since 24.06.2024
 */
public final class ConfigLoader implements Loader
{
	/**
	 * The {@link Logger} object for this class used for writing to the console.
	 */
	private static final ILogger LOGGER = new Logger(ConfigLoader.class.getSimpleName());


	/**
	 * Singleton instance, as there's no reason to have more than one {@link ConfigLoader}.
	 * <br>
	 * Instead of using a singleton, the entire class could've been created using solely static methods and fields.
	 */
	private static final ConfigLoader INSTANCE = new ConfigLoader();


	/**
	 * The {@link Gson} instance that's used to load or save data from/to the {@link ConfigLoader#configFile}.
	 */
	private final Gson gson;


	/**
	 * The configuration file where the data is written to or read from.
	 * <br>
	 * The configuration file is in JSON format, so {@link Gson} can be used to easily convert between JSON and POJO.
	 *
	 * @link <a href="https://en.wikipedia.org/wiki/Plain_old_Java_object">POJO</a>
	 */
	private final File configFile;


	/**
	 * The default configuration file which will be used if no other one was specified.
	 */
	private final File defaultFile;


	private ConfigLoader ()
	{
		this.gson = new GsonBuilder().setPrettyPrinting().create();

		final File configDirectoryPath = new File(GameConstants.GAME_SAVE_FOLDER_FILE_PATH);
		configDirectoryPath.mkdirs();

		this.configFile = new File(String.valueOf(configDirectoryPath), GameConstants.CONFIG_FILE);
		this.defaultFile = new File(String.valueOf(configDirectoryPath), GameConstants.DEFAULT_CONFIG_FILE);

		try
		{
			// TODO: Remove this first one, as it's not necessary anymore if a defaults.json exists.
			if (!this.configFile.exists())
			{
				LOGGER.log(NORMAL, "Creating dummy configuration file.");
				this.configFile.createNewFile();
			}

			if (!this.defaultFile.exists())
			{
				LOGGER.log(NORMAL, "Creating default configuration file.");
				this.defaultFile.createNewFile();
			}

			this.writeDefaultFile();

			// Only save to the file if no default config file is available yet, to create the default config file.
			//			if (this.isFileEmpty(this.configFile))
			//			{
			//				// Saves the default values that are defined within the Config POJO into the file.
			//				this.save(this.configFile);
			//			}

			// If there's existing data in the config file, load the config file into the Config class.
			//			else
			//			{
			//				// Loads the values stored in the config file into a POJO of the Config class.
			//				this.load(this.configFile);
			//			}
		}
		catch (final IOException e)
		{
			LOGGER.log(WARNING, e.getMessage());
		}
	}


	public static ConfigLoader getInstance ()
	{
		return INSTANCE;
	}


	private boolean isFileEmpty (final File file)
	{
		try (final FileInputStream fis = new FileInputStream(file))
		{
			if (file.exists() && fis.available() == 0)
			{
				return true;
			}
		}
		catch (final IOException e)
		{
			LOGGER.log(WARNING, e.getMessage());
		}
		return false;
	}


	@Override
	public void save ()
	{
		this.save(this.configFile);
	}


	@Override
	public void save (final File configFile)
	{
		// Pull all values from different parts of the game to have the latest version of them within the Config
		// object which is then written to the save file.
		Config.getInstance().updateConfigFromModels();

		// Write to file
		try (final FileWriter writer = new FileWriter(configFile))
		{
			this.gson.toJson(Config.getInstance(), writer);
		}
		catch (final IOException e)
		{
			e.printStackTrace();
		}
	}


	public void writeDefaultFile ()
	{
		// Write to file
		try (final FileWriter writer = new FileWriter(this.defaultFile))
		{
			this.gson.toJson(Config.getInstance(), writer);
		}
		catch (final IOException e)
		{
			e.printStackTrace();
		}
	}


	public void saveToFile (final String directoryPath, String fileName) throws Exception
	{
		File directory = ResourceLoader.getDirectory(directoryPath);
		if (!directory.isDirectory() || ResourceLoader.getFile(directoryPath, fileName) != null)
		{
			throw new Exception(); //TODO: specify exception;
		}

		File save = new File(directory, fileName);
		this.save(save);
	}


	@Override
	public void load (final File configFile)
	{
		try
		{
			final Config configObject = this.gson.fromJson(new JsonReader(new FileReader(configFile)),
				Config.class);
			Config.setInstance(configObject);
			Config.getInstance().updateModelsFromConfig();
		}
		catch (final FileNotFoundException e)
		{
			System.out.println(e.getMessage());
			// TODO: add logging
		}
	}


	public boolean isConfigDefault ()
	{
		try
		{
			if (Files.mismatch(ResourceLoader.getFile(GameConstants.GAME_SAVE_FOLDER_FILE_PATH,
					GameConstants.DEFAULT_CONFIG_FILE).toPath(),
				ResourceLoader.getFile(GameConstants.GAME_SAVE_FOLDER_FILE_PATH,
					GameConstants.CONFIG_FILE).toPath()) == MiscConstants.FILE_MISMATCH_INDICATOR)
			{
				return true;
			}
		}
		catch (IOException e)
		{
			throw new RuntimeException(e);
		}
		return false;
	}


	public void saveExistingGameToFile ()
	{
		this.save(this.configFile);
		try
		{
			this.saveToFile(GameConstants.GAME_SAVE_FOLDER_FILE_PATH,
				(StringConstants.SAVE_NAME +
				 new SimpleDateFormat(StringConstants.DATE_TIME_PATTERN).format(Calendar.getInstance().getTime()) +
				 StringConstants.JSON_FILE_ENDING));
		}
		catch (Exception e)
		{
		}
	}


	@Override
	public void load ()
	{
		this.load(this.configFile);
	}


	public void reset ()
	{
		this.load(this.defaultFile);
		this.save(this.configFile);
	}

}
