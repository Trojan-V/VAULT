package me.vault.game.utility.loading;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import me.vault.game.interfaces.Loader;
import me.vault.game.utility.logging.Logger;

import java.io.*;

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
	private static final Logger LOGGER = new Logger(ConfigLoader.class.getSimpleName());


	private static final ConfigLoader INSTANCE = new ConfigLoader();


	private final Gson gson;


	private final File configFile;


	private final File defaultsFile;


	private final File configDirectoryPath;


	private ConfigLoader ()
	{
		this.gson = new GsonBuilder().setPrettyPrinting().create();
		this.configDirectoryPath = new File("src/main/resources/me/vault/game/config/");
		this.configDirectoryPath.mkdirs();
		this.configFile = new File(String.valueOf(this.configDirectoryPath), "config.json");
		this.defaultsFile = new File(String.valueOf(this.configDirectoryPath), "defaults.json");

		try
		{
			// TODO: Remove this first one, as it's not necessary anymore if a defaults.json exists.
			if (!this.configFile.exists())
			{
				LOGGER.log(NORMAL, "Creating dummy configuration file.");
				this.configFile.createNewFile();
			}

			if (!this.defaultsFile.exists())
			{
				LOGGER.log(NORMAL, "Creating default configuration file.");
				this.defaultsFile.createNewFile();
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


	private void save (final File configFile)
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


	@Override
	public void save ()
	{
		this.save(this.configFile);
	}


	public void writeDefaultFile ()
	{
		// Write to file
		try (final FileWriter writer = new FileWriter(this.defaultsFile))
		{
			this.gson.toJson(Config.getInstance(), writer);
		}
		catch (final IOException e)
		{
			e.printStackTrace();
		}
	}


	private void load (final File configFile)
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


	@Override
	public void load ()
	{
		this.load(this.configFile);
	}


	public void reset ()
	{
		this.load(this.defaultsFile);
		this.save(this.configFile);
	}
}
