package me.vault.game.utility.loading;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import me.vault.game.model.artifact.Artifact;
import me.vault.game.utility.Config;
import me.vault.game.utility.interfaces.Loader;
import me.vault.game.utility.interfaces.constant.GameConstants;
import me.vault.game.utility.logging.ILogger;
import me.vault.game.utility.logging.Logger;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Objects;

import static me.vault.game.utility.interfaces.constant.LoggingConstants.Config.DEFAULT_FILE_CREATED;
import static me.vault.game.utility.interfaces.constant.MiscConstants.*;
import static me.vault.game.utility.logging.ILogger.Level.NORMAL;
import static me.vault.game.utility.logging.ILogger.Level.WARNING;


/**
 * This class serves as loader for configuration files and loads the configuration files into the {@link Config} class of the program.
 * <br>
 * It also allows writing the data stored in the program's memory in the {@link Config} file into the configuration file.
 *
 * @author Vincent Wolf, Lasse-Leander Hillen, Timothy Hoegen-Jupp, Alexander Goethel
 * @version 1.0.0
 * @see Config
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
	 * The {@link MessageFormat} pattern, which is used, when the {@link Artifact#toString()} is
	 * called.
	 */
	private static final String TO_STRING_PATTERN = "ConfigLoader'{'gson={0}, configFile={1}, defaultFile={2}'}'";


	/**
	 * The {@link Gson} instance that's used to load or save data from/to the {@link ConfigLoader#configFile}.
	 */
	private final Gson gson;


	/**
	 * The configuration file where the data is written to or read from.
	 * <br>
	 * The configuration file is in JSON format, so {@link Gson} can be used to easily convert between JSON and POJO.
	 */
	private final File configFile;


	/**
	 * The default configuration file which will be used if no other one was specified.
	 */
	private final File defaultFile;


	/**
	 * Constructs an instance of this class.
	 * <br>
	 * During instance creation, the default configuration file will be created if it doesn't exist yet.
	 * If no normal config file exists, the default configuration will be written to the normal configuration file as well.
	 *
	 * @precondition Constructor gets called from within the class.
	 * @postcondition A new instance of this class was created.
	 */
	private ConfigLoader ()
	{
		this.gson = new GsonBuilder().setPrettyPrinting().create();

		final File configDirectoryPath = new File(GameConstants.GAME_SAVE_DIRECTORY_PATH);
		configDirectoryPath.mkdirs();

		this.configFile = new File(String.valueOf(configDirectoryPath), GameConstants.CONFIG_FILE);
		this.defaultFile = new File(String.valueOf(configDirectoryPath), GameConstants.DEFAULT_CONFIG_FILE);

		try
		{
			if (!this.configFile.exists())
			{
				this.configFile.createNewFile();
			}

			if (!this.defaultFile.exists())
			{
				LOGGER.log(NORMAL, DEFAULT_FILE_CREATED);
				this.defaultFile.createNewFile();
			}

			this.writeToDefaultConfigFile();
		}
		catch (final IOException e)
		{
			LOGGER.log(WARNING, e.getMessage());
		}
	}


	/**
	 * Returns the singleton instance of this class.
	 *
	 * @return The singleton instance of this class.
	 *
	 * @precondition The singleton Instance exists.
	 * @postcondition The singleton Instance of this class has been returned.
	 */
	public static ConfigLoader getInstance ()
	{
		return INSTANCE;
	}


	/**
	 * Checks if the supplied {@link File} is empty and returns true or false based on that.
	 *
	 * @param file The {@link File} that'll be checked.
	 *
	 * @return True if the {@link File} is empty, otherwise false.
	 *
	 * @precondition A valid instance of {@link File} has to be supplied as parameter.
	 * @postcondition It was returned if the file is or isn't empty.
	 */
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


	/**
	 * Saves the data from the {@link Config} to the {@link ConfigLoader#configFile}.
	 *
	 * @precondition None.
	 * @postcondition The configuration from the program's memory (in {@link Config}) was saved to the normal configuration file.
	 */
	@Override
	public void save ()
	{
		this.save(this.configFile);
	}


	/**
	 * Saves the data from the {@link Config} to the {@link ConfigLoader#configFile}.
	 *
	 * @param configFile The configuration file that'll be written to.
	 *
	 * @precondition A valid instance of {@link File} has to be supplied as parameter.
	 * @postcondition The configuration from the program's memory (in {@link Config}) was saved to the supplied configuration file.
	 */
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
			LOGGER.log(WARNING, e.getMessage());
		}
	}


	/**
	 * Writes data to the default configuration file.
	 *
	 * @precondition None.
	 * @postcondition The default values were written to the default configuration file.
	 */
	private void writeToDefaultConfigFile ()
	{
		try (final FileWriter writer = new FileWriter(this.defaultFile))
		{
			this.gson.toJson(Config.getInstance(), writer);
		}
		catch (final IOException e)
		{
			LOGGER.log(WARNING, e.getMessage());
		}
	}


	/**
	 * Saves the configuration data to the specified path and specified file.
	 *
	 * @param directoryPath The path to the save file directory.
	 * @param fileName      The name of the configuration file that'll be created.
	 *
	 * @precondition A valid directory path and filename has to be supplied as a parameter.
	 * @postcondition The configuration data was saved to a file with the specified filename in the specified directory.
	 */
	private void saveToFile (final String directoryPath, final String fileName)
	{
		final File directory = ResourceLoader.getDirectory(directoryPath);
		final File save = new File(directory, fileName);
		this.save(save);
	}


	/**
	 * Loads the data from the specified configuration file.
	 *
	 * @param configFile The configuration file the data is loaded from.
	 *
	 * @precondition A valid instance of {@link File} has to be supplied as parameter.
	 * @postcondition The configuration data was loaded from the specified file.
	 */
	@Override
	public void load (final File configFile)
	{
		try
		{
			final Config configObject = this.gson.fromJson(new JsonReader(new FileReader(configFile)), Config.class);
			Config.setInstance(configObject);
			Config.getInstance().updateModelsFromConfig();
		}
		catch (final FileNotFoundException e)
		{
			LOGGER.log(WARNING, e.getMessage());
		}
	}


	/**
	 * Checks if the current configuration is equal to the default configuration.
	 *
	 * @return True if the current configuration is equal to the default configuration.
	 *
	 * @precondition None.
	 * @postcondition It was returned if the current configuration is equal to the default configuration.
	 */
	public boolean isConfigDefault ()
	{
		try
		{
			final Path defaultConfigPath =
				Objects.requireNonNull(ResourceLoader.getFile(GameConstants.GAME_SAVE_DIRECTORY_PATH, GameConstants.DEFAULT_CONFIG_FILE)).toPath();
			final Path configPath = Objects.requireNonNull(ResourceLoader.getFile(GameConstants.GAME_SAVE_DIRECTORY_PATH, GameConstants.CONFIG_FILE)).toPath();
			if (Files.mismatch(defaultConfigPath, configPath) == FILE_MISMATCH_INDICATOR)
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


	/**
	 * Saves the game in its current state to the {@link ConfigLoader#configFile}.
	 *
	 * @precondition None.
	 * @postcondition The game in its current state was saved to the {@link ConfigLoader#configFile}.
	 */
	public void saveExistingGameToFile ()
	{
		this.save(this.configFile);
		final String fileName =
			SAVE_NAME + new SimpleDateFormat(DATE_TIME_PATTERN, Locale.GERMANY).format(Calendar.getInstance().getTime()) + JSON_FILE_ENDING;
		this.saveToFile(GameConstants.GAME_SAVE_DIRECTORY_PATH, fileName);
	}


	/**
	 * Loads the data from the {@link ConfigLoader#configFile}.
	 *
	 * @precondition None.
	 * @postcondition The configuration data was loaded from the specified file.
	 */
	@Override
	public void load ()
	{
		this.load(this.configFile);
	}


	/**
	 * Resets the configuration in the {@link ConfigLoader#configFile} to the default configuration that's stored in the {@link ConfigLoader#defaultFile}.
	 *
	 * @precondition The data in the {@link ConfigLoader#defaultFile} is valid.
	 * @postcondition The configuration in the {@link ConfigLoader#configFile} was reset to the default configuration.
	 */
	public void reset ()
	{
		this.load(this.defaultFile);
		this.save(this.configFile);
	}


	/**
	 * Builds a formatted {@link String}, which represents the object, and it's current state using the
	 * {@link ConfigLoader#TO_STRING_PATTERN}.
	 *
	 * @return A {@link String} which has been formatted in the {@link ConfigLoader#TO_STRING_PATTERN}.
	 *
	 * @precondition The {@link ConfigLoader#TO_STRING_PATTERN} is {@code != null}.
	 * @postcondition The method returned a {@link String} which represents the object.
	 */
	@Override
	public String toString ()
	{
		return MessageFormat.format(TO_STRING_PATTERN, this.gson.toString(), this.configFile.toString(), this.defaultFile.toString());
	}

}
