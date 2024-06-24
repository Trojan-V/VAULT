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


	private final File configDirectoryPath;


	private FileWriter configWriter;


	private ConfigLoader ()
	{
		this.gson = new GsonBuilder().setPrettyPrinting().create();
		this.configDirectoryPath = new File("src/main/resources/me/vault/game/config/");
		this.configDirectoryPath.mkdirs();
		this.configFile = new File(String.valueOf(this.configDirectoryPath), "config.json");

		try
		{
			if (!this.configFile.exists())
			{
				LOGGER.log(NORMAL, "Creating default configuration file.");
				this.createConfigFile();
			}

			this.configWriter = new FileWriter(this.configFile, true);

			if (this.isFileEmpty(this.configFile))
			{
				// Saves the default values that are defined within the Config POJO into the file.
				this.save();
			}
			else
			{
				// Loads the values stored in the config file into a POJO of the Config class.
				this.load();
			}

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


	private void createConfigFile () throws IOException
	{
		this.configFile.createNewFile();
	}


	@Override
	public void save ()
	{
		// Write to file
		try (final FileWriter writer = new FileWriter(this.configFile))
		{
			this.gson.toJson(Config.getInstance(), writer);
		}
		catch (final IOException e)
		{
			e.printStackTrace();
		}
	}


	@Override
	public void load ()
	{
		try
		{
			final Config configObject = this.gson.fromJson(new JsonReader(new FileReader(this.configFile)),
				Config.class);
			Config.setInstance(configObject);
		}
		catch (final FileNotFoundException e)
		{
			System.out.println(e.getMessage());
			// TODO: add logging
		}
	}
}
